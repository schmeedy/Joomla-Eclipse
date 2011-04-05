package com.schmeedy.pdt.service.registry.invocation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BasicServiceInvoker implements IServiceInvoker {

	@Override
	public Object invoke(Object service, Method method, Object[] arguments) throws Exception {
		try {
			return method.invoke(service, arguments);
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof Error) {
				throw new RuntimeException("Error during service invocation - method called: " + method, e);
			} else {
				throw (Exception) e.getTargetException();
			}
		}
	}

}
