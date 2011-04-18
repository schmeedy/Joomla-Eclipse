package com.schmeedy.pdt.joomla.core.project.impl;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.internal.content.Activator;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

@SuppressWarnings("restriction")
class CustomizedXMLRootHandler extends DefaultHandler implements LexicalHandler {
	/**
	 * An exception indicating that the parsing should stop. This is usually
	 * triggered when the top-level element has been found.
	 * 
	 * @since 3.0
	 */
	private class StopParsingException extends SAXException {
		/**
		 * All serializable objects should have a stable serialVersionUID
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Constructs an instance of <code>StopParsingException</code> with a
		 * <code>null</code> detail message.
		 */
		public StopParsingException() {
			super((String) null);
		}
	}

	/**
	 * Should we check the root element?
	 */
	private final boolean checkRoot;
	/**
	 * The system identifier for the DTD that was found while parsing the XML.
	 * This member variable is <code>null</code> unless the file has been
	 * parsed successful to the point of finding the DTD's system identifier.
	 */
	private String dtdFound = null;
	/**
	 * This is the name of the top-level element found in the XML file. This
	 * member variable is <code>null</code> unless the file has been parsed
	 * successful to the point of finding the top-level element.
	 */
	private String elementFound = null;

	/**
	 * This is the namespace of the top-level element found in the XML file. This
	 * member variable is <code>null</code> unless the file has been parsed
	 * successful to the point of finding the top-level element.
	 */
	private String namespaceFound = null;
	
	private SimpleAttributeList rootElementAttributes;
	
	public CustomizedXMLRootHandler(boolean checkRoot) {
		this.checkRoot = checkRoot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#comment(char[], int, int)
	 */
	@Override
	public final void comment(final char[] ch, final int start, final int length) {
		// Not interested.
	}

	/**
	 * Creates a new SAX parser for use within this instance.
	 * 
	 * @return The newly created parser.
	 * 
	 * @throws ParserConfigurationException
	 *             If a parser of the given configuration cannot be created.
	 * @throws SAXException
	 *             If something in general goes wrong when creating the parser.
	 * @throws SAXNotRecognizedException
	 *             If the <code>XMLReader</code> does not recognize the
	 *             lexical handler configuration option.
	 * @throws SAXNotSupportedException
	 *             If the <code>XMLReader</code> does not support the lexical
	 *             handler configuration option.
	 */
	private final SAXParser createParser(SAXParserFactory parserFactory) throws ParserConfigurationException, SAXException, SAXNotRecognizedException, SAXNotSupportedException {
		// Initialize the parser.
		final SAXParser parser = parserFactory.newSAXParser();
		final XMLReader reader = parser.getXMLReader();
		reader.setProperty("http://xml.org/sax/properties/lexical-handler", this); //$NON-NLS-1$
		// disable DTD validation (bug 63625)
		try {
			//	be sure validation is "off" or the feature to ignore DTD's will not apply
			reader.setFeature("http://xml.org/sax/features/validation", false); //$NON-NLS-1$
			reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false); //$NON-NLS-1$
		} catch (final SAXNotRecognizedException e) {
			// not a big deal if the parser does not recognize the features
		} catch (final SAXNotSupportedException e) {
			// not a big deal if the parser does not support the features
		}
		return parser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#endCDATA()
	 */
	@Override
	public final void endCDATA() {
		// Not interested.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#endDTD()
	 */
	@Override
	public final void endDTD() {
		// Not interested.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#endEntity(java.lang.String)
	 */
	@Override
	public final void endEntity(final String name) {
		// Not interested.
	}

	public String getDTD() {
		return dtdFound;
	}

	public String getRootElementName() {
		return elementFound;
	}

	public SimpleAttributeList getRootElementAttributes() {
		return rootElementAttributes;
	}
	
	/**
	 * @since org.eclipse.core.contenttype 3.3
	 */
	public String getRootElementNamespace() {
		return namespaceFound;
	}

	public boolean parseContents(InputSource contents) throws IOException, ParserConfigurationException, SAXException {
		// Parse the file into we have what we need (or an error occurs).
		try {
			final SAXParserFactory factory = Activator.getDefault().getFactory();
			if (factory == null)
				return false;
			final SAXParser parser = createParser(factory);
			// to support external entities specified as relative URIs (see bug 63298)
			contents.setSystemId("/"); //$NON-NLS-1$
			parser.parse(contents, this);
		} catch (final StopParsingException e) {
			// Abort the parsing normally. Fall through...
		}
		return true;
	}

	/*
	 * Resolve external entity definitions to an empty string.  This is to speed
	 * up processing of files with external DTDs.  Not resolving the contents 
	 * of the DTD is ok, as only the System ID of the DTD declaration is used.
	 * @see org.xml.sax.helpers.DefaultHandler#resolveEntity(java.lang.String, java.lang.String)
	 */
	@Override
	public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
		return new InputSource(new StringReader("")); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#startCDATA()
	 */
	@Override
	public final void startCDATA() {
		// Not interested.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#startDTD(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public final void startDTD(final String name, final String publicId, final String systemId) throws SAXException {
		dtdFound = systemId;
		// If we don't care about the top-level element, we can stop here.
		if (!checkRoot)
			throw new StopParsingException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ContentHandler#startElement(java.lang.String,
	 *      java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public final void startElement(final String uri, final String elementName, final String qualifiedName, final Attributes attributes) throws SAXException {
		elementFound = elementName;
		rootElementAttributes = new SimpleAttributeList(attributes);
		namespaceFound = uri;
		throw new StopParsingException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#startEntity(java.lang.String)
	 */
	@Override
	public final void startEntity(final String name) {
		// Not interested.
	}
	
	public static final class SimpleAttributeList {
		private final Map<String, SimpleAttribute> attsByName = new HashMap<String, SimpleAttribute>();
		
		private SimpleAttributeList(Attributes atts) {
			for (int i = 0; i < atts.getLength(); i++) {
				final SimpleAttribute att = new SimpleAttribute(atts.getLocalName(i), atts.getValue(i));
				attsByName.put(att.getName(), att);
			}
		}
		
		public SimpleAttribute getByLocalName(String name) {
			return attsByName.get(name);
		}

		public Collection<SimpleAttribute> asCollection() {
			return Collections.unmodifiableCollection(attsByName.values());
		}
		
		@Override
		public String toString() {
			return attsByName.values().toString();
		}
	}
	
	public static final class SimpleAttribute {
		private final String name;
		private final String value;
		
		public SimpleAttribute(String name, String value) {
			super();
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return value;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final SimpleAttribute other = (SimpleAttribute) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return name + "=" + value;
		}
	}
	
}
