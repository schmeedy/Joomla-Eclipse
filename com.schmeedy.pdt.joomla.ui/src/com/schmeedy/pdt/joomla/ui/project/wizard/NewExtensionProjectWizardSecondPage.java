package com.schmeedy.pdt.joomla.ui.project.wizard;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.dltk.core.IBuildpathEntry;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.ui.wizards.NewElementWizardPage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.schmeedy.pdt.joomla.core.project.buildpath.JoomlaBuildpathUtils;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionType;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelFactory;
import com.schmeedy.pdt.joomla.core.server.ServerUtils;
import com.schmeedy.pdt.joomla.manifest.model.FileResource;
import com.schmeedy.pdt.joomla.manifest.model.FileSet;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifest;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestFactory;
import com.schmeedy.pdt.joomla.manifest.model.ManifestType;
import com.schmeedy.pdt.joomla.manifest.model.util.JoomlaExtensionManifestResourceFactoryImpl;
import com.schmeedy.pdt.joomla.ui.JoomlaUiPlugin;
import com.schmeedy.pdt.joomla.ui.buildpath.IBuildPathEntryListener;
import com.schmeedy.pdt.joomla.ui.buildpath.JoomlaBuildpathContainerBlock;
import com.schmeedy.pdt.joomla.ui.project.ExtensionProjectFactory;

public class NewExtensionProjectWizardSecondPage extends NewElementWizardPage {

	private static final String EMPTY_PHP_FILE_CONTENTS = "<?php \n\n?>";
	
	private final ExtensionProjectFactory projectFactory = new ExtensionProjectFactory();
	private final IExtensionManifestProvider manifestProvider;
	
	private Text projectNameText;
	private JoomlaBuildpathContainerBlock buildpathContainerBlock;
	
	private IBuildpathEntry buildPathEntry;
	
	private IScriptProject createdProject;

	public NewExtensionProjectWizardSecondPage(IExtensionManifestProvider manifestProvider) {
		super("New Joomla! Extension Project");
		setTitle("New Joomla! Extension Project");

		this.manifestProvider = manifestProvider;
		
		updateDescription(manifestProvider.getManifest());
	}

	private void updateDescription(final JoomlaExtensionManifest manifest) {
		final String extensionTypeName = manifest.getManifestType() == null || manifest.getManifestType() == ManifestType.UNKNOWN ? "extension" : manifest.getManifestType().getLiteral();
		setDescription("Configure Joomla! " + extensionTypeName + " project.");
	}
	
	private void updateProjectName(final JoomlaExtensionManifest manifest) {
		final BasicExtensionModel extension = JoomlaProjectModelFactory.eINSTANCE.createBasicExtensionModel();
		extension.setName(manifest.getName());
		extension.setSymbolicName(manifest.getName());
		extension.setType(toExtensionType(manifest.getManifestType()));
		projectNameText.setText(projectFactory.suggestProjectName(extension));
	}
	
	private ExtensionType toExtensionType(ManifestType manifestType) {
		return manifestType == null || manifestType == ManifestType.UNKNOWN ? ExtensionType.UNKNOWN : ExtensionType.valueOf(manifestType.name());
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			final JoomlaExtensionManifest manifest = manifestProvider.getManifest();
			if (projectNameText.getText() == null || "".equals(projectNameText.getText())) {
				updateProjectName(manifest);
			}
			updateDescription(manifest);
			validate();
		}
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		final Label lblProjectName = new Label(container, SWT.NONE);
		lblProjectName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblProjectName.setText("Project Name:");
		
		projectNameText = new Text(container, SWT.BORDER);
		projectNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		projectNameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validate();
			}
		});
		
		buildpathContainerBlock = new JoomlaBuildpathContainerBlock(JoomlaBuildpathUtils.newDefaultJoomlaContainerEntry());
		buildpathContainerBlock.addBuildPathEntryListener(new IBuildPathEntryListener() {
			@Override
			public void onBuildPathEntryChanged(IBuildpathEntry entry) {
				NewExtensionProjectWizardSecondPage.this.buildPathEntry = entry;
				validate();
			}
		});
		final Control buildpathContainerControl = buildpathContainerBlock.createControl(container);
		buildpathContainerControl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
	}
	
	private void validate() {
		if (buildPathEntry == null) {
			setErrorMessage("Joomla! API library is not configured.");
			setPageComplete(false);
			return;
		}
		
		if (projectNameText.getText() == null || projectNameText.getText().trim().length() == 0) {
			setErrorMessage("Project name cannot be empty.");
			setPageComplete(false);
			return;
		}
		
		final String projectName = projectNameText.getText().trim();
		
		for (final IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			if (projectName.toLowerCase().equals(project.getName().toLowerCase())) {
				setErrorMessage("Another project named '" + project.getName() + "' already exists in the workspace.");
				setPageComplete(false);
				return;
			}
		}
		
		setErrorMessage(null);
		setPageComplete(true);
	}
	
	public void performFinish(IProgressMonitor monitor) throws CoreException {		
		try {
			monitor.beginTask("Creating project and resources.",  4000);
			
			class SwtValues { // these values must be accessed through UI thread...
				String projectName;
				JoomlaExtensionManifest manifest;
			}
			final SwtValues swt = new SwtValues();
			getShell().getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					swt.projectName = projectNameText.getText().trim();
					swt.manifest = manifestProvider.getManifest();
				}
			});
			monitor.worked(1000);
			
			final String projectName = swt.projectName;
			final JoomlaExtensionManifest manifest = swt.manifest;
			final String cleanProjectName = ServerUtils.jfilterInputCleanCommand(projectName);
			
			final boolean jsSupport = manifest.getManifestType() == ManifestType.COMPONENT || manifest.getManifestType() == ManifestType.MODULE;
			createdProject = projectFactory.createJoomlaExtensionProject(projectName, buildPathEntry, jsSupport, new SubProgressMonitor(monitor, 1000));

			if (manifest.getManifestType() == ManifestType.MODULE || manifest.getManifestType() == ManifestType.PLUGIN) {
				final IFile extensionScriptFile = createdProject.getProject().getFile(cleanProjectName + ".php");
				extensionScriptFile.create(new ByteArrayInputStream(EMPTY_PHP_FILE_CONTENTS.getBytes()), IFile.FORCE, new SubProgressMonitor(monitor, 1000));
				final FileSet fileSet = JoomlaExtensionManifestFactory.eINSTANCE.createFileSet();
				manifest.getFileSets().add(fileSet);
				final FileResource extensionScriptResource = JoomlaExtensionManifestFactory.eINSTANCE.createFileResource();
				if (manifest.getManifestType() == ManifestType.MODULE) {
					extensionScriptResource.setModule(cleanProjectName);
				} else {
					extensionScriptResource.setPlugin(cleanProjectName);
				}
				extensionScriptResource.setPath(extensionScriptFile.getName());
				fileSet.getFiles().add(extensionScriptResource);
			} else {
				monitor.worked(1000);
			}
			
			final URI manifestResourceUri = URI.createPlatformResourceURI(createdProject.getProject().getFullPath().append(cleanProjectName + ".xml").toString(), true);
			final Resource manifestResource = new JoomlaExtensionManifestResourceFactoryImpl().createResource(manifestResourceUri);
			manifestResource.getContents().add(manifest);
			try {
				manifestResource.save(Collections.singletonMap(XMLResource.OPTION_ENCODING, "UTF-8"));
				monitor.worked(1000);
			} catch (final IOException e) {
				throw new CoreException(JoomlaUiPlugin.getInstance().newErrorStatus("Failed to save Joomla! extension manifest.", e));
			}
		} finally {
			monitor.done();
		}
	}
	
	public IScriptProject getCreatedProject() {
		return createdProject;
	}

}
