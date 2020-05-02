package com.ictti.orrs.presentation.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.ictti.orrs.business.service.AdoptService;
import com.ictti.orrs.presentation.form.AdopterForm;

public class AdopterRegistrationAction extends BaseAction {
	AdoptService myAdoptService;
    FormFile ff;
	public FormFile getFf() {
		return ff;
	}

	public void setFf(FormFile ff) {
		this.ff = ff;
	}

	public AdoptService getMyAdoptService() {
		return myAdoptService;
	}

	public void setMyAdoptService(AdoptService myAdoptService) {
		this.myAdoptService = myAdoptService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		
		AdopterForm myForm = (AdopterForm) form;
		/*if (request.getParameter("btnRegisterCancel") != null) {
			return "gotoMain";
		}*/
		if(isCancelled(request)){
			return "gotoHome";
		}

		if (request.getParameter("btnRegister") != null) {
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dob = myForm.getFrmAdopterDob();
			Date date = myFormat.parse(dob);
			GregorianCalendar birth = new GregorianCalendar();
			birth.setTime(date);
			GregorianCalendar now = new GregorianCalendar();
			int age = now.get(GregorianCalendar.YEAR)
					- birth.get(GregorianCalendar.YEAR);
			System.out.println(age);
			if (age < 25 || age > 80) {

				ActionErrors error = new ActionErrors();

				error.add("dobError", new ActionMessage("errors.IlligalDate"));
				saveErrors(request, error);
				return "gotoAdopt";

			} else {
				myAdoptService.getAdopterInfo(myForm);
				myForm.setFrmRegFormControl("data");
				return "gotoSave";
			}
		
		}
		if (request.getParameter("btnSaveCancel") != null) {
			myForm.setFrmRegFormControl(null);
			/*myForm.setFrmFileUpload(myForm.getFrmFileUpload());
			myForm.setFrmAdopterGender(myForm.getFrmAdopterGender());*/
			
			if(myForm.getFrmAdopterGender().equals("male"))
			{
				myForm.setFrmAdopterGender("0");
			}
			else if(myForm.getFrmAdopterGender().equals("female"))
			{
				myForm.setFrmAdopterGender("1");
			}
			
			if (myForm.getFrmAdopterMaritalStatus().equals("single")) {
				myForm.setFrmAdopterMaritalStatus("0");
			} else if(myForm.getFrmAdopterMaritalStatus().equals("married")) {
				myForm.setFrmAdopterMaritalStatus("1");
			}
			
			if (myForm.getFrmOrphanGender().equals("male")) {
				myForm.setFrmOrphanGender("0");

			} else if(myForm.getFrmOrphanGender().equals("female")){ 
				myForm.setFrmOrphanGender("1");
			}
			/*ff.setContentType(myForm.getFrmFileUpload().getContentType());
			ff.setFileName(myForm.getFrmFileUpload().getFileName());
			ff.setFileSize(myForm.getFrmFileUpload().getFileSize());
			myForm.getFrmFileUpload().getFileData();
			
			myForm.setFrmFileUpload(ff);*/
			
			return "gotoAdopt";
		}

		if (request.getParameter("btnSave") != null) {
			myAdoptService.saveAdopterInfo(myForm);
			return "gotoHome";

		}
		

		return null;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		
		
		AdopterForm myForm = (AdopterForm) form;
		myForm.setFrmRegFormControl(null);
		myForm.setFrmAdoptedChildNo(null);
		myForm.setFrmAdopterAddress(null);
		myForm.setFrmAdopterChildNo(null);
		myForm.setFrmAdopterDob(null);
		myForm.setFrmAdopterEmail(null);
		myForm.setFrmAdopterGender(null);
		myForm.setFrmAdopterIncome(null);
		myForm.setFrmAdopterMaritalStatus(null);
		myForm.setFrmAdopterName(null);
		myForm.setFrmAdopterNrc(null);
		myForm.setFrmAdopterOccupation(null);
		myForm.setFrmAdopterPhone(null);
		myForm.setFrmFileUpload(null);
		myForm.setFrmOrphanAge(null);
		myForm.setFrmOrphanGender(null);
		//mySearchService.getShelters(myForm);//below list
		//mySearchService.getShelters(myForm);//below list
		myAdoptService.getAllRegion(myForm);//first load
		myAdoptService.getAllShelter(myForm);//first load
		myAdoptService.getAllCity(myForm);//first load
		myForm.setFrmCityId("0");
		myForm.setFrmRegionId("0");
		myForm.setFrmShelterId("0");
		return "gotoAdopt";
	}

}