package com.schmeedy.pdt.joomla.core.project.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.internal.content.ContentMessages;
import org.eclipse.core.internal.content.TextContentDescriber;
import org.eclipse.core.internal.content.Util;
import org.eclipse.core.internal.runtime.RuntimeLog;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.ITextContentDescriber;
import org.eclipse.core.runtime.content.XMLContentDescriber;
import org.eclipse.core.runtime.content.XMLRootElementContentDescriber2;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.schmeedy.pdt.joomla.core.project.impl.CustomizedXMLRootHandler.SimpleAttributeList;

/**
 * This class derives is basically {@link XMLRootElementContentDescriber2} merged with {@link XMLContentDescriber} and customized. This is due to lack
 * of extensibility in these classes (although it does not make sense to re-implement everything already present and tested there).
 */
@SuppressWarnings("restriction")
public class JoomlaExtensionManifestContentTypeDescriber extends TextContentDescriber implements ITextContentDescriber, IExecutableExtension {

	private static final Pattern DTD_PATTERN = Pattern.compile("http://dev\\.joomla\\.org/xml/([^/]+)/(component|module|plugin|template)-(install|extension)\\.dtd"); 
	
	private static final QualifiedName[] SUPPORTED_OPTIONS = new QualifiedName[] {IContentDescription.CHARSET, IContentDescription.BYTE_ORDER_MARK};
	private static final String XML_PREFIX = "<?xml "; //$NON-NLS-1$
	private static final String XML_DECL_END = "?>"; //$NON-NLS-1$
	private static final String BOM = "org.eclipse.core.runtime.content.XMLContentDescriber.bom"; //$NON-NLS-1$
	private static final String CHARSET = "org.eclipse.core.runtime.content.XMLContentDescriber.charset"; //$NON-NLS-1$
	private static final String FULL_XML_DECL = "org.eclipse.core.runtime.content.XMLContentDescriber.fullXMLDecl"; //$NON-NLS-1$
	private static final String BASIC_RESULT = "org.eclipse.core.runtime.content.XMLContentDescriber.processed"; //$NON-NLS-1$
	
	private static final String DTD = "org.eclipse.core.runtime.content.XMLRootElementContentDescriber2.dtd"; //$NON-NLS-1$
	private static final String NAMESPACE = "org.eclipse.core.runtime.content.XMLRootElementContentDescriber2.namespace"; //$NON-NLS-1$
	private static final String ELEMENT = "org.eclipse.core.runtime.content.XMLRootElementContentDescriber2.element"; //$NON-NLS-1$
	private static final String ELEMENT_ATTRIBUTES = "org.eclipse.core.runtime.content.XMLRootElementContentDescriber2.elementAttributes"; //$NON-NLS-1$
	private static final String RESULT = "org.eclipse.core.runtime.content.XMLRootElementContentDescriber2.result"; //$NON-NLS-1$
	
	private static final String EXTENSION_TYPE_PARAM_NAME = "type";
	
	private String extensionType;
	
	@Override
	@SuppressWarnings("unchecked")
	public void setInitializationData(final IConfigurationElement config, final String propertyName, final Object data) throws CoreException {
		if (data instanceof String) {
			extensionType = (String) data;
		} else if (data instanceof Hashtable) {
			final Hashtable<String, String> table = (Hashtable<String, String>) data;
			extensionType = table.get(EXTENSION_TYPE_PARAM_NAME);
		}
	}
	
	private int checkCriteria(Map<String, Object> properties) throws IOException {
		final Boolean result = (Boolean) properties.get(RESULT);
		if (!result.booleanValue())
			return INDETERMINATE;
		final String dtd = (String) properties.get(DTD);
		if (dtd != null) {
			final Matcher matcher = DTD_PATTERN.matcher(dtd);
			if (matcher.matches()) {
				final String declaredExtensionType = matcher.group(1);
				return extensionType == null || extensionType.equals(declaredExtensionType) ? VALID : INVALID;
			}
		}
		final String rootElementName = (String) properties.get(ELEMENT);
		if (rootElementName == null) {
			return INDETERMINATE;
		} else if (!"install".equals(rootElementName) && !"extension".equals(rootElementName)) {
			return INVALID;
		}
		final SimpleAttributeList rootElementAttributes = (SimpleAttributeList) properties.get(ELEMENT_ATTRIBUTES);
		if (rootElementAttributes == null || rootElementAttributes.getByLocalName("type") == null || rootElementAttributes.getByLocalName("version") == null) {
			return INVALID;
		}
		final String declaredExtensionType = rootElementAttributes.getByLocalName("type").getValue();
		return extensionType == null || extensionType.equals(declaredExtensionType) ? VALID : INVALID;
	}
	
	@Override
	public int describe(InputStream contents, IContentDescription description) throws IOException {
		return describe(contents, description, new HashMap<String, Object>());
	}
	
	public int describe(InputStream contents, IContentDescription description, Map<String, Object> properties) throws IOException {
		// call the basic XML describer to do basic recognition
		if (describe2(contents, description, properties) == INVALID)
			return INVALID;
		// super.describe will have consumed some chars, need to rewind		
		contents.reset();
		// Check to see if we matched our criteria.		
		return checkCriteria(new InputSource(contents), properties);
	}
	
	@Override
	public int describe(Reader contents, IContentDescription description) throws IOException {
		return describe(contents, description, new HashMap<String, Object>());
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public int describe(Reader contents, IContentDescription description, Map<String, Object> properties) throws IOException {
		// call the basic XML describer to do basic recognition
		if (describe2(contents, description, properties) == INVALID)
			return INVALID;
		// super.describe will have consumed some chars, need to rewind
		contents.reset();
		// Check to see if we matched our criteria.
		return checkCriteria(new InputSource(contents), properties);
	}
	
	private int checkCriteria(InputSource contents, Map<String, Object> properties) throws IOException {
		if (properties.get(RESULT) == null)
			fillContentProperties(contents, properties);
		return checkCriteria(properties);
	}
	
	private static void fillContentProperties(InputSource input, Map<String, Object> properties) throws IOException {
		final CustomizedXMLRootHandler xmlHandler = new CustomizedXMLRootHandler(true);
		try {
			if (!xmlHandler.parseContents(input)) {
				properties.put(RESULT, new Boolean(false));
				return;
			}
		} catch (final SAXException e) {
			// we may be handed any kind of contents... it is normal we fail to parse
			properties.put(RESULT, new Boolean(false));
			return;
		} catch (final ParserConfigurationException e) {
			// some bad thing happened - force this describer to be disabled
			final String message = ContentMessages.content_parserConfiguration;
			RuntimeLog.log(new Status(IStatus.ERROR, ContentMessages.OWNER_NAME, 0, message, e));
			throw new RuntimeException(message);
		}
		final String element = xmlHandler.getRootElementName();
		if (element != null) {
			properties.put(ELEMENT, element);
			properties.put(ELEMENT_ATTRIBUTES, xmlHandler.getRootElementAttributes());
		}
		final String dtd = xmlHandler.getDTD();
		if (dtd != null)
			properties.put(DTD, dtd);
		final String namespace = xmlHandler.getRootElementNamespace();
		if (namespace != null)
			properties.put(NAMESPACE, namespace);
		properties.put(RESULT, new Boolean(true));
	}

	private int describe2(InputStream input, IContentDescription description, Map<String, Object> properties) throws IOException {
		if (properties.get(BASIC_RESULT) == null)
			fillBasicContentProperties(input, description, properties);
		return internalDescribe(description, properties);
	}


	private int describe2(Reader input, IContentDescription description, Map<String, Object> properties) throws IOException {
		if (properties.get(BASIC_RESULT) == null)
			fillBasicContentProperties(readXMLDecl(input), description, properties);
		return internalDescribe(description, properties);
	}

	private void fillBasicContentProperties(InputStream input, IContentDescription description, Map<String, Object> properties) throws IOException {
		final byte[] bom = Util.getByteOrderMark(input);
		String xmlDeclEncoding = "UTF-8"; //$NON-NLS-1$
		input.reset();
		if (bom != null) {
			if (bom == IContentDescription.BOM_UTF_16BE)
				xmlDeclEncoding = "UTF-16BE"; //$NON-NLS-1$
			else if (bom == IContentDescription.BOM_UTF_16LE)
				xmlDeclEncoding = "UTF-16LE"; //$NON-NLS-1$
			// skip BOM to make comparison simpler
			input.skip(bom.length);
			properties.put(BOM, bom);
		}
		fillBasicContentProperties(readXMLDecl(input, xmlDeclEncoding), description, properties);
	}

	private void fillBasicContentProperties(String line, IContentDescription description, Map<String, Object> properties) throws IOException {
		// XMLDecl should be the first string (no blanks allowed)
		if (line != null && line.startsWith(XML_PREFIX))
			properties.put(FULL_XML_DECL, new Boolean(true));
		final String charset = getCharset(line);
		if (charset != null)
			properties.put(CHARSET, charset);
		properties.put(BASIC_RESULT, new Boolean(true));
	}

	private int internalDescribe(IContentDescription description, Map<String, Object> properties) {
		if (description != null) {
			final byte[] bom = (byte[]) properties.get(BOM);
			if (bom != null && description.isRequested(IContentDescription.BYTE_ORDER_MARK))
				description.setProperty(IContentDescription.BYTE_ORDER_MARK, bom);
		}
		final Boolean fullXMLDecl = (Boolean) properties.get(FULL_XML_DECL);
		if (fullXMLDecl == null || !fullXMLDecl.booleanValue())
			return INDETERMINATE;
		if (description == null)
			return VALID;
		final String charset = (String) properties.get(CHARSET);
		if (description.isRequested(IContentDescription.CHARSET)) {
			if (charset != null && !isCharsetValid(charset))
				return INVALID;
			if (isNonDefaultCharset(charset))
				description.setProperty(IContentDescription.CHARSET, charset);
		}
		return VALID;
	}

	private boolean isNonDefaultCharset(String charset) {
		if (charset == null)
			return false;
		if (charset.equalsIgnoreCase("utf8") || charset.equalsIgnoreCase("utf-8")) //$NON-NLS-1$ //$NON-NLS-2$
			return false;
		return true;
	}

	private boolean isFullXMLDecl(String xmlDecl) {
		return xmlDecl.endsWith(XML_DECL_END);
	}

	private String readXMLDecl(InputStream input, String encoding) throws IOException {
		final byte[] xmlDeclEndBytes = XML_DECL_END.getBytes(encoding);

		// allocate an array for the input
		final int xmlDeclSize = 100 * xmlDeclEndBytes.length / 2;
		final byte[] xmlDecl = new byte[xmlDeclSize];

		// looks for XMLDecl end (?>)
		int c = 0;
		int read = 0;

		// count is incremented when subsequent read characters match the xmlDeclEnd bytes,
		// the end of xmlDecl is reached, when count equals the xmlDeclEnd length
		int count = 0;

		while (read < xmlDecl.length && (c = input.read()) != -1) {
			if (c == xmlDeclEndBytes[count])
				count++;
			else
				count = 0;
			xmlDecl[read++] = (byte) c;
			if (count == xmlDeclEndBytes.length)
				break;
		}
		return new String(xmlDecl, 0, read, encoding);
	}

	private String readXMLDecl(Reader input) throws IOException {
		final BufferedReader reader = new BufferedReader(input);
		String xmlDecl = new String();
		String line = null;

		while (xmlDecl.length() < 100 && ((line = reader.readLine()) != null)) {
			xmlDecl = xmlDecl + line;
			if (line.indexOf(XML_DECL_END) != -1) {
				return xmlDecl.substring(0, xmlDecl.indexOf(XML_DECL_END) + XML_DECL_END.length());
			}
		}
		return xmlDecl;
	}

	private String getCharset(String firstLine) {
		final int encodingPos = findEncodingPosition(firstLine);
		if (encodingPos == -1)
			return null;
		char quoteChar = '"';
		int firstQuote = firstLine.indexOf(quoteChar, encodingPos);
		if (firstQuote == -1) {
			quoteChar = '\'';
			firstQuote = firstLine.indexOf(quoteChar, encodingPos);
		}
		if (firstQuote == -1 || firstLine.length() == firstQuote + 1)
			return null;
		final int secondQuote = firstLine.indexOf(quoteChar, firstQuote + 1);
		if (secondQuote == -1)
			return isFullXMLDecl(firstLine) ? firstLine.substring(firstQuote + 1, firstLine.lastIndexOf(XML_DECL_END)).trim() : null;
		return firstLine.substring(firstQuote + 1, secondQuote);
	}

	private int findEncodingPosition(String line) {
		final String encoding = "encoding"; //$NON-NLS-1$
		int fromIndex = 0;
		int position = 0;
		while ((position = line.indexOf(encoding, fromIndex)) != -1) {
			boolean equals = false;
			fromIndex = position + encoding.length();
			for (int i = fromIndex; i < line.length(); i++) {
				final char c = line.charAt(i);
				if (c == '=' && !equals) {
					equals = true;
				} else if (c == 0x20 || c == 0x09 || c == 0x0D || c == 0x0A) {
					// white space characters to ignore
				} else if ((c == '"' || c == '\'') && equals) {
						return position;
				} else {
					break;
				}
			}
		}
		return -1;
	}

	private boolean isCharsetValid(String charset) {
		if (charset.length() == 0)
			return false;

		char c = charset.charAt(0);
		if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z'))
			return false;

		for (int i = 1; i < charset.length(); i++) {
			c = charset.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.')
				continue;
			return false;
		}
		return true;
	}

	@Override
	public QualifiedName[] getSupportedOptions() {
		return SUPPORTED_OPTIONS;
	}
	
}
