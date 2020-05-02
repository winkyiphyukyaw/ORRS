package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.ictti.orrs.business.entity.AdminDailyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminDailyReportTable;
import com.ictti.orrs.business.entity.AdminMonthlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminMonthlyReportTable;
import com.ictti.orrs.business.entity.AdminYearlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminYearlyReportTable;
import com.ictti.orrs.business.entity.Category;

public class AdminReportForm extends ActionForm {
	private String frmCategoryId;
	private List<Category> frmCategoryList ;
	private String chart;
	private String frmYearId;
	private List<AdminYearlyReportTable> frmYearList;
	
	private String frmMonthId;
	private List<AdminDailyReportTable> frmMonthList;
	
	public String getFrmMonthId() {
		return frmMonthId;
	}
	public void setFrmMonthId(String frmMonthId) {
		this.frmMonthId = frmMonthId;
	}
	public List<AdminDailyReportTable> getFrmMonthList() {
		return frmMonthList;
	}
	public void setFrmMonthList(List<AdminDailyReportTable> frmMonthList) {
		this.frmMonthList = frmMonthList;
	}
	private String frmFileName;
	private String frmAdminCategoryFileName;

	private String frmAdminDailyFileName;
	private String frmAdminMonthlyFileName;
	private String frmAdminYearlyFileName;
	


	public String getFrmAdminCategoryFileName() {
		return frmAdminCategoryFileName;
	}
	public void setFrmAdminCategoryFileName(String frmAdminCategoryFileName) {
		this.frmAdminCategoryFileName = frmAdminCategoryFileName;
	}
	public String getFrmAdminDailyFileName() {
		return frmAdminDailyFileName;
	}
	public void setFrmAdminDailyFileName(String frmAdminDailyFileName) {
		this.frmAdminDailyFileName = frmAdminDailyFileName;
	}
	public String getFrmAdminMonthlyFileName() {
		return frmAdminMonthlyFileName;
	}
	public void setFrmAdminMonthlyFileName(String frmAdminMonthlyFileName) {
		this.frmAdminMonthlyFileName = frmAdminMonthlyFileName;
	}
	public String getFrmAdminYearlyFileName() {
		return frmAdminYearlyFileName;
	}
	public void setFrmAdminYearlyFileName(String frmAdminYearlyFileName) {
		this.frmAdminYearlyFileName = frmAdminYearlyFileName;
	}
	private List<AdminYearlyReportTable> frmAdminCategoryReportList;
	
	public List<AdminYearlyReportTable> getFrmAdminCategoryReportList() {
		return frmAdminCategoryReportList;
	}
	public void setFrmAdminCategoryReportList(
			List<AdminYearlyReportTable> frmAdminCategoryReportList) {
		this.frmAdminCategoryReportList = frmAdminCategoryReportList;
	}
	private List<AdminYearlyReportTable> frmAdminYearlyReportList;
	private List<AdminMonthlyReportTable> frmAdminMonthlyReportList;
	
	private List<AdminYearlyReportAllCategoryTable> frmAdminYearlyReportAllList;
	private List<AdminMonthlyReportAllCategoryTable> frmAdminMonthlyReportAllList;

	private List<AdminDailyReportTable> frmAdminDailyReportList;
	private List<AdminDailyReportAllCategoryTable> frmAdminDailyReportAllList;
	

	public List<AdminDailyReportTable> getFrmAdminDailyReportList() {
		return frmAdminDailyReportList;
	}
	public void setFrmAdminDailyReportList(
			List<AdminDailyReportTable> frmAdminDailyReportList) {
		this.frmAdminDailyReportList = frmAdminDailyReportList;
	}
	public List<AdminDailyReportAllCategoryTable> getFrmAdminDailyReportAllList() {
		return frmAdminDailyReportAllList;
	}
	public void setFrmAdminDailyReportAllList(
			List<AdminDailyReportAllCategoryTable> frmAdminDailyReportAllList) {
		this.frmAdminDailyReportAllList = frmAdminDailyReportAllList;
	}
	public List<AdminMonthlyReportAllCategoryTable> getFrmAdminMonthlyReportAllList() {
		return frmAdminMonthlyReportAllList;
	}
	public void setFrmAdminMonthlyReportAllList(
			List<AdminMonthlyReportAllCategoryTable> frmAdminMonthlyReportAllList) {
		this.frmAdminMonthlyReportAllList = frmAdminMonthlyReportAllList;
	}
	public List<AdminYearlyReportAllCategoryTable> getFrmAdminYearlyReportAllList() {
		return frmAdminYearlyReportAllList;
	}
	public void setFrmAdminYearlyReportAllList(
			List<AdminYearlyReportAllCategoryTable> frmAdminYearlyReportAllList) {
		this.frmAdminYearlyReportAllList = frmAdminYearlyReportAllList;
	}
	public List<AdminMonthlyReportTable> getFrmAdminMonthlyReportList() {
		return frmAdminMonthlyReportList;
	}
	public void setFrmAdminMonthlyReportList(
			List<AdminMonthlyReportTable> frmAdminMonthlyReportList) {
		this.frmAdminMonthlyReportList = frmAdminMonthlyReportList;
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
	
	public List<AdminYearlyReportTable> getFrmAdminYearlyReportList() {
		return frmAdminYearlyReportList;
	}
	public void setFrmAdminYearlyReportList(
			List<AdminYearlyReportTable> frmAdminYearlyReportList) {
		this.frmAdminYearlyReportList = frmAdminYearlyReportList;
	}
	public String getFrmFileName() {
		return frmFileName;
	}
	public void setFrmFileName(String frmFileName) {
		this.frmFileName = frmFileName;
	}
	public String getFrmYearId() {
		return frmYearId;
	}
	public void setFrmYearId(String frmYearId) {
		this.frmYearId = frmYearId;
	}
	public List<AdminYearlyReportTable> getFrmYearList() {
		return frmYearList;
	}
	public void setFrmYearList(List<AdminYearlyReportTable> frmYearList) {
		this.frmYearList = frmYearList;
	}
	public String getChart() {
		return chart;
	}
	public void setChart(String chart) {
		this.chart = chart;
	}
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
	
	
}
