package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseCity;



public class City extends BaseCity {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public City () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public City (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public City (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.RegionState regionState) {

		super (
			id,
			regionState);
	}

/*[CONSTRUCTOR MARKER END]*/


}