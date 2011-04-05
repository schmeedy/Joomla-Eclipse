/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg.util;

import com.schmeedy.pdt.joomla.core.server.cfg.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage
 * @generated
 */
public class JoomlaServerConfigurationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JoomlaServerConfigurationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoomlaServerConfigurationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = JoomlaServerConfigurationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoomlaServerConfigurationSwitch<Adapter> modelSwitch =
		new JoomlaServerConfigurationSwitch<Adapter>() {
			@Override
			public Adapter caseAvailableServers(AvailableServers object) {
				return createAvailableServersAdapter();
			}
			@Override
			public Adapter caseLocalJoomlaServer(LocalJoomlaServer object) {
				return createLocalJoomlaServerAdapter();
			}
			@Override
			public Adapter caseDeploymentDescriptor(DeploymentDescriptor object) {
				return createDeploymentDescriptorAdapter();
			}
			@Override
			public Adapter caseDeploymentRuntime(DeploymentRuntime object) {
				return createDeploymentRuntimeAdapter();
			}
			@Override
			public Adapter caseJoomlaExtensionDeployment(JoomlaExtensionDeployment object) {
				return createJoomlaExtensionDeploymentAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers <em>Available Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.AvailableServers
	 * @generated
	 */
	public Adapter createAvailableServersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer <em>Local Joomla Server</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer
	 * @generated
	 */
	public Adapter createLocalJoomlaServerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor <em>Deployment Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor
	 * @generated
	 */
	public Adapter createDeploymentDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime <em>Deployment Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime
	 * @generated
	 */
	public Adapter createDeploymentRuntimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment <em>Joomla Extension Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment
	 * @generated
	 */
	public Adapter createJoomlaExtensionDeploymentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //JoomlaServerConfigurationAdapterFactory
