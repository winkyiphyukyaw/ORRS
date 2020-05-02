package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.Adopter;
import com.ictti.orrs.business.entity.Orphan;
import com.ictti.orrs.util.OrphanCount;

public class AdminAdopterForm extends ValidatorForm {
	private List<Adopter> frmAdopterList;
	private int begin;
	private int end;
	private int actualPage;
	private int iMaxShow;
	private int iMaxData; //total records;
	private int finalPage;
	private boolean prevBtn; //Previous Button
	private boolean nextBtn; //Next
	private String frmDetailAdopterId;
	private String frmControl;
	private Adopter AdopterViewFormBean;
	private Adopter frmAdopterDetail;
	private String frmDeleteAdopterId;
	private List<Orphan> frmOrphanDetail;
	private List<OrphanCount> frmOrphanTotalList;
	private String frmAdopterSearchName;
	
	private int mailStatus;
	
	
	
	public int getMailStatus() {
		return mailStatus;
	}
	public void setMailStatus(int mailStatus) {
		this.mailStatus = mailStatus;
	}
	public String getFrmAdopterSearchName() {
		return frmAdopterSearchName;
	}
	public void setFrmAdopterSearchName(String frmAdopterSearchName) {
		this.frmAdopterSearchName = frmAdopterSearchName;
	}
	public List<OrphanCount> getFrmOrphanTotalList() {
		return frmOrphanTotalList;
	}
	public void setFrmOrphanTotalList(List<OrphanCount> frmOrphanTotalList) {
		this.frmOrphanTotalList = frmOrphanTotalList;
	}
	public List<Orphan> getFrmOrphanDetail() {
		return frmOrphanDetail;
	}
	public void setFrmOrphanDetail(List<Orphan> frmOrphanDetail) {
		this.frmOrphanDetail = frmOrphanDetail;
	}

	private int frmOrphanNo;
	
	
	public int getFrmOrphanNo() {
		return frmOrphanNo;
	}
	public void setFrmOrphanNo(int frmOrphanNo) {
		this.frmOrphanNo = frmOrphanNo;
	}
	
	
	public String getFrmDeleteAdopterId() {
		return frmDeleteAdopterId;
	}
	public void setFrmDeleteAdopterId(String frmDeleteAdopterId) {
		this.frmDeleteAdopterId = frmDeleteAdopterId;
	}
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
	public Adopter getAdopterViewFormBean() {
		return AdopterViewFormBean;
	}
	public void setAdopterViewFormBean(Adopter adopterViewFormBean) {
		AdopterViewFormBean = adopterViewFormBean;
	}
	public Adopter getFrmAdopterDetail() {
		return frmAdopterDetail;
	}
	public void setFrmAdopterDetail(Adopter frmAdopterDetail) {
		this.frmAdopterDetail = frmAdopterDetail;
	}
	public List<Adopter> getFrmAdopterList() {
		return frmAdopterList;
	}
	public void setFrmAdopterList(List<Adopter> frmAdopterList) {
		this.frmAdopterList = frmAdopterList;
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
	public int getFinalPage() {
		finalPage=(int)Math.ceil((double)iMaxData/iMaxShow);
		return finalPage;
	}
	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
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


