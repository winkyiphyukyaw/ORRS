package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the donor_category table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="donor_category"
 */

public abstract class BaseDonorCategory  implements Serializable {

	public static String REF = "DonorCategory";
	public static String PROP_DONATE_DATE = "donateDate";
	public static String PROP_CATEGORY = "category";
	public static String PROP_DONOR = "donor";
	public static String PROP_ID = "id";


	// constructors
	public BaseDonorCategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDonorCategory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDonorCategory (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Category category,
		com.ictti.orrs.business.entity.Donor donor) {

		this.setId(id);
		this.setCategory(category);
		this.setDonor(donor);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date donateDate;

	// many to one
	private com.ictti.orrs.business.entity.Category category;
	private com.ictti.orrs.business.entity.Donor donor;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="donor_category_id"
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.DonorCategory)) return false;
		else {
			com.ictti.orrs.business.entity.DonorCategory donorCategory = (com.ictti.orrs.business.entity.DonorCategory) obj;
			if (null == this.getId() || null == donorCategory.getId()) return false;
			else return (this.getId().equals(donorCategory.getId()));
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