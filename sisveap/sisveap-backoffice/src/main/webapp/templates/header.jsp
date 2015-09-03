
<%@page import="com.onpe.sisveap.proxyws.Region"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<div class="sca-header" style="height: 125px">
    <div style="display: inline-block;">
        <span class="sca-title">
            <bean:message key="header.title"/>
        </span>	
    </div>
    <br/>
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
        <br/>
        <div style="text-align: right;">
            <label>Supervisor de Region: </label>
            <label id="lblRegion" style="text-align: right;"><%= session.getAttribute("region") == null ? "" : ((Region) session.getAttribute("region")).getNombre()%></label>
            <input id="txtCodigoRegion" type="hidden" value="<%= session.getAttribute("region") == null ? "" : ((Region) session.getAttribute("region")).getCodigo()%>">
        </div>
    </div>
</div>
<div class="separatorGreen" style="clear: both"></div>

<script type = "text/javascript" >

    $(document).ready(function () {
        $(".loginSupervisor").click(function () {
            var codigoRegion = $(this).data('region');
            getRegionName(codigoRegion);
            return false;
        });
    });

    function getRegionName(codigo) {
        $("#lblRegion").empty();
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "<%=request.getContextPath()%>" + '/DistribuirCarga.do?method=obtenerRegion&codigoRegion=' + codigo
        }).done(function (region) {
            console.log('region', region);
            location.assign("<%=request.getContextPath()%>");
        }).fail(function (error) {
            console.log('error', error);
            fn_mdl_alert(error.responseText, function () {
                location.assign("<%=request.getContextPath()%>");
            }, "VALIDACIONES");
        });
    }

</script>