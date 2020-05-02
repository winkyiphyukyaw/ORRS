package com.ictti.orrs.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;








import com.ictti.orrs.business.entity.Admin;
import com.ictti.orrs.business.service.AdminService;
import com.ictti.orrs.presentation.form.AdminDonorForm;
import com.ictti.orrs.presentation.form.AdminForm;



public class AdminHomeAction extends BaseAction {

@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
	HttpSession session = request.getSession(false);
	if (session.getAttribute("aid") == null) {
		return "gotoLogin";
	}
	
	

	return "gotoHome";
}

@Override
protected String doExecute(ActionForm form, HttpServletRequest request,
		HttpServletResponse response, ActionMapping mapping) throws Exception {
	// TODO Auto-generated method stub
	return null;
}

	

}
