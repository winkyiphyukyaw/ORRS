package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the category table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="category"
 */

public abstract class BaseCategory  implements Serializable {

	public static String REF = "Category";
	public static String PROP_TYPE = "type";
	public static String PROP_ID = "id";


	// constructors
	public BaseCategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCategory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCategory (
		java.lang.Integer id,
		java.lang.String type) {

		this.setId(id);
		this.setType(type);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String type;

	// collections
	private java.util.Set<com.ictti.orrs.business.entity.DonorShelter> donorShelters;
	private java.util.Set<com.ictti.orrs.business.entity.DonorCategory> donorCategories;
	private java.util.Set<com.ictti.orrs.business.entity.FinancialCalculate> financialCalculates;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="category_id"
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
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
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
	 * Return the value associated with the column: donorCategories
	 */
	public java.util.Set<com.ictti.orrs.business.entity.DonorCategory> getDonorCategories () {
		return donorCategories;
	}

	/**
	 * Set the value related to the column: donorCategories
	 * @param donorCategories the donorCategories value
	 */
	public void setDonorCategories (java.util.Set<com.ictti.orrs.business.entity.DonorCategory> donorCategories) {
		this.donorCategories = donorCategories;
	}

	public void addTodonorCategories (com.ictti.orrs.business.entity.DonorCategory donorCategory) {
		if (null == getDonorCategories()) setDonorCategories(new java.util.TreeSet<com.ictti.orrs.business.entity.DonorCategory>());
		getDonorCategories().add(donorCategory);
	}



	/**
	 * Return the value associated with the column: financialCalculates
	 */
	public java.util.Set<com.ictti.orrs.business.entity.FinancialCalculate> getFinancialCalculates () {
		return financialCalculates;
	}

	/**
	 * Set the value related to the column: financialCalculates
	 * @param financialCalculates the financialCalculates value
	 */
	public void setFinancialCalculates (java.util.Set<com.ictti.orrs.business.entity.FinancialCalculate> financialCalculates) {
		this.financialCalculates = financialCalculates;
	}

	public void addTofinancialCalculates (com.ictti.orrs.business.entity.FinancialCalculate financialCalculate) {
		if (null == getFinancialCalculates()) setFinancialCalculates(new java.util.TreeSet<com.ictti.orrs.business.entity.FinancialCalculate>());
		getFinancialCalculates().add(financialCalculate);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.Category)) return false;
		else {
			com.ictti.orrs.business.entity.Category category = (com.ictti.orrs.business.entity.Category) obj;
			if (null == this.getId() || null == category.getId()) return false;
			else return (this.getId().equals(category.getId()));
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