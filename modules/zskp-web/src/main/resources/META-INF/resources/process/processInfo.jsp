<%@ page import="ru.rostec.service.ZskpProcessLocalServiceUtil" %>
<%@ page import="ru.rostec.model.ZskpProcess" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%
    Long processId = Long.parseLong(ParamUtil.getString(request, "processId"));

    ZskpProcess zskpProcess = ZskpProcessLocalServiceUtil.getZskpProcess(processId);

%>

