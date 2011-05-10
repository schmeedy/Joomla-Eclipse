package com.schmeedy.pdt.joomla.core.project.builder;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;

import com.schmeedy.pdt.joomla.core.JoomlaCorePlugin;

class ResourceSynchronizer {

	private final int BUFFER_SIZE = 0x1000; // 4K

	public void copy(final IResource source, final FileOrFolder destination, final IProgressMonitor progressMonitor) {
		final File destinationFile = destination.getFile();
		if (destination.isFolder()) {
			if (!(source instanceof IFolder)) {
				JoomlaCorePlugin.logWarning("Resource " + source + " is listed as folder in the manifest file, but it's a "
						+ source.getClass().getSimpleName());
				if (source instanceof IFile) {
					copy((IFile) source, destinationFile, progressMonitor);
				}
				return;
			}
			final IFolder folder = (IFolder) source;
			copy(folder, destinationFile, progressMonitor);
		} else {
			if (!(source instanceof IFile)) {
				JoomlaCorePlugin.logWarning("Resource " + source + " is listed as file in the manifest file, but it's a "
						+ source.getClass().getSimpleName());
				if (source instanceof IFolder) {
					copy((IFolder) source, destinationFile, progressMonitor);
				}
				return;
			}
			copy((IFile) source, destinationFile, progressMonitor);
		}
	}

	public void remove(final FileOrFolder destination) {
		System.out.println("REMOVE " + destination.getFile());
		delete(destination.getFile());
	}

	private boolean delete(File fileOrDirectory) {
		if (fileOrDirectory.isDirectory()) {
			final String[] children = fileOrDirectory.list();
			for (int i = 0; i < children.length; i++) {
				final boolean success = delete(new File(fileOrDirectory, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		return fileOrDirectory.delete();
	}

	private void copy(final IFolder sourceFolder, final File destinationFile, final IProgressMonitor progressMonitor) {
		boolean progressMonitoring = false;
		try {
			final AtomicInteger fileCounter = new AtomicInteger();
			sourceFolder.accept(new IResourceVisitor() {
				@Override
				public boolean visit(IResource resource) throws CoreException {
					if (resource instanceof IFile) {
						final IFile fileHandle = (IFile) resource;
						if (!fileHandle.getName().startsWith(".")) {
							fileCounter.incrementAndGet();
						}
					}
					return resource instanceof IFolder;
				}
			});
			if (fileCounter.get() == 0) {
				return;
			}
			progressMonitor.beginTask("Copy resources from " + sourceFolder, fileCounter.get() * 1000);
			progressMonitoring = true;

			sourceFolder.accept(new IResourceVisitor() {
				@Override
				public boolean visit(IResource resource) throws CoreException {
					if (resource instanceof IFile) {
						final IFile fileHandle = (IFile) resource;
						// skip hidden files not explicitly named in manifest
						if (fileHandle.getName().startsWith(".")) {
							return false;
						}
						final String suffixPath = resource.getProjectRelativePath()
								.removeFirstSegments(sourceFolder.getProjectRelativePath().segmentCount()).toString();
						final File target = new File(destinationFile, suffixPath);
						copy(fileHandle, target, new SubProgressMonitor(progressMonitor, 1000));
					}
					return resource instanceof IFolder;
				}
			});
		} catch (final CoreException e) {
			JoomlaCorePlugin.logError("Exception when visiting resource tree.", e);
		} finally {
			if (progressMonitoring) {
				progressMonitor.done();
			}
		}
	}

	private void copy(IFile source, File destination, IProgressMonitor progressMonitor) {
		final File targetDir = destination.getParentFile();
		if (!targetDir.exists()) {
			targetDir.mkdirs();
		}
		if (!targetDir.canWrite()) {
			JoomlaCorePlugin.logError(targetDir + " is not accessible for writing.");
			return;
		}
		try {
			final IFileStore sourceStore = EFS.getStore(source.getLocationURI());
			final IFileInfo sourceInfo = sourceStore.fetchInfo();
			if (destination.lastModified() < sourceInfo.getLastModified()) {
				System.out.println("COPY (" + (destination.exists() ? "+" : "-") + ") " + source + " TO " + destination);
				doCopy(source, sourceInfo, destination, progressMonitor);
			}
		} catch (final IOException e) {
			JoomlaCorePlugin.logError("IOException when copying file from workspace to Joomla!.", e);
		} catch (final CoreException e) {
			JoomlaCorePlugin.log(e.getStatus());
		}
	}

	private void doCopy(IFile source, IFileInfo sourceInfo, File destination, IProgressMonitor progressMonitor) throws IOException, CoreException {
		final int totalWork = (int) sourceInfo.getLength() / BUFFER_SIZE;
		InputStream from = null;
		OutputStream to = null;
		try {
			progressMonitor.beginTask("Copy " + source.getName() + " to Joomla!", totalWork);
			from = source.getContents();
			to = new FileOutputStream(destination);
			final byte[] buf = new byte[BUFFER_SIZE];
			while (true) {
				final int r = from.read(buf);
				if (r == -1) {
					break;
				}
				to.write(buf, 0, r);
				progressMonitor.worked(1);
			}
		} finally {
			quietClose(from);
			quietClose(to);
			progressMonitor.done();
		}
	}

	private void quietClose(Closeable closeable) {
		try {
			closeable.close();
		} catch (final Exception ignore) {
		}
	}

}
