package com.ictti.orrs.business.service;

import com.ictti.orrs.business.entity.Admin;
import com.ictti.orrs.dao.AdminDao;
import com.ictti.orrs.presentation.form.AdminLoginForm;

public class AdminLoginService {
	AdminDao myAdminDao;
	public AdminDao getMyAdminDao() {
		return myAdminDao;
	}
	public void setMyAdminDao(AdminDao myAdminDao) {
		this.myAdminDao = myAdminDao;
	}
	public void checkLoginAdmin(AdminLoginForm myForm) {
		// TODO Auto-generated method stub
		Admin loginAdmin=new Admin();
		//loginAdmin=myAdminDao.checkLoginAdmin(myForm.getFrmLoginAdminName(),myForm.getFrmLoginAdminPassword());
		myForm.setFrmloginAdmin(loginAdmin);
	}
	public void setRegAdmin(AdminLoginForm myForm) {
		// TODO Auto-generated method stub
		Admin ad=new Admin();
		ad.setId(null); 
		ad.setAdminName(myForm.getFrmRegName());
		ad.setAdminPassword(myForm.getFrmRegPassword());
		
		//myAdminDao.setRegAdmin(ad);
	}

}
