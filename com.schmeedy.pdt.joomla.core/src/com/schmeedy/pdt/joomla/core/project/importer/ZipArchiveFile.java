package com.schmeedy.pdt.joomla.core.project.importer;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class ZipArchiveFile implements IArchiveFile {

	private ZipFile zipFile;
	private final File zipFileHandle;
	
	public ZipArchiveFile(File file) {
		try {
			this.zipFileHandle = file;
			this.zipFile = new ZipFile(file);
		} catch (final IOException e) {
			throw new ArchiveException("Cannot read ZIP archive: " + file.getName(), e);
		}
	}
	
	ZipFile getZipFile() {
		return zipFile;
	}
	
	@Override
	public IArchiveEntry getEntry(IPath path) {
		@SuppressWarnings("unchecked")
		final Enumeration<ZipEntry> entries = zipFile.getEntries();
		while (entries.hasMoreElements()) {
			final ZipEntry entry = entries.nextElement();
			if (isEntryForPath(entry, path)) {
				return new ZipArchiveEntry(this, entry);
			}
		}
		return null;
	}
	
	private boolean isEntryForPath(ZipEntry entry, IPath path) {
		String entryName = entry.getName().replace("\\", "/");
		if (path.isAbsolute() && !entry.getName().startsWith("/")) {
			entryName = "/" + entryName;
		}
		return new Path(entryName).equals(path);
	}

	@Override
	public int getNumberOfEntries() {
		int i = 0;
		@SuppressWarnings("unchecked")
		final Enumeration<ZipEntry> e = zipFile.getEntries();
		while (e.hasMoreElements()) {
			e.nextElement();
			i++;
		}
		return i;
	}
	
	@Override
	public Iterator<IArchiveEntry> iterator() {
		return new Iterator<IArchiveEntry>() {
			@SuppressWarnings("unchecked")
			private final Enumeration<ZipEntry> zipEntries = zipFile.getEntries();
			
			@Override
			public boolean hasNext() {
				return zipEntries.hasMoreElements();
			}
			
			@Override
			public IArchiveEntry next() {
				if (!zipEntries.hasMoreElements()) {
					throw new IllegalStateException("This iterator has no more elements.");
				}
				return new ZipArchiveEntry(ZipArchiveFile.this, zipEntries.nextElement());
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	@Override
	public void close() {
		ZipFile.closeQuietly(zipFile); 
	}
	
	@Override
	public void reopen() {
		close();
		try {
			zipFile = new ZipFile(zipFileHandle);
		} catch (final IOException e) {
			throw new ArchiveException("Cannot re-open archive " + zipFileHandle, e);
		}
	}
	
	@Override
	public String toString() {
		return zipFileHandle.toString();
	}
	
}
