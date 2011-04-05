package com.schmeedy.pdt.service.registry;

public interface IServiceRegistry {

	<T> T getService(Class<T> clazz);
	
}
