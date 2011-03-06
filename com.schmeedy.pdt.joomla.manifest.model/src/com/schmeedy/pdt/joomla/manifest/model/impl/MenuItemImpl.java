/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.manifest.model.impl;

import com.schmeedy.pdt.joomla.manifest.model.JoomlaExtensionManifestPackage;
import com.schmeedy.pdt.joomla.manifest.model.MenuItem;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl#getAct <em>Act</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl#getTask <em>Task</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl#getController <em>Controller</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl#getView <em>View</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl#getLayout <em>Layout</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl#getSub <em>Sub</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl#getImg <em>Img</em>}</li>
 *   <li>{@link com.schmeedy.pdt.joomla.manifest.model.impl.MenuItemImpl#getLink <em>Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MenuItemImpl extends EObjectImpl implements MenuItem {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAct() <em>Act</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAct()
	 * @generated
	 * @ordered
	 */
	protected static final String ACT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAct() <em>Act</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAct()
	 * @generated
	 * @ordered
	 */
	protected String act = ACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTask() <em>Task</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTask()
	 * @generated
	 * @ordered
	 */
	protected static final String TASK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTask() <em>Task</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTask()
	 * @generated
	 * @ordered
	 */
	protected String task = TASK_EDEFAULT;

	/**
	 * The default value of the '{@link #getController() <em>Controller</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getController()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTROLLER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getController() <em>Controller</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getController()
	 * @generated
	 * @ordered
	 */
	protected String controller = CONTROLLER_EDEFAULT;

	/**
	 * The default value of the '{@link #getView() <em>View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getView()
	 * @generated
	 * @ordered
	 */
	protected static final String VIEW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getView() <em>View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getView()
	 * @generated
	 * @ordered
	 */
	protected String view = VIEW_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayout() <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected static final String LAYOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected String layout = LAYOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSub() <em>Sub</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSub()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSub() <em>Sub</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSub()
	 * @generated
	 * @ordered
	 */
	protected String sub = SUB_EDEFAULT;

	/**
	 * The default value of the '{@link #getImg() <em>Img</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImg()
	 * @generated
	 * @ordered
	 */
	protected static final String IMG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImg() <em>Img</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImg()
	 * @generated
	 * @ordered
	 */
	protected String img = IMG_EDEFAULT;

	/**
	 * The default value of the '{@link #getLink() <em>Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected String link = LINK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JoomlaExtensionManifestPackage.Literals.MENU_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.MENU_ITEM__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAct() {
		return act;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAct(String newAct) {
		String oldAct = act;
		act = newAct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.MENU_ITEM__ACT, oldAct, act));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTask() {
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTask(String newTask) {
		String oldTask = task;
		task = newTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.MENU_ITEM__TASK, oldTask, task));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getController() {
		return controller;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setController(String newController) {
		String oldController = controller;
		controller = newController;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.MENU_ITEM__CONTROLLER, oldController, controller));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getView() {
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setView(String newView) {
		String oldView = view;
		view = newView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.MENU_ITEM__VIEW, oldView, view));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLayout() {
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayout(String newLayout) {
		String oldLayout = layout;
		layout = newLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.MENU_ITEM__LAYOUT, oldLayout, layout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSub() {
		return sub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSub(String newSub) {
		String oldSub = sub;
		sub = newSub;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.MENU_ITEM__SUB, oldSub, sub));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImg() {
		return img;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImg(String newImg) {
		String oldImg = img;
		img = newImg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.MENU_ITEM__IMG, oldImg, img));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLink() {
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink(String newLink) {
		String oldLink = link;
		link = newLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JoomlaExtensionManifestPackage.MENU_ITEM__LINK, oldLink, link));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JoomlaExtensionManifestPackage.MENU_ITEM__LABEL:
				return getLabel();
			case JoomlaExtensionManifestPackage.MENU_ITEM__ACT:
				return getAct();
			case JoomlaExtensionManifestPackage.MENU_ITEM__TASK:
				return getTask();
			case JoomlaExtensionManifestPackage.MENU_ITEM__CONTROLLER:
				return getController();
			case JoomlaExtensionManifestPackage.MENU_ITEM__VIEW:
				return getView();
			case JoomlaExtensionManifestPackage.MENU_ITEM__LAYOUT:
				return getLayout();
			case JoomlaExtensionManifestPackage.MENU_ITEM__SUB:
				return getSub();
			case JoomlaExtensionManifestPackage.MENU_ITEM__IMG:
				return getImg();
			case JoomlaExtensionManifestPackage.MENU_ITEM__LINK:
				return getLink();
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
			case JoomlaExtensionManifestPackage.MENU_ITEM__LABEL:
				setLabel((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__ACT:
				setAct((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__TASK:
				setTask((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__CONTROLLER:
				setController((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__VIEW:
				setView((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__LAYOUT:
				setLayout((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__SUB:
				setSub((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__IMG:
				setImg((String)newValue);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__LINK:
				setLink((String)newValue);
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
			case JoomlaExtensionManifestPackage.MENU_ITEM__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__ACT:
				setAct(ACT_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__TASK:
				setTask(TASK_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__CONTROLLER:
				setController(CONTROLLER_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__VIEW:
				setView(VIEW_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__LAYOUT:
				setLayout(LAYOUT_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__SUB:
				setSub(SUB_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__IMG:
				setImg(IMG_EDEFAULT);
				return;
			case JoomlaExtensionManifestPackage.MENU_ITEM__LINK:
				setLink(LINK_EDEFAULT);
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
			case JoomlaExtensionManifestPackage.MENU_ITEM__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case JoomlaExtensionManifestPackage.MENU_ITEM__ACT:
				return ACT_EDEFAULT == null ? act != null : !ACT_EDEFAULT.equals(act);
			case JoomlaExtensionManifestPackage.MENU_ITEM__TASK:
				return TASK_EDEFAULT == null ? task != null : !TASK_EDEFAULT.equals(task);
			case JoomlaExtensionManifestPackage.MENU_ITEM__CONTROLLER:
				return CONTROLLER_EDEFAULT == null ? controller != null : !CONTROLLER_EDEFAULT.equals(controller);
			case JoomlaExtensionManifestPackage.MENU_ITEM__VIEW:
				return VIEW_EDEFAULT == null ? view != null : !VIEW_EDEFAULT.equals(view);
			case JoomlaExtensionManifestPackage.MENU_ITEM__LAYOUT:
				return LAYOUT_EDEFAULT == null ? layout != null : !LAYOUT_EDEFAULT.equals(layout);
			case JoomlaExtensionManifestPackage.MENU_ITEM__SUB:
				return SUB_EDEFAULT == null ? sub != null : !SUB_EDEFAULT.equals(sub);
			case JoomlaExtensionManifestPackage.MENU_ITEM__IMG:
				return IMG_EDEFAULT == null ? img != null : !IMG_EDEFAULT.equals(img);
			case JoomlaExtensionManifestPackage.MENU_ITEM__LINK:
				return LINK_EDEFAULT == null ? link != null : !LINK_EDEFAULT.equals(link);
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
		result.append(" (label: ");
		result.append(label);
		result.append(", act: ");
		result.append(act);
		result.append(", task: ");
		result.append(task);
		result.append(", controller: ");
		result.append(controller);
		result.append(", view: ");
		result.append(view);
		result.append(", layout: ");
		result.append(layout);
		result.append(", sub: ");
		result.append(sub);
		result.append(", img: ");
		result.append(img);
		result.append(", link: ");
		result.append(link);
		result.append(')');
		return result.toString();
	}

} //MenuItemImpl
