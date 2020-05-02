package com.ictti.orrs.presentation.form;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.Admin;

public class AdminLoginForm extends ValidatorForm {
	private String frmLoginAdminName;
	private String frmLoginAdminPassword;
	private Admin frmloginAdmin;
	public Admin getFrmloginAdmin() {
		return frmloginAdmin;
	}
	public void setFrmloginAdmin(Admin frmloginAdmin) {
		this.frmloginAdmin = frmloginAdmin;
	}
	public String getFrmLoginAdminName() {
		return frmLoginAdminName;
	}
	public void setFrmLoginAdminName(String frmLoginAdminName) {
		this.frmLoginAdminName = frmLoginAdminName;
	}
	public String getFrmLoginAdminPassword() {
		return frmLoginAdminPassword;
	}
	public void setFrmLoginAdminPassword(String frmLoginAdminPassword) {
		this.frmLoginAdminPassword = frmLoginAdminPassword;
	}
	
	
	
	private String frmRegName;
	private String frmRegPassword;
	private String frmRegConfPassword;
	private String frmRegFormControl;
	public String getFrmRegFormControl() {
		return frmRegFormControl;
	}
	public void setFrmRegFormControl(String frmRegFormControl) {
		this.frmRegFormControl = frmRegFormControl;
	}
	public String getFrmRegName() {
		return frmRegName;
	}
	public void setFrmRegName(String frmRegName) {
		this.frmRegName = frmRegName;
	}
	public String getFrmRegPassword() {
		return frmRegPassword;
	}
	public void setFrmRegPassword(String frmRegPassword) {
		this.frmRegPassword = frmRegPassword;
	}
	public String getFrmRegConfPassword() {
		return frmRegConfPassword;
	}
	public void setFrmRegConfPassword(String frmRegConfPassword) {
		this.frmRegConfPassword = frmRegConfPassword;
	}
	
	
	
	
	private String frmLoginName;
	public String getFrmLoginName() {
		return frmLoginName;
	}
	public void setFrmLoginName(String frmLoginName) {
		this.frmLoginName = frmLoginName;
	}
}
