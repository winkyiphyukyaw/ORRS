package com.ictti.orrs.business.service;

import java.util.List;

import com.ictti.orrs.business.entity.Event;
import com.ictti.orrs.business.entity.EventImage;
import com.ictti.orrs.dao.EventDao;
import com.ictti.orrs.dao.EventImageDao;
import com.ictti.orrs.presentation.form.EventForm;
import com.ictti.orrs.presentation.form.StoryForm;

public class StoryService {
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


	public void retrieveFile(StoryForm myForm) {
	
		List<EventImage> l=myEventImageDao.getAllStoryImage();
		
		myForm.setUserStoryList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(3);
		if(l!=null)
		myForm.setiMaxData(l.size());
		/*myForm.setBegin(0);
		if(l!=null)
			myForm.setEnd(l.size()-1);*/
	}

}
