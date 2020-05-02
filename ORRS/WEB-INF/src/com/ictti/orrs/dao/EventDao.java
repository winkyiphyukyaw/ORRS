package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.Event;
import com.ictti.orrs.business.entity.EventImage;

public interface EventDao {

	 public List<Event> getAllEvent();

	//public EventImage getImageById(int parseInt);

	/*public EventImage getImageBy();*/

	public void saveText(Event event);
	
	public void saveEditText(Event myEditEvent);

	public Event getEditEventById(Integer id);

	public void savePermitStatus(Event myEditEvent);

}