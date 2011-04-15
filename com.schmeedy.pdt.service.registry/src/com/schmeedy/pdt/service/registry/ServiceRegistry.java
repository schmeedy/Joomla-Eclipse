package com.schmeedy.pdt.service.registry;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.schmeedy.pdt.service.registry.impl.ServiceProxyFactory;
import com.schmeedy.pdt.service.registry.invocation.BasicServiceInvoker;

public class ServiceRegistry implements IServiceRegistry, BundleActivator {

	private static ServiceRegistry instance;

	private ServiceProxyFactory serviceProxyFactory; 

	public static ServiceRegistry getInstance() {
		return instance;
	}

	@Override
	@SuppressWarnings("unchecked")
	public synchronized <T> T getService(Class<T> clazz) {
		return (T) serviceProxyFactory.createProxyFor(clazz);
	}

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		if (serviceProxyFactory == null) {
			serviceProxyFactory = new ServiceProxyFactory(bundleContext, new BasicServiceInvoker());
		}
		for (final Bundle bundle : bundleContext.getBundles()) {
			if ("org.eclipse.equinox.ds".equals(bundle.getSymbolicName()) && bundle.getState() != Bundle.ACTIVE) {
				bundle.start();
			}
		}
		instance = this;
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		instance = null;
		serviceProxyFactory = null;
	}

}
