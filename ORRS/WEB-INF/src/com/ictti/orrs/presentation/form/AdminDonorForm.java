package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.ictti.orrs.business.entity.Admin;
import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.Donor;
import com.ictti.orrs.business.entity.DonorCategory;
import com.ictti.orrs.business.entity.DonorShelter;
import com.ictti.orrs.business.entity.Shelter;

public class AdminDonorForm extends ActionForm {

	private List<DonorCategory> viewDonorList;
	private int begin;
	private int end;
	private int actualPage;
	private int iMaxShow;
	private int iMaxData;
	private boolean prevBtn;
	private boolean nextBtn;
	private int finalPage;
	private String donorNRC;
	private String donorListControl;
	private List<DonorCategory> viewDonorListDetail;
	private Category category;
	private DonorCategory dcategory;
	private List<Category> clist;
	private Admin loginAdmin;
	private String detailDonorId;
	private String frmDonorName;
	
	
	
	public List<DonorCategory> getViewDonorListDetail() {
		return viewDonorListDetail;
	}
	public void setViewDonorListDetail(List<DonorCategory> viewDonorListDetail) {
		this.viewDonorListDetail = viewDonorListDetail;
	}
	public String getDetailDonorId() {
		return detailDonorId;
	}
	public void setDetailDonorId(String detailDonorId) {
		this.detailDonorId = detailDonorId;
	}
	public String getDonorNRC() {
		return donorNRC;
	}
	public void setDonorNRC(String donorNRC) {
		this.donorNRC = donorNRC;
	}
	public Admin getLoginAdmin() {
		return loginAdmin;
	}
	public void setLoginAdmin(Admin loginAdmin) {
		this.loginAdmin = loginAdmin;
	}
	public List<Category> getClist() {
		return clist;
	}
	public void setClist(List<Category> clist) {
		this.clist = clist;
	}
	public DonorCategory getDcategory() {
		return dcategory;
	}
	public void setDcategory(DonorCategory dcategory) {
		this.dcategory = dcategory;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
	public List<DonorCategory> getViewDonorList() {
		return viewDonorList;
	}
	public void setViewDonorList(List<DonorCategory> viewDonorList) {
		this.viewDonorList = viewDonorList;
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

	public String getDonorListControl() {
		return donorListControl;
	}
	public void setDonorListControl(String donorListControl) {
		this.donorListControl = donorListControl;
	}

	private int begin1;
	private int end1;
	private int actualPage1;
	private int iMaxShow1;
	private int iMaxData1;
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
	public String getFrmDonorName() {
		return frmDonorName;
	}
	public void setFrmDonorName(String frmDonorName) {
		this.frmDonorName = frmDonorName;
	}

}
