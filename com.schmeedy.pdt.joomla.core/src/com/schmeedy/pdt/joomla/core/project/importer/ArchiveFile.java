package com.schmeedy.pdt.joomla.core.project.importer;

import org.eclipse.core.runtime.IPath;

public interface ArchiveFile extends Iterable<ArchiveEntry> {

	ArchiveEntry getEntry(IPath path);

	int getNumberOfEntries();

	void close();

	/**
	 * Re-opens closed file for further reading after the close() has been
	 * called. All ArchiveEntries previously returned must remain valid provided
	 * the underlying file has not been changed.
	 */
	void reopen() throws ArchiveException;

}
