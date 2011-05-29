package com.schmeedy.pdt.joomla.core.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	private static final List<String> JOOMLA_INSTALLATION_FOLDERS = Arrays.asList(new String[] {
			"administrator", "components", "libraries", "modules", "plugins", "templates"
	}); 
	
	private static final Pattern CHANGELOG_VERSION_LINE_PATTERN = Pattern.compile("-+ *([1-9]\\.[0-9]+\\.[0-9]+).*Release.*-+");
	
	private static ValidationStatusAndVersionInfo errorStatus(String message, Exception e) {
		return new ValidationStatusAndVersionInfo(new Status(IStatus.ERROR, BUNDLE_ID, message, e), null, null);
	}

	private static ValidationStatusAndVersionInfo warningStatus(String message) {
		return new ValidationStatusAndVersionInfo(new Status(IStatus.WARNING, BUNDLE_ID, message), null, null);
	}
	
	public ValidationStatusAndVersionInfo validate(File joomlaRootDir) {
		if (!joomlaRootDir.exists()) {
			return errorStatus("Given directory does not exist.", null);
		}
		if (!isJoomlaDirectoryStructure(joomlaRootDir)) {
			return errorStatus("Directory does not contain Joomla! installation - unfamiliar directory structure.", null);
		}
		final File joomlaManifestFile = new File(joomlaRootDir, "joomla.xml");
		if (joomlaManifestFile.exists()) {
			return validateOneSixInstallation(joomlaManifestFile);
		} else {
			return validateLegacyInstallation(joomlaRootDir);
		}
	}
	
	private boolean isJoomlaDirectoryStructure(File joomlaRootDir) {
		return Arrays.asList(joomlaRootDir.list()).containsAll(JOOMLA_INSTALLATION_FOLDERS);
	}

	private ValidationStatusAndVersionInfo validateLegacyInstallation(File joomlaRootDir) {
		final ValidationStatusAndVersionInfo cannotDetermineVersion = warningStatus("Failed to auto-detect Joomla! version.");

		final File changelog = new File(joomlaRootDir, "CHANGELOG.php");
		if (!changelog.exists() || !changelog.canRead()) {
			return cannotDetermineVersion;
		}
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(changelog)));
			String line;
			while ((line = reader.readLine()) != null) {
				final Matcher matcher = CHANGELOG_VERSION_LINE_PATTERN.matcher(line);
				if (matcher.matches()) {
					return okStatus(matcher.group(1));
				}
			}
			return cannotDetermineVersion;
		} catch (final Exception e) {
			return cannotDetermineVersion;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (final IOException ignore) {}
			}
		}
	}

	private ValidationStatusAndVersionInfo validateOneSixInstallation(File joomlaManifestFile) {
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
			return okStatus(exactVersion);
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

	private ValidationStatusAndVersionInfo okStatus(final String exactVersion) {
		final MajorJoomlaVersion majorVersion = getMajorVersion(exactVersion);
		if (majorVersion == null) {
			return errorStatus("Unsupported Joomla! version - " + exactVersion + ". Only 1.5.x and 1.6.x are supported.", null);
		}
		return new ValidationStatusAndVersionInfo(Status.OK_STATUS, majorVersion, exactVersion);
	}

	private MajorJoomlaVersion getMajorVersion(final String exactVersion) {
		if (exactVersion.startsWith("1.5")) {
			return MajorJoomlaVersion.ONE_FIVE;
		} else if (exactVersion.startsWith("1.6")) {
			return MajorJoomlaVersion.ONE_SIX;
		}
		return null;
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
