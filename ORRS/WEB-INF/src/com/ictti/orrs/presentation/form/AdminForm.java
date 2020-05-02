package com.ictti.orrs.presentation.form;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.Admin;



public class AdminForm extends ValidatorForm {
	private int adminId;
	private String adminLoginName;
	private String adminPassword;
	private Admin loginAdmin;
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public Admin getLoginAdmin() {
		return loginAdmin;
	}
	public void setLoginAdmin(Admin loginAdmin) {
		this.loginAdmin = loginAdmin;
	}
	public String getAdminLoginName() {
		return adminLoginName;
	}
	public void setAdminLoginName(String adminLoginName) {
		this.adminLoginName = adminLoginName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	

}
