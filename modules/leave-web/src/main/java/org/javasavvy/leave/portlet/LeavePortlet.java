package org.javasavvy.leave.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.javasavvy.leave.constants.LeavePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.javasavvy.leave.core.service.model.Leave;
import org.javasavvy.leave.core.service.service.LeaveLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

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
                "javax.portlet.display-name=Leave Portlet",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + LeavePortletKeys.Leave,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class LeavePortlet extends MVCPortlet {
    public void actionMethod1(ActionRequest request, ActionResponse response)
            throws IOException, PortletException, PortalException, SystemException {
        User usuario = PortalUtil.getUser(request);
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setScopeGroupId(usuario.getGroupId());
        Leave leave = LeaveLocalServiceUtil.createLeave(new Random().nextLong());
        LeaveLocalServiceUtil.addLeave(serviceContext, "leaveName1", new Date(), new Date());
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        super.doView(renderRequest, renderResponse);
    }
}
