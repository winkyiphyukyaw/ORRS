package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseDonor;



public class Donor extends BaseDonor {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Donor () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Donor (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Donor (
		java.lang.Integer id,
		java.lang.Integer amount,
		java.lang.String creditCard) {

		super (
			id,
			amount,
			creditCard);
	}

/*[CONSTRUCTOR MARKER END]*/


}