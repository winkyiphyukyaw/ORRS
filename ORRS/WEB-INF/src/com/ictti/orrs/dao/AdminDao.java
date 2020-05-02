package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.Admin;

public interface AdminDao {
	public Admin getAdminByLoginNameAndPassword(String adminLoginName,
			String adminPassword) ;

	public void SaveFile(Admin myAdmin);

	public List<Admin> getAllAdminList();

	public List<Admin> getAdminByNameAndPassword(String adminLoginName,
			String adminPassword);

	public void saveAdmin(Admin myAdmin);

	public Admin getAdminByLoginNameAndPassword(int parseInt);

	public Admin getAllAdminByid(int id);

	public void saveUpdateAdmin(Admin myUpdateAdmin);

	/*public Admin getCheckNamebyAdminName(String adminLoginName);*/
}
