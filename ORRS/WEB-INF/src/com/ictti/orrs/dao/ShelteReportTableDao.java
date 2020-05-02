package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.ShelterDailyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterDailyReportTable;
import com.ictti.orrs.business.entity.ShelterMonthlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterMonthlyReportTable;
import com.ictti.orrs.business.entity.ShelterYearlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterYearlyReportTable;

public interface ShelteReportTableDao {

	List<ShelterMonthlyReportTable> getAllYear();

	List<ShelterYearlyReportTable> searchByCategoryAndSno(String category,int shelterId);

	List<ShelterMonthlyReportTable> searchByYearAndCategoryAndSno(int year,
			String category, int shelterId);

	List<ShelterYearlyReportTable> searchByYearAndShelter(int year, int sno);

	List<ShelterYearlyReportAllCategoryTable> searchBySno(int shelterId);

	List<ShelterMonthlyReportAllCategoryTable> searchByYearAndSno(int year,
			int shelterId);


	List<ShelterDailyReportTable> searchByYearAndMonthAndCategoryAndSno(
			int year, String month, String category, int shelterId);

	List<ShelterDailyReportAllCategoryTable> AllCategoryAndYearAndMonthAndShelter(
			int year, String month, int shelterId);

}
