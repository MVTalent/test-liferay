<%@ page import="com.liferay.portal.kernel.search.suggest.SuggesterResult" %>
<%@include file="../../init.jsp"%>

<%
    SuggesterResult.Entry entry = (SuggesterResult.Entry)request.getAttribute("gb_entry");

    //entry = entry.toEscapedModel();
%>

<dl>
    <dt>Guestbook</dt>
    <dt>Name</dt>
    <dt>Message</dt>
</dl>
