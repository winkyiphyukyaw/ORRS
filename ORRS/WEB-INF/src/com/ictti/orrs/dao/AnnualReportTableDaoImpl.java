package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.AllYearTable;
import com.ictti.orrs.business.entity.AnnualReportTable;

public class AnnualReportTableDaoImpl extends HibernateDaoSupport implements
		AnnualReportTableDao {

	@Override
	public List<AnnualReportTable> getAllYear() {
		// TODO Auto-generated method stub
		String hql="from AnnualReportTable a group by a.year order by a.year";
		List<AnnualReportTable> l=getHibernateTemplate().find(hql);
		
		return l.isEmpty()||l==null? null:l;
		
	}


	@Override
	public List<AnnualReportTable> getAnnualList(String yid) {
		// TODO Auto-generated method stub
		String hql="from AnnualReportTable a where a.year=? order by a.year desc";
		
		List<AnnualReportTable> l=getHibernateTemplate().find(hql,yid);
		System.out.println(l.size()+"====Dao");
		return l;
	}


	@Override
	public List<AnnualReportTable> getAllCategoryList() {
		// TODO Auto-generated method stub
		String hql="from AnnualReportTable a group by a.category";
		List<AnnualReportTable> l=getHibernateTemplate().find(hql);
		System.out.println(l.size()+"===========CategoryDao");
		return l;
	}


	@Override
	public List<AnnualReportTable> getFrmAllYearAllCategoryList(String yid,
			String cid) {
		// TODO Auto-generated method stub
		String hql="from AnnualReportTable a where a.year=? and a.category=?";
		Object[] param={yid,cid};
		List<AnnualReportTable> l=getHibernateTemplate().find(hql,param);
		System.out.println(l.size()+"====Dao");
		return l;
	}


	@Override
	public List<AnnualReportTable> getDonorAmountCheck(String month,
			String year, String categoryid) {
		// TODO Auto-generated method stub
		String hql="from AnnualReportTable a where a.month=? and a.year=? and a.category=?";
		Object[] param={month,year,categoryid};
		List<AnnualReportTable> l=getHibernateTemplate().find(hql,param);
		System.out.println(l.size()+"====Dao");
		return l.isEmpty() || l==null? null : l;

		
	}
	
	






}