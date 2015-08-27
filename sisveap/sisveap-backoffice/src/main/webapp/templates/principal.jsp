<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<jsp:useBean id="msgexpiracion" class="java.lang.String" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="principal.title"/></title>

        <script src="<%=request.getContextPath()%>/resources/js/jquery-1.8.3.js"></script>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.9.2.css" />
        <script src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.9.2.js"></script>

        <link href="<%=request.getContextPath()%>/resources/css/skinSCA.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/resources/css/jquery-combobox.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/resources/css/sca-template.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/resources/css/jquery-override.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/resources/css/jquery.dataTables.css" rel="stylesheet" type="text/css" />

        <script src="<%=request.getContextPath()%>/resources/js/jquery.iframe-transport.js"></script>

        <script src="<%=request.getContextPath()%>/resources/js/jquery.fileupload.js"></script>       
        <script src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/util.js"></script>

<!-- script src="<%=request.getContextPath()%>/resources/js/leftTime.js"></script -->

        <html:base />
        <script type="text/javascript">
            var timeOutApp = 0;
            var url = null;
            var context = "<%=request.getContextPath()%>";
            //CONFIG
            var path = null;
            var nameForm = null;
            var prefix = null;
            var prefixFiltro = null;

            //TITULOS
            var tituloEditar = null;
            var tituloEliminar = null;
            var tituloInsertar = null;
            //MENSAJES
            var mensajeEliminar = null;

            //BUSCAR
            var timeout = null;
            var delay = null;
            var cargando = null;
            //DIALOG
            var form = "#div-formulario";
            var formEli = "#div-eliminar";
            var formConf = "#div-confirmacion";
            var formExpir = "#caduca-clave";

            //PARAM
            var disableParam = "";
            //TABLA
            var table = "#tbl-resultado";
            var index = 0;
            var oTable = null;

            function inhabilitar() {
                return false;
            }

            document.oncontextmenu = inhabilitar;

            function eliminar(col) {
                bean = obtenerDataCeldaTabla("id");
                url = context + path + "?method=eliminar&bean=" + bean;
                var value = mensajeEliminar.replace("@", obtenerDataCeldaTabla("nombre"));
                $("#lblEliminar").text(value);
                setDialog(formEli, tituloEliminar);
            }

            function setDialog(formulario, titulo) {
                popupOpen(formulario);
                popupTitulo(formulario, titulo);
            }

            function editar(bean) {
                url = context + path + "?method=inicializarEditar&bean=" + bean;
                $.ajax({
                    type: "POST",
                    url: url,
                    success: editarFormulario,
                    error: errorFormulario
                });
            }

            function prepararData(_form, _prefix) {
                var elem = $("form[name='" + _form + "']");
                var data = "";
                alert("Paso3");

                $(elem).find("[name^='" + _prefix + "']").each(function() {
                    data += "&" + $(this).attr('name') + "=" + $(this).val();
                });
                return data;
            }

            function buscarResponse(json, textStatus) {
                try {
                    oTable.fnDestroy();
                    initDataTable(json);
                } catch (e) {
                    errorFormulario();
                }
            }

            function buscarResponsePaging(url, data) {
                try {
                    oTable.fnDestroy();
                    initDataTablePaging(url, 'Y');

                } catch (e) {
                    errorFormulario();
                }
            }

            function buscar() {
                var _url = context + path + "?method=busqueda";
                var _data = prepararData(nameForm, prefixFiltro);

                $.ajax({
                    type: "POST",
                    url: _url,
                    data: _data,
                    success: buscarResponse,
                    error: errorFormulario
                });
            }

            function confirmarFormulario() {
                popupOpen(formConf);
                popupTitulo(formConf, '<bean:message key="sistema.confirma.titulo"/>');
                $("#lblMensaje").html('<bean:message key="sistema.confirma" />');
            }



            function errorFormulario() {
                popupOpen(formConf);
                popupTitulo(formConf, '<bean:message key="sistema.confirma.titulo" />');
                $("#lblMensaje").html('<bean:message key="sistema.rechaza" />');
            }

            function errorEliminacion(mensaje) {
                popupOpen(formConf);
                popupTitulo(formConf, '<bean:message key="sistema.error.eliminacion.titulo"/>');
                $("#lblMensaje").html(mensaje);
            }



            function iniciarFormularioContent(json, textStatus) {
                popularFormulario(json);
                configurarDimension();
                url = context + path + "?method=agregar";
                setDialog(form, tituloInsertar);
                alert("Paso4");

                habilitarParam(false);
                index = -1;
                $("label[id$='.error']").html("");
                $("select[name^='" + prefix + "']").val(-1);
                $("#divEditar").prop('disabled', false);
            }

            function editarFormularioContent(json, textStatus) {
                configurarDimension();
                var bean = json.id;
                url = context + path + "?method=editar&bean=" + bean;
                setDialog(form, tituloEditar);
                popularFormulario(json);
                habilitarParam(true);
                $("label[id$='.error']").html("");

                /* Ocultamos aplicacion */
                if ($("#tipo").val() == 0) {
                    /* Ocultamos Aplicacion */
                    $("#aplicacion").css("display", "none");
                } else {
                    $("#aplicacion").css("display", "");
                }

                $("#divEditar").prop('disabled', true);

            }

            function habilitarParam(flag) {
                var tokens = disableParam.split(",");
                for (var i = 0; i < tokens.length; i++) {
                    $("[name='" + tokens[i] + "']").prop('disabled', flag);
                }
            }

            function popularFormulario(json) {
                var elem = $("form[name='" + nameForm + "']");
                $(elem).find("[name^='" + prefix + "']").each(function() {
                    var name = $(this).attr("name");
                    var value = (json == null) ? '' : json[name.substring(name.indexOf('.') + 1)];
                    $(this).val(value);
                });
            }

            function recargarBusqueda(elem) {
                if (!cargando) {
                    timeout = setTimeout(function() {
                        cargando = true;
                        buscar();
                    }, delay);
                }
            }
            /*
             function guardarBean(){
             //                var _data = prepararData(nameForm, prefix) + "&validate=true";
             //                var _data = data = $("#frmEdit").serialize();
             
             var elem = $("#frmEdit");
             var _data = "";
             $(elem).find("[name^='template']").each(function(){
             _data += "&" + $(this).attr('name') + "=" +$(this).val();
             });
             */

            function guardarBean() {
                var _data = prepararData(nameForm, prefix) + "&validate=true";
                $.ajax({
                    type: "POST",
                    url: url,
                    data: _data,
                    success: function(response) {
                        popupClose(form);
                        confirmarFormulario();
                        console.log('index', index, 'oTable', oTable, 'response', response);
                        if (index == -1) {
                            oTable.fnAddData(response);
                        } else {
                            oTable.fnUpdate(response, index);
                        }
                    },
                    error: function(data, response, e) {
                        populateError(data);
                    }
                });
            }

            function populateError(data) {
                $("label[id$='.error']").html("");

                var json = $.parseJSON(data.responseText);
                if (json['error.general'] != 'undefined' && json['error.general'] != null) {
                    errorFormulario();
                } else {
                    $.each(json, function(i, item) {
                        $("label[id='" + i + ".error']").html(item);
                    });
                }
            }


            $(function() {
                var msgExp = '<%= msgexpiracion%>';
                if (msgExp.length > 0) {
                    $("#caduca-clave").dialog({
                        height: 160,
                        width: 400,
                        modal: true,
                        resizable: false,
                        buttons: {
                            '<bean:message key="sistema.continuar" />': function() {
                                popupClose(formExpir);
                            },
                            '<bean:message key="header.usuario.cambiar.clave" />': function() {
                                var _url = context + "/Login.do?method=cambiarClave";
                                $(location).attr('href', _url);
                            }
                        },
                        close: function() {
                            popupClose(formExpir);
                        }
                    });
                }

                $('#modal').hide().
                        ajaxStart(function() {
                            $(this).addClass("loading");
                            $(this).show();
                        }).
                        ajaxStop(function() {
                            $(this).removeClass("loading");
                            $(this).hide();
                        });

                $(form).dialog({
                    autoOpen: false,
                    height: 320,
                    width: 850,
                    modal: true,
                    resizable: false,
                    buttons: {
                        '<bean:message key="sistema.aceptar"/>': function() {
                            guardar();
                        },
                        Cancelar: function() {
                            if (cancelarForm) {
                                cancelarForm();
                            }
                            popupClose(form);
                        }
                    },
                    close: function() {
                        if (cancelarForm) {
                            cancelarForm();
                        }

                    }
                });

                $(formEli).dialog({
                    autoOpen: false,
                    height: 160,
                    width: 400,
                    modal: true,
                    resizable: false,
                    buttons: {
                        '<bean:message key="sistema.si"/>': function() {
                            $.ajax({
                                type: "POST",
                                url: url,
                                success: function(response) {

                                    if (response != '') {
                                        popupClose(formEli);
                                        errorEliminacion(response);
                                    } else {
                                        popupClose(formEli);
                                        oTable.fnDeleteRow(index);
                                        oTable.fnDraw();
                                        confirmarFormulario();
                                    }
                                },
                                error: function(xhr, ajaxOptions, thrownError) {
                                    //                                 	
                                    //                                 	if (jqXHR.status === 100) {
                                    //                                         alert('NO SE PUEDE ELIMAR.');
                                    //                                     }
                                    popupClose(formEli);
                                    errorFormulario();
                                }
                            });
                        },
                        '<bean:message key="sistema.no" />': function() {
                            popupClose(formEli);
                        }
                    },
                    close: function() {
                    }
                });

                $(formConf).dialog({
                    autoOpen: false,
                    height: 160,
                    width: 400,
                    zIndex: 10000,
                    modal: true,
                    resizable: false,
                    buttons: {
                        '<bean:message key="sistema.salir" />': function() {
                            popupClose(formConf);
                        }
                    },
                    close: function() {
                    }
                });

                $("#btn-agregar").button().click(function() {
                    url = context + path + "?method=inicializarAgregar";
                    $.ajax({
                        type: "POST",
                        url: url,
                        success: iniciarFormulario,
                        error: errorFormulario
                    });
                });

                /*------------------------------ BUSQUEDA ------------------------------------*/

                $("[name*='" + prefixFiltro + "']").each(function() {
                    var elem = $(this);
                    var tipo = elem.prop('tagName');
                    if (tipo == 'INPUT') {
                        elem.keyup(function() {
                            if (timeout) {
                                clearTimeout(timeout);
                                cargando = false;
                            }
                            recargarBusqueda(elem);
                        }).keypress(function(e) {
                            if (e.which == 13) {
                                return false;
                            }
                        });
                    } else if (tipo == 'SELECT') {
                        elem.change(function() {
                            if (timeout) {
                                clearTimeout(timeout);
                            }
                            buscar();
                        });
                    }
                });
            });




        </script>
    </head>
    <body oncontextmenu="return false;" onpaste="return false;">
        <div id="modal">
        </div>
        <div class="main">
            <table cellspacing="0" cellpadding="0" width="100%">
                <tbody>
                    <tr>
                        <td colspan="2">
                            <tiles:insert attribute="header"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="15%" valign="top">
                            <tiles:insert attribute="menu"/>
                        </td>
                        <td valign="top" height="100%">
                            <tiles:insert attribute="content" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <tiles:insert attribute="footer"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>                            
        <script type="text/javascript">

            $("#accordion > li > div").click(function() {
                if (false == $(this).next().is(':visible')) {
                    $('#accordion ul').slideUp();
                    var divId = ($(this).attr('id'));
                }
                $(this).next().slideToggle();
            });

            function fncTableMouseover(elem) {
                elem.className = 'tbl-active';
            }
            function fncTableMouseout(elem) {
                elem.className = 'tbl-link';
            }

        </script>
    </body>

    <div id="caduca-clave" class="div-content-center div-confirmacion">
        <label id="lblMensajeExpi" class="lbl-msg">
            <%= msgexpiracion%>
        </label>				
    </div>

</html:html> 