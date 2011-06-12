package com.schmeedy.pdt.joomla.core.project.importer;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipException;

import org.apache.tools.zip.ZipEntry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class ZipArchiveEntry implements IArchiveEntry {

	private final ZipArchiveFile zipArchive;
	
	private final String zipEntryName;

	public ZipArchiveEntry(ZipArchiveFile zipArchive, ZipEntry zipEntry) {
		this.zipArchive = zipArchive;
		this.zipEntryName = zipEntry.getName();
	}
	
	@Override
	public IArchiveFile getArchiveFile() {
		return zipArchive;
	}
	
	@Override
	public IPath getPath() {
		return new Path(zipEntryName.replace("\\", "/"));
	}
	
	private ZipEntry getEntry() {
		// this may seem a little weird, but we cannot store ZipEntry directly cause it wouldn't work when the archive is re-opened.
		final ZipEntry entry = zipArchive.getZipFile().getEntry(zipEntryName);
		if (entry == null) {
			throw new ArchiveException("No entry named '" + zipEntryName + "' found in archive " + zipArchive);
		}
		return entry;
	}
	
	private InputStream openRawStream() throws ZipException, IOException {
		return  zipArchive.getZipFile().getInputStream(getEntry());
	}
	
	@Override
	public InputStream openStream() throws ArchiveException {
		try {
			// decoration to make InputStream resetable
			return new InputStream() {
				private InputStream delegate = openRawStream();

				@Override
				public int read() throws IOException {
					return delegate.read();
				}

				@Override
				public int hashCode() {
					return delegate.hashCode();
				}

				@Override
				public int read(byte[] b) throws IOException {
					return delegate.read(b);
				}

				@Override
				public boolean equals(Object obj) {
					return delegate.equals(obj);
				}

				@Override
				public int read(byte[] b, int off, int len) throws IOException {
					return delegate.read(b, off, len);
				}

				@Override
				public long skip(long n) throws IOException {
					return delegate.skip(n);
				}

				@Override
				public String toString() {
					return delegate.toString();
				}

				@Override
				public int available() throws IOException {
					return delegate.available();
				}

				@Override
				public void close() throws IOException {
					delegate.close();
				}

				@Override
				public void mark(int readlimit) {
					delegate.mark(readlimit);
				}

				@Override
				public void reset() throws IOException {
					delegate.close();
					delegate = openRawStream();
				}

				@Override
				public boolean markSupported() {
					return delegate.markSupported();
				}
				
			};
		} catch (final Exception e) {
			throw new ArchiveException("Exception reading ZIP archive entry.", e);
		}
	}
	
	@Override
	public boolean isDirectory() {
		return getEntry().isDirectory();
	}
	
	@Override
	public String toString() {
		return zipArchive.toString() + ":" + zipEntryName;
	}
	
}
