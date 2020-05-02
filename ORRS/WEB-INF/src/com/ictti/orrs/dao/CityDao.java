package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.City;

public interface CityDao {
	List<City> getCityByRegionId(int parseInt);

	List<City> getAllCity();

	List<City> getSubcityByRegionId(int id);
	
	City getCityByCityId(int parseInt);

	/*City getCityByCityName(String frmCityName);*/
	City getCityByCityName(String frmCityName, int id);

	void addNewCity(City mycity);

	List<City> getCityNamebyRegionId(int id);

	void saveUpdateCity(City myCity);

	
	City getCityByCityNameExist(String frmCityName, int parseInt);

	City getCityNameById(int parseInt);
	
	
	
}






