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
        listarOT();
        
        $("#btnCancelar").click(function (e) {
            location.assign("<%=request.getContextPath()%>")
        });

        $("#btnGuardar").click(function (e) {
            e.preventDefault();

            /*var sError = validar();

            if (sError === "") {*/
                fn_mdl_confirma("¿Está seguro que desea guardar la distribucion de las ordenes?",
                        function () {
                            guardar();
                        },
                        null,
                        null,
                        "CONFIRMACIÓN"
                        );
            /*} else {
                fn_mdl_alert(sError, null, "VALIDACIONES");
            }*/
        });
    });


    function listarOT() {
        $("#mensajeError").empty();
        $("#tblDetalle tbody").empty();
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + action + '?method=listarOT'
        }).done(function (listado) {
            console.log('listado', listado);
            cargarListado(listado);

        }).fail(function (error) {
            console.log('error', error);
            fn_mdl_alert(error.responseText, function () {
                location.assign("<%=request.getContextPath()%>")
            }, "VALIDACIONES");
        });
    }

    function cargarListado(listado) {

        for (var i in listado) {
            var item = listado[i];
            cargarItem(item);

        }
    }

    function cargarItem(json) {

        var tableBody = $("#tblDetalle tbody");
        var detalle = $("#rowDetalle table tr").clone();

        detalle.show();
        detalle.attr("id", json.codigo);
        detalle.find("#lblCodigo").append(json.codigo);
        detalle.find("#lblCodigoArchivo").append(json.codigoArchivo);

        var date = new Date(json.fecIngreso.year, json.fecIngreso.month - 1, json.fecIngreso.day);
        detalle.find("#lblFecIngreso").append($.datepicker.formatDate(formatDate, date));

        if (json.verificador && json.verificador.codigo) {
            detalle.find("#txtVerificador").val(json.verificador.codigo);
            detalle.find("#lblVerificador").empty();
            detalle.find("#lblVerificador").append(json.verificador.nombres + ' ' + json.verificador.apellidos);
        } else {
            detalle.find("#txtVerificador").val('');
            detalle.find("#lblVerificador").append("-");
        }

        detalle.find("#lblEstado").append(json.estado.nombre);

        tableBody.append(detalle);

        detalle.find("#btnAsignar").click(function (e) {
            e.preventDefault();
            if (json.estado.codigo === 'ORT0002' || json.estado.codigo === 'ORT0003') {
                fn_util_AbreModal("",
                        "<%=request.getContextPath()%>" + '/pages/common/consultarVerificador.jsp?codigoRegion=' 
                                + json.region.codigo + '&codigoOT=' + json.codigo,
                        900, 500, null);                
            } else {
                fn_mdl_alert("No puede se puede asignar un verificador", null, "VALIDACIONES");
            }
        });

    }
    
    function cargarVerificador(model, codigoOT) {
        console.log('cargar modelo', model, 'codigoOT', codigoOT);
        
        if(model.estado.codigo === 'VER0001'){
            var detalle = $("#tblDetalle tbody tr[id='"+codigoOT+"']");
            console.log('tr', detalle);

            detalle.find("#txtVerificador").val(model.codigo);
            detalle.find("#lblVerificador").empty();
            detalle.find("#lblVerificador").append(model.nombres + ' ' + model.apellidos);

            fn_util_CierraModal();
            
        }else{
            fn_mdl_alert("El verificador no se encuentra disponible", null, "VALIDACIONES");
        }
        
    }

    function getRequestParameter(name) {
        if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)')).exec(location.search))
            return decodeURIComponent(name[1]);
    }
    
    function serialize() {
        //var dataSerialize = {};

        var listado = [];
 

        var elDetalle = $('#tblDetalle');

        elDetalle.find("tbody tr").each(function () {
            var item = getData($(this));
            console.log('item', item);
            if(item.verificador && item.verificador.codigo){
                listado.push(item);
            }
        });

        console.log('listado', listado); 

        //dataSerialize = getData($("#div-busqueda-filtros"));
        //dataSerialize["ordenes"] = listado;

        console.log("dataSerialize", listado);
        return listado;
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
            url: "<%=request.getContextPath()%>" + action + '?method=asignarVerificadorOT&ordenesTrabajo=' + JSON.stringify(data)
        }).done(function (msg) {
            console.log('msg', msg);
            //cargarPlan(plan);
            fn_mdl_alert(msg, function () {
                listarOT()
            }, "CONFIRMACION");
        }).fail(function (error) {
            console.log('error', error);
            fn_mdl_alert(error.responseText, function () {
                //
            }, "CONFIRMACION");
        });

        //$("#cphCuerpo_txtDetalle").val(JSON.stringify(listado));
        //console.log('detalle json', $("#cphCuerpo_txtDetalle").val());

    }

</script>

<div class="div-pagina">

    <div id="div-pagina-titulo" class="div-pagina-titulo">
        Listado de Ordenes de Trabajo
    </div>
    <div>
        <input type="button" id="btnGuardar" value="Guardar Asignación" />
        <input type="button" id="btnCancelar" value="Cancelar" />
    </div>
    <div id="dvData">
        <html:form styleId="frm" action="DistribuirCarga.do?method=busqueda" method="POST">
            <input id="hdnBuscast" type="submit" style="display: none;" />
            <!-- INCIO PANEL
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

            </div>-->
            <!-- FIN PANEL-->

            <div id="div-resultado">                

                <div id="rowDetalle" style="display:none;">   
                    <table>                        
                        <tr>
                            <td>
                                <label id="lblCodigo" class="inputValue" 
                                       data-name="codigo" name="codigo"></label>
                                <label id="lblCodigoArchivo" class="inputValue" style="display: none"
                                       data-name="codigoArchivo" name="codigoArchivo"></label>
                            </td>
                            <td>
                                <label id="lblFecIngreso"></label>
                            </td>
                            <td>
                                <input id="txtVerificador" type="hidden" class="inputValue"
                                       data-name="verificador.codigo" name="verificador.codigo">
                                <label id="lblVerificador"></label>
                            </td>
                            <td>
                                <label id="lblEstado"></label>
                            </td>
                            <td>
                                <input type="button" id="btnAsignar" value="Asignar Verificador">
                            </td>
                        </tr>

                    </table>
                </div>

                <table id="tblDetalle" border="0" cellpadding="3" cellspacing="0" class="css_grilla">
                    <thead>
                        <tr>
                            <th>Código</th>	
                            <th>Fecha Ingreso</th>
                            <th>Verificador</th>
                            <th>Estado</th>
                            <th>-</th>
                        </tr>	
                    </thead>
                    <tbody></tbody>
                </table>

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
