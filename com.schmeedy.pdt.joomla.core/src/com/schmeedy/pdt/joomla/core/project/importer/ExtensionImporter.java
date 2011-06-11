package com.schmeedy.pdt.joomla.core.project.importer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

import com.schmeedy.pdt.joomla.core.project.impl.IOUtils;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionResource;

class ExtensionImporter {
	
	void importExtension(ArchivedExtensionManifest extension, File destinationDir, IProgressMonitor progressMonitor) throws ExtensionImportException {
		final ArchiveEntry manifestEntry = extension.getArchiveEntry();
		final ArchiveFile archiveFile = manifestEntry.getArchiveFile();
		final BasicExtensionModel model = extension.getModel();
		
		try {			
			archiveFile.reopen();
			progressMonitor.beginTask("Import files from extension package.", archiveFile.getNumberOfEntries() * 100);
			copyFile(manifestEntry, new File(destinationDir, manifestEntry.getPath().lastSegment()));
			
			final IPath manifestContainerPath = manifestEntry.getPath().removeLastSegments(1).makeAbsolute();
			
			final Map<IPath, ExtensionResource> resourceMap = new HashMap<IPath, ExtensionResource>();
			for (final ExtensionResource resource : model.getResources()) {
				resourceMap.put(resource.getFullPath().makeAbsolute(), resource);
			}
			
			for (final ArchiveEntry archiveEntry : archiveFile) {
				if (archiveEntry.isDirectory()) {
					progressMonitor.worked(100);
					continue;
				}
				final IPath fullPath = archiveEntry.getPath().makeAbsolute();
				IPath path = fullPath;
				while (!path.makeRelative().isEmpty()) {
					if (resourceMap.containsKey(path)) {
						copyFile(archiveEntry, new File(destinationDir, fullPath.makeRelativeTo(manifestContainerPath).makeRelative().toString()));
						break;
					}
					path = path.removeLastSegments(1);
				}
				progressMonitor.worked(100);
			}
		} finally {
			archiveFile.close();
			progressMonitor.done();
		}
	}

	private void copyFile(ArchiveEntry fileEntry, File target) throws ExtensionImportException {
		InputStream in = null;
		OutputStream out = null;
		try {
			if (target.exists()) {
				target.delete();
			}
			if (!target.getParentFile().exists()) {
				target.getParentFile().mkdirs();
			}
			in = fileEntry.openStream();
			out = new FileOutputStream(target);
			IOUtils.copy(in, out);
		} catch (final Exception e) {
			throw new ExtensionImportException("Failed copying of " + fileEntry + " to " + target, e);
		} finally {
			IOUtils.quietClose(in);
			IOUtils.quietClose(out);
		}
	}
	
}
