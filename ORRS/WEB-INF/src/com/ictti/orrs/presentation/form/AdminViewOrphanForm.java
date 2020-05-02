package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.ictti.orrs.business.entity.Adopter;
import com.ictti.orrs.business.entity.Orphan;

public class AdminViewOrphanForm extends ActionForm {
	
	private List<Orphan> adminOrphanList;
	private int begin;
	private int end;
	private boolean prevBtn;
	private boolean nextBtn;
	private int actualPage;
	private int iMaxShow;
	private int iMaxData;
	private int finalPage;
	private int adoption_status;
	
	
	public int getAdoption_status() {
		return adoption_status;
	}
	public void setAdoption_status(int adoption_status) {
		this.adoption_status = adoption_status;
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
	public List<Orphan> getAdminOrphanList() {
		return adminOrphanList;
	}
	public void setAdminOrphanList(List<Orphan> adminOrphanList) {
		this.adminOrphanList = adminOrphanList;
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
	  
	
	
	
	//For Detail
	
	
	private String adminViewOrphanDetailId;
	private String adminViewOrphanControl;
    private Orphan adminViewOrphanDetail;
    




	public Orphan getAdminViewOrphanDetail() {
		return adminViewOrphanDetail;
	}
	public void setAdminViewOrphanDetail(Orphan adminViewOrphanDetail) {
		this.adminViewOrphanDetail = adminViewOrphanDetail;
	}
	public String getAdminViewOrphanDetailId() {
		return adminViewOrphanDetailId;
	}
	public void setAdminViewOrphanDetailId(String adminViewOrphanDetailId) {
		this.adminViewOrphanDetailId = adminViewOrphanDetailId;
	}
	public String getAdminViewOrphanControl() {
		return adminViewOrphanControl;
	}
	public void setAdminViewOrphanControl(String adminViewOrphanControl) {
		this.adminViewOrphanControl = adminViewOrphanControl;
	}
	
	//For Adopter
	private Adopter adminViewAdopterDetail;
	private String adminViewAdopterDetailId;
	

	public String getAdminViewAdopterDetailId() {
		return adminViewAdopterDetailId;
	}
	public void setAdminViewAdopterDetailId(String adminViewAdopterDetailId) {
		this.adminViewAdopterDetailId = adminViewAdopterDetailId;
	}
	public Adopter getAdminViewAdopterDetail() {
		return adminViewAdopterDetail;
	}
	public void setAdminViewAdopterDetail(Adopter adminViewAdopterDetail) {
		this.adminViewAdopterDetail = adminViewAdopterDetail;
	}
	
	//Correct
	
	private String adminOrphanShelterName;
	private String adminOrphanShelterId;
	


	public String getAdminOrphanShelterId() {
		return adminOrphanShelterId;
	}
	public void setAdminOrphanShelterId(String adminOrphanShelterId) {
		this.adminOrphanShelterId = adminOrphanShelterId;
	}
	public String getAdminOrphanShelterName() {
		return adminOrphanShelterName;
	}
	public void setAdminOrphanShelterName(String adminOrphanShelterName) {
		this.adminOrphanShelterName = adminOrphanShelterName;
	}
	
	
	

}
