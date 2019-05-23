<!--  Migrated to Liferay 7 / Liferay DXP by  Manish Kumar Jaiswal -->

<!--  ********Author Details******** -->
<!--  Manish Kumar Jaiswal -->
<!--  Email : Manish.kr.jaiswal@gmail.com -->
<!--  Cell No:+919990866537 -->
<!--  ********Author Details******** -->

<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@ include file="init.jsp"%>
<portlet:actionURL var="submitAutoFeedback"
	windowState="<%=LiferayWindowState.NORMAL.toString()%>"
	name="submitAutoFeedback">
</portlet:actionURL>
<a href="<portlet:renderURL />">&laquo;Home</a>
<div class="separator"></div>
<fieldset>
	<legend>Auto Feedback Form</legend>
	<c:if
		test='<%=SessionMessages.contains(renderRequest, "feedback-submit-success")%>'>
		<liferay-ui:success key="feedback-submit-success"
			message="Feedback has been submited successfully." />
	</c:if>
	<c:if
		test='<%=SessionMessages.contains(renderRequest, "workflow-not-enabled")%>'>
		<liferay-ui:success key="workflow-not-enabled"
			message="Feedback not enabled with workflow please enable workflow." />
	</c:if>
	<c:if
		test='<%=SessionErrors.contains(renderRequest, "feedback-submit-failed")%>'>
		<liferay-ui:success key="feedback-submit-failed"
			message="There is problem of submit feedback please try again.." />
	</c:if>
	<aui:form action="<%=submitAutoFeedback%>" method="post"
		name="feedbackForm">

		<aui:input label="Feedback Subject" name="feedbackSubject"
			id="feedbackSubject" type="text" style="width:600px;height:50px;">
			<aui:validator name="required" />
		</aui:input>



		<aui:input name="feedbackMessage" id="feedbackMessage"
			label="Feedback Message" type="textarea"
			style="width:600px;height:100px;">
			<aui:validator name="required" />
		</aui:input>
		
		<span style="float: left;">Characters Left&nbsp;</span>
		<p id="<portlet:namespace/>textCounter"></p>
	
&nbsp;

				<aui:button type="submit" value="Submit Feedback" name="submit"></aui:button>

	</aui:form>
</fieldset>
<aui:script>
	AUI().use('aui-char-counter', function(A) {
		new A.CharCounter({
			counter : '#<portlet:namespace/>textCounter',
			input : '#<portlet:namespace/>feedbackMessage',
			maxLength : 75,
			on : {
				maxLength : function(event) {
					alert('The max length limit was reached');
				}
			}
		});
	});
</aui:script>
