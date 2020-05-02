package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the donor_shelter table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="donor_shelter"
 */

public abstract class BaseDonorShelter  implements Serializable {

	public static String REF = "DonorShelter";
	public static String PROP_DONATE_DATE = "donateDate";
	public static String PROP_CATEGORY = "category";
	public static String PROP_DONOR = "donor";
	public static String PROP_DONATE_MEAL_DATE = "donateMealDate";
	public static String PROP_KIND_OF_MEAL = "kindOfMeal";
	public static String PROP_SHELTER = "shelter";
	public static String PROP_ID = "id";


	// constructors
	public BaseDonorShelter () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDonorShelter (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDonorShelter (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Category category,
		com.ictti.orrs.business.entity.Donor donor,
		com.ictti.orrs.business.entity.Shelter shelter) {

		this.setId(id);
		this.setCategory(category);
		this.setDonor(donor);
		this.setShelter(shelter);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date donateDate;
	private java.lang.String kindOfMeal;
	private java.util.Date donateMealDate;

	// many to one
	private com.ictti.orrs.business.entity.Category category;
	private com.ictti.orrs.business.entity.Donor donor;
	private com.ictti.orrs.business.entity.Shelter shelter;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="donor_shelter_id"
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
	 * Return the value associated with the column: donate_date
	 */
	public java.util.Date getDonateDate () {
		return donateDate;
	}

	/**
	 * Set the value related to the column: donate_date
	 * @param donateDate the donate_date value
	 */
	public void setDonateDate (java.util.Date donateDate) {
		this.donateDate = donateDate;
	}



	/**
	 * Return the value associated with the column: kind_of_meal
	 */
	public java.lang.String getKindOfMeal () {
		return kindOfMeal;
	}

	/**
	 * Set the value related to the column: kind_of_meal
	 * @param kindOfMeal the kind_of_meal value
	 */
	public void setKindOfMeal (java.lang.String kindOfMeal) {
		this.kindOfMeal = kindOfMeal;
	}



	/**
	 * Return the value associated with the column: donate_meal_date
	 */
	public java.util.Date getDonateMealDate () {
		return donateMealDate;
	}

	/**
	 * Set the value related to the column: donate_meal_date
	 * @param donateMealDate the donate_meal_date value
	 */
	public void setDonateMealDate (java.util.Date donateMealDate) {
		this.donateMealDate = donateMealDate;
	}



	/**
	 * Return the value associated with the column: category_id
	 */
	public com.ictti.orrs.business.entity.Category getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category_id
	 * @param category the category_id value
	 */
	public void setCategory (com.ictti.orrs.business.entity.Category category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: donor_id
	 */
	public com.ictti.orrs.business.entity.Donor getDonor () {
		return donor;
	}

	/**
	 * Set the value related to the column: donor_id
	 * @param donor the donor_id value
	 */
	public void setDonor (com.ictti.orrs.business.entity.Donor donor) {
		this.donor = donor;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.DonorShelter)) return false;
		else {
			com.ictti.orrs.business.entity.DonorShelter donorShelter = (com.ictti.orrs.business.entity.DonorShelter) obj;
			if (null == this.getId() || null == donorShelter.getId()) return false;
			else return (this.getId().equals(donorShelter.getId()));
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