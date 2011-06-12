package com.schmeedy.pdt.joomla.core.project.importer;

import java.io.File;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

public class JoomlaExtensionPackageImporterImpl implements IJoomlaExtensionPackageImporter {

	private final ExtensionPackageScanner extensionPackageScanner = new ExtensionPackageScanner();
	
	private final ExtensionImporter extensionImporter = new ExtensionImporter();
	
	@Override
	public List<ArchivedExtensionManifest> findExtensionManifests(File extensionArchive, IProgressMonitor progresMonitor) {
		return extensionPackageScanner.findExtensionManifests(extensionArchive, progresMonitor);
	}
	
	@Override
	public void importExtension(ArchivedExtensionManifest extension, File destinationDir, IProgressMonitor progressMonitor) throws ExtensionImportException {
		extensionImporter.importExtension(extension, destinationDir, progressMonitor);
	}

}
