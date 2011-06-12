package com.schmeedy.pdt.joomla.core.project.importer;

import java.io.File;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

public interface IJoomlaExtensionPackageImporter {

	List<ArchivedExtensionManifest> findExtensionManifests(File extensionArchive, IProgressMonitor progresMonitor);
	
	void importExtension(ArchivedExtensionManifest extension, File destinationDir, IProgressMonitor progressMonitor) throws ExtensionImportException;
	
}
