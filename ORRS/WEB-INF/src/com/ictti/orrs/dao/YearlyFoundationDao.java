package com.ictti.orrs.dao;

import java.util.Date;
import java.util.List;

import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.YearlyFoundationTable;


public interface YearlyFoundationDao {

	YearlyFoundationTable getAmountByDateAndCategory(Category c, Date d);

}
