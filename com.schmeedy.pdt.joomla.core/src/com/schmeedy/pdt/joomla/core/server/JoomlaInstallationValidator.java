package com.schmeedy.pdt.joomla.core.server;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.schmeedy.pdt.joomla.core.server.cfg.MajorJoomlaVersion;

public class JoomlaInstallationValidator {

	private static final String BUNDLE_ID = "com.schmeedy.pdt.joomla.core";
	
	private static ValidationStatusAndVersionInfo errorStatus(String message, Exception e) {
		return new ValidationStatusAndVersionInfo(new Status(IStatus.ERROR, BUNDLE_ID, message, e), null, null);
	}
	
	public ValidationStatusAndVersionInfo validate(File joomlaRootDir) {
		if (!joomlaRootDir.exists()) {
			return errorStatus("Given directory does not exist.", null);
		}
		final File joomlaManifestFile = new File(joomlaRootDir, "joomla.xml");
		if (!joomlaManifestFile.exists()) {
			return errorStatus("Given directory is not a Joomla! root - the joomla.xml file is missing.", null);
		}
		if (!joomlaManifestFile.canRead()) {
			return errorStatus("Cannot read the joomla.xml file in the Joomla! root directory - check access rigts.", null);
		}
		
		XMLEventReader eventReader = null;
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(joomlaManifestFile);
			eventReader = XMLInputFactory.newInstance().createXMLEventReader(inputStream);
			final String exactVersion = parseExactVersion(eventReader);
			
			if (exactVersion == null) {
				return errorStatus("The joomla.xml file is missing version information.", null);
			}
			final MajorJoomlaVersion majorVersion;
			if (exactVersion.startsWith("1.5")) {
				majorVersion = MajorJoomlaVersion.ONE_FIVE;
			} else if (exactVersion.startsWith("1.6")) {
				majorVersion = MajorJoomlaVersion.ONE_SIX;
			} else {
				return errorStatus("Unsupported Joomla! version - " + exactVersion + ". Only 1.5.x and 1.6.x are supported.", null);
			}
			return new ValidationStatusAndVersionInfo(Status.OK_STATUS, majorVersion, exactVersion);
		} catch (final Exception e) {
			return errorStatus("Failed to parse the joomla.xml file.", e);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (eventReader != null) {
					eventReader.close();
				}
			} catch (final Exception ignore) {}
		}
	}

	private String parseExactVersion(XMLEventReader eventReader) throws XMLStreamException {
		int elementDepth = 0;
		String exactVersion = null;
		while (exactVersion == null && eventReader.hasNext()) {
			final XMLEvent event = eventReader.nextEvent();
			switch (event.getEventType()) {
				case XMLStreamConstants.START_ELEMENT:
					elementDepth++;
					if (elementDepth == 2 && "version".equals(event.asStartElement().getName().getLocalPart())) {
						exactVersion = eventReader.getElementText().trim();
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					elementDepth--;
					break;
			}
		}
		return exactVersion;
	}
	
	public static class ValidationStatusAndVersionInfo {
		private final IStatus status;
		private final MajorJoomlaVersion majorVersion;
		private final String exactVersion;
		
		public ValidationStatusAndVersionInfo(IStatus status, MajorJoomlaVersion majorVersion, String exactVersion) {
			this.status = status;
			this.majorVersion = majorVersion;
			this.exactVersion = exactVersion;
		}

		public IStatus getStatus() {
			return status;
		}

		public MajorJoomlaVersion getMajorVersion() {
			return majorVersion;
		}

		public String getExactVersion() {
			return exactVersion;
		}
	}
	
}
