package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.Donor;

public interface DonorDao {

	Donor SaveDonor(Donor inDonor);

	List<Donor> getAllDonorList();

	Donor getDonorByid(int parseInt);
	
	
}
