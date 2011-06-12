package com.schmeedy.pdt.joomla.ui.buildpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.dltk.core.IBuildpathEntry;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.ui.wizards.IBuildpathContainerPage;
import org.eclipse.dltk.ui.wizards.IBuildpathContainerPageExtension;
import org.eclipse.dltk.ui.wizards.NewElementWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.schmeedy.pdt.joomla.core.project.buildpath.JoomlaBuildpathUtils;
import com.schmeedy.pdt.joomla.ui.JoomlaUiPlugin;

@SuppressWarnings("restriction")
public class JoomlaContainerWizardPage extends NewElementWizardPage implements IBuildpathContainerPage, IBuildpathContainerPageExtension, IBuildPathEntryListener {

	private static final IStatus OK_STATUS = JoomlaUiPlugin.getInstance().newOkStatus("Select how the Joomla! API library should be constructed");

	private IBuildpathEntry alreadyPresentJoomlaEntry;
	private IBuildpathEntry newEntry;
	
	private IScriptProject project;
	private IBuildpathEntry[] buildpath;

	private JoomlaBuildpathContainerBlock joomlaBuildpathContainerBlock;
	
	public JoomlaContainerWizardPage() {
		super("Joomla! API");
		setDescription(OK_STATUS.getMessage());
		setTitle("Add Joomla! API Library");
		setMessage("");
	}

	@Override
	public void initialize(IScriptProject project, IBuildpathEntry[] currentEntries) {
		this.project = project;
		this.buildpath = currentEntries;
		
		for (final IBuildpathEntry entry : buildpath) {
			if (JoomlaBuildpathUtils.isJoomlaContainerEntry(entry)) {
				alreadyPresentJoomlaEntry = entry;
				break;
			}
		}
	}
	
	@Override
	public void createControl(Composite parent) {
		final Composite wizardContainer = new Composite(parent, SWT.NULL);
		setControl(wizardContainer);
		final GridLayout gl_wizardContainer = new GridLayout(1, false);
		gl_wizardContainer.marginHeight = 0;
		gl_wizardContainer.marginWidth = 0;
		wizardContainer.setLayout(gl_wizardContainer);
		
		joomlaBuildpathContainerBlock = new JoomlaBuildpathContainerBlock(alreadyPresentJoomlaEntry);
		joomlaBuildpathContainerBlock.addBuildPathEntryListener(this);
		final Control buildpathContainerControl = joomlaBuildpathContainerBlock.createControl(wizardContainer);
		buildpathContainerControl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	}

	@Override
	public void onBuildPathEntryChanged(IBuildpathEntry entry) {
		if (entry == null) {
			newEntry = null;
			updateStatus(ValidationStatus.error("No Joomla! installation selected."));
		} else if (alreadyPresentJoomlaEntry == null) {
			newEntry = entry;
			updateStatus(OK_STATUS);
		} else if (alreadyPresentJoomlaEntry.getPath().equals(entry.getPath())) {
			newEntry = null;
			updateStatus(ValidationStatus.info("This entry is already present on the project's classpath."));
		} else {
			// there's been a warning about overriding current build path entry, but this wizard will most likely
			// be used for editing current entry and thus it's common situation and should not cause warnings
			newEntry = entry;
			updateStatus(OK_STATUS);
		}		
	}
	
	@Override
	public boolean finish() {
		return true;
	}

	@Override
	public IBuildpathEntry getSelection() {
		if (newEntry != null && alreadyPresentJoomlaEntry != null) {
			final List<IBuildpathEntry> entries = new ArrayList<IBuildpathEntry>(Arrays.asList(buildpath));
			entries.remove(alreadyPresentJoomlaEntry);
			try {
				project.setRawBuildpath(entries.toArray(new IBuildpathEntry[entries.size()]), null);
			} catch (final ModelException e) {
				JoomlaUiPlugin.getInstance().logError("Failed to remove buildpath entry. New Joomla! API container entry cannot be created.", e);
				return null;
			}
		}
		return newEntry;
	}

	@Override
	public void setSelection(IBuildpathEntry containerEntry) {}

	@Override
	public void dispose() {
		if (joomlaBuildpathContainerBlock != null) {
			joomlaBuildpathContainerBlock.dispose();
		}
	}
	
}
