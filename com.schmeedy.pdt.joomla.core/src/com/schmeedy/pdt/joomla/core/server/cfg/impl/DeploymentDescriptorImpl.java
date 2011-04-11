/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.server.cfg.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentDescriptor;
import com.schmeedy.pdt.joomla.core.server.cfg.DeploymentRuntime;
import com.schmeedy.pdt.joomla.core.server.cfg.JoomlaServerConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.server.cfg.impl.DeploymentDescriptorImpl#getRuntimes <em>Runtimes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeploymentDescriptorImpl extends EObjectImpl implements DeploymentDescriptor {
	/**
	 * The cached value of the '{@link #getRuntimes() <em>Runtimes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimes()
	 * @generated
	 * @ordered
	 */
	protected EList<DeploymentRuntime> runtimes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeploymentDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaServerConfigurationPackage.Literals.DEPLOYMENT_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeploymentRuntime> getRuntimes() {
		if (runtimes == null) {
			runtimes = new EObjectContainmentEList<DeploymentRuntime>(DeploymentRuntime.class, this, JoomlaServerConfigurationPackage.DEPLOYMENT_DESCRIPTOR__RUNTIMES);
		}
		return runtimes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JoomlaServerConfigurationPackage.DEPLOYMENT_DESCRIPTOR__RUNTIMES:
				return ((InternalEList<?>)getRuntimes()).basicRemove(otherEnd, msgs);
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
			case JoomlaServerConfigurationPackage.DEPLOYMENT_DESCRIPTOR__RUNTIMES:
				return getRuntimes();
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
			case JoomlaServerConfigurationPackage.DEPLOYMENT_DESCRIPTOR__RUNTIMES:
				getRuntimes().clear();
				getRuntimes().addAll((Collection<? extends DeploymentRuntime>)newValue);
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
			case JoomlaServerConfigurationPackage.DEPLOYMENT_DESCRIPTOR__RUNTIMES:
				getRuntimes().clear();
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
			case JoomlaServerConfigurationPackage.DEPLOYMENT_DESCRIPTOR__RUNTIMES:
				return runtimes != null && !runtimes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DeploymentDescriptorImpl
