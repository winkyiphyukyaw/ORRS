package com.ictti.orrs.business.service;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.ictti.orrs.business.entity.Adopter;
import com.ictti.orrs.business.entity.Orphan;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.dao.AdopterDao;
import com.ictti.orrs.dao.OrphanDao;
import com.ictti.orrs.dao.ShelterDao;
import com.ictti.orrs.presentation.form.AdminAdopterForm;
import com.ictti.orrs.util.MailConfig;
import com.ictti.orrs.util.OrphanCount;

public class AdopterViewService {
	AdopterDao myAdopterDao;
	OrphanDao myOrphanDao;
	ShelterDao myShelterDao;

	public ShelterDao getMyShelterDao() {
		return myShelterDao;
	}

	public void setMyShelterDao(ShelterDao myShelterDao) {
		this.myShelterDao = myShelterDao;
	}

	

	public String getOrphanAge() {
		return orphanAge;
	}

	public void setOrphanAge(String orphanAge) {
		this.orphanAge = orphanAge;
	}

	public String getOrphanGender() {
		return orphanGender;
	}

	public void setOrphanGender(String orphanGender) {
		this.orphanGender = orphanGender;
	}

	public OrphanDao getMyOrphanDao() {
		return myOrphanDao;
	}

	public void setMyOrphanDao(OrphanDao myOrphanDao) {
		this.myOrphanDao = myOrphanDao;
	}

	public AdopterDao getMyAdopterDao() {
		return myAdopterDao;
	}

	public void setMyAdopterDao(AdopterDao myAdopterDao) {
		this.myAdopterDao = myAdopterDao;
	}

	public void getAllAdopterList(AdminAdopterForm myForm) {
		// TODO Auto-generated method stub
		List<Adopter> l = myAdopterDao.getAllAdopterList();
		myForm.setFrmAdopterList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(10);
		if (l != null)
			myForm.setiMaxData(l.size());
	}

	String  orphanAge;
	String orphanGender = null;
	public void getAdopterById(AdminAdopterForm myForm) {
		// TODO Auto-generated method stub
		Adopter a = myAdopterDao.getAdopterById(Integer.parseInt(myForm
				.getFrmDetailAdopterId()));
		myForm.setFrmAdopterDetail(a);
		myForm.setFrmAdopterName(a.getAdopterName());
		myForm.setFrmAdopterEmail(a.getAdopterEmail());

		orphanAge = a.getAdopterOrphanAge();
		orphanGender = a.getAdopterOrphanGender();
		System.out.println(orphanAge);
		System.out.println(orphanGender);
		List<Orphan> OrphanAdopter = myOrphanDao.getOrphanByAdopterId(
				orphanAge, orphanGender);
		
		if (!OrphanAdopter.isEmpty()) {
			HashMap<Integer, List<Orphan>> hashMap = new HashMap<Integer, List<Orphan>>();

			for (Orphan orphan : OrphanAdopter) {
				// System.out.println("ID : "+student.id+"\t"+"Name : "+student.name+"\t"+"Location : "+student.location);

				if (!hashMap.containsKey(orphan.getShelter().getId())) {
					List<Orphan> myOrphanlist = new ArrayList<Orphan>();
					myOrphanlist.add(orphan);
					hashMap.put(orphan.getShelter().getId(), myOrphanlist);

				} else {
					hashMap.get(orphan.getShelter().getId()).add(orphan);
				}

			}
			Iterator it = hashMap.entrySet().iterator();
			List<OrphanCount> oclist = new ArrayList<>();
			int i = 0;
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				OrphanCount oc = new OrphanCount();
				int count = ((List<Orphan>) pair.getValue()).size();
				oc.setCount(count);
				oc.setSid((int) pair.getKey());
				System.out.println("Key is" + (int) pair.getKey());
				Shelter s = myShelterDao.getShelterId((int) pair.getKey());
				oc.setSname(s.getShelterName());
				oclist.add(i, oc);
				System.out.println(pair.getKey() + " = "
						+ ((List<Orphan>) pair.getValue()).size());
				it.remove(); // avoids a ConcurrentModificationException
				i++;

			}

			// System.out.println(oclist.get(0).getCount());

			/* System.out.println(OrphanAdopter.size()); */
			System.out.println(OrphanAdopter.get(0).getShelter());
			myForm.setFrmOrphanNo(OrphanAdopter.size());
			// myForm.setFrmOrphanDetail(OrphanAdopter);
			myForm.setFrmOrphanTotalList(oclist);
			System.out.println("Size is" + oclist.size());
			myForm.setBegin(1);
			if (oclist != null)
				myForm.setEnd(oclist.size() - 1);
		}
	}

	public void prepareForMail(AdminAdopterForm myForm) {
		// TODO Auto-generated method stub

		String strFrom = "ORRSAdmin@ictti.site";
		String strSubject = "Information for you";
		String strContent = new String();
		try {
			VelocityEngine engine = new VelocityEngine();
			
			Properties properties = new Properties();
			properties.setProperty(VelocityEngine.RESOURCE_LOADER, "classpath");
			properties.setProperty("classpath."
					+ VelocityEngine.RESOURCE_LOADER + ".class",
					ClasspathResourceLoader.class.getName());
			
			//1
			engine.init(properties);			
			
			//4 get template under the WEB-INF/src
			Template tm = engine.getTemplate("mailTemplate.vm");
			
			//2
			VelocityContext vc = new VelocityContext();
			
			//3
			// Put job list
			vc.put("name", myForm.getFrmAdopterName());
			// Put today's date
			String today = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date()).toString();
			vc.put("today", today);
			List<Orphan> OrphanAdopter = myOrphanDao.getOrphanByAdopterId(orphanAge, orphanGender);
			vc.put("Age",orphanAge);
			vc.put("Gender",orphanGender );
			vc.put("size", OrphanAdopter.size());
			vc.put("oList", OrphanAdopter);
			StringWriter sw = new StringWriter();
			
			//5
			tm.merge(vc, sw);
			strContent = sw.toString();
			if (strContent != null) {
				// Create an email object
								MailConfig smtpMailSender = new MailConfig();
				smtpMailSender.sendToOne(myForm.getFrmAdopterEmail(), strSubject,
						strContent, strFrom);
				myForm.setFrmMailMessage("Mail can send successfully");
			} else {
				myForm.setFrmMailMessage("Mail cannot send because the	message is null.");
			}
		} catch (Exception e) {
			myForm.setFrmMailMessage("Mail cannot send.");
		}		
			
	}
	
	public List<Adopter> findAdopterByLikeFromService(String s)
	{
		List<Adopter> l=myAdopterDao.getAdopterNameListByPattern(s);
		return l;
	}

	public void getAllAdopterByAdopterName(AdminAdopterForm myForm) {
		// TODO Auto-generated method stub
		List<Adopter> l=myAdopterDao.getAllAdopterName(myForm.getFrmAdopterSearchName());
		myForm.setFrmAdopterList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(5);
		if (l != null)
			myForm.setiMaxData(l.size());
		
		
	}

	public void Mail(AdminAdopterForm myForm) {
		// TODO Auto-generated method stub
		
		
	}

	public Adopter getMailStatus() {
		// TODO Auto-generated method stub
		Adopter mailStatus = myAdopterDao.getMailStatus();
		return mailStatus;
	}

	public void setMailStaus(AdminAdopterForm myForm) {
		// TODO Auto-generated method stub
		Adopter myAdopter = myAdopterDao.getAdopterById(Integer.parseInt(myForm.getFrmDetailAdopterId()));
		//Update
		myAdopter.setMailStatus(1);
		myAdopterDao.saveAdopterInfo(myAdopter);
		myForm.setFrmAdopterDetail(myAdopter);
		
		
	}

	



}
