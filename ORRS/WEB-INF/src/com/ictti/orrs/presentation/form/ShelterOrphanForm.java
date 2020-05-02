package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.Adopter;
import com.ictti.orrs.business.entity.Orphan;
import com.ictti.orrs.business.entity.Shelter;

public class ShelterOrphanForm extends ValidatorForm {
	
	private String frmName;
	private String frmAge;
	private String frmOrphanId;
	private List<Orphan> frmAgeList;
	private List<Orphan> frmEducationList;
	private List<Orphan> frmReligionList;
	private List<Orphan> frmMedicalList;
	private String frmGenderType;
	private String frmShelterID;
	private String frmEducation;
	private String frmReligion;
	private String frmMedical;
	private String frmAdoptType;
	private Shelter loginShelter;
	private String frmFormControlInsert;
	
	public String getFrmFormControlInsert() {
		return frmFormControlInsert;
	}
	public void setFrmFormControlInsert(String frmFormControlInsert) {
		this.frmFormControlInsert = frmFormControlInsert;
	}
	public Shelter getLoginShelter() {
		return loginShelter;
	}
	public void setLoginShelter(Shelter loginShelter) {
		this.loginShelter = loginShelter;
	}
	public String getFrmShelterID() {
		return frmShelterID;
	}
	public void setFrmShelterID(String frmShelterID) {
		this.frmShelterID = frmShelterID;
	}
	public String getFrmName() {
		return frmName;
	}
	public void setFrmName(String frmName) {
		this.frmName = frmName;
	}
	public String getFrmAge() {
		return frmAge;
	}
	public void setFrmAge(String frmAge) {
		this.frmAge = frmAge;
	}
	public String getFrmOrphanId() {
		return frmOrphanId;
	}
	public void setFrmOrphanId(String frmOrphanId) {
		this.frmOrphanId = frmOrphanId;
	}	
	public List<Orphan> getFrmAgeList() {
		return frmAgeList;
	}
	public void setFrmAgeList(List<Orphan> frmAgeList) {
		this.frmAgeList = frmAgeList;
	}
	public List<Orphan> getFrmEducationList() {
		return frmEducationList;
	}
	public void setFrmEducationList(List<Orphan> frmEducationList) {
		this.frmEducationList = frmEducationList;
	}
	public List<Orphan> getFrmReligionList() {
		return frmReligionList;
	}
	public void setFrmReligionList(List<Orphan> frmReligionList) {
		this.frmReligionList = frmReligionList;
	}
	public List<Orphan> getFrmMedicalList() {
		return frmMedicalList;
	}
	public void setFrmMedicalList(List<Orphan> frmMedicalList) {
		this.frmMedicalList = frmMedicalList;
	}
	public String getFrmGenderType() {
		return frmGenderType;
	}
	public void setFrmGenderType(String frmGenderType) {
		this.frmGenderType = frmGenderType;
	}
	public String getFrmEducation() {
		return frmEducation;
	}
	public void setFrmEducation(String frmEducation) {
		this.frmEducation = frmEducation;
	}
	public String getFrmReligion() {
		return frmReligion;
	}
	public void setFrmReligion(String frmReligion) {
		this.frmReligion = frmReligion;
	}
	public String getFrmMedical() {
		return frmMedical;
	}
	public void setFrmMedical(String frmMedical) {
		this.frmMedical = frmMedical;
	}
	public String getFrmAdoptType() {
		return frmAdoptType;
	}
	public void setFrmAdoptType(String frmAdoptType) {
		this.frmAdoptType = frmAdoptType;
	}




	//For View
	private List<Orphan> frmOrphanList;
	private int begin;
	private int end;
	private int actualPage; //self create
	private int iMaxShow; //total pages for show(self create)
	private int iMaxData; // All list Data in Book(self create)
	private boolean prevBtn;
	private boolean nextBtn;
	private int finalPage; //self create
	
	public List<Orphan> getFrmOrphanList() {
		return frmOrphanList;
	}
	public void setFrmOrphanList(List<Orphan> frmOrphanList) {
		this.frmOrphanList = frmOrphanList;
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
	public boolean isNextBtn() {
		if(actualPage==getFinalPage())
			nextBtn=false;
		else nextBtn=true;
		return nextBtn;
	}
	public void setNextBtn(boolean nextBtn) {
		this.nextBtn = nextBtn;
	}
	public int getFinalPage() {
		finalPage=(int)Math.ceil((double)iMaxData/iMaxShow);
		return finalPage;
	}
	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}
	
	//For Delete
	private String frmControl;
	private String frmDeleteOrphanId;

	public String getFrmControl() {
		return frmControl;
	}
	public void setFrmControl(String frmControl) {
		this.frmControl = frmControl;
	}
	public String getFrmDeleteOrphanId() {
		return frmDeleteOrphanId;
	}
	public void setFrmDeleteOrphanId(String frmDeleteOrphanId) {
		this.frmDeleteOrphanId = frmDeleteOrphanId;
	}
	
	//For Deatail
	private Orphan frmOrphanDetail;
	private String frmDetailOrphanId;
	
	public Orphan getFrmOrphanDetail() {
		return frmOrphanDetail;
	}
	public void setFrmOrphanDetail(Orphan frmOrphanDetail) {
		this.frmOrphanDetail = frmOrphanDetail;
	}
	public String getFrmDetailOrphanId() {
		return frmDetailOrphanId;
	}
	public void setFrmDetailOrphanId(String frmDetailOrphanId) {
		this.frmDetailOrphanId = frmDetailOrphanId;
	}

	//ForUpdate
	private String frmFormControl;
	private String frmGenderName;
	private String frmAdoptStatus;
	private String frmUpdateOrphanId;
	private String frmAdopterNRC;
	/*private List<Adopter> shelterAdopterList;*/
	private Adopter shelterAdopterList;
	private String frmAdopterFormControl;
	private String frmAdopterNRCError;
	
	public String getFrmUpdateOrphanId() {
		return frmUpdateOrphanId;
	}
	public void setFrmUpdateOrphanId(String frmUpdateOrphanId) {
		this.frmUpdateOrphanId = frmUpdateOrphanId;
	}
	
	
	public String getFrmFormControl() {
		return frmFormControl;
	}
	public void setFrmFormControl(String frmFormControl) {
		this.frmFormControl = frmFormControl;
	}
	public String getFrmGenderName() {
		return frmGenderName;
	}
	public void setFrmGenderName(String frmGenderName) {
		this.frmGenderName = frmGenderName;
	}
	public String getFrmAdoptStatus() {
		return frmAdoptStatus;
	}
	public void setFrmAdoptStatus(String frmAdoptStatus) {
		this.frmAdoptStatus = frmAdoptStatus;
	}
	public String getFrmAdopterNRC() {
		return frmAdopterNRC;
	}
	public void setFrmAdopterNRC(String frmAdopterNRC) {
		this.frmAdopterNRC = frmAdopterNRC;
	}
	public Adopter getShelterAdopterList() {
		return shelterAdopterList;
	}
	public void setShelterAdopterList(Adopter shelterAdopterList) {
		this.shelterAdopterList = shelterAdopterList;
	}
	public String getFrmAdopterFormControl() {
		return frmAdopterFormControl;
	}
	public void setFrmAdopterFormControl(String frmAdopterFormControl) {
		this.frmAdopterFormControl = frmAdopterFormControl;
	}
	public String getFrmAdopterNRCError() {
		return frmAdopterNRCError;
	}
	public void setFrmAdopterNRCError(String frmAdopterNRCError) {
		this.frmAdopterNRCError = frmAdopterNRCError;
	}
	
	
	
}
