package com.schmeedy.pdt.service.registry.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Enumeration;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import com.schmeedy.pdt.service.registry.IServiceProxy;
import com.schmeedy.pdt.service.registry.ServiceRegistryException;
import com.schmeedy.pdt.service.registry.ServiceUnavailableException;
import com.schmeedy.pdt.service.registry.invocation.IServiceInvoker;

public class ServiceProxyFactory {

	private static final int SERVICE_WAIT_TIMEOUT = 2000;

	private final BundleContext context;

	private final IServiceInvoker serviceInvoker;

	public ServiceProxyFactory(BundleContext context, IServiceInvoker serviceInvoker) {
		super();
		this.context = context;
		this.serviceInvoker = serviceInvoker;
	}

	public IServiceProxy createProxyFor(Class<?> clazz) {
		return (IServiceProxy) Proxy.newProxyInstance(new CombinedClassLoader(clazz.getClassLoader(), ServiceProxyFactory.class.getClassLoader()), new Class[] { clazz, IServiceProxy.class },
				new ServiceInvocationHandler(clazz));
	}

	private final class ServiceInvocationHandler implements InvocationHandler {

		private final Class<?> serviceClass;

		private final Method serviceProxyIsAvailableMethod;

		{
			try {
				serviceProxyIsAvailableMethod = IServiceProxy.class.getMethod("isServiceAvailable");
			} catch (Exception e) {
				throw new ServiceRegistryException(IServiceProxy.class.getName() + " interface was changed. Please update " + ServiceInvocationHandler.class.getName());
			}
		}

		ServiceInvocationHandler(Class<?> serviceClass) {
			super();
			this.serviceClass = serviceClass;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (method.equals(serviceProxyIsAvailableMethod)) {
				return isServiceAvailable();
			} else {
				return dispatchServiceMethod(method, args);
			}
		}

		private Object isServiceAvailable() {
			final ServiceReference reference = context.getServiceReference(serviceClass.getName());
			if (reference == null) {
				return false;
			} else {
				context.ungetService(reference);
				return true;
			}
		}

		private Object dispatchServiceMethod(Method method, Object[] args) throws Throwable {
			// stage 1 - try quick dispatch
			final ServiceReference reference = context.getServiceReference(serviceClass.getName());
			if (reference != null) {
				try {
					final Object service = context.getService(reference);
					return doInvoke(service, method, args);
				} finally {
					context.ungetService(reference);
				}
			}

			// stage 2 - open service tracker
			final ServiceTracker serviceTracker = new ServiceTracker(context, serviceClass.getName(), null);
			try {
				serviceTracker.open(true);
				Object service = null;
				try {
					service = serviceTracker.waitForService(SERVICE_WAIT_TIMEOUT);
				} catch (InterruptedException e) {
					throw new RuntimeException("Wainting for service interrupted.", e);
				}
				if (service == null) {
					throw new ServiceUnavailableException("Service " + serviceClass.getName() + " is not available at the moment.");
				} else {
					return doInvoke(service, method, args);
				}
			} finally {
				serviceTracker.close();
			}
		}

		private Object doInvoke(final Object service, Method method, Object[] args) throws Throwable {
			try {
				return serviceInvoker.invoke(service, method, args);
			} catch (InvocationTargetException e) {
				throw e.getCause(); // unwrap possible invocation target exception
			}
		}

	}

	private final class CombinedClassLoader extends ClassLoader {

		private final ClassLoader serviceClassLoader;

		private final ClassLoader bundleClassLoader;

		public CombinedClassLoader(ClassLoader serviceClassLoader, ClassLoader bundleClassLoader) {
			super();
			this.serviceClassLoader = serviceClassLoader;
			this.bundleClassLoader = bundleClassLoader;
		}

		@Override
		public Class<?> loadClass(String name) throws ClassNotFoundException {
			if (name.startsWith(context.getBundle().getSymbolicName())) {
				return bundleClassLoader.loadClass(name);
			} else {
				return serviceClassLoader.loadClass(name);
			}
		}

		@Override
		public URL getResource(String name) {
			return serviceClassLoader.getResource(name);
		}

		@Override
		public Enumeration<URL> getResources(String name) throws IOException {
			return serviceClassLoader.getResources(name);
		}

		@Override
		public InputStream getResourceAsStream(String name) {
			return serviceClassLoader.getResourceAsStream(name);
		}

	}

}
