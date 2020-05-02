package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.ShelterDailyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterDailyReportTable;
import com.ictti.orrs.business.entity.ShelterMonthlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterMonthlyReportTable;
import com.ictti.orrs.business.entity.ShelterYearlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterYearlyReportTable;

public class ShelterReportTableDaoImpl extends HibernateDaoSupport implements
		ShelteReportTableDao {

	@Override
	public List<ShelterMonthlyReportTable> getAllYear() {
		// TODO Auto-generated method stub
		String hql="from ShelterYearlyReportTable s group by s.year order by s.year";
		List<ShelterMonthlyReportTable> l=getHibernateTemplate().find(hql);
		
		return l.isEmpty()||l==null? null:l;
	}

	@Override
	public List<ShelterYearlyReportTable> searchByCategoryAndSno(
			String category, int shelterId) {
		// TODO Auto-generated method stub
		String hql = "from ShelterYearlyReportTable s where s.category=? and s.shelterId=?";
		Object[] param={category,shelterId};
		List<ShelterYearlyReportTable> l = getHibernateTemplate().find(hql,param);
		return l;
	}



	@Override
	public List<ShelterMonthlyReportTable> searchByYearAndCategoryAndSno(
			int year, String category, int shelterId) {
		// TODO Auto-generated method stub
		String hql = "from ShelterMonthlyReportTable s where s.year=? and s.category=? and s.shelterId=?";
		Object[] param={year,category,shelterId};
		List<ShelterMonthlyReportTable> l = getHibernateTemplate().find(hql,param);
		return l;
	}

	@Override
	public List<ShelterYearlyReportTable> searchByYearAndShelter(int year, int sno) {
		// TODO Auto-generated method stub
		String hql = "from ShelterYearlyReportTable s where s.year=? and s.shelterId=?";
		Object[] param={year,sno};
		List<ShelterYearlyReportTable> l = getHibernateTemplate().find(hql,param);
		return l;
	}

	@Override
	public List<ShelterYearlyReportAllCategoryTable> searchBySno(int shelterId) {
		// TODO Auto-generated method stub
		String hql = "from ShelterYearlyReportAllCategoryTable s where s.shelterId=?";
		List<ShelterYearlyReportAllCategoryTable> l = getHibernateTemplate().find(hql,shelterId);

		return l;
	}

	@Override
	public List<ShelterMonthlyReportAllCategoryTable> searchByYearAndSno(
			int year, int shelterId) {
		// TODO Auto-generated method stub
		String hql = "from ShelterMonthlyReportAllCategoryTable s where s.year=? and s.shelterId=?";
		Object[] param = {year,shelterId};
		List<ShelterMonthlyReportAllCategoryTable> l = getHibernateTemplate().find(hql,param);

		return l;
	}

	

	@Override
	public List<ShelterDailyReportTable> searchByYearAndMonthAndCategoryAndSno(
			int year, String month, String category, int shelterId) {
		// TODO Auto-generated method stub
		String hql = "from ShelterDailyReportTable s where s.year=? and s.month=? and s.category=? and s.shelterId=?";
		Object[] param = {year,month,category,shelterId};
		List<ShelterDailyReportTable> l = getHibernateTemplate().find(hql,param);

		return l;
	}

	@Override
	public List<ShelterDailyReportAllCategoryTable> AllCategoryAndYearAndMonthAndShelter(
			int year, String month, int shelterId) {
		// TODO Auto-generated method stub
		String hql = "from ShelterDailyReportAllCategoryTable s where s.year=? and s.month=? and s.shelterId=?";
		Object[] param = {year,month,shelterId};

		List<ShelterDailyReportAllCategoryTable> l = getHibernateTemplate().find(hql,param);

		return l;
	}



}
