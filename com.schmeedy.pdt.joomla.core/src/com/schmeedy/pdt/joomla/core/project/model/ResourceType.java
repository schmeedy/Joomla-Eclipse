/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.schmeedy.pdt.joomla.core.project.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Resource Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.schmeedy.pdt.joomla.core.project.model.JoomlaProjectModelPackage#getResourceType()
 * @model
 * @generated
 */
public enum ResourceType implements Enumerator {
	/**
	 * The '<em><b>GENERIC FILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERIC_FILE_VALUE
	 * @generated
	 * @ordered
	 */
	GENERIC_FILE(0, "GENERIC_FILE", "GENERIC_FILE"), /**
	 * The '<em><b>LANGUAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LANGUAGE_VALUE
	 * @generated
	 * @ordered
	 */
	LANGUAGE(1, "LANGUAGE", "LANGUAGE"), /**
	 * The '<em><b>MEDIA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIA_VALUE
	 * @generated
	 * @ordered
	 */
	MEDIA(2, "MEDIA", "MEDIA"), /**
	 * The '<em><b>SPECIAL INSTALL SCRIPT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIAL_INSTALL_SCRIPT_VALUE
	 * @generated
	 * @ordered
	 */
	SPECIAL_INSTALL_SCRIPT(3, "SPECIAL_INSTALL_SCRIPT", "SPECIAL_INSTALL_SCRIPT"), /**
	 * The '<em><b>SPECIAL UNINSTALL SCRIPT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIAL_UNINSTALL_SCRIPT_VALUE
	 * @generated
	 * @ordered
	 */
	SPECIAL_UNINSTALL_SCRIPT(4, "SPECIAL_UNINSTALL_SCRIPT", "SPECIAL_UNINSTALL_SCRIPT"), /**
	 * The '<em><b>SPECIAL INSTALL SQL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIAL_INSTALL_SQL_VALUE
	 * @generated
	 * @ordered
	 */
	SPECIAL_INSTALL_SQL(5, "SPECIAL_INSTALL_SQL", "SPECIAL_INSTALL_SQL"), /**
	 * The '<em><b>SPECIAL UNINSTALL SQL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIAL_UNINSTALL_SQL_VALUE
	 * @generated
	 * @ordered
	 */
	SPECIAL_UNINSTALL_SQL(6, "SPECIAL_UNINSTALL_SQL", "SPECIAL_UNINSTALL_SQL");

	/**
	 * The '<em><b>GENERIC FILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERIC FILE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERIC_FILE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GENERIC_FILE_VALUE = 0;

	/**
	 * The '<em><b>LANGUAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LANGUAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LANGUAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LANGUAGE_VALUE = 1;

	/**
	 * The '<em><b>MEDIA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MEDIA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEDIA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEDIA_VALUE = 2;

	/**
	 * The '<em><b>SPECIAL INSTALL SCRIPT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPECIAL INSTALL SCRIPT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPECIAL_INSTALL_SCRIPT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPECIAL_INSTALL_SCRIPT_VALUE = 3;

	/**
	 * The '<em><b>SPECIAL UNINSTALL SCRIPT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPECIAL UNINSTALL SCRIPT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPECIAL_UNINSTALL_SCRIPT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPECIAL_UNINSTALL_SCRIPT_VALUE = 4;

	/**
	 * The '<em><b>SPECIAL INSTALL SQL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPECIAL INSTALL SQL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPECIAL_INSTALL_SQL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPECIAL_INSTALL_SQL_VALUE = 5;

	/**
	 * The '<em><b>SPECIAL UNINSTALL SQL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPECIAL UNINSTALL SQL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPECIAL_UNINSTALL_SQL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPECIAL_UNINSTALL_SQL_VALUE = 6;

	/**
	 * An array of all the '<em><b>Resource Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ResourceType[] VALUES_ARRAY =
		new ResourceType[] {
			GENERIC_FILE,
			LANGUAGE,
			MEDIA,
			SPECIAL_INSTALL_SCRIPT,
			SPECIAL_UNINSTALL_SCRIPT,
			SPECIAL_INSTALL_SQL,
			SPECIAL_UNINSTALL_SQL,
		};

	/**
	 * A public read-only list of all the '<em><b>Resource Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ResourceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Resource Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResourceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Resource Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResourceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Resource Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourceType get(int value) {
		switch (value) {
			case GENERIC_FILE_VALUE: return GENERIC_FILE;
			case LANGUAGE_VALUE: return LANGUAGE;
			case MEDIA_VALUE: return MEDIA;
			case SPECIAL_INSTALL_SCRIPT_VALUE: return SPECIAL_INSTALL_SCRIPT;
			case SPECIAL_UNINSTALL_SCRIPT_VALUE: return SPECIAL_UNINSTALL_SCRIPT;
			case SPECIAL_INSTALL_SQL_VALUE: return SPECIAL_INSTALL_SQL;
			case SPECIAL_UNINSTALL_SQL_VALUE: return SPECIAL_UNINSTALL_SQL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ResourceType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ResourceType
