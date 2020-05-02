package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.Orphan;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.presentation.form.ShelterOrphanForm;

public class OrphanDaoImpl extends HibernateDaoSupport implements OrphanDao {
	
	@Override
	public List<Orphan> getAllOrphanList(Shelter myloginShelter) {
		// TODO Auto-generated method stub
		String hql="from Orphan o where o.shelter=?";
		List<Orphan> l = getHibernateTemplate().find(hql,myloginShelter);
		return l.isEmpty()||l==null?null:l;
	}

	@Override
	public void insertOrphan(Orphan myOrphan) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myOrphan);	
	}

	@Override
	public Orphan getUpdateOrphanById(int id) {
		// TODO Auto-generated method stub
		String hql="from Orphan i where i.id=?";
		List<Orphan> l=getHibernateTemplate().find(hql,id);
		//getHibernateTemplate().update(l.get(0));
		return l.isEmpty()||l==null? null:l.get(0);
	}

	@Override
	public void saveUpdateOrphan(Orphan myOrphan) {
		// TODO Auto-generated method stub
		//getHibernateTemplate().update(myOrphan);
	getHibernateTemplate().saveOrUpdate(myOrphan);
	}

	@Override
	public Orphan getOrphanById(int id) {
		// TODO Auto-generated method stub
		String hql="from Orphan o where o.id=?";
		List<Orphan> l=getHibernateTemplate().find(hql,id);
		return l.isEmpty()||l==null ? null : l.get(0);
	}

	///////////////////
	

	@Override
	public Orphan getOrphanbyID(int id) {
		// TODO Auto-generated method stub
		String hql="from Orphan i where i.id=?";
		List l=getHibernateTemplate().find(hql,id);
		return l.isEmpty()||l==null? null:(Orphan)l.get(0);
	}

	

	@Override
	public void getDeleteOrphanbyId(int id) {
		// TODO Auto-generated method stub
		String hql = "from Orphan c WHERE c.id = ?";
		List<Orphan> cl = getHibernateTemplate().find(hql,id);
		getHibernateTemplate().delete(cl.get(0));
	}


	@Override
	public Orphan getOrphanbyID(ShelterOrphanForm myForm) {
		// TODO Auto-generated method stub
		String hql = "from Orphan i where i.id=?";
		List<Orphan> l = getHibernateTemplate().find(hql,myForm);
		
		return l.isEmpty()||l==null?null:l.get(0);
	}

	


	
	/*@Override
	public Orphan getShelterbyID(int parseInt) {
		// TODO Auto-generated method stub
		String hql="from Orphan o where o..id=?";
		List l=getHibernateTemplate().find(hql,parseInt);
		return l.isEmpty()||l==null? null:(Orphan)l.get(0);
	}*/
	
	
	
	//For Admin View Orphan
	
	@Override
	public List<Orphan> getAllOrphanList() {
		// TODO Auto-generated method stub
		String hql="from Orphan";		
		List<Orphan> l=getHibernateTemplate().find(hql);
		return l.isEmpty() || l==null ? null:l;
	}

	

	@Override
	public Orphan getAllOrphanByid(int id) {
		String hql="from Orphan o where o.id=?";
		List<Orphan> l=getHibernateTemplate().find(hql,id);
		return l.isEmpty()||l==null ? null:l.get(0);
	
	}

	@Override
	public List<Orphan> getOrphanByAdopterId(String orphanAge, String orphanGender) {
		// TODO Auto-generated method stub
		String hql = "from Orphan o where o.orphanAge=? and o.orphanGender=?" ;
		Object [] obj={orphanAge,orphanGender};
		List<Orphan> l = getHibernateTemplate().find(hql, obj);
		return l;
	
	}
	

	@Override
	public List<Orphan> getAllOrphanListByShelterName(
			String adminOrphanShelterName) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String hql="from Orphan o where o.shelter.shelterName=?";
				List<Orphan> l=getHibernateTemplate().find(hql,adminOrphanShelterName);
			    return l.isEmpty() || l==null ? null : l;
	}

	
	
	@Override
	public List<Orphan> getOrphanByAgeAndGender(String orphanAge, String orphanGender) {
		// TODO Auto-generated method stub
		String hql = "from Orphan o where o.orphanAge=? and o.orphanGender=?";
		Object[] obj = {orphanAge, orphanGender};
		List<Orphan> l = getHibernateTemplate().find(hql, obj);
		System.out.println(l.size());
		 return l;
	}
	
	@Override
	public Orphan getOrphanByAdopterId(int parseInt,int shelterId) {
		// TODO Auto-generated method stub
		String hql = "from Orphan o where o.adopter.id = ? and o.shelter.id=?";
		Object[] obj = {parseInt, shelterId};
		List<Orphan> l = getHibernateTemplate().find(hql, obj);
		return l.isEmpty() || l==null? null:l.get(0);
	}


}
