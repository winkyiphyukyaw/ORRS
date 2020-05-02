package com.ictti.orrs.business.entity;

import com.ictti.orrs.business.entity.base.BaseFinancialCalculate;



public class FinancialCalculate extends BaseFinancialCalculate {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FinancialCalculate () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FinancialCalculate (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FinancialCalculate (
		java.lang.Integer id,
		com.ictti.orrs.business.entity.Category category) {

		super (
			id,
			category);
	}

/*[CONSTRUCTOR MARKER END]*/


}