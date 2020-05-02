package com.ictti.orrs.presentation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.entity.AllYearTable;
import com.ictti.orrs.business.entity.AnnualReportTable;
import com.ictti.orrs.business.service.AnnualReportService;
import com.ictti.orrs.presentation.form.AnnualReportForm;

public class AnnualReportAction extends BaseAction {
	AnnualReportService myAnnualReportService;
	
	public AnnualReportService getMyAnnualReportService() {
		return myAnnualReportService;
	}

	public void setMyAnnualReportService(AnnualReportService myAnnualReportService) {
		this.myAnnualReportService = myAnnualReportService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		AnnualReportForm myForm = (AnnualReportForm) form;
	
		if(request.getParameter("btnView")!=null)
		{
			
		
		//myForm.setFrmcontrol(null);
			//myForm.setActualPage(myForm.getActualPage());
			myAnnualReportService.getAllAnnualList(myForm);
			/*ActionErrors errors = new ActionErrors();
			List<AllYearTable> l = myForm.getFrmAllYearViewList();
			if(l.isEmpty())
			{
				errors.add("listerror", new ActionMessage("errors.list"));
				   saveErrors(request, errors);
				   myForm.setFrmAllYearViewList(null);
				   myForm.setFrmAnnualYearList(null);
				   return "gotoAnnualReport";
			}
			List<AnnualReportTable> l1 = myForm.getFrmAnnualYearList();
			if(l1.isEmpty()){
				errors.add("listerror", new ActionMessage("errors.list"));
				   saveErrors(request, errors);
				   myForm.setFrmAllYearViewList(null);
				   myForm.setFrmAnnualYearList(null);
				   return "gotoAnnualReport";
			}*/
			ActionErrors errors = new ActionErrors();
			if(myForm.getFrmAnnualId().equals("0"))
			{
				List<AllYearTable> l = myAnnualReportService.getAllAnnualList(myForm);
				if(l.isEmpty())
				{
					errors.add("listError", new ActionMessage("errors.list"));
					errors.add("reportlisterror", new ActionMessage("errors.reportlist"));
					saveErrors(request, errors);
					myForm.setFrmAllYearViewList(null);
					myForm.setFrmAnnualYearList(null);
					return "gotoAnnualReport";

				}
				myForm.setFrmcontrol("data");
				myForm.setBegin(0);
				myForm.setActualPage(1);
				myForm.setiMaxShow(10);
				myForm.setFrmAllYearViewList(l);
				myForm.setFrmAnnualYearList(null);
				if (l != null)
					myForm.setiMaxData(l.size());
				System.out.println(l.size());
			}
			else{
				List<AnnualReportTable> l = myAnnualReportService.getAnnualReportList(myForm);
				if(l.isEmpty())
				{
					errors.add("listError", new ActionMessage("errors.list"));
					errors.add("reportlisterror", new ActionMessage("errors.reportlist"));

					saveErrors(request, errors);
					myForm.setFrmAllYearViewList(null);
					myForm.setFrmAnnualYearList(null);
					return "gotoAnnualReport";

				}
				System.out.println(myForm.getFrmAnnualId());
				//System.out.println(l.get(0)+ "=====aaaaaaaaaaa==============");
				myForm.setFrmAnnualYearList(l);
				myForm.setFrmcontrol(null);
				myForm.setActualPage(1);
				myForm.setBegin(0);
				myForm.setiMaxShow(10);
				if (l != null)
					myForm.setiMaxData(l.size());
				//System.out.println(l.size());
				myForm.setFrmAllYearViewList(null);
			}
		return "gotoAnnualReport";
		}
		
		if(request.getParameter("next")!=null)
			myForm.setActualPage(myForm.getActualPage()+1);
		if(request.getParameter("prev")!=null)
		myForm.setActualPage(myForm.getActualPage()-1);
		
		return "gotoAnnualReport";
	}
	
	

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		
		AnnualReportForm myForm = (AnnualReportForm) form;
		myForm.setFrmcontrol("data");
		myAnnualReportService.fristLoadPage(myForm);
		myForm.setFrmAllYearViewList(null);
		myForm.setFrmAnnualYearList(null);
		
		myForm.setFrmCategoryId("0");
		List<AllYearTable> l = myAnnualReportService.getAllAnnualList(myForm);
		ActionErrors errors = new ActionErrors();
		
		if(l.isEmpty())
		{
			errors.add("listError", new ActionMessage("errors.list"));
			errors.add("reportlisterror", new ActionMessage("errors.reportlist"));

			saveErrors(request, errors);
			myForm.setFrmAllYearViewList(null);
			myForm.setFrmAnnualYearList(null);
			return "gotoAnnualReport";

		}
		myForm.setFrmcontrol("data");
		myForm.setBegin(0);
		myForm.setActualPage(1);
		myForm.setiMaxShow(10);
		myForm.setFrmAllYearViewList(l);
		myForm.setFrmAnnualYearList(null);
		if (l != null)
			myForm.setiMaxData(l.size());
		System.out.println(l.size());
		return "gotoAnnualReport";
	}

}
