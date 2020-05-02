package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.City;

public class CityDaoImpl extends HibernateDaoSupport implements CityDao {
	List<City> cl;
	@Override
	public List<City> getCityByRegionId(int id) {
		// TODO Auto-generated method stub
		String hql = "from City c where c.regionState.id=?";
		cl = getHibernateTemplate().find(hql,id);
		return cl;
	}

	@Override
	public List<City> getAllCity() {
		// TODO Auto-generated method stub
		String hql = "from City";
		cl = getHibernateTemplate().find(hql);
		return cl;
	}
	
	@Override
	public List<City> getSubcityByRegionId(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String hql="from City c where c.regionState.id=?";
				List<City> l=getHibernateTemplate().find(hql,id);
				return l.isEmpty() || l==null ? null:l;
	}

	@Override
	public City getCityByCityId(int parseInt) {
		// TODO Auto-generated method stub
		String hql="from City c where c.id=?";
		List<City> l=getHibernateTemplate().find(hql,parseInt);
		return l.isEmpty() || l==null ? null:l.get(0);
	}

	//check city name
	@Override
	public City getCityByCityName(String frmCityName, int id) {
		// TODO Auto-generated method stub
		String hql="from City c where c.name=? and c.regionState.id=?";
		Object[] param={frmCityName,id};
		List<City> l=getHibernateTemplate().find(hql,param);
		return l.isEmpty() || l==null ? null : (City) l.get(0);
	}

	//add city
	@Override
	public void addNewCity(City mycity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(mycity);
	}

	@Override
	public List<City> getCityNamebyRegionId(int id) {
		// TODO Auto-generated method stub
		String hql="from City c where c.regionState.id=?";
		List<City> l=getHibernateTemplate().find(hql,id);
		return l.isEmpty() || l==null ? null:l;
	}

	@Override
	public void saveUpdateCity(City myCity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myCity);
	}

	@Override
	public City getCityByCityNameExist(String frmCityName, int parseInt) 
	{
		// TODO Auto-generated method stub
		String hql="from City c where c.name=? and c.regionState.id=?";
		Object[] param={frmCityName,parseInt};
		List<City> l=getHibernateTemplate().find(hql,param);
		return l.isEmpty() || l==null ? null : (City) l.get(0);
	}

	@Override
	public City getCityNameById(int id ) {
		// TODO Auto-generated method stub
		String hql = "from City c where c.id=?";
		List<City> l = getHibernateTemplate().find(hql,id);
		return l.isEmpty()||l==null?null:l.get(0);
	}
}
