/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage;
import com.schmeedy.pdt.joomla.core.server.cfg.LocalJoomlaServer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment Runtime</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentRuntimeImpl#getServer <em>Server</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentRuntimeImpl#getDeployedExtensions <em>Deployed Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeploymentRuntimeImpl extends EObjectImpl implements DeploymentRuntime {
	/**
	 * The cached value of the '{@link #getServer() <em>Server</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServer()
	 * @generated
	 * @ordered
	 */
	protected LocalJoomlaServer server;

	/**
	 * The cached value of the '{@link #getDeployedExtensions() <em>Deployed Extensions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeployedExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<JoomlaExtensionDeployment> deployedExtensions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeploymentRuntimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaServerConfigurationPackage.Literals.DEPLOYMENT_RUNTIME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocalJoomlaServer getServer() {
		return server;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServer(LocalJoomlaServer newServer, NotificationChain msgs) {
		final LocalJoomlaServer oldServer = server;
		server = newServer;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER, oldServer, newServer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setServer(LocalJoomlaServer newServer) {
		if (newServer != server) {
			NotificationChain msgs = null;
			if (server != null)
				msgs = ((InternalEObject)server).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER, null, msgs);
			if (newServer != null)
				msgs = ((InternalEObject)newServer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER, null, msgs);
			msgs = basicSetServer(newServer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER, newServer, newServer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JoomlaExtensionDeployment> getDeployedExtensions() {
		if (deployedExtensions == null) {
			deployedExtensions = new EObjectWithInverseResolvingEList<JoomlaExtensionDeployment>(JoomlaExtensionDeployment.class, this, JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS, JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME);
		}
		return deployedExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeployedExtensions()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER:
				return basicSetServer(null, msgs);
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS:
				return ((InternalEList<?>)getDeployedExtensions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER:
				return getServer();
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS:
				return getDeployedExtensions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER:
				setServer((LocalJoomlaServer)newValue);
				return;
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS:
				getDeployedExtensions().clear();
				getDeployedExtensions().addAll((Collection<? extends JoomlaExtensionDeployment>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER:
				setServer((LocalJoomlaServer)null);
				return;
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS:
				getDeployedExtensions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__SERVER:
				return server != null;
			case JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS:
				return deployedExtensions != null && !deployedExtensions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DeploymentRuntimeImpl
