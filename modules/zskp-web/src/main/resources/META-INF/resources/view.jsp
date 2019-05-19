<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="ru.rostec.service.KindLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.rostec.model.Kind" %>
<%@ include file="/init.jsp" %>
<link href="${pageContext.request.contextPath}/css/zskp.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/zskp-view.js"></script>
<%
    PortletURL leaveItrUrl = renderResponse.createRenderURL();
    leaveItrUrl.setParameter("mvcPath", "/view.jsp");
    List<Kind> kindList = KindLocalServiceUtil.getKinds(-1, -1);
%>
<portlet:renderURL var="initProcess">
    <portlet:param name="mvcPath" value="/process/initProcess.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="listProcess">
    <portlet:param name="mvcPath" value="/process/listProcess.jsp"/>
</portlet:renderURL>
<div>
    <select id="process-kind-sel" onchange="filterProcessKind()">
        <option value="none" selected>Выберите вид процесса</option>
        <%
            for (Kind kind : kindList) {
        %>
        <option value="<%=kind.getCode()%>"><%=kind.getName()%></option>
        <%} %>
    </select>


    <%--<option value="holiday">Отпуск</option>
    <option value="application">Заявки</option>
    <option value="corporate_applications">Общекорпоративные заявки</option>
</select>--%>
    <ul class="process-kinds">
        <li class="absence"><span>Отсутствие</span>
            <ul>
                <li>Отсутствие по личным обстоятельствам
                    <ul class="process-name">
                        <li>Заявка на отсутствие по личным обстоятельствам</li>
                        <li>
                            <ul class="process-action">
                                <li><a href="<%= initProcess %>">Создать</a></li>
                                <li><a href="<%= listProcess %>">Созданные мной</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>Отсутствие по рабочим обстоятельствам
                    <ul class="process-name">
                        <li>Заявка на отсутствие по рабочим обстоятельствам</li>
                        <li>
                            <ul class="process-action">
                                <li><a href="<%= initProcess %>">Создать</a></li>
                                <li><a href="<%= listProcess %>">Созданные мной</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
        <li class="holiday"><span>Отпуск</span>
            <ul>
                <li>Плановый отпуск
                    <ul class="process-name">
                        <li>Заявка на плановый отпуск</li>
                        <li>
                            <ul class="process-action">
                                <li><a href="<%= initProcess %>">Создать</a></li>
                                <li><a href="<%= listProcess %>">Созданные мной</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>Ежегодный оплачиваемый отпуск
                    <ul class="process-name">
                        <li>Заявка на ежегодный оплачиваемый отпуск</li>
                        <li>
                            <ul class="process-action">
                                <li><a href="<%= initProcess %>">Создать</a></li>
                                <li><a href="<%= listProcess %>">Созданные мной</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>Отпуск без сохранения заработной платы
                    <ul class="process-name">
                        <li>Заявка на отпуск без сохранения заработной платы</li>
                        <li>
                            <ul class="process-action">
                                <li><a href="<%= initProcess %>">Создать</a></li>
                                <li><a href="<%= listProcess %>">Созданные мной</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>Дополнительный отпуск
                    <ul class="process-name">
                        <li>Заявка на дополнительный отпуск</li>
                        <li>
                            <ul class="process-action">
                                <li><a href="<%= initProcess %>">Создать</a></li>
                                <li><a href="<%= listProcess %>">Созданные мной</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>

        <li class="application"><span>Заявки</span>
            <ul>
                <li>Заявка в Банк идей
                    <ul class="process-name">
                        <li>Заявка в Банк идей</li>
                        <li>
                            <ul class="process-action">
                                <li><a href="<%= initProcess %>">Создать</a></li>
                                <li><a href="<%= listProcess %>">Созданные мной</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>Утверждение карточки KPI
                    <ul class="process-name">
                        <li>Утверждение карточки KPI</li>
                        <li>
                            <ul class="process-action">
                                <li><a href="<%= initProcess %>">Создать</a></li>
                                <li><a href="<%= listProcess %>">Созданные мной</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
        <li class="corporate_applications"><span>Общекорпоративные заявки</span>
            <ul>
                <li>Определяется на этапе технического проектирования
                    <ul class="process-name">
                        <li>Общекорпоративные заявки</li>
                        <li>
                            <ul class="process-action">
                                <li><a href="<%= initProcess %>">Создать</a></li>
                                <li><a href="<%= listProcess %>">Созданные мной</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
</div>
