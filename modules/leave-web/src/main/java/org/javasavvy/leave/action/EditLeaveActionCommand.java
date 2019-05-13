package org.javasavvy.leave.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.javasavvy.leave.constants.LeavePortletKeys;
import org.javasavvy.leave.core.service.model.Leave;
import org.javasavvy.leave.core.service.service.LeaveLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component(
        property = {
                "javax.portlet.name=" + LeavePortletKeys.Leave,
                "mvc.command.name=leave_editLeave"
        },
        service = MVCActionCommand.class
)
public class EditLeaveActionCommand extends BaseMVCActionCommand {

    private LeaveLocalService leaveService;

    @Reference(unbind = "-")
    protected void setLeaveService(LeaveLocalService leaveService) {
        this.leaveService = leaveService;
    }

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
        System.out.println("in EditLeaveActionCommand ");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String name = ParamUtil.getString(actionRequest, "name");
        Date startDate = ParamUtil.getDate(actionRequest, "startDate", sdf);
        Date endDate = ParamUtil.getDate(actionRequest, "endDate", sdf);

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getScopeGroupId();
        Leave leave = leaveService.addLeave(null ,name, startDate, endDate);

    }
}
