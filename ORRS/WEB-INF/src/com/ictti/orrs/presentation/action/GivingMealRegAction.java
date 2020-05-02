package com.ictti.orrs.presentation.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.entity.DonorShelter;
import com.ictti.orrs.business.service.DonorRegService;
import com.ictti.orrs.presentation.form.DonorRegForm;
import com.ictti.orrs.util.CheckValid;

public class GivingMealRegAction extends BaseAction {
	DonorRegService myDonorRegService;

	public DonorRegService getMyDonorRegService() {
		return myDonorRegService;
	}

	public void setMyDonorRegService(DonorRegService myDonorRegService) {
		this.myDonorRegService = myDonorRegService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("Execute");
		System.out.println("Giving Meal");
		DonorRegForm myForm = (DonorRegForm) form;
		ActionErrors errors = new ActionErrors();
		
		if (isCancelled(request)) {
			if (myForm.getFrmShelterControl() == null)
				return "gotoHome";
			return "gotoShelter";
		}
		if (request.getParameter("btnSaveCancel") != null) {
			myForm.setFrmRegFormControlFood(null);
			return "gotoGivingMealReg";
		}
		if (request.getParameter("btnDonateFood") != null) {
			Calendar todayCal = Calendar.getInstance();
			todayCal.getTime();
			SimpleDateFormat myFormat = new SimpleDateFormat("yyy-mm-dd");
			SimpleDateFormat todayFormat = new SimpleDateFormat("yyy-mm-dd");
			
			String today = todayFormat.format(todayCal.getTime());
			System.out.println("Today:" + todayFormat.parse(today));
			//myFormat.format(todayCal.getTime());
			Date myDate1 = myFormat.parse(myForm.getFrmRegDonateDate());
			/*System.out.println(myForm.getFrmRegDonateDate());
			System.out.println("From HTML :"+ myDate1);*/
			if(myDate1.compareTo(todayFormat.parse(today))<0){
				System.out.println(myDate1);
				System.out.println(today);
				errors.add("DateError", new ActionMessage(
						"errors.dateError"));
				saveErrors(request, errors);
				return "gotoGivingMealReg";
			}
			List<DonorShelter> checkDate = myDonorRegService
					.checkDonateMealDate(myForm);

			if (checkDate.size() > 0) {
				
				String ss="";
				String breakfast="";
				String lunch="" ;
				String dinner="";
				for (int i = 0; i < checkDate.size(); i++) {
					
					String kindOfMealFromDB = checkDate.get(i).getKindOfMeal();
					System.out.println(kindOfMealFromDB);
					char[] charr= kindOfMealFromDB.toCharArray();
					if(charr[0] == '1'){
						breakfast="1";
					}
					if(charr[1] == '1'){
						lunch="1";
					}
					if(charr[2] == '1'){
						dinner="1";
					}
					/*
					 *
					for(int j= 0; j<charr.length; j++){
						System.out.println("array :" + charr[j]);
						
					}
					if (checkDate.get(i).getKindOfMeal().equals("111")) {
						errors.add("MealError", new ActionMessage(
								"errors.FullForThatDay"));
						saveErrors(request, errors);
						return "gotoGivingMealReg";
					}
					if (checkDate.get(i).getKindOfMeal().equals("110")) {
						errors.add("MealError", new ActionMessage(
								"errors.FullForBAndL"));
						saveErrors(request, errors);
						return "gotoGivingMealReg";
					}
					if (checkDate.get(i).getKindOfMeal().equals("101")) {
						errors.add("MealError", new ActionMessage(
								"errors.FullForBAndD"));
						saveErrors(request, errors);
						return "gotoGivingMealReg";
					}
					if (checkDate.get(i).getKindOfMeal().equals("011")) {
						errors.add("MealError", new ActionMessage(
								"errors.FullForLAndD"));
						saveErrors(request, errors);
						return "gotoGivingMealReg";
					}
					if (checkDate.get(i).getKindOfMeal().equals("100")) {
						errors.add("MealError", new ActionMessage(
								"errors.FullForB"));
						saveErrors(request, errors);
						return "gotoGivingMealReg";
					}

					if (checkDate.get(i).getKindOfMeal().equals("010")) {
						errors.add("MealError", new ActionMessage(
								"errors.FullForL"));
						saveErrors(request, errors);
						return "gotoGivingMealReg";
					}
					if (checkDate.get(i).getKindOfMeal().equals("001")) {
						errors.add("MealError", new ActionMessage(
								"errors.FullForD"));
						saveErrors(request, errors);
						return "gotoGivingMealReg";
					}
				*/}
				int aa=0;
				String bf="";
				String lu="";
				String dn="";
				if(myForm.getFrmBreakfastMeal()!=null){
				bf=myForm.getFrmBreakfastMeal();}
				else{bf="koko";}
				if(myForm.getFrmLunchMeal()!=null){
					lu=myForm.getFrmLunchMeal();}
					else{lu="koko";}
				if(myForm.getFrmDinnerMeal()!=null){
					dn=myForm.getFrmDinnerMeal();}
					else{dn="koko";}
				System.out.println(myForm.getFrmLunchMeal());
				System.out.println(myForm.getFrmDinnerMeal());
				
				if ( breakfast.equals("1")&& bf.equals("frmBreakfast")) {
					errors.add("MealError.breakfast", new ActionMessage(
							"errors.FullForB"));
					saveErrors(request, errors);
					aa++;
				}
				if ( lunch.equals("1")&& lu.equals("frmLunch")) {
					errors.add("MealError.lunch", new ActionMessage(
							"errors.FullForL"));
					saveErrors(request, errors);
					aa++;
				}
				if ( dinner.equals("1")&& dn.equals("frmDinner")) {
					errors.add("MealError.dinner", new ActionMessage(
							"errors.FullForD"));
					saveErrors(request, errors);
					aa++;
				}
				if(aa!=0)
				{
				myForm.setFrmBreakfastMeal(null);
				myForm.setFrmLunchMeal(null);
				myForm.setFrmDinnerMeal(null);
				myForm.setFrmRegAmount(null);
				return "gotoGivingMealReg";
				}
				else {
					myForm.setFrmRegFormControlFood("data");
					return "gotoGivingMealReg";
				}
			}

			// String checkValid =
			// myDonorRegService.checkCreditCard(myForm.getFrmRegCreditCardType(),
			// myForm.getFrmRegDonorCreditCard(), myForm.getFrmRegCardHolder(),
			// myForm.getFrmRegCardExpireDate(), myForm.getFrmRegAmount());
			// System.out.println(checkValid);
			/*
			 * if(checkValid.equals("0")){ errors.add("frmRegDonorCreditCard",
			 * new ActionMessage("errors.accountInvalid")); saveErrors(request,
			 * errors); myForm.setFrmRegFormControlFood(""); return
			 * "gotoGivingMealReg"; } if(checkValid.equals("2")){
			 * errors.add("frmRegAmount", new
			 * ActionMessage("errors.balanceNotEnough")); saveErrors(request,
			 * errors); myForm.setFrmRegFormControlFood(""); return
			 * "gotoGivingMealReg"; } if(checkValid.equals("9")){
			 * errors.add("frmRegCardHolder", new
			 * ActionMessage("errors.notEnoughParam")); saveErrors(request,
			 * errors); myForm.setFrmRegFormControlFood(""); return
			 * "gotoGivingMealReg"; }
			 */
			else {
				myForm.setFrmRegFormControlFood("data");
				return "gotoGivingMealReg";
			}
		}
		if (request.getParameter("btnSave") != null) {

			myDonorRegService.saveNewDonor(myForm);
			myForm.setFrmBreakfastMeal(null);
			myForm.setFrmBreakfastPrice(0);
			myForm.setFrmDinnerMeal(null);
			myForm.setFrmDinnerPrice(0);
			myForm.setFrmRegFormControlFood(null);
			myForm.setFrmLunchMeal(null);
			myForm.setFrmLunchPrice(0);
			myForm.setFrmRegDonorAddress(null);
			myForm.setFrmRegDonorComment(null);
			myForm.setFrmRegDonorCreditCard(null);
			myForm.setFrmRegDonorName(null);
			myForm.setFrmRegDonorEmail(null);
			myForm.setFrmRegAmount(null);
			myForm.setFrmRegDonorNRC(null);
			myForm.setFrmRegDonorPhone(null);
			myForm.setFrmShelterName(null);
			myForm.setFrmRegCreditCardType(null);
			myForm.setFrmRegCardHolder(null);
			myForm.setFrmRegCardExpireDate(null);
			return "gotoGivingMealReg";
		}

		return "gotoGivingMealReg";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub

		DonorRegForm myForm = (DonorRegForm) form;
		myForm.setFrmBreakfastMeal(null);
		myForm.setFrmBreakfastPrice(0);
		myForm.setFrmDinnerMeal(null);
		myForm.setFrmDinnerPrice(0);
		myForm.setFrmLunchMeal(null);
		myForm.setFrmLunchPrice(0);
		myForm.setFrmRegDonorAddress(null);
		myForm.setFrmRegDonorComment(null);
		myForm.setFrmRegDonorCreditCard(null);
		myForm.setFrmRegDonorName(null);
		myForm.setFrmRegDonorEmail(null);
		myForm.setFrmRegAmount(null);
		myForm.setFrmRegDonorNRC(null);
		myForm.setFrmRegDonorPhone(null);
		myForm.setFrmShelterName(null);
		myForm.setFrmRegFormControlFood(null);
		myForm.setFrmShelterControl(null);
		myForm.setFrmRegCreditCardType(null);
		myForm.setFrmRegCardHolder(null);
		myForm.setFrmRegCardExpireDate(null);
		return "gotoGivingMealReg";
	}
}
