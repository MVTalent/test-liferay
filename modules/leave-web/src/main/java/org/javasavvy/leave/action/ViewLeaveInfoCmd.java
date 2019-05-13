package org.javasavvy.leave.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.javasavvy.leave.constants.LeavePortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        property = {
                "javax.portlet.name=" + LeavePortletKeys.Leave,
                "mvc.command.name=viewleave_info"
        }, service = MVCRenderCommand.class
)
public class ViewLeaveInfoCmd implements MVCRenderCommand {

    private final static String VIEW_LEAVE_INFO = "/leaveInfo.jsp";

    private final static String ERROR = "/error.jsp";

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        System.out.println("in ViewLeaveInfoCmd ");
        try {
            long leaveId = ParamUtil.getLong(renderRequest, "leaveId", -1L);
        } catch (Exception e) {
            return ERROR;
        }

        return VIEW_LEAVE_INFO;
    }
}
