package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.orrs.business.entity.City;
import com.ictti.orrs.business.entity.RegionState;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.business.entity.Category;

public class DonorRegForm extends ValidatorForm {
	private String frmRegDonorName;
	public String getFrmRegDonorName() {
		return frmRegDonorName;
	}
	public void setFrmRegDonorName(String frmRegDonorName) {
		this.frmRegDonorName = frmRegDonorName;
	}

	private String frmRegAmount;
	private String frmRegDonorNRC;
	private String frmRegDonorCreditCard;
	private String frmRegDonorAddress;


	private String frmRegDonorPhone;
	private String frmRegDonorEmail;
	private String frmRegDonorComment;
	private String frmRegKindofDonate;
	private String frmRegNoofDonate;
	
	public String getFrmRegAmount() {
		return frmRegAmount;
	}
	public void setFrmRegAmount(String frmRegAmount) {
		this.frmRegAmount = frmRegAmount;
	}
	public String getFrmRegDonorNRC() {
		return frmRegDonorNRC;
	}
	public void setFrmRegDonorNRC(String frmRegDonorNRC) {
		this.frmRegDonorNRC = frmRegDonorNRC;
	}
	public String getFrmRegDonorCreditCard() {
		return frmRegDonorCreditCard;
	}
	public void setFrmRegDonorCreditCard(String frmRegDonorCreditCard) {
		this.frmRegDonorCreditCard = frmRegDonorCreditCard;
	}
	public String getFrmRegDonorAddress() {
		return frmRegDonorAddress;
	}
	public void setFrmRegDonorAddress(String frmRegDonorAddress) {
		this.frmRegDonorAddress = frmRegDonorAddress;
	}
	public String getFrmRegDonorPhone() {
		return frmRegDonorPhone;
	}
	public void setFrmRegDonorPhone(String frmRegDonorPhone) {
		this.frmRegDonorPhone = frmRegDonorPhone;
	}
	public String getFrmRegDonorEmail() {
		return frmRegDonorEmail;
	}
	public void setFrmRegDonorEmail(String frmRegDonorEmail) {
		this.frmRegDonorEmail = frmRegDonorEmail;
	}
	public String getFrmRegDonorComment() {
		return frmRegDonorComment;
	}
	public void setFrmRegDonorComment(String frmRegDonorComment) {
		this.frmRegDonorComment = frmRegDonorComment;
	}
	public String getFrmRegKindofDonate() {
		return frmRegKindofDonate;
	}
	public void setFrmRegKindofDonate(String frmRegKindofDonate) {
		this.frmRegKindofDonate = frmRegKindofDonate;
	}
	public String getFrmRegNoofDonate() {
		return frmRegNoofDonate;
	}
	public void setFrmRegNoofDonate(String frmRegNoofDonate) {
		this.frmRegNoofDonate = frmRegNoofDonate;
	}
	
	private String frmShelterName;
	public String getFrmShelterName() {
		return frmShelterName;
	}
	public void setFrmShelterName(String frmShelterName) {
		this.frmShelterName = frmShelterName;
	}
	
	
	
	
	
	private String frmRegFormControl;
	public String getFrmRegFormControl() {
		return frmRegFormControl;
	}
	public void setFrmRegFormControl(String frmRegFormControl) {
		this.frmRegFormControl = frmRegFormControl;
	}
	
	
	
	
//for category list
private String frmRegCategoryId;
private List<Category> frmRegCategoryList;
public String getFrmRegCategoryId() {
	return frmRegCategoryId;
}
public void setFrmRegCategoryId(String frmRegCategoryId) {
	this.frmRegCategoryId = frmRegCategoryId;
}
public List<Category> getFrmRegCategoryList() {
	return frmRegCategoryList;
}
public void setFrmRegCategoryList(List<Category> frmRegCategoryList) {
	this.frmRegCategoryList = frmRegCategoryList;
}


private String monthlyFee;
private String yearlyFee;
public String getMonthlyFee() {
	return monthlyFee;
}
public void setMonthlyFee(String monthlyFee) {
	this.monthlyFee = monthlyFee;
}
public String getYearlyFee() {
	return yearlyFee;
}
public void setYearlyFee(String yearlyFee) {
	this.yearlyFee = yearlyFee;
}

private String radioTest;
public String getRadioTest() {
	return radioTest;
}
public void setRadioTest(String radioTest) {
	this.radioTest = radioTest;
}

private String frmRadioControlMonth;
private String frmRadioControlYear;
public String getFrmRadioControlYear() {
	return frmRadioControlYear;
}
public void setFrmRadioControlYear(String frmRadioControlYear) {
	this.frmRadioControlYear = frmRadioControlYear;
}
public String getFrmRadioControlMonth() {
	return frmRadioControlMonth;
}
public void setFrmRadioControlMonth(String frmRadioControlMonth) {
	this.frmRadioControlMonth = frmRadioControlMonth;
}





/*Shelter*/
private String frmRegionId;
private List<RegionState> regionChoice;
private String frmCityId;
private List<City> frmCityList;


/*private String frmShelterName;
public String getFrmShelterName() {
	return frmShelterName;
}
public void setFrmShelterName(String frmShelterName) {
	this.frmShelterName = f rmShelterName;
}*/

private String frmShelterId;
private List<Shelter> frmShelterList;


private List<Shelter> frmShelterList1;
private int begin;
private int end;
private int actualPage;
private int iMaxShow;
private int iMaxData;//Total Records @ service
private boolean prevBtn;
private boolean nextBtn;
private int finalPage;

private String frmDetailShelterId;
private String frmControl;
private Shelter shelterDetail;

public Shelter getShelterDetail() {
	return shelterDetail;
}
public void setShelterDetail(Shelter shelterDetail) {
	this.shelterDetail = shelterDetail;
}
public List<Shelter> getFrmShelterList1() {
	return frmShelterList1;
}
public void setFrmShelterList1(List<Shelter> frmShelterList1) {
	this.frmShelterList1 = frmShelterList1;
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
public String getFrmDetailShelterId() {
	return frmDetailShelterId;
}
public void setFrmDetailShelterId(String frmDetailShelterId) {
	this.frmDetailShelterId = frmDetailShelterId;
}
public String getFrmControl() {
	return frmControl;
}
public void setFrmControl(String frmControl) {
	this.frmControl = frmControl;
}
public String getFrmShelterId() {
	return frmShelterId;
}
public void setFrmShelterId(String frmShelterId) {
	this.frmShelterId = frmShelterId;
}
public List<Shelter> getFrmShelterList() {
	return frmShelterList;
}
public void setFrmShelterList(List<Shelter> frmShelterList) {
	this.frmShelterList = frmShelterList;
}
public String getFrmRegionId() {
	return frmRegionId;
}
public void setFrmRegionId(String frmRegionId) {
	this.frmRegionId = frmRegionId;
}
public List<RegionState> getRegionChoice() {
	return regionChoice;
}
public void setRegionChoice(List<RegionState> regionChoice) {
	this.regionChoice = regionChoice;
}
public String getFrmCityId() {
	return frmCityId;
}
public void setFrmCityId(String frmCityId) {
	this.frmCityId = frmCityId;
}
public List<City> getFrmCityList() {
	return frmCityList;
}
public void setFrmCityList(List<City> frmCityList) {
	this.frmCityList = frmCityList;
}

//to retrieve breakfastPrice, lunchPrice, dinnerPrice
private int frmBreakfastPrice;


public String getFrmBreakfastMeal() {
	return frmBreakfastMeal;
}
public void setFrmBreakfastMeal(String frmBreakfastMeal) {
	this.frmBreakfastMeal = frmBreakfastMeal;
}
public String getFrmLunchMeal() {
	return frmLunchMeal;
}
public void setFrmLunchMeal(String frmLunchMeal) {
	this.frmLunchMeal = frmLunchMeal;
}
public String getFrmDinnerMeal() {
	return frmDinnerMeal;
}
public void setFrmDinnerMeal(String frmDinnerMeal) {
	this.frmDinnerMeal = frmDinnerMeal;
}

private int frmLunchPrice;
private int frmDinnerPrice;
private String frmBreakfastMeal;
private String frmLunchMeal;
private String frmDinnerMeal;
private String frmRegFormControlFood;
public String getFrmRegFormControlFood() {
	return frmRegFormControlFood;
}
public void setFrmRegFormControlFood(String frmRegFormControlFood) {
	this.frmRegFormControlFood = frmRegFormControlFood;
}

public int getFrmLunchPrice() {
	return frmLunchPrice;
}
public void setFrmLunchPrice(int frmLunchPrice) {
	this.frmLunchPrice = frmLunchPrice;
}
public int getFrmDinnerPrice() {
	return frmDinnerPrice;
}
public void setFrmDinnerPrice(int frmDinnerPrice) {
	this.frmDinnerPrice = frmDinnerPrice;
}
public void setFrmBreakfastPrice(int frmBreakfastPrice) {
	this.frmBreakfastPrice = frmBreakfastPrice;
}
public int getFrmBreakfastPrice() {
	return frmBreakfastPrice;
}
//for shelter control
private String frmShelterControl;

public String getFrmShelterControl() {
	return frmShelterControl;
}
public void setFrmShelterControl(String frmShelterControl) {
	this.frmShelterControl = frmShelterControl;
}
//for credit card validation
public String frmRegCreditCardType;
public String frmRegCardHolder;
public String frmRegCardExpireDate;

public String getFrmRegCreditCardType() {
	return frmRegCreditCardType;
}
public void setFrmRegCreditCardType(String frmRegCreditCardType) {
	this.frmRegCreditCardType = frmRegCreditCardType;
}
public String getFrmRegCardHolder() {
	return frmRegCardHolder;
}
public void setFrmRegCardHolder(String frmRegCardHolder) {
	this.frmRegCardHolder = frmRegCardHolder;
}
public String getFrmRegCardExpireDate() {
	return frmRegCardExpireDate;
}
public void setFrmRegCardExpireDate(String frmRegCardExpireDate) {
	this.frmRegCardExpireDate = frmRegCardExpireDate;
}
private String lastamount;
private String lastcategory;
public String getLastamount() {
	return lastamount;
}
public void setLastamount(String lastamount) {
	this.lastamount = lastamount;
}
public String getLastcategory() {
	return lastcategory;
}
public void setLastcategory(String lastcategory) {
	this.lastcategory = lastcategory;
}
private String frmRegCategory;
public String getFrmRegCategory() {
	return frmRegCategory;
}
public void setFrmRegCategory(String frmRegCategory) {
	this.frmRegCategory = frmRegCategory;
}

private String frmRegDonateDate;
public String getFrmRegDonateDate() {
	return frmRegDonateDate;
}
public void setFrmRegDonateDate(String frmRegDonateDate) {
	this.frmRegDonateDate = frmRegDonateDate;
}




private String yearlyFee1;
private String monthlyFee1;
public String getYearlyFee1() {
	return yearlyFee1;
}
public void setYearlyFee1(String yearlyFee1) {
	this.yearlyFee1 = yearlyFee1;
}
public String getMonthlyFee1() {
	return monthlyFee1;
}
public void setMonthlyFee1(String monthlyFee1) {
	this.monthlyFee1 = monthlyFee1;
}

}
