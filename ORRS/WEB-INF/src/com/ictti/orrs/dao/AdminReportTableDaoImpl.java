package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.AdminDailyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminDailyReportTable;
import com.ictti.orrs.business.entity.AdminMonthlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminMonthlyReportTable;
import com.ictti.orrs.business.entity.AdminYearlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminYearlyReportTable;

public class AdminReportTableDaoImpl extends HibernateDaoSupport implements
		AdminReportTableDao {

	@Override
	public List<AdminYearlyReportTable> getAllYear() {
		// TODO Auto-generated method stub
		String hql="from AdminYearlyReportTable a group by a.year order by a.year";
		List<AdminYearlyReportTable> l=getHibernateTemplate().find(hql);
		
		return l;
	}
	
	@Override
	public List<AdminDailyReportTable> getAllMonth() {
		// TODO Auto-generated method stub
		String hql="from AdminDailyReportTable a group by a.month order by a.month";
		List<AdminDailyReportTable> l=getHibernateTemplate().find(hql);
		
		return l;
	}

	@Override
	public List<AdminYearlyReportTable> getReportByCategory(String type) {
		// TODO Auto-generated method stub
		String hql = "from AdminYearlyReportTable a where a.category=?";
		List<AdminYearlyReportTable> l = getHibernateTemplate().find(hql,type);
		return l;
	}

	@Override
	public List<AdminMonthlyReportTable> getReportByCategoryAndYear(
			String category, int year) {
		// TODO Auto-generated method stub
		String hql = "from AdminMonthlyReportTable a where a.category=? and a.year=?";
		Object[] param={category,year};
		List<AdminMonthlyReportTable> l = getHibernateTemplate().find(hql,param);
		return l;
	}

	@Override
	public List<AdminYearlyReportTable> getReportByCategoryAndYear(int year) {
		// TODO Auto-generated method stub
		String hql = "from AdminYearlyReportTable a where a.year=?";
		List<AdminYearlyReportTable> l = getHibernateTemplate().find(hql,year);
		return l.isEmpty()||l==null? null:l;
	}

	@Override
	public List<AdminMonthlyReportAllCategoryTable> getReportByYear(int year) {
		// TODO Auto-generated method stub
		String hql = "from AdminMonthlyReportAllCategoryTable a where a.year=?";
		List<AdminMonthlyReportAllCategoryTable> l = getHibernateTemplate().find(hql,year);
		return l;
	}

	@Override
	public List<AdminYearlyReportAllCategoryTable> getReportByAllCategory() {
		// TODO Auto-generated method stub
		String hql = "from AdminYearlyReportAllCategoryTable";
		List<AdminYearlyReportAllCategoryTable> l = getHibernateTemplate().find(hql);
		return l;
	}

	@Override
	public List<AdminDailyReportAllCategoryTable> getReportByYearAndMonthAndAllCategory(
			int year, String month) {
		// TODO Auto-generated method stub
		String hql = "from AdminDailyReportAllCategoryTable a where a.year=? and a.month=?";
		Object[] param = {year,month};
		List<AdminDailyReportAllCategoryTable> l = getHibernateTemplate().find(hql,param);
		return l;
	}

	@Override
	public List<AdminDailyReportTable> getReportByCategoryAndYearAndMonth(
			String category, int year, String month) {
		// TODO Auto-generated method stub
		String hql = "from AdminDailyReportTable a where a.category =? and a.year=? and a.month=?";
		Object[] param = {category,year,month};
		List<AdminDailyReportTable> l = getHibernateTemplate().find(hql,param);
		return l;
	}

	

}
