
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<div class="sca-header">
    <div style="display: inline-block;">
        <span class="sca-title">
            <bean:message key="header.title"/>
        </span>	
    </div><!--
    <div style="float: right; margin-right: 20px">
        <div style="float: left; width: 250px">
            <bean:message key="header.usuario"/> : ${usuario.usuario} <br>
            <a href="<%=request.getContextPath()%>/Login.do?method=cambiarClave">
                <bean:message key="header.usuario.cambiar.clave"/>
            </a>
        
        </div>
        
        <div style="float: left">
            <a href="<%=request.getContextPath()%>/Login.do?method=cerrarCesion">
                <bean:message key="header.salir"/>
            </a>
        </div>
            
    </div>-->
</div>
<div class="separatorGreen" style="clear: both"></div>