package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseDonorCategory;



public class DonorCategory extends BaseDonorCategory {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public DonorCategory () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public DonorCategory (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public DonorCategory (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Category category,
		com.ictti.orrs.business.entity.Donor donor) {

		super (
			id,
			category,
			donor);
	}

/*[CONSTRUCTOR MARKER END]*/


}