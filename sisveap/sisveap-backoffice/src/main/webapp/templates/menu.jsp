<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<div class="cnt-menu">
    <!--<div class="sca-novatronic" >
        <img src="<%=request.getContextPath()%>/resources/images/novatronic.png" /> 
    </div>-->
    <ul id="accordion">
<!--     EMPRESA -->

        <li>
            <div>Planificación</div>
            <ul style="display: none;">
                <li>
                    <html:link page="/ConfigurarEstrategia.do?method=init" >
                        Configurar Plan
                    </html:link>
                </li>
                <li>
                    <html:link page="/ProgramarPlan.do?method=init" >
                        Programar Plan
                    </html:link>
                <li> 
            </ul>
        </li>
        
    </ul>

</div>