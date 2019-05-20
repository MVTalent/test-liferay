package ru.rostec.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import ru.rostec.model.Process;
import ru.rostec.service.ProcessLocalService;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

@Component(
        property = {"model.class.name=ru.rostec.model.Process"},
        service = WorkflowHandler.class
)
public class ProcessWorkflowHandler extends BaseWorkflowHandler<Process> {

    private ProcessLocalService processLocalService;

    @Reference(unbind = "-")
    protected void setLeaveService(ProcessLocalService processService) {
        this.processLocalService = processService;
    }

    @Override
    public String getClassName() {
        return Process.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return "process";
    }

    @Override
    public Process updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        long userId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long processId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        ServiceContext serviceContext = (ServiceContext)workflowContext.get("serviceContext");
        return processLocalService.updateStatus(userId, processId, status, serviceContext);
    }
}
