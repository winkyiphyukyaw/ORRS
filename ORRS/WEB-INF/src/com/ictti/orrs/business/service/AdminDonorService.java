package com.ictti.orrs.business.service;

import java.util.ArrayList;
import java.util.List;

import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.Donor;
import com.ictti.orrs.business.entity.DonorCategory;
import com.ictti.orrs.business.entity.DonorShelter;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.dao.DonorCategoryDao;
import com.ictti.orrs.dao.DonorDao;
import com.ictti.orrs.dao.DonorShelterDao;
import com.ictti.orrs.presentation.form.AdminDonorForm;

public class AdminDonorService {
	DonorDao myDonorDao;
	DonorCategoryDao myDonorCategoryDao;
	
	public DonorDao getMyDonorDao() {
		return myDonorDao;
	}

	public void setMyDonorDao(DonorDao myDonorDao) {
		this.myDonorDao = myDonorDao;
	}

	public DonorCategoryDao getMyDonorCategoryDao() {
		return myDonorCategoryDao;
	}

	public void setMyDonorCategoryDao(DonorCategoryDao myDonorCategoryDao) {
		this.myDonorCategoryDao = myDonorCategoryDao;
	}

	

	public void getDonorCategoryByNRC(AdminDonorForm myForm) {
		// TODO Auto-generated method stub
		List<DonorCategory> d =myDonorCategoryDao.getDonorCategoryByNRC(Integer.parseInt(myForm.getDetailDonorId()));
		myForm.setViewDonorListDetail(d);
		myForm.setActualPage1(1);
		myForm.setiMaxShow1(7);
		System.out.println(d.size());
		if(d!=null)
			myForm.setiMaxData1(d.size());
	}

	public void getAllDonorList(AdminDonorForm myForm) {
		// TODO Auto-generated method stub
		List<DonorCategory> l=myDonorCategoryDao.getAllDonorList();
		//List<Category> cl = new ArrayList<>();
		
		myForm.setViewDonorList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(7);
		if(l!=null)
			myForm.setiMaxData(l.size());
		
	}

	public  List<DonorCategory> getAllDonorName(String s) {
		
		List<DonorCategory> l = myDonorCategoryDao.getAllDonor(s);
		/*myForm.setViewDonorList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(7);
		if(l!=null)
			myForm.setiMaxData(l.size());*/
		
		return l;
	}

}
