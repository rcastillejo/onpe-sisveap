<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="principal.title"/></title>
        <script src="<%=request.getContextPath()%>/resources/js/util.js"></script>
        <link href="<%=request.getContextPath()%>/resources/css/login.css" rel="stylesheet" type="text/css" />
        <html:base/>

    </head>

    <body>

        <div class="cnt-login">
            <div id="login-background">
                <div class="div-sessionExpired">
                    <p class="parrafo-expired">Su sesión ha caducado. Por favor ingrese al sistema nuevamente</p>
                    <br/>
                    <p class="parrafo"> 
                        <a href="/moduloReportes/pages/login/Login.jsp" class="button-link">
                            Volver acceder a la aplicación
                        </a>
                    </p>
                </div>
            </div>
        </div>
    </body>
</html:html>
