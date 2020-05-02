package com.ictti.orrs.business.service;

import java.io.IOException;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts.upload.FormFile;
import org.hibernate.Hibernate;

import com.ictti.orrs.business.entity.Admin;
import com.ictti.orrs.business.entity.Event;
import com.ictti.orrs.business.entity.EventImage;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.dao.EventDao;
import com.ictti.orrs.dao.EventImageDao;
import com.ictti.orrs.presentation.form.AdminEventForm;

public class AdminEventService {
	EventDao myAdminEventDao;
	EventImageDao myAdminEventImgDao;

	public EventDao getMyAdminEventDao() {
		return myAdminEventDao;
	}

	public void setMyAdminEventDao(EventDao myAdminEventDao) {
		this.myAdminEventDao = myAdminEventDao;
	}

	public EventImageDao getMyAdminEventImgDao() {
		return myAdminEventImgDao;
	}

	public void setMyAdminEventImgDao(EventImageDao myAdminEventImgDao) {
		this.myAdminEventImgDao = myAdminEventImgDao;
	}

	public void saveEvent(AdminEventForm myForm) {
		// TODO Auto-generated method stub
		Event event = new Event();
		EventImage event_image = new EventImage();

		try {
			Blob bdata = Hibernate.createBlob(myForm.getFrmUploadFile()
					.getInputStream());
			event.setId(null);
			event.setEventText(myForm.getEventText());

			event.setEventDate(new Date());
			event.setEventStatus(1);

			event.setPermitStatus(1);
			if (myForm.getFrmEventStoryStatus().equals("0")) {
				event.setStoryEventStatus(0);
			} else {
				event.setStoryEventStatus(1);
			}
			Admin myLoginAdmin = myForm.getLoginAdmin();
			event.setAdmin(myLoginAdmin);
			event.setShelter(null);

			event_image.setImage(bdata);
			event_image.setId(null);
			// event_image.setEventVideo(bdata);
			event_image.setEvent(event);
			event_image.setEventImageName(myForm.getFrmUploadFile()
					.getFileName());
			event_image.setEventImageContentType(myForm.getFrmUploadFile()
					.getContentType());

			myAdminEventDao.saveText(event);
			myAdminEventImgDao.saveImgVideo(event_image);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * public void getAllStoryByDate(AdminEventForm myForm) { // TODO
	 * Auto-generated method stub SimpleDateFormat myFormat = new
	 * SimpleDateFormat("yyyy-MM-dd"); String date1 =
	 * myForm.getFrmSearchDate1(); String date2 = myForm.getFrmSearchDate2();
	 * Date d1,d2; try { d1 = myFormat.parse(date1); d2 = myFormat.parse(date2);
	 * myAdminEventDao.getAllStoryByDate(myForm.getLoginAdmin(),d1,d2); } catch
	 * (ParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * public void getAllEventByDate(AdminEventForm myForm) { // TODO
	 * Auto-generated method stub SimpleDateFormat myFormat = new
	 * SimpleDateFormat("yyyy-MM-dd"); String date1 =
	 * myForm.getFrmSearchDate1(); String date2 = myForm.getFrmSearchDate2();
	 * Date d1,d2; try { d1 = myFormat.parse(date1); d2 = myFormat.parse(date2);
	 * myAdminEventDao.getAllEventByDate(myForm.getLoginAdmin(),d1,d2); } catch
	 * (ParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * public void getAllStoryAndEventByDate(AdminEventForm myForm) { // TODO
	 * Auto-generated method stub SimpleDateFormat myFormat = new
	 * SimpleDateFormat("yyyy-MM-dd"); String date1 =
	 * myForm.getFrmSearchDate1(); String date2 = myForm.getFrmSearchDate2();
	 * Date d1,d2; try { d1 = myFormat.parse(date1); d2 = myFormat.parse(date2);
	 * myAdminEventDao.getAllStoryAndEventByDate(myForm.getLoginAdmin(),d1,d2);
	 * } catch (ParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public void getAllStory(AdminEventForm myForm) {
		// TODO Auto-generated method stub
		Admin myloginAdmin = myForm.getLoginAdmin();

		List<EventImage> l = myAdminEventImgDao.getAllStory();
		if (l == null) {
			System.out.println("Story List is nulll==========");
			myForm.setAdminEventList(null);
			myForm.setiMaxData(0);
			myForm.setiMaxShow(0);
			myForm.setActualPage(0);
		} else if (l != null) {
			System.out.println("Story List is exists" + l.size());
			myForm.setAdminEventList(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(2);
			myForm.setiMaxData(l.size());
		}

	}

	// public void getEditEventPage(AdminEventForm myForm) {
	// // TODO Auto-generated method stub
	// System.out.println(myForm.getFrmEditEvent());
	// EventImage
	// myem=myAdminEventImgDao.getAdminEventImgById(myForm.getLoginAdmin(),Integer.parseInt(myForm.getFrmEditEvent()));
	// // myForm.setAdminEditEventControl(myem);
	// }

	public void getEditEventPage(AdminEventForm myForm) {
		// TODO Auto-generated method stub

		EventImage myEventImage = myAdminEventImgDao
				.getAdminEventImgById(Integer.parseInt(myForm.getFrmEditEvent()));

		myForm.setEventText(myEventImage.getEvent().getEventText());
		myForm.setFrmEventStoryStatus(String.valueOf(myEventImage.getEvent()
				.getStoryEventStatus()));

		myForm.setAdminEditEventControl(null);

	}

	public void saveEditEvent(AdminEventForm myForm) {
		// TODO Auto-generated method stub

		EventImage myEditEventImage = myAdminEventImgDao
				.getEditEventImageById(Integer.parseInt(myForm
						.getFrmEditEvent()));
		System.out.println(myForm.getFrmEditEvent());
		// myEditEvent =
		// myAdminEventImgDao.getEditEventById(Integer.parseInt(myForm.getFrmEditEvent()));
		// System.out.println(myForm.getFrmEditEvent());
		Event myEditEvent = new Event();
		try {
			Blob bdata = Hibernate.createBlob(myForm.getFrmUploadFile()
					.getInputStream());
			myEditEvent.setId(myEditEventImage.getEvent().getId());

			myEditEvent.setEventText(myForm.getEventText());

			myEditEvent.setEventDate(new Date());
			myEditEvent.setEventStatus(1);

			myEditEvent.setPermitStatus(1);
			if (myForm.getFrmEventStoryStatus().equals("0")) {
				myEditEvent.setStoryEventStatus(0);
			} else {
				myEditEvent.setStoryEventStatus(1);
			}
			Admin myLoginAdmin = myForm.getLoginAdmin();
			myEditEvent.setAdmin(myLoginAdmin);
			myEditEvent.setShelter(null);

			myAdminEventDao.saveEditText(myEditEvent);
			if (myForm.getFrmUploadFile().getFileSize() != 0) {
				myEditEventImage.setEvent(myEditEvent);
				myEditEventImage.setImage(bdata);
				myEditEventImage.setId(Integer.parseInt(myForm
						.getFrmEditEvent()));
				// event_image.setEventVideo(bdata);
				myEditEventImage.setEvent(myEditEvent);
				myEditEventImage.setEventImageName(myForm.getFrmUploadFile()
						.getFileName());
				myEditEventImage.setEventImageContentType(myForm
						.getFrmUploadFile().getContentType());
				myAdminEventImgDao.saveEditImgVideo(myEditEventImage);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getAllEvent(AdminEventForm myForm) {
		// TODO Auto-generated method stub
		Admin myloginAdmin = myForm.getLoginAdmin();

		List<EventImage> l = myAdminEventImgDao.getAllEvent();
		if (l == null) {
			System.out.println("Story List is nulll==========");
			myForm.setAdminEventList(null);
			myForm.setiMaxData(0);
			myForm.setiMaxShow(0);
			myForm.setActualPage(0);
		} else if (l != null) {
			System.out.println("Story List is exists" + l.size());
			myForm.setAdminEventList(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(2);
			myForm.setiMaxData(l.size());

		}

	}

	public void getAllStoryAndEvent(AdminEventForm myForm) {
		// TODO Auto-generated method stub
		// Admin myloginAdmin = myForm.getLoginAdmin();

		List<EventImage> l = myAdminEventImgDao.getAllStoryEvent();
		if (l == null) {
			System.out.println("Story List is nulll==========");
			myForm.setAdminEventList(null);
			myForm.setiMaxData(0);
			myForm.setiMaxShow(0);
			myForm.setActualPage(0);
		} else if (l != null) {
			System.out.println("Story List is exists" + l.size());
			myForm.setAdminEventList(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(2);
			myForm.setiMaxData(l.size());

		}
	}

	public void changePermitStatus(AdminEventForm myForm) {
		// TODO Auto-generated method stub
		EventImage myEditEventImage = myAdminEventImgDao
				.getEditEventImageById(Integer.parseInt(myForm
						.getFrmUploadEvent()));
		Event myEditEvent = new Event();
		myEditEvent.setId(myEditEventImage.getEvent().getId());
		myEditEvent.setPermitStatus(1);
		myEditEvent
				.setEventStatus(myEditEventImage.getEvent().getEventStatus());
		myEditEvent.setEventText(myEditEventImage.getEvent().getEventText());
		myEditEvent.setEventDate(myEditEventImage.getEvent().getEventDate());
		myEditEvent.setStoryEventStatus(myEditEventImage.getEvent()
				.getStoryEventStatus());
		myEditEvent.setShelter(myEditEventImage.getEvent().getShelter());
		myEditEvent.setAdmin(myEditEventImage.getEvent().getAdmin());
		myAdminEventDao.savePermitStatus(myEditEvent);
		

	}

	public void getAllStoryByDate(AdminEventForm myForm, Date myDate1,
			Date myDate2) {
		// TODO Auto-generated method stub
		List<EventImage> l = myAdminEventImgDao.getAllStoryByDate(myDate1,
				myDate2);
		if (l == null) {
			System.out.println("Story List is nulll==========");
			myForm.setAdminEventList(null);
			myForm.setiMaxData(0);
			myForm.setiMaxShow(0);
			myForm.setActualPage(0);
		} else if (l != null) {
			System.out.println("Story List is exists" + l.size());
			myForm.setAdminEventList(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(2);
			myForm.setiMaxData(l.size());

		}

	}

	public void getAllEventByDate(AdminEventForm myForm, Date myDate1,
			Date myDate2) {
		// TODO Auto-generated method stub
		List<EventImage> l = myAdminEventImgDao.getAllEventByDate(myDate1,
				myDate2);
		if (l == null) {
			System.out.println("Story List is nulll==========");
			myForm.setAdminEventList(null);
			myForm.setiMaxData(0);
			myForm.setiMaxShow(0);
			myForm.setActualPage(0);
		} else if (l != null) {
			System.out.println("Story List is exists" + l.size());
			myForm.setAdminEventList(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(2);
			myForm.setiMaxData(l.size());

		}

	}

	public void getAllStoryAndEventByDate(AdminEventForm myForm, Date myDate1,
			Date myDate2) {
		// TODO Auto-generated method stub
		List<EventImage> l = myAdminEventImgDao.getAllStoryAndEventByDate(
				myDate1, myDate2);
		if (l == null) {
			System.out.println("Story List is nulll==========");
			myForm.setAdminEventList(null);
			myForm.setiMaxData(0);
			myForm.setiMaxShow(0);
			myForm.setActualPage(0);

		} else if (l != null) {
			System.out.println("Story List is exists" + l.size());
			myForm.setAdminEventList(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(2);
			myForm.setiMaxData(l.size());

		}

	}

	public void getAllStoryByFirstDate(AdminEventForm myForm, Date myDate1,
			Date todayDate1) {
		// TODO Auto-generated method stub
		List<EventImage> l = myAdminEventImgDao.getAllStoryByFirstDate(myDate1,
				todayDate1);
		if (l == null) {
			System.out.println("Story List is nulll==========");
			myForm.setAdminEventList(null);
			myForm.setiMaxData(0);
			myForm.setiMaxShow(0);
			myForm.setActualPage(0);

		} else if (l != null) {
			System.out.println("Story List is exists" + l.size());
			myForm.setAdminEventList(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(2);
			myForm.setiMaxData(l.size());

		}

	}

	public void getAllEventByFirstDate(AdminEventForm myForm, Date myDate1,
			Date todayDate1) {
		// TODO Auto-generated method stub
		List<EventImage> l = myAdminEventImgDao.getAllEventByFirstDate(myDate1,
				todayDate1);
		if (l == null) {
			System.out.println("Story List is nulll==========");
			myForm.setAdminEventList(null);
			myForm.setiMaxData(0);
			myForm.setiMaxShow(0);
			myForm.setActualPage(0);

		} else if (l != null) {
			System.out.println("Story List is exists" + l.size());
			myForm.setAdminEventList(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(2);
			myForm.setiMaxData(l.size());

		}

	}

	public void getAllStoryAndEventByFirstDate(AdminEventForm myForm,
			Date myDate1, Date todayDate1) {
		// TODO Auto-generated method stub
		List<EventImage> l = myAdminEventImgDao.getAllStoryAndEventByFirstDate(
				myDate1, todayDate1);
		if (l == null) {
			System.out.println("Story List is nulll==========");
			myForm.setAdminEventList(null);
			myForm.setiMaxData(0);
			myForm.setiMaxShow(0);
			myForm.setActualPage(0);

		} else if (l != null) {
			System.out.println("Story List is exists" + l.size());
			myForm.setAdminEventList(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(2);
			myForm.setiMaxData(l.size());

		}

	}

	public void getAllStoryToSecondDate(AdminEventForm myForm, Date myDate2) {
		// TODO Auto-generated method stub
		List<EventImage> l = myAdminEventImgDao
				.getAllStoryToSecondDate(myDate2);
		if (l == null) {
			System.out.println("Story List is nulll==========");
			myForm.setAdminEventList(null);
			myForm.setiMaxData(0);
			myForm.setiMaxShow(0);
			myForm.setActualPage(0);

		} else if (l != null) {
			System.out.println("Story List is exists" + l.size());
			myForm.setAdminEventList(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(2);
			myForm.setiMaxData(l.size());

		}

	}

	public void getAllEventToSecondDate(AdminEventForm myForm, Date myDate2) {
		// TODO Auto-generated method stub
		List<EventImage> l = myAdminEventImgDao
				.getAllEventToSecondDate(myDate2);
		if (l == null) {
			System.out.println("Story List is nulll==========");
			myForm.setAdminEventList(null);
			myForm.setiMaxData(0);
			myForm.setiMaxShow(0);
			myForm.setActualPage(0);

		} else if (l != null) {
			System.out.println("Story List is exists" + l.size());
			myForm.setAdminEventList(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(2);
			myForm.setiMaxData(l.size());

		}

	}

	public void getAllStoryAndEventToSecondDate(AdminEventForm myForm,
			Date myDate2) {
		// TODO Auto-generated method stub
		List<EventImage> l = myAdminEventImgDao
				.getAllStoryAndEventToSecondDate(myDate2);
		if (l == null) {
			System.out.println("Story List is nulll==========");
			myForm.setAdminEventList(null);
			myForm.setiMaxData(0);
			myForm.setiMaxShow(0);
			myForm.setActualPage(0);

		} else if (l != null) {
			System.out.println("Story List is exists" + l.size());
			myForm.setAdminEventList(l);
			myForm.setActualPage(1);
			myForm.setiMaxShow(2);
			myForm.setiMaxData(l.size());

		}

	}

}
