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
        listarArchivoOT();
        $("#lblDate").empty();
        $("#lblDate").append($.datepicker.formatDate(formatDate, new Date()))                
        $("#btnCancelar").click(function (e) {
            location.assign("<%=request.getContextPath()%>")
        });
    });


    function listarArchivoOT() {
        $("#mensajeError").empty();
        $("#tblDetalle tbody").empty();
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + action + '?method=listarArchivoOT'
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

        detalle.find("#lblCodigoArchivo").append(json.codigo);
        detalle.find("#lblNombreArchivo").append(json.nombre);
        detalle.find("#lblCantRegistro").append(json.cantRegistro);
        
        var date = new Date(json.fecRegistro.year, json.fecRegistro.month - 1, json.fecRegistro.day);
        detalle.find("#lblFecRegistro").append($.datepicker.formatDate(formatDate, date));
        detalle.find("#lblEstado").append(json.estado.nombre);

        tableBody.append(detalle);

        detalle.find("#btnAsignar").click(function () {
            if (json.estado.codigo === 'AOT0001' || json.estado.codigo === 'AOT0003' ) {                
                fn_util_AbreModal("",
                        "<%=request.getContextPath()%>" + '/pages/distribucion/distribuirArchivoOT.jsp?codigoArchivoOT=' + json.codigo,
                        900, 500, null);
            }else{
                fn_mdl_alert("No puede se puede asignar un supervisor", null, "VALIDACIONES");
            }
        });

    }

</script>

<div class="div-pagina">

    <div id="div-pagina-titulo" class="div-pagina-titulo">
        Ordenes de Trabajo: Fuentes ONP al <label id="lblDate"/>
    </div>
    <div>
        <!--<input type="button" id="btnConsultarEstrategia" value="Consultar Estrategia" />
        <input type="button" id="btnGuardarConfiguracion" value="Guardar Configuración" />
        <input type="button" id="btnAgregarEstrategia" value="Agregar Estrategia" />-->
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
                                <label id="lblCodigoArchivo" class="inputValue" data-name="actividad.codigo" name="actividad.codigo"></label>
                            </td>
                            <td>
                                <label id="lblNombreArchivo"></label>
                            </td>
                            <td>
                                <label id="lblCantRegistro"></label>
                            </td>
                            <td>
                                <label id="lblFecRegistro"></label>
                            </td>
                            <td>
                                <label id="lblEstado"></label>
                            </td>
                            <td>
                                <input type="button" id="btnAsignar" value="Asignar Sup.">
                            </td>
                        </tr>

                    </table>
                </div>

                <table id="tblDetalle" border="0" cellpadding="3" cellspacing="0" class="css_grilla">
                    <thead>
                        <tr>
                            <th>Código</th>	
                            <th>Nombre</th>
                            <th>Cant. Registros</th>
                            <th>Fec. Carga</th>
                            <th>Estado</th>
                            <th>Acción</th>
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
