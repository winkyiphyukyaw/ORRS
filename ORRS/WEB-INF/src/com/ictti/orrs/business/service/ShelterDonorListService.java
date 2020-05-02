package com.ictti.orrs.business.service;

import java.util.ArrayList;
import java.util.List;

import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.Donor;
import com.ictti.orrs.business.entity.DonorCategory;
import com.ictti.orrs.business.entity.DonorShelter;
import com.ictti.orrs.dao.DonorCategoryDao;
import com.ictti.orrs.dao.DonorDao;
import com.ictti.orrs.dao.DonorShelterDao;
import com.ictti.orrs.presentation.form.ShelterDonorListForm;


public class ShelterDonorListService {
	DonorDao myDonorDao;
	DonorCategoryDao myDonorCategoryDao;
	DonorShelterDao myDonorShelterDao;
	
	
	
	
	public DonorShelterDao getMyDonorShelterDao() {
		return myDonorShelterDao;
	}

	public void setMyDonorShelterDao(DonorShelterDao myDonorShelterDao) {
		this.myDonorShelterDao = myDonorShelterDao;
	}

	public DonorCategoryDao getMyDonorCategoryDao() {
		return myDonorCategoryDao;
	}

	public void setMyDonorCategoryDao(DonorCategoryDao myDonorCategoryDao) {
		this.myDonorCategoryDao = myDonorCategoryDao;
	}

	public DonorDao getMyDonorDao() {
		return myDonorDao;
	}

	public void setMyDonorDao(DonorDao myDonorDao) {
		this.myDonorDao = myDonorDao;
	}

	/*public void getDonorByid(ShelterDonorListForm myForm) {
		// TODO Auto-generated method stub
		Donor d =myDonorDao.getDonorByid(Integer.parseInt(myForm.getDetailDonorId()));
		myForm.setViewDonorListDetail(d);
		
		
	}*/

	public void getAllDonorList(ShelterDonorListForm myForm) {
		// TODO Auto-generated method stub
		//List<Donor> l=myDonorDao.getAllDonorList();
		List<DonorShelter> l=myDonorShelterDao.getDonorListbyShelter(myForm.getLoginShelter().getId());
		//List<Category> cl = new ArrayList<>();
		
		myForm.setViewDonorList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(3);
		if(l!=null)
			myForm.setiMaxData(l.size());
		
		
	}

	public List<DonorShelter> getAllDonorByShelterName(String s) {
		// TODO Auto-generated method stub
	
		List<DonorShelter> l=myDonorShelterDao.getAllDonorListByShelterName(s);
		
		return l;
	}

	public void getDonorShelterByNRC(ShelterDonorListForm myForm) {
		// TODO Auto-generated method stub
		List<DonorShelter> d =myDonorShelterDao.getDonorShelterByNRC(myForm.getDetailDonorId());
		myForm.setViewDonorListDetail(d);
		myForm.setActualPage(1);
		myForm.setiMaxShow(3);
		if(d!=null)
			myForm.setiMaxData(d.size());
	}
	}
		
		
		
	
		
	


