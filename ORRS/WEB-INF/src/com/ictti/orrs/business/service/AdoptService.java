package com.ictti.orrs.business.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;

import com.ictti.orrs.business.entity.Adopter;
import com.ictti.orrs.business.entity.AdopterImage;
import com.ictti.orrs.business.entity.City;
import com.ictti.orrs.business.entity.RegionState;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.dao.AdopterDao;
import com.ictti.orrs.dao.AdopterImageDao;
import com.ictti.orrs.dao.CityDao;
import com.ictti.orrs.dao.RegionStateDao;
import com.ictti.orrs.dao.ShelterDao;
import com.ictti.orrs.presentation.form.AdopterForm;
import com.ictti.orrs.presentation.form.DonorRegForm;

public class AdoptService {
	AdopterDao myAdoptDao;
	AdopterImageDao myAdopterImageDao;
	ShelterDao myShelterDao;
	RegionStateDao myRegionDao;
	CityDao myCityDao;

	public ShelterDao getMyShelterDao() {
		return myShelterDao;
	}

	public void setMyShelterDao(ShelterDao myShelterDao) {
		this.myShelterDao = myShelterDao;
	}

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

	public AdopterImageDao getMyAdopterImageDao() {
		return myAdopterImageDao;
	}

	public void setMyAdopterImageDao(AdopterImageDao myAdopterImageDao) {
		this.myAdopterImageDao = myAdopterImageDao;
	}

	public AdopterDao getMyAdoptDao() {
		return myAdoptDao;
	}

	public void setMyAdoptDao(AdopterDao myAdoptDao) {
		this.myAdoptDao = myAdoptDao;
	}
	
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
		public void getAllRegion(AdopterForm myForm) {
			// TODO Auto-generated method stub
			List<RegionState> l = myRegionDao.getAllRegion();
			myForm.setRegionChoice(l);
		}
		public void getAllShelter(AdopterForm myForm) {
			// TODO Auto-generated method stub
			List<Shelter> l = myShelterDao.getAllShelters();
			myForm.setFrmShelterList(l);
		}
		public void getAllCity(AdopterForm myForm) {
			// TODO Auto-generated method stub
			List<City> l = myCityDao.getAllCity();
			myForm.setFrmCityList(l);
		}

	public void getAdopterInfo(AdopterForm myForm) {
		// TODO Auto-generated method stub
		
		if (myForm.getFrmAdopterGender().equals("0")) {
			myForm.setFrmAdopterGender("male");
		} else if(myForm.getFrmAdopterGender().equals("1")) {
			myForm.setFrmAdopterGender("female");
		}
		if (myForm.getFrmAdopterMaritalStatus().equals("0")) {
			myForm.setFrmAdopterMaritalStatus("single");
		} else if(myForm.getFrmAdopterMaritalStatus().equals("1")) {
			myForm.setFrmAdopterMaritalStatus("married");
		}
		// For region
		/*switch (myForm.getFrmShelterName()) {
		case "1":
			myForm.setFrmShelterName("Yangon");
			break;
		case "2":
			myForm.setFrmShelterName("Mandalay");
			break;
		case "3":
			myForm.setFrmShelterName("Thaninthayi");
			break;
		case "4":
			myForm.setFrmShelterName("Mon");
			break;
		case "5":
			myForm.setFrmShelterName("Ayeyarwaddy");
			break;
		case "6":
			myForm.setFrmShelterName("Kayin");
			break;
		case "7":
			myForm.setFrmShelterName("Bago");
			break;
		case "8":
			myForm.setFrmShelterName("Rakhine");
			break;
		case "9":
			myForm.setFrmShelterName("Magwe");
			break;
		case "10":
			myForm.setFrmShelterName("Kayah");
			break;
		case "11":
			myForm.setFrmShelterName("Shan");
			break;
		case "12":
			myForm.setFrmShelterName("Sagaing");
			break;
		case "13":
			myForm.setFrmShelterName("Chin");
			break;
		case "14":
			myForm.setFrmShelterName("Kachin");
			break;

		}
		*/
		if (myForm.getFrmRegionId().equals("0")){
			myForm.setFrmRegionName("All");
		}
		else {
			RegionState rs = myRegionDao.getRegionNameById(Integer.parseInt(myForm.getFrmRegionId()));
			myForm.setFrmRegionName(rs.getName());
		}
		if (myForm.getFrmCityId().equals("0")){
			myForm.setFrmCityName("All");
		}
		else {
			City city = myCityDao.getCityNameById(Integer.parseInt(myForm.getFrmCityId()));
			myForm.setFrmCityName(city.getName());
		}
		if (myForm.getFrmShelterId().equals("0")){
			myForm.setFrmShelterName("All");
		}
		else {
			Shelter shelter = myShelterDao.getShelterById(Integer.parseInt(myForm.getFrmShelterId()));
			myForm.setFrmShelterName(shelter.getShelterName());
		}
		if (myForm.getFrmOrphanGender().equals("0")) {
			myForm.setFrmOrphanGender("male");

		} else {
			myForm.setFrmOrphanGender("female");
		}
		switch (myForm.getFrmOrphanAge()) {
		case "0":
			myForm.setFrmOrphanAge("Under 1 year");
			break;
		case "1":
			myForm.setFrmOrphanAge("Under 5 year");
			break;
		case "2":
			myForm.setFrmOrphanAge("Under 10 year");
			break;
		case "3":
			myForm.setFrmOrphanAge("Under 15 year");
			break;
			
		}
		
		

		myForm.setFrmRegFormControl("data");

	}

	public void saveAdopterInfo(AdopterForm myForm)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		Adopter adopterInfo = new Adopter();
		AdopterImage adopterImg = new AdopterImage();
		System.out.print(Integer.parseInt(myForm.getFrmRegionId()));
		RegionState rs = myRegionDao.getRegionById(Integer.parseInt(myForm.getFrmRegionId()));
		
		City city = myCityDao.getCityByCityId(Integer.parseInt(myForm.getFrmCityId()));
		Shelter shelter = myShelterDao.getShelterById(Integer.parseInt(myForm.getFrmShelterId()));
		adopterInfo.setId(null);
		adopterInfo.setAdopterName(myForm.getFrmAdopterName());
		adopterInfo.setAdopterEmail(myForm.getFrmAdopterEmail());
		adopterInfo.setAdopterPhNo(myForm.getFrmAdopterPhone());
		adopterInfo.setAdopterAddress(myForm.getFrmAdopterAddress());
		adopterInfo.setAdopterNrc(myForm.getFrmAdopterNrc());
		adopterInfo.setAdopterIncome(myForm.getFrmAdopterIncome());
		adopterInfo.setAdopterOccupation(myForm.getFrmAdopterOccupation());
		adopterInfo.setAdopterMaritalStatus(myForm
				.getFrmAdopterMaritalStatus());
		adopterInfo.setAdopterGender(myForm.getFrmAdopterGender());
		adopterInfo.setAdopterNoOfChildren(Integer.parseInt(myForm
				.getFrmAdopterChildNo()));
		adopterInfo.setMailStatus(0);
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dob = myForm.getFrmAdopterDob();
		Date date;
		try {
			date = myFormat.parse(dob);
			adopterInfo.setAdopterDob(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//adopterInfo.setAdopterShelterLocation(myForm.getFrmShelterName());
/*		adopterInfo.setAdopterOrphanAge(Integer.parseInt(myForm.getFrmOrphanAge()));
*/		adopterInfo.setAdopterOrphanAge(myForm.getFrmOrphanAge());

		adopterInfo.setAdoptedChildNo(Integer.parseInt(myForm
				.getFrmAdoptedChildNo()));
		adopterInfo.setAdopterOrphanGender(myForm.getFrmOrphanGender());
		adopterInfo.setRegionState(rs);
		adopterInfo.setCity(city);
		adopterInfo.setShelter(shelter);
		myAdoptDao.saveAdopterInfo(adopterInfo);
		// for AdopterImage

		try {
			Blob bdata = Hibernate.createBlob(myForm.getFrmFileUpload()
					.getInputStream());
			adopterImg.setId(null);
			adopterImg.setImage(bdata);
			adopterImg.setAdopter(adopterInfo);
			myAdopterImageDao.saveFamilyForm(adopterImg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}