package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the shelter table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="shelter"
 */

public abstract class BaseShelter  implements Serializable {

	public static String REF = "Shelter";
	public static String PROP_SHELTER_NAME = "shelterName";
	public static String PROP_SHELTER_LOCATION = "shelterLocation";
	public static String PROP_BREAKFAST_PRICE = "breakfastPrice";
	public static String PROP_SHELTER_EMAIL = "shelterEmail";
	public static String PROP_SHELTER_DELETE_STATUS = "shelterDeleteStatus";
	public static String PROP_PRINCIPAL_NAME = "principalName";
	public static String PROP_CITY = "city";
	public static String PROP_LUNCH_PRICE = "lunchPrice";
	public static String PROP_SHELTER_PH_NO = "shelterPhNo";
	public static String PROP_SHELTER_LOGIN_PASSWORD = "shelterLoginPassword";
	public static String PROP_DINNER_PRICE = "dinnerPrice";
	public static String PROP_SHELTER_LOGIN_NAME = "shelterLoginName";
	public static String PROP_ID = "id";


	// constructors
	public BaseShelter () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShelter (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseShelter (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.City city,
		java.lang.String shelterLoginPassword,
		java.lang.String shelterLoginName,
		java.lang.String shelterName,
		java.lang.String shelterLocation,
		java.lang.String shelterPhNo,
		java.lang.String shelterEmail,
		java.lang.String principalName) {

		this.setId(id);
		this.setCity(city);
		this.setShelterLoginPassword(shelterLoginPassword);
		this.setShelterLoginName(shelterLoginName);
		this.setShelterName(shelterName);
		this.setShelterLocation(shelterLocation);
		this.setShelterPhNo(shelterPhNo);
		this.setShelterEmail(shelterEmail);
		this.setPrincipalName(principalName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String shelterLoginPassword;
	private java.lang.String shelterLoginName;
	private java.lang.String shelterName;
	private java.lang.String shelterLocation;
	private java.lang.String shelterPhNo;
	private java.lang.String shelterEmail;
	private java.lang.String principalName;
	private java.lang.Integer breakfastPrice;
	private java.lang.Integer lunchPrice;
	private java.lang.Integer dinnerPrice;
	private java.lang.Integer shelterDeleteStatus;

	// many to one
	private com.ictti.orrs.business.entity.City city;

	// collections
	private java.util.Set<com.ictti.orrs.business.entity.Adopter> adopters;
	private java.util.Set<com.ictti.orrs.business.entity.Orphan> orphans;
	private java.util.Set<com.ictti.orrs.business.entity.DonorShelter> donorShelters;
	private java.util.Set<com.ictti.orrs.business.entity.Event> events;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="shelter_id"
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
	 * Return the value associated with the column: shelter_login_password
	 */
	public java.lang.String getShelterLoginPassword () {
		return shelterLoginPassword;
	}

	/**
	 * Set the value related to the column: shelter_login_password
	 * @param shelterLoginPassword the shelter_login_password value
	 */
	public void setShelterLoginPassword (java.lang.String shelterLoginPassword) {
		this.shelterLoginPassword = shelterLoginPassword;
	}



	/**
	 * Return the value associated with the column: shelter_login_name
	 */
	public java.lang.String getShelterLoginName () {
		return shelterLoginName;
	}

	/**
	 * Set the value related to the column: shelter_login_name
	 * @param shelterLoginName the shelter_login_name value
	 */
	public void setShelterLoginName (java.lang.String shelterLoginName) {
		this.shelterLoginName = shelterLoginName;
	}



	/**
	 * Return the value associated with the column: shelter_name
	 */
	public java.lang.String getShelterName () {
		return shelterName;
	}

	/**
	 * Set the value related to the column: shelter_name
	 * @param shelterName the shelter_name value
	 */
	public void setShelterName (java.lang.String shelterName) {
		this.shelterName = shelterName;
	}



	/**
	 * Return the value associated with the column: shelter_location
	 */
	public java.lang.String getShelterLocation () {
		return shelterLocation;
	}

	/**
	 * Set the value related to the column: shelter_location
	 * @param shelterLocation the shelter_location value
	 */
	public void setShelterLocation (java.lang.String shelterLocation) {
		this.shelterLocation = shelterLocation;
	}



	/**
	 * Return the value associated with the column: shelter_ph_no
	 */
	public java.lang.String getShelterPhNo () {
		return shelterPhNo;
	}

	/**
	 * Set the value related to the column: shelter_ph_no
	 * @param shelterPhNo the shelter_ph_no value
	 */
	public void setShelterPhNo (java.lang.String shelterPhNo) {
		this.shelterPhNo = shelterPhNo;
	}



	/**
	 * Return the value associated with the column: shelter_email
	 */
	public java.lang.String getShelterEmail () {
		return shelterEmail;
	}

	/**
	 * Set the value related to the column: shelter_email
	 * @param shelterEmail the shelter_email value
	 */
	public void setShelterEmail (java.lang.String shelterEmail) {
		this.shelterEmail = shelterEmail;
	}



	/**
	 * Return the value associated with the column: principal_name
	 */
	public java.lang.String getPrincipalName () {
		return principalName;
	}

	/**
	 * Set the value related to the column: principal_name
	 * @param principalName the principal_name value
	 */
	public void setPrincipalName (java.lang.String principalName) {
		this.principalName = principalName;
	}



	/**
	 * Return the value associated with the column: breakfast_price
	 */
	public java.lang.Integer getBreakfastPrice () {
		return breakfastPrice;
	}

	/**
	 * Set the value related to the column: breakfast_price
	 * @param breakfastPrice the breakfast_price value
	 */
	public void setBreakfastPrice (java.lang.Integer breakfastPrice) {
		this.breakfastPrice = breakfastPrice;
	}



	/**
	 * Return the value associated with the column: lunch_price
	 */
	public java.lang.Integer getLunchPrice () {
		return lunchPrice;
	}

	/**
	 * Set the value related to the column: lunch_price
	 * @param lunchPrice the lunch_price value
	 */
	public void setLunchPrice (java.lang.Integer lunchPrice) {
		this.lunchPrice = lunchPrice;
	}



	/**
	 * Return the value associated with the column: dinner_price
	 */
	public java.lang.Integer getDinnerPrice () {
		return dinnerPrice;
	}

	/**
	 * Set the value related to the column: dinner_price
	 * @param dinnerPrice the dinner_price value
	 */
	public void setDinnerPrice (java.lang.Integer dinnerPrice) {
		this.dinnerPrice = dinnerPrice;
	}



	/**
	 * Return the value associated with the column: shelter_delete_status
	 */
	public java.lang.Integer getShelterDeleteStatus () {
		return shelterDeleteStatus;
	}

	/**
	 * Set the value related to the column: shelter_delete_status
	 * @param shelterDeleteStatus the shelter_delete_status value
	 */
	public void setShelterDeleteStatus (java.lang.Integer shelterDeleteStatus) {
		this.shelterDeleteStatus = shelterDeleteStatus;
	}



	/**
	 * Return the value associated with the column: city_id
	 */
	public com.ictti.orrs.business.entity.City getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city_id
	 * @param city the city_id value
	 */
	public void setCity (com.ictti.orrs.business.entity.City city) {
		this.city = city;
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



	/**
	 * Return the value associated with the column: orphans
	 */
	public java.util.Set<com.ictti.orrs.business.entity.Orphan> getOrphans () {
		return orphans;
	}

	/**
	 * Set the value related to the column: orphans
	 * @param orphans the orphans value
	 */
	public void setOrphans (java.util.Set<com.ictti.orrs.business.entity.Orphan> orphans) {
		this.orphans = orphans;
	}

	public void addToorphans (com.ictti.orrs.business.entity.Orphan orphan) {
		if (null == getOrphans()) setOrphans(new java.util.TreeSet<com.ictti.orrs.business.entity.Orphan>());
		getOrphans().add(orphan);
	}



	/**
	 * Return the value associated with the column: donorShelters
	 */
	public java.util.Set<com.ictti.orrs.business.entity.DonorShelter> getDonorShelters () {
		return donorShelters;
	}

	/**
	 * Set the value related to the column: donorShelters
	 * @param donorShelters the donorShelters value
	 */
	public void setDonorShelters (java.util.Set<com.ictti.orrs.business.entity.DonorShelter> donorShelters) {
		this.donorShelters = donorShelters;
	}

	public void addTodonorShelters (com.ictti.orrs.business.entity.DonorShelter donorShelter) {
		if (null == getDonorShelters()) setDonorShelters(new java.util.TreeSet<com.ictti.orrs.business.entity.DonorShelter>());
		getDonorShelters().add(donorShelter);
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
		if (!(obj instanceof com.ictti.orrs.business.entity.Shelter)) return false;
		else {
			com.ictti.orrs.business.entity.Shelter shelter = (com.ictti.orrs.business.entity.Shelter) obj;
			if (null == this.getId() || null == shelter.getId()) return false;
			else return (this.getId().equals(shelter.getId()));
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