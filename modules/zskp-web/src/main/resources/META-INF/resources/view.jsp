<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="ru.rostec.service.ZskpProcessLocalServiceUtil" %>
<%@ include file="/init.jsp" %>
<%
    PortletURL leaveItrUrl = renderResponse.createRenderURL();
    leaveItrUrl.setParameter("mvcPath", "/view.jsp");

%>
<style>
    * {
        box-sizing: border-box;
    }

    #myInput {
        background-image: url('/css/searchicon.png');
        background-position: 10px 10px;
        background-repeat: no-repeat;
        width: 100%;
        font-size: 16px;
        padding: 12px 20px 12px 40px;
        border: 1px solid #ddd;
        margin-bottom: 12px;
    }

    #mylist {

        background-position: 10px 10px;
        background-repeat: no-repeat;
        width: 100%;
        font-size: 16px;
        padding: 12px 20px 12px 40px;
        border: 1px solid #ddd;
        margin-bottom: 12px;
    }

    #myTable {
        border-collapse: collapse;
        width: 100%;
        border: 1px solid #ddd;
        font-size: 18px;
    }

    #myTable th, #myTable td {
        text-align: left;
        padding: 12px;
    }

    #myTable tr {
        border-bottom: 1px solid #ddd;
    }

    #myTable tr.header, #myTable tr:hover {
        background-color: #f1f1f1;
    }
</style>

<label for="mylist"></label>
<select id="mylist" onchange="myFunction()">
    <option selected>Выберите вид процесса</option>
    <option value="Отсутствие">Отсутствие</option>
    <option value="Отпуск">Отпуск</option>
    <option value="Отпуск">Заявки</option>
    <option value="Общекорпоративные заявки">Общекорпоративные заявки</option>
</select>