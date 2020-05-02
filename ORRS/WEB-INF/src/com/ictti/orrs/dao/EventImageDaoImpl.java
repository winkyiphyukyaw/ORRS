package com.ictti.orrs.dao;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ictti.orrs.business.entity.Event;
import com.ictti.orrs.business.entity.EventImage;
import com.ictti.orrs.business.entity.Shelter;

public class EventImageDaoImpl extends HibernateDaoSupport implements
		EventImageDao {

	@Override
	public List<EventImage> getAllStoryImage() {
		// TODO Auto-generated method stub
		//String hql = "from EventImage";
	   String hql="from EventImage e where e.event.storyEventStatus=0 and e.event.permitStatus=1 order by e.event.id desc";//group by e.event.id
		List<EventImage> l=getHibernateTemplate().find(hql);		
		/*System.out.println(l.get(0));*/
		return l.isEmpty() || l==null? null:l;
	}
	@Override
	public List<EventImage> getAllEventImage() {
		// TODO Auto-generated method stub
		//String hql = "from EventImage";
		 String hql="from EventImage e where e.event.storyEventStatus=1 and e.event.permitStatus=1 order by e.event.id desc";//group by e.event.id
			List<EventImage> l=getHibernateTemplate().find(hql);		
			/*System.out.println(l.get(0));*/
			return l.isEmpty() || l==null? null:l;
		}
	
	
	@Override
	public void saveImgVideo(EventImage event_image) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(event_image);
	}
	@Override
	public List<EventImage> getAllEventImageByShelter(Shelter myloginShelter) {
		// TODO Auto-generated method stub
		String hql = "from EventImage e where e.event.shelter =? order by e.event.id";
		List<EventImage> l = getHibernateTemplate().find(hql,myloginShelter);
		return l.isEmpty()|| l==null?null :l;
	}
	@Override
	public List<EventImage> getAllStory() {
		// TODO Auto-generated method stub
		String hql="from EventImage e where e.event.storyEventStatus=0 order by e.event.id desc";
		List<EventImage> s = getHibernateTemplate().find(hql);
		return s.isEmpty()||s==null?null:s;
	}
	@Override
	public EventImage getAdminEventImgById(int i) {
		// TODO Auto-generated method stub
		String hql = "from EventImage em where em.id=?";
		List<EventImage> em = getHibernateTemplate().find(hql,i);
		
		return em.isEmpty()||em==null?null:em.get(0);
	}
	@Override
	public EventImage getEditEventImageById(int parseInt) {
		// TODO Auto-generated method stub
		String hql="from EventImage e where e.id=?";
		List<EventImage> e = getHibernateTemplate().find(hql,parseInt);
		
		return e.isEmpty()||e==null?null:e.get(0);
	}
	@Override
	public void saveEditImgVideo(EventImage myEditEventImage) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(myEditEventImage);
		
	}
	@Override
	public List<EventImage> getAllEvent() {
		// TODO Auto-generated method stub
		String hql = "from EventImage em where em.event.storyEventStatus=1 order by em.event.id desc";
		List<EventImage> s = getHibernateTemplate().find(hql);
		return s.isEmpty()||s==null?null:s;
			}
	@Override
	public List<EventImage> getAllStoryEvent() {
		// TODO Auto-generated method stub
		String hql = "from EventImage em order by em.event.id desc";
		List<EventImage> s = getHibernateTemplate().find(hql);
		return s.isEmpty()||s==null?null:s;
	}
	@Override
	public List<EventImage> getAllStoryByDate(Date myDate1, Date myDate2) {
		// TODO Auto-generated method stub
		String hql = "from EventImage em where em.event.storyEventStatus=0 and em.event.eventDate>=? and em.event.eventDate<=?";
		Object [] date = {myDate1,myDate2};
		List<EventImage> em = getHibernateTemplate().find(hql,date);
		return em.isEmpty()||em==null?null:em; 
	}
	@Override
	public List<EventImage> getAllEventByDate(Date myDate1, Date myDate2) {
		// TODO Auto-generated method stub
		String hql = "from EventImage em where em.event.storyEventStatus=1 and em.event.eventDate>=? and em.event.eventDate<=?";
		Object [] date = {myDate1,myDate2};
		List<EventImage> em = getHibernateTemplate().find(hql,date);
		return em.isEmpty()||em==null?null:em; 
	}
	@Override
	public List<EventImage> getAllStoryAndEventByDate(Date myDate1, Date myDate2) {
		// TODO Auto-generated method stub
		String hql = "from EventImage em where em.event.eventDate>=? and em.event.eventDate<=?";
		Object [] date = {myDate1,myDate2};
		List<EventImage> em = getHibernateTemplate().find(hql,date);
		return em.isEmpty()||em==null?null:em; 
	}
	@Override
	public List<EventImage> getAllStoryByFirstDate(Date myDate1, Date todayDate1) {
		// TODO Auto-generated method stub
		String hql = "from EventImage em where em.event.storyEventStatus=0 and em.event.eventDate>=? and em.event.eventDate<=?";
		Object [] date = {myDate1,todayDate1};
		List<EventImage> em = getHibernateTemplate().find(hql,date);
		return em.isEmpty()||em==null?null:em; 
	}
	@Override
	public List<EventImage> getAllEventByFirstDate(Date myDate1, Date todayDate1) {
		// TODO Auto-generated method stub
		String hql = "from EventImage em where em.event.storyEventStatus=1 and em.event.eventDate>=? and em.event.eventDate<=?";
		Object [] date = {myDate1,todayDate1};
		List<EventImage> em = getHibernateTemplate().find(hql,date);
		return em.isEmpty()||em==null?null:em; 
	}
	@Override
	public List<EventImage> getAllStoryAndEventByFirstDate(Date myDate1,
			Date todayDate1) {
		// TODO Auto-generated method stub
		String hql = "from EventImage em where em.event.eventDate>=? and em.event.eventDate<=?";
		Object [] date = {myDate1,todayDate1};
		List<EventImage> em = getHibernateTemplate().find(hql,date);
		return em.isEmpty()||em==null?null:em; 
	}
	@Override
	public List<EventImage> getAllStoryToSecondDate(Date myDate2) {
		// TODO Auto-generated method stub
		String hql = "from EventImage em where em.event.storyEventStatus=0 and em.event.eventDate<=?";
		
		List<EventImage> em = getHibernateTemplate().find(hql,myDate2);
		return em.isEmpty()||em==null?null:em; 
		
		
	}
	@Override
	public List<EventImage> getAllEventToSecondDate(Date myDate2) {
		// TODO Auto-generated method stub
String hql = "from EventImage em where em.event.storyEventStatus=1 and em.event.eventDate<=?";
		
		List<EventImage> em = getHibernateTemplate().find(hql,myDate2);
		return em.isEmpty()||em==null?null:em;
	}
	@Override
	public List<EventImage> getAllStoryAndEventToSecondDate(Date myDate2) {
		// TODO Auto-generated method stub
String hql = "from EventImage em where em.event.eventDate<=?";
		
		List<EventImage> em = getHibernateTemplate().find(hql,myDate2);
		return em.isEmpty()||em==null?null:em;
	}
	
	
}