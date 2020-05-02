package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.Adopter;
import com.ictti.orrs.business.entity.Orphan;
import com.ictti.orrs.business.entity.Shelter;



public class ShelterAdopterSearchForm extends ValidatorForm {
	private List<Adopter> frmAdopterList;
	private int begin;
	private int end;
	private int actualPage;
	private int iMaxShow;//total page
	private int iMaxData;//total records length
	private boolean prevBtn;
	private boolean nextBtn;
	private int finalPage;
	private Orphan frmOrphanDetail;
	private Shelter loginShelter;
	private List<Orphan> frmOrphanList;
	private int mailStatus;
	
	

	public int getMailStatus() {
		return mailStatus;
	}
	public void setMailStatus(int mailStatus) {
		this.mailStatus = mailStatus;
	}
	public List<Orphan> getFrmOrphanList() {
		return frmOrphanList;
	}
	public void setFrmOrphanList(List<Orphan> frmOrphanList) {
		this.frmOrphanList = frmOrphanList;
	}
	public Shelter getLoginShelter() {
		return loginShelter;
	}
	public void setLoginShelter(Shelter loginShelter) {
		this.loginShelter = loginShelter;
	}
	public Orphan getFrmOrphanDetail() {
		return frmOrphanDetail;
	}
	public void setFrmOrphanDetail(Orphan frmOrphanDetail) {
		this.frmOrphanDetail = frmOrphanDetail;
	}
	public int getFinalPage() {
		finalPage=(int)Math.ceil((double)iMaxData/iMaxShow);
		return finalPage;
	}
	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
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
	
	//For Detail link
	private String frmDetailAdopterId;
	private String frmControl;
	private Adopter frmAdopterDetail;
	
	public String getFrmDetailAdopterId() {
		return frmDetailAdopterId;
	}
	public void setFrmDetailAdopterId(String frmDetailAdopterId) {
		this.frmDetailAdopterId = frmDetailAdopterId;
	}
	public String getFrmControl() {
		return frmControl;
	}
	public void setFrmControl(String frmControl) {
		this.frmControl = frmControl;
	}
	
	public List<Adopter> getFrmAdopterList() {
		return frmAdopterList;
	}
	public void setFrmAdopterList(List<Adopter> frmAdopterList) {
		this.frmAdopterList = frmAdopterList;
	}
	public Adopter getFrmAdopterDetail() {
		return frmAdopterDetail;
	}
	public void setFrmAdopterDetail(Adopter frmAdopterDetail) {
		this.frmAdopterDetail = frmAdopterDetail;
	}
	private List<Adopter> frmAdoptedAdopterList;
	public List<Adopter> getFrmAdoptedAdopterList() {
		return frmAdoptedAdopterList;
	}
	public void setFrmAdoptedAdopterList(List<Adopter> frmAdoptedAdopterList) {
		this.frmAdoptedAdopterList = frmAdoptedAdopterList;
	}
	private int begin1;
	private int end1;
	private int actualPage1;
	private int iMaxShow1;//total page
	private int iMaxData1;//total records length
	private boolean prevBtn1;
	private boolean nextBtn1;
	private int finalPage1;
	public int getBegin1() {
		begin1=(actualPage1-1)*iMaxShow1+1;
		return begin1;
	}
	public void setBegin1(int begin1) {
		this.begin1 = begin1;
	}
	public int getEnd1() {
		end1=actualPage1*iMaxShow1; 
		if(end1>iMaxData1)
		end1=iMaxData1;
		return end1;
	}
	public void setEnd1(int end1) {
		this.end1 = end1;
	}
	public int getActualPage1() {
		return actualPage1;
	}
	public void setActualPage1(int actualPage1) {
		this.actualPage1 = actualPage1;
	}
	public int getiMaxShow1() {
		return iMaxShow1;
	}
	public void setiMaxShow1(int iMaxShow1) {
		this.iMaxShow1 = iMaxShow1;
	}
	public int getiMaxData1() {
		return iMaxData1;
	}
	public void setiMaxData1(int iMaxData1) {
		this.iMaxData1 = iMaxData1;
	}
	public boolean isPrevBtn1() {
		if(actualPage1==1)
			prevBtn1=false;
			else 
			prevBtn1=true;
		return prevBtn1;
	}
	public void setPrevBtn1(boolean prevBtn1) {
		this.prevBtn1 = prevBtn1;
	}
	public boolean isNextBtn1() {
		if(actualPage1==getFinalPage1())
			nextBtn1=false;
		else nextBtn1=true;
		return nextBtn1;
	}
	public void setNextBtn1(boolean nextBtn1) {
		this.nextBtn1 = nextBtn1;
	}
	public int getFinalPage1() {
		finalPage1=(int)Math.ceil((double)iMaxData1/iMaxShow1);
		return finalPage1;
	}
	public void setFinalPage1(int finalPage1) {
		this.finalPage1 = finalPage1;
	}
	
	//For mail
	private String frmAdopterName;
	private String frmAdopterEmail;
	private String frmMailMessage;

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
	public String getFrmMailMessage() {
		return frmMailMessage;
	}
	public void setFrmMailMessage(String frmMailMessage) {
		this.frmMailMessage = frmMailMessage;
	}
}
