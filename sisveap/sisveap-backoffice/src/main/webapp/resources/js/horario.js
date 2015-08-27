function editarHorario() {
	var bean = obtenerDataCeldaTabla("id");
	var empresa = obtenerDataCeldaTabla('empresa');
    var nombreTipo = obtenerDataCeldaTabla('nombre');
    $('#txtEmpresa').text(empresa);
    $('#txtnNombreTipo').text(nombreTipo);
    
    $('#div-datos-agregar').hide();
    $('#div-datos-editar').show();
    
    var comboTipo =  $('#sel-tipo-horario');
//    $('select[name="horario.idTipo"]');
//    iniciarComboTipoHorario(comboTipo);
    
	url = context + path + "?method=inicializarEditar&bean=" + bean;
	$.ajax({
		type : "POST",
		url : url,
		success : editarFormHorario,
		error : errorFormulario
	});
}

function printErrorDiasHoras(errorDias, errorHoras){
	$("#checkboxerror").text(errorDias);
	$("#horaerror").text(errorHoras);
}

function guardarBeanHorario() {
	var size = $("input[type='checkbox']:checked").length;
	var cbxDia = $("input[name='porDia']:checked").val();
	if (cbxDia == "1") {
		$('[name="hdnDias"]').attr("value", size);
		
	} else {
		$('[name="hdnDias"]').attr("value", "7");
	}
	var _data = $("form[name='"+nameForm+"']").serialize()+ "&validate=true";;
        console.log(_data);
		$.ajax({
			type : "POST",
			url : url,
			data : _data,
			success : function(response) {
				popupClose(form);
				confirmarFormulario();
				if (index == -1) {
					oTable.fnAddData(response);
				} else {
					oTable.fnUpdate(response, index);
				}
			},
			error : function(data, response, e) {
				$("label[id$='.error']").html("");

				var json = $.parseJSON(data.responseText);
				$.each(json, function(i, item) {
					$("label[id='" + i + ".error']").html(item);
				});
				if (json == null) {
					errorFormulario();
				}
			}
		});
	
}

function editarFormHorario(json, textStatus) {
	configurarDimension();
	var bean = json.id;
	url = context + path + "?method=editar&bean=" + bean;
	setDialog(form, tituloEditar);
	popularFormHorario(json);
	habilitarParam(true);
	habilitarValorCheckBox();
        $('[name="horario.horaFin"]').val(json.horaFin);
	$('[name="horario.horaInicio"]').val(json.horaInicio);
	actualizarHoraInicio();
	actualizarHoraFin();
	$("label[id$='.error']").html("");
	
}

function habilitarHora() {
	var hora = $("input[name='porHora']:checked").val();
	if (hora == '0') {
		$('[name="horario.horaInicio"]').attr("value", "0");
		$('[name="horario.horaFin"]').attr("value", "23");
		$('[name="horario.horaInicio"]').attr("disabled", 'disabled');
		$('[name="horario.horaFin"]').attr("disabled", 'disabled');
		actualizarHoraInicio();
		actualizarHoraFin();
		
	} else {
		$('[name="horario.horaInicio"]').removeAttr("disabled");
		$('[name="horario.horaFin"]').removeAttr("disabled");
	}
}


function actualizarHoraInicio(){
	var valueFin = $('[name="horario.horaFin"]').val();
	var value = $('[name="horario.horaInicio"]').val();
        
	var horaIni = parseInt(value) + 1;
	$('[name="hdnHoraInicio"]').attr("value", value);
	var oComboHoraFin = $('select[name="horario.horaFin"]');
	oComboHoraFin.empty();
	oComboHoraFin.append($("<option></option>").val('-1').html('Seleccione'));
	for (i=horaIni; i<=24; i++) {
	    var hora = (i<10) ? '0'+i : i; 
	    hora = hora + ':00';
	    oComboHoraFin.append($("<option></option>").val(i).html(hora));
	}
	$('[name="horario.horaFin"]').val(valueFin);
}

function actualizarHoraFin(){
	var valueIni = $('[name="horario.horaInicio"]').val();
	var value = $('[name="horario.horaFin"]').val();
        
	var horaFin = parseInt(value);
	$('[name="hdnHoraFin"]').attr("value", value);
	var oComboHoraIni = $('select[name="horario.horaInicio"]');
	oComboHoraIni.empty();
	oComboHoraIni.append($("<option></option>").val('-1').html('Seleccione'));
        if(horaFin==-1){
            horaFin = 24;
        }
        
	for (i=0; i<=horaFin; i++) {
	    var hora = (i<10) ? '0'+i : i; 
            hora = hora + ':00';
	    oComboHoraIni.append($("<option></option>").val(i).html(hora));
	}
	$('[name="horario.horaInicio"]').val(valueIni);
}

function popularFormHorario(json) {
	var array_value_checkBox = new Array();
	array_value_checkBox[0] = "horario.lunes";
	array_value_checkBox[1] = "horario.martes";
	array_value_checkBox[2] = "horario.miercoles";
	array_value_checkBox[3] = "horario.jueves";
	array_value_checkBox[4] = "horario.viernes";
	array_value_checkBox[5] = "horario.sabado";
	array_value_checkBox[6] = "horario.domingo";

	var array_checkBox = new Array();
	array_checkBox[0] = "hLunes";
	array_checkBox[1] = "hMartes";
	array_checkBox[2] = "hMiercoles";
	array_checkBox[3] = "hJueves";
	array_checkBox[4] = "hViernes";
	array_checkBox[5] = "hSabado";
	array_checkBox[6] = "hDomingo";

	var array_value_radio = new Array();
	array_value_radio[0] = "horario.tipo";
	array_value_radio[1] = "horario.porDia";
	array_value_radio[2] = "horario.porHora";

	var array_radio = new Array();
	array_radio[0] = "porTipo";
	array_radio[1] = "porDia";
	array_radio[2] = "porHora";

	editarObjetoCheck(array_value_checkBox, array_checkBox, json);
	editarObjetoRadio(array_value_radio, array_radio, json);
	
	var tipoSeleccionado = "horario.tipo";
	var tipo = (json == null) ? '' : json[tipoSeleccionado
			.substring(tipoSeleccionado.indexOf('.') + 1)];
	
	$('[name="horario.idTipo"]').attr("value", json["horario.idTipo".substring("horario.idTipo".indexOf('.') + 1)]);
	$('[name="horario.idEmpresa"]').attr("value", json["horario.idEmpresa".substring("horario.idEmpresa".indexOf('.') + 1)]);
	$('[name="horario.id"]').attr("value", json["horario.id".substring("horario.id".indexOf('.') + 1)]);
	$('[name="horario.idDetalle"]').attr("value", json["horario.idDetalle".substring("horario.idDetalle".indexOf('.') + 1)]);
	cambiarLabelTipoEditar(tipo);
	habilitarDias();
	habilitarHora();
	// $('input[type="checkbox"]').attr("checked", false);
}

function editarObjetoCheck(array_value, array_fields, json) {
	for (var i = 0; i < array_value.length; i++) {
		var name = array_value[i];
		var field = array_fields[i];
		var value = (json == null) ? '' : json[name
				.substring(name.indexOf('.') + 1)];
		var check = (value == '1' ? true : false);
		$("[type=checkbox][name=" + field + "]").attr("checked", check);
		$("[type=checkbox][name=" + field + "]").attr("value", true);
	};
}

function habilitarValorCheckBox(){
	$("[type=checkbox][name=hLunes]").attr("value", true);
	$("[type=checkbox][name=hMartes]").attr("value", true);
	$("[type=checkbox][name=hMiercoles]").attr("value", true);
	$("[type=checkbox][name=hJueves]").attr("value", true);
	$("[type=checkbox][name=hViernes]").attr("value", true);
	$("[type=checkbox][name=hSabado]").attr("value", true);
	$("[type=checkbox][name=hDomingo]").attr("value", true);
}

function editarObjetoRadio(array_value, array_fields, json) {
	for (var i = 0; i < array_value.length; i++) {
		var name = array_value[i];
		var field = array_fields[i];
		var value = (json == null) ? '' : json[name
				.substring(name.indexOf('.') + 1)];
		$("[type=radio][name=" + field + "][value=" + value + "]").attr(
				"checked", "checked");
	}
}

function habilitarDias() {
	var dia = $("input[name='porDia']:checked").val();
	if (dia == '0') {
		$('input[type="checkbox"]').attr("disabled", true);
		$('input[type="checkbox"]').attr("checked", false);
	} else {
		$('input[type="checkbox"]').removeAttr("disabled");
	}
}



