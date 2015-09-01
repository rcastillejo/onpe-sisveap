
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<div class="sca-header">
    <div style="display: inline-block;">
        <span class="sca-title">
            <bean:message key="header.title"/>
        </span>	
    </div>
    <br/>
    <div style="float: left; margin-right: 20px">
        <label >Supervisor de Region: </label>
        <label id="lblRegion"></label>
        <input id="txtCodigoRegion" type="hidden"/>
    </div>
    <div style="float: right; margin-right: 20px">
        <div style="display: inline-block">
            <a href="#" class="loginSupervisor" data-region="RG00001">
                Supervisor Region1
            </a>
            &nbsp;
            <a href="#" class="loginSupervisor" data-region="RG00002">
                Supervisor Region2
            </a>
            &nbsp;
            <a href="#" class="loginSupervisor" data-region="RG00003">
                Supervisor Region3
            </a>
            &nbsp;
            <a href="#" class="loginSupervisor" data-region="RG00004">
                Supervisor Region4
            </a>
        </div>
    </div>
</div>
<div class="separatorGreen" style="clear: both"></div>

<script type = "text/javascript" >
    
    $(document).ready(function () {
        $(".loginSupervisor").click(function(){            
            var codigoRegion = $(this).data('region');
            getRegionName(codigoRegion);
            return false;
        });
    });
    
    function getRegionName(codigo){   
        $("#lblRegion").empty();
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + '/DistribuirCarga.do?method=obtenerRegion&codigoRegion=' + codigo
        }).done(function (region) {
            console.log('region', region);
            $("#txtCodigoRegion").val(region.codigo);
            $("#lblRegion").append(region.nombre);
        }).fail(function (error) {
            console.log('error', error);
            fn_mdl_alert(error.responseText, function () {
                location.assign("<%=request.getContextPath()%>");
            }, "VALIDACIONES");
        });
    }
    
</script>