package com.ictti.orrs.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;



import com.ictti.orrs.business.service.ShelterService;
import com.ictti.orrs.presentation.form.ShelterForm;

public class ShelterUpdateAction extends BaseAction {
	ShelterService myShelterService;
	
	public ShelterService getMyShelterService() {
		return myShelterService;
	}

	public void setMyShelterService(ShelterService myShelterService) {
		this.myShelterService = myShelterService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
				
		ShelterForm myForm=(ShelterForm) form;
		ShelterForm loginForm=(ShelterForm)request.getSession().getAttribute("ShelterFormBean");
		myForm.setLoginShelter(loginForm.getLoginShelter());
		myShelterService.firstLoadUpdateProfile(myForm);
		System.out.println(loginForm.getShelterId());
		return "gotoUpdate";
		
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		ShelterForm myForm=(ShelterForm) form;
		ActionErrors errors = new ActionErrors();
		//System.out.println(myForm.getLoginShelter().getShelterLoginPassword());
		//myForm.setShelRegFormControl("data");
		//return "gotoUpdate";
		if(request.getParameter("btnUpdate") != null){
			if (Integer.parseInt(myForm.getShelterRegBfCost())<=0) {
				errors.add("breakfastError", new ActionMessage(
						"errors.shelterBreakfast"));
				saveErrors(request, errors);
				
			}

			if (Integer.parseInt(myForm.getShelterRegLunCost())<=0) {
				errors.add("lunchError", new ActionMessage(
						"errors.shelterLunch"));
				saveErrors(request, errors);
				
			}

			if (Integer.parseInt(myForm.getShelterRegDinCost())<=0) {
				errors.add("dinnerError", new ActionMessage(
						"errors.shelterDinner"));
				saveErrors(request, errors);
				
			}
			
			
			if (!myForm.getShelterRegPassword().equals(myForm.getShelterRegConfPassword())) {
				errors.add("passwordError", new ActionMessage(
						"errors.matchPassword"));
				saveErrors(request, errors);
				myForm.setShelRegFormControl(null);
				return "gotoUpdate";
			}		
			myForm.setShelRegFormControl("data");
			return "gotoUpdate";
		
		}
		if(isCancelled(request)){
			return "gotoHome";
		}
		
			if(request.getParameter("btnSaveCancel") != null){
				myForm.setShelRegFormControl(null);
				return "gotoUpdate";
			}
			if (request.getParameter("btnSave") != null) {
				 myShelterService.saveUpdateStudent(myForm);
				 myShelterService.prepareForUpdateConfirmMail(myForm);
				return "gotoHome";
			}
			return null;
	}
		
		
}	
	

	

	

