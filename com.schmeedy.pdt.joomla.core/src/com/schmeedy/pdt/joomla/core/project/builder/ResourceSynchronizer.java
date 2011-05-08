package com.schmeedy.pdt.joomla.core.project.builder;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

import com.schmeedy.pdt.joomla.core.JoomlaCorePlugin;

class ResourceSynchronizer {

	public void copy(final IResource source, final FileOrFolder destination) {
		final File destinationFile = destination.getFile();
		if (destination.isFolder()) {
			if (!(source instanceof IFolder)) {
				JoomlaCorePlugin.logWarning("Resource " + source + " is listed as folder in the manifest file, but it's a " + source.getClass().getSimpleName());
				if (source instanceof IFile) {
					copy((IFile) source, destinationFile);
				}
				return;
			}
			final IFolder folder = (IFolder) source;
			copy(folder, destinationFile);
		} else {
			if (!(source instanceof IFile)) {
				JoomlaCorePlugin.logWarning("Resource " + source + " is listed as file in the manifest file, but it's a " + source.getClass().getSimpleName());
				if (source instanceof IFolder) {
					copy((IFolder) source, destinationFile);
				}
				return;
			}
			copy((IFile) source, destinationFile);
		}
	}
	
	public void remove(final FileOrFolder destination) {
		System.out.println("REMOVE " + destination.getFile());
	}

	private void copy(final IFolder sourceFolder, final File destinationFile) {
		try {
			sourceFolder.accept(new IResourceVisitor() {
				@Override
				public boolean visit(IResource resource) throws CoreException {
					if (resource instanceof IFile) {
						final IFile fileHandle = (IFile) resource;
						// skip hidden files not explicitly named in manifest
						if (fileHandle.getName().startsWith(".")) {
							return false;
						}
						final String suffixPath = resource.getProjectRelativePath().removeFirstSegments(sourceFolder.getProjectRelativePath().segmentCount()).toString();
						final File target = new File(destinationFile, suffixPath);
						copy(fileHandle, target);
					}
					return resource instanceof IFolder;
				}
			});
		} catch (final CoreException e) {
			JoomlaCorePlugin.logError("Exception when visiting resource tree.", e);
		}
	}

	private void copy(IFile source, File file) {
//		final File targetDir = file.getParentFile();
//		if (!targetDir.exists()) {
//			targetDir.mkdirs();
//		}
//		if (!targetDir.canWrite()) {
//			JoomlaCorePlugin.logError(targetDir + " is not accessible for writing.");
//			return;
//		}
		System.out.println("COPY (" + (file.exists() ? "+" : "-") + ") " + source + " TO " + file);
	}
	
}
