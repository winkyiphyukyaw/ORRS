package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseEvent;



public class Event extends BaseEvent {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Event () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Event (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Event (
		java.lang.Integer id,
		java.util.Date eventDate,
		java.lang.Integer eventStatus) {

		super (
			id,
			eventDate,
			eventStatus);
	}

/*[CONSTRUCTOR MARKER END]*/


}