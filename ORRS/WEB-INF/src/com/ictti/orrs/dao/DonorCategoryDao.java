package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.DonorCategory;

public interface DonorCategoryDao {

	void SaveDonorCategory(DonorCategory inDonorCategory);
	
	List<DonorCategory> getAllDonorList();
	List<DonorCategory> getDonorCategoryByNRC(int detailDonorId);
	List<DonorCategory> getAllDonor(String s);
}
