package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the event table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="event"
 */

public abstract class BaseEvent  implements Serializable {

	public static String REF = "Event";
	public static String PROP_STORY_EVENT_STATUS = "storyEventStatus";
	public static String PROP_EVENT_DATE = "eventDate";
	public static String PROP_EVENT_TEXT = "eventText";
	public static String PROP_EVENT_STATUS = "eventStatus";
	public static String PROP_SHELTER = "shelter";
	public static String PROP_PERMIT_STATUS = "permitStatus";
	public static String PROP_ID = "id";
	public static String PROP_ADMIN = "admin";


	// constructors
	public BaseEvent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEvent (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEvent (
		java.lang.Integer id,
		java.util.Date eventDate,
		java.lang.Integer eventStatus) {

		this.setId(id);
		this.setEventDate(eventDate);
		this.setEventStatus(eventStatus);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String eventText;
	private java.util.Date eventDate;
	private java.lang.Integer eventStatus;
	private java.lang.Integer permitStatus;
	private java.lang.Integer storyEventStatus;

	// many to one
	private com.ictti.orrs.business.entity.Admin admin;
	private com.ictti.orrs.business.entity.Shelter shelter;

	// collections
	private java.util.Set<com.ictti.orrs.business.entity.EventImage> eventImages;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="event_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: event_text
	 */
	public java.lang.String getEventText () {
		return eventText;
	}

	/**
	 * Set the value related to the column: event_text
	 * @param eventText the event_text value
	 */
	public void setEventText (java.lang.String eventText) {
		this.eventText = eventText;
	}



	/**
	 * Return the value associated with the column: event_date
	 */
	public java.util.Date getEventDate () {
		return eventDate;
	}

	/**
	 * Set the value related to the column: event_date
	 * @param eventDate the event_date value
	 */
	public void setEventDate (java.util.Date eventDate) {
		this.eventDate = eventDate;
	}



	/**
	 * Return the value associated with the column: event_status
	 */
	public java.lang.Integer getEventStatus () {
		return eventStatus;
	}

	/**
	 * Set the value related to the column: event_status
	 * @param eventStatus the event_status value
	 */
	public void setEventStatus (java.lang.Integer eventStatus) {
		this.eventStatus = eventStatus;
	}



	/**
	 * Return the value associated with the column: permit_status
	 */
	public java.lang.Integer getPermitStatus () {
		return permitStatus;
	}

	/**
	 * Set the value related to the column: permit_status
	 * @param permitStatus the permit_status value
	 */
	public void setPermitStatus (java.lang.Integer permitStatus) {
		this.permitStatus = permitStatus;
	}



	/**
	 * Return the value associated with the column: story_event_status
	 */
	public java.lang.Integer getStoryEventStatus () {
		return storyEventStatus;
	}

	/**
	 * Set the value related to the column: story_event_status
	 * @param storyEventStatus the story_event_status value
	 */
	public void setStoryEventStatus (java.lang.Integer storyEventStatus) {
		this.storyEventStatus = storyEventStatus;
	}



	/**
	 * Return the value associated with the column: admin_id
	 */
	public com.ictti.orrs.business.entity.Admin getAdmin () {
		return admin;
	}

	/**
	 * Set the value related to the column: admin_id
	 * @param admin the admin_id value
	 */
	public void setAdmin (com.ictti.orrs.business.entity.Admin admin) {
		this.admin = admin;
	}



	/**
	 * Return the value associated with the column: shelter_id
	 */
	public com.ictti.orrs.business.entity.Shelter getShelter () {
		return shelter;
	}

	/**
	 * Set the value related to the column: shelter_id
	 * @param shelter the shelter_id value
	 */
	public void setShelter (com.ictti.orrs.business.entity.Shelter shelter) {
		this.shelter = shelter;
	}



	/**
	 * Return the value associated with the column: eventImages
	 */
	public java.util.Set<com.ictti.orrs.business.entity.EventImage> getEventImages () {
		return eventImages;
	}

	/**
	 * Set the value related to the column: eventImages
	 * @param eventImages the eventImages value
	 */
	public void setEventImages (java.util.Set<com.ictti.orrs.business.entity.EventImage> eventImages) {
		this.eventImages = eventImages;
	}

	public void addToeventImages (com.ictti.orrs.business.entity.EventImage eventImage) {
		if (null == getEventImages()) setEventImages(new java.util.TreeSet<com.ictti.orrs.business.entity.EventImage>());
		getEventImages().add(eventImage);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.Event)) return false;
		else {
			com.ictti.orrs.business.entity.Event event = (com.ictti.orrs.business.entity.Event) obj;
			if (null == this.getId() || null == event.getId()) return false;
			else return (this.getId().equals(event.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}