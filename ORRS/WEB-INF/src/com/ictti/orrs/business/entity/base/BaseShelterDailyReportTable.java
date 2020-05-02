package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the shelter_daily_report_view table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="shelter_daily_report_view"
 */

public abstract class BaseShelterDailyReportTable  implements Serializable {

	public static String REF = "ShelterDailyReportTable";
	public static String PROP_DONATE_DATE = "donateDate";
	public static String PROP_MONTH = "month";
	public static String PROP_SHELTER_NAME = "shelterName";
	public static String PROP_CATEGORY = "category";
	public static String PROP_YEAR = "year";
	public static String PROP_AMOUNT = "amount";
	public static String PROP_ID = "id";
	public static String PROP_SHELTER_ID = "shelterId";
	public static String PROP_DAY = "day";


	// constructors
	public BaseShelterDailyReportTable () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShelterDailyReportTable (java.lang.Integer id) {
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
	private java.lang.String category;
	private java.lang.Integer year;
	private java.lang.String month;
	private java.lang.Integer day;
	private java.util.Date donateDate;
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
	 * Return the value associated with the column: category
	 */
	public java.lang.String getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category
	 * @param category the category value
	 */
	public void setCategory (java.lang.String category) {
		this.category = category;
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
	 * Return the value associated with the column: month
	 */
	public java.lang.String getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: month
	 * @param month the month value
	 */
	public void setMonth (java.lang.String month) {
		this.month = month;
	}



	/**
	 * Return the value associated with the column: day
	 */
	public java.lang.Integer getDay () {
		return day;
	}

	/**
	 * Set the value related to the column: day
	 * @param day the day value
	 */
	public void setDay (java.lang.Integer day) {
		this.day = day;
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
		if (!(obj instanceof com.ictti.orrs.business.entity.ShelterDailyReportTable)) return false;
		else {
			com.ictti.orrs.business.entity.ShelterDailyReportTable shelterDailyReportTable = (com.ictti.orrs.business.entity.ShelterDailyReportTable) obj;
			if (null == this.getId() || null == shelterDailyReportTable.getId()) return false;
			else return (this.getId().equals(shelterDailyReportTable.getId()));
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