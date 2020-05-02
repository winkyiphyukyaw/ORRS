package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the orphan_image table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="orphan_image"
 */

public abstract class BaseOrphanImage  implements Serializable {

	public static String REF = "OrphanImage";
	public static String PROP_ORPHAN = "orphan";
	public static String PROP_ID = "id";
	public static String PROP_IMAGE = "image";


	// constructors
	public BaseOrphanImage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrphanImage (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOrphanImage (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Orphan orphan) {

		this.setId(id);
		this.setOrphan(orphan);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private byte[] image;

	// many to one
	private com.ictti.orrs.business.entity.Orphan orphan;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="orphan_image_id"
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
	 * Return the value associated with the column: image
	 */
	public byte[] getImage () {
		return image;
	}

	/**
	 * Set the value related to the column: image
	 * @param image the image value
	 */
	public void setImage (byte[] image) {
		this.image = image;
	}



	/**
	 * Return the value associated with the column: orphan_id
	 */
	public com.ictti.orrs.business.entity.Orphan getOrphan () {
		return orphan;
	}

	/**
	 * Set the value related to the column: orphan_id
	 * @param orphan the orphan_id value
	 */
	public void setOrphan (com.ictti.orrs.business.entity.Orphan orphan) {
		this.orphan = orphan;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.OrphanImage)) return false;
		else {
			com.ictti.orrs.business.entity.OrphanImage orphanImage = (com.ictti.orrs.business.entity.OrphanImage) obj;
			if (null == this.getId() || null == orphanImage.getId()) return false;
			else return (this.getId().equals(orphanImage.getId()));
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