package com.ictti.orrs.business.service;

import java.util.ArrayList;
import java.util.List;
import com.ictti.orrs.business.entity.City;
import com.ictti.orrs.business.entity.RegionState;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.dao.CityDao;
import com.ictti.orrs.dao.RegionStateDao;
import com.ictti.orrs.dao.ShelterDao;
import com.ictti.orrs.presentation.form.DonorRegForm;

public class SearchShelterService {
	ShelterDao myShelterDao;
	RegionStateDao myRegionDao;
	CityDao myCityDao;

	public RegionStateDao getMyRegionDao() {
		return myRegionDao;
	}
	public void setMyRegionDao(RegionStateDao myRegionDao) {
		this.myRegionDao = myRegionDao;
	}
	public CityDao getMyCityDao() {
		return myCityDao;
	}
	public void setMyCityDao(CityDao myCityDao) {
		this.myCityDao = myCityDao;
	}

	public ShelterDao getMyShelterDao() {
		return myShelterDao;
	}
	public void setMyShelterDao(ShelterDao myShelterDao) {
		this.myShelterDao = myShelterDao;
	}
	
	//from jsp
	public List<Shelter> getShelterByRegion(String id){
		List<Shelter> sl = new ArrayList<>();
		
		Shelter s = new Shelter();
		
		if(id.equals("0"))
		{
			s.setId(0);
			s.setShelterName("All");
			sl.add(s);
			sl.addAll(myShelterDao.getAllShelters());
			 return sl;
		}
		else{
			s.setId(0);
			s.setShelterName("All");
			sl.add(s);
			sl.addAll(myShelterDao.getSheltersByRegion(Integer.parseInt(id)));
			return sl;
		}
		
		
	}
	//from jsp
	
	public List<City> getCityByRegion(String id){
		List<City> cl = new ArrayList<>();
		City c = new City();
		
		if(id.equals("0"))
		{
			c.setId(0);
			c.setName("All");
			cl.add(c);
			cl.addAll(myCityDao.getAllCity());
			 return cl;
		}
		else{
			c.setId(0);
			c.setName("All");
			cl.add(c);
			cl.addAll(myCityDao.getCityByRegionId(Integer.parseInt(id)));
			return cl;
		}
		
	}
	//from jsp
	public List<Shelter> getShelterByCity(String cid,String rid){
		List<Shelter> sl = new ArrayList<>();
		Shelter s = new Shelter();
		if(cid.equals("0"))
		{
			s.setId(0);
			s.setShelterName("All");
			sl.add(s);
			if(rid.equals("0"))
			{
				sl.addAll(myShelterDao.getAllShelters());
			}
			else
				sl.addAll(myShelterDao.getSheltersByRegion(Integer.parseInt(rid)));
			 return sl;
		}
		else{
			s.setId(0);
			s.setShelterName("All");
			sl.add(s);
			sl.addAll(myShelterDao.getSheltersByCity(Integer.parseInt(cid)));
			return sl;
		}
		
	}
	//first load
	public void getAllRegion(DonorRegForm myForm) {
		// TODO Auto-generated method stub
		List<RegionState> l = myRegionDao.getAllRegion();
		myForm.setRegionChoice(l);
	}
	public void getAllShelter(DonorRegForm myForm) {
		// TODO Auto-generated method stub
		List<Shelter> l = myShelterDao.getAllShelters();
		myForm.setFrmShelterList(l);
	}
	public void getAllCity(DonorRegForm myForm) {
		// TODO Auto-generated method stub
		List<City> l = myCityDao.getAllCity();
		myForm.setFrmCityList(l);
	}
	//below list
	public void getShelters(DonorRegForm myForm) {
			// TODO Auto-generated method stub
			List<Shelter> l = myShelterDao.getAllShelters();
			myForm.setFrmShelterList1(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(5);
			if(l!=null)
				myForm.setiMaxData(l.size());
	}
	
	
	public void getSheltersByCondition(DonorRegForm myForm) {
		// TODO Auto-generated method stu
		List<Shelter> l = new ArrayList<>();
		String region = myForm.getFrmRegionId();
		String city = myForm.getFrmCityId();
		String shelter = myForm.getFrmShelterId();
		int region_id = Integer.parseInt(region);
		int city_id = Integer.parseInt(city);
		int shelter_id = Integer.parseInt(shelter);
		
		//Choose All
		if(!(region.equals("0")) && !(city.equals("0")) && !(shelter.equals("0"))){
			 l = myShelterDao.getSheltersByRegionAndCityAndShelter(region_id,city_id,shelter_id);
		}
		//Not Choose All
		else if((region.equals("0")) && (city.equals("0")) && (shelter.equals("0"))){
			l=myShelterDao.getAllShelters();
		}
		//choose Region
		else if(!(region.equals("0")) && (city.equals("0")) && (shelter.equals("0"))){
			 //l = myShelterDao.getAllShelters();
			l=myShelterDao.getSheltersByRegion(region_id);
		}
		
		//choose City
		else if((region.equals("0")) && !(city.equals("0")) && (shelter.equals("0"))){
			l=myShelterDao.getSheltersByCity(city_id);
		}
		
		//choose Shelter
		else if((region.equals("0")) && (city.equals("0")) && !(shelter.equals("0"))){
			l=myShelterDao.getSheltersByShelter(shelter_id);
		}
		
		//choose Region and City
		else if(!(region.equals("0")) && !(city.equals("0")) && (shelter.equals("0"))){
			l=myShelterDao.getSheltersByRegionandCity(region_id,city_id);
		}
		
		//choose Region and Shelter
		else if(!(region.equals("0")) && (city.equals("0")) && !(shelter.equals("0"))){
			 l = myShelterDao.getSheltersByRegionAndShelter(region_id,shelter_id);
		}
		
		//choose City and Shelter
		else if((region.equals("0")) && !(city.equals("0")) && !(shelter.equals("0"))){
			 l = myShelterDao.getSheltersByCityandShelter(city_id,shelter_id);
		}
		myForm.setFrmShelterList1(l);
		//myForm.setFrmCityList(myCityDao.getCityByRegionId(Integer.parseInt(myForm.getFrmRegionId())));
		myForm.setActualPage(1);
		myForm.setiMaxShow(5);
		if(l!=null)
			myForm.setiMaxData(l.size());
		System.out.println("Size is"+l.size());
	}
	//detail
	public void getShelterById(DonorRegForm myForm) {
		// TODO Auto-generated method stub
		Shelter s = myShelterDao.getShelterByDetailId(Integer.parseInt(myForm.getFrmDetailShelterId()));
		myForm.setShelterDetail(s);
	}
	
	
	
}
