package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.Adopter;

public class AdopterDaoImpl extends HibernateDaoSupport implements AdopterDao {

	@Override
	public void saveAdopterInfo(Adopter adopterInfo) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(adopterInfo);

	}

	@Override
	public Adopter getAdoptersById(int frmDetailAdopterId) {
		// TODO Auto-generated method stub
		String hql = "from Adopter a where a.id = ?";
		List<Adopter> adopters = getHibernateTemplate().find(hql,
				frmDetailAdopterId);
		return adopters.get(0);
	}

	@Override
	public List<Adopter> getAllAdoptersList() {
		// TODO Auto-generated method stub
		String hql = "from Adopter";
		List<Adopter> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
	}

	@Override
	public List<Adopter> getAdoptedAdoptersList() {
		// TODO Auto-generated method stub
		String hql = "from Adopter a where a.adoptedChildNo > ?";
		int i = 0;
		List<Adopter> l = getHibernateTemplate().find(hql, i);
		return l.isEmpty() || l == null ? null : l;
	}

	// Admin View Orphan

	@Override
	public Adopter getAllAdopterByid(int id) {
		// TODO Auto-generated method stub
		String hql = "from Adopter a where a.id=?";
		List<Adopter> l = getHibernateTemplate().find(hql, id);
		return l.isEmpty() || l == null ? null : l.get(0);
	}

	@Override
	public List<Adopter> getAllAdopterList() {
		// TODO Auto-generated method stub
		String hql = "from Adopter c where c.adoptedChildNo = 0";

		List<Adopter> l = getHibernateTemplate().find(hql);
		// System.out.println(l.get(0));
		return l.isEmpty() || l == null ? null : l;
	}

	@Override
	public Adopter getAdopterById(int parseInt) {
		// TODO Auto-generated method stub
		String hql = "from Adopter a where a.id =?";
		List<Adopter> l = getHibernateTemplate().find(hql, parseInt);
		return l.isEmpty() || l == null ? null : l.get(0);
	}

	@Override
	public List<Adopter> getAllAdoptersListShelterId(int id) {
		// TODO Auto-generated method stub
		String hql = "from Adopter a where a.shelter.id=?";
		List<Adopter> l = getHibernateTemplate().find(hql, id);
		return l.isEmpty() || l == null ? null : l;
	}

	@Override
	public void setStatus(Adopter myAdopter) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myAdopter);

	}

	@Override
	public Adopter getStatus() {
		// TODO Auto-generated method stub
		String hql = "from Adopter ";
		List<Adopter> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l.get(0);
	}

	public List<Adopter> getAdopterNameListByPattern(String s) {
		// TODO Auto-generated method stub
		String hql = "from Adopter a where a.adopterName like ?";
		List<Adopter> l = getHibernateTemplate().find(hql, s + "%");

		return l.isEmpty() || l == null ? null : l;
	}

	@Override
	public List<Adopter> getAllAdopterName(String frmAdopterSearchName) {

		String hql = "from Adopter a where a.adopterName=?";
		List<Adopter> l = getHibernateTemplate()
				.find(hql, frmAdopterSearchName);
		return l.isEmpty() || l == null ? null : l;
	}

	@Override
	public Adopter getMailStatus() {
		// TODO Auto-generated method stub
		String hql = "from Adopter";
		List<Adopter> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l.get(0);
	}

	
	@Override
	public Adopter getAdopterInfoByNRC(String frmAdopterNRC) {
		// TODO Auto-generated method stub
		String hql="from Adopter a where a.adopterNrc=?";
		List<Adopter> l=getHibernateTemplate().find(hql,frmAdopterNRC);
		return l.isEmpty()||l==null ? null : l.get(0);
	}
}