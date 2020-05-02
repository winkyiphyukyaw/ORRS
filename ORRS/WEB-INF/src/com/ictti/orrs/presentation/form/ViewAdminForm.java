package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.Admin;

public class ViewAdminForm extends ValidatorForm {
private String adminLoginName;
	
	private String adminPassword;
	
	private int begin;
	private int end;
	private int actualPage;
	private int iMaxShow;
	private int iMaxData;
	private boolean prevBtn;
	
	private boolean nextBtn;
	private int finalPage;
	
	private String adminViewControl;
	private String adminViewUpdateId;
	
	private List<Admin> adminList;
	 private Admin adminViewUpdate;
	 private String adminConfirmPassword;
	 private String frmAdminNameError;
	 private Admin loginAdmin;
	
	
	
	
	
	public Admin getLoginAdmin() {
		return loginAdmin;
	}
	public void setLoginAdmin(Admin loginAdmin) {
		this.loginAdmin = loginAdmin;
	}
	public String getFrmAdminNameError() {
		return frmAdminNameError;
	}
	public void setFrmAdminNameError(String frmAdminNameError) {
		this.frmAdminNameError = frmAdminNameError;
	}
	public String getAdminConfirmPassword() {
		return adminConfirmPassword;
	}
	public void setAdminConfirmPassword(String adminConfirmPassword) {
		this.adminConfirmPassword = adminConfirmPassword;
	}
	public Admin getAdminViewUpdate() {
		return adminViewUpdate;
	}
	public void setAdminViewUpdate(Admin adminViewUpdate) {
		this.adminViewUpdate = adminViewUpdate;
	}
	public List<Admin> getAdminList() {
		return adminList;
	}
	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}
	//private int categoryId;
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
	public int getBegin() {
		begin=(actualPage-1)*iMaxShow+1;
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		end=actualPage*iMaxShow; 
		if(end>iMaxData)
		end=iMaxData;

		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	public int getActualPage() {
		return actualPage;
	}
	public void setActualPage(int actualPage) {
		this.actualPage = actualPage;
	}
	public int getiMaxShow() {
		return iMaxShow;
	}
	public void setiMaxShow(int iMaxShow) {
		this.iMaxShow = iMaxShow;
	}
	public int getiMaxData() {
		return iMaxData;
	}
	public void setiMaxData(int iMaxData) {
		this.iMaxData = iMaxData;
	}
	public boolean isPrevBtn() {
		if(actualPage==1)
			prevBtn=false;
			else 
			prevBtn=true;

		return prevBtn;
	}

	public void setPrevBtn(boolean prevBtn) {
		this.prevBtn = prevBtn;
	}
	public void setNextBtn(boolean nextBtn) {
		this.nextBtn = nextBtn;
	}
	public boolean isNextBtn() {
		if(actualPage==getFinalPage())
			nextBtn=false;
		else nextBtn=true;

		return nextBtn;
	}

	public int getFinalPage() {
		finalPage=(int)Math.ceil((double)iMaxData/iMaxShow);
		return finalPage;
	}
	
	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}
	public String getAdminViewControl() {
		return adminViewControl;
	}
	public void setAdminViewControl(String adminViewControl) {
		this.adminViewControl = adminViewControl;
	}
	public String getAdminViewUpdateId() {
		return adminViewUpdateId;
	}
	public void setAdminViewUpdateId(String adminViewUpdateId) {
		this.adminViewUpdateId = adminViewUpdateId;
	}
	


}
