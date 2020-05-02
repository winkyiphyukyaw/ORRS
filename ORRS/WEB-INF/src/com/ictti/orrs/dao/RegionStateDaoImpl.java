package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.RegionState;

public class RegionStateDaoImpl extends HibernateDaoSupport implements
		RegionStateDao {
	public List<RegionState> getAllRegion() {
		// TODO Auto-generated method stub
		String hql = "from RegionState";
		List<RegionState> rl = getHibernateTemplate().find(hql);
		return rl;
		
	}
	
	@Override
	public RegionState getRegionById(int id) {
		// TODO Auto-generated method stub
	
		String hql="from RegionState r where r.id=?";
		List<RegionState> l=getHibernateTemplate().find(hql,id);
		return l.isEmpty() || l==null ? null : l.get(0);
	}

	@Override
	public RegionState getRegionState(Integer regid) {
		// TODO Auto-generated method stub
		String hql = "from RegionState rs where rs.id=?";
		List<RegionState> rs = getHibernateTemplate().find(hql,regid);
		return rs.isEmpty() || rs==null ? null : rs.get(0);
	}

	@Override
	public RegionState getRegionNameById(int id) {
		// TODO Auto-generated method stub
		String hql = "from RegionState rs where rs.id=?";
		List<RegionState> rs = getHibernateTemplate().find(hql,id);
		return rs.isEmpty() || rs==null ? null : rs.get(0);
	}


}
