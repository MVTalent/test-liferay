<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@page language="java" contentType="text/html; charset=utf-8" %>
<portlet:actionURL name="createProcess" var="createProcessAction">
    <param name="test" value="test">
</portlet:actionURL>

<form action="${createProcessAction}" method="post">
    <table>
        <tr>
            <td><label for="<portlet:namespace/>startDate">Дата отсутствия</label></td>
            <td><input type="date" id="<portlet:namespace/>startDate" name="<portlet:namespace/>startDate"></td>
        </tr>
        <tr>
            <td><label for="<portlet:namespace/>startTime">Время начала отсутствия</label></td>
            <td><input type="time" id="<portlet:namespace/>startTime" name="<portlet:namespace/>startTime"></td>
        </tr>
        <tr>
            <td><label for="<portlet:namespace/>endTime">Время окончания отсутствия</label></td>
            <td><input type="time" id="<portlet:namespace/>endTime" name="<portlet:namespace/>endTime"></td>
        </tr>
        <tr>
            <td><label for="<portlet:namespace/>justification">Обоснование</label></td>
            <td><input type="text" id="<portlet:namespace/>justification" name="<portlet:namespace/>justification"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Запустить процесс">
            </td>
        </tr>
    </table>
</form>
