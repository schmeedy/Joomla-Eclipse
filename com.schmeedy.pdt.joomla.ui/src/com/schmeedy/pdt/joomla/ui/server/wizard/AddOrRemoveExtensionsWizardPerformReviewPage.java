package com.schmeedy.pdt.joomla.ui.server.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.server.IJoomlaDeployer;
import com.schmeedy.pdt.joomla.core.server.ServerUtils;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment;
import com.schmeedy.pdt.joomla.ui.JoomlaUiPlugin;

public class AddOrRemoveExtensionsWizardPerformReviewPage extends WizardPage {

	private final IDeploymentChangeRequestProvider changeRequestProvider;
	private final DeploymentRuntime targetRuntime;
	private final IJoomlaDeployer deployer;
	
	private boolean visible = false;
	
	public AddOrRemoveExtensionsWizardPerformReviewPage(IDeploymentChangeRequestProvider changeRequestProvider, DeploymentRuntime targetRuntime, IJoomlaDeployer deployer) {
		super("Add or remove extensions - results");
		this.changeRequestProvider = changeRequestProvider;
		this.targetRuntime = targetRuntime;
		this.deployer = deployer;
		setDescription("Review result of requested additions / removals");
		setTitle("Add or remove extensions");
		setPageComplete(false);
	}
	
	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container); 
	}
	
	@Override
	public void setVisible(boolean visible) {
		final boolean madeVisible = !this.visible && visible;
		super.setVisible(visible);
		if (madeVisible) {
			processChangeRequestsAndShowResult();
			setPageComplete(true);
		}
		this.visible = visible;
	}

	private void processChangeRequestsAndShowResult() {
		try {
			getContainer().run(true, false, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException {
					try {
						final List<DeploymentChangeRequest> changeRequests = changeRequestProvider.getDeploymentChangeRequests();
						progressMonitor.beginTask("Processing requested changes to deployment.", changeRequests.size() * 1000);
						for (final DeploymentChangeRequest changeRequest : changeRequests) {
							final IStatus processingResult;
							switch (changeRequest.getType()) {
								case INSTALL:
									processingResult = installExtension(changeRequest.getExtension(), new SubProgressMonitor(progressMonitor, 1000));
									break;
								case UNINSTALL:
									processingResult = uninstallExtension(changeRequest.getExtension(), new SubProgressMonitor(progressMonitor, 1000));
									break;
								default:
									continue; // illegal change request
							}
							System.out.println(processingResult);
						}
					} finally {
						progressMonitor.done();
					}
				}
			});
		} catch (final InvocationTargetException e) {
			JoomlaUiPlugin.getInstance().logError("Exception when processing deployment change requests.", e);
			return;
		} catch (final InterruptedException e) {
			return;
		}
	}

	private IStatus installExtension(BasicExtensionModel extension, IProgressMonitor progressMonitor) {
		return deployer.install(extension, targetRuntime, progressMonitor);
	}
	
	private IStatus uninstallExtension(BasicExtensionModel extension, SubProgressMonitor progressMonitor) {
		final JoomlaExtensionDeployment deployment = ServerUtils.getExtensionDeployment(extension, targetRuntime);
		return deployer.uninstall(deployment, progressMonitor);
	}

	@Override
	public IWizardPage getPreviousPage() {
		return null; // don't allow going back
	}
	
}
