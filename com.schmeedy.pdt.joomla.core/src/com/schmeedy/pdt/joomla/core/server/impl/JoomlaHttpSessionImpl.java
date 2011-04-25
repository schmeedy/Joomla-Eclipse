package com.schmeedy.pdt.joomla.core.server.impl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import com.schmeedy.pdt.joomla.core.server.HttpSessionException;
import com.schmeedy.pdt.joomla.core.server.IJoomlaHttpSession;
import com.schmeedy.pdt.joomla.core.server.InvalidCredentialsException;
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
	public TagNode executeAndParseResponseBody(IMethodFactory requestFactory, boolean followRedirects) {
		final HttpMethod request = requestFactory.createMethod();
		final TagNode responsePageNode = doExecuteAndParse(request, followRedirects ? MAX_REDIRECTS : 0);
		if (isLoginPage(responsePageNode)) {
			return loginAndExecute(requestFactory.createMethod(), responsePageNode, followRedirects);
		} else {
			return responsePageNode;
		}
	}

	private TagNode loginAndExecute(HttpMethod request, TagNode loginPageNode, boolean followRedirects) {
		final List<NameValuePair> loginRequestParams = getLoginRequestParams(loginPageNode);
		final String loginUrl = ServerUtils.getUrl(runtime, "administrator/index.php");
		final PostMethod loginRequest = new PostMethod(loginUrl);
		loginRequest.setRequestBody(loginRequestParams.toArray(new NameValuePair[loginRequestParams.size()]));
		final TagNode pageNode = doExecuteAndParse(loginRequest, 0);
		if (isLoginPage(pageNode)) {
			final JoomlaSystemMessage message = ServerUtils.extractFirstSystemMessage(pageNode);
			if (message != null && message.getSeverity() == MessageSeverity.ERROR) {
				throw new InvalidCredentialsException("Failed to log in using admin user credentials: " + message.getMessage());
			}
		}
		return doExecuteAndParse(request, followRedirects ? MAX_REDIRECTS : 0);
	}

	private List<NameValuePair> getLoginRequestParams(TagNode loginPageNode) {
		final UserCredentials credentials = runtime.getServer().getAdminUserCredentials();
		if (credentials == null || credentials.getUsername() == null || credentials.getPassword() == null) {
			throw new InvalidCredentialsException("Admin user credentials are not set.");
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
	
	private TagNode doExecuteAndParse(HttpMethod request, int redirectsLeft) {
		try {
			final int responseCode = httpClient.executeMethod(request);
			if (isRedirectResponse(responseCode) && redirectsLeft > 0) {
				final String targetLocation = request.getResponseHeader("Location").getValue();
				final GetMethod fetchTarget = new GetMethod(targetLocation);
				return doExecuteAndParse(fetchTarget, --redirectsLeft);
			} else if (isRedirectResponse(responseCode) || responseCode == HttpStatus.SC_OK) {
				return htmlCleaner.clean(request.getResponseBodyAsStream());
			} else {
				throw new HttpSessionException("Unexpected HTTP response code " + responseCode);
			}
		} catch (final IOException e) {
			throw new HttpSessionException("HTTP invocation failed.", e);
		}
	}

	private boolean isRedirectResponse(int responseCode) {
		return responseCode == HttpStatus.SC_MOVED_PERMANENTLY || responseCode == HttpStatus.SC_MOVED_TEMPORARILY || responseCode == HttpStatus.SC_SEE_OTHER || responseCode == HttpStatus.SC_TEMPORARY_REDIRECT;
	}
	
}
