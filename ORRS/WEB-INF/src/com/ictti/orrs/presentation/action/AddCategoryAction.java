package com.ictti.orrs.presentation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.service.CategoryService;
import com.ictti.orrs.presentation.form.AddCategoryForm;

public class AddCategoryAction extends BaseAction {
	CategoryService myCategoryService;

	public CategoryService getMyCategoryService() {
		return myCategoryService;
	}

	public void setMyCategoryService(CategoryService myCategoryService) {
		this.myCategoryService = myCategoryService;
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
		
		AddCategoryForm myForm=(AddCategoryForm)form;
		//myForm.setCategoryName(null);
		
		//AddCategoryForm dd=(AddCategoryForm) form;
		/*myCategoryService.saveFile(myForm);*/
		if(request.getParameter("btnAdd")!=null)
		{
			ActionErrors errors = new ActionErrors();
			//myCategoryService.comfirmCategory(myForm);
			//myCategoryService.getAllCategoryList(myForm);
			//myCategoryService.checkCategoryName(myForm);
			myCategoryService.checkCategoryName(myForm);
			if (myForm.getFrmCategoryNameError()==null) 
			{
					System.out.println("in error");
					errors.add("categoryError", new ActionMessage("errors.category"));
					saveErrors(request, errors);
					/*myForm.setFrmRegionId(null);
					myForm.setFrmSubcityId(null);
					myForm.setFrmCityName(null);*/
					return "gotoCategory";
			}
			else
			{
				myForm.setUpdateCategoryControl("data");
			}
			//myCategoryService.saveFile(myForm);
			myCategoryService.comfirmCategory(myForm);
			myCategoryService.getAllCategoryList(myForm);
			
			return "gotoCategory";
		}
		if(request.getParameter("next")!=null)
			myForm.setActualPage(myForm.getActualPage()+1);
	
		if(request.getParameter("prev")!=null)
			myForm.setActualPage(myForm.getActualPage()-1);
	

	
		
		if(request.getParameter("btnSave")!=null)
		{
			myCategoryService.saveFile(myForm);
			myCategoryService.getAllCategoryList(myForm);
			myForm.setCategoryName(null);
			myForm.setCategoryList(null);
			return "gotoCategory";
		}
		if(request.getParameter("btnCancel") != null)
		{
			myForm.setCategoryList(null);
			myForm.setCategoryName(null);
			
			return "gotoCategory";
		}
		
	
		return "gotoCategory";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
		
		AddCategoryForm myForm=(AddCategoryForm)form;
		myCategoryService.getAllCategoryList(myForm);
		myCategoryService.firstLoadCategory(myForm);
		myForm.setCategoryName(null);
		return "gotoCategory";
	}
}
