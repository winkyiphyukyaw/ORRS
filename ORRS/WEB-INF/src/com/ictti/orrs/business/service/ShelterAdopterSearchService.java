package com.ictti.orrs.business.service;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;








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
import com.ictti.orrs.presentation.form.ShelterAdopterSearchForm;
import com.ictti.orrs.util.MailConfig;


public class ShelterAdopterSearchService {
	AdopterDao myAdopterDao;
	OrphanDao myOrphanDao;
	public AdopterDao getMyAdopterDao() {
		return myAdopterDao;
	}

	public void setMyAdopterDao(AdopterDao myAdopterDao) {
		this.myAdopterDao = myAdopterDao;
	}
	
	public OrphanDao getMyOrphanDao() {
		return myOrphanDao;
	}

	public void setMyOrphanDao(OrphanDao myOrphanDao) {
		this.myOrphanDao = myOrphanDao;
	}

	String orphanAge = null;
	String orphanGender = null;
	public void getAdopterById(ShelterAdopterSearchForm myForm) {
		// TODO Auto-generated method stub
		Adopter adopters = myAdopterDao.getAdoptersById(Integer.parseInt(myForm.getFrmDetailAdopterId()));
		myForm.setFrmAdopterName(adopters.getAdopterName());
		myForm.setFrmAdopterEmail(adopters.getAdopterEmail());
		
		
		orphanAge = adopters.getAdopterOrphanAge();
		orphanGender = adopters.getAdopterOrphanGender();
		List<Orphan> orphanAdopter = myOrphanDao.getOrphanByAgeAndGender(orphanAge, orphanGender);
		myForm.setFrmOrphanList(orphanAdopter);
		myForm.setActualPage1(1);
		myForm.setiMaxShow1(3);
		if(orphanAdopter!=null){
		myForm.setiMaxData1(orphanAdopter.size());
		}
		Orphan orphans = myOrphanDao.getOrphanByAdopterId(Integer.parseInt(myForm.getFrmDetailAdopterId()),myForm.getLoginShelter().getId());
		myForm.setFrmAdopterDetail(adopters);
		myForm.setFrmOrphanDetail(orphans);
	}

	public void getAllAdopterListByShelterId(ShelterAdopterSearchForm myForm) {
		// TODO Auto-generated method stub
		Shelter myloginShelter = myForm.getLoginShelter();
		List<Adopter> l = myAdopterDao.getAllAdoptersListShelterId(myloginShelter.getId());
		myForm.setFrmAdopterList(l);
		myForm.setActualPage(1);
		myForm.setiMaxShow(3);
		if(l!=null){
		myForm.setiMaxData(l.size());
		}
	}
   
	public void Mail(ShelterAdopterSearchForm myForm){
		
		Adopter myAdopter = myAdopterDao.getAdoptersById(Integer.parseInt(myForm.getFrmDetailAdopterId()));
		
		myAdopter.setMailStatus(1);
		//System.out.println("MailService");
		myAdopterDao.setStatus(myAdopter);
		
	}
	public Adopter getMailStatus(){
		Adopter l = myAdopterDao.getStatus();
		return l;
	}
	public void prepareForMail(ShelterAdopterSearchForm myForm) {
		// TODO Auto-generated method stub
		System.out.print("Mail");
		String strFrom = "Shelter@ictti.site";
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
			List<Orphan> listOrphan = myOrphanDao.getOrphanByAgeAndGender(orphanAge, orphanGender);
			vc.put("Age",orphanAge);
			vc.put("Gender",orphanGender );
			vc.put("shelterName", myForm.getLoginShelter().getShelterLoginName());
			vc.put("size", listOrphan.size());
			vc.put("oList", listOrphan);
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

	/*public void getAdoptedAdopterList(ShelterAdopterSearchForm myForm) {
		// TODO Auto-generated method stub
		List<Adopter> l1 = myAdopterDao.getAdoptedAdoptersList();
		myForm.setFrmAdoptedAdopterList(l1);
		myForm.setActualPage1(1);
		myForm.setiMaxShow1(3);
		if(l1!=null){
		myForm.setiMaxData1(l1.size());
		}
	}*/



}
