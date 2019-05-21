<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ page import="ru.rostec.model.Process" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.rostec.service.ProcessLocalServiceUtil" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ include file="/init.jsp" %>
<%
    List<Process> processList = ProcessLocalServiceUtil.getProcesses(-1, -1);
    PortletURL leaveItrUrl = renderResponse.createRenderURL();
    leaveItrUrl.setParameter("mvcPath", "/process/processInfo.jsp");
%>

<c:if test="<%= processList != null && !processList.isEmpty() %>">
    <table>
        <thead>
        <tr>
            <th>Process id</th>
            <th>Process name</th>
            <th>Process kind</th>
            <th>Process type</th>
            <th>Process status</th>
        </tr>
        </thead>
        <tbody>
            <%for (Process process : processList) {%>
            <tr>
                <td><%=process.getId()%></td>
                <td><%=process.getName()%></td>
                <td><%=process.getKind()%></td>
                <td><%=process.getType()%></td>
                <td><%=process.getStatus()%></td>
            </tr>
            <%}%>
        </tbody>
    </table>
</c:if>

<liferay-ui:search-container emptyResultsMessage="no-leaves-found">
    <liferay-ui:search-container-results results="<%= ProcessLocalServiceUtil.getProcesses(-1, -1) %>" >
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row className="ru.rostec.model.Process" modelVar="leave" keyProperty="leaveId" >
        <portlet:renderURL var="rowURL" >
            <portlet:param name="processId" value="${process.id}" />
            <portlet:param name="mvcRenderCommandName" value="viewleave_info"/>
        </portlet:renderURL>
        <liferay-ui:search-container-column-user userId="${process.userId}" showDetails="false" name="User" />
        <liferay-ui:search-container-column-text property="name" name="Process Name" href="${rowURL}"/>
        <liferay-ui:search-container-column-text property="kind" name="Process Kind" href="${rowURL}"/>
        <liferay-ui:search-container-column-text property="type" name="Process Type"/>
        <liferay-ui:search-container-column-status property="status" name="Status" >
        </liferay-ui:search-container-column-status>

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>
