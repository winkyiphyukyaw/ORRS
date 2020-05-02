package com.ictti.orrs.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;




import com.ictti.orrs.business.entity.Admin;
import com.ictti.orrs.business.service.AdminService;
import com.ictti.orrs.presentation.form.AdminForm;



public class AdminLoginAction extends BaseAction {

AdminService myAdminService;
	public AdminService getMyAdminService() {
	return myAdminService;
}
public void setMyAdminService(AdminService myAdminService) {
	this.myAdminService = myAdminService;
}
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		AdminForm myForm=(AdminForm) form;
		Admin myAdmin = myAdminService.checkLoginAdmin(myForm);
		
		ActionErrors errors=new ActionErrors();
		if(myForm.getLoginAdmin()==null){
			errors.add("loginerror",new ActionMessage("errors.login"));
			saveErrors(request, errors);
			return "gotoLogin";
		}
		else
		{
			myForm.setAdminId(myAdmin.getId());
			request.getSession(true);
			request.getSession().setAttribute("aid", request.getSession().getId());
			return "gotoHome";
		}
		
	}

}
