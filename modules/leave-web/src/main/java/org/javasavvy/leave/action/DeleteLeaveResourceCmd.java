package org.javasavvy.leave.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import org.javasavvy.leave.constants.LeavePortletKeys;
import org.javasavvy.leave.core.service.service.LeaveLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

@Component(
        property = {
                "javax.portlet.name=" + LeavePortletKeys.Leave,
                "mvc.command.name=delete_leave_res"
        },
        service = MVCResourceCommand.class
)
public class DeleteLeaveResourceCmd extends BaseMVCResourceCommand {
    private LeaveLocalService leaveService;

    @Reference(unbind = "-")
    protected void setLeaveService(LeaveLocalService leaveService) {

        this.leaveService = leaveService;
    }

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws Exception {

        System.out.println("in delete leave Resource cmd ");

    }
}
