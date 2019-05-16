<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="ru.rostec.service.ZskpProcessLocalServiceUtil" %>
<%@ include file="/init.jsp" %>
<%
    PortletURL leaveItrUrl = renderResponse.createRenderURL();
    leaveItrUrl.setParameter("mvcPath", "/view.jsp");

%>
<%--<portlet:renderURL var="addProcessJSP">
    <portlet:param name="mvcPath" value="/process/addProcess.jsp"/>
</portlet:renderURL>--%>
<%--<liferay-ui:user-display
        markupView="lexicon"
        showUserDetails="false"
        showUserName="true"
        userId="<%= themeDisplay.getRealUserId() %>"
        userName="<%= themeDisplay.getRealUser().getFullName() %>"
/>--%>

<%--<div class="container-fluid-1280 main-content-body">
    <liferay-frontend:add-menu>
        <liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add-process") %>' url="<%=addProcessJSP%>"/>
    </liferay-frontend:add-menu>

    <liferay-ui:search-container emptyResultsMessage="no-processes-found" iteratorURL="<%=leaveItrUrl %>">
        <liferay-ui:search-container-results results="<%= ZskpProcessLocalServiceUtil.getZskpProcesses(-1, -1) %>">
        </liferay-ui:search-container-results>

        <liferay-ui:search-container-row className="ru.rostec.model.ZskpProcess" modellet="process"
                                         keyProperty="processId">
            <portlet:renderURL var="rowURL">
                <portlet:param name="backURL" value="<%=currentURL %>"/>
                <portlet:param name="processId" value="${process.processId}"/>
                <portlet:param name="mvcPath" value="/process/processInfo.jsp"/>
            </portlet:renderURL>
            <portlet:renderURL let="executeProcess">
                <portlet:param name="processId" value="${process.processId}"/>
                <portlet:param name="mvcPath" value="/process/initProcess.jsp"/>
            </portlet:renderURL>
            <liferay-ui:search-container-column-text property="name" name="process.name" href="${rowURL}"/>
            <liferay-ui:search-container-column-text property="type" name="process.type"/>
            <liferay-ui:search-container-column-text property="kind" name="process.kind"/>
            <liferay-ui:search-container-column-button href="<%= executeProcess %>" name="process.execute.name"/>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator/>
    </liferay-ui:search-container>
</div>--%>

<div id="myDataTable"></div>
<script>
    YUI().use(
        'aui-datatable',
        function (Y) {
            var columns = [
                {key: 'name', label: '<%=LanguageUtil.get(request, "process.name")%>'},
                {key: 'type', label: '<%=LanguageUtil.get(request, "process.type")%>'},
                {key: 'kind', label: '<%=LanguageUtil.get(request, "process.kind")%>'},
                {key: 'action', label: '<%=LanguageUtil.get(request, "process.operation")%>'}
            ];

            var data = [
                {type: '1236 Some Street', kind: 'San Francisco', name: 'Process One', action: 'CA'},
                {type: '3271 Another Ave', kind: 'New York', name: 'Process two', action: 'NY'},
                {type: '9996 Random Road', kind: 'Los Angeles', name: 'Process three', action: 'CA'},
                {type: '1623 Some Street', kind: 'San Francisco', name: 'Process four', action: 'CA'},
                {type: '9899 Random Road', kind: 'Los Angeles', name: 'Process five', action: 'CA'}
            ];

            new Y.DataTable.Base(
                {
                    columns: columns,
                    data: data,
                    sortable: ['name']
                }
            ).render('#myDataTable');
        }
    );
</script>
