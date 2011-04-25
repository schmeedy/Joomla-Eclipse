package com.schmeedy.pdt.joomla.core.server.impl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.httpclient.NameValuePair;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyHtmlSerializer;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;

class ServerUtils {

	private ServerUtils() {}
	
	public static String extractErrorMessage(TagNode pageNode) {
		final List<TagNode> messageItems = evaluateXPathForTags("//dl[@id='system-message']//dd[@class='error message']//li", pageNode);
		String message = "";
		for (final TagNode messageItem : messageItems) {
			if (message != "") {
				message += ". ";
			}
			message += messageItem.getText();
		}
		return message.length() == 0 ? null : message;
	}
	
	public static List<NameValuePair> extractInputNameValuePairs(String xPath, TagNode context) {
		final List<NameValuePair> pairs = new LinkedList<NameValuePair>();
		final List<TagNode> hiddenFields = ServerUtils.evaluateXPathForTags(xPath, context);
		for (final TagNode hiddenField : hiddenFields) {
			final NameValuePair param = new NameValuePair(hiddenField.getAttributeByName("name"), hiddenField.getAttributeByName("value"));
			pairs.add(param);
		}
		return pairs;
	}
	
	public static List<TagNode> evaluateXPathForTags(String tagXPath, TagNode context) {
		try {
			final List<TagNode> resultList = new LinkedList<TagNode>();
			final Object[] result = context.evaluateXPath(tagXPath);
			for (final Object tag : result) {
				resultList.add((TagNode) tag);
			}
			return resultList;
		} catch (final XPatherException e) {
			throw new RuntimeException(e); // this shouldn't happen...and this exception should've been runtime
		}
	}
	
	public static String getUrl(DeploymentRuntime runtime, String url) {
		return runtime.getServer().getBaseUrl() + (runtime.getServer().getBaseUrl().endsWith("/") ? "" : "/") + url;
	}
	
	public static String serialize(TagNode tagNode) {
		try {
			final CleanerProperties properties = new CleanerProperties();
			new HtmlCleaner(properties); // this is just consequence of a stupid HtmlCleaner API
			final PrettyHtmlSerializer serializer = new PrettyHtmlSerializer(properties);
			return serializer.getAsString(tagNode);
		} catch (final IOException e) {
			throw new RuntimeException("Failed to serialize tag node " + tagNode, e);
		}
	}
	
}
