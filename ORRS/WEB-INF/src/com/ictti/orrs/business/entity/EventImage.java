package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseEventImage;



public class EventImage extends BaseEventImage {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public EventImage () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public EventImage (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public EventImage (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Event event) {

		super (
			id,
			event);
	}

/*[CONSTRUCTOR MARKER END]*/


}