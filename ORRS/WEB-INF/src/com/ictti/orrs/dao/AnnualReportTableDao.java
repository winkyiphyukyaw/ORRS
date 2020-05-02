package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.AllYearTable;
import com.ictti.orrs.business.entity.AnnualReportTable;

public interface AnnualReportTableDao {

	List<AnnualReportTable> getAllYear();

	List<AnnualReportTable> getAnnualList(String yid);

	List<AnnualReportTable> getAllCategoryList();

	List<AnnualReportTable> getFrmAllYearAllCategoryList(String yid,
			String cid);
	List<AnnualReportTable> getDonorAmountCheck(String month, String year, String categoryid);


}
