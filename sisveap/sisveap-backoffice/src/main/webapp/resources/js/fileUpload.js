//function importarPermiso(){
//$(function () {
	console.info("");

	
    $('#fileupload').fileupload({
    	
        dataType: 'json',
        
        done: function (e, data) {
        	console.log(data);
        	$("tr:has(td)").remove();
            $.each(data.result, function (index, file) {
            	
            	console.info("NOMBRE DEL FILE:",file.fileName);
                
            }); 
        },
        fail: function (e, data) {
        	console.info(data);
        },
        change: function (e, data) {
        	
        	var nameFile=data.files[0].name;
        	console.info(nameFile);
        	var filex=data.files[0];
        	var typex=data.files[0].type;
        	console.info(filex);
        	if(typex!='text/plain'){
        		e.cancelable=true;
        	}
        	console.info(typex);
        },
        progressall: function (e, data) {
	        var progress = parseInt(data.loaded / data.total * 100, 10);
	        console.info(progress);
   		}
    }).bind('fileuploadsubmit', function (e, data) {
    	
    });       
//});
//}

