package com.schmeedy.pdt.joomla.ui.server.view;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.schmeedy.pdt.joomla.common.ui.JoomlaCommonUiPlugin;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.project.model.ManifestVersion;

public class ExtensionModelLabelProvider extends StyledCellLabelProvider {
	private final Image projectImage = PlatformUI.getWorkbench().getSharedImages().getImage(IDE.SharedImages.IMG_OBJ_PROJECT);
	
	private final Image componentImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_EXT_COMPONENT);
	private final Image pluginImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_EXT_PLUGIN);
	private final Image moduleImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_EXT_MODULE);
	
	@Override
	public void update(ViewerCell cell) {
		update(cell, cell.getElement());
	}
	
	public void update(ViewerCell cell, Object overrideElement) {
		if (overrideElement instanceof JoomlaExtensionProject) {
			final JoomlaExtensionProject extensionProject = (JoomlaExtensionProject) overrideElement;
			cell.setImage(projectImage);
			cell.setText(extensionProject.getProject().getName());
		} else if (overrideElement instanceof BasicExtensionModel) {
			final BasicExtensionModel extension = (BasicExtensionModel) overrideElement;
			switch (extension.getType()) {
				case COMPONENT:
					cell.setImage(componentImage);
					break;
				case PLUGIN:
					cell.setImage(pluginImage);
					break;
				case MODULE:
					cell.setImage(moduleImage);
					break;
			}
			
			final StyledString label = new StyledString(extension.getName());
			label.append(getVersionDecoration(extension), StyledString.QUALIFIER_STYLER);
			cell.setText(label.getString());
			cell.setStyleRanges(label.getStyleRanges());			
		}
	}

	private String getVersionDecoration(BasicExtensionModel extension) {
		final StringBuilder sb = new StringBuilder(" [");
		if (extension.getManifestVersion() == null || extension.getManifestVersion() == ManifestVersion.UNKNOWN) {
			sb.append("unknown manifest version");
		} else {
			final String versionLiteral = extension.getManifestVersion().getLiteral();
			sb.append(versionLiteral.substring(0, versionLiteral.lastIndexOf("."))).append(" native");
		}
		return sb.append("]").toString();
	}

}