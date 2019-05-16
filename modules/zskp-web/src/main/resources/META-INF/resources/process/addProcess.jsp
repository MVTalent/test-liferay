<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<portlet:actionURL name="createProcess" var="createProcessAction">
</portlet:actionURL>

<form action="${createProcessAction}" method="post">
    <label>
        <input type="text" name="<portlet:namespace/>processName">
    </label><br>
    <label>
        <input type="text" name="<portlet:namespace/>processType">
    </label><br>
    <label>
        <input type="text" name="<portlet:namespace/>processKind">
    </label><br>
    <input type="submit" value="Submit">
</form>
