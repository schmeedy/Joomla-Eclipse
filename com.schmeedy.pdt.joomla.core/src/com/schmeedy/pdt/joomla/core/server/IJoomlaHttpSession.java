package com.schmeedy.pdt.joomla.core.server;

import org.apache.commons.httpclient.HttpMethod;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.htmlcleaner.TagNode;

public interface IJoomlaHttpSession {
	
	IStatus getSessionStatus(IProgressMonitor progressMonitor);
	
	TagNode executeAndParseResponseBody(IMethodFactory requestFactory, boolean followRedirects, IProgressMonitor progressMonitor) throws HttpSessionException;
	
	public interface IMethodFactory {
		HttpMethod createMethod();
	}

}
