package com.schmeedy.pdt.joomla.core.project.impl;

import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.project.model.ExtensionType;
import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelFactory;
import com.schmeedy.pdt.joomla.core.project.model.ManifestVersion;

class BasicExtensionModelParser {

	private final JoomlaProjectModelFactory factory = JoomlaProjectModelFactory.eINSTANCE;
	
	public BasicExtensionModel parse(InputStream inputStream) throws ParsingException {
		final XMLEventReader eventReader;
		try {
			eventReader = XMLInputFactory.newInstance().createXMLEventReader(inputStream);
		} catch (final XMLStreamException e) {
			throw new ParsingException("Failed to create STAX reader.", e);
		}
		try {
			return doParse(eventReader);
		} catch (final XMLStreamException e) {
			throw new ParsingException("Exception while parsing extension model.", e);
		}
	}
	
	private BasicExtensionModel doParse(XMLEventReader eventReader) throws XMLStreamException {
		final BasicExtensionModel extensionModel = factory.createBasicExtensionModel();
		int elementDepth = 0;
		while (eventReader.hasNext()) {
			final XMLEvent event = eventReader.nextEvent();
			switch (event.getEventType()) {
				case XMLStreamConstants.START_ELEMENT:
					elementDepth++;
					final StartElement startElement = event.asStartElement();
					if (elementDepth == 1) {
						final Attribute versionAtt = startElement.getAttributeByName(new QName("version"));
						if (versionAtt != null) {
							if (versionAtt.getValue().trim().startsWith("1.5")) {
								extensionModel.setManifestVersion(ManifestVersion.ONE_FIVE);
							} else if (versionAtt.getValue().trim().startsWith("1.6")) {
								extensionModel.setManifestVersion(ManifestVersion.ONE_SIX);
							}
						}
						final Attribute typeAtt = startElement.getAttributeByName(new QName("type"));
						if (typeAtt != null) {
							final ExtensionType extensionType = getExtensionTypeByLiteral(typeAtt.getValue());
							if (extensionType != null) {
								extensionModel.setType(extensionType);
							}
						}
					} if (elementDepth == 2 && "name".equals(startElement.getName().getLocalPart())) {
						extensionModel.setName(eventReader.getElementText());
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					elementDepth--;
					break;
			}
		}
		return extensionModel;
	}

	private ExtensionType getExtensionTypeByLiteral(String value) {
		for (final ExtensionType type : ExtensionType.values()) {
			if (type.getLiteral().equals(value)) {
				return type;
			}
		}
		return null;
	}

	public static class ParsingException extends Exception {

		private static final long serialVersionUID = 1L;

		public ParsingException(String message, Throwable cause) {
			super(message, cause);
		}

		public ParsingException(String message) {
			super(message);
		}

		public ParsingException(Throwable cause) {
			super(cause);
		}
		
	}
	
}
