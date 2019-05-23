<!--  Migrated to Liferay 7 / Liferay DXP by  Manish Kumar Jaiswal -->

<!--  ********Author Details******** -->
<!--  Manish Kumar Jaiswal -->
<!--  Email : Manish.kr.jaiswal@gmail.com -->
<!--  Cell No:+919990866537 -->
<!--  ********Author Details******** -->

<%@page import="com.feedbackservice.model.Feedback"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.feedbackservice.service.FeedbackLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@ include file="init.jsp"%>
<%
	Feedback feedback = null;
	if (request.getAttribute("feedBackObject") != null)
		feedback = (Feedback) request.getAttribute("feedBackObject");
%>
<c:if test='<%=feedback != null%>'>
	<h2><%=feedback.getFeedbackSubject()%></h2>
	<br />
Message:
<div>
		<%=feedback.getFeedbackText()%>
	</div>
</c:if>