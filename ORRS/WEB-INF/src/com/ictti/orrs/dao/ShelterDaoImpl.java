package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;











import com.ictti.orrs.business.entity.Shelter;

public class ShelterDaoImpl extends HibernateDaoSupport implements ShelterDao {

	public List<Shelter> getAllShelter(String s) {
		// TODO Auto-generated method stub
		String hql="from Shelter i where i.shelterName like ?";
		List<Shelter> l=getHibernateTemplate().find(hql,s+"%");
/*		System.out.println(l.get(0).getId()+l.get(0).getShelterName());
*/		return l.isEmpty() || l==null ? null : l;
	
		
	}

	

	public Shelter getShelterByShelterName(String frmShelterName) {
		// TODO Auto-generated method stub
		String hql="from Shelter i where i.shelterName=?";
		List<Shelter> l=getHibernateTemplate().find(hql,frmShelterName);
		return l.isEmpty() || l==null ?null :l.get(0) ;
	}



	public Shelter checkShelterBySName(String frmShelterName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	List<Shelter> l;
	@Override
	public List<Shelter> getSheltersByRegionAndCityAndShelter(int rid, int cid,int sid) {//choose all
		// TODO Auto-generated method stub
		String hql = "from Shelter s where s.city.regionState.id=? and s.city.id=? and s.id=?";
		Object[] param = {rid,cid,sid};
		l = getHibernateTemplate().find(hql,param);
		return  l;
	}
	@Override
	public List<Shelter> getAllShelters() {//not choose all
		// TODO Auto-generated method stub
		String hql = "from Shelter";
		l = getHibernateTemplate().find(hql);
		return l;
	}
	
	@Override
	public List<Shelter> getSheltersByRegion(int rid) {//choose region
		
		String hql = "from Shelter s where s.city.regionState.id=?";
		l = getHibernateTemplate().find(hql,rid);
		return l;
		}
	
	@Override
	public List<Shelter> getSheltersByCity(int cid) {//choose city
		// TODO Auto-generated method stub
		
		String hql = "from Shelter s where s.city.id=?";
		l = getHibernateTemplate().find(hql,cid);
		return l;
	}
	
	@Override
	public List<Shelter> getSheltersByShelter(int sid) {//choose shelter
		// TODO Auto-generated method stub
		String hql = "from Shelter s where s.id=?";
		l = getHibernateTemplate().find(hql,sid);
		return l;
	}
	
	@Override
	public List<Shelter> getSheltersByRegionandCity(int rid, int cid) {//choose region and city
		// TODO Auto-generated method stub
		String hql = "from Shelter s where s.city.regionState.id=? and s.city.id=?";
		Object[] param = {rid,cid};
		l = getHibernateTemplate().find(hql,param);
		return l;
	}

	@Override
	public List<Shelter> getSheltersByRegionAndShelter(int rid,int sid) {//choose region and shelter
		// TODO Auto-generated method stub
		String hql = "from Shelter s where s.city.regionState.id=? and s.id=?";
		Object[] param = {rid,sid};
		l= getHibernateTemplate().find(hql,param);
		return l;
	}

	@Override
	public List<Shelter> getSheltersByCityandShelter(int cid,int sid) {//choose city and shelter
		// TODO Auto-generated method stub
		String hql = "from Shelter s where s.city.id=? and s.id=?";
		Object[] param = {cid,sid};
		l = getHibernateTemplate().find(hql,param);
		return l;
	}
	
	@Override
	public Shelter getShelterByDetailId(int sid) {
		// TODO Auto-generated method stub
		String hql = "from Shelter s where s.id=?";
		l = getHibernateTemplate().find(hql,sid);
		return l.get(0);
	}

	
	//For Shelter Page
	
	@Override
	public void saveShelter(Shelter myShelter) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myShelter);
	}



	@Override
	public Shelter getShelterByLoginName(String shelterRegLoginName) {
		// TODO Auto-generated method stub
		String hql="from Shelter i where i.shelterLoginName=?";
		List l=getHibernateTemplate().find(hql,shelterRegLoginName);
		return l.isEmpty() || l==null ? null : (Shelter) l.get(0);
	}



	@Override
	public Shelter getShelterByLoginNameAndPassword(String shelterLoginName,
			String shelterPassword) {
		// TODO Auto-generated method stub
		String hql="from Shelter s where s.shelterLoginName=? and s.shelterLoginPassword=?";
		Object[] param={shelterLoginName,shelterPassword};
		List l=getHibernateTemplate().find(hql,param);
		return (Shelter) (l.isEmpty() || l==null? null:l.get(0));
	}



	@Override
	public Shelter getShelterId(int id) {
		// TODO Auto-generated method stub
		String hql = "from Shelter s where s.id=?";
		List l = getHibernateTemplate().find(hql,id);
		return (Shelter) (l.isEmpty()||l==null?null:l.get(0));
		
	}
	public Shelter getShelterbyID() {
		// TODO Auto-generated method stub
		String hql="from Shelter";
		List l=getHibernateTemplate().find(hql);
		return l.isEmpty()||l==null? null:(Shelter)l.get(0);
	}



	@Override
	public Shelter getShelterById(int id) {
		// TODO Auto-generated method stub
		String hql="from Shelter s where s.id=?";
		List<Shelter> sl = getHibernateTemplate().find(hql,id);
		return sl.isEmpty()||sl==null?null:sl.get(0);
	}
	
	@Override
	public List<Shelter> getShelterNameListByPattern(String s) {
		String hql="from Shelter s where s.shelterName like ?";
		List<Shelter> l=getHibernateTemplate().find(hql,s+"%");
		
		return l.isEmpty() || l==null ? null:l;
	}



}
