package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.AdminDailyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminDailyReportTable;
import com.ictti.orrs.business.entity.AdminMonthlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminMonthlyReportTable;
import com.ictti.orrs.business.entity.AdminYearlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminYearlyReportTable;

public interface AdminReportTableDao {

	List<AdminYearlyReportTable> getAllYear();
	
	List<AdminDailyReportTable> getAllMonth();

	List<AdminYearlyReportTable> getReportByCategory(String type);

	List<AdminMonthlyReportTable> getReportByCategoryAndYear(String category,int year);

	List<AdminYearlyReportTable> getReportByCategoryAndYear(int year);

	List<AdminMonthlyReportAllCategoryTable> getReportByYear(int year);

	List<AdminYearlyReportAllCategoryTable> getReportByAllCategory();

	List<AdminDailyReportAllCategoryTable> getReportByYearAndMonthAndAllCategory(
			int year, String month);

	List<AdminDailyReportTable> getReportByCategoryAndYearAndMonth(
			String category, int year, String month);

	

}
