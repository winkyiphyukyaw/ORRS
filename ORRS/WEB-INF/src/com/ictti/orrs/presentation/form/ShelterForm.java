package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.City;
import com.ictti.orrs.business.entity.RegionState;
import com.ictti.orrs.business.entity.Shelter;

public class ShelterForm extends ValidatorForm {
	private int shelterId;
	public int getShelterId() {
		return shelterId;
	}
	public void setShelterId(int shelterId) {
		this.shelterId = shelterId;
	}


	private String shelRegFormControl;
	private String shelterRegName;
	private String shelterPrincipalName;
	private String shelterRegLoginName;
	private String shelterRegPassword;
	private String shelterRegConfPassword;
	private String shelterRegEmail;
	private String shelterRegPhone;
	private String shelterRegAddress;	
	private String shelterRegBfCost;
	private String shelterRegLunCost;
	private String shelterRegDinCost;
	private String shelterRegRegionState;
	private String shelterRegRegionStateById;
	private List<RegionState> shelterRegRegionStateList;
	private Shelter loginShelter;
	private String shelterRegCity;
	
	//for delete
	private String ShelRegFormControl;
	private String ShelRegAccountNameError;
	private String ShelRegDate;
	//For Subcity
	private String shelterRegSubCityId;
	private List<City> shelterRegSubcityList;
	

	

	
	public String getShelRegDate() {
		return ShelRegDate;
	}
	public void setShelRegDate(String shelRegDate) {
		ShelRegDate = shelRegDate;
	}
	public String getShelRegAccountNameError() {
		return ShelRegAccountNameError;
	}
	public void setShelRegAccountNameError(String shelRegAccountNameError) {
		ShelRegAccountNameError = shelRegAccountNameError;
	}
	public String getShelterRegSubCityId() {
		return shelterRegSubCityId;
	}
	public void setShelterRegSubCityId(String shelterRegSubCityId) {
		this.shelterRegSubCityId = shelterRegSubCityId;
	}
	public List<City> getShelterRegSubcityList() {
		return shelterRegSubcityList;
	}
	public void setShelterRegSubcityList(List<City> shelterRegSubcityList) {
		this.shelterRegSubcityList = shelterRegSubcityList;
	}
	public String getShelterRegRegionStateById() {
		return shelterRegRegionStateById;
	}
	public void setShelterRegRegionStateById(String shelterRegRegionStateById) {
		this.shelterRegRegionStateById = shelterRegRegionStateById;
	}

	public List<RegionState> getShelterRegRegionStateList() {
		return shelterRegRegionStateList;
	}
	public void setShelterRegRegionStateList(
			List<RegionState> shelterRegRegionStateList) {
		this.shelterRegRegionStateList = shelterRegRegionStateList;
	}	
	public String getShelterRegBfCost() {
		return shelterRegBfCost;
	}
	public void setShelterRegBfCost(String shelterRegBfCost) {
		this.shelterRegBfCost = shelterRegBfCost;
	}
	public String getShelterRegLunCost() {
		return shelterRegLunCost;
	}
	public void setShelterRegLunCost(String shelterRegLunCost) {
		this.shelterRegLunCost = shelterRegLunCost;
	}
	public String getShelterRegDinCost() {
		return shelterRegDinCost;
	}
	public void setShelterRegDinCost(String shelterRegDinCost) {
		this.shelterRegDinCost = shelterRegDinCost;
	}
	public String getShelterRegLoginName() {
		return shelterRegLoginName;
	}
	public void setShelterRegLoginName(String shelterRegLoginName) {
		this.shelterRegLoginName = shelterRegLoginName;
	}
	
	public Shelter getLoginShelter() {
		return loginShelter;
	}
	public void setLoginShelter(Shelter loginShelter) {
		this.loginShelter = loginShelter;
	}
	public String getShelRegFormControl() {
		return shelRegFormControl;
	}
	public void setShelRegFormControl(String shelRegFormControl) {
		this.shelRegFormControl = shelRegFormControl;
	}
	public String getShelterRegName() {
		return shelterRegName;
	}
	public void setShelterRegName(String shelterRegName) {
		this.shelterRegName = shelterRegName;
	}
	public String getShelterPrincipalName() {
		return shelterPrincipalName;
	}
	public void setShelterPrincipalName(String shelterPrincipalName) {
		this.shelterPrincipalName = shelterPrincipalName;
	}
	public String getShelterRegPassword() {
		return shelterRegPassword;
	}
	public void setShelterRegPassword(String shelterRegPassword) {
		this.shelterRegPassword = shelterRegPassword;
	}
	public String getShelterRegConfPassword() {
		return shelterRegConfPassword;
	}
	public void setShelterRegConfPassword(String shelterRegConfPassword) {
		this.shelterRegConfPassword = shelterRegConfPassword;
	}
	public String getShelterRegEmail() {
		return shelterRegEmail;
	}
	public void setShelterRegEmail(String shelterRegEmail) {
		this.shelterRegEmail = shelterRegEmail;
	}
	public String getShelterRegPhone() {
		return shelterRegPhone;
	}
	public void setShelterRegPhone(String shelterRegPhone) {
		this.shelterRegPhone = shelterRegPhone;
	}
	public String getShelterRegAddress() {
		return shelterRegAddress;
	}
	public void setShelterRegAddress(String shelterRegAddress) {
		this.shelterRegAddress = shelterRegAddress;
	}
	
	
	
	public String getShelterRegRegionState() {
		return shelterRegRegionState;
	}
	public void setShelterRegRegionState(String shelterRegRegionState) {
		this.shelterRegRegionState = shelterRegRegionState;
	}

	
	//for login
	
	private String shelterLoginName;
	private String shelterPassword;
	
	public String getShelterLoginName() {
		return shelterLoginName;
	}
	public void setShelterLoginName(String shelterLoginName) {
		this.shelterLoginName = shelterLoginName;
	}
	public String getShelterPassword() {
		return shelterPassword;
	}
	public void setShelterPassword(String shelterPassword) {
		this.shelterPassword = shelterPassword;
	}
	public String getShelterRegCity() {
		return shelterRegCity;
	}
	public void setShelterRegCity(String shelterRegCity) {
		this.shelterRegCity = shelterRegCity;
	}
	
	/*
	//for report

	private String frmYearId;	
	private List<ShelterReportTable> frmYearList;
	//private String frmShelterNo;
	private String frmFileName;
	
	public String getFrmFileName() {
		return frmFileName;
	}
	public void setFrmFileName(String frmFileName) {
		this.frmFileName = frmFileName;
	}
	
	public String getFrmShelterNo() {
		return frmShelterNo;
	}
	public void setFrmShelterNo(String frmShelterNo) {
		this.frmShelterNo = frmShelterNo;
	}
	public String getFrmYearId() {
		return frmYearId;
	}
	public void setFrmYearId(String frmYearId) {
		this.frmYearId = frmYearId;
	}
	public List<ShelterReportTable> getFrmYearList() {
		return frmYearList;
	}
	public void setFrmYearList(List<ShelterReportTable> frmYearList) {
		this.frmYearList = frmYearList;
	}
*/
	
	//for mailing
	private String frmshelterName;
	private String frmshelterEmail;
	private String frmMailMessage;
	
	public String getFrmshelterName() {
		return frmshelterName;
	}
	public void setFrmshelterName(String frmshelterName) {
		this.frmshelterName = frmshelterName;
	}
	public String getFrmshelterEmail() {
		return frmshelterEmail;
	}
	public void setFrmshelterEmail(String frmshelterEmail) {
		this.frmshelterEmail = frmshelterEmail;
	}
	public String getFrmMailMessage() {
		return frmMailMessage;
	}
	public void setFrmMailMessage(String frmMailMessage) {
		this.frmMailMessage = frmMailMessage;
	}

	
	
}
