package com.ictti.orrs.dao;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.DonorShelter;

public class DonorShelterDaoImpl extends HibernateDaoSupport implements
		DonorShelterDao {

	public void SaveDonorShelter(DonorShelter inDonorShelter) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(inDonorShelter);
	}
	
	

	@Override
	public List<DonorShelter> getAllDateForMealByShelterId(int sid,Date d) {
		// TODO Auto-generated method stub
		
		String hql = "from DonorShelter ds where  ds.shelter.id=? and ds.donateMealDate=? ";
		Object[] obj={ sid,d};
		List<DonorShelter> l = getHibernateTemplate().find(hql,obj);
		
		return l;
	}
	
	@Override
	public List<DonorShelter> getDonorListbyShelter(int sid) {
		// TODO Auto-generated method stub
		String hql="from DonorShelter ds where ds.shelter.id=? group by ds.donor.donorNrc";
		List<DonorShelter> l=getHibernateTemplate().find(hql,sid);
		return l.isEmpty() || l==null ? null : l;
	}
	
	@Override
	public List<DonorShelter> getAllDonorListByShelterName( String donorShelterName) {
		// TODO Auto-generated method stub
		String hql="from DonorShelter ds where ds.donor.donorName like ? group by ds.donor.donorNrc";
		
		List<DonorShelter> l=getHibernateTemplate().find(hql,donorShelterName+"%");
		
		return l.isEmpty() || l==null ? null:l;
	}

	@Override
	public List<DonorShelter> getDonorShelterByNRC(String donorNRC) {
		// TODO Auto-generated method stub
		String hql="from DonorShelter ds where ds.donor.donorNrc=?";
		//Object[] obj = {id, shelterId};
		List<DonorShelter> l=getHibernateTemplate().find(hql,donorNRC);
		 return l.isEmpty() || l==null ? null : l;
	}

	@Override
	public List<DonorShelter> getAllDonor(String s) {
	
			// TODO Auto-generated method stub
			String hql="from DonorShelter ds where ds.donor.donorName like ? group by ds.donor.donorNrc";
			List<DonorShelter> l=getHibernateTemplate().find(hql,s+"%");
	/*		System.out.println(l.get(0).getId()+l.get(0).getShelterName());
	*/		return l.isEmpty() || l==null ? null : l;
		
		
	}

	@Override
	public List<DonorShelter> getAllDonorList() {
		// TODO Auto-generated method stub
		String hql="from DonorShelter ds group by ds.donor.donorNrc";
		List<DonorShelter> l=getHibernateTemplate().find(hql);
		
		return l.isEmpty() || l==null ? null : l;
	}
}
