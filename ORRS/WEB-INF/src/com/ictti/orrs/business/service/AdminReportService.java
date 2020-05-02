package com.ictti.orrs.business.service;

import java.util.List;

import com.ictti.orrs.business.entity.AdminDailyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminDailyReportTable;
import com.ictti.orrs.business.entity.AdminMonthlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminMonthlyReportTable;
import com.ictti.orrs.business.entity.AdminYearlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminYearlyReportTable;
import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.dao.AdminReportTableDao;
import com.ictti.orrs.dao.CategoryDao;
import com.ictti.orrs.presentation.form.AdminReportForm;

public class AdminReportService {
	CategoryDao myCategoryDao;
	AdminReportTableDao myAdminReportDao;
	
	public AdminReportTableDao getMyAdminReportDao() {
		return myAdminReportDao;
	}

	public void setMyAdminReportDao(AdminReportTableDao myAdminReportDao) {
		this.myAdminReportDao = myAdminReportDao;
	}

	public CategoryDao getMyCategoryDao() {
		return myCategoryDao;
	}

	public void setMyCategoryDao(CategoryDao myCategoryDao) {
		this.myCategoryDao = myCategoryDao;
	}

	public void getAllCategory(AdminReportForm myForm) {
		// TODO Auto-generated method stub
		List<Category> l = myCategoryDao.getAllCategory();
		myForm.setFrmCategoryList(l);
	}

	public void getAllYear(AdminReportForm myForm) {
		// TODO Auto-generated method stub
		List<AdminYearlyReportTable> l = myAdminReportDao.getAllYear();
		myForm.setFrmYearList(l);
	}
	
	public void getAllMonth(AdminReportForm myForm) {
		// TODO Auto-generated method stub
		List<AdminDailyReportTable> l = myAdminReportDao.getAllMonth();
		myForm.setFrmMonthList(l);
	}

	public Category getCategoryById(int cid) {
		// TODO Auto-generated method stub
		Category c = myCategoryDao.getCategoryById(cid);
		return c;
	}

	public List<AdminYearlyReportTable> getReportByCategory(String type) {
		// TODO Auto-generated method stub
		List<AdminYearlyReportTable> l = myAdminReportDao.getReportByCategory(type);
		
		return l;
	}

	public List<AdminMonthlyReportTable> getReportByCategoryAndYear(
			String category, int year) {
		// TODO Auto-generated method stub
		List<AdminMonthlyReportTable> l = myAdminReportDao.getReportByCategoryAndYear(category,year);
		return l;
	}

	public List<AdminYearlyReportTable> getReportByYear(int year) {
		// TODO Auto-generated method stub
		List<AdminYearlyReportTable> l = myAdminReportDao.getReportByCategoryAndYear(year);
		return l;
	}

	public List<AdminYearlyReportAllCategoryTable> getReportByAllCategory() {
		// TODO Auto-generated method stub
		List<AdminYearlyReportAllCategoryTable> l = myAdminReportDao.getReportByAllCategory();
		return l;
	}

	public List<AdminMonthlyReportAllCategoryTable> getReportByYearAndAllCategory(int year) {
		// TODO Auto-generated method stub
		List<AdminMonthlyReportAllCategoryTable> l = myAdminReportDao.getReportByYear(year);
		return l;
	}

	public List<AdminDailyReportAllCategoryTable> getReportByYearAndMonthAndAllCategory(
			int year, String month) {
		// TODO Auto-generated method stub
		List<AdminDailyReportAllCategoryTable> l = myAdminReportDao.getReportByYearAndMonthAndAllCategory(year,month);
		return l;
	}

	public List<AdminDailyReportTable> getReportByCategoryAndYearAndMonth(
			String category, int year, String month) {
		List<AdminDailyReportTable> l = myAdminReportDao.getReportByCategoryAndYearAndMonth(category,year,month);
		// TODO Auto-generated method stub
		return l;
	}

	
	
}
