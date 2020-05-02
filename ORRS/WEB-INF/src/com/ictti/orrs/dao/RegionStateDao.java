package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.RegionState;

public interface RegionStateDao {
	List<RegionState> getAllRegion();
	
	RegionState getRegionState(Integer regid);

	RegionState getRegionById(int id);

	RegionState getRegionNameById(int parseInt);
	
	}
