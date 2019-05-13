package org.javasavvy.leave.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import org.javasavvy.leave.core.service.model.Leave;
import org.javasavvy.leave.core.service.service.LeaveLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.ServletContext;

@Component(
        immediate = true,
        property = {"javax.portlet.name=org_javasavvy_web_leave_portlet"},
        service = AssetRendererFactory.class
)
public class LeaveAssetRenderFactory extends BaseAssetRendererFactory<Leave> {
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
        setPortletId("org_javasavvy_web_leave_portlet");
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
        return "leave";
    }

    @Override
    public String getClassName() {
        return Leave.class.getName();
    }
}
