package com.schmeedy.pdt.joomla.ui.server;

import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;

import com.schmeedy.pdt.joomla.common.ui.JoomlaCommonUiPlugin;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage;
import com.schmeedy.pdt.joomla.ui.server.view.ExtensionModelLabelProvider;

public class DeploymentTreeLabelProvider extends StyledCellLabelProvider {
	
	private final Image joomlaServerImage = JoomlaCommonUiPlugin.getInstance().getImage(JoomlaCommonUiPlugin.IMG_OBJ_JOOMLA);

	private final IMapChangeListener mapChangeListener = new IMapChangeListener() {
		@Override
		public void handleMapChange(MapChangeEvent event) {
			final Set<?> affectedElements = event.diff.getChangedKeys();
			if (!affectedElements.isEmpty()) {
				final LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(DeploymentTreeLabelProvider.this,
						affectedElements.toArray());
				fireLabelProviderChanged(newEvent);
			}
		}
	};
	
	private final ExtensionModelLabelProvider extensionModelLabelProvider = new ExtensionModelLabelProvider();

	public DeploymentTreeLabelProvider(IObservableSet knownRuntimes) {
		final IObservableMap[] lpMaps = new IObservableMap[4];
		
		lpMaps[0] = EMFProperties.value(FeaturePath.fromList(
				JoomlaServerConfigurationPackage.Literals.DEPLOYMENT_RUNTIME__SERVER,
				JoomlaServerConfigurationPackage.Literals.LOCAL_JOOMLA_SERVER__NAME
			)).observeDetail(knownRuntimes);

		lpMaps[1] = EMFProperties.value(FeaturePath.fromList(
				JoomlaServerConfigurationPackage.Literals.DEPLOYMENT_RUNTIME__SERVER,
				JoomlaServerConfigurationPackage.Literals.LOCAL_JOOMLA_SERVER__EXACT_VERSION
		)).observeDetail(knownRuntimes);
		
		lpMaps[2] = EMFProperties.value(FeaturePath.fromList(
				JoomlaServerConfigurationPackage.Literals.JOOMLA_EXTENSION_DEPLOYMENT__EXTENSION,
				JoomlaProjectModelPackage.Literals.BASIC_EXTENSION_MODEL__TYPE
		)).observeDetail(knownRuntimes);

		lpMaps[3] = EMFProperties.value(FeaturePath.fromList(
				JoomlaServerConfigurationPackage.Literals.JOOMLA_EXTENSION_DEPLOYMENT__EXTENSION,
				JoomlaProjectModelPackage.Literals.BASIC_EXTENSION_MODEL__NAME
		)).observeDetail(knownRuntimes);
		
		init(lpMaps);
	}
	
	private void init(IObservableMap... attributeMaps) {
		for (int i = 0; i < attributeMaps.length; i++) {
			attributeMaps[i].addMapChangeListener(mapChangeListener);
		}
	}

	@Override
	public void update(ViewerCell cell) {
		if (cell.getElement() instanceof DeploymentRuntime) {
			final DeploymentRuntime runtime = (DeploymentRuntime) cell.getElement();
			final StyledString label = new StyledString(runtime.getServer().getName());
			final String versionDecoration = " [" + runtime.getServer().getExactVersion() + "]";
			label.append(versionDecoration, StyledString.QUALIFIER_STYLER);
			cell.setImage(joomlaServerImage);
			cell.setText(label.getString());
			cell.setStyleRanges(label.getStyleRanges());
		} else if (cell.getElement() instanceof JoomlaExtensionDeployment) {
			final BasicExtensionModel extension = ((JoomlaExtensionDeployment) cell.getElement()).getExtension();
			final Image image = extensionModelLabelProvider.getImage(extension);
			if (image != null) {
				cell.setImage(image);
			}
			final String text = extensionModelLabelProvider.getText(extension);
			if (text != null) {
				cell.setText(text);
			}
		}
	}
	
}