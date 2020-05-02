package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.Donor;
import com.ictti.orrs.business.entity.DonorCategory;
import com.ictti.orrs.business.entity.DonorShelter;
import com.ictti.orrs.business.entity.Shelter;


public class ShelterDonorListForm extends ActionForm {
	private List<DonorShelter> viewDonorList;
	private int begin;
	private int end;
	private int actualPage;
	private int iMaxShow;
	private int iMaxData;
	private boolean prevBtn;
	private boolean nextBtn;
	private int finalPage;
	private String detailDonorId;
	private String donorListControl;
	private List<DonorShelter> viewDonorListDetail;
	private String frmDonorName;
	public String getFrmDonorName() {
		return frmDonorName;
	}
	public void setFrmDonorName(String frmDonorName) {
		this.frmDonorName = frmDonorName;
	}
	public List<DonorShelter> getViewDonorListDetail() {
		return viewDonorListDetail;
	}
	public void setViewDonorListDetail(List<DonorShelter> viewDonorListDetail) {
		this.viewDonorListDetail = viewDonorListDetail;
	}
	private Category category;
	private DonorCategory dcategory;
	private List<Category> clist;
	private Shelter loginShelter;
	private int shelterId;
	private String donorShelterName;
	private List<Donor> viewDonorListByAjax;
	
	
	public List<Donor> getViewDonorListByAjax() {
		return viewDonorListByAjax;
	}
	public void setViewDonorListByAjax(List<Donor> viewDonorListByAjax) {
		this.viewDonorListByAjax = viewDonorListByAjax;
	}
	public String getDonorShelterName() {
		return donorShelterName;
	}
	public void setDonorShelterName(String donorShelterName) {
		this.donorShelterName = donorShelterName;
	}
	public int getShelterId() {
		return shelterId;
	}
	public void setShelterId(int shelterId) {
		this.shelterId = shelterId;
	}
	public Shelter getLoginShelter() {
		return loginShelter;
	}
	public void setLoginShelter(Shelter loginShelter) {
		this.loginShelter = loginShelter;
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
	/*public Donor getViewDonorListDetail() {
		return viewDonorListDetail;
	}
	public void setViewDonorListDetail(Donor viewDonorListDetail) {
		this.viewDonorListDetail = viewDonorListDetail;
	}*/
	
	public List<DonorShelter> getViewDonorList() {
		return viewDonorList;
	}
	public void setViewDonorList(List<DonorShelter> viewDonorList) {
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
	public String getDetailDonorId() {
		return detailDonorId;
	}
	public void setDetailDonorId(String detailDonorId) {
		this.detailDonorId = detailDonorId;
	}
	public String getDonorListControl() {
		return donorListControl;
	}
	public void setDonorListControl(String donorListControl) {
		this.donorListControl = donorListControl;
	}

}
