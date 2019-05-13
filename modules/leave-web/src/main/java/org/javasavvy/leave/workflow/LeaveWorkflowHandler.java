package org.javasavvy.leave.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import org.javasavvy.leave.core.service.model.Leave;
import org.javasavvy.leave.core.service.service.LeaveLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

@Component(
        property = {"model.class.name=org.javasavvy.leave.model.Leave"},
        service = WorkflowHandler.class
)
public class LeaveWorkflowHandler extends BaseWorkflowHandler<Leave> {

    private LeaveLocalService leaveService;

    @Reference(unbind = "-")
    protected void setLeaveService(LeaveLocalService leaveService) {
        this.leaveService = leaveService;
    }

    @Override
    public String getClassName() {
        return Leave.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "leave";
    }

    @Override
    public Leave updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {

        long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long leaveId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");
        return leaveService.updateStatus(20139, leaveId, status, serviceContext);
    }
}
