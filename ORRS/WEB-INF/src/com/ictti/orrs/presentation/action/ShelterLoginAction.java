package com.ictti.orrs.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.business.service.ShelterService;
import com.ictti.orrs.presentation.form.ShelterForm;


public class ShelterLoginAction extends BaseAction {
	
	ShelterService myShelterService;
	
	
	public ShelterService getMyShelterService() {
		return myShelterService;
	}


	public void setMyShelterService(ShelterService myShelterService) {
		this.myShelterService = myShelterService;
	}


	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		
		ShelterForm myform=(ShelterForm) form;
		Shelter myShelter = myShelterService.checkLoginShelter(myform);
		
		//System.out.println(myform.getShelterId());
		
		ActionErrors errors=new ActionErrors();
		if(myform.getLoginShelter()==null)
		{
			errors.add("LoginError",new ActionMessage("errors.login"));
		saveErrors(request, errors);
		return "gotoShelterLogin";
		}
		else
		{
			myform.setShelterId(myShelter.getId());
			request.getSession(true);
			request.getSession().setAttribute("id", request.getSession().getId());
			return "gotoShelterHome";
		}
	}
}
		