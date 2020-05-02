package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.AnnualReportTable;
import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.business.entity.ShelterDailyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterDailyReportTable;
import com.ictti.orrs.business.entity.ShelterMonthlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterMonthlyReportTable;
import com.ictti.orrs.business.entity.ShelterYearlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterYearlyReportTable;

public class ShelterReportForm extends ValidatorForm {
	private String frmYearId;	
	private List<ShelterMonthlyReportTable> frmYearList;
	private String frmShelterNo;
	private String frmFileName;
	private Shelter loginShelter;
	private String chart;
	private List<ShelterYearlyReportTable> frmShelterCategoryReportList;
	
	private List<ShelterYearlyReportTable> frmShelterYearlyReportList;
	private List<ShelterYearlyReportAllCategoryTable> frmShelterYearlyReportAllList;

	private List<ShelterMonthlyReportTable> frmShelterMonthlyReportList;
	private List<ShelterMonthlyReportAllCategoryTable> frmShelterMonthlyReportAllList;
	
	private List<ShelterDailyReportTable> frmShelterDailyReportList;
	private List<ShelterDailyReportAllCategoryTable> frmShelterDailyReportAllList;
	
	private String frmMonthId;
	
	public String getFrmMonthId() {
		return frmMonthId;
	}
	public void setFrmMonthId(String frmMonthId) {
		this.frmMonthId = frmMonthId;
	}
	public List<ShelterMonthlyReportAllCategoryTable> getFrmShelterMonthlyReportAllList() {
		return frmShelterMonthlyReportAllList;
	}
	public void setFrmShelterMonthlyReportAllList(
			List<ShelterMonthlyReportAllCategoryTable> frmShelterMonthlyReportAllList) {
		this.frmShelterMonthlyReportAllList = frmShelterMonthlyReportAllList;
	}
	public List<ShelterDailyReportTable> getFrmShelterDailyReportList() {
		return frmShelterDailyReportList;
	}
	public void setFrmShelterDailyReportList(
			List<ShelterDailyReportTable> frmShelterDailyReportList) {
		this.frmShelterDailyReportList = frmShelterDailyReportList;
	}
	public List<ShelterDailyReportAllCategoryTable> getFrmShelterDailyReportAllList() {
		return frmShelterDailyReportAllList;
	}
	public void setFrmShelterDailyReportAllList(
			List<ShelterDailyReportAllCategoryTable> frmShelterDailyReportAllList) {
		this.frmShelterDailyReportAllList = frmShelterDailyReportAllList;
	}
	public List<ShelterYearlyReportAllCategoryTable> getFrmShelterYearlyReportAllList() {
		return frmShelterYearlyReportAllList;
	}
	public void setFrmShelterYearlyReportAllList(
			List<ShelterYearlyReportAllCategoryTable> frmShelterYearlyReportAllList) {
		this.frmShelterYearlyReportAllList = frmShelterYearlyReportAllList;
	}
	public List<ShelterYearlyReportTable> getFrmShelterCategoryReportList() {
		return frmShelterCategoryReportList;
	}
	public void setFrmShelterCategoryReportList(
			List<ShelterYearlyReportTable> frmShelterCategoryReportList) {
		this.frmShelterCategoryReportList = frmShelterCategoryReportList;
	}
	public List<ShelterYearlyReportTable> getFrmShelterYearlyReportList() {
		return frmShelterYearlyReportList;
	}
	public void setFrmShelterYearlyReportList(
			List<ShelterYearlyReportTable> frmShelterYearlyReportList) {
		this.frmShelterYearlyReportList = frmShelterYearlyReportList;
	}
	public List<ShelterMonthlyReportTable> getFrmShelterMonthlyReportList() {
		return frmShelterMonthlyReportList;
	}
	public void setFrmShelterMonthlyReportList(
			List<ShelterMonthlyReportTable> frmShelterMonthlyReportList) {
		this.frmShelterMonthlyReportList = frmShelterMonthlyReportList;
	}
	private String frmCategoryId;
	private List<Category> frmCategoryList;
	
	
	
	public String getFrmCategoryId() {
		return frmCategoryId;
	}
	public void setFrmCategoryId(String frmCategoryId) {
		this.frmCategoryId = frmCategoryId;
	}
	public List<Category> getFrmCategoryList() {
		return frmCategoryList;
	}
	public void setFrmCategoryList(List<Category> frmCategoryList) {
		this.frmCategoryList = frmCategoryList;
	}
	private int begin;
	private int end;
	private int actualPage;
	private int iMaxShow;
	private int iMaxData; //total records;
	private int finalPage;
	private boolean prevBtn; //Previous Button
	private boolean nextBtn; //Next
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
	public int getBegin() {
		begin=(actualPage-1)*iMaxShow+1;
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		
		System.out.println("ImaxData is "+iMaxData+"===="+end);
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
	
	public String getChart() {
		return chart;
	}
	public void setChart(String chart) {
		this.chart = chart;
	}
	public Shelter getLoginShelter() {
		return loginShelter;
	}
	public void setLoginShelter(Shelter loginShelter) {
		this.loginShelter = loginShelter;
	}
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
	public List<ShelterMonthlyReportTable> getFrmYearList() {
		return frmYearList;
	}
	public void setFrmYearList(List<ShelterMonthlyReportTable> frmYearList) {
		this.frmYearList = frmYearList;
	}

}