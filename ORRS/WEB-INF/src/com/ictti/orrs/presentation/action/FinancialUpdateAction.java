package com.ictti.orrs.presentation.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.entity.AnnualReportTable;
import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.service.FinancialService;
import com.ictti.orrs.dao.CategoryDao;
import com.ictti.orrs.presentation.form.FinancialForm;

public class FinancialUpdateAction extends BaseAction {

	FinancialService myFinancialService;
	
	
	public FinancialService getMyFinancialService() {
		return myFinancialService;
	}

	public void setMyFinancialService(FinancialService myFinancialService) {
		this.myFinancialService = myFinancialService;
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
		
		FinancialForm myForm = (FinancialForm) form;
		
		
		/*if (request.getParameter("btnInsertFinancial") != null) {
		
			ActionErrors errors = new ActionErrors();
			if (myForm.getFrmCategoryId().equals("0")) {
				errors.add("CategoryError", new ActionMessage("errors.categoryFinancial"));
				saveErrors(request, errors);
				System.out.println("ERRRRRRRRRRRRRRRR");
				return "gotoFinancial";
			}
			
			if(myForm.getFrmOutcome().equals(null)|| Double.parseDouble(myForm.getFrmOutcome())<=0){
				errors.add("outcomeError",new ActionMessage("errors.outcome"));
				saveErrors(request, errors);
				return "gotoFinancial";
			}
			
			
			
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			Date myDate2 = myformat.parse(myForm.getFirstDate());
			//For check amount
			SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
			SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
			String month=monthFormat.format(myDate2);
			String year=yearFormat.format(myDate2);
			Category myCategory=myFinancialService.getCategoryByBalance(myForm);
			System.out.println("OPPPPPP--------"+myCategory.getType());
			String categoryid1=myCategory.getType();
			
			Date myDate3 = new Date();
			String myDate4 = myformat.format(myDate3);
			Date todayDate = myformat.parse(myDate4);
			if(myDate2.after(todayDate)){
				errors.add("DateMisMatch", new ActionMessage("errors.DateMismatch"));
				saveErrors(request, errors);
				return "gotoFinancial";
			}
			
			//For Check Fund
			System.out.println("Pl-----------------"+categoryid1);
			List<AnnualReportTable> myBalanceChecked=myFinancialService.getDonorAmount(month, year,categoryid1);
			if(myBalanceChecked!=null)
			{
			System.out.println(myBalanceChecked.size());
			System.out.println("Year----"+myBalanceChecked.get(0).getYear()+"Month----"+myBalanceChecked.get(0).getMonth()+"Balance---"+
			myBalanceChecked.get(0).getBalance());
			System.out.println("Category-----------+"+myBalanceChecked.get(0).getCategory());
	
			if(myBalanceChecked.size()!=0)
			{
			if((myBalanceChecked.get(0).getBalance())<Integer.parseInt(myForm.getFrmOutcome())){
				errors.add("outcomeError", new ActionMessage("errors.NotMatchBalance"));
				saveErrors(request, errors);
				return "gotoFinancial";
			
			}
			}
			else{
				
				errors.add("outcomeError", new ActionMessage("errors.NotMatchBalance"));
				saveErrors(request, errors);
				return "gotoFinancial";
			}
			}
			else
{
				
				errors.add("outcomeError", new ActionMessage("errors.nothingBalance"));
				saveErrors(request, errors);
				return "gotoFinancial";
			}
			myForm.setFrmFinancialFormControl("data");
			myFinancialService.getCategoryName(myForm);
			return "gotoFinancial";
		}
		
		
				if (request.getParameter("btnInsertCancel") != null) {
					myForm.setFrmFinancialFormControl(null);
					myForm.setFirstDate("");
					myForm.setFrmCategoryId("");
					myForm.setFrmOutcome(null);
					return "gotoFinancial";
		
		
				if(request.getParameter("btnsaveFinancialCancel") != null)
				{
					myForm.setFrmFinancialFormControl(null);
					myForm.setFirstDate("");
					myForm.setFrmCategoryId("");
					myForm.setFrmOutcome(null);
					return "gotoFinancial";
				}
		
				if (request.getParameter("btnSaveFinancial") != null)
				{
					
					myFinancialService.saveFinancialOutcome(myForm);
					myFinancialService.getAllAmountList(myForm);
					myForm.setFrmFinancialFormControl(null);
					myForm.setFirstDate("");
					myForm.setFrmCategoryId("");
					myForm.setFrmOutcome(null);
					return "gotoFinancial";
				}
		
		
		//For Next Previous
				if (request.getParameter("next") != null)
					myForm.setActualPage(myForm.getActualPage() + 1);
				if (request.getParameter("prev") != null)
					myForm.setActualPage(myForm.getActualPage() - 1);*/
				
				
				
				
		//For Update
				if(request.getParameter("btnUpdateFinancial") != null)
				{
					ActionErrors errors = new ActionErrors();
					
					if (myForm.getFrmCategoryId().equals("0")) {
						errors.add("CategoryError", new ActionMessage("errors.categoryFinancial"));
						saveErrors(request, errors);
						System.out.println("ERRRRRRRRRRRRRRRR");
						return "gotoUpdate";
					}
					
					if(myForm.getFrmOutcome().equals(null)|| Double.parseDouble(myForm.getFrmOutcome())<=0){
						errors.add("outcomeError",new ActionMessage("errors.outcome"));
						saveErrors(request, errors);
						return "gotoUpdate";
					}
					
					SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
					Date myDate2 = myformat.parse(myForm.getFirstDate());
					Date myDate3 = new Date();
					String myDate4 = myformat.format(myDate3);
					Date todayDate = myformat.parse(myDate4);
					if(myDate2.after(todayDate)){
						errors.add("DateMisMatch", new ActionMessage("errors.DateMismatch"));
						saveErrors(request, errors);
						return "gotoUpdate";
					}
					
					
					
					//For check amount
					SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
					SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
					String month=monthFormat.format(myDate2);
					String year=yearFormat.format(myDate2);
					Category myCategory=myFinancialService.getCategoryByBalance(myForm);
					System.out.println("OPPPPPP--------"+myCategory.getType());
					String categoryid1=myCategory.getType();
					List<AnnualReportTable> myBalanceChecked=myFinancialService.getDonorAmount(month, year,categoryid1);
					if(myBalanceChecked!=null)
					{
					System.out.println(myBalanceChecked.size());
					System.out.println("Year----"+myBalanceChecked.get(0).getYear()+"Month----"+myBalanceChecked.get(0).getMonth()+"Balance---"+
					myBalanceChecked.get(0).getBalance());
					System.out.println("Category-----------+"+myBalanceChecked.get(0).getCategory());
			
					if(myBalanceChecked.size()!=0)
					{
					if((myBalanceChecked.get(0).getBalance())<Integer.parseInt(myForm.getFrmOutcome())){
						errors.add("outcomeError", new ActionMessage("errors.NotMatchBalance"));
						saveErrors(request, errors);
						return "gotoUpdate";
					
					}
					}
					else{
						
						errors.add("outcomeError", new ActionMessage("errors.NotMatchBalance"));
						saveErrors(request, errors);
						return "gotoUpdate";
					}
					}
					else
					{
						
						errors.add("outcomeError", new ActionMessage("errors.NotMatchBalance"));
						saveErrors(request, errors);
						return "gotoUpdate";
					}
					
					
				
					myForm.setFrmUpdateFormControl("data");
					myFinancialService.getCategoryNameForUpdate(myForm);
					System.out.println("Category Name************************"+myForm.getFrmCategoryName());
					return "gotoUpdate";
				}
				
				if(request.getParameter("btnUpdateFinancialCancel")!=null)
				{
					myForm.setFrmUpdateFormControl(null);
					myForm.setFrmCategoryId(null);
					myForm.setFrmOutcome(null);
					myForm.setFirstDate(null);
					return "gotoFinancial";
					
				}
				
				
				//For UpdateFinancial Cancel 
				if(isCancelled(request)){
					myForm.setFirstDate("");
					myForm.setFrmCategoryId("");
					myForm.setFrmOutcome("");
					myForm.setFrmUpdateFormControl(null);
					return "gotoFinancial";
				}
				
	
				
				
				
				if(request.getParameter("btnUpdateSaveCancel") != null){
					myForm.setFrmUpdateFormControl(null);
					return "gotoUpdate";
				}
				if (request.getParameter("btnUpdateSaveFinancial") != null) {
					myFinancialService.saveUpdateFinancialList(myForm);
					myFinancialService.getAllAmountList(myForm);
					myForm.setFrmUpdateFormControl("data");
					myForm.setFirstDate(null);
					myForm.setFrmCategoryId(null);
					myForm.setFrmOutcome(null);
					return "gotoFinancial";
				}
				
		return "gotoFinancial";
				}
	
	


	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null)
			return "gotoLogin";
	
		FinancialForm myForm = (FinancialForm) form;
		myFinancialService.getAllAmountList(myForm);
		
		if(myForm.getFrmFormControl().equals("1"))
		{
			myFinancialService.getCategoryList(myForm);
			myFinancialService.getAllAmountList(myForm);
			myFinancialService.firstLoadInsertFinancial(myForm);
			return "gotoFinancial";
		}
		
		
		//For Update
				if(myForm.getFrmFormControl().equals("2"))
				{
				
					myFinancialService.firstLoadUpdate(myForm);
					return "gotoUpdate";
				}
				
		return "gotoFinancial";
	}
	

}
