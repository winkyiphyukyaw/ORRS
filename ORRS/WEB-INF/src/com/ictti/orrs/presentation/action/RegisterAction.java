package com.ictti.orrs.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.service.AdminLoginService;
import com.ictti.orrs.presentation.form.AdminLoginForm;

public class RegisterAction extends BaseAction {
	
	AdminLoginService myRegService;
	public AdminLoginService getMyRegService() {
		return myRegService;
	}

	public void setMyRegService(AdminLoginService myRegService) {
		this.myRegService = myRegService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		AdminLoginForm myForm=(AdminLoginForm) form;
		ActionErrors errors = new ActionErrors();
		if(isCancelled(request)){
			return "gotoLogin";
		}
		
		if(request.getParameter("btnRegister")!=null)
		{
			if(!myForm.getFrmRegPassword().equals(myForm.getFrmRegConfPassword())){
				errors.add("passwordError", new ActionMessage("errors.matchPassword"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl("");
				System.out.println("plane");
				return "gotoRegister";
			}
			else{
				myForm.setFrmRegFormControl("data");
				System.out.println("plane ma hote");
				return "gotoRegister";
			}
				
				
			
			
			
			
			
		}
		
		if(request.getParameter("btnRegisterCancel")!=null)
		{
			
			return "gotoLogin";
		}
		if(request.getParameter("btnSave")!=null)
		{
			myRegService.setRegAdmin(myForm);
			return "gotoLogin";
		}
		if(request.getParameter("btnSaveCancel")!=null)
		{
			myForm.setFrmRegFormControl("");
			return "gotoRegister";
		}
		return "gotoRegister";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		AdminLoginForm myForm=(AdminLoginForm) form;
		myForm.setFrmRegFormControl("");
		return "gotoRegister";
	}

}
