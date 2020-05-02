package com.ictti.orrs.business.service;

import java.util.List;

import com.ictti.orrs.business.entity.City;
import com.ictti.orrs.business.entity.RegionState;
import com.ictti.orrs.dao.CityDao;
import com.ictti.orrs.dao.RegionStateDao;
import com.ictti.orrs.presentation.form.AdminLocationForm;

public class AdminLocationService {
	
	RegionStateDao myRegionStateDao;
	CityDao myCityDao;
	
	public RegionStateDao getMyRegionStateDao() {
		return myRegionStateDao;
	}


	public void setMyRegionStateDao(RegionStateDao myRegionStateDao) {
		this.myRegionStateDao = myRegionStateDao;
	}


	public CityDao getMyCityDao() {
		return myCityDao;
	}


	public void setMyCityDao(CityDao myCityDao) {
		this.myCityDao = myCityDao;
	}


	public void getAllRegion(AdminLocationForm myForm) {
		// TODO Auto-generated method stub
		List<RegionState> l=myRegionStateDao.getAllRegion();
		myForm.setFrmRegionList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(5);
		if(l!=null)
			myForm.setiMaxData(l.size());
	}

	//For subcategory
	/*public List<City> getBySubcity(String id)
	{
		List<City> l=myCityDao.getSubcityByRegionId(Integer.parseInt(id));
		return l;
	}*/
	
	
	//Check City for ADD
	public void checkCityName(AdminLocationForm myForm) {
		// TODO Auto-generated method stub
		/*City myCity = myCityDao.getCityByCityName(myForm.getFrmCityName(),Integer.parseInt(myForm.getFrmRegionId()));*/
		City myCity = myCityDao.getCityByCityName(myForm.getFrmCityName(),Integer.parseInt(myForm.getFrmCitybyRegionId()));
		RegionState myRegion=myRegionStateDao.getRegionById(Integer.parseInt(myForm.getFrmCitybyRegionId()));
		if (myCity != null) //error
		{
			System.out.println(myCity.getName());
			myForm.setFrmCityNameError(null);
		} 
		else
		{
			myForm.setFrmRegionStateName(myRegion.getName());
			myForm.setFrmCityNameError("data");
		}
	}	
	//Check City For Update Add
	public void checkCityNameExist(AdminLocationForm myForm) 
	{
		// TODO Auto-generated method stub
		City myCity = myCityDao.getCityByCityNameExist(myForm.getFrmCityName(),Integer.parseInt(myForm.getFrmCitybyRegionId()));
		if (myCity != null) //error
		{
			System.out.println(myCity.getName());
			myForm.setFrmCityNameError(null);
		} 
		else
		{
			myForm.setFrmCityNameError("data");
		}
	}

	//For ADD city
	public void firstLoadAddCity(AdminLocationForm myForm) {
		// TODO Auto-generated method stub
		RegionState myRegion=myRegionStateDao.getRegionById(Integer.parseInt(myForm.getFrmCitybyRegionId()));
		myForm.setFrmCityName("");
		myForm.setFrmRegionStateName(myRegion.getName());
		myForm.setFrmFormControlLocation(null);
	}
	public void saveNewCity(AdminLocationForm myForm) {
		// TODO Auto-generated method stub
		/*RegionState myRegion=myRegionStateDao.getRegionById(Integer.parseInt(myForm.getFrmRegionId()));*/
		RegionState myRegion=myRegionStateDao.getRegionById(Integer.parseInt(myForm.getFrmCitybyRegionId()));
		City mycity=new City();
		mycity.setId(null);
		mycity.setName(myForm.getFrmCityName());
		mycity.setRegionState(myRegion);
		myCityDao.addNewCity(mycity);
	}

	//For Detail
	public void getCityNamebyRegionId(AdminLocationForm myForm) {
		// TODO Auto-generated method stub
		List<City> myCity=myCityDao.getCityNamebyRegionId(Integer.parseInt(myForm.getFrmCitybyRegionId()));
		myForm.setFrmSubcityList(myCity);
		myForm.setActualPage(1);
		myForm.setiMaxShowDetail(5);
		if(myCity!=null)
			myForm.setiMaxDataDetail(myCity.size());
	}
	public void getRegionNamebyRegionId(AdminLocationForm myForm) {
		// TODO Auto-generated method stub
		RegionState myRegion=myRegionStateDao.getRegionById(Integer.parseInt(myForm.getFrmCitybyRegionId()));
		myForm.setFrmRegionStateName(myRegion.getName());
	}

	//For Update
	public void firstLoadCityUpdate(AdminLocationForm myForm) {
		// TODO Auto-generated method stub
		City myCity=myCityDao.getCityByCityId(Integer.parseInt(myForm.getFrmUpdateCityId()));
		myForm.setFrmRegionName(myCity.getRegionState().getName());
		myForm.setFrmCityName(myCity.getName());
		myForm.setFrmFormControl(null);	
	}
	public void saveUpdateCityName(AdminLocationForm myForm) {
		// TODO Auto-generated method stub
		City myCity=myCityDao.getCityByCityId(Integer.parseInt(myForm.getFrmUpdateCityId()));
		myCity.setName(myForm.getFrmCityName());
		myCityDao.saveUpdateCity(myCity);
	}

}
