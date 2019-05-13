<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<portlet:renderURL var="viewLeave" >
    <%--<portlet:param name="backURL" value="<%=currentURL %>" />--%>
    <portlet:param name="leaveId" value="${leave.leaveId}" />
    <portlet:param name="mvcRenderCommandName" value="viewleave_info"/>
</portlet:renderURL>
