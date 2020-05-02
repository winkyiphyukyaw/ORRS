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

import com.ictti.orrs.business.entity.City;
import com.ictti.orrs.business.entity.RegionState;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.dao.CityDao;
import com.ictti.orrs.dao.RegionStateDao;
import com.ictti.orrs.dao.ShelterDao;
import com.ictti.orrs.presentation.form.ShelterForm;
import com.ictti.orrs.util.MailConfig;



public class ShelterService {
	ShelterDao myShelterDao;
	RegionStateDao myRegionStateDao;
    CityDao mySubCityDao;
	
	
	public CityDao getMySubCityDao() {
		return mySubCityDao;
	}
	public void setMySubCityDao(CityDao mySubCityDao) {
		this.mySubCityDao = mySubCityDao;
	}
	public RegionStateDao getMyRegionStateDao() {
		return myRegionStateDao;
	}
	public void setMyRegionStateDao(RegionStateDao myRegionStateDao) {
		this.myRegionStateDao = myRegionStateDao;
	}
	public ShelterDao getMyShelterDao() {
		return myShelterDao;
	}
	public void setMyShelterDao(ShelterDao myShelterDao) {
		this.myShelterDao = myShelterDao;
	}
	
	
	public void fristLoadRegistration(ShelterForm myForm) {
		List<RegionState> l = myRegionStateDao.getAllRegion();
		myForm.setShelterRegRegionStateList(l);
		myForm.setShelterRegRegionStateById("0");
		myForm.setShelterRegName("");
		myForm.setShelterPrincipalName("");
		myForm.setShelterLoginName("");
		myForm.setShelterRegPassword("");
		myForm.setShelterRegConfPassword("");
		myForm.setShelterRegEmail("");
		myForm.setShelterRegPhone("");
		myForm.setShelterRegAddress("");
		myForm.setShelterRegCity("");
		myForm.setShelterRegBfCost("");
		myForm.setShelterRegLunCost("");
		myForm.setShelterRegDinCost("");
		myForm.setShelRegFormControl(null);
		//For subCity
		List<City> c = mySubCityDao.getSubcityByRegionId(Integer.parseInt(myForm.getShelterRegRegionStateById()));
		myForm.setShelterRegSubcityList(c);
		myForm.setShelterRegSubCityId("0");
		
	}

	
	public List<City> getBySubcity(String id)
	{
		List<City> l=mySubCityDao.getSubcityByRegionId(Integer.parseInt(id));
		return l;
	}
	
	
	
	
	public void saveNewShelter(ShelterForm myForm) {
		// TODO Auto-generated method stub
		Shelter myShelter= new Shelter();
		/*myShelter.setId(null);
		myShelter.setShelterLoginPassword(myForm.getShelterRegPassword());
		myShelter.setShelterLoginName(myForm.getShelterRegLoginName());
		myShelter.setShelterName(myForm.getShelterRegName());
		myShelter.setShelterLocation(myForm.getShelterRegAddress());
		myShelter.setShelterPhNo(myForm.getShelterRegPhone());
		RegionState myRegion = myRegionStateDao.getRegionById(Integer
			.parseInt(myForm.getShelterRegRegionStateById()));
	
		City city = mySubCityDao.getSubcityByRegionId(Integer.parseInt(myForm.getShelterRegSubCityId()));
		myShelter.setCity(city);
		myShelter.setCity(city);
		myForm.setShelterRegLoginName(myRegion.getId()+"-"
				+ myForm.getShelterRegLoginName());
		
		List<City> city = mySubCityDao.getSubcityByRegionId(Integer.parseInt(myForm.getShelterRegSubCityId()));
		myShelter.setCity(city.get(Integer.parseInt(myForm.getShelterRegSubCityId())));
		myShelter.setCity(Integer.parseInt(myForm.getShelterRegSubCityId()));
		myShelter.setShelterEmail(myForm.getShelterRegEmail());
		myShelter.setPrincipalName(myForm.getShelterPrincipalName());
		myShelter.setBreakfastPrice(myForm.getShelterRegBfCost());
		myShelter.setLunchPrice(myForm.getShelterRegLunCost());
		myShelter.setDinnerPrice(myForm.getShelterRegDinCost());
		myShelterDao.saveShelter(myShelter);*/
		
		
		
		myShelter.setId(null);
		myShelter.setShelterLoginPassword(myForm.getShelterRegPassword());
		myShelter.setShelterLoginName(myForm.getShelterRegLoginName());
		myShelter.setShelterName(myForm.getShelterRegName());
		myShelter.setShelterLocation(myForm.getShelterRegAddress());
		myShelter.setShelterPhNo(myForm.getShelterRegPhone());
		RegionState myRegion = myRegionStateDao.getRegionById(Integer
			.parseInt(myForm.getShelterRegRegionStateById()));
		List<City> city = mySubCityDao.getSubcityByRegionId(Integer.parseInt(myForm.getShelterRegRegionStateById()));
		myShelter.setCity(city.get(0));
		myShelter.setShelterEmail(myForm.getShelterRegEmail());
		myShelter.setPrincipalName(myForm.getShelterPrincipalName());
		myShelter.setBreakfastPrice(Integer.parseInt(myForm.getShelterRegBfCost()));
		myShelter.setLunchPrice(Integer.parseInt(myForm.getShelterRegLunCost()));
		myShelter.setDinnerPrice(Integer.parseInt(myForm.getShelterRegDinCost()));
		myForm.setFrmshelterName(myShelter.getShelterName());
		myForm.setFrmshelterEmail(myShelter.getShelterEmail());	
		myShelterDao.saveShelter(myShelter);
		
		
		
	}
	
	

	
	//For Update Profile
	public void firstLoadUpdateProfile(ShelterForm myForm) {
		// TODO Auto-generated method stub
		Shelter myLoginShelter=myForm.getLoginShelter();
		
		myForm.setShelterRegName(myLoginShelter.getShelterName());
		myForm.setShelterPrincipalName(myLoginShelter.getPrincipalName());
		myForm.setShelterLoginName(myLoginShelter.getShelterLoginName());
		myForm.setShelterRegPassword(myLoginShelter.getShelterLoginPassword());
		myForm.setShelterRegConfPassword(myLoginShelter.getShelterLoginPassword());
		myForm.setShelterRegEmail(myLoginShelter.getShelterEmail());
		myForm.setShelterRegPhone(myLoginShelter.getShelterPhNo());
		myForm.setShelterRegAddress(myLoginShelter.getShelterLocation());
		myForm.setShelterRegCity((myLoginShelter.getCity().getName()));
		myForm.setShelterRegBfCost(String.valueOf(myLoginShelter.getBreakfastPrice()));
		myForm.setShelterRegLunCost(String.valueOf(myLoginShelter.getLunchPrice()));
		myForm.setShelterRegDinCost(String.valueOf(myLoginShelter.getDinnerPrice()));
		/*RegionState rs = new RegionState();
		rs = myRegionStateDao.getRegionState(myForm.getShelterRegCity().getRegionState().getId());*/
		
		myForm.setShelterRegRegionState(myLoginShelter.getCity().getRegionState().getName());
		myForm.setShelRegFormControl(null);	
		
				
	}
	public Shelter checkLoginShelter(ShelterForm myform) {
		// TODO Auto-generated method stub
		Shelter myShelter=myShelterDao.getShelterByLoginNameAndPassword(myform.getShelterLoginName(),myform.getShelterPassword());
		myform.setLoginShelter(myShelter);
		/*int shelterId = myShelter.getId();
		System.out.println(shelterId);*/
		return myShelter;
	}
	public void saveUpdateStudent(ShelterForm myForm) {
		System.out.println("in service");
		Shelter myShelter=myForm.getLoginShelter();
		
		myShelter.setShelterName(myForm.getShelterRegName());
		myShelter.setPrincipalName(myForm.getShelterPrincipalName());
		myShelter.setShelterLoginName(myForm.getShelterLoginName());
		myShelter.setShelterLoginPassword(myForm.getShelterPassword());
		myShelter.setShelterLoginPassword(myForm.getShelterRegConfPassword());
		myShelter.setShelterEmail(myForm.getShelterRegEmail());
		myShelter.setShelterPhNo(myForm.getShelterRegPhone());
		myShelter.setShelterLocation(myForm.getShelterRegAddress());
		myShelter.setBreakfastPrice(Integer.parseInt(myForm.getShelterRegBfCost()));
		myShelter.setLunchPrice(Integer.parseInt(myForm.getShelterRegLunCost()));
		myShelter.setDinnerPrice(Integer.parseInt(myForm.getShelterRegDinCost()));
		myShelterDao.saveShelter(myShelter);
		
		myForm.setFrmshelterName(myShelter.getShelterName());
		myForm.setFrmshelterEmail(myShelter.getShelterEmail());
	}
	

	public void checkLoginName(ShelterForm myForm) {
		// TODO Auto-generated method stub
		Shelter myShelter = myShelterDao.getShelterByLoginName(myForm.getShelterRegLoginName());
		if (myShelter != null) {
			myForm.setShelRegAccountNameError(null);
			myForm.setShelRegFormControl(null);
		} 
		else
		{
			
			
			
			City myCity= mySubCityDao.getCityByCityId(Integer.parseInt(myForm.getShelterRegSubCityId()));
			myForm.setShelterRegCity(myCity.getName());
			System.out.println("city is "+myForm.getShelterRegCity()+"=================");
			System.out.println("CIty Id==========="+myForm.getShelterRegSubCityId()+"==========");
			RegionState myregion = myRegionStateDao.getRegionById(Integer.parseInt(myForm.getShelterRegRegionStateById()));
			/*myForm.setShelterRegLoginName(myregion.getId()+"-"
					+ myForm.getShelterRegLoginName());*/
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			myForm.setShelRegDate(myFormat.format(new Date()));
			myForm.setShelterRegRegionState(myregion.getName());
			myForm.setShelRegFormControl("data");
			
			
		}
	}
	public void prepareForUpdateConfirmMail(ShelterForm myForm) {
		// TODO Auto-generated method stub

		String strFrom = "Admin@ictti.site";
		String strSubject = "Profile Update Information For You";
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
			Template tm = engine.getTemplate("shelterUpdatemailTemplate .vm");
			
			//2
			VelocityContext vc = new VelocityContext();
			
			//3
			// Put job list
			vc.put("name", myForm.getFrmshelterName());
			// Put today's date
			String today = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date()).toString();
			vc.put("today", today);
			StringWriter sw = new StringWriter();
			
			//5
			tm.merge(vc, sw);
			strContent = sw.toString();
			if (strContent != null) {
				// Create an email object
								MailConfig smtpMailSender = new MailConfig();
				smtpMailSender.sendToOne(myForm.getFrmshelterEmail(), strSubject,
						strContent, strFrom);
			
				myForm.setFrmMailMessage("Mail can send successfully");
			} else {
				myForm.setFrmMailMessage("Mail cannot send because the	message is null.");
			}
		} catch (Exception e) {
			myForm.setFrmMailMessage("Mail cannot send.");
		}		
		
	}
	
	
	public void prepareForRegisterConfirmMail(ShelterForm myForm) {
		// TODO Auto-generated method stub
		String strFrom = "Admin@ictti.site";
		String strSubject = "Profile Register Information for You";
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
			Template tm = engine.getTemplate("shelterRegisterMailTemplate .vm");
			
			//2
			VelocityContext vc = new VelocityContext();
			
			//3
			// Put job list
			vc.put("name", myForm.getFrmshelterName());
			vc.put("Principal", myForm.getShelterPrincipalName());
			vc.put("Login", myForm.getShelterRegLoginName());
			vc.put("password",myForm.getShelterRegPassword());
			vc.put("BreakfastCost", myForm.getShelterRegBfCost());
			vc.put("LunchCost", myForm.getShelterRegLunCost());
			vc.put("DinnerCost", myForm.getShelterRegPhone());
			vc.put("Phone", myForm.getShelterRegPhone());
			vc.put("Email", myForm.getShelterRegEmail());
			vc.put("Address", myForm.getShelterRegAddress());
			vc.put("RegionState", myForm.getShelterRegRegionState());
			vc.put("city", myForm.getShelterRegCity());
			// Put today's date
			String today = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date()).toString();
			vc.put("today", today);
			StringWriter sw = new StringWriter();
			
			//5
			tm.merge(vc, sw);
			strContent = sw.toString();
			if (strContent != null) {
				// Create an email object
								MailConfig smtpMailSender = new MailConfig();
				smtpMailSender.sendToOne(myForm.getFrmshelterEmail(), strSubject,
						strContent, strFrom);
			
				myForm.setFrmMailMessage("Mail can send successfully");
			} else {
				myForm.setFrmMailMessage("Mail cannot send because the	message is null.");
			}
		} catch (Exception e) {
			myForm.setFrmMailMessage("Mail cannot send.");
		}		
		
		
	}

	
	}


