package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseOrphan;



public class Orphan extends BaseOrphan {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Orphan () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Orphan (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Orphan (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Shelter shelter,
		java.lang.String orphanName,
		java.lang.String orphanAge,
		java.lang.String orphanGender,
		java.lang.String orphanEdu,
		java.lang.String orphanReligion,
		java.lang.String orphanMedicalGrade) {

		super (
			id,
			shelter,
			orphanName,
			orphanAge,
			orphanGender,
			orphanEdu,
			orphanReligion,
			orphanMedicalGrade);
	}

/*[CONSTRUCTOR MARKER END]*/


}