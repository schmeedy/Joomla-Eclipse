package com.schmeedy.pdt.joomla.ui.server.view;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.schmeedy.pdt.joomla.common.ui.JoomlaCommonUiPlugin;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;

public class ExtensionModelLabelProvider extends LabelProvider {
	private final Image projectImage = PlatformUI.getWorkbench().getSharedImages().getImage(IDE.SharedImages.IMG_OBJ_PROJECT);
	
	private final Image componentImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_EXT_COMPONENT);
	private final Image pluginImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_EXT_PLUGIN);
	private final Image moduleImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_EXT_MODULE);
	
	@Override
	public Image getImage(Object element) {
		if (element instanceof JoomlaExtensionProject) {
			return projectImage;
		} if (element instanceof BasicExtensionModel) {
			switch (((BasicExtensionModel) element).getType()) {
				case COMPONENT:
					return componentImage;
				case PLUGIN:
					return pluginImage;
				case MODULE:
					return moduleImage;
			}
		}
		return super.getImage(element);
	}
	
	@Override
	public String getText(Object element) {
		if (element instanceof JoomlaExtensionProject) {
			return ((JoomlaExtensionProject) element).getProject().getName();
		} else if (element instanceof BasicExtensionModel) {
			return ((BasicExtensionModel) element).getName();
		}
		return super.getText(element);
	}
}