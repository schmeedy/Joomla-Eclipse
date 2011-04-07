package com.schmeedy.pdt.joomla.ui.server.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.schmeedy.pdt.joomla.core.server.IJoomlaServerManager;
import com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;
import com.schmeedy.pdt.service.registry.ServiceRegistry;

public class RenameDeploymentRuntimeHandler extends AbstractHandler {

	private final IJoomlaServerManager serverManager = ServiceRegistry.getInstance().getService(IJoomlaServerManager.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final StructuredSelection selection = (StructuredSelection) HandlerUtil.getCurrentSelection(event);
		final DeploymentRuntime runtime = (DeploymentRuntime) selection.getFirstElement();
		
		final Shell shell = HandlerUtil.getActiveShell(event);
		final InputDialog dialog = new InputDialog(shell, "Rename Joomla! Server", "Enter new name for server configuration.", runtime.getServer().getName(), new IInputValidator() {
			@Override
			public String isValid(String newText) {
				if (newText == null || newText.trim().length() == 0) {
					return "Server name cannot be empty.";
				} else {
					return null;
				}
			}
		});
		final int result = dialog.open();
		if (result == SWT.CANCEL) {
			return null;
		}
		final String newName = dialog.getValue().trim();
		
		final String serverId = runtime.getServer().getId();
		final AvailableServers configuredServers = serverManager.getAvailableServers();
		for (final LocalJoomlaServer server : configuredServers.getServers()) {
			if (serverId.equals(server.getId())) {
				server.setName(newName);
			}
		}
		serverManager.updateAvailableServers(configuredServers);
		
		return null;
	}
	
}
