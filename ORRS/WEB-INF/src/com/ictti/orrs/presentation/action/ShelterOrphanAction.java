package com.ictti.orrs.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.Validate;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.service.ShelterOrphanService;
import com.ictti.orrs.presentation.form.ShelterEventForm;
import com.ictti.orrs.presentation.form.ShelterForm;
import com.ictti.orrs.presentation.form.ShelterOrphanForm;

public class ShelterOrphanAction extends BaseAction {
	ShelterOrphanService myOrphanService;
	
	public ShelterOrphanService getMyOrphanService() {
		return myOrphanService;
	}

	public void setMyOrphanService(ShelterOrphanService myOrphanService) {
		this.myOrphanService = myOrphanService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null)
		{
			return "gotoShelterLogin";
		}
		
		ShelterOrphanForm myForm=(ShelterOrphanForm)form;	
		
		ShelterForm loginForm = (ShelterForm) request.getSession().getAttribute("ShelterFormBean");
		myForm.setLoginShelter(loginForm.getLoginShelter());
		
		if(isCancelled(request))
		{
			myForm.setFrmName(null);
			myForm.setFrmAge(null);
			myForm.setFrmEducation(null);
			myForm.setFrmReligion(null);
			myForm.setFrmMedical(null);
			myForm.setFrmGenderType(null);
			myForm.setFrmAdoptType(null);
			return "gotoOrphan";
		}
				
		if (request.getParameter("btnInsert") != null) 
		{
			myOrphanService.OrphanList(myForm);
			ActionErrors errors=new ActionErrors();
			if (myForm.getFrmAge().equals("0")) 
			{
				errors.add("AgeError", new ActionMessage("errors.age"));
				saveErrors(request, errors);
				return "gotoOrphan";
			} 
			
			else if (myForm.getFrmEducation().equals("0")) 
			{
				errors.add("EducationError", new ActionMessage("errors.education"));
				saveErrors(request, errors);
				return "gotoOrphan";
			} 
			else if (myForm.getFrmReligion().equals("0") ) 
			{
				errors.add("ReligionError", new ActionMessage("errors.religion"));
				saveErrors(request, errors);
				return "gotoOrphan";
			} 
			else if (myForm.getFrmMedical().equals("0")) 
			{
				errors.add("MedicalError", new ActionMessage("errors.medical"));
				saveErrors(request, errors);
				return "gotoOrphan";
			} 
			myForm.setFrmFormControlInsert("data");		
			return "gotoOrphan"; 
		}
		if(request.getParameter("btnInSaveCancel") != null)
		{
			myForm.setFrmFormControlInsert(null);
			myOrphanService.OrphanList(myForm);
			/*myForm.setFrmName(null);
			myForm.setFrmAge(null);
			myForm.setFrmEducation(null);
			myForm.setFrmReligion(null);
			myForm.setFrmMedical(null);
			myForm.setFrmGenderType(null);
			myForm.setFrmAdoptType(null);*/
			return "gotoOrphan";
		}
		if (request.getParameter("btnInSave") != null)
		{
			myOrphanService.insertNewOrphan(myForm);		
			myForm.setFrmFormControlInsert(null);
			myOrphanService.OrphanList(myForm);
			myForm.setFrmName(null);
			myForm.setFrmAge(null);
			myForm.setFrmEducation(null);
			myForm.setFrmReligion(null);
			myForm.setFrmMedical(null);
			myForm.setFrmGenderType(null);
			myForm.setFrmAdoptType(null);			
			return "gotoOrphan";
		}
		
		
		//Next Previous	
		if(request.getParameter("next")!=null)
		{
			myForm.setActualPage(myForm.getActualPage()+1);
		}
		if(request.getParameter("prev")!=null)
		{
			myForm.setActualPage(myForm.getActualPage()-1);
		}
		
		//For Detail
		if(request.getParameter("btnOk")!=null)
		{
			return "gotoOrphan";
			
		}
		
		//for Update
		/*if(request.getParameter("btnSearch")!=null)
		{
			ActionErrors errors = new ActionErrors();
			myOrphanService.checkCityName(myForm);
			if (myForm.getFrmAdopterNRCError() == null) {
				System.out.println("in error");
				errors.add("AdopterNRCError", new ActionMessage("errors.NRC"));
				saveErrors(request, errors);
				myForm.setFrmAdopterFormControl(null);
				return "gotoUpdate";
			}
			else
			{
			myOrphanService.getAdopterInfoByNRC(myForm);
			}
			return "gotoUpdate";
		}
		
		if(request.getParameter("btnCancel")!=null){
			myForm.setFrmName(null);
			myForm.setFrmAge(null);
			myForm.setFrmEducation(null);
			myForm.setFrmReligion(null);
			myForm.setFrmMedical(null);
			myForm.setFrmGenderType(null);
			myForm.setFrmAdoptType(null);
			myForm.setFrmAdopterFormControl(null);
			return "gotoOrphan";
		}
		if(request.getParameter("btnUpdate") != null)
		{	
			ActionErrors errors = new ActionErrors();
			myOrphanService.checkCityName(myForm);
			if (myForm.getFrmAdopterNRCError() == null) {
				System.out.println("in error");
				errors.add("AdopterNRCError", new ActionMessage("errors.NRC"));
				saveErrors(request, errors);
				myForm.setFrmAdopterFormControl(null);
				return "gotoUpdate";
			}
			if (myForm.getFrmAge().equals("0")) 
			{
				errors.add("AgeError", new ActionMessage("errors.age"));
				saveErrors(request, errors);
				return "gotoUpdate";
			} 
			
			else if (myForm.getFrmEducation().equals("0")) 
			{
				errors.add("EducationError", new ActionMessage("errors.education"));
				saveErrors(request, errors);
				return "gotoUpdate";
			} 
			else if (myForm.getFrmReligion().equals("0") ) 
			{
				errors.add("ReligionError", new ActionMessage("errors.religion"));
				saveErrors(request, errors);
				return "gotoUpdate";
			} 
			else if (myForm.getFrmMedical().equals("0")) 
			{
				errors.add("MedicalError", new ActionMessage("errors.medical"));
				saveErrors(request, errors);
				return "gotoUpdate";
			} 
			myForm.setFrmFormControl("data");
			return "gotoUpdate";
		}
		if(request.getParameter("btnSaveCancel") != null)
		{
			myForm.setFrmFormControl(null);
			myForm.setFrmAdopterFormControl(null);
			myForm.setFrmAdopterNRC(null);
			return "gotoUpdate";
		}
		if (request.getParameter("btnSave") != null)
		{
			myOrphanService.saveUpdateOrphan(myForm);
			myOrphanService.OrphanList(myForm);
			myForm.setFrmName(null);
			myForm.setFrmAge(null);
			myForm.setFrmEducation(null);
			myForm.setFrmReligion(null);
			myForm.setFrmMedical(null);
			myForm.setFrmGenderType(null);
			myForm.setFrmAdoptType(null);
			return "gotoOrphan";
		}*/
		
		myForm.setFrmName(null);
		myForm.setFrmAge(null);
		myForm.setFrmEducation(null);
		myForm.setFrmReligion(null);
		myForm.setFrmMedical(null);
		myForm.setFrmGenderType(null);
		/*myForm.setFrmAdoptType(null);*/
		return "gotoOrphan";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) 
	{
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null)
		{
			return "gotoShelterLogin";
		}
		
		ShelterOrphanForm myForm = (ShelterOrphanForm) form;
		
		ShelterForm loginForm = (ShelterForm) request.getSession().getAttribute("ShelterFormBean");
		myForm.setLoginShelter(loginForm.getLoginShelter());
		
		myOrphanService.OrphanList(myForm);
		/*myForm.setFrmOrphanList(null);*/
		
		//For Insert 
		if(myForm.getFrmControl().equals("1"))
		{	
			myOrphanService.firstLoadInsert(myForm);
			myOrphanService.OrphanList(myForm);
			myForm.setFrmFormControlInsert(null); 
			return "gotoOrphan";
		}
		
		//For Detail
		if(myForm.getFrmControl().equals("4"))
		{
			myOrphanService.getOrphanListbyid(myForm);
			return "gotoDetail";
		}
		
		//For Update 
		if(myForm.getFrmControl().equals("3"))
		{				
			myOrphanService.getUpdateOrphanbyId(myForm);
			myForm.setFrmFormControl(null);	
			myForm.setFrmAdopterFormControl(null); 
			myForm.setFrmAdopterNRC(null);
			return "gotoUpdate";
		}
		
		/*//For Delete
		if(myForm.getFrmControl().equals("2"))
		{
			myOrphanService.getFrmDeleteOrphanbyId(myForm);
			myOrphanService.OrphanList(myForm);
			return "gotoOrphan";
		}	*/	
		
		return "gotoOrphan";
	}
}
