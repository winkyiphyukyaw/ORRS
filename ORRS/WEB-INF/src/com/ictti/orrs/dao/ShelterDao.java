package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.Shelter;

public interface ShelterDao {

	public List<Shelter> getAllShelter(String s);

	

	public Shelter getShelterByShelterName(String frmShelterName);



	public Shelter checkShelterBySName(String frmShelterName);
	
	List<Shelter> getSheltersByRegionAndCityAndShelter(int rid, int cid, int sid);//choose all
	List<Shelter> getAllShelters();//not choose all in service and from Action
	List<Shelter> getSheltersByRegion(int rid);//choose region
	List<Shelter> getSheltersByCity(int cid);//choose city
	List<Shelter> getSheltersByShelter(int sid);//choose shelter
	List<Shelter> getSheltersByRegionandCity(int rid, int cid);//choose region and city
	List<Shelter> getSheltersByRegionAndShelter(int rid, int cid);//choose region and shelter
	List<Shelter> getSheltersByCityandShelter(int cid, int sid);//choose city and shelter

	Shelter getShelterByDetailId(int parseInt);
	
	//For shelter Page 
	public void saveShelter(Shelter myShelter);



	public Shelter getShelterByLoginName(String shelterRegLoginName);



	public Shelter getShelterByLoginNameAndPassword(String shelterLoginName,
			String shelterPassword);
	


	



	public Shelter getShelterId(int id);
	Shelter getShelterbyID();



	public Shelter getShelterById(int parseInt);
	
	public List<Shelter> getShelterNameListByPattern(String s);
	


}
