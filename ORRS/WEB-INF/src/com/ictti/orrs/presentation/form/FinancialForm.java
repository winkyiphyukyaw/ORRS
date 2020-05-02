package com.ictti.orrs.presentation.form;

import java.util.Date;
import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.City;
import com.ictti.orrs.business.entity.FinancialCalculate;
import com.ictti.orrs.business.entity.RegionState;

public class FinancialForm extends ValidatorForm {
	
	private String firstDate;
	private List<Category> frmCategoryList;
	private String frmCategoryId;
	/*private double frmOutcome;*/
	private String frmOutcome;
	private String frmFinancialFormControl;
	private String frmCategoryName;
	
	
	
	public String getFrmCategoryName() {
		return frmCategoryName;
	}

	public void setFrmCategoryName(String frmCategoryName) {
		this.frmCategoryName = frmCategoryName;
	}

	public String getFrmFinancialFormControl() {
		return frmFinancialFormControl;
	}

	public void setFrmFinancialFormControl(String frmFinancialFormControl) {
		this.frmFinancialFormControl = frmFinancialFormControl;
	}

	public String getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(String firstDate) {
		this.firstDate = firstDate;
	}
	

	public List<Category> getFrmCategoryList() {
		return frmCategoryList;
	}

	public void setFrmCategoryList(List<Category> frmCategoryList) {
		this.frmCategoryList = frmCategoryList;
	}

	public String getFrmCategoryId() {
		return frmCategoryId;
	}

	public void setFrmCategoryId(String frmCategoryId) {
		this.frmCategoryId = frmCategoryId;
	}

	
		public String getFrmOutcome() {
		return frmOutcome;
	}

	public void setFrmOutcome(String frmOutcome) {
		this.frmOutcome = frmOutcome;
	}








		// For View
		private List<FinancialCalculate> frmAmountList;
		private int begin;
		private int end;
		private int actualPage; // self create
		private int iMaxShow; // total pages for show(self create)
		private int iMaxData; // All list Data in Book(self create)
		private boolean prevBtn;
		private boolean nextBtn;
		private int finalPage; // self create
		public List<FinancialCalculate> getFrmAmountList() {
			return frmAmountList;
		}

		public void setFrmAmountList(List<FinancialCalculate> frmAmountList) {
			this.frmAmountList = frmAmountList;
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
		
		
		//For Update
		private String frmFormControl;
		private String  frmUpdateFinancialProfileId;
		private String frmUpdateFormControl;
		
		public String getFrmUpdateFormControl() {
			return frmUpdateFormControl;
		}

		public void setFrmUpdateFormControl(String frmUpdateFormControl) {
			this.frmUpdateFormControl = frmUpdateFormControl;
		}

		public String getFrmUpdateFinancialProfileId() {
			return frmUpdateFinancialProfileId;
		}

		public void setFrmUpdateFinancialProfileId(String frmUpdateFinancialProfileId) {
			this.frmUpdateFinancialProfileId = frmUpdateFinancialProfileId;
		}

		public String getFrmFormControl() {
			return frmFormControl;
		}

		public void setFrmFormControl(String frmFormControl) {
			this.frmFormControl = frmFormControl;
		}
		

}
