package com.schmeedy.pdt.joomla.core.project.impl;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	
	private static final int BUFFER_SIZE = 0x1000; // 4K
	
	public static void copy(InputStream from, OutputStream to) throws IOException {
		final byte[] buf = new byte[BUFFER_SIZE];
		while (true) {
			final int r = from.read(buf);
			if (r == -1) {
				break;
			}
			to.write(buf, 0, r);
		}
	}

	public static void quietClose(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (final Exception ignore) {}
		}
	}
	
}
