/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.schmeedy.pdt.joomla.core.project.model.BasicExtensionModel;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaExtensionDeployment;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Joomla Extension Deployment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaExtensionDeploymentImpl#getRuntime <em>Runtime</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.JoomlaExtensionDeploymentImpl#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JoomlaExtensionDeploymentImpl extends EObjectImpl implements JoomlaExtensionDeployment {
	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected BasicExtensionModel extension;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoomlaExtensionDeploymentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaServerConfigurationPackage.Literals.JOOMLA_EXTENSION_DEPLOYMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentRuntime getRuntime() {
		if (eContainerFeatureID() != JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME) return null;
		return (DeploymentRuntime)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRuntime(DeploymentRuntime newRuntime, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRuntime, JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntime(DeploymentRuntime newRuntime) {
		if (newRuntime != eInternalContainer() || (eContainerFeatureID() != JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME && newRuntime != null)) {
			if (EcoreUtil.isAncestor(this, newRuntime))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRuntime != null)
				msgs = ((InternalEObject)newRuntime).eInverseAdd(this, JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS, DeploymentRuntime.class, msgs);
			msgs = basicSetRuntime(newRuntime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME, newRuntime, newRuntime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicExtensionModel getExtension() {
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtension(BasicExtensionModel newExtension, NotificationChain msgs) {
		BasicExtensionModel oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__EXTENSION, oldExtension, newExtension);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtension(BasicExtensionModel newExtension) {
		if (newExtension != extension) {
			NotificationChain msgs = null;
			if (extension != null)
				msgs = ((InternalEObject)extension).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__EXTENSION, null, msgs);
			if (newExtension != null)
				msgs = ((InternalEObject)newExtension).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__EXTENSION, null, msgs);
			msgs = basicSetExtension(newExtension, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__EXTENSION, newExtension, newExtension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRuntime((DeploymentRuntime)otherEnd, msgs);
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
			case JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME:
				return basicSetRuntime(null, msgs);
			case JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__EXTENSION:
				return basicSetExtension(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME:
				return eInternalContainer().eInverseRemove(this, JoomlaServerConfigurationPackage.DEPLOYMENT_RUNTIME__DEPLOYED_EXTENSIONS, DeploymentRuntime.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME:
				return getRuntime();
			case JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__EXTENSION:
				return getExtension();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME:
				setRuntime((DeploymentRuntime)newValue);
				return;
			case JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__EXTENSION:
				setExtension((BasicExtensionModel)newValue);
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
			case JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME:
				setRuntime((DeploymentRuntime)null);
				return;
			case JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__EXTENSION:
				setExtension((BasicExtensionModel)null);
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
			case JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__RUNTIME:
				return getRuntime() != null;
			case JoomlaServerConfigurationPackage.JOOMLA_EXTENSION_DEPLOYMENT__EXTENSION:
				return extension != null;
		}
		return super.eIsSet(featureID);
	}

} //JoomlaExtensionDeploymentImpl
