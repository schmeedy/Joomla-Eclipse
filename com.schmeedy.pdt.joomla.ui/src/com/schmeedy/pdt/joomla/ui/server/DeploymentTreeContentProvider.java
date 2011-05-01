package com.schmeedy.pdt.joomla.ui.server;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;

import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage;

public class DeploymentTreeContentProvider extends ObservableListTreeContentProvider {

	public DeploymentTreeContentProvider() {
		super(new DeploymentTreeObservableFactory(), new DeploymentTreeStructureAdvisor());
	}

	private static class DeploymentTreeObservableFactory implements IObservableFactory {
		private final IEMFListProperty deployedExtensionsProperty = EMFProperties.list(JoomlaServerConfigurationPackage.Literals.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS);
		
		@Override
		public IObservable createObservable(Object target) {
			if (target instanceof IObservableList) {
				return (IObservable) target;
			} else if (target instanceof DeploymentRuntime) {
				return deployedExtensionsProperty.observe(target);
			}
			return null;
		}
	}
	
	private static class DeploymentTreeStructureAdvisor extends TreeStructureAdvisor {
		@Override
		public Object getParent(Object element) {
			if (element instanceof JoomlaExtensionDeployment) {
				return ((JoomlaExtensionDeployment) element).getRuntime();
			}
			return null;
		}
	}
	
}
