	path = "/Permiso.do";
	nameForm = "permisoForm";
	prefix = "permiso";
	prefixFiltro    = "permisoBusqueda";
    tituloInsertar  = '<bean:message key="permiso.agregar.titulo" bundle="rsPermiso"/>';
    timeout         = null;
    delay           = 1000;
    cargando        = false;
    disableParam    = "rol.mnemonico";
    tituloEditar = '<bean:message key="permiso.editar.titulo" bundle="rsPermiso"/>';
    tituloEliminar = '<bean:message key="permiso.eliminar.titulo" bundle="rsPermiso"/>';

	var oComboBox = null;
	
	function configurarDimension(){
        popupSetDimension(form, 630, 300);
    }
	
	 function resetear(id, hash){
         var bean  = $(this).attr('bean');
         var hash  = $(this).attr('hash');
         var url = "${pageContext.request.contextPath}" + path + "?method=reset&bean=" + bean + "&hash=" + hash;
	}
	 
	 function initDataTable(data){
         oTable = $(table).dataTable({
             "bFilter"       : false,
             "bLengthChange" : false,
             "bSortClasses"  : false,
             "aaData"        : data,
             "aaSorting"     : [[1,'asc']],
             "sScrollY"      : "220px",
             "aoColumns": [ 
                 {
                     "sTitle"    : '<bean:message key="permiso.buscar.col.0" bundle="rsPermiso"/>',
                     "mData"     : null,
                     "bSortable" : false
                 },
                 {   
                     "sTitle" : '<bean:message key="permiso.buscar.col.1" bundle="rsPermiso"/>',
                     "mData": "mnemonico"
                 },
                 {
                     "sTitle" : '<bean:message key="permiso.buscar.col.2" bundle="rsPermiso"/>',
                     "mData": "nombre"
                 },
                 {
                     "sTitle" :'<bean:message key="permiso.buscar.col.3" bundle="rsPermiso"/>',
                     "mData": "descripcion"
                 },
                 {
                     "sTitle" : '<bean:message key="permiso.buscar.col.4" bundle="rsPermiso"/>',
                     "mData": "tipo"
                 },
                 {
                     "sTitle" : '<bean:message key="permiso.buscar.col.5" bundle="rsPermiso"/>',
                     "mData": "aplicacion.nombre"
                 },
                 {
                     "sTitle" : '<bean:message key="permiso.buscar.col.6" bundle="rsPermiso"/>',
                     "mData": "empresa.nombre"
                 },
                 {
                     "sTitle" : '<bean:message key="permiso.buscar.col.7" bundle="rsPermiso"/>',
                     "mData": "estado"
                 },
                 {
                     "sTitle" : '<bean:message key="permiso.buscar.col.8" bundle="rsPermiso"/>',
                     "mData"  : "id",
                     "sClass" : "btn-action"
                 },
                 {
                     "sTitle" : '<bean:message key="permiso.buscar.col.9" bundle="rsPermiso"/>',
                     "mData"  : "id",
                     "sClass" : "btn-action"
                 }
             ],
             "aoColumnDefs":[
                             {
                                 "aTargets":[8],
                                 "mRender"  : function(data, type, full){
                                     return '<img src="${pageContext.request.contextPath}/resources/images/edit-icon.png"' +
                                         ' alt="<bean:message key="permiso.buscar.col.8" bundle="rsPermiso"/>"' +
                                         ' title="<bean:message key="permiso.buscar.col.8" bundle="rsPermiso"/>"' + 
                                         ' onclick="editar(' + data +')""/>';
                                 },
                                 "bSortable" : false
                             },
                             {
                                 "aTargets":[9],
                                 "mRender"  : function(data, type, full){
                                     return '<img src="${pageContext.request.contextPath}/resources/images/delete-icon.gif"' +
                                         ' alt="<bean:message key="permiso.buscar.col.9" bundle="rsPermiso"/>"' +
                                         ' title="<bean:message key="permiso.buscar.col.9" bundle="rsPermiso"/>"' + 
                                         ' onclick="eliminar(' + data +')"/>';
                                 },
                                 "bSortable" : false
                             }
                             
                         ],
                         "fnDrawCallback" : function(oSettings){
                             if(oSettings.bSorted || oSettings.bFiltered){
                                 for(var i=0, iLen= oSettings.aiDisplay.length; i<iLen; i++){
                                     $('td:eq(0)', oSettings.aoData[oSettings.aiDisplay[i]].nTr).html( i+1);
                                 }
                             }
                         }
         });
         asociarEventoActualizador();
     }
	 
  function guardar(){
        guardarBean();
        }
		 
	 
     $(function() {
         var _url = "${pageContext.request.contextPath}" + path + "?method=inicializarBusqueda";
         
         $.ajax({
             type: "POST",
             url: _url,
             success: function(response){
                 initDataTable(response);
             },
             error: function(e){
                 console.info(e);
             }
         });




         formPermiso = "#div-permisos";

         $(formPermiso).dialog({
             autoOpen: false,
             height: 500,
             width: 620,
             modal: true,
             resizable: false,
             
             buttons: {
                 '<bean:message key="sistema.aceptar" />': function() {
                     $.ajax({
                         type: "POST",
                         url : url_Permisos,
                         success: function(response) {
                             popupClose(formPermiso);
                         },
                         error: function(e) {
                             popupClose(formPermiso);
                         }
                     });
                 },
                 Cancelar: function() {
                     popupClose(formPermiso);
                 }
             },
             close: function() {
             }
         });
         
     });
     
     oComboBox = $("select[name='permisoBusqueda.aplicacion']").combobox({});
     
     
function actualizarAplicacion(empresa){
    // 
    	var _url = context + path + "?method=recargarPermiso";
		$.ajax({
			type : "POST",
			url : _url,
			dataType: "json",
			data : {
				empresa : empresa
			},
			success: function (response) {
                           // 
				oComboBox.empty();
				oComboBox.append($("<option></option>").val('-1').html('Seleccione'));
		        $.each(response, function () {
		        	oComboBox.append($("<option></option>").val(this['lId']).html(this['nombre']));
		        });
		     },   
            error: function(e) {
                errorFormulario();
            }
           
		});
	}