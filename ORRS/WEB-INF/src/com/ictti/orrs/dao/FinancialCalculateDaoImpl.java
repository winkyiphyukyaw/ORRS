package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.FinancialCalculate;

public class FinancialCalculateDaoImpl extends HibernateDaoSupport implements
		FinancialCalculateDao {
	@Override
	public void saveFinancialOutcome(FinancialCalculate myFinancial) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myFinancial);
	}

	@Override
	public List<FinancialCalculate> getAllFinancialAmountList() {
		// TODO Auto-generated method stub
		String hql="from FinancialCalculate";
		List<FinancialCalculate> l=getHibernateTemplate().find(hql);
		return l.isEmpty()||l==null ? null : l;
	}

	@Override
	public FinancialCalculate geFinancialProfilebyId(int id) {
		// TODO Auto-generated method stub
		String hql="from FinancialCalculate f where f.id=?";
		List<FinancialCalculate> l=getHibernateTemplate().find(hql,id);
		return l.isEmpty() || l==null ? null : (FinancialCalculate) l.get(0);
	}

	@Override
	public void saveUpdateFinancialOutcome(FinancialCalculate myFinancial) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myFinancial);
	}

}
