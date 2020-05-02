package com.ictti.orrs.business.service;

import java.io.IOException;
import java.sql.Blob;
import java.util.Date;

import org.hibernate.Hibernate;

import com.ictti.orrs.business.entity.Admin;
import com.ictti.orrs.business.entity.Event;
import com.ictti.orrs.business.entity.EventImage;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.dao.AdminDao;
import com.ictti.orrs.dao.EventDao;
import com.ictti.orrs.dao.EventImageDao;
import com.ictti.orrs.dao.ShelterDao;
import com.ictti.orrs.presentation.form.ShelterEventForm;

public class ShelterEventService {
	EventDao myShelterEventDao;
	EventImageDao myShelterEventImageDao;
	AdminDao myAdminDao;
	ShelterDao myShelterDao;

	public AdminDao getMyAdminDao() {
		return myAdminDao;
	}

	public void setMyAdminDao(AdminDao myAdminDao) {
		this.myAdminDao = myAdminDao;
	}

	public ShelterDao getMyShelterDao() {
		return myShelterDao;
	}

	public void setMyShelterDao(ShelterDao myShelterDao) {
		this.myShelterDao = myShelterDao;
	}

	public EventDao getMyShelterEventDao() {
		return myShelterEventDao;
	}

	public void setMyShelterEventDao(EventDao myShelterEventDao) {
		this.myShelterEventDao = myShelterEventDao;
	}

	public EventImageDao getMyShelterEventImageDao() {
		return myShelterEventImageDao;
	}

	public void setMyShelterEventImageDao(EventImageDao myShelterEventImageDao) {
		this.myShelterEventImageDao = myShelterEventImageDao;
	}

	public void saveEvent(ShelterEventForm myForm) {
		// TODO Auto-generated method stub
		Event event = new Event();
		EventImage event_image = new EventImage();
		
		try {
			Blob bdata = Hibernate.createBlob(myForm.getFrmUploadFile()
					.getInputStream());
			event.setId(null);
			event.setEventText(myForm.getEventText());

			event.setEventDate(new Date());
			event.setEventStatus(0);
			
			event.setPermitStatus(0);
			if (myForm.getFrmEventStoryStatus().equals("0")) {
				event.setStoryEventStatus(0);
			} else {
				event.setStoryEventStatus(1);
			}
			Shelter myloginShelter = myForm.getLoginShelter();
			event.setShelter(myloginShelter);
			event.setAdmin(null);
			
			
			event_image.setImage(bdata);
			event_image.setId(null);
			//event_image.setEventVideo(bdata);
			event_image.setEvent(event);
			event_image.setEventImageName(myForm.getFrmUploadFile()
					.getFileName());
			event_image.setEventImageContentType(myForm.getFrmUploadFile()
					.getContentType());

			myShelterEventDao.saveText(event);
			myShelterEventImageDao.saveImgVideo(event_image);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
