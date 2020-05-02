package com.ictti.orrs.presentation.action;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.EventFilter;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.ictti.orrs.business.entity.EventImage;
import com.ictti.orrs.business.service.EventService;
import com.ictti.orrs.business.service.StoryService;
import com.ictti.orrs.presentation.form.EventForm;
import com.ictti.orrs.presentation.form.StoryForm;

public class EventAction extends BaseAction {
  EventService myEventService; 
  
  
	

	public EventService getMyEventService() {
	return myEventService;
}

public void setMyEventService(EventService myEventService) {
	this.myEventService = myEventService;
}
	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		
		EventForm myForm=(EventForm) form;
		if(request.getParameter("next")!=null)
			myForm.setActualPage(myForm.getActualPage()+1);
		if(request.getParameter("prev")!=null)
		myForm.setActualPage(myForm.getActualPage()-1);
		return "gotoEvent";
	}	
	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		EventForm myForm=(EventForm) form;
		//myEventService.getAllEvent(myForm);	
		
		System.out.println("In action");
		myEventService.retrieveFile(myForm);
		String[]  imagelist = new String[100] ;
	/*	myForm.setEventViewFile("images/"+myForm.getEventFile().getEventImageName());*/
		if(myForm.getUserEventList()!=null){
		for(int i=0;i<myForm.getUserEventList().size();i++)
		{
			System.out.println(myForm.getUserEventList().get(i).getEventImageName());

			String filePath=getServlet().getServletContext().getRealPath("")+"/images/"+myForm.getUserEventList().get(i).getEventImageName();
			
			try {
				BufferedOutputStream outStream=new BufferedOutputStream(new FileOutputStream(filePath));
				InputStream in=myForm.getUserEventList().get(i).getImage().getBinaryStream();
				byte[] buffer=new byte[1000];
				int n=0;
				while((n=in.read(buffer))!=-1)
				{
					outStream.write(buffer,0,n);
				}
				in.close();outStream.close();
				//imagelist.add(myForm.getEventViewFile());
				imagelist[i]="images/"+myForm.getUserEventList().get(i).getEventImageName();
				
				
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
		}
		myForm.setEventViewFile(imagelist);
		
		return "gotoEvent";
	}
}
	
	
		
	
