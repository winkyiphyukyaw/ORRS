package com.ictti.orrs.presentation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.ictti.orrs.business.entity.DonorCategory;
import com.ictti.orrs.business.service.AdminDonorService;
import com.ictti.orrs.presentation.form.AdminDonorForm;
import com.ictti.orrs.presentation.form.AdminForm;
import com.ictti.orrs.presentation.form.ShelterDonorListForm;
import com.ictti.orrs.presentation.form.ShelterForm;

public class AdminDonorAction extends BaseAction {
	AdminDonorService myAdminDonorService;
	public AdminDonorService getMyAdminDonorService() {
		return myAdminDonorService;
	}

	public void setMyAdminDonorService(AdminDonorService myAdminDonorService) {
		this.myAdminDonorService = myAdminDonorService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
		AdminDonorForm myForm = (AdminDonorForm) form;
		AdminForm loginForm = (AdminForm) request.getSession()
				.getAttribute("AdminFormBean");
		myForm.setLoginAdmin(loginForm.getLoginAdmin());

		if (myForm.getDonorListControl().equals("2")) {
			myAdminDonorService.getDonorCategoryByNRC(myForm);
			return "gotoViewDonorDetail";
		}
		myForm.setFrmDonorName(null);
		myAdminDonorService.getAllDonorList(myForm);
		
		
		return "gotoViewDonor";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		AdminDonorForm myForm = (AdminDonorForm) form;
		if (request.getParameter("next") != null)
			myForm.setActualPage(myForm.getActualPage() + 1);

		if (request.getParameter("prev") != null)
			myForm.setActualPage(myForm.getActualPage() - 1);
		
		if (request.getParameter("btnOk") != null){
			return "gotoViewDonor";
		}
		if(request.getParameter("searchDonor")!=null){
			System.out.println("first " + myForm.getFrmDonorName());
			if(myForm.getFrmDonorName().equals("")){
				System.out.println(myForm.getFrmDonorName());
				myAdminDonorService.getAllDonorList(myForm);
			}
			else{
			List<DonorCategory> l = myAdminDonorService.getAllDonorName(myForm.getFrmDonorName());
			 myForm.setViewDonorList(l);
				myForm.setActualPage(1);
				myForm.setiMaxShow(7);
				if(l!=null)
					myForm.setiMaxData(l.size());
		}
		
		
	}
		return "gotoViewDonor";
}
}