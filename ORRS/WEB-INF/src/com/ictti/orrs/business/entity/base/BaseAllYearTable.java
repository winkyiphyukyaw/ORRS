package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the all_year_report table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="all_year_report"
 */

public abstract class BaseAllYearTable  implements Serializable {

	public static String REF = "AllYearTable";
	public static String PROP_CATEGORY = "category";
	public static String PROP_FUND = "fund";
	public static String PROP_ID = "id";
	public static String PROP_COST = "cost";
	public static String PROP_BALANCE = "balance";


	// constructors
	public BaseAllYearTable () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAllYearTable (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.math.BigDecimal fund;
	private java.lang.Double cost;
	private java.lang.Double balance;
	private java.lang.String category;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="id"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: fund
	 */
	public java.math.BigDecimal getFund () {
		return fund;
	}

	/**
	 * Set the value related to the column: fund
	 * @param fund the fund value
	 */
	public void setFund (java.math.BigDecimal fund) {
		this.fund = fund;
	}



	/**
	 * Return the value associated with the column: cost
	 */
	public java.lang.Double getCost () {
		return cost;
	}

	/**
	 * Set the value related to the column: cost
	 * @param cost the cost value
	 */
	public void setCost (java.lang.Double cost) {
		this.cost = cost;
	}



	/**
	 * Return the value associated with the column: balance
	 */
	public java.lang.Double getBalance () {
		return balance;
	}

	/**
	 * Set the value related to the column: balance
	 * @param balance the balance value
	 */
	public void setBalance (java.lang.Double balance) {
		this.balance = balance;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.AllYearTable)) return false;
		else {
			com.ictti.orrs.business.entity.AllYearTable allYearTable = (com.ictti.orrs.business.entity.AllYearTable) obj;
			if (null == this.getId() || null == allYearTable.getId()) return false;
			else return (this.getId().equals(allYearTable.getId()));
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