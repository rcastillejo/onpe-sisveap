<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"  %>

<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/resources/js/ZeroClipboard.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/resources/js/TableTools.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/config.js">
    var refresco;
    alert('COLORRRR' + gOptions.color);
    if (gOptions.enabled) {
        for (var i = 0; i < gOptions.count; i++) {
            console.log(gOptions.refresh);
            refresco = gOptions.refresh;
        }
    }
    alert(refresco);
    window.setTimeout(function() {
        document.location.reload(true);
    }, gOptions.refresh);</script>
<script type="text/javascript">
    //alert('COLORRRR' + gOptions.color);
    var table = '#div-resultado';
    var combo = '#div-combo';
    var comboprocesador = '#div-procesador';
    var comboadquiriente = '#div-adquiriente';
    var comboautorizador = '#div-autorizador';
    var comboreporte = '#div-reporte';
    var action = '/ConfigurarEstrategia.do';
    
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
    $(function() {      
        
        
        $("#mensajeError").empty();
        $("#campo5").datepicker({
            showOn: "button",
            dateFormat: 'yymmdd',
            buttonImage: "../resources/images/calendar.png",
            buttonImageOnly: true,
            dayNamesMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
            dayNamesShort: ["Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"],
            monthNames:
                    ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
                        "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
            monthNamesShort:
                    ["Ene", "Feb", "Mar", "Abr", "May", "Jun",
                        "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"]
        });
        $("#btnExportar").click(function(e) {
            console.log('Entro');
            window.open('data:application/vnd.ms-excel,' + $(table).html());
            console.log('Entro1');
            e.preventDefault();
            console.log('Entro2');
        });
        /*   $.ajax({
         type: "POST",
         data: "{\"CAMPO1\":\"" + value1 + "\", \"CAMPO2\":\"" + value2 + "\", \"CAMPO3\":\"" + value3 + "\", \"CAMPO4\":\"" + value4 + "\", \"CAMPO5\":\"" + value5 + "\"}",
         dataType: 'json',
         url: "<%=request.getContextPath()%>" + action + '?method=inicializarBusqueda'
         }).done(function(response) {
         console.log('response', response);
         if (response.mensajeError) {
         console.log('Error!', response.mensajeError);
         $("#mensajeError").append(response.mensajeError);
         } else if (response.resultado.oo_cur) {
         initDataTable(table, response.resultado.oo_cur);
         }
         }).fail(function() {
         console.log('error');
         errorFormulario();
         });
         */
        var armarCombo1 = {};
        armarCombo1["CAMPO1"] = tipo_adquiriente;
        armarCombo1["CAMPO2"] = cod_autorizador;
        var jsonarmarCombo1 = JSON.stringify(armarCombo1);
        $.ajax({
            type: "POST",
            //data: "{\"CAMPO1\":\"" + tipo_adquiriente + "\", \"CAMPO2\":\"" + cod_autorizador + "\"}",
            data: jsonarmarCombo1,
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + action + '?method=inicializarCombo'
        }).done(function(response) {
            console.log('response', response);
            if (response.mensajeError) {
                console.log('Error!', response.mensajeError);
                $("#mensajeError").append(response.mensajeError);
            } else if (response.resultado.oo_cur) {
                initDataCombo(comboadquiriente, response.resultado.oo_cur);
            }
        }).fail(function() {
            console.log('error');
            errorFormulario();
        });
        //
        var armarCombo2 = {};
        armarCombo2["CAMPO1"] = tipo_procesador;
        armarCombo2["CAMPO2"] = cod_autorizador;
        var jsonarmarCombo2 = JSON.stringify(armarCombo2);
        $.ajax({
            type: "POST",
            //data: "{\"CAMPO1\":\"" + tipo_procesador + "\", \"CAMPO2\":\"" + cod_autorizador + "\"}",
            data: jsonarmarCombo2,
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + action + '?method=inicializarCombo'
        }).done(function(response) {
            console.log('response', response);
            if (response.mensajeError) {
                console.log('Error!', response.mensajeError);
                $("#mensajeError").append(response.mensajeError);
            } else if (response.resultado.oo_cur) {
                initDataCombo(comboprocesador, response.resultado.oo_cur);
            }
        }).fail(function() {
            console.log('error');
            errorFormulario();
        });
        //
        //
        var armarCombo3 = {};
        armarCombo3["CAMPO1"] = tipo_autorizador;
        armarCombo3["CAMPO2"] = cod_autorizador;
        var jsonarmarCombo3 = JSON.stringify(armarCombo3);
        $.ajax({
            type: "POST",
            //data: "{\"CAMPO1\":\"" + tipo_autorizador + "\", \"CAMPO2\":\"" + cod_autorizador + "\"}",
            data: jsonarmarCombo3,
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + action + '?method=inicializarCombo'
        }).done(function(response) {
            console.log('response', response);
            if (response.mensajeError) {
                console.log('Error!', response.mensajeError);
                $("#mensajeError").append(response.mensajeError);
            } else if (response.resultado.oo_cur) {
                initDataCombo(comboautorizador, response.resultado.oo_cur);
            }
        }).fail(function() {
            console.log('error');
            errorFormulario();
        });
        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath()%>" + action + '?method=inicializarComboReporte'
        }).done(function(response) {
            console.log('response', response);
            if (response.mensajeError) {
                console.log('Error!', response.mensajeError);
                $("#mensajeError").append(response.mensajeError);
            } else if (response.resultado.oo_cur) {
                initDataComboReporte(comboreporte, response.resultado.oo_cur);
            }
        }).fail(function() {
            console.log('error');
            errorFormulario();
        });
        //
        /* $(comboautorizador).change(function() {
         codautorizador = $(comboautorizador + " option:selected").val();
         //alert(codautorizador);
         });
         $(comboprocesador).change(function() {
         codprocesador = $(comboprocesador + " option:selected").val();
         //alert(codprocesador);
         });
         $(comboadquiriente).change(function() {
         codadquiriente = $(comboadquiriente + " option:selected").val();
         //alert(codadquiriente);
         });
         $(comboreporte).change(function() {
         
         codprpt = $(comboreporte + " option:selected").val();
         //alert('Combo Reporte' + codprpt);
         });
         var tp = 'tp_operacion_diario';*/
        $("#frmReporte").submit(function(e) {
            var repoconfecha = 'tp_operacion';
            // console.log('Paso yyyy: ');
            $("#mensajeError").empty();
            var valor = $("#campo5").datepicker("getDate");
            // console.log('Paso hhhh: ' + valor);
            var campo5 = document.getElementById("campo5").value;
            //console.log('Paso lll: ' + campo5);

            if (valor == null)
            {
                repoconfecha = 'tp_operacion_diario';
                var tdate = new Date();
                var dd = tdate.getDate(); //yields day
                var MM = tdate.getMonth() + 1; //yields month
                var yyyy = tdate.getFullYear(); //yields year
                if (dd < 10) {
                    dd = '0' + dd
                }
                if (MM < 10) {
                    MM = '0' + MM
                }
                campo5 = yyyy + '' + MM + '' + dd;
                console.log('FECHITA: ' + campo5);
            }
            //console.log('Valor de la Fecha: ' + valor);
            var codigocomboReporte = $(comboreporte).val();
            // console.log('Paso mmm: ' + codigocomboReporte);

            //  for (index = 0; index < lista_descripcion.length; index++) {
            //     console.log('Paso nnnn: ' + lista_descripcion.length);
            //     console.log('Paso nnnwwwwn: ' + lista_descripcion[index]);
            //     var lista = jQuery.parseJSON(lista_descripcion[index]);
            //     console.log('Paso xxxxx :' + lista);
            //console.log('Codigod e Reporte > ' + codigocomboReporte);
            //console.log('DE COLUMAS ESCOGIDOS > ' + lista[codigocomboReporte][0].key);
            for (index = 0; index < lista_descripcion.length; index++) {
                var lista = jQuery.parseJSON(lista_descripcion[index]);
                //console.log('ssssssssss'+lista.key);
                $.each(lista, function(key, val) {
                    //items.push("<li id='" + key + "'>" + val + "</li>");
                    console.log('key: ' + key + ', value: ' + val);
                    if (codigocomboReporte == key)
                    {
                        //alert('BINGOOOO');
                        // var dd = '';

                        //console.log('Paso zzzzz: ' + lista);
                        // console.log('JSON DE ENTRADA > ' + lista[codigocomboReporte]);
                        var myObjInicial = {};
                        myObjInicial["sTitle"] = 'N°';
                        myObjInicial["mData"] = null;
                        myObjInicial["bSortable"] = false;
                        myColumnsReq = [];
                        myColumnsReq[0] = myObjInicial;
                        for (j = 0; j < lista[codigocomboReporte].length; j++) {
                            //console.log('Clave > ' + lista[codigocomboReporte][j].key);
                            //console.log('Paso wwwwww: ' + lista[codigocomboReporte][j].value);
                            //console.log('Valor > ' + lista[codigocomboReporte][j].value);
                            var myObj = {};
                            myObj["sTitle"] = lista[codigocomboReporte][j].value;
                            myObj["mData"] = lista[codigocomboReporte][j].key;
                            myObj["bSortable"] = true;
                            myColumnsReq[j + 1] = myObj;
                        }
                        var json = JSON.stringify(myColumnsReq);
                        //console.log('Creacion JSON > ' + json);
                    }
                });
            }


            //  }
            var armarJSONReq = {};
            armarJSONReq["CAMPO0"] = $(comboreporte).val();
            armarJSONReq["CAMPO1"] = repoconfecha;
            armarJSONReq["CAMPO2"] = $(comboadquiriente).val();
            armarJSONReq["CAMPO3"] = $(comboautorizador).val();
            armarJSONReq["CAMPO4"] = $(comboprocesador).val();
            armarJSONReq["CAMPO5"] = campo5;
            //repoconfecha = 'tp_operacion';
            $('#campo5').val(campo5);
            var jsonreqpost = JSON.stringify(armarJSONReq);
            console.log('CAMPOS REQUERIMIENTO > ' + jsonreqpost);
            e.preventDefault(); //Prevent Default action. 
            $(table).empty(); //Inicializar table

            $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>" + action + '?method=busqueda',
                data: jsonreqpost,
            }).done(function(response) {
                console.log('response', response);
                if (response.mensajeError) {
                    console.log('Error!', response.mensajeError);
                    $("#mensajeError").append(response.mensajeError);
                } else if (response.resultado.oo_cur) {
                    initDataTable(table, response.resultado.oo_cur);
                }
            }).fail(function() {
                errorFormulario();
            });
        });
    });
    function initDataTable(id, data) {
        var table = $('<table id="tbl-resultado"></table>');
        console.log('Armando la vista listado', id, 'datos', data);
        table.dataTable({
            "bFilter": false,
            "bDestroy": true,
            //"sDom": 'T<"clear">lfrtip',
            "bLengthChange": false,
            "bSortClasses": false,
            "aaData": data,
            "bInfo": false,
            "sPaginationType": "full_numbers",
            //"aaSorting": [[1, 'asc']],
            "aaSorting": [[1, 'desc']],
            "sScrollY": "auto",
            "sScrollX": "930px",
            "sScrollXInner": "110%",
            "oLanguage": {
                "sUrl": "../resources/language/dataTables.spanish.txt"
            },
            "aoColumns": myColumnsReq,
            "fnDrawCallback": function(oSettings) {
                if (oSettings.bSorted || oSettings.bFiltered) {
                    for (var i = 0, iLen = oSettings.aiDisplay.length; i < iLen; i++) {
                        $('td:eq(0)', oSettings.aoData[oSettings.aiDisplay[i]].nTr).html(i + 1);
                    }
                }
            }
        });
        $(id).append(table);
    }
    /* function initDataTable2(id, data) {
     var table = $('<table id="tbl-resultado"></table>');
     console.log('Armando la vista listado', id, 'datos', data);
     for (var i in data) {
     var col = data[i];
     $.each(col, function(index, value) {
     //console.log('VALORESSSS:  ' + index + ' - ' + value);
     });
     }
     table.dataTable({
     "bFilter": false,
     "bDestroy": true,
     "bLengthChange": false,
     "bSortClasses": false,
     "aaData": data,
     "bInfo": false,
     "sPaginationType": "full_numbers",
     "aaSorting": [[1, 'asc']],
     "sScrollY": "auto",
     "sScrollX": "930px",
     "sScrollXInner": "110%",
     "oLanguage": {
     "sUrl": "../resources/language/dataTables.spanish.txt"
     },
     "aoColumns":
     [
     {
     "sTitle": "N°",
     "mData": null,
     "bSortable": false
     },
     {
     "sTitle": "Numero Celular",
     "mData": "numero_celular",
     "bSortable": false
     }
     ,
     {
     "sTitle": "Operacion BM",
     "mData": "operacion_bancamovil",
     "bSortable": false
     }
     ,
     {
     "sTitle": "Importe",
     "mData": "importe",
     "bSortable": false
     }
     ,
     {
     "sTitle": "Descripcion Operacion",
     "mData": "descripcion_operacion",
     "bSortable": false
     },
     {
     "sTitle": "Fecha de Operacion",
     "mData": "fecha_operacion",
     "bSortable": false
     },
     {
     "sTitle": "Codigo Resultado",
     "mData": "codigo_operacion",
     "bSortable": false
     },
     {
     "sTitle": "Resultado de Operacion",
     "mData": "resultado_operacion",
     "bSortable": false
     }
     ],
     "fnDrawCallback": function(oSettings) {
     if (oSettings.bSorted || oSettings.bFiltered) {
     for (var i = 0, iLen = oSettings.aiDisplay.length; i < iLen; i++) {
     $('td:eq(0)', oSettings.aoData[oSettings.aiDisplay[i]].nTr).html(i + 1);
     }
     }
     }
     });
     $(id).append(table);
     }*/
    function initDataCombo(id, data) {
        console.log('Armando la vista listado Combo', id, 'datos', data);
        jQuery.each(data, function(i, val) {
            $(id).append('<option value="' + val.codigo + '">' + val.descripcion + '</option>');
        });
    }
    function initDataComboReporte(id, data) {
        console.log('Armando la vista listado Combo Reporte', id, 'datos', data);
        jQuery.each(data, function(i, val) {
            lista_descripcion[i] = val.nombre_columnas;
            $(id).append('<option value="' + val.id_reporte + '">' + val.descripcion_reporte + '</option>');
        });
//        jQuery.each(data, function(i, val) {
//            //lista_descripcion[i] = val.nombre_columnas;
//            //console.log('Valores de Columnas: ' + lista_descripcion[i]);
//        });

    }
    
    function cargarPlan(){
        $("#mensajeError").empty();
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + action + '?method=obtenerPlanRegistrado'
        }).done(function(response) {
            console.log('response', response);
            /*if (response.mensajeError) {
                console.log('Error!', response.mensajeError);
                $("#mensajeError").append(response.mensajeError);
            } else if (response.resultado) {
                
            }*/
        }).fail(function() {
            console.log('error');
            errorFormulario();
        });
    }
    
    
</script>

<div class="div-pagina">

    <div id="div-pagina-titulo" class="div-pagina-titulo">
        <%--<bean:message key="empresa.titulo" bundle="rsEmpresa" />--%>
        Configurar Estrategia
    </div>
    <div>
        <input type="button" id="btnExportar" value="Exportar a Excel" />


    </div>
    <div id="dvData">
        <html:form styleId="frmReporte" action="TransaccionReporte.do?method=busqueda" method="POST">
            <%--<html:form styleId="frmReporte" action="TransaccionReporte.do?method=postBuscar">--%>
            <input id="hdnBuscast" type="submit" style="display: none;" />
            <!-- INCIO PANEL-->
            <div id="div-busqueda" class="div-busqueda">
                <div id="div-busqueda-titulo" class="div-busqueda-titulo">
                    Criterios de búsqueda
                </div>

                <div id="div-busqueda-filtros" class="div-busqueda-filtros">                        


                    <div class="div-busqueda-filtro">
                        Procesador: 
                        <select name="div-procesador" id="div-procesador" tabindex="1"></select>
                    </div>
                    <div class="div-busqueda-filtro">
                        Adquiriente: 
                        <select name="div-adquiriente" id="div-adquiriente" tabindex="1"></select>
                    </div>
                    <div class="div-busqueda-filtro">
                        Autorizador: 
                        <select name="div-autorizador" id="div-autorizador" tabindex="1"></select>
                    </div>
                    <div class="div-busqueda-filtro">
                        Nombre de Reporte: 
                        <select name="div-reporte" id="div-reporte" tabindex="1"></select>
                    </div>
                    <div class="div-busqueda-filtro">
                        Fecha Transaccion:
                        <input id="campo5" type="text" name="filtro(CAMPO5)"/>
                    </div>
                    <div class="div-busqueda-filtro">
                        <button id="btnEnviar" data-action="buscar" type="submit" class="div-busqueda-titulo">Consultar</button>

                    </div>

                </div>

                <div class="no-float"></div>

            </div>
            <!-- FIN PANEL-->

            <div id="div-resultado">

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

            <div>
                <html:link page="index.jsp" >
                    Regresar	
                </html:link>
            </div>

        </html:form>
    </div>

</div>
