package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the city table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="city"
 */

public abstract class BaseCity  implements Serializable {

	public static String REF = "City";
	public static String PROP_REGION_STATE = "regionState";
	public static String PROP_ID = "id";
	public static String PROP_NAME = "name";


	// constructors
	public BaseCity () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCity (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCity (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.RegionState regionState) {

		this.setId(id);
		this.setRegionState(regionState);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;

	// many to one
	private com.ictti.orrs.business.entity.RegionState regionState;

	// collections
	private java.util.Set<com.ictti.orrs.business.entity.Shelter> shelters;
	private java.util.Set<com.ictti.orrs.business.entity.Adopter> adopters;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="city_id"
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
	 * Return the value associated with the column: region_state_id
	 */
	public com.ictti.orrs.business.entity.RegionState getRegionState () {
		return regionState;
	}

	/**
	 * Set the value related to the column: region_state_id
	 * @param regionState the region_state_id value
	 */
	public void setRegionState (com.ictti.orrs.business.entity.RegionState regionState) {
		this.regionState = regionState;
	}



	/**
	 * Return the value associated with the column: shelters
	 */
	public java.util.Set<com.ictti.orrs.business.entity.Shelter> getShelters () {
		return shelters;
	}

	/**
	 * Set the value related to the column: shelters
	 * @param shelters the shelters value
	 */
	public void setShelters (java.util.Set<com.ictti.orrs.business.entity.Shelter> shelters) {
		this.shelters = shelters;
	}

	public void addToshelters (com.ictti.orrs.business.entity.Shelter shelter) {
		if (null == getShelters()) setShelters(new java.util.TreeSet<com.ictti.orrs.business.entity.Shelter>());
		getShelters().add(shelter);
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
		if (!(obj instanceof com.ictti.orrs.business.entity.City)) return false;
		else {
			com.ictti.orrs.business.entity.City city = (com.ictti.orrs.business.entity.City) obj;
			if (null == this.getId() || null == city.getId()) return false;
			else return (this.getId().equals(city.getId()));
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