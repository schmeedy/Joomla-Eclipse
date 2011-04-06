package com.schmeedy.pdt.joomla.ui.server.handler;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.schmeedy.pdt.joomla.core.server.IJoomlaServerManager;
import com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;
import com.schmeedy.pdt.service.registry.ServiceRegistry;

public class DeleteDeploymentRuntimeHandler extends AbstractHandler {

	private final IJoomlaServerManager serverManager = ServiceRegistry.getInstance().getService(IJoomlaServerManager.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final StructuredSelection selection = (StructuredSelection) HandlerUtil.getCurrentSelection(event);
		final DeploymentRuntime runtime = (DeploymentRuntime) selection.getFirstElement();
		
		final Shell shell = HandlerUtil.getActiveShell(event);
		final MessageBox confirmationDialog = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
		confirmationDialog.setMessage("Are you sure you want to remove " + runtime.getServer().getName() + "?");
		confirmationDialog.setText("Remove Joomla! Server Configuration");
		final int result = confirmationDialog.open();
		if (result == SWT.NO) {
			return null;
		}
		
		final String serverId = runtime.getServer().getId();
		final AvailableServers configuredServers = serverManager.getAvailableServers();
		boolean serverRemoved = false;
		final Iterator<LocalJoomlaServer> i = configuredServers.getServers().iterator();
		while (i.hasNext()) {
			final LocalJoomlaServer server = i.next();
			if (serverId.equals(server.getId())) {
				i.remove();
				serverRemoved = true;
			}
		}
		if (serverRemoved) {
			serverManager.updateAvailableServers(configuredServers);
		}
				
		return null;
	}

}
