package com.ictti.orrs.business.service;

import java.util.List;

import com.ictti.orrs.business.entity.EventImage;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.dao.EventDao;
import com.ictti.orrs.dao.EventImageDao;



import com.ictti.orrs.presentation.form.ShelterEventForm;

public class ShelterViewEventService {
	EventDao myEventDao;   
    EventImageDao myEventImageDao;
    
	public EventDao getMyEventDao() {
		return myEventDao;
	}

	public void setMyEventDao(EventDao myEventDao) {
		this.myEventDao = myEventDao;
	}

	public EventImageDao getMyEventImageDao() {
		return myEventImageDao;
	}

	public void setMyEventImageDao(EventImageDao myEventImageDao) {
		this.myEventImageDao = myEventImageDao;
	}

	public void getAllEventsByShelter(ShelterEventForm shelterForm) {
		// TODO Auto-generated method stub
		
		
		Shelter myloginShelter = shelterForm.getLoginShelter();
	
		List<EventImage> l=myEventImageDao.getAllEventImageByShelter(myloginShelter);
			if (l==null)
			{
			 shelterForm.setShelterEventList(null);
			 shelterForm.setiMaxData(0);
			 shelterForm.setiMaxShow(0);
			 shelterForm.setActualPage(0);
			}
			else if (l!=null){
			shelterForm.setShelterEventList(l);
			shelterForm.setActualPage(1);
			shelterForm.setiMaxShow(2);
			shelterForm.setiMaxData(l.size());
			}
	     
	     
		
	}

}
