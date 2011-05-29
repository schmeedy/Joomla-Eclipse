package com.schmeedy.pdt.joomla.ui.project;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.internal.LegacyResourceSupport;
import org.osgi.framework.ServiceRegistration;

import com.schmeedy.pdt.joomla.common.ui.JoomlaCommonUiPlugin;
import com.schmeedy.pdt.joomla.core.project.IExtensionModelChangeListener;
import com.schmeedy.pdt.joomla.core.project.IJoomlaProjectManager;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionResource;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.ui.JoomlaUiPlugin;
import com.schmeedy.pdt.service.registry.ServiceRegistry;

@SuppressWarnings("restriction")
public class ExtensionFileLabelDecorator implements ILightweightLabelDecorator, IExtensionModelChangeListener {
	
	private final IJoomlaProjectManager projectManager = ServiceRegistry.getInstance().getService(IJoomlaProjectManager.class);
	
	private final ServiceRegistration extensionModelChangeListenerRegistration;
	
	private final ImageDescriptor siteOverlay = JoomlaCommonUiPlugin.getInstance().getImageDescriptor(JoomlaCommonUiPlugin.OVR_SYNC_SITE);
	private final ImageDescriptor adminOverlay = JoomlaCommonUiPlugin.getInstance().getImageDescriptor(JoomlaCommonUiPlugin.OVR_SYNC_ADMIN);
	
	private final List<ILabelProviderListener> listeners = new CopyOnWriteArrayList<ILabelProviderListener>();
	
	public ExtensionFileLabelDecorator() {
		extensionModelChangeListenerRegistration = JoomlaUiPlugin.getInstance().getBundleContext().registerService(IExtensionModelChangeListener.class.getName(), this, null);
	}
	
	@Override
	public void decorate(Object element, IDecoration decoration) {
		final Object adapterElement = element instanceof ModelElement ? LegacyResourceSupport.getAdaptedContributorResource(element) : element; 
		if (!(adapterElement instanceof IFile) && !(adapterElement instanceof IFolder)) {
			return;
		}
		final IResource resource = (IResource) adapterElement;
		final IProject project = resource.getProject();
		if (project == null) {
			return;
		}
		final JoomlaExtensionProject extensionProject = projectManager.getExtensionProjectModel(project);
		if (extensionProject == null) {
			return;
		}
		final ExtensionResource extensionResource = getExtensionResource(resource, extensionProject);
		if (extensionResource == null) {
			return;
		}
		doDecorate(extensionResource, decoration);
	}

	private void doDecorate(ExtensionResource extensionResource, IDecoration decoration) {
		decoration.addOverlay(extensionResource.isInAdministration() ? adminOverlay : siteOverlay, IDecoration.TOP_LEFT);		
	}

	private ExtensionResource getExtensionResource(IResource resource, JoomlaExtensionProject extensionProject) {
		for (final BasicExtensionModel extensionModel : extensionProject.getExtensions()) {
			if (!extensionModel.getManifestPath().removeLastSegments(1).isPrefixOf(resource.getFullPath())) {
				continue;
			}
			for (final ExtensionResource extensionResource : extensionModel.getResources()) {
				if (extensionResource.getFullPath().equals(resource.getFullPath())) {
					return extensionResource;
				}
			}
		}
		return null;
	}

	@Override
	public void onExtensionModelChange(BasicExtensionModel extensionModel) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				for (final ILabelProviderListener listener : listeners) {
					listener.labelProviderChanged(new LabelProviderChangedEvent(ExtensionFileLabelDecorator.this));
				}
			}
		});
	}
	
	@Override
	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}
	
	@Override
	public void dispose() {
		extensionModelChangeListenerRegistration.unregister();
	}
	
}
