package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseAdopter;



public class Adopter extends BaseAdopter {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Adopter () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Adopter (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Adopter (
		java.lang.Integer id,
		java.lang.String adopterName,
		java.lang.String adopterEmail,
		java.lang.String adopterPhNo,
		java.lang.String adopterAddress,
		java.lang.String adopterNrc,
		java.lang.String adopterIncome,
		java.lang.String adopterOccupation,
		java.lang.String adopterMaritalStatus,
		java.lang.String adopterGender,
		java.lang.Integer adopterNoOfChildren,
		java.util.Date adopterDob,
		java.lang.String adopterOrphanGender) {

		super (
			id,
			adopterName,
			adopterEmail,
			adopterPhNo,
			adopterAddress,
			adopterNrc,
			adopterIncome,
			adopterOccupation,
			adopterMaritalStatus,
			adopterGender,
			adopterNoOfChildren,
			adopterDob,
			adopterOrphanGender);
	}

/*[CONSTRUCTOR MARKER END]*/


}