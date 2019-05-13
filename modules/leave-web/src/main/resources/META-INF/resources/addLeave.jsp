<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<portlet:actionURL name="actionMethod1" var="actionURLByPortletTagURL">
</portlet:actionURL>

<form action="${actionURLByPortletTagURL}" method="post">
    UserName :-<input type="text" name="userName"><br>
    <input type="submit" value="Submit">
</form>
