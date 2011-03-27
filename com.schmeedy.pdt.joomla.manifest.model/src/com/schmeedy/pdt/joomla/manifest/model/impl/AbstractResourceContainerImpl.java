/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.AbstractResource;
import com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Resource Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractResourceContainerImpl#getBaseFolder <em>Base Folder</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractResourceContainerImpl#getAllResources <em>All Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractResourceContainerImpl extends EObjectImpl implements AbstractResourceContainer {
	/**
	 * The default value of the '{@link #getBaseFolder() <em>Base Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseFolder() <em>Base Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseFolder()
	 * @generated
	 * @ordered
	 */
	protected String baseFolder = BASE_FOLDER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAllResources() <em>All Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllResources()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractResource> allResources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected AbstractResourceContainerImpl() {
		eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.isTouch()) {
					return;
				}
				final int featureId = msg.getFeatureID(AbstractMultiResourceContainer.class);
				if (getBaseFeatureIdsForAllResources().contains(featureId)) {
					updateAllResourcesFeatureList();
				}
			}
		});
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaExtensionManifestPackage.Literals.ABSTRACT_RESOURCE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBaseFolder() {
		return baseFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBaseFolder(String newBaseFolder) {
		String oldBaseFolder = baseFolder;
		baseFolder = newBaseFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER, oldBaseFolder, baseFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractResource> getAllResources() {
		if (allResources == null) {
			allResources = new EObjectResolvingEList<AbstractResource>(AbstractResource.class, this, JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__ALL_RESOURCES);
		}
		return allResources;
	}
	
	protected abstract Set<Integer> getBaseFeatureIdsForAllResources();
	
	protected abstract List<AbstractResource> doGetAllResources();
	
	/**
	 * @generated NOT
	 */
	private void updateAllResourcesFeatureList() {
		final List<AbstractResource> newListContents = doGetAllResources();
		final List<AbstractResource> currentListContents = getAllResources();

		if (newListContents.isEmpty()) {
			if (!currentListContents.isEmpty()) {
				currentListContents.clear();
			}
			return;
		} else if (currentListContents.isEmpty()) {
			currentListContents.addAll(newListContents);
			return;
		}

		final List<? extends AbstractResource> additions = new ArrayList<AbstractResource>(newListContents);
		additions.removeAll(currentListContents);
		final List<AbstractResource> subtractions = new ArrayList<AbstractResource>(currentListContents);
		subtractions.removeAll(newListContents);

		if (!subtractions.isEmpty()) {
			if (subtractions.size() == currentListContents.size()) {
				currentListContents.clear();
			} else {
				currentListContents.removeAll(subtractions);
			}
		}

		if (!additions.isEmpty()) {
			boolean additionsToTheEnd = true;
			final Map<Integer, AbstractResource> positionMap = new HashMap<Integer, AbstractResource>();
			for (final AbstractResource eObject : additions) {
				final int additionIndex = newListContents.indexOf(eObject);
				positionMap.put(additionIndex, eObject);
				if (additionIndex < currentListContents.size()) {
					additionsToTheEnd = false;
				}
			}

			if (additionsToTheEnd) {
				currentListContents.addAll(additions);
			} else {
				final List<Integer> indexes = new ArrayList<Integer>(positionMap.keySet());
				Collections.sort(indexes);
				for (final Integer idx : indexes) {
					currentListContents.add(idx, positionMap.get(idx));
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER:
				return getBaseFolder();
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__ALL_RESOURCES:
				return getAllResources();
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
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER:
				setBaseFolder((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__ALL_RESOURCES:
				getAllResources().clear();
				getAllResources().addAll((Collection<? extends AbstractResource>)newValue);
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
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER:
				setBaseFolder(BASE_FOLDER_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__ALL_RESOURCES:
				getAllResources().clear();
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
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__BASE_FOLDER:
				return BASE_FOLDER_EDEFAULT == null ? baseFolder != null : !BASE_FOLDER_EDEFAULT.equals(baseFolder);
			case JoomlaExtensionManifestPackage.ABSTRACT_RESOURCE_CONTAINER__ALL_RESOURCES:
				return allResources != null && !allResources.isEmpty();
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
		result.append(" (baseFolder: ");
		result.append(baseFolder);
		result.append(')');
		return result.toString();
	}

} //AbstractResourceContainerImpl
