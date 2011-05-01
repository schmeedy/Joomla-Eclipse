package com.schmeedy.pdt.joomla.core.server.impl;

import java.io.IOException;
import java.net.ConnectException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import com.schmeedy.pdt.joomla.core.JoomlaCorePlugin;
import com.schmeedy.pdt.joomla.core.server.HttpSessionException;
import com.schmeedy.pdt.joomla.core.server.IJoomlaHttpSession;
import com.schmeedy.pdt.joomla.core.server.InvalidJoomlaCredentialsException;
import com.schmeedy.pdt.joomla.core.server.JoomlaConnectException;
import com.schmeedy.pdt.joomla.core.server.ServerUtils;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.UserCredentials;
import com.schmeedy.pdt.joomla.core.server.impl.JoomlaSystemMessage.MessageSeverity;

public class JoomlaHttpSessionImpl implements IJoomlaHttpSession {

	private static final int MAX_REDIRECTS = 5;
	
	private final HttpClient httpClient = new HttpClient();
	private final HtmlCleaner htmlCleaner = new HtmlCleaner(); 
	private final DeploymentRuntime runtime;
	
	public JoomlaHttpSessionImpl(DeploymentRuntime runtime) {
		this.runtime = runtime;
	}
	
	@Override
	public IStatus getSessionStatus(IProgressMonitor progressMonitor) {
		try {
			// we do progress monitoring here to set a good message :) ... otherwise it would be OK to pass the monitor instance on...
			progressMonitor.beginTask("Contacting Joomla! server at " + runtime.getServer().getBaseUrl(), 1000);
			executeAndParseResponseBody(new IMethodFactory() {
				@Override
				public HttpMethod createMethod() {
					final String adminBaseUrl = ServerUtils.getUrl(runtime, "administrator/index.php");
					final PostMethod request = new PostMethod(adminBaseUrl);
					return request;
				}
			}, false, new SubProgressMonitor(progressMonitor, 1000));
			return Status.OK_STATUS;
		} catch (final InvalidJoomlaCredentialsException e) {
			return JoomlaCorePlugin.newStatus(IStatus.ERROR, e.getMessage(), e);
		} catch (final JoomlaConnectException e) {
			return JoomlaCorePlugin.newStatus(IStatus.ERROR, e.getMessage(), e);
		} catch (final Exception e) {
			// TODO: log this exception?
			return JoomlaCorePlugin.newStatus(IStatus.ERROR, "Unexpected exception occured when trying to connecto to Joomla! at " + runtime.getServer().getBaseUrl() + " : " + e.getMessage(), e);
		} finally {
			progressMonitor.done();
		}
	}
	
	@Override
	public TagNode executeAndParseResponseBody(IMethodFactory requestFactory, boolean followRedirects, IProgressMonitor progressMonitor) {
		try {
			progressMonitor.beginTask("Execute HTTP request with admin login if necessary.", 3000);
			final HttpMethod request = requestFactory.createMethod();
			final TagNode responsePageNode = doExecuteAndParse(request, followRedirects ? MAX_REDIRECTS : 0, new SubProgressMonitor(progressMonitor, 1000));
			if (isLoginPage(responsePageNode)) {
				return loginAndExecute(requestFactory.createMethod(), responsePageNode, followRedirects, new SubProgressMonitor(progressMonitor, 2000));
			} else {
				return responsePageNode;
			}
		} finally {
			progressMonitor.done();
		}
	}

	private TagNode loginAndExecute(HttpMethod request, TagNode loginPageNode, boolean followRedirects, IProgressMonitor progressMonitor) {
		try {
			progressMonitor.beginTask("Login into Joomla! administration and execute HTTP request.", 2000);
			final List<NameValuePair> loginRequestParams = getLoginRequestParams(loginPageNode);
			final String loginUrl = ServerUtils.getUrl(runtime, "administrator/index.php");
			final PostMethod loginRequest = new PostMethod(loginUrl);
			loginRequest.setRequestBody(loginRequestParams.toArray(new NameValuePair[loginRequestParams.size()]));
			final TagNode pageNode = doExecuteAndParse(loginRequest, 0, new SubProgressMonitor(progressMonitor, 1000));
			if (isLoginPage(pageNode)) {
				final JoomlaSystemMessage message = ServerUtils.extractFirstSystemMessage(pageNode);
				if (message != null && message.getSeverity() == MessageSeverity.ERROR) {
					throw new InvalidJoomlaCredentialsException("Failed to log in using admin user credentials. Joomla! response: " + message.getMessage());
				}
			}
			return doExecuteAndParse(request, followRedirects ? MAX_REDIRECTS : 0, new SubProgressMonitor(progressMonitor, 1000));
		} finally {
			progressMonitor.done();
		}
	}

	private List<NameValuePair> getLoginRequestParams(TagNode loginPageNode) {
		final UserCredentials credentials = runtime.getServer().getAdminUserCredentials();
		if (credentials == null || credentials.getUsername() == null || credentials.getPassword() == null) {
			throw new InvalidJoomlaCredentialsException("Admin user credentials are not configured for '" + runtime.getServer().getName() + "'");
		}
		final List<NameValuePair> params = new LinkedList<NameValuePair>();
		params.add(new NameValuePair("username", credentials.getUsername()));
		params.add(new NameValuePair("passwd", credentials.getPassword()));
		
		final List<NameValuePair> hiddenFields = ServerUtils.extractInputNameValuePairs("//form[@id='form-login']//input[@type='hidden']", loginPageNode);
		params.addAll(hiddenFields);
		
		return params;
	}

	private boolean isLoginPage(TagNode pageNode) {
		return !ServerUtils.evaluateXPathForTags("//form[@id='form-login']", pageNode).isEmpty();
	}
	
	private TagNode doExecuteAndParse(HttpMethod request, int redirectsLeft, IProgressMonitor progressMonitor) {
		try {
			progressMonitor.beginTask("Execute HTTP request and parse response.", redirectsLeft > 0 ? 2000 : 1000);
			final int responseCode = httpClient.executeMethod(request);
			progressMonitor.worked(1000);
			if (isRedirectResponse(responseCode) && redirectsLeft > 0) {
				final String targetLocation = request.getResponseHeader("Location").getValue();
				final GetMethod fetchTarget = new GetMethod(targetLocation);
				return doExecuteAndParse(fetchTarget, --redirectsLeft, new SubProgressMonitor(progressMonitor, 1000));
			} else if (isRedirectResponse(responseCode) || responseCode == HttpStatus.SC_OK) {
				return htmlCleaner.clean(request.getResponseBodyAsStream());
			} else {
				throw new HttpSessionException("Unexpected HTTP response code " + responseCode);
			}
		} catch (final ConnectException e) {
			throw new JoomlaConnectException("Cannot connect to Joomla! server at " + runtime.getServer().getBaseUrl() + ". Make sure it's running.", e);
		} catch (final IOException e) {
			throw new HttpSessionException("HTTP invocation failed.", e);
		} finally {
			progressMonitor.done();
		}
	}

	private boolean isRedirectResponse(int responseCode) {
		return responseCode == HttpStatus.SC_MOVED_PERMANENTLY || responseCode == HttpStatus.SC_MOVED_TEMPORARILY || responseCode == HttpStatus.SC_SEE_OTHER || responseCode == HttpStatus.SC_TEMPORARY_REDIRECT;
	}
	
}
