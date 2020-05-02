package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.Orphan;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.presentation.form.ShelterOrphanForm;

public interface OrphanDao {

	Orphan getOrphanbyID(int id);

	void getDeleteOrphanbyId(int id);

	Orphan getOrphanbyID(ShelterOrphanForm myForm);

	public List<Orphan> getAllOrphanList();

	public Orphan getAllOrphanByid(int id);

	List<Orphan> getOrphanByAdopterId(String orphanAge, String orphanGender);

	List<Orphan> getAllOrphanList(Shelter myloginShelter);

	void insertOrphan(Orphan myOrphan);

	Orphan getUpdateOrphanById(int id);

	void saveUpdateOrphan(Orphan myOrphan);

	Orphan getOrphanById(int id);
	
	List<Orphan> getAllOrphanListByShelterName(String adminOrphanShelterName);
	
	
	
	Orphan getOrphanByAdopterId(int parseInt, int shelterId);

	List<Orphan> getOrphanByAgeAndGender(String orphanAge, String orphanGender);
	
	


}
