package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the event_image table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="event_image"
 */

public abstract class BaseEventImage  implements Serializable {

	public static String REF = "EventImage";
	public static String PROP_EVENT_IMAGE_CONTENT_TYPE = "eventImageContentType";
	public static String PROP_EVENT = "event";
	public static String PROP_EVENT_IMAGE_NAME = "eventImageName";
	public static String PROP_EVENT_VIDEO = "eventVideo";
	public static String PROP_ID = "id";
	public static String PROP_IMAGE = "image";


	// constructors
	public BaseEventImage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEventImage (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEventImage (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Event event) {

		this.setId(id);
		this.setEvent(event);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String eventImageContentType;
	private java.lang.String eventImageName;
	private java.lang.String eventVideo;
	private java.sql.Blob image;

	// many to one
	private com.ictti.orrs.business.entity.Event event;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="event_image_id"
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
	 * Return the value associated with the column: event_image_content_type
	 */
	public java.lang.String getEventImageContentType () {
		return eventImageContentType;
	}

	/**
	 * Set the value related to the column: event_image_content_type
	 * @param eventImageContentType the event_image_content_type value
	 */
	public void setEventImageContentType (java.lang.String eventImageContentType) {
		this.eventImageContentType = eventImageContentType;
	}



	/**
	 * Return the value associated with the column: event_image_name
	 */
	public java.lang.String getEventImageName () {
		return eventImageName;
	}

	/**
	 * Set the value related to the column: event_image_name
	 * @param eventImageName the event_image_name value
	 */
	public void setEventImageName (java.lang.String eventImageName) {
		this.eventImageName = eventImageName;
	}



	/**
	 * Return the value associated with the column: event_video
	 */
	public java.lang.String getEventVideo () {
		return eventVideo;
	}

	/**
	 * Set the value related to the column: event_video
	 * @param eventVideo the event_video value
	 */
	public void setEventVideo (java.lang.String eventVideo) {
		this.eventVideo = eventVideo;
	}



	/**
	 * Return the value associated with the column: image
	 */
	public java.sql.Blob getImage () {
		return image;
	}

	/**
	 * Set the value related to the column: image
	 * @param image the image value
	 */
	public void setImage (java.sql.Blob image) {
		this.image = image;
	}



	/**
	 * Return the value associated with the column: event_id
	 */
	public com.ictti.orrs.business.entity.Event getEvent () {
		return event;
	}

	/**
	 * Set the value related to the column: event_id
	 * @param event the event_id value
	 */
	public void setEvent (com.ictti.orrs.business.entity.Event event) {
		this.event = event;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.EventImage)) return false;
		else {
			com.ictti.orrs.business.entity.EventImage eventImage = (com.ictti.orrs.business.entity.EventImage) obj;
			if (null == this.getId() || null == eventImage.getId()) return false;
			else return (this.getId().equals(eventImage.getId()));
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