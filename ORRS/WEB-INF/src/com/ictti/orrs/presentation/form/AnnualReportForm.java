package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.AllYearTable;
import com.ictti.orrs.business.entity.AnnualReportTable;

public class AnnualReportForm extends ValidatorForm {
	private String frmAnnualId;	
	private List<AnnualReportTable> frmAnnualYearList;
	private int begin;
	private int end;
	private int actualPage;
	private int iMaxShow;
	private int iMaxData; //total records;
	private int finalPage;
	private boolean prevBtn; //Previous Button
	private boolean nextBtn; //Next
	private double cost_sum;
	private double total_balance;
	private double fund_sum;
	private List<AllYearTable>frmAllYearViewList;
	
	//category 
	private String frmCategoryId;
	private List<AnnualReportTable> frmCategoryList;
	
	

	

	

	public String getFrmCategoryId() {
		return frmCategoryId;
	}

	public void setFrmCategoryId(String frmCategoryId) {
		this.frmCategoryId = frmCategoryId;
	}

	public List<AnnualReportTable> getFrmCategoryList() {
		return frmCategoryList;
	}

	public void setFrmCategoryList(List<AnnualReportTable> frmCategoryList) {
		this.frmCategoryList = frmCategoryList;
	}

	public List<AllYearTable> getFrmAllYearViewList() {
		return frmAllYearViewList;
	}

	public void setFrmAllYearViewList(List<AllYearTable> frmAllYearViewList) {
		this.frmAllYearViewList = frmAllYearViewList;
	}

	public double getCost_sum() {
		return cost_sum;
	}

	public void setCost_sum(double cost_sum) {
		this.cost_sum = cost_sum;
	}

	public double getTotal_balance() {
		return total_balance;
	}

	public void setTotal_balance(double total_balance) {
		this.total_balance = total_balance;
	}

	public double getFund_sum() {
		return fund_sum;
	}

	public void setFund_sum(double fund_sum) {
		this.fund_sum = fund_sum;
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

	private List<AnnualReportTable> frmAnnualList; //For All data
	
	public List<AnnualReportTable> getFrmAnnualList() {
		return frmAnnualList;
	}

	public void setFrmAnnualList(List<AnnualReportTable> frmAnnualList) {
		this.frmAnnualList = frmAnnualList;
	}

	private AnnualReportTable AnnualReportFormBean;

	public String getFrmAnnualId() {
		return frmAnnualId;
	}

	public void setFrmAnnualId(String frmAnnualId) {
		this.frmAnnualId = frmAnnualId;
	}

	public List<AnnualReportTable> getFrmAnnualYearList() {
		return frmAnnualYearList;
	}

	public void setFrmAnnualYearList(List<AnnualReportTable> frmAnnualYearList) {
		this.frmAnnualYearList = frmAnnualYearList;
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
		System.out.println("ImaxData is "+iMaxData+"===="+end);
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

	public AnnualReportTable getAnnualReportFormBean() {
		return AnnualReportFormBean;
	}

	public void setAnnualReportFormBean(AnnualReportTable annualReportFormBean) {
		AnnualReportFormBean = annualReportFormBean;
	}
	private String frmcontrol;

	public String getFrmcontrol() {
		return frmcontrol;
	}

	public void setFrmcontrol(String frmcontrol) {
		this.frmcontrol = frmcontrol;
	}
	
	
	
	
}