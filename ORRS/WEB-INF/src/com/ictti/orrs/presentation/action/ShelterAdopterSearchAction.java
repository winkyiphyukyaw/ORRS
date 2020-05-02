package com.ictti.orrs.presentation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.ictti.orrs.business.entity.Adopter;
import com.ictti.orrs.business.service.ShelterAdopterSearchService;
import com.ictti.orrs.presentation.form.ShelterAdopterSearchForm;
import com.ictti.orrs.presentation.form.ShelterForm;
import com.ictti.orrs.presentation.form.ShelterOrphanForm;

public class ShelterAdopterSearchAction extends BaseAction {

	ShelterAdopterSearchService mySearchService;

	public ShelterAdopterSearchService getMySearchService() {
		return mySearchService;
	}

	public void setMySearchService(ShelterAdopterSearchService mySearchService) {
		this.mySearchService = mySearchService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoShelterLogin";
		}
		ShelterAdopterSearchForm myForm = (ShelterAdopterSearchForm) form;
		ShelterForm loginForm = (ShelterForm) request.getSession()
				.getAttribute("ShelterFormBean");
		myForm.setLoginShelter(loginForm.getLoginShelter());

		if (myForm.getFrmControl().equals("2")) {
			mySearchService.getAdopterById(myForm);
			return "gotoDetail";
		}
		mySearchService.getAllAdopterListByShelterId(myForm);
		// mySearchService.getAdoptedAdopterList(myForm);
		return "gotoAdopterList";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		ShelterAdopterSearchForm myForm = (ShelterAdopterSearchForm) form;
		if (request.getParameter("next") != null) {
			myForm.setActualPage(myForm.getActualPage() + 1);
		}
		if (request.getParameter("prev") != null) {
			myForm.setActualPage(myForm.getActualPage() - 1);
		}
		if (request.getParameter("next1") != null) {
			myForm.setActualPage1(myForm.getActualPage1() + 1);
		}
		if (request.getParameter("prev1") != null) {
			myForm.setActualPage1(myForm.getActualPage1() - 1);
		}
		Adopter l = mySearchService.getMailStatus();
		System.out.println(l.getMailStatus());
	if(l.getMailStatus()==null){
		System.out.println("null");
		
	}
	else{
		myForm.setMailStatus(l.getMailStatus());
	}
		if (request.getParameter("sendMail") != null) {
			
			mySearchService.Mail(myForm);
			
			mySearchService.prepareForMail(myForm);
			
			return "gotoDetail";
		}
		return "gotoAdopterList";
	}

}
