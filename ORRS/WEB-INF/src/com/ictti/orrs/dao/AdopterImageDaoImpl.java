package com.ictti.orrs.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.AdopterImage;

public class AdopterImageDaoImpl extends HibernateDaoSupport implements
		AdopterImageDao {

	@Override
	public void saveFamilyForm(AdopterImage adopterImg) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(adopterImg);
		
	}

}