package com.ictti.orrs.presentation.action;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.ictti.orrs.business.service.ShelterViewEventService;
import com.ictti.orrs.presentation.form.ShelterEventForm;
import com.ictti.orrs.presentation.form.ShelterForm;

public class ShelterViewEventAction extends BaseAction {
	ShelterViewEventService myShelterEventService;
	

	public ShelterViewEventService getMyShelterEventService() {
		return myShelterEventService;
	}


	public void setMyShelterEventService(
			ShelterViewEventService myShelterEventService) {
		this.myShelterEventService = myShelterEventService;
	}


	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		ShelterEventForm  myForm= (ShelterEventForm) form;
		if(request.getParameter("next")!=null)
			myForm.setActualPage(myForm.getActualPage()+1);
		if(request.getParameter("prev")!=null)
		myForm.setActualPage(myForm.getActualPage()-1);
		return "gotoEventView";
	}


	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null)
			return "gotoShelterLogin";
		ShelterEventForm myForm = (ShelterEventForm) form;

		ShelterForm loginForm = (ShelterForm) request.getSession()
				.getAttribute("ShelterFormBean");
		myForm.setLoginShelter(loginForm.getLoginShelter());
		
		
		String[]  imagelist = new String[100] ;
		myShelterEventService.getAllEventsByShelter(myForm);
		if(myForm.getShelterEventList()==null)
		{ 
			return "gotoNoEvent";
			
		}
		
		for(int i=0;i<myForm.getShelterEventList().size();i++){
			
			String filePath=getServlet().getServletContext().getRealPath("")+"/images/"+myForm.getShelterEventList().get(i).getEventImageName();
			try {
				BufferedOutputStream outStream=new BufferedOutputStream(new FileOutputStream(filePath));
				InputStream in=myForm.getShelterEventList().get(i).getImage().getBinaryStream();
				byte[] buffer=new byte[1000];
				int n=0;
				while((n=in.read(buffer))!=-1)
				{
					outStream.write(buffer,0,n);
				}
				in.close();outStream.close();
				//imagelist.add(myForm.getEventViewFile());
				imagelist[i]="images/"+myForm.getShelterEventList().get(i).getEventImageName();
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		myForm.setEventViewFile(imagelist);
		return "gotoEventView";
		
	
		
	}
	

}
