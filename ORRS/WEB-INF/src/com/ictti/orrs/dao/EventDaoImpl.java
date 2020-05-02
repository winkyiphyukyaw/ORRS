package com.ictti.orrs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.Event;
import com.ictti.orrs.business.entity.EventImage;

public class EventDaoImpl extends HibernateDaoSupport implements EventDao {

	@Override
	public List<Event> getAllEvent() {
		// TODO Auto-generated method stub
		String hql="from EventImage e where e.event.storyEventStatus<1 order by e.event.id desc";// group by e.event.id
		List<Event> l=getHibernateTemplate().find(hql);		
		
		return l.isEmpty() || l==null? null:l;
	}

	/*@Override
	public EventImage getImageBy() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	public void saveText(Event event) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(event);
	}

	@Override
	public void saveEditText(Event myEditEvent) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myEditEvent);
	}

	@Override
	public Event getEditEventById(Integer id) {
		// TODO Auto-generated method stub
		String hql = "from event e where e.eventImages.id=?";
		List<Event> e = getHibernateTemplate().find(hql,id);
		return e.isEmpty()||e==null?null:e.get(0);
	}

	@Override
	public void savePermitStatus(Event myEditEvent) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myEditEvent);
	}


}