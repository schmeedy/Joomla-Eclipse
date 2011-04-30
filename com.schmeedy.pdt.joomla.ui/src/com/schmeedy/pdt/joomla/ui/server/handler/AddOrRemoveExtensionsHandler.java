package com.schmeedy.pdt.joomla.ui.server.handler;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.schmeedy.pdt.joomla.core.project.IJoomlaProjectManager;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.ui.server.wizard.AddOrRemoveExtensionsWizard;
import com.schmeedy.pdt.service.registry.ServiceRegistry;

public class AddOrRemoveExtensionsHandler extends AbstractHandler {

	private final IJoomlaProjectManager projectManager = ServiceRegistry.getInstance().getService(IJoomlaProjectManager.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final StructuredSelection selection = (StructuredSelection) HandlerUtil.getCurrentSelection(event);
		final DeploymentRuntime runtime = (DeploymentRuntime) selection.getFirstElement();
		
		final Shell shell = HandlerUtil.getActiveShell(event);
		final List<JoomlaExtensionProject> extensionProjects = projectManager.getExtensionProjects();
		if (extensionProjects.isEmpty() && runtime.getDeployedExtensions().isEmpty()) {
			final MessageBox notifyDialog = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
			notifyDialog.setMessage("No Joomla! extension can be found in workspace.");
			notifyDialog.setText("No extensions");
			notifyDialog.open();
		} else {
			final AddOrRemoveExtensionsWizard wizard = new AddOrRemoveExtensionsWizard(extensionProjects, runtime);
			final WizardDialog dialog = new WizardDialog(shell, wizard);
			dialog.open();
		}
		
		return null;
	}

}
