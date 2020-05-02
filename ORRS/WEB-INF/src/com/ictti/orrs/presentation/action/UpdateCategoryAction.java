package com.ictti.orrs.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.service.CategoryService;
import com.ictti.orrs.presentation.form.AddCategoryForm;

public class UpdateCategoryAction extends BaseAction {
	CategoryService myCategoryService;

	public CategoryService getMyCategoryService() {
		return myCategoryService;
	}

	public void setMyCategoryService(CategoryService myCategoryService) {
		this.myCategoryService = myCategoryService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
		System.out.println("Doinit====");
		/*HttpSession session=request.getSession(false);
		if(session.getAttribute("id")==null)
			return "gotoUpdateCategory";
		*/
		AddCategoryForm myForm=(AddCategoryForm) form;
		myCategoryService.getAllCategoryList(myForm);
		//AddCategoryForm loginForm=(AddCategoryForm)request.getSession().getAttribute("AdFormBean");
		//myForm.setLoginCategory(loginForm.getLoginCategory());
		//myCategoryService.firstLoadUpdateProfile(myForm);
		//return "gotoUpdateCategory";
		if(myForm.getUpdateCategoryControl().equals("2"))
		{
			System.out.println("Form ctrl 2 workssssss");
			myCategoryService.firstLoadUpdateCategory(myForm);
		//myForm.setCategoryList("data");
		return "gotoUpdateCategory";
		}
		return "gotoCategory";
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
		AddCategoryForm myForm=(AddCategoryForm) form;
		
		
		/*HttpSession session=request.getSession(false);
		if(session.getAttribute("id")==null)
			return "gotoUpdateCategory";*/
		
		if(isCancelled(request) ){
			return "gotoCategory";	}
		
		if(request.getParameter("btnUpdate") != null){

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
					return "gotoUpdateCategory";
			}
			else
			{
				myForm.setUpdateCategoryControl("data");
			}
				
			myForm.setCategoryList("data");			
			return "gotoUpdateCategory";
		}
		if(request.getParameter("btnSaveCancel") != null){
			myForm.setCategoryList(null);
			return "gotoUpdateCategory";
		}
if (request.getParameter("btnUpdateSave") != null) {
	
	
	
	//myCategoryService.saveFile(myForm);
	myCategoryService.saveUpdateCategory(myForm);
	AddCategoryForm insertCategoryForm=(AddCategoryForm)request.getSession().getAttribute("AdFormBean");
	myCategoryService.getAllCategoryList(insertCategoryForm);
	//myForm.setUpdateCategoryControl("data");
	//myForm.setCategoryName(null);
	
	return "gotoCategory";
		}

		return "gotoCategory";
	}

	}

