package ru.rostec.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import ru.rostec.constants.ZskpPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import ru.rostec.model.ZskpProcess;
import ru.rostec.service.ZskpProcessLocalServiceUtil;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * @author user
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + ZskpPortletKeys.Zskp,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.version=3.0"
        },
        service = Portlet.class
)
public class ZskpPortlet extends MVCPortlet {

    public void createProcess(ActionRequest request, ActionResponse response)
            throws PortalException, SystemException {
        User user = PortalUtil.getUser(request);
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setScopeGroupId(user.getGroupId());
        ZskpProcess process = ZskpProcessLocalServiceUtil.createZskpProcess(new Random().nextLong());
        String processName = ParamUtil.getString(request, "processName");
        long processType = Long.parseLong(ParamUtil.getString(request, "processType"));
        long processKind = Long.parseLong(ParamUtil.getString(request, "processKind"));
        process.setName(processName);
        process.setType(processType);
        process.setKind(processKind);
        ZskpProcessLocalServiceUtil.addZskpProcess(process);
    }
}
