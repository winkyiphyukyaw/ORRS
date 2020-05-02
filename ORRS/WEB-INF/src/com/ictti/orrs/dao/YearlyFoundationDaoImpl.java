package com.ictti.orrs.dao;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.DonorCategory;
import com.ictti.orrs.business.entity.YearlyFoundationTable;

public class YearlyFoundationDaoImpl extends HibernateDaoSupport implements
		YearlyFoundationDao {

	@Override
	public YearlyFoundationTable getAmountByDateAndCategory(Category c,
			Date d) {
		// TODO Auto-generated method stub
		String hql="from YearlyFoundationTable y where  y.category=? and y.year=YEAR(?)";
		Object [] aa={c.getType(),d};
		List<YearlyFoundationTable> l=getHibernateTemplate().find(hql,aa);
		if(!l.isEmpty())
		System.out.println(l.size());
		
		return l.isEmpty() || l==null ? null :l.get(0);
	}

}
