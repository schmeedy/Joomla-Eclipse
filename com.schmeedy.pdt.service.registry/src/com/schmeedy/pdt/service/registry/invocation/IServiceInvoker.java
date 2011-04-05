package com.schmeedy.pdt.service.registry.invocation;

import java.lang.reflect.Method;

public interface IServiceInvoker {
	
	Object invoke(Object service, Method method, Object[] arguments) throws Exception;
	
}
