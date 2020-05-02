package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the shelter_yearly_report_all_category_view table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="shelter_yearly_report_all_category_view"
 */

public abstract class BaseShelterYearlyReportAllCategoryTable  implements Serializable {

	public static String REF = "ShelterYearlyReportAllCategoryTable";
	public static String PROP_SHELTER_NAME = "shelterName";
	public static String PROP_YEAR = "year";
	public static String PROP_AMOUNT = "amount";
	public static String PROP_ID = "id";
	public static String PROP_SHELTER_ID = "shelterId";


	// constructors
	public BaseShelterYearlyReportAllCategoryTable () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShelterYearlyReportAllCategoryTable (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer shelterId;
	private java.lang.String shelterName;
	private java.lang.Integer year;
	private java.math.BigDecimal amount;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="id"
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
	 * Return the value associated with the column: shelter_id
	 */
	public java.lang.Integer getShelterId () {
		return shelterId;
	}

	/**
	 * Set the value related to the column: shelter_id
	 * @param shelterId the shelter_id value
	 */
	public void setShelterId (java.lang.Integer shelterId) {
		this.shelterId = shelterId;
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
	 * Return the value associated with the column: year
	 */
	public java.lang.Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * @param year the year value
	 */
	public void setYear (java.lang.Integer year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.ShelterYearlyReportAllCategoryTable)) return false;
		else {
			com.ictti.orrs.business.entity.ShelterYearlyReportAllCategoryTable shelterYearlyReportAllCategoryTable = (com.ictti.orrs.business.entity.ShelterYearlyReportAllCategoryTable) obj;
			if (null == this.getId() || null == shelterYearlyReportAllCategoryTable.getId()) return false;
			else return (this.getId().equals(shelterYearlyReportAllCategoryTable.getId()));
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