package com.ictti.orrs.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the orphan table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="orphan"
 */

public abstract class BaseOrphan  implements Serializable {

	public static String REF = "Orphan";
	public static String PROP_ADOPT_STATUS = "adoptStatus";
	public static String PROP_ORPHAN_RELIGION = "orphanReligion";
	public static String PROP_ORPHAN_AGE = "orphanAge";
	public static String PROP_ORPHAN_MEDICAL_GRADE = "orphanMedicalGrade";
	public static String PROP_ADOPTER = "adopter";
	public static String PROP_SHELTER = "shelter";
	public static String PROP_ORPHAN_NAME = "orphanName";
	public static String PROP_ORPHAN_GENDER = "orphanGender";
	public static String PROP_ID = "id";
	public static String PROP_ORPHAN_EDU = "orphanEdu";
	public static String PROP_ORPHAN_DELETE_STATUS = "orphanDeleteStatus";


	// constructors
	public BaseOrphan () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrphan (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOrphan (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Shelter shelter,
		java.lang.String orphanName,
		java.lang.String orphanAge,
		java.lang.String orphanGender,
		java.lang.String orphanEdu,
		java.lang.String orphanReligion,
		java.lang.String orphanMedicalGrade) {

		this.setId(id);
		this.setShelter(shelter);
		this.setOrphanName(orphanName);
		this.setOrphanAge(orphanAge);
		this.setOrphanGender(orphanGender);
		this.setOrphanEdu(orphanEdu);
		this.setOrphanReligion(orphanReligion);
		this.setOrphanMedicalGrade(orphanMedicalGrade);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String orphanName;
	private java.lang.String orphanAge;
	private java.lang.String orphanGender;
	private java.lang.String orphanEdu;
	private java.lang.String orphanReligion;
	private java.lang.String orphanMedicalGrade;
	private java.lang.Integer adoptStatus;
	private java.lang.Integer orphanDeleteStatus;

	// many to one
	private com.ictti.orrs.business.entity.Shelter shelter;
	private com.ictti.orrs.business.entity.Adopter adopter;

	// collections
	private java.util.Set<com.ictti.orrs.business.entity.OrphanImage> orphanImages;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="orphan_id"
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
	 * Return the value associated with the column: orphan_name
	 */
	public java.lang.String getOrphanName () {
		return orphanName;
	}

	/**
	 * Set the value related to the column: orphan_name
	 * @param orphanName the orphan_name value
	 */
	public void setOrphanName (java.lang.String orphanName) {
		this.orphanName = orphanName;
	}



	/**
	 * Return the value associated with the column: orphan_age
	 */
	public java.lang.String getOrphanAge () {
		return orphanAge;
	}

	/**
	 * Set the value related to the column: orphan_age
	 * @param orphanAge the orphan_age value
	 */
	public void setOrphanAge (java.lang.String orphanAge) {
		this.orphanAge = orphanAge;
	}



	/**
	 * Return the value associated with the column: orphan_gender
	 */
	public java.lang.String getOrphanGender () {
		return orphanGender;
	}

	/**
	 * Set the value related to the column: orphan_gender
	 * @param orphanGender the orphan_gender value
	 */
	public void setOrphanGender (java.lang.String orphanGender) {
		this.orphanGender = orphanGender;
	}



	/**
	 * Return the value associated with the column: orphan_edu
	 */
	public java.lang.String getOrphanEdu () {
		return orphanEdu;
	}

	/**
	 * Set the value related to the column: orphan_edu
	 * @param orphanEdu the orphan_edu value
	 */
	public void setOrphanEdu (java.lang.String orphanEdu) {
		this.orphanEdu = orphanEdu;
	}



	/**
	 * Return the value associated with the column: orphan_religion
	 */
	public java.lang.String getOrphanReligion () {
		return orphanReligion;
	}

	/**
	 * Set the value related to the column: orphan_religion
	 * @param orphanReligion the orphan_religion value
	 */
	public void setOrphanReligion (java.lang.String orphanReligion) {
		this.orphanReligion = orphanReligion;
	}



	/**
	 * Return the value associated with the column: orphan_medical_grade
	 */
	public java.lang.String getOrphanMedicalGrade () {
		return orphanMedicalGrade;
	}

	/**
	 * Set the value related to the column: orphan_medical_grade
	 * @param orphanMedicalGrade the orphan_medical_grade value
	 */
	public void setOrphanMedicalGrade (java.lang.String orphanMedicalGrade) {
		this.orphanMedicalGrade = orphanMedicalGrade;
	}



	/**
	 * Return the value associated with the column: adopt_status
	 */
	public java.lang.Integer getAdoptStatus () {
		return adoptStatus;
	}

	/**
	 * Set the value related to the column: adopt_status
	 * @param adoptStatus the adopt_status value
	 */
	public void setAdoptStatus (java.lang.Integer adoptStatus) {
		this.adoptStatus = adoptStatus;
	}



	/**
	 * Return the value associated with the column: orphan_delete_status
	 */
	public java.lang.Integer getOrphanDeleteStatus () {
		return orphanDeleteStatus;
	}

	/**
	 * Set the value related to the column: orphan_delete_status
	 * @param orphanDeleteStatus the orphan_delete_status value
	 */
	public void setOrphanDeleteStatus (java.lang.Integer orphanDeleteStatus) {
		this.orphanDeleteStatus = orphanDeleteStatus;
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



	/**
	 * Return the value associated with the column: orphanImages
	 */
	public java.util.Set<com.ictti.orrs.business.entity.OrphanImage> getOrphanImages () {
		return orphanImages;
	}

	/**
	 * Set the value related to the column: orphanImages
	 * @param orphanImages the orphanImages value
	 */
	public void setOrphanImages (java.util.Set<com.ictti.orrs.business.entity.OrphanImage> orphanImages) {
		this.orphanImages = orphanImages;
	}

	public void addToorphanImages (com.ictti.orrs.business.entity.OrphanImage orphanImage) {
		if (null == getOrphanImages()) setOrphanImages(new java.util.TreeSet<com.ictti.orrs.business.entity.OrphanImage>());
		getOrphanImages().add(orphanImage);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.orrs.business.entity.Orphan)) return false;
		else {
			com.ictti.orrs.business.entity.Orphan orphan = (com.ictti.orrs.business.entity.Orphan) obj;
			if (null == this.getId() || null == orphan.getId()) return false;
			else return (this.getId().equals(orphan.getId()));
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