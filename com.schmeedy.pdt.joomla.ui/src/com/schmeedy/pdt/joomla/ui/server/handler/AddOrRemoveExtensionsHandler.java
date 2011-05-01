package com.schmeedy.pdt.joomla.ui.server.handler;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.schmeedy.pdt.joomla.core.project.IJoomlaProjectManager;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaExtensionProject;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.ui.JoomlaUiPlugin;
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
			try {
				new ProgressMonitorDialog(shell).run(true, false, new IRunnableWithProgress() {
					@Override
					public void run(IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException {
						final IStatus sessionStatus = runtime.getHttpSession().getSessionStatus(progressMonitor);
						
						shell.getDisplay().asyncExec(new Runnable() {
							@Override
							public void run() {
								if (sessionStatus.getSeverity() < IStatus.ERROR) {
									openWizard(runtime, shell, extensionProjects);
								} else {
									final MessageBox errorDialog = new MessageBox(shell, SWT.ICON_ERROR| SWT.OK);
									errorDialog.setMessage(sessionStatus.getMessage());
									errorDialog.setText("Cannot talk to Joomla! server");
									errorDialog.open();
								}
							}
						});
					}
				});
			} catch (final InvocationTargetException e) {
				JoomlaUiPlugin.getInstance().logError("Exception when testing Joomla! connectivity.", e);
				return null;
			} catch (final InterruptedException e) {
				return null;
			}
		}
		
		return null;
	}

	private void openWizard(final DeploymentRuntime runtime, final Shell shell, final List<JoomlaExtensionProject> extensionProjects) {
		final AddOrRemoveExtensionsWizard wizard = new AddOrRemoveExtensionsWizard(extensionProjects, runtime);
		final WizardDialog dialog = new WizardDialog(shell, wizard);
		dialog.setTitle("Add or Remove Extensions");
		dialog.open();
	}

}
