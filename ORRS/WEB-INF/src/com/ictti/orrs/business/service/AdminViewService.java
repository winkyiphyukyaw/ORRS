package com.ictti.orrs.business.service;

import java.util.List;

import com.ictti.orrs.business.entity.Admin;
import com.ictti.orrs.dao.AdminDao;
import com.ictti.orrs.presentation.form.ViewAdminForm;

public class AdminViewService {
	AdminDao myAdminDao;
	

	public AdminDao getMyAdminDao() {
		return myAdminDao;
	}

	public void setMyAdminDao(AdminDao myAdminDao) {
		this.myAdminDao = myAdminDao;
	}

	public void getAllAdminList(ViewAdminForm myForm) {
		// TODO Auto-generated method stub
		List<Admin> l=myAdminDao.getAllAdminList();		
		
		myForm.setAdminList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(5);
		if(l!=null)
		{
			myForm.setiMaxData(l.size());
		}
	
	}

	public void getAllAdminById(ViewAdminForm myForm) {
		// TODO Auto-generated method stub
		Admin a=myAdminDao.getAllAdminByid(Integer.parseInt(myForm.getAdminViewUpdateId()));
		myForm.setAdminLoginName(a.getAdminName());
		myForm.setAdminPassword(a.getAdminPassword());
		myForm.setAdminViewControl(null);
		//myForm.setAdminViewControl("");
	}

	public void firstLoadAdmin(ViewAdminForm myForm) {
		// TODO Auto-generated method stub
		myForm.setAdminViewControl("");
	}

	public void saveUpdateAdmin(ViewAdminForm myForm) {
		// TODO Auto-generated method stub
Admin myAdmin=myForm.getLoginAdmin();
myAdmin.setAdminName(myForm.getAdminLoginName());
myAdmin.setAdminPassword(myForm.getAdminPassword());
		
myAdminDao.saveAdmin(myAdmin);
	}
	

	public void firstLoadUpdateProfile(ViewAdminForm myForm) {
		// TODO Auto-generated method stub
Admin myLoginAdmin=myForm.getLoginAdmin();
		
		System.out.println("Login admin is======"+myForm.getLoginAdmin().getAdminName());
		myForm.setAdminConfirmPassword(myLoginAdmin.getAdminPassword());
		
		myForm.setAdminLoginName(myLoginAdmin.getAdminName());
		
		myForm.setAdminPassword(myLoginAdmin.getAdminPassword());
		
		myForm.setAdminViewControl(null);
	}

/*	public void checkAdminName(ViewAdminForm myForm) {
		// TODO Auto-generated method stub
      Admin myAdmin = myAdminDao.getCheckNamebyAdminName(myForm.getAdminLoginName());
		
		if (myAdmin != null) //error
		{
			System.out.println(myAdmin.getAdminName());
			myForm.setFrmAdminNameError(null);
		} 
		else
		{
			
			myForm.setFrmAdminNameError("data");
		}
		
	}*/
}




	


