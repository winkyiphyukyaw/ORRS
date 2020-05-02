package com.ictti.orrs.presentation.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.business.service.DonorRegService;
import com.ictti.orrs.presentation.form.DonorRegForm;

public class DonorDirectRegAction extends BaseAction {
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
		Shelter isShelter=new Shelter();
		DonorRegForm myForm=(DonorRegForm) form;
		ActionErrors errors = new ActionErrors();
		if(request.getParameter("btnDonate")!=null){
			
			int i=0;
			/*isShelter=myDonorRegService.checkShelterbyShelter(myForm.getFrmShelterName());*/
			if(myForm.getFrmRegCategoryId().equals("0"))
			{
				errors.add("categoryError", new ActionMessage("errors.category"));
			   saveErrors(request, errors);
			   i++;
			}
			/*if(isShelter==null){errors.add("shelterError", new ActionMessage("errors.shelter"));
			   saveErrors(request, errors);i++;}*/
			
			
			int amount=0;
			if (i == 0) {
				System.out.println("here");
				myForm.setFrmRegFormControl("data");
				String category = myDonorRegService.getCategoryById(myForm.getFrmRegCategoryId());
				myForm.setFrmRegCategory(category);
				if (myForm.getRadioTest().equals("1")) {
					String month=myForm.getMonthlyFee();
					String[] parts = month.split("-");
					
					String month1=myForm.getMonthlyFee1();
					String[] parts1 = month1.split("-");
					int month_no=0;
					if(Integer. parseInt( parts1[0])==Integer. parseInt( parts[0]))
					{
						month_no=(Integer. parseInt( parts1[1])-Integer. parseInt( parts[1]))+1;
						
					}
					else{
						month_no=(12-Integer. parseInt( parts[1]))+Integer. parseInt( parts1[1])+1;
						
					}
					amount=Integer.parseInt(myForm.getFrmRegAmount())*month_no;
					myForm.setFrmRadioControlMonth("data");
				} else if (myForm.getRadioTest().equals("2")) {
					int year_no=(Integer. parseInt( myForm.getYearlyFee1()) -Integer. parseInt( myForm.getYearlyFee()))+1;
					amount=Integer.parseInt(myForm.getFrmRegAmount())*year_no;
					myForm.setFrmRadioControlYear("data");
				} else {
					amount = Integer.parseInt(myForm.getFrmRegAmount());
					myForm.setFrmRadioControlYear(null);
					myForm.setFrmRadioControlMonth(null);
				}
			}
			/*String checkValid = myDonorRegService.checkCreditCard(myForm.getFrmRegCreditCardType(), myForm.getFrmRegDonorCreditCard(), myForm.getFrmRegCardHolder(), myForm.getFrmRegCardExpireDate(), String.valueOf(amount));
			if(checkValid.equals("0")){
				errors.add("frmRegDonorCreditCard", new ActionMessage("errors.accountInvalid"));
				   saveErrors(request, errors);
				   myForm.setFrmRegFormControl(null);
					return "gotoDonorDirectReg";
			}
			if(checkValid.equals("2")){
				errors.add("frmRegAmount", new ActionMessage("errors.balanceNotEnough"));
				   saveErrors(request, errors);
				   myForm.setFrmRegFormControl(null);
					return "gotoDonorDirectReg";
			}
			if(checkValid.equals("9")){
				errors.add("frmRegCardHolder", new ActionMessage("errors.notEnoughParam"));
				   saveErrors(request, errors);
				   myForm.setFrmRegFormControl(null);
					return "gotoDonorDirectReg";
			}*/
			return "gotoDonorDirectReg";
		}
		if(isCancelled(request)){
			myForm.setFrmRegFormControl(null);
			return "gotoDonorDirectReg";
		}
		if (request.getParameter("btnCancel") != null) {
			
			myForm.setFrmRegFormControl(null);
			myForm.setFrmRadioControlYear(null);
			myForm.setFrmRadioControlMonth(null);
			return "gotoDonorDirectReg";
		}
		if (request.getParameter("DonorConfirm") != null) {
			
			myDonorRegService.setRegDonateFoundation(myForm);
			myForm.setFrmRegCreditCardType(null);
			myForm.setFrmRegCardHolder(null);
			myForm.setFrmRegCardExpireDate(null);
			myForm.setFrmRadioControlYear(null);
			myForm.setFrmRadioControlMonth(null);
			myForm.setRadioTest(null);
			return "gotoHome";
		}
		
		myForm.setFrmRadioControlYear(null);
		myForm.setFrmRadioControlMonth(null);
		return "gotoDonorDirectReg";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		DonorRegForm myForm=(DonorRegForm) form;
		myDonorRegService.getAllCategory(myForm);
		myDonorRegService.getlessCategory(myForm);
		myForm.setFrmRegFormControl(null);
		
		myForm.setFrmShelterName(null);
		
		myForm.setFrmRegAmount(null);
		
		myForm.setFrmRegDonorCreditCard(null);
		myForm.setFrmRegDonorEmail(null);
		myForm.setFrmRegDonorName(null);
		myForm.setFrmRegDonorNRC(null);
		myForm.setFrmRegDonorPhone(null);
		myForm.setFrmRegDonorAddress(null);
		myForm.setFrmRegDonorComment(null);
		myForm.setFrmRegKindofDonate(null);
		myForm.setYearlyFee(null);
		myForm.setMonthlyFee(null);
		
		myForm.setFrmRadioControlYear(null);
		myForm.setFrmRadioControlMonth(null);
		myForm.setRadioTest(null);
		
		myForm.setFrmRegCreditCardType(null);
		myForm.setFrmRegCardHolder(null);
		myForm.setFrmRegCardExpireDate(null);
		
		
		myForm.setRadioTest("0");
		
		
		Date d=new Date();
		SimpleDateFormat myFormat =new SimpleDateFormat("yyyy");
		String kk=myFormat.format(d);
		myForm.setYearlyFee(kk);
		
		Date dd=new Date();
		SimpleDateFormat myFormat1 =new SimpleDateFormat("yyyy-MM");
		String kkd=myFormat1.format(dd);
		myForm.setMonthlyFee(kkd);
		return "gotoDonorDirectReg";
	}

}