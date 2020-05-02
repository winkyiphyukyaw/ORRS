package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.Adopter;



public interface AdopterDao {

	void saveAdopterInfo(Adopter adopterInfo);

	Adopter getAdoptersById(int frmDetailAdopterId);

	List<Adopter> getAllAdoptersList();

	List<Adopter> getAdoptedAdoptersList();
	public Adopter getAllAdopterByid(int id);
	
	
	
	
	List<Adopter> getAllAdoptersListShelterId(int id);
	void setStatus(Adopter myAdopter);
	Adopter getStatus();
	
	public List<Adopter> getAllAdopterList();
	public Adopter getAdopterById(int parseInt);
	List<Adopter> getAdopterNameListByPattern(String s);
	List<Adopter> getAllAdopterName(String frmAdopterSearchName);
	Adopter getMailStatus();
	
	
	Adopter getAdopterInfoByNRC(String frmAdopterNRC);
}