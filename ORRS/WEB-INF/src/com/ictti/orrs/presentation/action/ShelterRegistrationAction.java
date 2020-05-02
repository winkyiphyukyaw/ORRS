package com.ictti.orrs.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.service.ShelterService;
import com.ictti.orrs.presentation.form.ShelterForm;

public class ShelterRegistrationAction extends BaseAction {

	ShelterService myShelterService;

	public ShelterService getMyShelterService() {
		return myShelterService;
	}

	public void setMyShelterService(ShelterService myShelterService) {
		this.myShelterService = myShelterService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		ShelterForm myForm = (ShelterForm) form;
		/*
		 * if (request.getParameter("btnRegisterCancel") != null) { return
		 * "gotoLogin"; }
		 */
		if (isCancelled(request)) {
			return "gotoLogin";

		}
		if (request.getParameter("btnRegister") != null) {
			int flag = 0;
			ActionErrors errors = new ActionErrors();
			if (myForm.getShelterRegRegionStateById().equals("0")) {
				errors.add("regionstateError", new ActionMessage(
						"errors.course"));
				saveErrors(request, errors);
				flag = 1;
			}
			if (myForm.getShelterRegSubCityId().equals("0")) {
				errors.add("subcityError", new ActionMessage("errors.subcity"));
				saveErrors(request, errors);
				flag = 1;
			}

			if (Integer.parseInt(myForm.getShelterRegBfCost())<=0) {
				errors.add("breakfastError", new ActionMessage(
						"errors.shelterBreakfast"));
				saveErrors(request, errors);
				flag = 1;
			}

			if (Integer.parseInt(myForm.getShelterRegLunCost())<=0) {
				errors.add("lunchError", new ActionMessage(
						"errors.shelterLunch"));
				saveErrors(request, errors);
				flag = 1;
			}

			if (Integer.parseInt(myForm.getShelterRegDinCost())<=0) {
				errors.add("dinnerError", new ActionMessage(
						"errors.shelterDinner"));
				saveErrors(request, errors);
				flag = 1;
			}
			if (!myForm.getShelterRegPassword().equals(
					myForm.getShelterRegConfPassword())) {
				errors.add("passwordError", new ActionMessage(
						"errors.matchPassword"));
				saveErrors(request, errors);
				flag = 1;
			}
			if (flag == 0) {
				myShelterService.checkLoginName(myForm);
				if (myForm.getShelRegAccountNameError() == null) {
					errors.add("accountError", new ActionMessage(
							"errors.account"));
					saveErrors(request, errors);
				}
			}
			System.out.println("CIty Id==========="
					+ myForm.getShelterRegSubCityId() + "==========");
			return "gotoRegister";
		}

		// btnsave

		if (request.getParameter("btnSaveCancel") != null) {
			myForm.setShelRegFormControl(null);
			return "gotoRegister";
		}
		if (request.getParameter("btnSave") != null) {
			myShelterService.saveNewShelter(myForm);
			myShelterService.prepareForRegisterConfirmMail(myForm);
			return "gotoLogin";
		}

		if (isCancelled(request)) {
			return "gotoLogin";
		}

		return "gotoRegister";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		ShelterForm myForm = (ShelterForm) form;
		myShelterService.fristLoadRegistration(myForm);
		myShelterService.getBySubcity(myForm.getShelterRegRegionStateById());
		/* myShelterService.getBySubcity(myForm); */
		return "gotoRegister";
	}

}
