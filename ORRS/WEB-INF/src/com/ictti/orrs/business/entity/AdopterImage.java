package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseAdopterImage;



public class AdopterImage extends BaseAdopterImage {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public AdopterImage () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public AdopterImage (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public AdopterImage (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Adopter adopter) {

		super (
			id,
			adopter);
	}

/*[CONSTRUCTOR MARKER END]*/


}