package org.javasavvy.leave.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.javasavvy.leave.constants.LeavePortletKeys;
import org.javasavvy.leave.core.service.model.Leave;
import org.javasavvy.leave.core.service.service.LeaveLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
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
    public void actionMethod1(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException, PortalException, SystemException {
        User usuario = PortalUtil.getUser(actionRequest);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Leave.class.getName(), actionRequest);

        serviceContext.setScopeGroupId(usuario.getGroupId());
        Leave leave = LeaveLocalServiceUtil.createLeave(new Random().nextLong());
        LeaveLocalServiceUtil.addLeave(serviceContext, "leaveName1", new Date(), new Date());
        actionResponse.setRenderParameter("mvcPath", "/auto_leave_form.jsp");
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        super.doView(renderRequest, renderResponse);
    }
}
