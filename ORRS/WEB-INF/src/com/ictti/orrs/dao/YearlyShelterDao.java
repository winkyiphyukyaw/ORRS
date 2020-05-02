package com.ictti.orrs.dao;

import java.util.Date;

import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.YearlyShelterTable;

public interface YearlyShelterDao {

	YearlyShelterTable getAmountByDateAndCategoryAndShelter(Category c,
			Date d, String frmShelterName);

}
