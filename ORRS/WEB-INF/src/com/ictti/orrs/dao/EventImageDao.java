package com.ictti.orrs.dao;

import java.util.Date;
import java.util.List;

import com.ictti.orrs.business.entity.EventImage;
import com.ictti.orrs.business.entity.Shelter;

public interface EventImageDao {

	List<EventImage> getAllStoryImage();
	List<EventImage> getAllEventImage();
	void saveImgVideo(EventImage event_image);
	List<EventImage> getAllEventImageByShelter(Shelter myloginShelter);
	//List<EventImage> getAllStory(Admin loginAdmin);
		EventImage getAdminEventImgById(int i);
		EventImage getEditEventImageById(int parseInt);
		void saveEditImgVideo(EventImage myEditEventImage);
		List<EventImage> getAllStory();
		List<EventImage> getAllEvent();
		List<EventImage> getAllStoryEvent();
		List<EventImage> getAllStoryByDate(Date myDate1, Date myDate2);
		List<EventImage> getAllEventByDate(Date myDate1, Date myDate2);
		List<EventImage> getAllStoryAndEventByDate(Date myDate1, Date myDate2);
		List<EventImage> getAllStoryByFirstDate(Date myDate1, Date todayDate1);
		List<EventImage> getAllEventByFirstDate(Date myDate1, Date todayDate1);
		List<EventImage> getAllStoryAndEventByFirstDate(Date myDate1,
				Date todayDate1);
		List<EventImage> getAllStoryToSecondDate(Date myDate2);
		List<EventImage> getAllEventToSecondDate(Date myDate2);
		List<EventImage> getAllStoryAndEventToSecondDate(Date myDate2);
}