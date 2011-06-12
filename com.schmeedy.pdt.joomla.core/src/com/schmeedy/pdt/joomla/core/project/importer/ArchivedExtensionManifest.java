package com.schmeedy.pdt.joomla.core.project.importer;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;

public class ArchivedExtensionManifest {

	private final BasicExtensionModel model;
	
	private final IArchiveEntry archiveEntry;

	public ArchivedExtensionManifest(BasicExtensionModel model, IArchiveEntry archiveEntry) {
		this.model = model;
		this.archiveEntry = archiveEntry;
	}

	public BasicExtensionModel getModel() {
		return model;
	}

	IArchiveEntry getArchiveEntry() {
		return archiveEntry;
	}
	
	@Override
	public String toString() {
		return model.toString() + "@" + archiveEntry.toString();
	}
	
}
