package org.javasavvy.leave.asset;

import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRenderer;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.javasavvy.leave.constants.LeavePortletKeys;
import org.javasavvy.leave.core.service.model.Leave;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LeaveAssetRenderer extends BaseJSPAssetRenderer<Leave> implements TrashRenderer {

    public static final String TYPE = "leave";

    private final Leave _leave;

    public LeaveAssetRenderer(Leave leave) {
        _leave = leave;
    }

    @Override
    public Leave getAssetObject() {
        return _leave;
    }

    @Override
    public String getClassName() {
        return Leave.class.getName();
    }

    public long getClassPK() {
        return _leave.getLeaveId();
    }

    public long getGroupId() {
        return _leave.getGroupId();
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        if (template.equals(TEMPLATE_FULL_CONTENT)) {
            request.setAttribute(WebKeys.JOURNAL_FOLDER, _leave);
            return "/asset/folder_" + template + ".jsp";
        } else {
            return null;
        }
    }

    @Override
    public String getPortletId() {
        AssetRendererFactory<Leave> assetRendererFactory =
                getAssetRendererFactory();
        return assetRendererFactory.getPortletId();
    }

    @Override
    public int getStatus() {
        return _leave.getStatus();
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return _leave.getLeaveName() + "by " + _leave.getUserName() + ",from:" + _leave.getStartDate();
    }

    @Override
    public String getTitle(Locale locale) {
        return _leave.getLeaveName();
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public long getUserId() {
        return _leave.getUserId();
    }

    @Override
    public String getUserName() {
        return _leave.getUserName();
    }

    @Override
    public String getUuid() {
        return _leave.getUuid();
    }

    @Override
    public PortletURL getURLEdit(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse)
            throws Exception {

        Group group = GroupLocalServiceUtil.fetchGroup(_leave.getGroupId());

        PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
                liferayPortletRequest, group, LeavePortletKeys.Leave, 0, 0,
                PortletRequest.RENDER_PHASE);

        portletURL.setParameter("mvcPath", "/edit_folder.jsp");
        portletURL.setParameter(
                "folderId", String.valueOf(_leave.getLeaveId()));

        return portletURL;
    }

    @Override
    public String getURLView(
            LiferayPortletResponse liferayPortletResponse,
            WindowState windowState)
            throws Exception {

        AssetRendererFactory<Leave> assetRendererFactory =
                getAssetRendererFactory();

        PortletURL portletURL = assetRendererFactory.getURLView(
                liferayPortletResponse, windowState);

        portletURL.setParameter("mvcPath", "/asset/folder_full_content.jsp");
        portletURL.setParameter(
                "folderId", String.valueOf(_leave.getLeaveId()));
        portletURL.setWindowState(windowState);

        return portletURL.toString();
    }

    @Override
    public String getURLViewInContext(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            String noSuchEntryRedirect) {

        try {
            return getURLView(liferayPortletResponse, WindowState.MAXIMIZED);
        } catch (Exception e) {
            return noSuchEntryRedirect;
        }
    }

}
