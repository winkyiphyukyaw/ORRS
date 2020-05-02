package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the adopter_image table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="adopter_image"
 */

public abstract class BaseAdopterImage  implements Serializable {

	public static String REF = "AdopterImage";
	public static String PROP_ADOPTER_IMAGE_CONTENT_TYPE = "adopterImageContentType";
	public static String PROP_ADOPTER = "adopter";
	public static String PROP_ADOPTER_IMAGE_NAME = "adopterImageName";
	public static String PROP_ID = "id";
	public static String PROP_IMAGE = "image";


	// constructors
	public BaseAdopterImage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAdopterImage (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAdopterImage (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Adopter adopter) {

		this.setId(id);
		this.setAdopter(adopter);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adopterImageContentType;
	private java.lang.String adopterImageName;
	private java.sql.Blob image;

	// many to one
	private com.ictti.orrs.business.entity.Adopter adopter;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="adopter_image_id"
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
	 * Return the value associated with the column: adopter_image_content_type
	 */
	public java.lang.String getAdopterImageContentType () {
		return adopterImageContentType;
	}

	/**
	 * Set the value related to the column: adopter_image_content_type
	 * @param adopterImageContentType the adopter_image_content_type value
	 */
	public void setAdopterImageContentType (java.lang.String adopterImageContentType) {
		this.adopterImageContentType = adopterImageContentType;
	}



	/**
	 * Return the value associated with the column: adopter_image_name
	 */
	public java.lang.String getAdopterImageName () {
		return adopterImageName;
	}

	/**
	 * Set the value related to the column: adopter_image_name
	 * @param adopterImageName the adopter_image_name value
	 */
	public void setAdopterImageName (java.lang.String adopterImageName) {
		this.adopterImageName = adopterImageName;
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
	 * Return the value associated with the column: adopter_id
	 */
	public com.ictti.orrs.business.entity.Adopter getAdopter () {
		return adopter;
	}

	/**
	 * Set the value related to the column: adopter_id
	 * @param adopter the adopter_id value
	 */
	public void setAdopter (com.ictti.orrs.business.entity.Adopter adopter) {
		this.adopter = adopter;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.AdopterImage)) return false;
		else {
			com.ictti.orrs.business.entity.AdopterImage adopterImage = (com.ictti.orrs.business.entity.AdopterImage) obj;
			if (null == this.getId() || null == adopterImage.getId()) return false;
			else return (this.getId().equals(adopterImage.getId()));
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