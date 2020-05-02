package com.ictti.orrs.presentation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.entity.Orphan;
import com.ictti.orrs.business.service.AdminViewOrphanService;
import com.ictti.orrs.presentation.form.AdminViewOrphanForm;

public class AdminViewOrphanAction extends BaseAction {

	AdminViewOrphanService myOrphanService;	
	
	

	public AdminViewOrphanService getMyOrphanService() {
		return myOrphanService;
	}

	public void setMyOrphanService(AdminViewOrphanService myOrphanService) {
		this.myOrphanService = myOrphanService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
		AdminViewOrphanForm myForm=(AdminViewOrphanForm) form;
		if(request.getParameter("next")!=null)			
			myForm.setActualPage(myForm.getActualPage()+1);
		
		if(request.getParameter("prev")!=null)
			  myForm.setActualPage(myForm.getActualPage()-1);
		
		
		//Correct 
		
		if(request.getParameter("btnHome")!=null)
		{
			return "gotoHome";
		}
		

		if(request.getParameter("btnSearch")!=null)
		{
					
			if(myForm.getAdminOrphanShelterName().equals(""))
			{
				myOrphanService.getAllOrphanList(myForm);
			}
			
			else{				
		
			    myOrphanService.getAllOrphanByShelterName(myForm);
			}	
			
		    if(myForm.getAdminOrphanList()==null)
			{
				ActionErrors error=new ActionErrors();
				error.add("noOrphanErr",new ActionMessage("errors.noOrphan"));
				saveErrors(request, error);
				return "gotoSearch";
			}
			
		
			return "gotoSearch";
		}
		
		if(request.getParameter("btnOk1")!=null)
		{
			return "gotoViewOrphanDetail";
		}
		
		if(request.getParameter("btnOk")!=null)
		{
			return "gotoViewOrphan";
		}

		
		
		
		
		return "gotoViewOrphan";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
		AdminViewOrphanForm myForm=(AdminViewOrphanForm) form;	
		
		if(myForm.getAdminViewOrphanControl().equals("1"))
		{
		myOrphanService.getAllOrphanList(myForm);
		myForm.setAdminOrphanShelterName(null);
		return "gotoViewOrphan";
		}
		
		if(myForm.getAdminViewOrphanControl().equals("2"))
		{
		
			myOrphanService.getAllOrphanById(myForm);
			
			return "gotoViewOrphanDetail";					
		}
		//Correct
		
		if(myForm.getAdminViewOrphanControl().equals("3"))
		{
			
			myOrphanService.getAllOrphanAndAdopterById(myForm);
			
			return "gotoViewAdopterDetail";					
		}
		//
		return "gotoViewOrphan";
		
		
	}
	
	
	

}
