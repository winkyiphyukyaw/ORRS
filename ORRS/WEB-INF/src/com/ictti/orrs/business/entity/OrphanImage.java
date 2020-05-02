package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseOrphanImage;



public class OrphanImage extends BaseOrphanImage {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OrphanImage () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OrphanImage (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public OrphanImage (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Orphan orphan) {

		super (
			id,
			orphan);
	}

/*[CONSTRUCTOR MARKER END]*/


}