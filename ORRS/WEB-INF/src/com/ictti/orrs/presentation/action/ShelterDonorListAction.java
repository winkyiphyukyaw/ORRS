package com.ictti.orrs.presentation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.ictti.orrs.business.entity.DonorShelter;
import com.ictti.orrs.business.service.ShelterDonorListService;
import com.ictti.orrs.presentation.form.ShelterDonorListForm;
import com.ictti.orrs.presentation.form.ShelterForm;
import com.ictti.orrs.presentation.form.ShelterOrphanForm;



public class ShelterDonorListAction extends BaseAction {
	ShelterDonorListService myViewDonorListService;

	

	public ShelterDonorListService getMyViewDonorListService() {
		return myViewDonorListService;
	}

	public void setMyViewDonorListService(
			ShelterDonorListService myViewDonorListService) {
		this.myViewDonorListService = myViewDonorListService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null)
			{
			return "gotoShelterLogin";
			}
		ShelterDonorListForm myForm=(ShelterDonorListForm) form;
		ShelterForm loginForm = (ShelterForm) request.getSession()
				.getAttribute("ShelterFormBean");
		myForm.setLoginShelter(loginForm.getLoginShelter());
		myForm.setFrmDonorName(null);
		
		if(myForm.getDonorListControl().equals("2"))
		{
			myViewDonorListService.getDonorShelterByNRC(myForm);
			return "gotoViewDonorDetail";
		}
		myViewDonorListService.getAllDonorList(myForm);
		
		return "gotoViewDonor";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		ShelterDonorListForm myForm= (ShelterDonorListForm) form;
		if(request.getParameter("next")!=null)
			myForm.setActualPage(myForm.getActualPage()+1);
	
		if(request.getParameter("prev")!=null)
				myForm.setActualPage(myForm.getActualPage()-1);
		
		
		if (request.getParameter("btnOk") != null){
			return "gotoViewDonor";
		}
		
		//For search
		if(request.getParameter("btnSearch")!=null)
		{
			System.out.println("Search BUtoon=======");
		
			if(myForm.getFrmDonorName().equals("")){
				System.out.println("No DOnor Name");
				
				myViewDonorListService.getAllDonorList(myForm);
			}
			else{
				List<DonorShelter> l = myViewDonorListService.getAllDonorByShelterName(myForm.getFrmDonorName());
				myForm.setViewDonorList(l);
				myForm.setActualPage(1);
				myForm.setiMaxShow(3);
				if(l!=null)
					myForm.setiMaxData(l.size());
			}
		
		
		
	}
		return "gotoViewDonor";	
		
		
	}

}
