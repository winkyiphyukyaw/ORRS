package com.ictti.orrs.business.service;

import java.util.List;

import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.dao.CategoryDao;
import com.ictti.orrs.presentation.form.AddCategoryForm;

public class CategoryService {
	CategoryDao myCategoryDao;

	public CategoryDao getMyCategoryDao() {
		return myCategoryDao;
	}

	public void setMyCategoryDao(CategoryDao myCategoryDao) {
		this.myCategoryDao = myCategoryDao;
	}

	public void saveFile(AddCategoryForm myForm) {
		// TODO Auto-generated method stub
		
		Category myCategory=new Category();
		myCategory.setId(null);
		myCategory.setType(myForm.getCategoryName());
		myCategoryDao.SaveFile(myCategory);
		
	/*	myForm.setAddCategoryList(myCategory);*/
		
	}
	public void getAllCategoryList(AddCategoryForm myForm) {
		// TODO Auto-generated method stub
		List<Category> l=myCategoryDao.getAllCategoryList();
		myForm.setAddCategoryList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(5);
		if(l!=null)
			myForm.setiMaxData(l.size());
		
	}
	public List<Category> getCategoryByIdAndType(int id,String categoryType){
		List<Category> l=myCategoryDao.getCategoryByIdAndType(id,categoryType);
		return l;		
	}

	public void firstLoadCategory(AddCategoryForm myForm) {
		// TODO Auto-generated method stub
		
		myForm.setCategoryList("");
	}

	public void comfirmCategory(AddCategoryForm myForm) {
		// TODO Auto-generated method stub
		myForm.setCategoryList("data");
		
	}

	public void firstLoadUpdateCategory(AddCategoryForm myForm) {
		// TODO Auto-generated method stub
		//myForm.setCategoryList("data");
		//Category myLoginCategory=myForm.getLoginCategory();
		
		//myForm.setCategoryName(myLoginCategory.getType());
		
		//myForm.setCategoryList("data");
		//myForm.setCategoryList(null);
Category myCategory= myCategoryDao.getCategoryByIdAndType(Integer.parseInt(myForm.getUpdateCatId()));
		
		
		myForm.setCategoryName(myCategory.getType());
		System.out.println(myForm.getCategoryName()+"========"+myCategory.getType());
		myForm.setCategoryList(null);
		
	}

	public void saveUpdateCategory(AddCategoryForm myForm) {
		// TODO Auto-generated method stub
Category myUpdateCategory=myCategoryDao.getCategoryByIdAndType(Integer.parseInt(myForm.getUpdateCatId()));
		System.out.println("Save Update work"+myForm.getCategoryName());
		myUpdateCategory.setType(myForm.getCategoryName());
		System.out.println("obj===="+myUpdateCategory.getType());
		myCategoryDao.saveUpdateCategory(myUpdateCategory);
		myForm.setCategoryList(null);
		
	}

	public void checkCategoryName(AddCategoryForm myForm) {
		// TODO Auto-generated method stub
		
		Category myCategory = myCategoryDao.getCheckNamebyCategoryName(myForm.getCategoryName());
		
		if (myCategory != null) //error
		{
			System.out.println(myCategory.getType());
			myForm.setFrmCategoryNameError(null);
		} 
		else
		{
			
			myForm.setFrmCategoryNameError("data");
		}
	}




	
}
