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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.schmeedy.pdt.joomla.manifest.model.AbstractMultiResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.AbstractResourceContainer;
import com.schmeedy.pdt.joomla.manifest.model.FileSet;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;
import com.schmeedy.pdt.joomla.manifest.model.LanguageSet;
import com.schmeedy.pdt.joomla.manifest.model.MediaSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Multi Resource Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractMultiResourceContainerImpl#getFileSets <em>File Sets</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractMultiResourceContainerImpl#getLanguageSets <em>Language Sets</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractMultiResourceContainerImpl#getMediaSets <em>Media Sets</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.AbstractMultiResourceContainerImpl#getAllResourceSets <em>All Resource Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractMultiResourceContainerImpl extends EObjectImpl implements AbstractMultiResourceContainer {
	/**
	 * The cached value of the '{@link #getFileSets() <em>File Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileSets()
	 * @generated
	 * @ordered
	 */
	protected EList<FileSet> fileSets;

	/**
	 * The cached value of the '{@link #getLanguageSets() <em>Language Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageSets()
	 * @generated
	 * @ordered
	 */
	protected EList<LanguageSet> languageSets;

	/**
	 * The cached value of the '{@link #getMediaSets() <em>Media Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediaSets()
	 * @generated
	 * @ordered
	 */
	protected EList<MediaSet> mediaSets;

	/**
	 * The cached value of the '{@link #getAllResourceSets() <em>All Resource Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllResourceSets()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractResourceContainer> allResourceSets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected AbstractMultiResourceContainerImpl() {
		eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.isTouch()) {
					return;
				}
				final int featureId = msg.getFeatureID(AbstractMultiResourceContainer.class);
				if (featureId == JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__FILE_SETS || 
					featureId == JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__MEDIA_SETS || 
					featureId == JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__LANGUAGE_SETS) {
					
					updateAllResourceSetList();
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
		return JoomlaExtensionManifestPackage.Literals.ABSTRACT_MULTI_RESOURCE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FileSet> getFileSets() {
		if (fileSets == null) {
			fileSets = new EObjectContainmentEList<FileSet>(FileSet.class, this, JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__FILE_SETS);
		}
		return fileSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LanguageSet> getLanguageSets() {
		if (languageSets == null) {
			languageSets = new EObjectContainmentEList<LanguageSet>(LanguageSet.class, this, JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__LANGUAGE_SETS);
		}
		return languageSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MediaSet> getMediaSets() {
		if (mediaSets == null) {
			mediaSets = new EObjectContainmentEList<MediaSet>(MediaSet.class, this, JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__MEDIA_SETS);
		}
		return mediaSets;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractResourceContainer> getAllResourceSets() {
		if (allResourceSets == null) {
			allResourceSets = new EObjectResolvingEList<AbstractResourceContainer>(AbstractResourceContainer.class, this, JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__ALL_RESOURCE_SETS);
		}
		return allResourceSets;
	}

	/**
	 * @generated NOT
	 */
	private void updateAllResourceSetList() {
		final List<AbstractResourceContainer> newListContents = new ArrayList<AbstractResourceContainer>();
		newListContents.addAll(getFileSets());
		newListContents.addAll(getMediaSets());
		newListContents.addAll(getLanguageSets());
		
		final List<AbstractResourceContainer> currentListContents = getAllResourceSets();

		if (newListContents.isEmpty()) {
			if (!currentListContents.isEmpty()) {
				currentListContents.clear();
			}
			return;
		} else if (currentListContents.isEmpty()) {
			currentListContents.addAll(newListContents);
			return;
		}

		final List<? extends AbstractResourceContainer> additions = new ArrayList<AbstractResourceContainer>(newListContents);
		additions.removeAll(currentListContents);
		final List<AbstractResourceContainer> subtractions = new ArrayList<AbstractResourceContainer>(currentListContents);
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
			final Map<Integer, AbstractResourceContainer> positionMap = new HashMap<Integer, AbstractResourceContainer>();
			for (final AbstractResourceContainer eObject : additions) {
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__FILE_SETS:
				return ((InternalEList<?>)getFileSets()).basicRemove(otherEnd, msgs);
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__LANGUAGE_SETS:
				return ((InternalEList<?>)getLanguageSets()).basicRemove(otherEnd, msgs);
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__MEDIA_SETS:
				return ((InternalEList<?>)getMediaSets()).basicRemove(otherEnd, msgs);
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
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__FILE_SETS:
				return getFileSets();
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__LANGUAGE_SETS:
				return getLanguageSets();
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__MEDIA_SETS:
				return getMediaSets();
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__ALL_RESOURCE_SETS:
				return getAllResourceSets();
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
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__FILE_SETS:
				getFileSets().clear();
				getFileSets().addAll((Collection<? extends FileSet>)newValue);
				return;
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__LANGUAGE_SETS:
				getLanguageSets().clear();
				getLanguageSets().addAll((Collection<? extends LanguageSet>)newValue);
				return;
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__MEDIA_SETS:
				getMediaSets().clear();
				getMediaSets().addAll((Collection<? extends MediaSet>)newValue);
				return;
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__ALL_RESOURCE_SETS:
				getAllResourceSets().clear();
				getAllResourceSets().addAll((Collection<? extends AbstractResourceContainer>)newValue);
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
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__FILE_SETS:
				getFileSets().clear();
				return;
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__LANGUAGE_SETS:
				getLanguageSets().clear();
				return;
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__MEDIA_SETS:
				getMediaSets().clear();
				return;
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__ALL_RESOURCE_SETS:
				getAllResourceSets().clear();
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
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__FILE_SETS:
				return fileSets != null && !fileSets.isEmpty();
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__LANGUAGE_SETS:
				return languageSets != null && !languageSets.isEmpty();
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__MEDIA_SETS:
				return mediaSets != null && !mediaSets.isEmpty();
			case JoomlaExtensionManifestPackage.ABSTRACT_MULTI_RESOURCE_CONTAINER__ALL_RESOURCE_SETS:
				return allResourceSets != null && !allResourceSets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractMultiResourceContainerImpl
