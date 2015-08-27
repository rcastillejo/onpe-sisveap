//**********************************************************************
// Nombre: fn_mdl_iframe
// Funcion: Abre un modal con una URL (IFRAME)
//**********************************************************************
function fn_util_AbreModal(pTitulo, pURL, pAncho, pAlto, pFuncion) {
    if ((pTitulo == null) | (pTitulo == 'undefined')) { pTitulo = ''; }
    $("body").append("<div id='dv_ModalFrame'></div>");
	
	var strHtml= '<iframe runat="server" id="ifrModal" width="'+pAncho+'px" height="'+ (pAlto - 20) +'px" frameborder="0"scrolling="auto" marginheight="0" marginwidth="0" src="'+ pURL +'"></iframe>';
		 
    $("#dv_ModalFrame").html(strHtml);
    $("#dv_ModalFrame").dialog({
        modal: true
        , title: pTitulo
        , resizable: false
	    , beforeclose: function (event, ui) {
	        $(this).remove(); pFuncion();
	    }
        /*,buttons: {
            "Cerrar": function () {
                $(this).remove();
            }
        }*/
		, width: (pAncho + 30)
    });
	
};

function fn_util_CierraModal() {
    $("#ifrModal").attr('src', '');
    $("#dv_ModalFrame").dialog("close");
    $("#dv_ModalFrame").remove();
    //$("#dv_ModalFrame").dialog("destroy");
    //$(".ui-dialog-content").dialog().dialog("close");
    //$("#dv_ModalFrame").dialog("destroy");
}



//**********************************************************************
// Nombre: fn_mdl_alert
// Funcion: Abre alerta
//**********************************************************************
function fn_mdl_alert(pHTML, pFuncion, pTitulo) {
    if ((pTitulo == null) | (pTitulo == 'undefined')) { pTitulo = 'VALIDACIONES PRINCIPALES'; }
    $("body").append("<div id='divMessageDialogB'></div>");
    $("#divMessageDialogB").html(pHTML + '<br />');
    $("#divMessageDialogB").dialog({
        modal: true
        , title: pTitulo
        , resizable: false
	    , beforeclose: function (event, ui) {
	        $(this).remove();
	        if (pFuncion != null) pFuncion();
	    },
        buttons: {
            "Aceptar": function () {
                $(this).remove();
                if (pFuncion != null) pFuncion(); 
            }
        }
    });
};


//**********************************************************************
// Nombre: fn_mdl_confirma
// Funcion: Abre confirmación
//**********************************************************************
function fn_mdl_confirma(Message, Action, UrlImagen, Action1, Title) {
    if (Title == null) { Title = 'VALIDACIONES PRINCIPALES'; }
    if (UrlImagen == null) { UrlImagen = '../../Util/images/question.gif'; }
    $("body").append("<div id='divMessageConfirm' title='" + Title + "'></div>");
    $("#divMessageConfirm").html('<br /><table><tr><td style="width:35px"><img src="' + UrlImagen + '" alt=""></td><td aling="left" class="css_lbl_texto">' + Message + '</td></tr></table>');   
    $("#divMessageConfirm").dialog({
        modal: true
        , resizable: false
	    , beforeclose: function (event, ui) {
	        $(this).remove();
	        if (Action1 != null) {
	            Action1();
	        }	       
	    }, buttons: {
	        "Aceptar": function () {
	            $(this).remove();
	            Action();	           
	        },
	        "Cancelar": function () {
	            $(this).remove();
	            if (Action1 != null) {
	                Action1();
	            }	               
	        }
	    }
    });
};


//**********************************************************************
// Nombre: fn_mdl_muestraForm
// Funcion: Abre formulario
//**********************************************************************
function fn_mdl_muestraForm(pControlDiv, pFuncion, pFuncion1, pTitulo, pWidth) {
    if (pWidth == null) { pWidth = '85%'; }
    var pHTML = $(pControlDiv).html();
    pControlDiv.innerHTML = '';
    if ((pTitulo == null) | (pTitulo == 'undefined')) { pTitulo = ''; }
    $("body").append("<div id='divDialogForm'></div>");
    $("#divDialogForm").html(pHTML);

    $("#divDialogForm").dialog({
        modal: true
        , title: pTitulo
        , resizable: false
        , width: pWidth
	    , beforeclose: function (event, ui) {
	        pControlDiv.innerHTML = pHTML;
	        $(this).remove();
	        if (pFuncion1 != null) {
	            pFuncion1();
	        }
	    },
        buttons: {
            'Guardar': function () {
                pControlDiv.innerHTML = $(this).find("table[id^=tbForm]").parent().html();
                pFuncion();
            },
            'Cancelar': function () {
                pControlDiv.innerHTML = pHTML;
                $(this).remove();
                if (pFuncion1 != null) {
                    pFuncion1();
                }
            }
        }
    });
};


//**********************************************************************
// Nombre: fn_mdl_muestraForm2
// Funcion: Abre formulario 2
//**********************************************************************
function fn_mdl_muestraForm2(pControlDiv, pFuncion, pFuncion1, pTitulo, pWidth) {
    if (pWidth == null) { pWidth = '85%'; }
    var pHTML = $(pControlDiv).html();
    pControlDiv.innerHTML = '';
    if ((pTitulo == null) | (pTitulo == 'undefined')) { pTitulo = ''; }
    $("body").append("<div id='divDialogForm'></div>");
    $("#divDialogForm").html(pHTML);

    $("#divDialogForm").dialog({
        modal: true
        , closeOnEscape: true
        , title: pTitulo
        , resizable: false
        , width: pWidth
	    , beforeclose: function (event, ui) {
	        pControlDiv.innerHTML = pHTML;
	        $(this).remove();
	        if (pFuncion1 != null) {
	            pFuncion1();
	        }
	    },
        buttons: {
            'Aceptar': function () {
                pControlDiv.innerHTML = $(this).find("table[id^=tbForm]").parent().html();
                pFuncion();
            },
            'Cancelar': function () {
                pControlDiv.innerHTML = pHTML;
                $(this).remove();
                if (pFuncion1 != null) {
                    pFuncion1();
                }
            }
        }
    });
};


//**********************************************************************
// Nombre: fn_mdl_muestraMensaje
// Funcion: Muestra mensaje en modal
//**********************************************************************
function fn_mdl_mensaje(HTML, WIDTH) {
    if (WIDTH == null) { WIDTH = 300; }
    $("body").append("<div id='divMessageDialogA' title='VALIDACIONES PRINCIPALES'></div>");
    $("#divMessageDialogA").html(HTML + '<br />');
    $("#divMessageDialogA").dialog({
        modal: true
        , resizable: false
        , width: WIDTH
	    , beforeclose: function (event, ui) {
	        $(this).remove();
	    }
    });
};


//**********************************************************************
// Nombre: fn_mdl_mensajeIco
// Funcion: Muestra mensaje con icono
//**********************************************************************
function fn_mdl_mensajeIco(Message, Image) {
    if (Image == null) { Image = 'util/images/ok.gif'; }
    $("body").append("<div id='divMessageInfoA' title='VALIDACIONES PRINCIPALES'></div>");
    $("#divMessageInfoA").html('<br /><table><tr><td style="width:35px"><img src="' + Image + '" alt=""></td><td aling="left" class="css_lbl_texto">' + Message + '</td></tr></table>');
    $("#divMessageInfoA").dialog({
        modal: true
        , resizable: false
	    , beforeclose: function (event, ui) {
	        $("#divMessageInfoA").remove();
	    }
        , buttons: {
            "Aceptar": function () {
                $("#divMessageInfoA").remove();

            }
        }
    });
};


//**********************************************************************
// Nombre: fn_mdl_mensajeClose
// Funcion: Muestra mensaje y cierra parent
//**********************************************************************
function fn_mdl_mensajeClose(Message, Image, IdControl) {
    $("body").append("<div id='divMessageInfoA' title='VALIDACIONES PRINCIPALES'></div>");
    $("#divMessageInfoA").html('<br /><table><tr><td style="width:35px"><img src="' + Image + '" alt=""></td><td aling="left" class="css_lbl_texto"><strong>' + Message + '</strong></td></tr></table>');
    $("#divMessageInfoA").dialog({
        modal: true
        , resizable: false
	    , beforeclose: function (event, ui) {
	        $("#divMessageInfoA").remove();
	        parent.closeWindow(IdControl);
	    },
        buttons: {
            "Aceptar": function () {
                $("#divMessageInfoA").remove();
                parent.closeWindow(IdControl);
            }
        }
    });
};

function esAlfaNumLogin(event) {
    // Codigos Javascript del Teclado – KeyCodes
    // tab:         9 
    // arrow left:  37 - %
    // arrow right: 39 
    // end:         35 - #
    // home:        36 - $
    // backspace:   8 
    // delete:      46 - .
    if (!window.event) {
        if ((event.which > 64 && event.which < 91) || (event.which > 96 && event.which < 123) || (event.which >= 48 && event.which <= 57) || event.which == 13) {
            return true;
        }
        if ((event.keyCode == 37 && event.which != 37) || event.keyCode == 39 || event.keyCode == 9 || (event.keyCode == 35 && event.which != 35) || (event.keyCode == 36 && event.which != 36) || event.keyCode == 8 || (event.keyCode == 46 && event.which != 46)) {
            return true;
        }
        // ñ:   241 ; Ñ:    209
        // á:   225 ; Á:    193
        // é:   233 ; É:    201
        // í:   237 ; Í:    205
        // ó:   243 ; Ó:    211
        // ú:   250 ; Ú:    218
        if (event.which == 241 || event.which == 209 || event.which == 225 || event.which == 193 || event.which == 233 || event.which == 201 || event.which == 237 || event.which == 205 || event.which == 243 || event.which == 211 || event.which == 250 || event.which == 218) {
            return true;
        }
    } else {
        if ((event.keyCode > 64 && event.keyCode < 91) || (event.keyCode > 96 && event.keyCode < 123) || (event.keyCode >= 48 && event.keyCode <= 57) || event.keyCode == 13) {
            return true;
        }
        if (event.keyCode == 241 || event.keyCode == 209 || event.keyCode == 225 || event.keyCode == 193 || event.keyCode == 233 || event.keyCode == 201 || event.keyCode == 237 || event.keyCode == 205 || event.keyCode == 243 || event.keyCode == 211 || event.keyCode == 250 || event.keyCode == 218) {
            return true;
        }
    }
    return false;
}

function esAlfaNum(event) {
    /*
     var k;
     document.all ? k = e.keyCode : k = e.which;
     return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k >= 48 && k <= 57));
     */
    var keyCode = event.keyCode || event.which;
    charIngresado = String.fromCharCode(keyCode);
    // Codigos Javascript del Teclado – KeyCodes
    // tab:         9 
    // arrow left:  37 - %
    // arrow right: 39 
    // end:         35 - #
    // home:        36 - $
    // backspace:   8 
    // delete:      46 - .
    if (!window.event) {
        if ((event.keyCode == 37 && event.which != 37) || event.keyCode == 39 || event.keyCode == 9 || (event.keyCode == 35 && event.which != 35) || (event.keyCode == 36 && event.which != 36) || event.keyCode == 8 || (event.keyCode == 46 && event.which != 46)) {
            return true;
        }
    }
    patron = /([A-Za-z0-9áéíóúñÁÉÍÓÚÑ ])/;
    return patron.test(charIngresado);
}

function esAlfaNumGionB(e) {
    var k;
    document.all ? k = e.keyCode : k = e.which;
    return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 95 || k == 8 || k == 32 || (k >= 48 && k <= 57));
}

function esAlfaNumPunto(e) {
    var k;
    document.all ? k = e.keyCode : k = e.which;
    return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || k == 95 || k == 46 || (k >= 48 && k <= 57));
}

function esAlfaNumEsp(event) {
    /*
     var k;
     document.all ? k = e.keyCode : k = e.which;
     return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k==58 || k==47 || k==40 || k==41 || k == 32 || k== 46 || k == 95 ||(k >= 48 && k <= 57));
     */
    var keyCode = event.keyCode || event.which;
    charIngresado = String.fromCharCode(keyCode);
    // Codigos Javascript del Teclado – KeyCodes
    // tab:         9 
    // arrow left:  37 - %
    // arrow right: 39 
    // end:         35 - #
    // home:        36 - $
    // backspace:   8 
    // delete:      46 - .
    if (!window.event) {
        if ((event.keyCode == 37 && event.which != 37) || event.keyCode == 39 || event.keyCode == 9 || (event.keyCode == 35 && event.which != 35) || (event.keyCode == 36 && event.which != 36) || event.keyCode == 8 || (event.keyCode == 46 && event.which != 46)) {
            return true;
        }
    }
    patron = /([A-Za-z0-9áéíóúñÁÉÍÓÚÑ:./() ])/;
    return patron.test(charIngresado);
}

function esAlfaNumCorreo(event)
{
    /*
     var k;
     document.all ? k = e.keyCode : k = e.which;
     return ((k >= 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 95 || k== 46 ||(k >= 48 && k <= 57));
     */
    var keyCode = event.keyCode || event.which;
    charIngresado = String.fromCharCode(keyCode);
    // Codigos Javascript del Teclado – KeyCodes
    // tab:         9 
    // arrow left:  37 - %
    // arrow right: 39 
    // end:         35 - #
    // home:        36 - $
    // backspace:   8 
    // delete:      46 - .
    if (!window.event) {
        if ((event.keyCode == 37 && event.which != 37) || 
                event.keyCode == 39 || event.keyCode == 9 || 
                (event.keyCode == 35 && event.which != 35) || 
                (event.keyCode == 36 && event.which != 36) || 
                event.keyCode == 8 || event.keyCode == 45 || event.keyCode == 95 ||
                (event.keyCode == 46 && event.which != 46) ||
                (event.keyCode == 45 || event.which != 45)) {
            return true;
        }
    }
    patron = /([A-Za-z0-9áéíóúñÁÉÍÓÚÑ@._-])/;
    return patron.test(charIngresado);
}

function esCaracter(event) {
    /*
     var k;
     document.all ? k = e.keyCode : k = e.which;
     return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32);
     */
    var keyCode = event.keyCode || event.which;
    charIngresado = String.fromCharCode(keyCode);
    // Codigos Javascript del Teclado – KeyCodes
    // tab:         9 
    // arrow left:  37 - %
    // arrow right: 39 
    // end:         35 - #
    // home:        36 - $
    // backspace:   8 
    // delete:      46 - .
    if (!window.event) {
        if ((event.keyCode == 37 && event.which != 37) || event.keyCode == 39 || event.keyCode == 9 || (event.keyCode == 35 && event.which != 35) || (event.keyCode == 36 && event.which != 36) || event.keyCode == 8 || (event.keyCode == 46 && event.which != 46)) {
            return true;
        }
    }
    patron = /([A-Za-záéíóúñÁÉÍÓÚÑ ])/;
    return patron.test(charIngresado);
}

function esNumero(event) {
    /*
     var k;
     document.all ? k = e.keyCode : k = e.which;
     return ((k >= 48 && k <= 57) || k == 8);
     */
    var keyCode = event.keyCode || event.which;
    charIngresado = String.fromCharCode(keyCode);
    // Codigos Javascript del Teclado – KeyCodes
    // tab:         9 
    // arrow left:  37 - %
    // arrow right: 39 
    // end:         35 - #
    // home:        36 - $
    // backspace:   8 
    // delete:      46 - .
    if (!window.event) {
        if ((event.keyCode == 37 && event.which != 37) || event.keyCode == 39 || event.keyCode == 9 || (event.keyCode == 35 && event.which != 35) || (event.keyCode == 36 && event.which != 36) || event.keyCode == 8 || (event.keyCode == 46 && event.which != 46)) {
            return true;
        }
    }
    patron = /([0-9])/;
    return patron.test(charIngresado);
}

function hasClass(ele, cls) {
    return ele.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
}

function addClass(ele, cls) {
    if (!this.hasClass(ele, cls))
        ele.className += " " + cls;
}

function removeClass(ele, cls) {
    if (hasClass(ele, cls)) {
        var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
        ele.className = ele.className.replace(reg, ' ');
    }
}

/**
 * @param formulario    : nombre del pop up
 * @param titulo        : nuevo titulo
 */
function popupTitulo(formulario, titulo) {
    $(formulario).dialog({
        title: titulo
    });
}

/**
 * @param formulario    : nombre del pop up
 */
function popupClose(formulario) {
    $(formulario).dialog("close");
}

/**
 * @param formulario    : nombre del pop up
 */
function popupOpen(formulario) {
    $(formulario).dialog("open");
}

function popupSetDimension(formulario, _width, _height) {
    $(formulario).dialog({
        width: _width
    });
    $(formulario).dialog({
        height: _height
    });
}

/**
 * @param source    : name del select que debe extraerse el text actual
 * @param target    : name del hidden a modificar
 */
function setValue(source, target) {
    var value = $('select[name="' + source + '"] option:selected').text();
    $('input[name="' + target + '"]').val(value);
}

/**
 * @param column   : index de la columna de la tabla
 * @return         : data de la celda
 */
function obtenerDataCeldaByIndexColumn(col) {
    var oSettings = oTable.fnSettings();  // you can find all sorts of goodies in the Settings
    var col_id = oSettings.aoColumns[col].mData;
    return obtenerDataCeldaTabla(col_id);
}

/**
 * @param column   : key que le da el valor a la celda de cada columna
 * @return         : data de la celda
 */
function obtenerDataCeldaTabla(column) {
    var aData = oTable.fnGetData(index);
    
    if(aData!=null){
        return aData[column];
    }else{
        return "";
    }
}

/**
 * Funcion que permite obtener el index de la fila
 * de la tabla de resultados
 */
function asociarEventoActualizador() {
    $(table + " tbody td").click(function() {
        var aPos = oTable.fnGetPosition(this);
        index = aPos[0];
    });
}

function esNumerico(numero) {
    if (/^([0-9])*$/.test(numero)) {
        return true;
    }

    return false;
}


function validarTextoNumerico(field) {
    var re = /^[0-9-'.'-',']*$/;
    if (!re.test(field.value)) {
        field.value = field.value.replace(/[^0-9-'.'-',']/g, "");
    }
}

function setearComboName(combo, response) {
    var select = $("select[name='" + combo + "']");
    select.empty();
    select.append($("<option></option>").val('-1').html('Seleccione'));
    $.each(response, function() {
        select.append($("<option></option>").val(this['lId']).html(this['nombre']));
    });
}

function setearCombo(combo, response) {
    var select = $("select[id='" + combo + "']");
    select.empty();
    select.append($("<option></option>").val('-1').html('Seleccione'));
    $.each(response, function() {
        select.append($("<option></option>").val(this['lId']).html(this['nombre']));
    });
}

function reiniciarCombo(combo) {
    var select = $("select[id='" + combo + "']");
    select.empty();
    select.append($("<option></option>").val('-1').html('Seleccione'));
}

//function contador(compo, maxlength){
//    var value = compo.value;
//    if(value !== null && value.length > 0){
//        length = value.length;
//        if(length <= maxlength){
//            compo.value = value;
//        }else{
//            compo.value = value.substring(0,maxlength);
//        }
//    }
//}

//function contador(inicio, maxlength) {
//    var value = inicio.value;
//    var tam = value.length;
//    if (tam > maxlength) {
//        inicio.value = value.substring(0, maxlength);
//    }
//}