package org.javasavvy.process.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import org.javasavvy.process.core.service.model.Process;
import org.javasavvy.process.core.service.service.ProcessLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

@Component(
        property = {"model.class.name=org.javasavvy.process.model.Leave"},
        service = WorkflowHandler.class
)
public class ProcessWorkflowHandler extends BaseWorkflowHandler<Process> {

    private ProcessLocalService processLocalService;

    @Reference(unbind = "-")
    protected void setLeaveService(ProcessLocalService processLocalService) {
        this.processLocalService = processLocalService;
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
        return null;
    }
}
