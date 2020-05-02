package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.AllYearTable;

public interface AllYearTableDao {

	List<AllYearTable> getFrmAllYearAllCategoryViewList(String frmAnnualId,String cid);

	List<AllYearTable> getFrmAllYearViewList(String frmAnnualId);

	
}
