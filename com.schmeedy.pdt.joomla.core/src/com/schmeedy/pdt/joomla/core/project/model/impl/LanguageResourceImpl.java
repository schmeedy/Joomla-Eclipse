/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model.impl;

import com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage;
import com.schmeedy.pdt.joomla.core.project.model.LanguageResource;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.core.project.model.impl.LanguageResourceImpl#getLanguageTag <em>Language Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LanguageResourceImpl extends ExtensionResourceImpl implements LanguageResource {
	/**
	 * The default value of the '{@link #getLanguageTag() <em>Language Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageTag()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_TAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguageTag() <em>Language Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageTag()
	 * @generated
	 * @ordered
	 */
	protected String languageTag = LANGUAGE_TAG_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaProjectModelPackage.Literals.LANGUAGE_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguageTag() {
		return languageTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguageTag(String newLanguageTag) {
		String oldLanguageTag = languageTag;
		languageTag = newLanguageTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaProjectModelPackage.LANGUAGE_RESOURCE__LANGUAGE_TAG, oldLanguageTag, languageTag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JoomlaProjectModelPackage.LANGUAGE_RESOURCE__LANGUAGE_TAG:
				return getLanguageTag();
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
			case JoomlaProjectModelPackage.LANGUAGE_RESOURCE__LANGUAGE_TAG:
				setLanguageTag((String)newValue);
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
			case JoomlaProjectModelPackage.LANGUAGE_RESOURCE__LANGUAGE_TAG:
				setLanguageTag(LANGUAGE_TAG_EDEFAULT);
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
			case JoomlaProjectModelPackage.LANGUAGE_RESOURCE__LANGUAGE_TAG:
				return LANGUAGE_TAG_EDEFAULT == null ? languageTag != null : !LANGUAGE_TAG_EDEFAULT.equals(languageTag);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (languageTag: ");
		result.append(languageTag);
		result.append(')');
		return result.toString();
	}

} //LanguageResourceImpl
