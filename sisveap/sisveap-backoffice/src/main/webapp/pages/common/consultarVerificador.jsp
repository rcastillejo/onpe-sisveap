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

<script type='text/javascript'>
    var action = '/DistribuirCarga.do';
    var item;

    $(document).ready(function () {
        initConsultar();
    });

    function getRequestParameter(name) {
        if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)')).exec(location.search))
            return decodeURIComponent(name[1]);
    }

    function initConsultar() {
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + action + '?method=listarVerificador&codigoRegion=' + getRequestParameter('codigoRegion')
        }).done(function (listado) {
            console.log('listado', listado);
            cargarListado(listado);
        }).fail(function (error) {
            console.log('error', error);
            //$("#mensajeError").append(error);
            fn_mdl_alert(error.responseText, parent.fn_util_CierraModal, "CONSULTAS");
        });
    }


    function cargarListado(listado) {
        for (var i in listado) {
            cargarItem(listado[i]);
        }
    }

    function cargarItem(json) {
        console.log('cargando...', json);

        var table = $("#tblDetalle");

        var detalle = $("#rowDetalle").find("tbody tr").clone();

        detalle.find("#lblCodigo").append(json.codigo);
        detalle.find("#lblDni").append(json.dni);
        detalle.find("#lblNombre").append(json.nombres);
        detalle.find("#lblApellidos").append(json.apellidos);
        detalle.find("#lblRegion").append(json.region.nombre);
        detalle.find("#lblCantOtAsig").append(json.cantOTEnProceso);
        detalle.find("#lblEstado").append(json.estado.nombre);

        table.find("tbody").append(detalle);

        detalle.find("#chkId").click(function () {
            fn_checkListadoItem($(this).get(0), json);
        });
    }

    function fn_checkListadoItem(objCheck, json) {
        $('input[id*="chkId"]').prop('checked', false);
        objCheck.checked = true;
        item = json;
    }

    function fn_seleccionar() {
        if (item && item !== null) {
            console.log("itemSeleccionado", item);
            parent.cargarVerificador(item, getRequestParameter('codigoOT'));
        } else {
            fn_mdl_alert("Debe seleccionar un supervisor", null, "VALIDACIONES");
        }
    }


</script>

<div class="div-pagina">
    <!-- INCIO PANEL-->
    <div id="div-busqueda" class="div-busqueda">
        <div id="div-busqueda-titulo" class="div-busqueda-titulo">
            Consulta de Verificadores
        </div>

        <div id="div-busqueda-filtros" class="div-busqueda-filtros">
            <div class="div-busqueda-filtro">
                <a href="javascript:fn_seleccionar();">
                    <img src="<%=request.getContextPath()%>/resources/images/iconos/ico_mdl_dominio.jpg" border="0" /><br />
                    Aceptar
                </a>
            </div>
            <div class="div-busqueda-filtro">
                <a href="javascript:parent.fn_util_CierraModal();">
                    <img src="<%=request.getContextPath()%>/resources/images/iconos/ico_btn_cancelar.jpg" border="0" /><br />
                    Cerrar
                </a>
            </div>
        </div>
        <div class="no-float"></div>
    </div>

    <div id="div-resultado">
        <div id="rowDetalle" style="display:none;">   
            <table>
                <tr>
                    <td>
                        <input id="chkId" type="checkbox" />
                    </td>
                    <td>
                        <label id="lblCodigo" class="inputValue" data-name="codigo" ></label>
                    </td>
                    <td>
                        <label id="lblDni" class="inputValue" data-name="dni" ></label>
                    </td>
                    <td>
                        <label id="lblNombre" class="inputValue" data-name="nombre" ></label>
                    </td>
                    <td>
                        <label id="lblApellidos" class="inputValue" data-name="apellidos" ></label>
                    </td>
                    <td>
                        <label id="lblRegion" class="inputValue" data-name="region" ></label>
                    </td>
                    <td>
                        <label id="lblCantOtAsig" class="inputValue" data-name="cant_ot_asig" ></label>
                    </td>
                    <td>
                        <label id="lblEstado" class="inputValue" data-name="estado" ></label>
                    </td>
                </tr>
            </table>
        </div>

        <table id="tblDetalle" border="0" cellpadding="3" cellspacing="0" class="css_grilla">
            <thead>
                <tr>
                    <th>_</th>
                    <th>C�digo</th>	
                    <th>Dni</th>	
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Region</th>
                    <th>OT Asignados</th>
                    <th>Estado</th>
                </tr>	
            </thead>
            <tbody></tbody>
        </table>

    </div>
    <!-- FIN PANEL-->            
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
</div>
