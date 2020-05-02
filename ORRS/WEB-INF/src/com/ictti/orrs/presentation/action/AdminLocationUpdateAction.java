package com.ictti.orrs.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.service.AdminLocationService;
import com.ictti.orrs.presentation.form.AdminLocationForm;

public class AdminLocationUpdateAction extends BaseAction {

	AdminLocationService myLocationService;

	public AdminLocationService getMyLocationService() {
		return myLocationService;
	}

	public void setMyLocationService(AdminLocationService myLocationService) {
		this.myLocationService = myLocationService;
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

		AdminLocationForm myForm = (AdminLocationForm) form;

		
		if (isCancelled(request)) {
			/*myForm.setFrmRegionId(null);*/
			/*myForm.setFrmSubcityId(null);*/
			myForm.setFrmCityName(null);
			return "gotoDetail";
		}
		/*if (request.getParameter("btnHome") != null) {
			return "gotoHome";
		}
		
		//for Add city
		if (request.getParameter("btnAdd") != null) {

			ActionErrors errors = new ActionErrors();

			
			 * if (myForm.getFrmRegionId().equals("0"))
			 *  {
			 * errors.add("regionError", new ActionMessage("errors.region"));
			 * saveErrors(request, errors); 
			 * return "gotoDetail"; 
			 * }
			 

			myLocationService.checkCityName(myForm);
			if (myForm.getFrmCityNameError() == null) {
				System.out.println("in error");
				errors.add("cityError", new ActionMessage("errors.city"));
				saveErrors(request, errors);
				return "gotoDetail";
			} else {
				myForm.setFrmFormControlLocation("data");
			}
			return "gotoDetail";
		}

		if (request.getParameter("btnLocSaveCancel") != null) {
			myForm.setFrmFormControlLocation(null);
			myForm.setFrmCityName(null);
			return "gotoDetail";
		}
		if (request.getParameter("btnLocSave") != null) {
			myLocationService.saveNewCity(myForm);
			myForm.setFrmFormControlLocation(null);
			myForm.setFrmCityName(null);
			myLocationService.getCityNamebyRegionId(myForm);
			return "gotoDetail";
		}*/

		// For Update
		/*if (request.getParameter("btnUpdateCancel") != null) {
			myForm.setFrmCityName(null);
			return "gotoDetail";
		}*/
		if (request.getParameter("btnUpdate") != null) {
			ActionErrors errors = new ActionErrors();
			myLocationService.checkCityNameExist(myForm);
			if (myForm.getFrmCityNameError() == null) {
				System.out.println("in error");
				errors.add("cityError", new ActionMessage("errors.city"));
				saveErrors(request, errors);
				return "gotoUpdate";
			} else {
				myForm.setFrmFormControl("data");
			}
			return "gotoUpdate";
		}
		if (request.getParameter("btnSaveCancel") != null) {
			myForm.setFrmFormControl(null);
			return "gotoUpdate";
		}
		if (request.getParameter("btnSave") != null) {
			myLocationService.saveUpdateCityName(myForm);
			myLocationService.getCityNamebyRegionId(myForm);
			myForm.setFrmSubcityId(null);
			myForm.setFrmRegionId(null);
			myForm.setFrmCityName(null);
			return "gotoDetail";
		}

		// For Next Previous
		/*if (request.getParameter("next") != null)
			myForm.setActualPage(myForm.getActualPage() + 1);
		if (request.getParameter("prev") != null)
			myForm.setActualPage(myForm.getActualPage() - 1);*/

		// For Next Previous detail
		/*if (request.getParameter("nextDetail") != null) {
			myForm.setActualPage(myForm.getActualPage() + 1);
			return "gotoDetail";
		}
		if (request.getParameter("prevDetail") != null) {
			myForm.setActualPage(myForm.getActualPage() - 1);
			return "gotoDetail";
		}*/

		myForm.setFrmSubcityId(null);
		myForm.setFrmRegionId(null);
		myForm.setFrmCityName(null);
		return "gotoLocation";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
		AdminLocationForm myForm = (AdminLocationForm) form;
		myLocationService.getAllRegion(myForm);

		// For ADD City
		if (myForm.getFrmControl().equals("1")) 
		{
			myLocationService.getAllRegion(myForm);
			return "gotoLocation";
		}

		// For Detail
		if (myForm.getFrmControl().equals("2")) {
			myLocationService.firstLoadAddCity(myForm);
			myLocationService.getCityNamebyRegionId(myForm);
			myLocationService.getRegionNamebyRegionId(myForm);
			return "gotoDetail";
		}

		// For Update
		if (myForm.getFrmControl().equals("3")) {
			myLocationService.firstLoadCityUpdate(myForm);
			return "gotoUpdate";
		}
		return "gotoLocation";
	}

}
