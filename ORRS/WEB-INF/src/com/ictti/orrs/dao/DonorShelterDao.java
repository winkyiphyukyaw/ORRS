package com.ictti.orrs.dao;

import java.util.Date;
import java.util.List;

import com.ictti.orrs.business.entity.DonorShelter;

public interface DonorShelterDao {

	void SaveDonorShelter(DonorShelter inDonorShelter);
	List<DonorShelter> getDonorListbyShelter(int sid);
	List<DonorShelter> getAllDateForMealByShelterId(int sid, Date myDate1);
	
	
	List<DonorShelter> getAllDonorListByShelterName(String donorShelterName);
	List<DonorShelter> getDonorShelterByNRC(String donorNRC);
	List<DonorShelter> getAllDonorList();
	List<DonorShelter> getAllDonor(String s);
}
