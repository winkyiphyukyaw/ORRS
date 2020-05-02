package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.Category;

public class AddCategoryForm extends ValidatorForm {
	private String categoryName;
	
	private String categoryType;
	
	private int begin;
	private int end;
	private int actualPage;
	private int iMaxShow;
	private int iMaxData;
	private boolean prevBtn;
	private boolean nextBtn;
	private int finalPage;
	private List<Category> addCategoryList;
	private int categoryId;
	private String categoryList;
	private Category loginCategory;
	private String frmCategoryNameError;
	
	public String getFrmCategoryNameError() {
		return frmCategoryNameError;
	}

	public void setFrmCategoryNameError(String frmCategoryNameError) {
		this.frmCategoryNameError = frmCategoryNameError;
	}

	private String updateCategoryControl;
	public String getUpdateCategoryControl() {
		return updateCategoryControl;
	}

	public void setUpdateCategoryControl(String updateCategoryControl) {
		this.updateCategoryControl = updateCategoryControl;
	}

	public String getUpdateCatId() {
		return updateCatId;
	}

	public void setUpdateCatId(String updateCatId) {
		this.updateCatId = updateCatId;
	}

	private String updateCatId;

	

	public Category getLoginCategory() {
		return loginCategory;
	}

	public void setLoginCategory(Category loginCategory) {
		this.loginCategory = loginCategory;
	}

	public String getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(String categoryList) {
		this.categoryList = categoryList;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public List<Category> getAddCategoryList() {
		return addCategoryList;
	}

	public void setAddCategoryList(List<Category> addCategoryList) {
		this.addCategoryList = addCategoryList;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
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

	public void setNextBtn(boolean nextBtn) {
		this.nextBtn = nextBtn;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

}
