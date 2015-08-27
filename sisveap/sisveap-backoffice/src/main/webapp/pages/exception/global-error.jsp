<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="imagetoolbar" content="no">
<meta name="robots" content="noindex,nofollow">
<link href="<%=request.getContextPath()%>/resources/css/error.css" rel="stylesheet" type="text/css" />
<title>Error</title>

</head>

<body class="login">
	<div class="error_page">
		<img alt="Kidmondo_face_sad"
			src="./resources/images/error.gif">
		<h1><bean:message key="opcion.error.mensaje.titulo"/></h1>
		<p>
		
		<bean:message key="opcion.error.mensaje.noexiste"/>
		</p>
		<p>
			<br> <a href="<%=request.getContextPath()%>/"> <bean:message key="opcion.volver"/></a>
		
		</p>
	</div>

</body>
</html>