package org.javasavvy.leave.asset;

import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import org.javasavvy.leave.constants.LeavePortletKeys;
import org.javasavvy.leave.core.service.model.Leave;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.ResourceBundle;

public class LeaveAssetRenderer extends BaseJSPAssetRenderer<Leave> implements TrashRenderer {

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
        return "/leaveInfo.jsp";

    }

    @Override
    public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
        request.setAttribute("leaveEntry", leave);
        return super.include(request, response, template);
    }

    @Override
    public String getPortletId() {
        AssetRendererFactory<Leave> assetRendererFactory =
                getAssetRendererFactory();

        return assetRendererFactory.getPortletId();
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public boolean isPrintable() {
        return true;
    }

    @Override
    public PortletURL getURLEdit(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse)
            throws Exception {

        Group group = GroupLocalServiceUtil.fetchGroup(leave.getGroupId());

        PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
                liferayPortletRequest, group, LeavePortletKeys.Leave, 0, 0,
                PortletRequest.RENDER_PHASE);

        portletURL.setParameter("mvcRenderCommandName", "/edit");
        portletURL.setParameter("leaveId", String.valueOf(leave.getLeaveId()));

        return portletURL;
    }

    @Override
    public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {
        AssetRendererFactory<Leave> assetRendererFactory =
                getAssetRendererFactory();

        PortletURL portletURL = assetRendererFactory.getURLView(
                liferayPortletResponse, windowState);
        portletURL.setParameter("mvcRenderCommandName", "/addLeave");
        portletURL.setParameter("leaveId", String.valueOf(leave.getLeaveId()));
        portletURL.setWindowState(windowState);
        return portletURL.toString();
    }

    @Override
    public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) {
        return getURLViewInContext(
                liferayPortletRequest, noSuchEntryRedirect, "/leaveInfo",
                "leaveId", leave.getLeaveId());
    }
}
