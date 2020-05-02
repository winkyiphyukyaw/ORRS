package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.Donor;

public class DonorDaoImpl extends HibernateDaoSupport implements DonorDao {

	public Donor SaveDonor(Donor inDonor) {
		// TODO Auto-generated method stub
		String hql="from Donor";
		getHibernateTemplate().saveOrUpdate(inDonor);
		
		List<Donor> l=getHibernateTemplate().find(hql);
		l.get(l.size()-1);
		
		return l.isEmpty() || l==null ?null :l.get(l.size()-1);
	}
	
	@Override
	public List<Donor> getAllDonorList() {
		String hql="from Donor ";
		List<Donor> l=getHibernateTemplate().find(hql);
		
		return l.isEmpty() || l==null ? null : l;
	}

	@Override
	public Donor getDonorByid(int id) {
		String hql="from Donor d where d.id=?";
		//Object[] obj = {id, shelterId};
		List<Donor> l=getHibernateTemplate().find(hql,id);
		 return l.isEmpty() || l==null ? null : (Donor) l.get(0);
		
	}

}
