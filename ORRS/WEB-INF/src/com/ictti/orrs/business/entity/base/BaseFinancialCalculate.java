package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the financial_calculate table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="financial_calculate"
 */

public abstract class BaseFinancialCalculate  implements Serializable {

	public static String REF = "FinancialCalculate";
	public static String PROP_CATEGORY = "category";
	public static String PROP_MONTHLY_OUTCOME = "monthlyOutcome";
	public static String PROP_REPORT_DATE = "reportDate";
	public static String PROP_ID = "id";


	// constructors
	public BaseFinancialCalculate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFinancialCalculate (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFinancialCalculate (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Category category) {

		this.setId(id);
		this.setCategory(category);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Double monthlyOutcome;
	private java.util.Date reportDate;

	// many to one
	private com.ictti.orrs.business.entity.Category category;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="financial_calculate_id"
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
	 * Return the value associated with the column: monthly_outcome
	 */
	public java.lang.Double getMonthlyOutcome () {
		return monthlyOutcome;
	}

	/**
	 * Set the value related to the column: monthly_outcome
	 * @param monthlyOutcome the monthly_outcome value
	 */
	public void setMonthlyOutcome (java.lang.Double monthlyOutcome) {
		this.monthlyOutcome = monthlyOutcome;
	}



	/**
	 * Return the value associated with the column: report_date
	 */
	public java.util.Date getReportDate () {
		return reportDate;
	}

	/**
	 * Set the value related to the column: report_date
	 * @param reportDate the report_date value
	 */
	public void setReportDate (java.util.Date reportDate) {
		this.reportDate = reportDate;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.FinancialCalculate)) return false;
		else {
			com.ictti.orrs.business.entity.FinancialCalculate financialCalculate = (com.ictti.orrs.business.entity.FinancialCalculate) obj;
			if (null == this.getId() || null == financialCalculate.getId()) return false;
			else return (this.getId().equals(financialCalculate.getId()));
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