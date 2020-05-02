package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseShelter;



public class Shelter extends BaseShelter {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Shelter () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Shelter (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Shelter (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.City city,
		java.lang.String shelterLoginPassword,
		java.lang.String shelterLoginName,
		java.lang.String shelterName,
		java.lang.String shelterLocation,
		java.lang.String shelterPhNo,
		java.lang.String shelterEmail,
		java.lang.String principalName) {

		super (
			id,
			city,
			shelterLoginPassword,
			shelterLoginName,
			shelterName,
			shelterLocation,
			shelterPhNo,
			shelterEmail,
			principalName);
	}

/*[CONSTRUCTOR MARKER END]*/


}