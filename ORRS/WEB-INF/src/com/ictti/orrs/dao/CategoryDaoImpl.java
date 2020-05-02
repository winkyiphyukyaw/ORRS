package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.Category;

public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		String hql="from Category";
		List<Category> l=getHibernateTemplate().find(hql);
		return l.isEmpty() || l==null ? null:l;
	}

	@Override
	public Category getCategoryTypebyId(int id) {
		// TODO Auto-generated method stub
		String hql="from Category i where i.id=?";
		List<Category> l=getHibernateTemplate().find(hql,id);
		return l.isEmpty() || l==null ? null:l.get(0);
		
	}
	@Override
	public void SaveFile(Category c) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(c);
		
	}

	@Override
	public Category getCategoryById(int cid) {
		// TODO Auto-generated method stub
		String hql="from Category c where c.id=?";
		
		List<Category> l=getHibernateTemplate().find(hql,cid);
		return l.isEmpty()||l==null?null:l.get(0);
		
	}


	@Override
	public List<Category> getAllCategoryList() {
		// TODO Auto-generated method stub
		String hql="from Category";
		List<Category> l=getHibernateTemplate().find(hql);
		
		return l.isEmpty() || l==null ? null : l;
	}

	@Override
	public List<Category> getCategoryByIdAndType(int id, String categoryType) {
		// TODO Auto-generated method stub
		String hql="from Category c where c.id=? and c.type=?";
		Object[] parm={id,categoryType};
		List l=getHibernateTemplate().find(hql, parm);
		return l.isEmpty()||l==null? null:l;
	}

	@Override
	public void updateFile(Category myCategory1) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myCategory1);
	}

	@Override
	public void saveUpdateCategory(Category myUpdateCategory) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myUpdateCategory);
		
	}

	@Override
	public Category getCategoryByIdAndType(int parseInt) {
		// TODO Auto-generated method stub
		String hql = "from Category c where c.id=?";
		List<Category> l = getHibernateTemplate().find(hql,parseInt);
		return l.isEmpty()||l==null?null:l.get(0);
	}

	@Override
	public Category getCheckNamebyCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		String hql="from Category c where c.type=?";
		/*Object[] param={frmCityName,id};*/
		List<Category> l=getHibernateTemplate().find(hql,categoryName);
		return l.isEmpty() || l==null ? null : (Category) l.get(0);
	}

}
