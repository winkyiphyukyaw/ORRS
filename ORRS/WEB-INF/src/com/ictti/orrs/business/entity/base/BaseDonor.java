package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the donor table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="donor"
 */

public abstract class BaseDonor  implements Serializable {

	public static String REF = "Donor";
	public static String PROP_DONOR_NRC = "donorNrc";
	public static String PROP_COMMENT = "comment";
	public static String PROP_DONOR_NAME = "donorName";
	public static String PROP_DONOR_ADDRESS = "donorAddress";
	public static String PROP_AMOUNT = "amount";
	public static String PROP_ID = "id";
	public static String PROP_DONOR_PH_NO = "donorPhNo";
	public static String PROP_DONOR_EMAIL = "donorEmail";
	public static String PROP_NO_OF_DONATE_TIME = "noOfDonateTime";
	public static String PROP_CREDIT_CARD = "creditCard";
	public static String PROP_KIND_OF_DONATE = "kindOfDonate";


	// constructors
	public BaseDonor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDonor (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDonor (
		java.lang.Integer id,
		java.lang.Integer amount,
		java.lang.String creditCard) {

		this.setId(id);
		this.setAmount(amount);
		this.setCreditCard(creditCard);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String donorName;
	private java.lang.String donorNrc;
	private java.lang.String donorPhNo;
	private java.lang.String donorAddress;
	private java.lang.String donorEmail;
	private java.lang.Integer amount;
	private java.lang.String comment;
	private java.lang.String creditCard;
	private java.lang.Integer kindOfDonate;
	private java.lang.Integer noOfDonateTime;

	// collections
	private java.util.Set<com.ictti.orrs.business.entity.DonorShelter> donorShelters;
	private java.util.Set<com.ictti.orrs.business.entity.DonorCategory> donorCategories;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="donor_id"
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
	 * Return the value associated with the column: donor_name
	 */
	public java.lang.String getDonorName () {
		return donorName;
	}

	/**
	 * Set the value related to the column: donor_name
	 * @param donorName the donor_name value
	 */
	public void setDonorName (java.lang.String donorName) {
		this.donorName = donorName;
	}



	/**
	 * Return the value associated with the column: donor_nrc
	 */
	public java.lang.String getDonorNrc () {
		return donorNrc;
	}

	/**
	 * Set the value related to the column: donor_nrc
	 * @param donorNrc the donor_nrc value
	 */
	public void setDonorNrc (java.lang.String donorNrc) {
		this.donorNrc = donorNrc;
	}



	/**
	 * Return the value associated with the column: donor_ph_no
	 */
	public java.lang.String getDonorPhNo () {
		return donorPhNo;
	}

	/**
	 * Set the value related to the column: donor_ph_no
	 * @param donorPhNo the donor_ph_no value
	 */
	public void setDonorPhNo (java.lang.String donorPhNo) {
		this.donorPhNo = donorPhNo;
	}



	/**
	 * Return the value associated with the column: donor_address
	 */
	public java.lang.String getDonorAddress () {
		return donorAddress;
	}

	/**
	 * Set the value related to the column: donor_address
	 * @param donorAddress the donor_address value
	 */
	public void setDonorAddress (java.lang.String donorAddress) {
		this.donorAddress = donorAddress;
	}



	/**
	 * Return the value associated with the column: donor_email
	 */
	public java.lang.String getDonorEmail () {
		return donorEmail;
	}

	/**
	 * Set the value related to the column: donor_email
	 * @param donorEmail the donor_email value
	 */
	public void setDonorEmail (java.lang.String donorEmail) {
		this.donorEmail = donorEmail;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.lang.Integer getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.lang.Integer amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: comment
	 */
	public java.lang.String getComment () {
		return comment;
	}

	/**
	 * Set the value related to the column: comment
	 * @param comment the comment value
	 */
	public void setComment (java.lang.String comment) {
		this.comment = comment;
	}



	/**
	 * Return the value associated with the column: credit_card
	 */
	public java.lang.String getCreditCard () {
		return creditCard;
	}

	/**
	 * Set the value related to the column: credit_card
	 * @param creditCard the credit_card value
	 */
	public void setCreditCard (java.lang.String creditCard) {
		this.creditCard = creditCard;
	}



	/**
	 * Return the value associated with the column: kind_of_donate
	 */
	public java.lang.Integer getKindOfDonate () {
		return kindOfDonate;
	}

	/**
	 * Set the value related to the column: kind_of_donate
	 * @param kindOfDonate the kind_of_donate value
	 */
	public void setKindOfDonate (java.lang.Integer kindOfDonate) {
		this.kindOfDonate = kindOfDonate;
	}



	/**
	 * Return the value associated with the column: no_of_donate_time
	 */
	public java.lang.Integer getNoOfDonateTime () {
		return noOfDonateTime;
	}

	/**
	 * Set the value related to the column: no_of_donate_time
	 * @param noOfDonateTime the no_of_donate_time value
	 */
	public void setNoOfDonateTime (java.lang.Integer noOfDonateTime) {
		this.noOfDonateTime = noOfDonateTime;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.Donor)) return false;
		else {
			com.ictti.orrs.business.entity.Donor donor = (com.ictti.orrs.business.entity.Donor) obj;
			if (null == this.getId() || null == donor.getId()) return false;
			else return (this.getId().equals(donor.getId()));
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