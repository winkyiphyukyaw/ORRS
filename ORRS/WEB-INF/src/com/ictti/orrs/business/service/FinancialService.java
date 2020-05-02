package com.ictti.orrs.business.service;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ictti.orrs.business.entity.AnnualReportTable;
import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.City;
import com.ictti.orrs.business.entity.FinancialCalculate;
import com.ictti.orrs.dao.AnnualReportTableDao;
import com.ictti.orrs.dao.CategoryDao;
import com.ictti.orrs.dao.FinancialCalculateDao;
import com.ictti.orrs.presentation.form.FinancialForm;

public class FinancialService {
	AnnualReportTableDao myAnuualReportDao;
	public AnnualReportTableDao getMyAnuualReportDao() {
		return myAnuualReportDao;
	}


	public void setMyAnuualReportDao(AnnualReportTableDao myAnuualReportDao) {
		this.myAnuualReportDao = myAnuualReportDao;
	}


	CategoryDao myCategoryDao;
	FinancialCalculateDao myFinancialCalDao;

	
	public FinancialCalculateDao getMyFinancialCalDao() {
		return myFinancialCalDao;
	}


	public void setMyFinancialCalDao(FinancialCalculateDao myFinancialCalDao) {
		this.myFinancialCalDao = myFinancialCalDao;
	}


	public CategoryDao getMyCategoryDao() {
		return myCategoryDao;
	}


	public void setMyCategoryDao(CategoryDao myCategoryDao) {
		this.myCategoryDao = myCategoryDao;
	}


	public void getCategoryList(FinancialForm myForm) {
		// TODO Auto-generated method stub
		List<Category> l = myCategoryDao.getAllCategory();
		myForm.setFrmCategoryList(l);
		myForm.setFrmCategoryId("0");
	}


	public void saveFinancialOutcome(FinancialForm myForm) {
		// TODO Auto-generated method stub
		FinancialCalculate myFinancial = new FinancialCalculate();
		Category myCategory = myCategoryDao.getCategoryById(Integer.parseInt(myForm.getFrmCategoryId()));
		myFinancial.setCategory(myCategory);
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date myD1;
		try {
			myD1 = myformat.parse(myForm.getFirstDate());
			myFinancial.setReportDate(myD1);
			myFinancial.setId(null);
			myFinancial.setMonthlyOutcome(Double.parseDouble(myForm.getFrmOutcome()));
			myFinancialCalDao.saveFinancialOutcome(myFinancial);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void getAllAmountList(FinancialForm myForm) {
		// TODO Auto-generated method stub
		List<FinancialCalculate> l=myFinancialCalDao.getAllFinancialAmountList();
		myForm.setFrmAmountList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(5);
		if(l!=null)
			myForm.setiMaxData(l.size());
		
	}

	//**************For Update***********

	public void firstLoadUpdate(FinancialForm myForm) {
		// TODO Auto-generated method stub
		

		
		FinancialCalculate myFinancial=myFinancialCalDao.geFinancialProfilebyId(Integer.parseInt(myForm.getFrmUpdateFinancialProfileId()));
		/*myForm.setFrmOutcome(String.valueOf(myFinancial.getMonthlyOutcome()));*/
		DecimalFormat decimalFormat=new DecimalFormat("#.#");
		myForm.setFrmOutcome(decimalFormat.format((myFinancial.getMonthlyOutcome())));
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date myD2;
		myD2 = myFinancial.getReportDate();
		Date todaysDate = new Date();
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		myForm.setFirstDate(df.format(myD2));
		System.out.println("Selected____________________________"+myFinancial.getCategory().getType());
		myForm.setFrmCategoryId(myFinancial.getCategory().getId().toString());
		myForm.setFrmUpdateFormControl(null);	
	}


	public void saveUpdateFinancialList(FinancialForm myForm) {
		// TODO Auto-generated method stub
		/*FinancialCalculate myFinancial = new FinancialCalculate();
		Category myCategory = myCategoryDao.getCategoryById(Integer.parseInt(myForm.getFrmCategoryId()));
		myFinancial.setCategory(myCategory);
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date myD1;
		try {
			myD1 = myformat.parse(myForm.getFirstDate());
			myFinancial.setReportDate(myD1);
			myFinancial.setId(null);
			myFinancial.setMonthlyOutcome(myForm.getFrmOutcome());
			myFinancialCalDao.saveUpdateFinancialOutcome(myFinancial);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		FinancialCalculate myFinancial=myFinancialCalDao.geFinancialProfilebyId(Integer.parseInt(myForm.getFrmUpdateFinancialProfileId()));
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date myD2;
		try {
			myD2 = myformat.parse(myForm.getFirstDate());
			myFinancial.setReportDate(myD2);
			Category myCategory = myCategoryDao.getCategoryById(Integer.parseInt(myForm.getFrmCategoryId()));
			myFinancial.setCategory(myCategory);
			myFinancial.setMonthlyOutcome(Double.parseDouble(myForm.getFrmOutcome()));
			myFinancialCalDao.saveUpdateFinancialOutcome(myFinancial);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	public void getCategoryName(FinancialForm myForm) {
		// TODO Auto-generated method stub
		Category myCategory=myCategoryDao.getCategoryById(Integer.parseInt(myForm.getFrmCategoryId()));
		myForm.setFrmCategoryName(myCategory.getType());
		myForm.setFrmFinancialFormControl("data");
	}


	public void firstLoadInsertFinancial(FinancialForm myForm) {
		// TODO Auto-generated method stub
		myForm.setFirstDate(null);
		myForm.setFrmCategoryId(null);
		myForm.setFrmOutcome(null);
		myForm.setFrmFinancialFormControl(null);
	}


	public void getCategoryNameForUpdate(FinancialForm myForm) {
		// TODO Auto-generated method stub
		Category myCategory=myCategoryDao.getCategoryById(Integer.parseInt(myForm.getFrmCategoryId()));
		myForm.setFrmCategoryName(myCategory.getType());
		myForm.setFrmUpdateFormControl("data");
	}


	public List<AnnualReportTable> getDonorAmount(String month, String year, String categoryid) {
		// TODO Auto-generated method stub
		List<AnnualReportTable> myAnnualAmount=myAnuualReportDao.getDonorAmountCheck(month,year,categoryid);
		/*myAnnualAmount.get(0).getBalance()*/;
		return myAnnualAmount;
		
		
	}


	public Category getCategoryByBalance(FinancialForm myForm) {
		// TODO Auto-generated method stub
		Category myCategory=myCategoryDao.getCategoryById(Integer.parseInt(myForm.getFrmCategoryId()));
		return myCategory;
	}


	
	



	
}
