package com.ictti.orrs.business.service;

import java.util.List;

import com.ictti.orrs.business.entity.Adopter;
import com.ictti.orrs.business.entity.Orphan;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.dao.AdopterDao;
import com.ictti.orrs.dao.OrphanDao;
import com.ictti.orrs.dao.ShelterDao;
import com.ictti.orrs.presentation.form.ShelterOrphanForm;

public class ShelterOrphanService {

	
	OrphanDao myOrphanDao;
	ShelterDao myShelterDao;
	AdopterDao myAdopterDao;
	
	
	public ShelterDao getMyShelterDao() {
		return myShelterDao;
	}
	public void setMyShelterDao(ShelterDao myShelterDao) {
		this.myShelterDao = myShelterDao;
	}
	public OrphanDao getMyOrphanDao() {
		return myOrphanDao;
	}
	public void setMyOrphanDao(OrphanDao myOrphanDao) {
		this.myOrphanDao = myOrphanDao;
	}
	public AdopterDao getMyAdopterDao() {
		return myAdopterDao;
	}
	public void setMyAdopterDao(AdopterDao myAdopterDao) {
		this.myAdopterDao = myAdopterDao;
	}
	
	public void OrphanList(ShelterOrphanForm myForm) 
	{
		// TODO Auto-generated method stub
		Shelter myloginShelter = myForm.getLoginShelter();
		List<Orphan> l = myOrphanDao.getAllOrphanList(myloginShelter);
		/*myForm.setFrmAgeList(l);
		myForm.setFrmEducationList(l);
		myForm.setFrmReligionList(l);
		myForm.setFrmMedicalList(l);*/
		//for View
		myForm.setFrmOrphanList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(5);
		if(l!=null)
		{
			myForm.setiMaxData(l.size());
		}
		
	}
	
	//for Insert
	public void firstLoadInsert(ShelterOrphanForm myForm) 
	{
		// TODO Auto-generated method stub
		myForm.setFrmName("");
		myForm.setFrmAge("0");
		myForm.setFrmEducation("0");
		myForm.setFrmReligion("0");
		myForm.setFrmMedical("0");
		myForm.setFrmGenderType("");
		/*myForm.setFrmAdoptType("");*/
		myForm.setFrmFormControlInsert(null);
	}
	public void insertNewOrphan(ShelterOrphanForm myForm) 
	{
		// TODO Auto-generated method stub
		/*System.out.println("========="+myForm.getFrmName()+"=========");
		System.out.println("========="+myForm.getFrmAge()+"=========");
		System.out.println("========="+myForm.getFrmEducation()+"=========");
		System.out.println("========="+myForm.getFrmReligion()+"=========");
		System.out.println("========="+myForm.getFrmMedical()+"=========");
		System.out.println("========="+myForm.getFrmGenderType()+"=========");*/
		Orphan myOrphan=new Orphan();
		myOrphan.setId(null); 
		myOrphan.setOrphanName(myForm.getFrmName());
		myOrphan.setOrphanAge(myForm.getFrmAge());
		myOrphan.setOrphanEdu(myForm.getFrmEducation());
		myOrphan.setOrphanReligion(myForm.getFrmReligion());
		myOrphan.setOrphanMedicalGrade(myForm.getFrmMedical());
		myOrphan.setOrphanGender(myForm.getFrmGenderType());
		myOrphan.setAdoptStatus(0);		
		/*if(myForm.getFrmAdoptType().equals("Not Yet"))
		{ 
			myOrphan.setAdoptStatus(0);
		}
		else
		{
			myOrphan.setAdoptStatus(1);
		}*/
		
		//show comfirm Form
		if(myOrphan.getOrphanGender().equals("Male"))
		{ 
			myForm.setFrmGenderType("Male");
		}
		else
		{
				myForm.setFrmGenderType("Female");
		}
		
		if(myOrphan.getAdoptStatus().equals("0"))
		{
			myForm.setFrmAdoptType("Not Yet");
		}
		else
		{
			myForm.setFrmAdoptType("Adopt");
		}		
		/*Shelter myloginShelter = myForm.getLoginShelter();*/
		/*Shelter myShelter=myShelterDao.getShelterbyID();*/
		myOrphan.setShelter(myForm.getLoginShelter());
		myOrphanDao.insertOrphan(myOrphan);
	}

	//for Update
	public void getUpdateOrphanbyId(ShelterOrphanForm myForm)
	{
		// TODO Auto-generated method stub
		 Orphan myOrphan = myOrphanDao.getUpdateOrphanById(Integer.parseInt(myForm.getFrmUpdateOrphanId()));
		 	myForm.setFrmName(myOrphan.getOrphanName());
	        myForm.setFrmAge(myOrphan.getOrphanAge());
	        myForm.setFrmEducation(myOrphan.getOrphanEdu());
	        myForm.setFrmReligion(myOrphan.getOrphanReligion());
	        myForm.setFrmMedical(myOrphan.getOrphanMedicalGrade());
	       /* myForm.setFrmGenderName(myOrphan.getOrphanGender());
	        if(myOrphan.getAdoptStatus()==0)
	    		{			myForm.setFrmAdoptStatus("Not Adopted Yet");
	    		
	    		}		else if(myOrphan.getAdoptStatus()==1)
	    		{
	    			myForm.setFrmAdoptStatus("Adopted");
	    		}*/
	        if(myOrphan.getOrphanGender().equals("Male"))
			{ 
				myForm.setFrmGenderType("Male");
			}
			else
			{
					myForm.setFrmGenderType("Female");
			}
			if(myOrphan.getAdoptStatus()==0)
			{
				myForm.setFrmAdoptType("Not Yet");
			}
			else if(myOrphan.getAdoptStatus()==1)
			{
				myForm.setFrmAdoptType("Adopt");
			}
			myForm.setFrmFormControl(null);
					
		} 			
	public void saveUpdateOrphan(ShelterOrphanForm myForm) {
		// TODO Auto-generated method stub
		Orphan myOrphan = new Orphan();
		myOrphan.setId(Integer.parseInt(myForm.getFrmUpdateOrphanId()));
		myOrphan.setOrphanName(myForm.getFrmName());
		myOrphan.setOrphanAge(myForm.getFrmAge());
		myOrphan.setOrphanGender(myForm.getFrmGenderName());
		myOrphan.setOrphanEdu(myForm.getFrmEducation());
		myOrphan.setOrphanReligion(myForm.getFrmReligion());
		myOrphan.setOrphanMedicalGrade(myForm.getFrmMedical());
		if(myForm.getFrmGenderType().equals("Male"))
		{ 
			myOrphan.setOrphanGender("Male");
		}
		else
		{
				myOrphan.setOrphanGender("Female");
		}
		if(myForm.getFrmAdoptType().equals("Adopt"))
		{ 
			myOrphan.setAdoptStatus(1);
		}
		else
		{
			myOrphan.setAdoptStatus(0);
		}		
		myOrphan.setShelter(myForm.getLoginShelter());
		Adopter myAdopter=myAdopterDao.getAdopterInfoByNRC(myForm.getFrmAdopterNRC());
		myOrphan.setAdopter(myAdopter);
		myOrphanDao.saveUpdateOrphan(myOrphan);		
	}
	public void getAdopterInfoByNRC(ShelterOrphanForm myForm) {
		// TODO Auto-generated method stub
		System.out.println("========"+myForm.getFrmAdopterNRC()+"========");
		Adopter myAdopter=myAdopterDao.getAdopterInfoByNRC(myForm.getFrmAdopterNRC());
		myForm.setShelterAdopterList(myAdopter);	
		myForm.setFrmAdopterFormControl("data");
	}
	public void checkAdopterNRCName(ShelterOrphanForm myForm) {
		// TODO Auto-generated method stub
		Adopter myAdopter=myAdopterDao.getAdopterInfoByNRC(myForm.getFrmAdopterNRC());
		if (myAdopter == null) //error
		{
			/*System.out.println(myAdopter.getAdopterNrc());*/
			myForm.setFrmAdopterNRCError(null);
		} 
		else
		{
			myForm.setFrmAdopterNRCError("data");
		}
	}
	
	//For Detail
	public void getOrphanListbyid(ShelterOrphanForm myForm) {
		// TODO Auto-generated method stub
		Orphan myOrphan=myOrphanDao.getOrphanById(Integer.parseInt(myForm.getFrmDetailOrphanId()));
		myForm.setFrmOrphanDetail(myOrphan);
	}
	
	/*//for Delete
	public void getFrmDeleteOrphanbyId(ShelterOrphanForm myForm) {
		// TODO Auto-generated method stub
		myOrphanDao.getDeleteOrphanbyId(Integer.parseInt(myForm.getFrmDeleteOrphanId()));
	}*/
	

}
