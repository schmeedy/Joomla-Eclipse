/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.schmeedy.pdt.joomla.manifest.model.AbstractResource;
import com.schmeedy.pdt.joomla.manifest.model.FileResource;
import com.schmeedy.pdt.joomla.manifest.model.FileSet;
import com.schmeedy.pdt.joomla.manifest.model.FolderResource;
import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.FileSetImpl#getFiles <em>Files</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.FileSetImpl#getFolders <em>Folders</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileSetImpl extends AbstractResourceContainerImpl implements FileSet {
	/**
	 * The cached value of the '{@link #getFiles() <em>Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<FileResource> files;

	/**
	 * The cached value of the '{@link #getFolders() <em>Folders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolders()
	 * @generated
	 * @ordered
	 */
	protected EList<FolderResource> folders;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaExtensionManifestPackage.Literals.FILE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FileResource> getFiles() {
		if (files == null) {
			files = new EObjectContainmentEList<FileResource>(FileResource.class, this, JoomlaExtensionManifestPackage.FILE_SET__FILES);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FolderResource> getFolders() {
		if (folders == null) {
			folders = new EObjectContainmentEList<FolderResource>(FolderResource.class, this, JoomlaExtensionManifestPackage.FILE_SET__FOLDERS);
		}
		return folders;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	protected List<AbstractResource> doGetAllResources() {
		final List<AbstractResource> resources = new LinkedList<AbstractResource>();
		resources.addAll(getFolders());
		resources.addAll(getFiles());
		return resources;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	protected Set<Integer> getBaseFeatureIdsForAllResources() {
		final Set<Integer> featureIds = new HashSet<Integer>();
		featureIds.add(JoomlaExtensionManifestPackage.FILE_SET__FOLDERS);
		featureIds.add(JoomlaExtensionManifestPackage.FILE_SET__FILES);
		return featureIds;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JoomlaExtensionManifestPackage.FILE_SET__FILES:
				return ((InternalEList<?>)getFiles()).basicRemove(otherEnd, msgs);
			case JoomlaExtensionManifestPackage.FILE_SET__FOLDERS:
				return ((InternalEList<?>)getFolders()).basicRemove(otherEnd, msgs);
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
			case JoomlaExtensionManifestPackage.FILE_SET__FILES:
				return getFiles();
			case JoomlaExtensionManifestPackage.FILE_SET__FOLDERS:
				return getFolders();
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
			case JoomlaExtensionManifestPackage.FILE_SET__FILES:
				getFiles().clear();
				getFiles().addAll((Collection<? extends FileResource>)newValue);
				return;
			case JoomlaExtensionManifestPackage.FILE_SET__FOLDERS:
				getFolders().clear();
				getFolders().addAll((Collection<? extends FolderResource>)newValue);
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
			case JoomlaExtensionManifestPackage.FILE_SET__FILES:
				getFiles().clear();
				return;
			case JoomlaExtensionManifestPackage.FILE_SET__FOLDERS:
				getFolders().clear();
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
			case JoomlaExtensionManifestPackage.FILE_SET__FILES:
				return files != null && !files.isEmpty();
			case JoomlaExtensionManifestPackage.FILE_SET__FOLDERS:
				return folders != null && !folders.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FileSetImpl
