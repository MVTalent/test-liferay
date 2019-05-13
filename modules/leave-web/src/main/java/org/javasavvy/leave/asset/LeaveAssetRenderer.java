package org.javasavvy.leave.asset;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import org.javasavvy.leave.core.service.model.Leave;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LeaveAssetRenderer extends BaseJSPAssetRenderer<Leave> {

    private final Leave leave;
    private final ResourceBundleLoader resourceBundleLoader;

    public LeaveAssetRenderer(Leave leave, ResourceBundleLoader resourceBundleLoader) {
        this.leave = leave;
        this.resourceBundleLoader = resourceBundleLoader;
    }

    @Override
    public Leave getAssetObject() {
        return leave;
    }

    @Override
    public long getGroupId() {
        return leave.getGroupId();
    }

    @Override
    public long getUserId() {
        return leave.getUserId();
    }

    @Override
    public String getUserName() {
        return leave.getUserName();
    }

    @Override
    public String getUuid() {
        return leave.getUuid();
    }

    @Override
    public String getClassName() {
        return Leave.class.getName();
    }

    @Override
    public long getClassPK() {
        return leave.getLeaveId();
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return leave.getLeaveName() + "by " + leave.getUserName() + ",from:" + leave.getStartDate();
    }

    @Override
    public int getStatus() {
        return leave.getStatus();
    }

    @Override
    public String getTitle(Locale locale) {
        return leave.getLeaveName();
    }

    @Override
    public int getAssetRendererType() {
        return super.getAssetRendererType();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        return "/leaveAssetInfo.jsp";

    }

    @Override
    public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
        request.setAttribute("leaveEntry", leave);
        return super.include(request, response, template);
    }

}
