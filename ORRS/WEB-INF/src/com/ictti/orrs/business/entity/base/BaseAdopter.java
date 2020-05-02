package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the adopter table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="adopter"
 */

public abstract class BaseAdopter  implements Serializable {

	public static String REF = "Adopter";
	public static String PROP_ADOPTER_GENDER = "adopterGender";
	public static String PROP_ADOPTER_NAME = "adopterName";
	public static String PROP_ADOPTER_EMAIL = "adopterEmail";
	public static String PROP_ADOPTER_INCOME = "adopterIncome";
	public static String PROP_ADOPTER_OCCUPATION = "adopterOccupation";
	public static String PROP_ADOPTER_ADDRESS = "adopterAddress";
	public static String PROP_ADOPTER_DOB = "adopterDob";
	public static String PROP_ADOPTER_DELETE_STATUS = "adopterDeleteStatus";
	public static String PROP_CITY = "city";
	public static String PROP_ADOPTER_NO_OF_CHILDREN = "adopterNoOfChildren";
	public static String PROP_ADOPTED_CHILD_NO = "adoptedChildNo";
	public static String PROP_ADOPTER_ORPHAN_AGE = "adopterOrphanAge";
	public static String PROP_ADOPTER_NRC = "adopterNrc";
	public static String PROP_REGION_STATE = "regionState";
	public static String PROP_ADOPTER_MARITAL_STATUS = "adopterMaritalStatus";
	public static String PROP_ADOPTER_ORPHAN_GENDER = "adopterOrphanGender";
	public static String PROP_SHELTER = "shelter";
	public static String PROP_ID = "id";
	public static String PROP_ADOPTER_PH_NO = "adopterPhNo";
	public static String PROP_MAIL_STATUS = "mailStatus";


	// constructors
	public BaseAdopter () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAdopter (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAdopter (
		java.lang.Integer id,
		java.lang.String adopterName,
		java.lang.String adopterEmail,
		java.lang.String adopterPhNo,
		java.lang.String adopterAddress,
		java.lang.String adopterNrc,
		java.lang.String adopterIncome,
		java.lang.String adopterOccupation,
		java.lang.String adopterMaritalStatus,
		java.lang.String adopterGender,
		java.lang.Integer adopterNoOfChildren,
		java.util.Date adopterDob,
		java.lang.String adopterOrphanGender) {

		this.setId(id);
		this.setAdopterName(adopterName);
		this.setAdopterEmail(adopterEmail);
		this.setAdopterPhNo(adopterPhNo);
		this.setAdopterAddress(adopterAddress);
		this.setAdopterNrc(adopterNrc);
		this.setAdopterIncome(adopterIncome);
		this.setAdopterOccupation(adopterOccupation);
		this.setAdopterMaritalStatus(adopterMaritalStatus);
		this.setAdopterGender(adopterGender);
		this.setAdopterNoOfChildren(adopterNoOfChildren);
		this.setAdopterDob(adopterDob);
		this.setAdopterOrphanGender(adopterOrphanGender);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adopterName;
	private java.lang.String adopterEmail;
	private java.lang.String adopterPhNo;
	private java.lang.String adopterAddress;
	private java.lang.String adopterNrc;
	private java.lang.String adopterIncome;
	private java.lang.String adopterOccupation;
	private java.lang.String adopterMaritalStatus;
	private java.lang.String adopterGender;
	private java.lang.Integer adopterNoOfChildren;
	private java.util.Date adopterDob;
	private java.lang.String adopterOrphanAge;
	private java.lang.String adopterOrphanGender;
	private java.lang.Integer adoptedChildNo;
	private java.lang.Integer adopterDeleteStatus;
	private java.lang.Integer mailStatus;

	// many to one
	private com.ictti.orrs.business.entity.Shelter shelter;
	private com.ictti.orrs.business.entity.RegionState regionState;
	private com.ictti.orrs.business.entity.City city;

	// collections
	private java.util.Set<com.ictti.orrs.business.entity.Orphan> orphans;
	private java.util.Set<com.ictti.orrs.business.entity.AdopterImage> adopterImages;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="adopter_id"
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
	 * Return the value associated with the column: adopter_name
	 */
	public java.lang.String getAdopterName () {
		return adopterName;
	}

	/**
	 * Set the value related to the column: adopter_name
	 * @param adopterName the adopter_name value
	 */
	public void setAdopterName (java.lang.String adopterName) {
		this.adopterName = adopterName;
	}



	/**
	 * Return the value associated with the column: adopter_email
	 */
	public java.lang.String getAdopterEmail () {
		return adopterEmail;
	}

	/**
	 * Set the value related to the column: adopter_email
	 * @param adopterEmail the adopter_email value
	 */
	public void setAdopterEmail (java.lang.String adopterEmail) {
		this.adopterEmail = adopterEmail;
	}



	/**
	 * Return the value associated with the column: adopter_ph_no
	 */
	public java.lang.String getAdopterPhNo () {
		return adopterPhNo;
	}

	/**
	 * Set the value related to the column: adopter_ph_no
	 * @param adopterPhNo the adopter_ph_no value
	 */
	public void setAdopterPhNo (java.lang.String adopterPhNo) {
		this.adopterPhNo = adopterPhNo;
	}



	/**
	 * Return the value associated with the column: adopter_address
	 */
	public java.lang.String getAdopterAddress () {
		return adopterAddress;
	}

	/**
	 * Set the value related to the column: adopter_address
	 * @param adopterAddress the adopter_address value
	 */
	public void setAdopterAddress (java.lang.String adopterAddress) {
		this.adopterAddress = adopterAddress;
	}



	/**
	 * Return the value associated with the column: adopter_nrc
	 */
	public java.lang.String getAdopterNrc () {
		return adopterNrc;
	}

	/**
	 * Set the value related to the column: adopter_nrc
	 * @param adopterNrc the adopter_nrc value
	 */
	public void setAdopterNrc (java.lang.String adopterNrc) {
		this.adopterNrc = adopterNrc;
	}



	/**
	 * Return the value associated with the column: adopter_income
	 */
	public java.lang.String getAdopterIncome () {
		return adopterIncome;
	}

	/**
	 * Set the value related to the column: adopter_income
	 * @param adopterIncome the adopter_income value
	 */
	public void setAdopterIncome (java.lang.String adopterIncome) {
		this.adopterIncome = adopterIncome;
	}



	/**
	 * Return the value associated with the column: adopter_occupation
	 */
	public java.lang.String getAdopterOccupation () {
		return adopterOccupation;
	}

	/**
	 * Set the value related to the column: adopter_occupation
	 * @param adopterOccupation the adopter_occupation value
	 */
	public void setAdopterOccupation (java.lang.String adopterOccupation) {
		this.adopterOccupation = adopterOccupation;
	}



	/**
	 * Return the value associated with the column: adopter_marital_status
	 */
	public java.lang.String getAdopterMaritalStatus () {
		return adopterMaritalStatus;
	}

	/**
	 * Set the value related to the column: adopter_marital_status
	 * @param adopterMaritalStatus the adopter_marital_status value
	 */
	public void setAdopterMaritalStatus (java.lang.String adopterMaritalStatus) {
		this.adopterMaritalStatus = adopterMaritalStatus;
	}



	/**
	 * Return the value associated with the column: adopter_gender
	 */
	public java.lang.String getAdopterGender () {
		return adopterGender;
	}

	/**
	 * Set the value related to the column: adopter_gender
	 * @param adopterGender the adopter_gender value
	 */
	public void setAdopterGender (java.lang.String adopterGender) {
		this.adopterGender = adopterGender;
	}



	/**
	 * Return the value associated with the column: adopter_no_of_children
	 */
	public java.lang.Integer getAdopterNoOfChildren () {
		return adopterNoOfChildren;
	}

	/**
	 * Set the value related to the column: adopter_no_of_children
	 * @param adopterNoOfChildren the adopter_no_of_children value
	 */
	public void setAdopterNoOfChildren (java.lang.Integer adopterNoOfChildren) {
		this.adopterNoOfChildren = adopterNoOfChildren;
	}



	/**
	 * Return the value associated with the column: adopter_dob
	 */
	public java.util.Date getAdopterDob () {
		return adopterDob;
	}

	/**
	 * Set the value related to the column: adopter_dob
	 * @param adopterDob the adopter_dob value
	 */
	public void setAdopterDob (java.util.Date adopterDob) {
		this.adopterDob = adopterDob;
	}



	/**
	 * Return the value associated with the column: adopter_orphan_age
	 */
	public java.lang.String getAdopterOrphanAge () {
		return adopterOrphanAge;
	}

	/**
	 * Set the value related to the column: adopter_orphan_age
	 * @param adopterOrphanAge the adopter_orphan_age value
	 */
	public void setAdopterOrphanAge (java.lang.String adopterOrphanAge) {
		this.adopterOrphanAge = adopterOrphanAge;
	}



	/**
	 * Return the value associated with the column: adopter_orphan_gender
	 */
	public java.lang.String getAdopterOrphanGender () {
		return adopterOrphanGender;
	}

	/**
	 * Set the value related to the column: adopter_orphan_gender
	 * @param adopterOrphanGender the adopter_orphan_gender value
	 */
	public void setAdopterOrphanGender (java.lang.String adopterOrphanGender) {
		this.adopterOrphanGender = adopterOrphanGender;
	}



	/**
	 * Return the value associated with the column: adopted_child_no
	 */
	public java.lang.Integer getAdoptedChildNo () {
		return adoptedChildNo;
	}

	/**
	 * Set the value related to the column: adopted_child_no
	 * @param adoptedChildNo the adopted_child_no value
	 */
	public void setAdoptedChildNo (java.lang.Integer adoptedChildNo) {
		this.adoptedChildNo = adoptedChildNo;
	}



	/**
	 * Return the value associated with the column: adopter_delete_status
	 */
	public java.lang.Integer getAdopterDeleteStatus () {
		return adopterDeleteStatus;
	}

	/**
	 * Set the value related to the column: adopter_delete_status
	 * @param adopterDeleteStatus the adopter_delete_status value
	 */
	public void setAdopterDeleteStatus (java.lang.Integer adopterDeleteStatus) {
		this.adopterDeleteStatus = adopterDeleteStatus;
	}



	/**
	 * Return the value associated with the column: mail_status
	 */
	public java.lang.Integer getMailStatus () {
		return mailStatus;
	}

	/**
	 * Set the value related to the column: mail_status
	 * @param mailStatus the mail_status value
	 */
	public void setMailStatus (java.lang.Integer mailStatus) {
		this.mailStatus = mailStatus;
	}



	/**
	 * Return the value associated with the column: shelter_id
	 */
	public com.ictti.orrs.business.entity.Shelter getShelter () {
		return shelter;
	}

	/**
	 * Set the value related to the column: shelter_id
	 * @param shelter the shelter_id value
	 */
	public void setShelter (com.ictti.orrs.business.entity.Shelter shelter) {
		this.shelter = shelter;
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



	/**
	 * Return the value associated with the column: adopterImages
	 */
	public java.util.Set<com.ictti.orrs.business.entity.AdopterImage> getAdopterImages () {
		return adopterImages;
	}

	/**
	 * Set the value related to the column: adopterImages
	 * @param adopterImages the adopterImages value
	 */
	public void setAdopterImages (java.util.Set<com.ictti.orrs.business.entity.AdopterImage> adopterImages) {
		this.adopterImages = adopterImages;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.Adopter)) return false;
		else {
			com.ictti.orrs.business.entity.Adopter adopter = (com.ictti.orrs.business.entity.Adopter) obj;
			if (null == this.getId() || null == adopter.getId()) return false;
			else return (this.getId().equals(adopter.getId()));
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