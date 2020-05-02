package com.ictti.orrs.business.service;

import java.util.List;

import com.ictti.orrs.business.entity.Adopter;
import com.ictti.orrs.business.entity.Orphan;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.dao.AdopterDao;
import com.ictti.orrs.dao.OrphanDao;
import com.ictti.orrs.dao.ShelterDao;
import com.ictti.orrs.presentation.form.AdminViewOrphanForm;

public class AdminViewOrphanService {

	OrphanDao myOrphanDao;
	AdopterDao myAdopterDao;
	ShelterDao myShelterDao;
	
	
	
	
	
	public ShelterDao getMyShelterDao() {
		return myShelterDao;
	}


	public void setMyShelterDao(ShelterDao myShelterDao) {
		this.myShelterDao = myShelterDao;
	}


	public AdopterDao getMyAdopterDao() {
		return myAdopterDao;
	}


	public void setMyAdopterDao(AdopterDao myAdopterDao) {
		this.myAdopterDao = myAdopterDao;
	}


	public OrphanDao getMyOrphanDao() {
		return myOrphanDao;
	}


	public void setMyOrphanDao(OrphanDao myOrphanDao) {
		this.myOrphanDao = myOrphanDao;
	}


	public void getAllOrphanList(AdminViewOrphanForm myForm) {
		// TODO Auto-generated method stub
		System.out.println("In get all orphanList");
		
		List<Orphan> l=myOrphanDao.getAllOrphanList();		
		if(l!=null)
		{
			System.out.println(l.size());
		}
		myForm.setAdminOrphanList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(5);
		if(l!=null)
		{
			myForm.setiMaxData(l.size());
		}
		
	}



	public void getAllOrphanById(AdminViewOrphanForm myForm) {
		
		Orphan op=myOrphanDao.getAllOrphanByid(Integer.parseInt(myForm.getAdminViewOrphanDetailId()));
		myForm.setAdminViewOrphanDetail(op);    
		
	}

//Correct
	public void getAllOrphanAndAdopterById(AdminViewOrphanForm myForm) {
		// TODO Auto-generated method stub
		Orphan op=myOrphanDao.getAllOrphanByid(Integer.parseInt(myForm.getAdminViewOrphanDetailId()));
		myForm.setAdminViewOrphanDetail(op);
		if(op.getAdoptStatus()!=0){
			Adopter myAdopter=myAdopterDao.getAllAdopterByid(Integer.parseInt(myForm.getAdminViewAdopterDetailId()));
			myForm.setAdminViewAdopterDetail(myAdopter);
			}
		
	}



	public List<Shelter> findShelterNameByLikeFromService(String s)
	{
		List<Shelter> l=myShelterDao.getShelterNameListByPattern(s);
		return l;
	}


	
		
		
	
	
	
public void getAllOrphanByShelterName(AdminViewOrphanForm myForm) {	
		
		// TODO Auto-generated method stub
		System.out.println("============"+myForm.getAdminOrphanShelterName()+"===========");
		List<Orphan> l=myOrphanDao.getAllOrphanListByShelterName(myForm.getAdminOrphanShelterName());
		System.out.println("============"+myForm.getAdminOrphanShelterId()+"===========");
		myForm.setAdminOrphanList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(5);
		if(l!=null)
		{
			myForm.setiMaxData(l.size());
		}
		
		
		
	}


	
}

//
		
		
	






