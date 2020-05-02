package com.ictti.orrs.presentation.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.Admin;
import com.ictti.orrs.business.entity.EventImage;
import com.ictti.orrs.business.entity.Shelter;

public class AdminEventForm extends ValidatorForm {

	private FormFile frmUploadFile;
	private String frmEventStoryStatus;
	private String eventText;

	private int begin;
	private int end;
	private List<EventImage> adminEventList;
	private ArrayList<String> eventViewFile;
	private EventImage eventFile;
	private String eventFileId;

	// for btn

	private boolean prevBtn;
	private boolean nextBtn;
	private int actualPage;
	private int iMaxShow;
	private int iMaxData;
	private int finalPage;

	private String frmEvent;
	private String frmStory;
	private String frmAll;
	
	private String btnView;
	private String btnViewCancel;
	private String frmSearchDate1;
	private String frmSearchDate2;

	private String btnConfirm;
	private String btnConfirmCancel;

	private String adminEventFormControl;
	private Admin loginAdmin;
	private String frmFormControl;
	private String frmEditEvent;
	private String frmControl;
	private String adminEditEventControl;
	private String frmEditEventImgPath;
	private String frmUploadEventImgPath;
	private String frmUploadEvent;
	private String adminEventFormControl1;
	private String frmFirstControl;
	private String filePath1;
	private String filePath2;
	
	
	

	

	

	public String getFilePath2() {
		return filePath2;
	}

	public void setFilePath2(String filePath2) {
		this.filePath2 = filePath2;
	}

	public String getFilePath1() {
		return filePath1;
	}

	public void setFilePath1(String filePath1) {
		this.filePath1 = filePath1;
	}

	public String getFrmFirstControl() {
		return frmFirstControl;
	}

	public void setFrmFirstControl(String frmFirstControl) {
		this.frmFirstControl = frmFirstControl;
	}

	public String getAdminEventFormControl1() {
		return adminEventFormControl1;
	}

	public void setAdminEventFormControl1(String adminEventFormControl1) {
		this.adminEventFormControl1 = adminEventFormControl1;
	}

	public String getFrmUploadEventImgPath() {
		return frmUploadEventImgPath;
	}

	public void setFrmUploadEventImgPath(String frmUploadEventImgPath) {
		this.frmUploadEventImgPath = frmUploadEventImgPath;
	}

	public String getFrmUploadEvent() {
		return frmUploadEvent;
	}

	public void setFrmUploadEvent(String frmUploadEvent) {
		this.frmUploadEvent = frmUploadEvent;
	}

	public String getAdminEditEventControl() {
		return adminEditEventControl;
	}

	public void setAdminEditEventControl(String adminEditEventControl) {
		this.adminEditEventControl = adminEditEventControl;
	}

	public String getFrmEditEvent() {
		return frmEditEvent;
	}

	public void setFrmEditEvent(String frmEditEvent) {
		this.frmEditEvent = frmEditEvent;
	}

	public String getFrmControl() {
		return frmControl;
	}

	public void setFrmControl(String frmControl) {
		this.frmControl = frmControl;
	}

	public String getFrmFormControl() {
		return frmFormControl;
	}

	public void setFrmFormControl(String frmFormControl) {
		this.frmFormControl = frmFormControl;
	}

	

	public String getEventText() {
		return eventText;
	}

	public void setEventText(String eventText) {
		this.eventText = eventText;
	}

	public Admin getLoginAdmin() {
		return loginAdmin;
	}

	public void setLoginAdmin(Admin loginAdmin) {
		this.loginAdmin = loginAdmin;
	}

	public String getAdminEventFormControl() {
		return adminEventFormControl;
	}

	public void setAdminEventFormControl(String adminEventFormControl) {
		this.adminEventFormControl = adminEventFormControl;
	}

	public String getBtnConfirm() {
		return btnConfirm;
	}

	public void setBtnConfirm(String btnConfirm) {
		this.btnConfirm = btnConfirm;
	}

	public String getBtnConfirmCancel() {
		return btnConfirmCancel;
	}

	public void setBtnConfirmCancel(String btnConfirmCancel) {
		this.btnConfirmCancel = btnConfirmCancel;
	}

	public String getFrmSearchDate1() {
		return frmSearchDate1;
	}

	public void setFrmSearchDate1(String frmSearchDate1) {
		this.frmSearchDate1 = frmSearchDate1;
	}

	public String getFrmSearchDate2() {
		return frmSearchDate2;
	}

	public void setFrmSearchDate2(String frmSearchDate2) {
		this.frmSearchDate2 = frmSearchDate2;
	}

	public String getBtnView() {
		return btnView;
	}

	public void setBtnView(String btnView) {
		this.btnView = btnView;
	}

	public String getBtnViewCancel() {
		return btnViewCancel;
	}

	public void setBtnViewCancel(String btnViewCancel) {
		this.btnViewCancel = btnViewCancel;
	}

	public String getFrmEvent() {
		return frmEvent;
	}

	public void setFrmEvent(String frmEvent) {
		this.frmEvent = frmEvent;
	}

	public String getFrmStory() {
		return frmStory;
	}

	public void setFrmStory(String frmStory) {
		this.frmStory = frmStory;
	}
	

	public String getFrmAll() {
		return frmAll;
	}

	public void setFrmAll(String frmAll) {
		this.frmAll = frmAll;
	}

	public boolean isPrevBtn() {
		if (actualPage == 1)
			prevBtn = false;
		else
			prevBtn = true;
		return prevBtn;
	}

	public void setPrevBtn(boolean prevBtn) {
		this.prevBtn = prevBtn;
	}

	public boolean isNextBtn() {
		if (actualPage == getFinalPage())
			nextBtn = false;
		else
			nextBtn = true;

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
		finalPage = (int) Math.ceil((double) iMaxData / iMaxShow);
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

	

	public EventImage getEventFile() {
		return eventFile;
	}

	public void setEventFile(EventImage eventFile) {
		this.eventFile = eventFile;
	}

	public int getBegin() {
		begin = (actualPage - 1) * iMaxShow + 1;
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		end = actualPage * iMaxShow;
		if (end > iMaxData)
			end = iMaxData;
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public List<EventImage> getAdminEventList() {
		return adminEventList;
	}

	public void setAdminEventList(List<EventImage> adminEventList) {
		this.adminEventList = adminEventList;
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

	public String getFrmEditEventImgPath() {
		return frmEditEventImgPath;
	}

	public void setFrmEditEventImgPath(String frmEditEventImgPath) {
		this.frmEditEventImgPath = frmEditEventImgPath;
	}

	public ArrayList<String> getEventViewFile() {
		return eventViewFile;
	}

	public void setEventViewFile(ArrayList<String> eventViewFile) {
		this.eventViewFile = eventViewFile;
	}
	
}
