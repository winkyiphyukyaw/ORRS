package com.ictti.orrs.business.service;

import java.util.List;

import com.ictti.orrs.business.entity.Event;
import com.ictti.orrs.business.entity.EventImage;
import com.ictti.orrs.dao.EventDao;
import com.ictti.orrs.dao.EventImageDao;
import com.ictti.orrs.presentation.form.EventForm;

public class EventService {
     EventDao myEventDao;   
     EventImageDao myEventImageDao;
     
     
     
	public EventImageDao getMyEventImageDao() {
		return myEventImageDao;
	}


	public void setMyEventImageDao(EventImageDao myEventImageDao) {
		this.myEventImageDao = myEventImageDao;
	}


	public EventDao getMyEventDao() {
		return myEventDao;
	}


	public void setMyEventDao(EventDao myEventDao) {
		this.myEventDao = myEventDao;
	}



	/*public void getAllEvent(EventForm myForm) {
		// TODO Auto-generated method stub
		
	List<Event>	l=myEventDao.getAllEvent();
	myForm.setUserEventList(l);
	
	}*/


	public void retrieveFile(EventForm myForm) {
		// TODO Auto-generated method stub
		//System.out.println("Null?");
		List<EventImage> l=myEventImageDao.getAllEventImage();
	//	myForm.setEventFile(e);
		myForm.setUserEventList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(3);
	 //	myForm.setBegin(0);
		//if(l!=null)
		//	myForm.setEnd(l.size());
		//myForm.setEventFile(l.get(0));
		//System.out.println(l.size());
		if(l!=null)
			myForm.setiMaxData(l.size());
		
		
	}

}
