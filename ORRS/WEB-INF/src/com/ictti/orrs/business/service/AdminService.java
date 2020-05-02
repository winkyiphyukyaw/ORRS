package com.ictti.orrs.business.service;

import com.ictti.orrs.business.entity.Admin;
import com.ictti.orrs.dao.AdminDao;
import com.ictti.orrs.presentation.form.AdminForm;



public class AdminService {
	AdminDao myAdminDao;

	public AdminDao getMyAdminDao() {
		return myAdminDao;
	}

	public void setMyAdminDao(AdminDao myAdminDao) {
		this.myAdminDao = myAdminDao;
	}

	public Admin checkLoginAdmin(AdminForm myForm) {
		// TODO Auto-generated method stub
		Admin myAdmin=myAdminDao.getAdminByLoginNameAndPassword(myForm.getAdminLoginName(),myForm.getAdminPassword());
		myForm.setLoginAdmin(myAdmin);
		return myAdmin;
	}
		
	}

