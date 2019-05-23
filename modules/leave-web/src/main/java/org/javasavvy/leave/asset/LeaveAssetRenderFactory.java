package org.javasavvy.leave.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import org.javasavvy.leave.constants.LeavePortletKeys;
import org.javasavvy.leave.core.service.model.Leave;
import org.javasavvy.leave.core.service.service.LeaveLocalService;
import org.javasavvy.leave.core.service.service.LeaveLocalServiceUtil;
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

    @Override
    public AssetRenderer<Leave> getAssetRenderer(long classPK, int type) throws PortalException, SystemException {
        Leave feedback = LeaveLocalServiceUtil.getLeave(classPK);
        return new LeaveAssetRenderer(feedback);
    }

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    public static final String TYPE = "Leave";
    public static final String CLASS_NAME = Leave.class.getName();

   /* private static final String TYPE = "leave";
    *//*private LeaveLocalService leaveService;
    private ResourceBundleLoader resourceBundleLoader;
    private ServletContext servletContext;
    private ModelResourcePermission<Leave> leaveModelResourcePermission;*//*

    *//*@Reference(unbind = "-")
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
*//*
    *//*public LeaveAssetRenderFactory() {
        setClassName(Leave.class.getName());
        setCategorizable(true);
        setLinkable(true);
        setPortletId(LeavePortletKeys.Leave);
        setSearchable(true);
        setSelectable(true);
    }
*//*
    @Override
    public AssetRenderer<Leave> getAssetRenderer(long classPK, int type) throws PortalException {
        Leave leave = LeaveLocalServiceUtil.getLeave(classPK);
        return new LeaveAssetRenderer(leave);
        //Leave leave = leaveService.getLeave(classPK);
        //LeaveAssetRenderer assetRenders = new LeaveAssetRenderer(leave, resourceBundleLoader, leaveModelResourcePermission);
        //assetRenders.setAssetRendererType(type);
        //assetRenders.setServletContext(servletContext);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getClassName() {
        return Leave.class.getName();
    }*/

}
