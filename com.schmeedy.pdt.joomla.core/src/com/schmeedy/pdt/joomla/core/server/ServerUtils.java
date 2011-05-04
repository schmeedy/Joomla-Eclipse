package com.schmeedy.pdt.joomla.core.server;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.httpclient.NameValuePair;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyHtmlSerializer;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment;
import com.schmeedy.pdt.joomla.core.server.impl.JoomlaSystemMessage;
import com.schmeedy.pdt.joomla.core.server.impl.JoomlaSystemMessage.MessageSeverity;

public class ServerUtils {

	private ServerUtils() {}
	
	public static JoomlaSystemMessage extractFirstSystemMessage(TagNode pageNode) {
		final List<TagNode> messageNodeCandidates = evaluateXPathForTags("//dl[@id='system-message']", pageNode);
		final TagNode messageNode = messageNodeCandidates.isEmpty() ? null : messageNodeCandidates.get(0);
		if (messageNode == null) {
			return null;
		}
		
		final TagNode[] termNodes = messageNode.getElementsByName("dt", true);
		if (termNodes.length == 0) {
			return null;
		}
		
		final TagNode[] messageTextNodes = messageNode.getElementsByName("li", true);
		if (messageTextNodes.length == 0) {
			return null;
		}
		
		final String termNodeClass = termNodes[0].getAttributeByName("class");
		final MessageSeverity severity = termNodeClass != null && termNodeClass.toLowerCase().contains("error") ? MessageSeverity.ERROR : MessageSeverity.INFO;
		final String messageText = messageTextNodes[0].getText().toString();
		return new JoomlaSystemMessage(messageText, severity);		
	}
	
	public static NameValuePair extractSessionTokenParam(TagNode pageNode) {
		final List<NameValuePair> hiddenFieldParams = extractInputNameValuePairs("//input[@type='hidden']", pageNode);
		for (final NameValuePair param : hiddenFieldParams) {
			if (param.getName().length() == 32 && "1".equals(param.getValue())) {
				return param;
			}
		}
		throw new IllegalArgumentException("No session token present in the supplied page.");
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
	
	public static TagNode evaluateXPathForSingleTag(String tagXPath, TagNode context) {
		final List<TagNode> tags = evaluateXPathForTags(tagXPath, context);
		return tags.isEmpty() ? null : tags.get(0);
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
	
	public static boolean equals(JoomlaExtensionDeployment ed1, JoomlaExtensionDeployment ed2) {
		if (ed1 == null) {
			return ed2 == null;
		} else {
			return equals(ed1.getExtension(), ed2.getExtension());
		}
	}
	
	public static boolean equals(BasicExtensionModel e1, BasicExtensionModel e2) {
		if (e1 == null) {
			return e2 == null;
		} else {
			return e1.getManifestPath().equals(e2.getManifestPath());
		}
	}
	
	public static boolean equals(Object o1, Object o2) {
		if (o1 == null) {
			return o2 == null;
		} else {
			return o1.equals(o2);
		}
	}
	
	public static JoomlaExtensionDeployment getExtensionDeployment(BasicExtensionModel extension, DeploymentRuntime runtime) {
		if (extension == null) {
			return null;
		}
		for (final JoomlaExtensionDeployment deployment : runtime.getDeployedExtensions()) {
			if (equals(extension, deployment.getExtension())) {
				return deployment;
			}
		}
		return null;
	}
	
	public static JoomlaExtensionDeployment getExtensionDeployment(BasicExtensionModel extension, DeploymentDescriptor descriptor) {
		if (extension == null) {
			return null;
		}
		for (final DeploymentRuntime runtime : descriptor.getRuntimes()) {
			for (final JoomlaExtensionDeployment deployment : runtime.getDeployedExtensions()) {
				if (equals(extension, deployment.getExtension())) {
					return deployment;
				}
			}
		}
		return null;
	}
	
	public static JoomlaExtensionDeployment getPersistentExtensionDeployment(JoomlaExtensionDeployment transientDeployment, DeploymentDescriptor deploymentDescriptor) {
		if (transientDeployment == null) {
			return null;
		}
		final DeploymentRuntime persistentRuntime = getPersistentDeploymentRuntime(transientDeployment.getRuntime(), deploymentDescriptor);
		if (persistentRuntime == null) {
			return null;
		}
		if (persistentRuntime.getDeployedExtensions().contains(transientDeployment)) {
			return transientDeployment;
		}
		for (final JoomlaExtensionDeployment currentDeployment : persistentRuntime.getDeployedExtensions()) {
			if (ServerUtils.equals(currentDeployment, transientDeployment)) {
				return currentDeployment;
			}
		}
		return null;
	}
	
	public static DeploymentRuntime getPersistentDeploymentRuntime(DeploymentRuntime transientRuntime, DeploymentDescriptor deploymentDescriptor) {
		if (transientRuntime == null) {
			return null;
		}
		if (deploymentDescriptor.getRuntimes().contains(transientRuntime)) {
			return transientRuntime;
		}
		for (final DeploymentRuntime runtime : deploymentDescriptor.getRuntimes()) {
			if (runtime.getServer().getId().equals(transientRuntime.getServer().getId())) {
				return runtime;
			}
		}
		return null;
	}
	
	public static void copyAttributes(EObject source, EObject target) {
		Assert.isTrue(source.eClass() == target.eClass(), "Cannot copy attributes between instances of two distinct EClasses.");
		for (final EAttribute attribute : source.eClass().getEAllAttributes()) {
			final Object sourceValue = source.eGet(attribute);
			final Object targetValue = target.eGet(attribute);
			if (!equals(sourceValue, targetValue)) {
				target.eSet(attribute, sourceValue);
			}
		}
	}
	
}
