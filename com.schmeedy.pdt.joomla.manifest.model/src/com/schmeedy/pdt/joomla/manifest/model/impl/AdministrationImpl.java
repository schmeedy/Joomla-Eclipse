/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.impl;

import com.schmeedy.pdt.joomla.manifest.model.Administration;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;
import com.schmeedy.pdt.joomla.manifest.model.MenuItem;
import com.schmeedy.pdt.joomla.manifest.model.SubMenu;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Administration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.AdministrationImpl#getMenu <em>Menu</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.AdministrationImpl#getSubMenu <em>Sub Menu</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdministrationImpl extends AbstractMultiResourceContainerImpl implements Administration {
	/**
	 * The cached value of the '{@link #getMenu() <em>Menu</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMenu()
	 * @generated
	 * @ordered
	 */
	protected MenuItem menu;

	/**
	 * The cached value of the '{@link #getSubMenu() <em>Sub Menu</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubMenu()
	 * @generated
	 * @ordered
	 */
	protected SubMenu subMenu;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdministrationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaExtensionManifestPackage.Literals.ADMINISTRATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuItem getMenu() {
		return menu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMenu(MenuItem newMenu, NotificationChain msgs) {
		MenuItem oldMenu = menu;
		menu = newMenu;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.ADMINISTRATION__MENU, oldMenu, newMenu);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMenu(MenuItem newMenu) {
		if (newMenu != menu) {
			NotificationChain msgs = null;
			if (menu != null)
				msgs = ((InternalEObject)menu).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JoomlaExtensionManifestPackage.ADMINISTRATION__MENU, null, msgs);
			if (newMenu != null)
				msgs = ((InternalEObject)newMenu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JoomlaExtensionManifestPackage.ADMINISTRATION__MENU, null, msgs);
			msgs = basicSetMenu(newMenu, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.ADMINISTRATION__MENU, newMenu, newMenu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubMenu getSubMenu() {
		return subMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubMenu(SubMenu newSubMenu, NotificationChain msgs) {
		SubMenu oldSubMenu = subMenu;
		subMenu = newSubMenu;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.ADMINISTRATION__SUB_MENU, oldSubMenu, newSubMenu);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubMenu(SubMenu newSubMenu) {
		if (newSubMenu != subMenu) {
			NotificationChain msgs = null;
			if (subMenu != null)
				msgs = ((InternalEObject)subMenu).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JoomlaExtensionManifestPackage.ADMINISTRATION__SUB_MENU, null, msgs);
			if (newSubMenu != null)
				msgs = ((InternalEObject)newSubMenu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JoomlaExtensionManifestPackage.ADMINISTRATION__SUB_MENU, null, msgs);
			msgs = basicSetSubMenu(newSubMenu, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.ADMINISTRATION__SUB_MENU, newSubMenu, newSubMenu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JoomlaExtensionManifestPackage.ADMINISTRATION__MENU:
				return basicSetMenu(null, msgs);
			case JoomlaExtensionManifestPackage.ADMINISTRATION__SUB_MENU:
				return basicSetSubMenu(null, msgs);
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
			case JoomlaExtensionManifestPackage.ADMINISTRATION__MENU:
				return getMenu();
			case JoomlaExtensionManifestPackage.ADMINISTRATION__SUB_MENU:
				return getSubMenu();
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
			case JoomlaExtensionManifestPackage.ADMINISTRATION__MENU:
				setMenu((MenuItem)newValue);
				return;
			case JoomlaExtensionManifestPackage.ADMINISTRATION__SUB_MENU:
				setSubMenu((SubMenu)newValue);
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
			case JoomlaExtensionManifestPackage.ADMINISTRATION__MENU:
				setMenu((MenuItem)null);
				return;
			case JoomlaExtensionManifestPackage.ADMINISTRATION__SUB_MENU:
				setSubMenu((SubMenu)null);
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
			case JoomlaExtensionManifestPackage.ADMINISTRATION__MENU:
				return menu != null;
			case JoomlaExtensionManifestPackage.ADMINISTRATION__SUB_MENU:
				return subMenu != null;
		}
		return super.eIsSet(featureID);
	}

} //AdministrationImpl
