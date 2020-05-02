package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the region_state table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="region_state"
 */

public abstract class BaseRegionState  implements Serializable {

	public static String REF = "RegionState";
	public static String PROP_ID = "id";
	public static String PROP_NAME = "name";


	// constructors
	public BaseRegionState () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRegionState (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;

	// collections
	private java.util.Set<com.ictti.orrs.business.entity.City> cities;
	private java.util.Set<com.ictti.orrs.business.entity.Adopter> adopters;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="region_state_id"
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
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: cities
	 */
	public java.util.Set<com.ictti.orrs.business.entity.City> getCities () {
		return cities;
	}

	/**
	 * Set the value related to the column: cities
	 * @param cities the cities value
	 */
	public void setCities (java.util.Set<com.ictti.orrs.business.entity.City> cities) {
		this.cities = cities;
	}

	public void addTocities (com.ictti.orrs.business.entity.City city) {
		if (null == getCities()) setCities(new java.util.TreeSet<com.ictti.orrs.business.entity.City>());
		getCities().add(city);
	}



	/**
	 * Return the value associated with the column: adopters
	 */
	public java.util.Set<com.ictti.orrs.business.entity.Adopter> getAdopters () {
		return adopters;
	}

	/**
	 * Set the value related to the column: adopters
	 * @param adopters the adopters value
	 */
	public void setAdopters (java.util.Set<com.ictti.orrs.business.entity.Adopter> adopters) {
		this.adopters = adopters;
	}

	public void addToadopters (com.ictti.orrs.business.entity.Adopter adopter) {
		if (null == getAdopters()) setAdopters(new java.util.TreeSet<com.ictti.orrs.business.entity.Adopter>());
		getAdopters().add(adopter);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.RegionState)) return false;
		else {
			com.ictti.orrs.business.entity.RegionState regionState = (com.ictti.orrs.business.entity.RegionState) obj;
			if (null == this.getId() || null == regionState.getId()) return false;
			else return (this.getId().equals(regionState.getId()));
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