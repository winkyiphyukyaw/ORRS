package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the yearly_foundation_fund table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="yearly_foundation_fund"
 */

public abstract class BaseYearlyFoundationTable  implements Serializable {

	public static String REF = "YearlyFoundationTable";
	public static String PROP_CATEGORY = "category";
	public static String PROP_YEAR = "year";
	public static String PROP_YEARLY_FUND = "yearlyFund";
	public static String PROP_ID = "id";


	// constructors
	public BaseYearlyFoundationTable () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseYearlyFoundationTable (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String category;
	private java.lang.String year;
	private java.math.BigDecimal yearlyFund;



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
	public java.lang.String getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * @param year the year value
	 */
	public void setYear (java.lang.String year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: yearly_fund
	 */
	public java.math.BigDecimal getYearlyFund () {
		return yearlyFund;
	}

	/**
	 * Set the value related to the column: yearly_fund
	 * @param yearlyFund the yearly_fund value
	 */
	public void setYearlyFund (java.math.BigDecimal yearlyFund) {
		this.yearlyFund = yearlyFund;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.YearlyFoundationTable)) return false;
		else {
			com.ictti.orrs.business.entity.YearlyFoundationTable yearlyFoundationTable = (com.ictti.orrs.business.entity.YearlyFoundationTable) obj;
			if (null == this.getId() || null == yearlyFoundationTable.getId()) return false;
			else return (this.getId().equals(yearlyFoundationTable.getId()));
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