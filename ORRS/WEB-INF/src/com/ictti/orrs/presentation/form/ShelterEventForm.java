package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.EventImage;
import com.ictti.orrs.business.entity.Shelter;

public class ShelterEventForm extends ValidatorForm {
		private String eventText;
		private FormFile frmUploadFile;
		private String frmEventStoryStatus;
		private Shelter loginName;
		private Shelter shelterPassword;
		private Shelter loginShelter;
		
		private int begin;
		private int end;
		private List<EventImage> shelterEventList;
		private String[] eventViewFile;
		private EventImage eventFile;	
		private String eventFileId;
		
		
		//for btn
		
		private boolean prevBtn;
		private boolean nextBtn;
		private int actualPage;
		private int iMaxShow;
		private int iMaxData;
		private int finalPage;
		
		private String FilePath;
		private String shelterEventFormControl;
		private String frmControl;
		
		
		
		
		
		
		
		
		public String getFrmControl() {
			return frmControl;
		}
		public void setFrmControl(String frmControl) {
			this.frmControl = frmControl;
		}
		public String getShelterEventFormControl() {
			return shelterEventFormControl;
		}
		public void setShelterEventFormControl(String shelterEventFormControl) {
			this.shelterEventFormControl = shelterEventFormControl;
		}
		public String getFilePath() {
			return FilePath;
		}
		public void setFilePath(String filePath) {
			FilePath = filePath;
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
		public String getEventFileId() {
			return eventFileId;
		}
		public void setEventFileId(String eventFileId) {
			this.eventFileId = eventFileId;
		}
		
		public String[] getEventViewFile() {
			return eventViewFile;
		}
		public void setEventViewFile(String[] eventViewFile) {
			this.eventViewFile = eventViewFile;
		}
		public EventImage getEventFile() {
			return eventFile;
		}
		public void setEventFile(EventImage eventFile) {
			this.eventFile = eventFile;
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
		public List<EventImage> getShelterEventList() {
			return shelterEventList;
		}
		public void setShelterEventList(List<EventImage> shelterEventList) {
			this.shelterEventList = shelterEventList;
		}
		
		
		
		
		public Shelter getLoginName() {
			return loginName;
		}
		public void setLoginName(Shelter loginName) {
			this.loginName = loginName;
		}
		public Shelter getShelterPassword() {
			return shelterPassword;
		}
		public void setShelterPassword(Shelter shelterPassword) {
			this.shelterPassword = shelterPassword;
		}
		public Shelter getLoginShelter() {
			return loginShelter;
		}
		public void setLoginShelter(Shelter loginShelter) {
			this.loginShelter = loginShelter;
		}
		public String getEventText() {
			return eventText;
		}
		public void setEventText(String eventText) {
			this.eventText = eventText;
		}
		public FormFile getFrmUploadFile() {
			return frmUploadFile;
		}
		public void setFrmUploadFile(FormFile frmUploadFile) {
			this.frmUploadFile = frmUploadFile;
		}
		public String getFrmEventStoryStatus() {
			return frmEventStoryStatus;
		}
		public void setFrmEventStoryStatus(String frmEventStoryStatus) {
			this.frmEventStoryStatus = frmEventStoryStatus;
		}
		
}
