package com.schmeedy.pdt.joomla.core.project.builder;

import java.io.File;

class FileOrFolder {
	
	private final File file;
	private final boolean folder;

	public FileOrFolder(File file, boolean folder) {
		this.file = file;
		this.folder = folder;
	}

	public File getFile() {
		return file;
	}

	public boolean isFolder() {
		return folder;
	}
	
}