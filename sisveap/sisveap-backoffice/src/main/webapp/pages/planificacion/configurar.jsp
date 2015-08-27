<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"  %>

<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/resources/js/ZeroClipboard.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/resources/js/TableTools.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/config.js"></script>

<script type = "text/javascript" >
    //alert('COLORRRR' + gOptions.color);
    var formatDate = 'dd/mm/yy';
    var table = '#div-resultado';
    var action = '/ConfigurarEstrategia.do';


    var combo = '#div-combo';
    var comboprocesador = '#div-procesador';
    var comboadquiriente = '#div-adquiriente';
    var comboautorizador = '#div-autorizador';
    var comboreporte = '#div-reporte';

    var tipo_procesador = '2';
    var tipo_adquiriente = '1';
    var tipo_autorizador = '3';
    var cod_autorizador = '421410';
    var codadquiriente;
    var codautorizador;
    var codprocesador;
    var codprpt;
    //var codReporte = 'rpt_general';
    var lista_descripcion = [];
    var myColumnsReq = [];
    var dialog;

    $(document).ready(function () {
        obtenerPlanRegistrado();

        $("#btnCancelar").click(function (e) {
            e.preventDefault();
            location.assign("<%=request.getContextPath()%>");
        });
        
        //CargarModal ConsultarEstrategia
        $("#btnConsultarEstrategia").click(function (e) {
            e.preventDefault();
            fn_util_AbreModal("",
                    "<%=request.getContextPath()%>" + '/pages/common/consultarEstrategia.jsp',
                    900, 500, null);
        });

        //CargarModal ConsultarEstrategia
        $("#btnGuardarConfiguracion").click(function (e) {
            e.preventDefault();

            var sError = validarConfiguracion();

            if (sError === "") {
                fn_mdl_confirma("¿Está seguro que desea guardar la configuracion del Plan?",
                        function () {
                            guardarConfiguracion();
                        },
                        null,
                        null,
                        "CONFIRMACIÓN"
                        );
            } else {
                fn_mdl_alert(sError, null, "VALIDACIONES");
            }
        });


        //$('.tooltip').tooltip();

    });

    function validarConfiguracion() {
        var sError = "";

        var elEstrategias = $("#tblDetalle div[id^='tblDetalleEstrategia']");

        if (elEstrategias.length === 0) {
            sError = sError + "   - Debe agregar al menos una estrategia. <br/>";
        } else {
            elEstrategias.map(function (index, elem) {
                var actividades = 0;
                console.log('index', index, 'elem', elem);

                var codEstrategia = $(this).find('#lblCodigo').text();

                var elActividad = $(this).find('.actividad');
                var codActividad = elActividad.find('#lblCodigoActividad').text();

                console.log('elActividad', elActividad, 'lblActividad', codActividad);

                actividades += elActividad.length;

                if (actividades === 0) {
                    sError = sError + "   - Debe agregar al menos una actividad para la estrategia " + codEstrategia + " <br/>";
                }
            });
        }
        return sError;
    }

    function serializeConfiguracionPlan() {
        var dataSerialize = {};
        var listadoVal = [];

        var elEstrategias = $("#tblDetalle div[id^='tblDetalleEstrategia']");


        elEstrategias.map(function (index, elem) {
            var estrategia = {};
            var actividades = [];

            var elEstrategia = $(this).find('#tblEstrategia');
            var elActividades = $(this).find('#tblDetalleActividad');


            estrategia = getData(elEstrategia);

            elActividades.find("tbody tr").each(function () {
                var actividad = getData($(this));
                var lstIndicadores = [];
                var indicadores = actividad.indicadoresSeleccionados.split(',');

                for (var i in indicadores) {
                    lstIndicadores.push({'codigo': indicadores[i]});
                }

                actividad['indicadoresSeleccionados'] = lstIndicadores;
                actividades.push(actividad);
            });


            var str = elActividades.serialize();
            console.log('serialize', str);

            estrategia['actividadesSeleccionadas'] = actividades;

            listadoVal.push(estrategia);
            console.log('listDetalle', listadoVal);
        });

        dataSerialize = getData($("#div-busqueda-filtros"));
        dataSerialize["estrategiasSeleccionadas"] = listadoVal;

        console.log("dataSerialize", dataSerialize);
        return dataSerialize;
    }

    function getData(jQueryEl) {
        var data = {};
        jQueryEl.find(".inputValue").each(function () {
            var k = $(this).data("name");
            var v = $(this).val() || $(this).text();
            if (v && v !== '') {
                var ks = k.split(".");
                if (ks.length === 1) {
                    data[ks[0]] = v;
                } else {
                    var d = data[ks[0]] || {};
                    d[ks[1]] = v;
                    data[ks[0]] = d;
                }
            }

        });


        return data;
    }

    function guardarConfiguracion() {
        var data = serializeConfiguracionPlan();
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + action + '?method=guardarConfiguracionPlan&configuracionPlan=' + JSON.stringify(data)
        }).done(function (msg) {
            console.log('msg', msg);
            //cargarPlan(plan);
            fn_mdl_alert(msg, function () {
                location.assign("<%=request.getContextPath()%>");
            }, "CONFIRMACION");
        }).fail(function (error) {
            console.log('error', error);
            fn_mdl_alert(error.responseText, function () {
                location.assign("<%=request.getContextPath()%>");
            }, "CONFIRMACION");
        });

        //$("#cphCuerpo_txtDetalle").val(JSON.stringify(listado));
        //console.log('detalle json', $("#cphCuerpo_txtDetalle").val());

    }

    function obtenerPlanRegistrado() {
        $("#mensajeError").empty();
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + action + '?method=obtenerPlanRegistrado'
        }).done(function (plan) {
            console.log('plan', plan);
            if (plan.estado.codigo === 'PLA0001') {//Registrado
                cargarPlan(plan);
            } else if (plan.estado.codigo === 'PLA0002') {//Configurado
                cargarPlanEstrategia(plan);
            } else {
                fn_mdl_alert('El plan ya fue configurado', function () {
                    location.assign("<%=request.getContextPath()%>");
                }, "VALIDACIONES");
            }
        }).fail(function (error) {
            console.log('error', error);
            fn_mdl_alert(error.responseText, function () {
                location.assign("<%=request.getContextPath()%>");
            }, "VALIDACIONES");
        });
    }

    function cargarPlanEstrategia(plan) {

        cargarPlan(plan);

        for (var i in plan.estrategiasSeleccionadas) {
            var estrategia = plan.estrategiasSeleccionadas[i];
            cargarEstrategia(estrategia);

            for (var j in estrategia.actividadesSeleccionadas) {
                var actividad = estrategia.actividadesSeleccionadas[j];
                cargarActividadIndicadores(actividad, actividad.indicadoresSeleccionados);
            }

        }
    }

    function cargarPlan(plan) {
        $("#codigo").val(plan.codigo);
        var dateIni = new Date(plan.fecInicio.year, plan.fecInicio.month - 1, plan.fecInicio.day);
        $("#fecInicio").val($.datepicker.formatDate(formatDate, dateIni));
        var dateFin = new Date(plan.fecFin.year, plan.fecFin.month - 1, plan.fecFin.day);
        $("#fecFin").val($.datepicker.formatDate(formatDate, dateFin));
        console.log('dateIni', dateIni, 'dateFin', dateFin);
    }

    function validarItemDuplicado(name, value) {
        var isValid = true;
        $("#tblDetalle #tblDetalleEstrategia-" + value + " tbody tr").map(function (index, elem) {
            if (isValid) {
                $('.inputValue', this).each(function () {
                    var k = $(this).data("name");
                    var v = $(this).val() || $(this).text();
                    if (isValid && k === name && v === value) {
                        isValid = false;
                    }
                });
            }
        });
        return isValid;
    }

    function validarItemActividadDuplicado(name, value, estrategia) {
        var isValid = true;
        $("#tblDetalleEstrategia-" + estrategia + " #tblDetalleActividad tbody tr").map(function (index, elem) {
            if (isValid) {
                $('.inputValue', this).each(function () {
                    var k = $(this).data("name");
                    var v = $(this).val() || $(this).text();
                    if (isValid && k === name && v === value) {
                        isValid = false;
                    }
                });
            }
        });
        return isValid;
    }

    function cargarEstrategia(json) {

        if (json.estado.codigo === "EST0002") {

            var valid = validarItemDuplicado('codigo', json.codigo);
            if (!valid) {
                fn_mdl_alert("La estrategia ya se encuetra agregada", null, "VALIDACIONES");
            } else {
                console.log('cargando estrategia...', json);

                var table = $("#tblDetalle");
                var detalle = $("#tblDetalleEstrategia").clone();

                detalle.attr('id', 'tblDetalleEstrategia-' + json.codigo);
                detalle.show();

                detalle.find("#lblCodigo").append(json.codigo);
                detalle.find("#lblNombre").append(json.nombre);

                table.append(detalle);

                /*detalle.find("#chkId").click(function () {
                 fn_checkListaItemDetalle($(this).get(0), json);
                 });*/
                detalle.find("#lnkEliminar").click(function () {
                    fn_mdl_confirma("¿Está seguro que desea eliminar la estrategia?",
                            function () {
                                detalle.remove();
                            },
                            null,
                            null,
                            "CONFIRMACIÓN"
                            );
                });
                detalle.find("#btnConsultarActividad").click(function () {
                    fn_util_AbreModal("",
                            "<%=request.getContextPath()%>" + '/pages/common/consultarActividad.jsp?codigoEstrategia=' + json.codigo,
                            900, 500, null);
                });
            }

        } else {
            fn_mdl_alert("No puede se puede agregar la estrategia ya que no está configurado", null, "VALIDACIONES");
        }

        fn_util_CierraModal();

    }

    function cargarActividad(json) {
        cargarActividadIndicadores(json, json.indicadores);
        fn_util_CierraModal();

    }

    function cargarActividadIndicadores(json, indicadores) {
        var valid = validarItemActividadDuplicado('actividad.codigo', json.actividad.codigo, json.codigoEstrategia);
        if (!valid) {
            fn_mdl_alert("La actividad ya se encuentra agregada en la estrategia " + json.codigoEstrategia, null, "VALIDACIONES");
        } else {

            console.log('cargando...', json);

            var table = $("#tblDetalleEstrategia-" + json.codigoEstrategia + " #tblDetalleActividad");

            var detalle = $("#rowDetalleActividad").find("tbody tr").clone();
            detalle.attr('id', json.actividad.codigo);
            detalle.attr('class', 'actividad');
            detalle.find("#lblCodigoActividad").append(json.actividad.codigo);
            detalle.find("#lblNombreActividad").append(json.actividad.nombre);

            //var indicadores = json.indicadores;
            for (var i in indicadores) {
                var indicador = indicadores[i];
                detalle.find("#hdnIndicadores").append(indicador.codigo);
                detalle.find("#lblIndicadores").append(indicador.nombre);

                if (indicadores.length - 1 > i) {
                    detalle.find("#hdnIndicadores").append(',');
                    detalle.find("#lblIndicadores").append('<br/>');
                }

            }

            table.find("tbody").append(detalle);

            detalle.find("#lnkEliminarActividad").click(function () {
                fn_mdl_confirma("¿Está seguro que desea eliminar la actividad?",
                        function () {
                            detalle.remove();
                        },
                        null,
                        null,
                        "CONFIRMACIÓN"
                        );
                //fn_checkListaItemActividad($(this).get(0), detalle);
            });
        }
        //objItemSeleccionado === null;
        //objItemActividadSeleccionado === null;
        //fn_util_CierraModal();

    }

</script>

<div class="div-pagina">

    <div id="div-pagina-titulo" class="div-pagina-titulo">
        Configurar Estrategia de Plan
    </div>
    <div>
        <input type="button" id="btnConsultarEstrategia" value="Consultar Estrategia" />
        <input type="button" id="btnGuardarConfiguracion" value="Guardar Configuración" />
        <input type="button" id="btnAgregarEstrategia" value="Agregar Estrategia" />
        <input type="button" id="btnCancelar" value="Cancelar" />
    </div>
    <div id="dvData">
        <html:form styleId="frmReporte" action="ConfigurarEstrategia.do?method=busqueda" method="POST">
            <input id="hdnBuscast" type="submit" style="display: none;" />
            <!-- INCIO PANEL-->
            <div id="div-busqueda" class="div-busqueda">
                <div id="div-busqueda-titulo" class="div-busqueda-titulo">
                    Datos del Plan
                </div>

                <div id="div-busqueda-filtros" class="div-busqueda-filtros">
                    <div class="div-busqueda-filtro">
                        Codigo: 
                        <input id="codigo" type="text" disabled="true" class="inputValue" data-name="codigo">
                    </div>
                    <div class="div-busqueda-filtro">
                        Fecha Inicio: 
                        <input id="fecInicio" type="text" disabled="true">
                    </div>
                    <div class="div-busqueda-filtro">
                        Fecha Fin: 
                        <input id="fecFin" type="text" disabled="true">
                    </div>

                </div>

                <div class="no-float"></div>

            </div>
            <!-- FIN PANEL-->

            <div id="div-resultado">

                <div id="rowDetalleActividad" style="display:none;">   
                    <table>    
                        <tr>
                            <td>
                                <label id="lblCodigoActividad" class="inputValue" data-name="actividad.codigo" name="actividad.codigo"></label>
                            </td>
                            <td>
                                <label id="lblNombreActividad"></label>
                            </td>
                            <td>
                                <label id="hdnIndicadores" class="inputValue" data-name="indicadoresSeleccionados" name="indicadoresSeleccionados" style="display: none"></label>
                                <label id="lblIndicadores" ></label>
                            </td>
                            <td>
                                <button id="lnkEliminarActividad" type="button" value="Eliminar">
                                    <img src="<%=request.getContextPath()%>/resources/images/delete-icon.gif" border="0" />                                        
                                </button>
                            </td>
                        </tr>
                    </table>
                </div>


                <div id="tblDetalleEstrategia" style="display: none;">

                    <div id="tblEstrategia" class="div-busqueda">
                        <div class="div-busqueda-titulo">
                            Datos de la Estrategia
                        </div>
                        <table border="0" cellpadding="3" cellspacing="0" class="css_grilla">
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>Estrategia</th>
                                </tr>	
                            </thead>                        
                            <tbody>
                                <tr>
                                    <td>
                                        <label id="lblCodigo" class="inputValue" data-name="codigo" name="codigo"></label>
                                    </td>
                                    <td>
                                        <label id="lblNombre"></label>
                                    </td>
                                    <td>
                                        <input type="button" id="btnConsultarActividad" value="Consultar Actividad">
                                    </td>
                                    <td>
                                        <button id="lnkEliminar" type="button" value="Eliminar">
                                            <img src="<%=request.getContextPath()%>/resources/images/delete-icon.gif" border="0" />                                        
                                        </button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                        <div class="no-float"></div>

                        <div id="tblDetalleActividad" class="div-busqueda">
                            <div class="div-busqueda-titulo">
                                Relacion de Actividades
                            </div>      
                            <table border="0" cellpadding="3" cellspacing="0" class="css_grilla">
                                <thead>
                                    <tr>
                                        <th>N°</th>
                                        <th>Actividad</th>
                                        <th>Indicadores</th>
                                    </tr>	
                                </thead>
                                <tbody></tbody>
                            </table>   
                            <div class="no-float"></div>               
                        </div>
                    </div>
                </div>

                <div id="tblDetalle">

                </div>
            </div>

            <div class="mensaje" >
                <span>
                    <label id="mensaje" />                
                </span>
            </div>  
            <div class="mensaje-error" >
                <span>
                    <label id="mensajeError" />
                </span>
            </div>  

        </html:form>
    </div>

</div>
