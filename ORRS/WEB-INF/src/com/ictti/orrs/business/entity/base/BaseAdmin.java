package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the admin table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="admin"
 */

public abstract class BaseAdmin  implements Serializable {

	public static String REF = "Admin";
	public static String PROP_ADMIN_NAME = "adminName";
	public static String PROP_ID = "id";
	public static String PROP_ADMIN_PASSWORD = "adminPassword";


	// constructors
	public BaseAdmin () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAdmin (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAdmin (
		java.lang.Integer id,
		java.lang.String adminName,
		java.lang.String adminPassword) {

		this.setId(id);
		this.setAdminName(adminName);
		this.setAdminPassword(adminPassword);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adminName;
	private java.lang.String adminPassword;

	// collections
	private java.util.Set<com.ictti.orrs.business.entity.Event> events;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="admin_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: admin_name
	 */
	public java.lang.String getAdminName () {
		return adminName;
	}

	/**
	 * Set the value related to the column: admin_name
	 * @param adminName the admin_name value
	 */
	public void setAdminName (java.lang.String adminName) {
		this.adminName = adminName;
	}



	/**
	 * Return the value associated with the column: admin_password
	 */
	public java.lang.String getAdminPassword () {
		return adminPassword;
	}

	/**
	 * Set the value related to the column: admin_password
	 * @param adminPassword the admin_password value
	 */
	public void setAdminPassword (java.lang.String adminPassword) {
		this.adminPassword = adminPassword;
	}



	/**
	 * Return the value associated with the column: events
	 */
	public java.util.Set<com.ictti.orrs.business.entity.Event> getEvents () {
		return events;
	}

	/**
	 * Set the value related to the column: events
	 * @param events the events value
	 */
	public void setEvents (java.util.Set<com.ictti.orrs.business.entity.Event> events) {
		this.events = events;
	}

	public void addToevents (com.ictti.orrs.business.entity.Event event) {
		if (null == getEvents()) setEvents(new java.util.TreeSet<com.ictti.orrs.business.entity.Event>());
		getEvents().add(event);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.Admin)) return false;
		else {
			com.ictti.orrs.business.entity.Admin admin = (com.ictti.orrs.business.entity.Admin) obj;
			if (null == this.getId() || null == admin.getId()) return false;
			else return (this.getId().equals(admin.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}