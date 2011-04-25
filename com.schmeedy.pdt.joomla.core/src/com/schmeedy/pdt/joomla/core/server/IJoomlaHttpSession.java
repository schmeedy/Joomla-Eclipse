package com.schmeedy.pdt.joomla.core.server;

import org.apache.commons.httpclient.HttpMethod;
import org.htmlcleaner.TagNode;

public interface IJoomlaHttpSession {
	
	TagNode executeAndParseResponseBody(IMethodFactory requestFactory, boolean followRedirects);
	
	public interface IMethodFactory {
		HttpMethod createMethod();
	}

}
