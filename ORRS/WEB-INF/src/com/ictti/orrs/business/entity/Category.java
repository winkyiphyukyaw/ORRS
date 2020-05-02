package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseCategory;



public class Category extends BaseCategory {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Category () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Category (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Category (
		java.lang.Integer id,
		java.lang.String type) {

		super (
			id,
			type);
	}

/*[CONSTRUCTOR MARKER END]*/


}