<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insert page="/templates/principal.jsp" flush="true">
	<tiles:put name="header" value="/templates/header.jsp" />
	<tiles:put name="menu" value="/templates/menu.jsp" />
	<tiles:put name="content" value="/templates/content.jsp" />
	<tiles:put name="footer" value="/templates/footer.jsp" />
</tiles:insert>
