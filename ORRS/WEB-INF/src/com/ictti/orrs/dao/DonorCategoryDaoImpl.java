package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.DonorCategory;

public class DonorCategoryDaoImpl extends HibernateDaoSupport implements
		DonorCategoryDao {

	public void SaveDonorCategory(DonorCategory inDonorCategory) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(inDonorCategory);
	}
	
	
	
	@Override
	public List<DonorCategory> getAllDonorList() {
		String hql="from DonorCategory dc group by dc.donor.donorNrc";
		List<DonorCategory> l=getHibernateTemplate().find(hql);
		
		return l.isEmpty() || l==null ? null : l;
	}
	@Override
	public List<DonorCategory> getDonorCategoryByNRC(int detailDonorId) {
		// TODO Auto-generated method stub
		String hql="from DonorCategory dc where dc.donor.id=?";
		//Object[] obj = {id, shelterId};
		List<DonorCategory> l=getHibernateTemplate().find(hql,detailDonorId);
		 return l.isEmpty() || l==null ? null : l;
	}
	
	@Override
	public List<DonorCategory> getAllDonor(String s) {
	
			// TODO Auto-generated method stub
			String hql="from DonorCategory dc where dc.donor.donorName like ? group by dc.donor.donorNrc";
			List<DonorCategory> l=getHibernateTemplate().find(hql,s+"%");
	/*		System.out.println(l.get(0).getId()+l.get(0).getShelterName());
	*/		return l.isEmpty() || l==null ? null : l;
		
		
	}
}
