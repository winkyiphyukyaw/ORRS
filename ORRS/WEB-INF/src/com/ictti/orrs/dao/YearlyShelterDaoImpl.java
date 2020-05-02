package com.ictti.orrs.dao;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.YearlyShelterTable;

public class YearlyShelterDaoImpl extends HibernateDaoSupport implements
		YearlyShelterDao {

	@Override
	public YearlyShelterTable getAmountByDateAndCategoryAndShelter(
			Category c, Date d, String frmShelterName) {
		String hql="from YearlyShelterTable y where  y.category=? and y.year=YEAR(?) and y.shelterName=?";
		Object [] aa={c.getType(),d,frmShelterName};
		List<YearlyShelterTable> l=getHibernateTemplate().find(hql,aa);
		if(!l.isEmpty())
		System.out.println(l.size());
		
		return l.isEmpty() || l==null ? null :l.get(0);
	}

}
