package com.ictti.orrs.business.service;

import java.util.List;

import com.ictti.orrs.business.entity.AnnualReportTable;
import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.ShelterDailyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterDailyReportTable;
import com.ictti.orrs.business.entity.ShelterMonthlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterMonthlyReportTable;
import com.ictti.orrs.business.entity.ShelterYearlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterYearlyReportTable;
import com.ictti.orrs.dao.AnnualReportTableDao;
import com.ictti.orrs.dao.CategoryDao;
import com.ictti.orrs.dao.ShelteReportTableDao;
import com.ictti.orrs.presentation.form.AnnualReportForm;
import com.ictti.orrs.presentation.form.ShelterForm;
import com.ictti.orrs.presentation.form.ShelterReportForm;


public class ShelterReportService {
	CategoryDao myCategoryDao;

	public CategoryDao getMyCategoryDao() {
		return myCategoryDao;
	}

	public void setMyCategoryDao(CategoryDao myCategoryDao) {
		this.myCategoryDao = myCategoryDao;
	}

	ShelteReportTableDao myShelterReportTableDao;
	
	public ShelteReportTableDao getMyShelterReportTableDao() {
		return myShelterReportTableDao;
	}

	public void setMyShelterReportTableDao(
			ShelteReportTableDao myShelterReportTableDao) {
		this.myShelterReportTableDao = myShelterReportTableDao;
	}

	public void getAllCategory(ShelterReportForm myForm) {
		// TODO Auto-generated method stub
		List<Category> l = myCategoryDao.getAllCategory();
		System.out.println(l);
		myForm.setFrmCategoryList(l);;
	}

	public List<ShelterYearlyReportTable> getReportByCategoryAndShelter(String category,
			int shelterId) {
		// TODO Auto-generated method stub
		List<ShelterYearlyReportTable> list = myShelterReportTableDao.searchByCategoryAndSno(category,shelterId);

		return list;
	}

	public void getAllYear(ShelterReportForm myForm) {
		// TODO Auto-generated method stub
		List<ShelterMonthlyReportTable> l = myShelterReportTableDao.getAllYear();
		System.out.println(l);
		myForm.setFrmYearList(l);
	}

	public List<ShelterMonthlyReportTable> getReportByYearAndCategoryAndShelter(
			int year, String category, int shelterId) {
		// TODO Auto-generated method stub
		List<ShelterMonthlyReportTable> list = myShelterReportTableDao.searchByYearAndCategoryAndSno(year,category,shelterId);

		return list;
	}

	public List<ShelterYearlyReportTable> getReportByYearAndShelter(int year, int sno) {
		// TODO Auto-generated method stub
		List<ShelterYearlyReportTable> list = myShelterReportTableDao.searchByYearAndShelter(year,sno);
		return list;
	}

	public List<ShelterYearlyReportAllCategoryTable> getReportByShelter(
			int shelterId) {
		// TODO Auto-generated method stub
		List<ShelterYearlyReportAllCategoryTable> list = myShelterReportTableDao.searchBySno(shelterId);
		return list;
	}

	public List<ShelterMonthlyReportAllCategoryTable> getReportByYearAndSno(
			int year, int shelterId) {
		// TODO Auto-generated method stub
		List<ShelterMonthlyReportAllCategoryTable> list = myShelterReportTableDao.searchByYearAndSno(year,shelterId);
		return list;
	}

	

	public List<ShelterDailyReportTable> getReportByYearAndMonthAndCategoryAndShelter(
			int year, String month, String category, int shelterId) {
		// TODO Auto-generated method stub
		List<ShelterDailyReportTable> list = myShelterReportTableDao.searchByYearAndMonthAndCategoryAndSno(year,month,category,shelterId);
		return list;
	}

	public List<ShelterDailyReportAllCategoryTable> getReportByAllCategoryAndYearAndMonthAndShelter(
			int year, String month, int shelterId) {
		// TODO Auto-generated method stub
		List<ShelterDailyReportAllCategoryTable> list = myShelterReportTableDao.AllCategoryAndYearAndMonthAndShelter(year,month,shelterId);
		return list;
	}

	


	
}
