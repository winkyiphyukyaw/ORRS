package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.AllYearTable;
import com.ictti.orrs.business.entity.AnnualReportTable;

public class AllYearTableDaoImpl extends HibernateDaoSupport implements
		AllYearTableDao {

	@Override
	public List<AllYearTable> getFrmAllYearAllCategoryViewList(String frmAnnualId,String cid) {
		// TODO Auto-generated method stub
		String hql="from AllYearTable a where a.category=?";
		List<AllYearTable> l=getHibernateTemplate().find(hql,cid);
		System.out.println(l.size()+"====Dao");
		return l;
	}


	@Override
	public List<AllYearTable> getFrmAllYearViewList(String frmAnnualId) {
		// TODO Auto-generated method stub
		String hql="from AllYearTable";
		List<AllYearTable> l=getHibernateTemplate().find(hql);
		System.out.println(l.size()+"====Dao");
		return l;
	}


	
}
