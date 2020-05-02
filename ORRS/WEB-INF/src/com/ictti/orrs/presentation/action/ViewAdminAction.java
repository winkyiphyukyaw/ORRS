package com.ictti.orrs.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.service.AdminViewService;
import com.ictti.orrs.presentation.form.ViewAdminForm;
import com.ictti.orrs.presentation.form.AdminForm;

public class ViewAdminAction extends BaseAction {
	AdminViewService myAdminViewService;

	

	public AdminViewService getMyAdminViewService() {
		return myAdminViewService;
	}

	public void setMyAdminViewService(AdminViewService myAdminViewService) {
		this.myAdminViewService = myAdminViewService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
		System.out.println("in admin view intit");
		ViewAdminForm myForm=(ViewAdminForm) form;
		AdminForm loginForm=(AdminForm)request.getSession().getAttribute("AdminFormBean");
		myForm.setLoginAdmin(loginForm.getLoginAdmin());
		myAdminViewService.firstLoadUpdateProfile(myForm);
		return "gotoViewAdminUpdate";
	}
		
		
	

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
		ViewAdminForm myForm=(ViewAdminForm) form;
		ActionErrors errors = new ActionErrors();
		
		
		
		if(isCancelled(request)){
			return "gotoHome";	}
		
		if(request.getParameter("btnAdminViewUpdate") != null){
			if (!myForm.getAdminPassword().equals(
					myForm.getAdminConfirmPassword())) {
				errors.add("passwordError", new ActionMessage(
						"errors.matchPassword"));
				saveErrors(request, errors);
				myForm.setAdminViewControl(null);;
				return "gotoViewAdminUpdate";
			}
			
			/*myAdminViewService.checkAdminName(myForm);
			if (myForm.getFrmAdminNameError()==null) 
			{
					System.out.println("in error");
					errors.add("adminError", new ActionMessage("errors.AdminAccount"));
					saveErrors(request, errors);
					return "gotoViewAdminUpdate";
			}
			else
			{
				myForm.setAdminViewControl("data");
			}*/
			
			
			myForm.setAdminViewControl("data");
			return "gotoViewAdminUpdate";
		}
		if(request.getParameter("btnAdminViewSaveCancel") != null){
			myForm.setAdminViewControl(null);
			return "gotoViewAdminUpdate";
		}
if (request.getParameter("btnAdminViewUpdateSave") != null) {
	myAdminViewService.saveUpdateAdmin(myForm);
			return "gotoHome";
		}
		return null;
	}

}
