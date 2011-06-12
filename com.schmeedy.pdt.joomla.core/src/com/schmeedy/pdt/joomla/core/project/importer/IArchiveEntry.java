package com.schmeedy.pdt.joomla.core.project.importer;

import java.io.InputStream;

import org.eclipse.core.runtime.IPath;

public interface IArchiveEntry {

	IArchiveFile getArchiveFile();
	
	IPath getPath();
	
	boolean isDirectory();
	
	InputStream openStream() throws ArchiveException;

}
