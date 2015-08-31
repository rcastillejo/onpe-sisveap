<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"  %>

<script src="<%=request.getContextPath()%>/resources/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.9.2.css" />
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.9.2.js"></script>

<!--<link href="<%=request.getContextPath()%>/resources/css/skinSCA.css" rel="stylesheet" type="text/css" />-->
<link href="<%=request.getContextPath()%>/resources/css/jquery-combobox.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/sca-template.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/jquery-override.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/jquery.dataTables.css" rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath()%>/resources/js/jquery.iframe-transport.js"></script>

<script src="<%=request.getContextPath()%>/resources/js/jquery.fileupload.js"></script>       
<script src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/util.js"></script>

<script type = "text/javascript" >
    //alert('COLORRRR' + gOptions.color);
    var formatDate = 'dd/mm/yy';
    var table = '#div-resultado';
    var action = '/DistribuirCarga.do';


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
        obtenerArchivoOT();

        $("#btnCancelar").click(function (e) {
            parent.fn_util_CierraModal();
        });

        $("#btnGuardar").click(function (e) {
            e.preventDefault();

            var sError = validar();

            if (sError === "") {
                fn_mdl_confirma("¿Está seguro que desea guardar la distribucion del Archivo OT?",
                        function () {
                            guardar();
                        },
                        null,
                        null,
                        "CONFIRMACIÓN"
                        );
            } else {
                fn_mdl_alert(sError, null, "VALIDACIONES");
            }
        });



    });

    function getRequestParameter(name) {
        if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)')).exec(location.search))
            return decodeURIComponent(name[1]);
    }

    function obtenerArchivoOT() {
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + action + '?method=obtenerArchivoOT&codigoArchivoOT=' + getRequestParameter('codigoArchivoOT')
        }).done(function (json) {
            console.log('json', json);
            cargarModel(json);
        }).fail(function (error) {
            console.log('error', error);
            //$("#mensajeError").append(error);
            fn_mdl_alert(error.responseText, parent.fn_util_CierraModal, "CONSULTAS");
        });
    }


    function validar() {
        var sError = "";

        var elRegiones = $("#tblDetalle div[id^='tblDetalleRegion']");

        elRegiones.map(function (index, elem) {
            console.log('index', index, 'elem', elem);

            var codSupervisor = $(this).find('#lblCodigoSupervisor').text();

            var region = $(this).find('#lblRegion').text();

            console.log('codSupervisor', codSupervisor, 'region', region);

            if (codSupervisor === '') {
                sError = sError + "   - Debe asignar un supèrvisor para la region " + region + " <br/>";
            }
        });
        return sError;
    }

    function serialize() {
        var dataSerialize = {};

        var elRegiones = $("#tblDetalle div[id^='tblDetalleRegion']");
        
        var ordenes = [];

        elRegiones.map(function (index, elem) {

            var elOrdenes = $(this).find('#tblDetalleOT');
            
            elOrdenes.find("tbody tr").each(function () {
                var orden = getData($(this));
                console.log('orden', orden);
                ordenes.push(orden);
            });

            console.log('ordenes', ordenes);
        });

        dataSerialize = getData($("#div-busqueda-filtros"));
        dataSerialize["ordenes"] = ordenes;

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

    function guardar() {
        var data = serialize();
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + action + '?method=asignarSupervisorArchivoOT&archivoOT=' + JSON.stringify(data)
        }).done(function (msg) {
            console.log('msg', msg);
            //cargarPlan(plan);
            fn_mdl_alert(msg, function () {//@TODO:Revisar
                parent.fn_util_CierraModal();
            }, "CONFIRMACION");
        }).fail(function (error) {
            console.log('error', error);
            fn_mdl_alert(error.responseText, function () {
                parent.fn_util_CierraModal();
            }, "CONFIRMACION");
        });

        //$("#cphCuerpo_txtDetalle").val(JSON.stringify(listado));
        //console.log('detalle json', $("#cphCuerpo_txtDetalle").val());

    }

    function cargarModel(model) {

        cargarArchivoOT(model);

        for (var i in model.ordenes) {
            var ordenTrabajo = model.ordenes[i];

            cargarOT(ordenTrabajo);

        }
    }

    function cargarArchivoOT(model) {
        console.log('cargarArchivoOT', model);
        $("#codigo").val(model.codigo);
        $("#nombre").val(model.nombre);
        $("#cantRegistro").val(model.cantRegistro);
    }

    function getRegion(model) {
        console.log('getRegion', model);
        var table = $("#tblDetalle");
        var region = $("#tblDetalle #tblDetalleRegion-" + model.region.codigo);
        if (region.length === 0) {
            region = $("#tblDetalleRegion").clone();
            region.attr('id', 'tblDetalleRegion-' + model.region.codigo);
            region.find("#lblRegion").append(model.region.nombre);
            
            if(model.supervisor){
                region.find("#lblCodigoSupervisor").append(model.supervisor.codigo);
                region.find("#lblDniSupervisor").append(model.supervisor.dni);
                region.find("#lblNombreSupervisor").append(model.supervisor.nombres);
            }

            region.find("#btnConsultarSupervisor").click(function (e) {
                e.preventDefault();
                fn_util_AbreModal2("",
                        "<%=request.getContextPath()%>" + '/pages/common/consultarSupervisor.jsp?codigoRegion=' + model.region.codigo,
                        900, 500, null);
            });

            table.append(region);
        }
        return region;
    }


    function cargarOT(ot) {
        console.log('cargar OT', ot);
        var region = getRegion(ot);
        region.show();


        var table = region.find("#tblDetalleOT");

        var detalle = $("#rowDetalleOT").find("tbody tr").clone();

        //detalle.attr('id', json.actividad.codigo);
        //detalle.attr('class', 'actividad');
        detalle.find("#lblCodigoOT").append(ot.codigo);
        var dateFin = new Date(ot.fecIngreso.year, ot.fecIngreso.month - 1, ot.fecIngreso.day);
        detalle.find("#lblFecIngresoOT").append($.datepicker.formatDate(formatDate, dateFin));
        
        if(ot.supervisor){
            detalle.find("#txtCodigoSupervisor").append(ot.supervisor.codigo);
        }

        table.find("tbody").append(detalle);
    }

    function cargarSupervisor(model) {
        var region = $("#tblDetalle #tblDetalleRegion-" + model.region.codigo);
        
        region.find("#txtCodigoSupervisor").empty();
        region.find("#lblCodigoSupervisor").empty();
        region.find("#lblDniSupervisor").empty();
        region.find("#lblNombreSupervisor").empty();
        
        region.find("#txtCodigoSupervisor").append(model.codigo);
        region.find("#lblCodigoSupervisor").append(model.codigo);
        region.find("#lblDniSupervisor").append(model.dni);
        region.find("#lblNombreSupervisor").append(model.nombres);
        
        fn_util_CierraModal2();
    }

</script>

<div class="div-pagina">

    <div id="div-pagina-titulo" class="div-pagina-titulo">
        Distribuir Carga Archivo OT
    </div>
    <div>
        <input type="button" id="btnGuardar" value="Guardar Distribucion" />
        <input type="button" id="btnCancelar" value="Cancelar" />
    </div>
    <div id="dvData">
        <html:form styleId="frmReporte" action="DistribuirCarga.do?method=busqueda" method="POST">
            <input id="hdnBuscast" type="submit" style="display: none;" />
            <!-- INCIO PANEL-->
            <div id="div-busqueda" class="div-busqueda">
                <div id="div-busqueda-titulo" class="div-busqueda-titulo">
                    Datos del Archivo OT
                </div>

                <div id="div-busqueda-filtros" class="div-busqueda-filtros">
                    <div class="div-busqueda-filtro">
                        Codigo del Archivo: 
                        <input id="codigo" type="text" disabled="true" class="inputValue" data-name="codigo">
                    </div>
                    <div class="div-busqueda-filtro">
                        Nombre del Archivo: 
                        <input id="nombre" type="text" disabled="true">
                    </div>
                    <div class="div-busqueda-filtro">
                        Cantidad de Registros: 
                        <input id="cantRegistro" type="text" disabled="true">
                    </div>

                </div>

                <div class="no-float"></div>

            </div>
            <!-- FIN PANEL-->

            <div id="div-resultado">

                <div id="rowDetalleOT" style="display:none;">   
                    <table>    
                        <tr>
                            <td>
                                <label id="lblCodigoOT" class="inputValue" data-name="codigo" name="codigo"></label>
                            </td>
                            <td>
                                <label id="lblFecIngresoOT"></label>
                            </td>
                            <td>
                                <input id="txtCodigoSupervisor" class="inputValue" type="hidden" data-name="supervisor.codigo" name="supervisor.codigo">
                                <label id="lblSupervisorOT"></label>
                            </td>
                        </tr>
                    </table>
                </div>


                <div id="tblDetalleRegion" style="display: none;">

                    <div id="tblOTRegion" class="div-busqueda">
                        <div class="div-busqueda-titulo">
                            Ordenes de Trabajo de la Region: <label id="lblRegion" class="inputValue"></label>
                            <div style="float: right">
                                <input type="button" id="btnConsultarSupervisor" value="Consultar Supervisor" />
                            </div>
                        </div>
                        <table border="0" cellpadding="3" cellspacing="0" class="css_grilla">
                            <thead>
                                <tr>
                                    <th>Còdigo de Supervisor</th>
                                    <th>Dni Supervisor</th>
                                    <th>Nombre Supervisor</th>
                                </tr>	
                            </thead>                        
                            <tbody>
                                <tr>
                                    <td>
                                        <label id="lblCodigoSupervisor"></label>
                                    </td>
                                    <td>
                                        <label id="lblDniSupervisor"></label>
                                    </td>
                                    <td>
                                        <label id="lblNombreSupervisor"></label>
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                        <div class="no-float"></div>

                        <div id="tblDetalleOT" class="div-busqueda">
                            <table border="0" cellpadding="3" cellspacing="0" class="css_grilla">
                                <thead>
                                    <tr>
                                        <th>Codigo</th>
                                        <th>Fecha Ingreso</th>
                                        <th>Verificador</th>
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
