<%@page import="javax.portlet.PortletURL" %>
<%@ page import="org.javasavvy.leave.core.service.service.LeaveLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="java.time.LocalDate" %>
<%@ include file="/init.jsp" %>
<%
    PortletURL leaveItrUrl = renderResponse.createRenderURL();
    leaveItrUrl.setProperty("mvcPath", "/view.jsp");

%>
<portlet:renderURL var="addLeaveJSP">
    <portlet:param name="mvcPath" value="/addLeave.jsp"/>
</portlet:renderURL>
<liferay-ui:user-display
        markupView="lexicon"
        showUserDetails="false"
        showUserName="true"
        userId="<%= themeDisplay.getRealUserId() %>"
        userName="<%= themeDisplay.getRealUser().getFullName() %>"
/>
<div class="container-fluid-1280 main-content-body">

    <liferay-ui:search-container emptyResultsMessage="no-leaves-found" iteratorURL="<%=leaveItrUrl %>">
        <liferay-ui:search-container-results results="<%= LeaveLocalServiceUtil.getLeaves(-1, -1) %>">
        </liferay-ui:search-container-results>

        <liferay-ui:search-container-row className=" org.javasavvy.leave.core.service.model.Leave" modelVar="leave"
                                         keyProperty="leaveId">
            <portlet:renderURL var="rowURL">
                <portlet:param name="leaveId" value="${leave.leaveId}"/>
                <portlet:param name="mvcRenderCommandName" value="viewleave_info"/>
            </portlet:renderURL>
            <liferay-ui:search-container-column-user userId="${leave.userId}" showDetails="false" name="User"/>
            <liferay-ui:search-container-column-text property="userName" name="User Name" href="${rowURL}"/>
            <liferay-ui:search-container-column-text property="leaveName" name="Leave Name" href="${rowURL}"/>
            <liferay-ui:search-container-column-date property="startDate" name="Start Date"/>
            <liferay-ui:search-container-column-date property="endDate" name="End Date"/>
            <liferay-ui:search-container-column-status property="status" name="Status">
            </liferay-ui:search-container-column-status>

        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator/>
    </liferay-ui:search-container>

    <liferay-frontend:add-menu>
        <liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add-leave") %>' url="<%= addLeaveJSP %>"/>
    </liferay-frontend:add-menu>

</div>
