package com.schmeedy.pdt.joomla.core.project.importer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.content.IContentDescriber;

import com.schmeedy.pdt.joomla.core.JoomlaCorePlugin;
import com.schmeedy.pdt.joomla.core.project.impl.BasicExtensionModelParser;
import com.schmeedy.pdt.joomla.core.project.impl.BasicExtensionModelParser.ParsingException;
import com.schmeedy.pdt.joomla.core.project.impl.IOUtils;
import com.schmeedy.pdt.joomla.core.project.impl.JoomlaExtensionManifestContentTypeDescriber;
import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionResource;

class ExtensionPackageScanner {

private final File TMP_DIR = new File(new File(System.getProperty("java.io.tmpdir")), "eclipse" + File.separator + "joomla");
	
	private final JoomlaExtensionManifestContentTypeDescriber manifestContentTypeDescriber = new JoomlaExtensionManifestContentTypeDescriber();

	private final BasicExtensionModelParser extensionModelParser = new BasicExtensionModelParser();

	List<ArchivedExtensionManifest> findExtensionManifests(File extensionArchive, IProgressMonitor progresMonitor) {
		final ArchiveFile archiveFile = createArchiveFile(extensionArchive);
		try {
			return findExtensionManifests(archiveFile, progresMonitor);
		} finally {
			archiveFile.close();
		}
	}
	
	private List<ArchivedExtensionManifest> findExtensionManifests(ArchiveFile archiveFile, IProgressMonitor progresMonitor)
			throws ArchiveException {
		
		final List<ArchivedExtensionManifest> manifests = new LinkedList<ArchivedExtensionManifest>();
		try {
			progresMonitor.beginTask("Scan archive for extension manifests.", archiveFile.getNumberOfEntries() * 1000);
			for (final ArchiveEntry entry : archiveFile) {
				if (isManifestFileEntry(entry)) {
					final BasicExtensionModel model = parseExtensionModel(entry);
					if (model.getType() == null) {
						JoomlaCorePlugin.logWarning("No type found for extension " + entry);
						progresMonitor.worked(1000);
						continue;
					}
					switch (model.getType()) {
						case PACKAGE:
							final List<ArchivedExtensionManifest> manifestsInPackage = findExtensionManifestsInJoomlaPackage(model, archiveFile, progresMonitor);
							manifests.addAll(manifestsInPackage);
							break;
						case UNKNOWN:
							progresMonitor.worked(1000);
							JoomlaCorePlugin.logWarning("Unknown extension type for extension " + entry);
							continue;
						default: 
							manifests.add(new ArchivedExtensionManifest(model, entry));
					}
				} else {
					progresMonitor.worked(1000);
				}
			}
		} finally {
			progresMonitor.done();
		}
		return manifests;
	}

	private List<ArchivedExtensionManifest> findExtensionManifestsInJoomlaPackage(BasicExtensionModel packageManifest, ArchiveFile archiveFile,
			IProgressMonitor progresMonitor) {
		
		if (packageManifest.getResources().isEmpty()) {
			return Collections.emptyList();
		}
		final List<ArchivedExtensionManifest> archivedManifests = new ArrayList<ArchivedExtensionManifest>();
		
		try {
			progresMonitor.beginTask("Scan Joomla! package for contained extensions.", packageManifest.getResources().size() * 1000);
			for (final ExtensionResource resource : packageManifest.getResources()) {
				final ArchiveEntry entry = archiveFile.getEntry(resource.getManifestRelativePath());
				if (entry == null) {
					progresMonitor.worked(1000);
					continue;
				}
				
				final ArchiveFile extensionArchive = copyExtensionFromArchiveToTmpDir(entry, new SubProgressMonitor(progresMonitor, 200));
				if (extensionArchive != null) {
					try {
						final List<ArchivedExtensionManifest> extensionManifest = findExtensionManifests(extensionArchive, new SubProgressMonitor(progresMonitor, 800));
						archivedManifests.addAll(extensionManifest);
					} finally {
						extensionArchive.close();
					}
				} else {
					progresMonitor.worked(800);
				}
			}
			return archivedManifests;
		} finally {
			progresMonitor.done();
		}
	}
	
	private ArchiveFile copyExtensionFromArchiveToTmpDir(ArchiveEntry packageEntry, IProgressMonitor progressMonitor) {
		InputStream in = null;
		OutputStream out = null;
		try {
			progressMonitor.beginTask("Copy extension package to temporary dir.", 1000);
			
			if (!TMP_DIR.exists()) {
				TMP_DIR.mkdirs();
			}
			
			final File archiveTmpFile = File.createTempFile("extension", packageEntry.getPath().lastSegment(), TMP_DIR);
			archiveTmpFile.deleteOnExit();
			progressMonitor.worked(200);
			
			in = packageEntry.openStream();
			out = new FileOutputStream(archiveTmpFile);
			IOUtils.copy(in, out);
			progressMonitor.worked(800);
			
			try {
				return createArchiveFile(archiveTmpFile);
			} catch (final UnsupportedArchiveTypeException e) {
				JoomlaCorePlugin.logError(e.getMessage(), e);
				return null;
			}
		} catch (final Exception e) {
			JoomlaCorePlugin.logError("Error when scanning Joomla! extension embedded in archive.", e);
			return null;
		} finally {
			IOUtils.quietClose(in);
			IOUtils.quietClose(out);
			progressMonitor.done();
		}
	}
	
	private ArchiveFile createArchiveFile(File file) {
		if (file.getName().endsWith(".zip") || file.getName().endsWith(".phar")) {
			return new ZipArchiveFile(file);
		} else {
			throw new UnsupportedArchiveTypeException("Unsupported archive type (matched by file extension): " + file.getName());
		}
	}

	private BasicExtensionModel parseExtensionModel(ArchiveEntry entry) {
		final InputStream in = entry.openStream();
		try {
			final BasicExtensionModel model = extensionModelParser.parse(in, entry.getPath().lastSegment());
			if (model != null) {
				model.setManifestPath(entry.getPath());
			}
			return model;
		} catch (final ParsingException e) {
			JoomlaCorePlugin.logError("Exception parsing Joomla! extension manifest.", e);
			// be fault tolerant in this case
		}
		return null;
	}

	private boolean isManifestFileEntry(ArchiveEntry entry) throws ArchiveException {
		if (entry.getPath().lastSegment().endsWith(".xml")) {
			InputStream in = null;
			try {
				in = entry.openStream();
				final int result = manifestContentTypeDescriber.describe(in, null);
				return result == IContentDescriber.VALID;
			} catch (final IOException e) {
				JoomlaCorePlugin.logError("Exception reading archive entry during content type description.", e);
				return false; // be fault tolerant in this case
			} finally {
				IOUtils.quietClose(in);
			}
		} else {
			return false;
		}
	}
	
}
