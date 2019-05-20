package ru.rostec.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import ru.rostec.constants.ZskpPortletKeys;
import ru.rostec.model.Process;
import ru.rostec.service.ProcessLocalService;

import javax.servlet.ServletContext;

@Component(
        immediate = true,
        property = {"javax.portlet.name=" + ZskpPortletKeys.Zskp},
        service = AssetRendererFactory.class
)
public class ProcessAssetRenderFactory extends BaseAssetRendererFactory<Process> {

    private ProcessLocalService processLocalService;
    private ResourceBundleLoader resourceBundleLoader;
    private ServletContext servletContext;

    @Reference(unbind = "-")
    protected void setLeaveService(ProcessLocalService processLocalService) {
        this.processLocalService = processLocalService;
    }

    @Reference(unbind = "-")
    public void setResourceBundleLoader(ResourceBundleLoader resourceBundleLoader) {
        this.resourceBundleLoader = resourceBundleLoader;
    }

    @Reference(unbind = "-")
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public ProcessAssetRenderFactory() {
        setClassName(Process.class.getName());
        setCategorizable(true);
        setLinkable(true);
        setPortletId(ZskpPortletKeys.Zskp);
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Process> getAssetRenderer(long classPK, int type) throws PortalException {
        Process process = processLocalService.getProcess(classPK);
        ProcessAssetRenderer assetRenders = new ProcessAssetRenderer(process, resourceBundleLoader);
        assetRenders.setAssetRendererType(type);
        assetRenders.setServletContext(servletContext);
        return assetRenders;
    }

    @Override
    public String getType() {
        return "process";
    }

    @Override
    public String getClassName() {
        return Process.class.getName();
    }
}
