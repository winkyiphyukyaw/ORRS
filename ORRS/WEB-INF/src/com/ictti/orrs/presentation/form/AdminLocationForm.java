package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.City;
import com.ictti.orrs.business.entity.RegionState;

public class AdminLocationForm extends ValidatorForm {
	
	//For Add City
	private String frmRegionId;
	private List<RegionState> frmRegionList;
	private String frmSubcityId;
	private List<City> frmSubcityList;
	private String frmCityName;
	private String frmFormControlLocation;
	private String frmRegionStateName;
	private String frmControl;
	private String frmCityNameError;
	
	public String getFrmRegionId() {
		return frmRegionId;
	}
	public void setFrmRegionId(String frmRegionId) {
		this.frmRegionId = frmRegionId;
	}
	public List<RegionState> getFrmRegionList() {
		return frmRegionList;
	}
	public void setFrmRegionList(List<RegionState> frmRegionList) {
		this.frmRegionList = frmRegionList;
	}
	public String getFrmSubcityId() {
		return frmSubcityId;
	}
	public void setFrmSubcityId(String frmSubcityId) {
		this.frmSubcityId = frmSubcityId;
	}
	public List<City> getFrmSubcityList() {
		return frmSubcityList;
	}
	public void setFrmSubcityList(List<City> frmSubcityList) {
		this.frmSubcityList = frmSubcityList;
	}
	public String getFrmCityName() {
		return frmCityName;
	}
	public void setFrmCityName(String frmCityName) {
		this.frmCityName = frmCityName;
	}
	public String getFrmFormControlLocation() {
		return frmFormControlLocation;
	}
	public void setFrmFormControlLocation(String frmFormControlLocation) {
		this.frmFormControlLocation = frmFormControlLocation;
	}
	public String getFrmRegionStateName() {
		return frmRegionStateName;
	}
	public void setFrmRegionStateName(String frmRegionStateName) {
		this.frmRegionStateName = frmRegionStateName;
	}
	public String getFrmControl() {
		return frmControl;
	}
	public void setFrmControl(String frmControl) {
		this.frmControl = frmControl;
	}
	public String getFrmCityNameError() {
		return frmCityNameError;
	}
	public void setFrmCityNameError(String frmCityNameError) {
		this.frmCityNameError = frmCityNameError;
	}
	
	//For View
	private int begin;
	private int end;
	private int actualPage; // self create
	private int iMaxShow; // total pages for show(self create)
	private int iMaxData; // All list Data in Book(self create)
	private boolean prevBtn;
	private boolean nextBtn;
	private int finalPage; // self create
	

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
	public int getFinalPage() {
		finalPage = (int) Math.ceil((double) iMaxData / iMaxShow);
		return finalPage;
	}
	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}
	
	//For Detail
	private String frmCitybyRegionId;
	private int iMaxShowDetail;
	private int iMaxDataDetail;
	private int beginDetail;
	private int endDetail;
	private boolean prevBtnDetail;
	private boolean nextBtnDetail;
	private int finalPageDetail;
	

	public String getFrmCitybyRegionId() {
		return frmCitybyRegionId;
	}
	public void setFrmCitybyRegionId(String frmCitybyRegionId) {
		this.frmCitybyRegionId = frmCitybyRegionId;
	}
	public int getiMaxShowDetail() {
		return iMaxShowDetail;
	}
	public void setiMaxShowDetail(int iMaxShowDetail) {
		this.iMaxShowDetail = iMaxShowDetail;
	}
	public int getiMaxDataDetail() {
		return iMaxDataDetail;
	}
	public void setiMaxDataDetail(int iMaxDataDetail) {
		this.iMaxDataDetail = iMaxDataDetail;
	}
	public int getBeginDetail() {
		beginDetail = (actualPage - 1) * iMaxShowDetail + 1;
		return beginDetail;
	}
	public void setBeginDetail(int beginDetail) {
		this.beginDetail = beginDetail;
	}
	public int getEndDetail() {
		endDetail = actualPage * iMaxShowDetail;
		if (endDetail > iMaxDataDetail)
			endDetail = iMaxDataDetail;
		return endDetail;
	}
	public void setEndDetail(int endDetail) {
		this.endDetail = endDetail;
	}
	public boolean isPrevBtnDetail() {
		if (actualPage == 1)
			prevBtnDetail = false;
		else
			prevBtnDetail = true;
		return prevBtnDetail;
	}
	public void setPrevBtnDetail(boolean prevBtnDetail) {
		this.prevBtnDetail = prevBtnDetail;
	}
	public boolean isNextBtnDetail() {
		if (actualPage == getFinalPageDetail())
			nextBtnDetail = false;
		else
			nextBtnDetail = true;
		return nextBtnDetail;
	}
	public void setNextBtnDetail(boolean nextBtnDetail) {
		this.nextBtnDetail = nextBtnDetail;
	}
	public int getFinalPageDetail() {
		finalPageDetail = (int) Math.ceil((double) iMaxDataDetail / iMaxShowDetail);
		return finalPageDetail;
	}
	public void setFinalPageDetail(int finalPageDetail) {
		this.finalPageDetail = finalPageDetail;
	}

	//For Update City
	private String frmFormControl;
	private String  frmUpdateCityId;
	private String frmRegionName;

	public String getFrmFormControl() {
		return frmFormControl;
	}
	public void setFrmFormControl(String frmFormControl) {
		this.frmFormControl = frmFormControl;
	}
	public String getFrmUpdateCityId() {
		return frmUpdateCityId;
	}
	public void setFrmUpdateCityId(String frmUpdateCityId) {
		this.frmUpdateCityId = frmUpdateCityId;
	}
	public String getFrmRegionName() {
		return frmRegionName;
	}
	public void setFrmRegionName(String frmRegionName) {
		this.frmRegionName = frmRegionName;
	}
	
}
