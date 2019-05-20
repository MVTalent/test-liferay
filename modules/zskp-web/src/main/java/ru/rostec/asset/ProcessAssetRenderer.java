package ru.rostec.asset;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import ru.rostec.model.Process;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class ProcessAssetRenderer extends BaseJSPAssetRenderer<Process> {

    private final Process process;
    private final ResourceBundleLoader resourceBundleLoader;

    public ProcessAssetRenderer(Process process, ResourceBundleLoader resourceBundleLoader) {
        this.process = process;
        this.resourceBundleLoader = resourceBundleLoader;
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        return "/process/processInfo.jsp";
    }

    @Override
    public Process getAssetObject() {
        return process;
    }

    @Override
    public long getGroupId() {
        return 0;
    }

    @Override
    public long getUserId() {
        return 0;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getUuid() {
        return null;
    }

    @Override
    public String getClassName() {
        return Process.class.getName();
    }

    @Override
    public long getClassPK() {
        return process.getId();
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return null;
    }

    @Override
    public String getTitle(Locale locale) {
        return null;
    }

    @Override
    public int getAssetRendererType() {
        return super.getAssetRendererType();
    }

    @Override
    public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
        request.setAttribute("processEntry", process);
        return super.include(request, response, template);
    }
}

