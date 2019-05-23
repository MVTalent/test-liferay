<%@ page import="org.javasavvy.leave.core.service.model.Leave" %>
<%@include file="../../init.jsp"%>

<%
    Leave leave = (Leave)request.getAttribute("leaveEntry");

    //leave = guestbook.toEscapedModel();
%>

<dl>
    <dt>Name</dt>
    <dd><%= leave.getLeaveName() %></dd>
</dl>
