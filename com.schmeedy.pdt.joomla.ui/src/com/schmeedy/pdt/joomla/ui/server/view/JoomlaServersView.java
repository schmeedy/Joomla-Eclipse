package com.schmeedy.pdt.joomla.ui.server.view;


import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;

import com.schmeedy.pdt.joomla.core.server.IJoomlaDeployer;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage;
import com.schmeedy.pdt.joomla.ui.server.DeploymentTreeContentProvider;
import com.schmeedy.pdt.joomla.ui.server.DeploymentTreeLabelProvider;
import com.schmeedy.pdt.service.registry.ServiceRegistry;

/*
 * tree data binding code is based on http://tomsondev.bestsolution.at/2009/06/08/galileo-emf-databinding-–-part-3/
 */
public class JoomlaServersView extends ViewPart {
	
	private final IJoomlaDeployer deployer = ServiceRegistry.getInstance().getService(IJoomlaDeployer.class);
	private final DeploymentDescriptor deploymentDescriptor = deployer.getDeploymentDescriptor();
	private TreeViewer deploymentTreeViewer;
	private IObservableList inputObservable;
	
	public JoomlaServersView() {}

	@Override
	public void createPartControl(Composite parent) {
		final GridLayout gl_parent = new GridLayout(1, false);
		gl_parent.marginWidth = 0;
		gl_parent.marginHeight = 0;
		parent.setLayout(gl_parent);
		
		deploymentTreeViewer = new TreeViewer(parent, SWT.BORDER);
		final Tree tree = deploymentTreeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		{ // configure tree viewer
			final ObservableListTreeContentProvider contentProvider = new DeploymentTreeContentProvider();
			deploymentTreeViewer.setContentProvider(contentProvider);
			deploymentTreeViewer.setLabelProvider(new DeploymentTreeLabelProvider(contentProvider.getKnownElements()));
			
			inputObservable = EMFProperties.list(JoomlaServerConfigurationPackage.Literals.DEPLOYMENT_DESCRIPTOR__RUNTIMES).observe(deploymentDescriptor);
			deploymentTreeViewer.setInput(inputObservable);
			deploymentTreeViewer.expandAll();
		}
		
		{ // initialize context menu
			final MenuManager menuManager = new MenuManager();
			menuManager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			
			final Control control = deploymentTreeViewer.getControl();
			final Menu menu = menuManager.createContextMenu(control);
			control.setMenu(menu);
			getViewSite().registerContextMenu(menuManager, deploymentTreeViewer);
		}
		
		getSite().setSelectionProvider(deploymentTreeViewer);
	}

	@Override
	public void setFocus() {
		deploymentTreeViewer.getTree().setFocus();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		if (inputObservable != null) {
			inputObservable.dispose();		
		}
	}

}
