<!--  Migrated to Liferay 7 / Liferay DXP by  Manish Kumar Jaiswal -->

<!--  ********Author Details******** -->
<!--  Manish Kumar Jaiswal -->
<!--  Email : Manish.kr.jaiswal@gmail.com -->
<!--  Cell No:+919990866537 -->
<!--  ********Author Details******** -->

<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.feedbackservice.model.Feedback"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.feedbackservice.service.FeedbackLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp"%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/view_approved_feedback.jsp" />
</liferay-portlet:renderURL>
<liferay-ui:search-container emptyResultsMessage="there-are-no-feedbacks"
	headerNames="FeedBack Subject,Message, Stauts"
	iteratorURL="<%=iteratorURL%>" delta="10" deltaConfigurable="true">
	<liferay-ui:search-container-results>
		<%
			List<Feedback> feedbackList = FeedbackLocalServiceUtil.findByG_S(themeDisplay.getScopeGroupId(),
							WorkflowConstants.STATUS_APPROVED);
					results = ListUtil.subList(feedbackList, searchContainer.getStart(), searchContainer.getEnd());
					searchContainer.setTotal(feedbackList.size());
					searchContainer.setResults(results);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Feedback"
		keyProperty="feedbackId" modelVar="currentFeedback">
		<liferay-ui:search-container-column-text name="FeedBack Subject"
			property="feedbackSubject" />
		<liferay-ui:search-container-column-text name="Message"
			property="feedbackText" />
		<liferay-ui:search-container-column-text name="status"><%=WorkflowConstants.LABEL_APPROVED%></liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>
