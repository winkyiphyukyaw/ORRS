package com.ictti.orrs.presentation.form;



import java.util.List;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.City;
import com.ictti.orrs.business.entity.RegionState;
import com.ictti.orrs.business.entity.Shelter;



public class AdopterForm extends ValidatorForm {
	private String frmRegFormControl;
	private String frmAdopterName;
	private String frmAdopterEmail;
	private String frmAdopterPhone;
	private String frmAdopterNrc;
	private String frmAdopterAddress;
	private String frmAdopterOccupation;
	private String frmAdopterIncome;
	private String frmAdopterGender;
	private String frmAdopterMaritalStatus;
	private String frmAdopterChildNo;
	
	public String getFrmAdopterMaritalStatus() {
		return frmAdopterMaritalStatus;
	}
	public void setFrmAdopterMaritalStatus(String frmAdopterMaritalStatus) {
		this.frmAdopterMaritalStatus = frmAdopterMaritalStatus;
	}
	public String getFrmAdopterChildNo() {
		return frmAdopterChildNo;
	}
	public void setFrmAdopterChildNo(String frmAdopterChildNo) {
		this.frmAdopterChildNo = frmAdopterChildNo;
	}
	//for dob
	private String frmAdopterBirthday;
	/*private String frmDay;
	private String frmMonth;
	private String frmYear;*/
	private String frmAdoptedChildNo;
	private String frmAdopterDob;
	
	
	
	public String getFrmAdoptedChildNo() {
		return frmAdoptedChildNo;
	}
	public void setFrmAdoptedChildNo(String frmAdoptedChildNo) {
		this.frmAdoptedChildNo = frmAdoptedChildNo;
	}
	public String getFrmAdopterDob() {
		return frmAdopterDob;
	}
	public void setFrmAdopterDob(String frmAdopterDob) {
		this.frmAdopterDob = frmAdopterDob;
	}
	
	
	public String getFrmAdopterBirthday() {
		return frmAdopterBirthday;
	}
	public void setFrmAdopterBirthday(String frmAdopterBirthday) {
		this.frmAdopterBirthday = frmAdopterBirthday;
	}
	public String getFrmRegFormControl() {
		return frmRegFormControl;
	}
	public void setFrmRegFormControl(String frmRegFormControl) {
		this.frmRegFormControl = frmRegFormControl;
	}

	private String frmOrphanGender;
	private FormFile frmFileUpload;
	private String frmOrphanAge;
	
	
	public String getFrmOrphanAge() {
		return frmOrphanAge;
	}
	public void setFrmOrphanAge(String frmOrphanAge) {
		this.frmOrphanAge = frmOrphanAge;
	}
	//location
	
	public String getFrmAdopterName() {
		return frmAdopterName;
	}
	public void setFrmAdopterName(String frmAdopterName) {
		this.frmAdopterName = frmAdopterName;
	}
	public String getFrmAdopterEmail() {
		return frmAdopterEmail;
	}
	public void setFrmAdopterEmail(String frmAdopterEmail) {
		this.frmAdopterEmail = frmAdopterEmail;
	}
	public String getFrmAdopterPhone() {
		return frmAdopterPhone;
	}
	public void setFrmAdopterPhone(String frmAdopterPhone) {
		this.frmAdopterPhone = frmAdopterPhone;
	}
	public String getFrmAdopterNrc() {
		return frmAdopterNrc;
	}
	public void setFrmAdopterNrc(String frmAdopterNrc) {
		this.frmAdopterNrc = frmAdopterNrc;
	}
	public String getFrmAdopterAddress() {
		return frmAdopterAddress;
	}
	public void setFrmAdopterAddress(String frmAdopterAddress) {
		this.frmAdopterAddress = frmAdopterAddress;
	}
	public String getFrmAdopterOccupation() {
		return frmAdopterOccupation;
	}
	public void setFrmAdopterOccupation(String frmAdopterOccupation) {
		this.frmAdopterOccupation = frmAdopterOccupation;
	}
	public String getFrmAdopterIncome() {
		return frmAdopterIncome;
	}
	public void setFrmAdopterIncome(String frmAdopterIncome) {
		this.frmAdopterIncome = frmAdopterIncome;
	}
	public String getFrmAdopterGender() {
		return frmAdopterGender;
	}
	public void setFrmAdopterGender(String frmAdopterGender) {
		this.frmAdopterGender = frmAdopterGender;
	}
	
	
	public String getFrmOrphanGender() {
		return frmOrphanGender;
	}
	public void setFrmOrphanGender(String frmOrphanGender) {
		this.frmOrphanGender = frmOrphanGender;
	}
	public FormFile getFrmFileUpload() {
		return frmFileUpload;
	}
	public void setFrmFileUpload(FormFile frmFileUpload) {
		this.frmFileUpload = frmFileUpload;
	}
	
	//For Shelter's Name
	
	private String frmRegionId;
	private List<RegionState> regionChoice;
	private String frmCityId;
	private List<City> frmCityList;
	private String frmShelterName;
	private String FrmShelterId;
	private List<Shelter> FrmShelterList;
	private String frmRegionName;
	private String frmCityName;
	
	
	
	public String getFrmRegionName() {
		return frmRegionName;
	}
	public void setFrmRegionName(String frmRegionName) {
		this.frmRegionName = frmRegionName;
	}
	public String getFrmCityName() {
		return frmCityName;
	}
	public void setFrmCityName(String frmCityName) {
		this.frmCityName = frmCityName;
	}
	public List<Shelter> getFrmShelterList() {
		return FrmShelterList;
	}
	public void setFrmShelterList(List<Shelter> frmShelterList) {
		FrmShelterList = frmShelterList;
	}
	public String getFrmShelterId() {
		return FrmShelterId;
	}
	public void setFrmShelterId(String frmShelterId) {
		FrmShelterId = frmShelterId;
	}
	public String getFrmShelterName() {
		return frmShelterName;
	}
	public void setFrmShelterName(String frmShelterName) {
		this.frmShelterName = frmShelterName;
	}

	public String getFrmRegionId() {
		return frmRegionId;
	}
	public void setFrmRegionId(String frmRegionId) {
		this.frmRegionId = frmRegionId;
	}
	public List<RegionState> getRegionChoice() {
		return regionChoice;
	}
	public void setRegionChoice(List<RegionState> regionChoice) {
		this.regionChoice = regionChoice;
	}
	public String getFrmCityId() {
		return frmCityId;
	}
	public void setFrmCityId(String frmCityId) {
		this.frmCityId = frmCityId;
	}
	public List<City> getFrmCityList() {
		return frmCityList;
	}
	public void setFrmCityList(List<City> frmCityList) {
		this.frmCityList = frmCityList;
	}
	
	
	
}