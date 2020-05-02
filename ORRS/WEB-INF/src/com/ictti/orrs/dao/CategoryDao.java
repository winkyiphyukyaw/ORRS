package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.Category;

public interface CategoryDao {

	List<Category> getAllCategory();

	Category getCategoryById(int Id);

	Category getCategoryTypebyId(int parseInt);
	
	//For Admin Category
	public void SaveFile(Category myCategory);
	
	public List<Category> getAllCategoryList();

	public List<Category> getCategoryByIdAndType(int id, String categoryType);

	public void updateFile(Category myCategory1);

	public void saveUpdateCategory(Category myUpdateCategory);

	public Category getCategoryByIdAndType(int parseInt);

	public Category getCheckNamebyCategoryName(String categoryName);

}
