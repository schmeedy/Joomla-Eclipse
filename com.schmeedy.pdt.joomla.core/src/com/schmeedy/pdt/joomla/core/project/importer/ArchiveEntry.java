package com.schmeedy.pdt.joomla.core.project.importer;

import java.io.InputStream;

import org.eclipse.core.runtime.IPath;

public interface ArchiveEntry {

	ArchiveFile getArchiveFile();
	
	IPath getPath();
	
	boolean isDirectory();
	
	InputStream openStream() throws ArchiveException;

}
