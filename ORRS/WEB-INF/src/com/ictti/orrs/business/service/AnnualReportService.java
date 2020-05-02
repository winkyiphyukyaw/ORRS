package com.ictti.orrs.business.service;

import java.math.BigDecimal;
import java.util.List;

import com.ictti.orrs.business.entity.AllYearTable;
import com.ictti.orrs.business.entity.AnnualReportTable;
import com.ictti.orrs.dao.AllYearTableDao;
import com.ictti.orrs.dao.AnnualReportTableDao;
import com.ictti.orrs.presentation.form.AnnualReportForm;

public class AnnualReportService {

	AnnualReportTableDao myAnnualReportTableDao;
	AllYearTableDao myAllYearTableDao;

	public AllYearTableDao getMyAllYearTableDao() {
		return myAllYearTableDao;
	}

	public void setMyAllYearTableDao(AllYearTableDao myAllYearTableDao) {
		this.myAllYearTableDao = myAllYearTableDao;
	}

	public AnnualReportTableDao getMyAnnualReportTableDao() {
		return myAnnualReportTableDao;
	}

	public void setMyAnnualReportTableDao(
			AnnualReportTableDao myAnnualReportTableDao) {
		this.myAnnualReportTableDao = myAnnualReportTableDao;
	}

	public void fristLoadPage(AnnualReportForm myForm) {
		// TODO Auto-generated method stub
		List<AnnualReportTable> l = myAnnualReportTableDao.getAllYear();
		myForm.setFrmAnnualList(l);
		myForm.setFrmAllYearViewList(null);

		List<AnnualReportTable> c = myAnnualReportTableDao.getAllCategoryList();
		myForm.setFrmCategoryList(c);
		System.out.print("Category_____________" + c.size() + "-------------");
	}

	
	public List<AllYearTable> getAllAnnualList(AnnualReportForm myForm) {
		// TODO Auto-generated method stub
		float cost_sum = 0;
			List<AllYearTable> l;
			if(myForm.getFrmCategoryId().equals("0")){
				 l= myAllYearTableDao.getFrmAllYearViewList(myForm.getFrmAnnualId());
			}
			else{
				l = myAllYearTableDao.getFrmAllYearAllCategoryViewList(myForm.getFrmAnnualId(),myForm.getFrmCategoryId());
			}
			return l;
			
	
	
		}
	public List<AnnualReportTable> getAnnualReportList(AnnualReportForm myForm){
		List<AnnualReportTable> l;
		if (myForm.getFrmCategoryId().equals("0"))
		{
			l = myAnnualReportTableDao.getAnnualList(myForm.getFrmAnnualId());
		}
		else
		{
			l=myAnnualReportTableDao.getFrmAllYearAllCategoryList(myForm.getFrmAnnualId(),myForm.getFrmCategoryId());
		}
		
		double f = 0, c = 0, b = 0;

		if (l != null) {
			for (int i = 0; i < l.size(); i++) {
				f = f + Double.valueOf(l.get(i).getFund().toString());
				c = c + Double.valueOf(l.get(i).getCost().toString());
			}

			b = f - c;
			System.out.println("Total Fund : " + f + " Total Cost: "
					+ c + " Balance : " + b);
			myForm.setCost_sum(c);
			myForm.setFund_sum(f);
			myForm.setTotal_balance(b);
		}
		return l;
		
	}
	}

