package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.Admin;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {
	public Admin getAdminByLoginNameAndPassword(String adminLoginName,
			String adminPassword) {
		// TODO Auto-generated method stub
		String hql="from Admin i where i.adminName=? and i.adminPassword=?";
		Object[] parm={adminLoginName,adminPassword};
		List l=getHibernateTemplate().find(hql,parm);
		return l.isEmpty()||l==null? null:(Admin)l.get(0);
	}

	@Override
	public void SaveFile(Admin a) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(a);
	}

	@Override
	public List<Admin> getAllAdminList() {
		String hql="from Admin";
		List<Admin> l=getHibernateTemplate().find(hql);
		
		return l.isEmpty() || l==null ? null : l;
	}
	

	@Override
	public List<Admin> getAdminByNameAndPassword(String adminLoginName,
			String adminPassword) {
		String hql="from Admin a where a.adminName=? and a.adminPassword=?";
		Object[] parm={adminLoginName,adminPassword};
		List l=getHibernateTemplate().find(hql, parm);
		return l.isEmpty()||l==null? null:l;
	}

	@Override
	public void saveAdmin(Admin myAdmin) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myAdmin);
	}

	@Override
	public Admin getAdminByLoginNameAndPassword(int parseInt) {
		// TODO Auto-generated method stub
		String hql = "from Admin a where a.id=?";
		List<Admin> al = getHibernateTemplate().find(hql,parseInt);
		return al.isEmpty()||al==null?null:al.get(0);
	}

	@Override
	public Admin getAllAdminByid(int id) {
		// TODO Auto-generated method stub
		String hql="from Admin a where a.id=?";
		List<Admin> l=getHibernateTemplate().find(hql,id);
		return l.isEmpty()||l==null ? null:l.get(0);
	}

	@Override
	public void saveUpdateAdmin(Admin myUpdateAdmin) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myUpdateAdmin);
	}

	/*@Override
	public Admin getCheckNamebyAdminName(String adminLoginName) {
		// TODO Auto-generated method stub
		String hql="from Admin a where a.adminName=?";
		List<Admin> l=getHibernateTemplate().find(hql,adminLoginName);
		return l.isEmpty() || l==null ? null : (Admin) l.get(0);
	}*/
}
