package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseDonorShelter;



public class DonorShelter extends BaseDonorShelter {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public DonorShelter () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public DonorShelter (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public DonorShelter (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Category category,
		com.ictti.orrs.business.entity.Donor donor,
		com.ictti.orrs.business.entity.Shelter shelter) {

		super (
			id,
			category,
			donor,
			shelter);
	}

/*[CONSTRUCTOR MARKER END]*/


}