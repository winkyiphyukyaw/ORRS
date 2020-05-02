package com.ictti.orrs.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.ictti.orrs.business.entity.Adopter;
import com.ictti.orrs.business.service.AdopterViewService;
import com.ictti.orrs.presentation.form.AdminAdopterForm;
import com.ictti.orrs.presentation.form.AdopterForm;


public class AdminAdopterAction extends BaseAction {
	AdopterViewService myAdopterViewService;

	public AdopterViewService getMyAdopterViewService() {
		return myAdopterViewService;
	}

	public void setMyAdopterViewService(AdopterViewService myAdopterViewService) {
		this.myAdopterViewService = myAdopterViewService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
		// TODO Auto-generated method stub
		AdminAdopterForm myForm=(AdminAdopterForm) form;
		myForm.setFrmControl(null);		
		if(request.getParameter("next")!= null){
			myForm.setActualPage(myForm.getActualPage()+1);
		}
			
		if(request.getParameter("prev")!=null)
		{
			myForm.setActualPage(myForm.getActualPage()-1);		
		}
	
		/*if(l.getMailStatus()==0){
			System.out.print("null");
		}
		else{
			myForm.setMailStatus(l.getMailStatus());
		}*/
		Adopter mailStatus = myAdopterViewService.getMailStatus();
		
		
		if(request.getParameter("sendMail")!=null){
			
			
			myAdopterViewService.prepareForMail(myForm);
			myAdopterViewService.setMailStaus(myForm);
			
			return "gotoAdopterViewDetail";
		}
		
		
		if(request.getParameter("btnSearch")!=null)
		{
					
			if(myForm.getFrmAdopterSearchName().equals(""))
			{
				myAdopterViewService.getAllAdopterList(myForm);
			}
			else{				
		
				myAdopterViewService.getAllAdopterByAdopterName(myForm);
			}		
			
		
			return "gotoAdopterView";
		}
		
		
		
		
		return "gotoAdopterView" ;		
	}
		
	
	
	
	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
		AdminAdopterForm myForm=(AdminAdopterForm) form;
		myAdopterViewService.getAllAdopterList(myForm);
		
		if(myForm.getFrmControl().equals("2"))
		{ 	myForm.setFrmOrphanTotalList(null);
			myAdopterViewService.getAdopterById(myForm);
			myAdopterViewService.getAllAdopterList(myForm);
			return "gotoAdopterViewDetail";	
		}
		myForm.setFrmOrphanTotalList(null);
		myForm.setFrmControl(null);	
		myForm.setFrmAdopterSearchName(null);
		return "gotoAdopterView";
	}

}
