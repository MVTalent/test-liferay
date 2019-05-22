package org.javasavvy.leave.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import org.javasavvy.leave.constants.LeavePortletKeys;
import org.javasavvy.leave.core.service.model.Leave;
import org.javasavvy.leave.core.service.service.LeaveLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

@Component(
        immediate = true,
        property = {"javax.portlet.name=" + LeavePortletKeys.Leave},
        service = AssetRendererFactory.class
)
public class LeaveAssetRenderFactory extends BaseAssetRendererFactory<Leave> {
    public static final String TYPE = "leave";
    private LeaveLocalService leaveService;
    private ResourceBundleLoader resourceBundleLoader;
    private ServletContext servletContext;

    @Reference(unbind = "-")
    protected void setLeaveService(LeaveLocalService leaveService) {
        this.leaveService = leaveService;
    }

    @Reference(unbind = "-")
    public void setResourceBundleLoader(ResourceBundleLoader resourceBundleLoader) {
        this.resourceBundleLoader = resourceBundleLoader;
    }

    @Reference(unbind = "-")
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public LeaveAssetRenderFactory() {
        setClassName(Leave.class.getName());
        setCategorizable(true);
        setLinkable(true);
        setPortletId(LeavePortletKeys.Leave);
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Leave> getAssetRenderer(long classPK, int type) throws PortalException {
        Leave leave = leaveService.getLeave(classPK);
        LeaveAssetRenderer assetRenders = new LeaveAssetRenderer(leave, resourceBundleLoader);
        assetRenders.setAssetRendererType(type);
        assetRenders.setServletContext(servletContext);
        return assetRenders;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getClassName() {
        return Leave.class.getName();
    }

    @Override
    public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, long classTypeId) {
        PortletURL portletURL = PortalUtil.getControlPanelPortletURL(liferayPortletRequest, getGroup(liferayPortletRequest),
                LeavePortletKeys.Leave, 0, 0, PortletRequest.RENDER_PHASE);
        portletURL.setParameter("mvcRenderCommandName", "/edit");
        return portletURL;
    }

    @Override
    public PortletURL getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) {
        LiferayPortletURL liferayPortletURL = liferayPortletResponse.createLiferayPortletURL(
                LeavePortletKeys.Leave, PortletRequest.RENDER_PHASE);
        try {
            liferayPortletURL.setWindowState(windowState);
        } catch (WindowStateException wse) {
            wse.printStackTrace();
        }

        return liferayPortletURL;
    }

}
