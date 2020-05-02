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
import com.ictti.orrs.presentation.form.StoryForm;

public class StoryAction extends BaseAction {
	StoryService myStoryService;
	

	public StoryService getMyStoryService() {
		return myStoryService;
	}

	public void setMyStoryService(StoryService myStoryService) {
		this.myStoryService = myStoryService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		StoryForm myForm=(StoryForm) form;
		if(request.getParameter("next")!=null)
			myForm.setActualPage(myForm.getActualPage()+1);
		if(request.getParameter("prev")!=null)
		myForm.setActualPage(myForm.getActualPage()-1);
		return "gotoUserStory";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		StoryForm myForm=(StoryForm) form;
		
		myStoryService.retrieveFile(myForm);
		String[]  imagelist = new String[100] ;
		if(myForm.getUserStoryList()!=null)
		{
		for(int i=0;i<myForm.getUserStoryList().size();i++)
		{
			System.out.println(myForm.getUserStoryList().get(i).getEventImageName());

			String filePath=getServlet().getServletContext().getRealPath("")+"/images/"+myForm.getUserStoryList().get(i).getEventImageName();
			/*System.out.println(filePath);*/
			try {
				BufferedOutputStream outStream=new BufferedOutputStream(new FileOutputStream(filePath));
				InputStream in=myForm.getUserStoryList().get(i).getImage().getBinaryStream();
				//System.out.println(myForm.getUserStoryList().get(i).getImage().getBinaryStream());
				byte[] buffer=new byte[10000];
				int n=0;
				while((n=in.read(buffer))!=-1)
				{
					outStream.write(buffer,0,n);
					/*System.out.println(outStream);*/
				}
				
				in.close();
				outStream.close();
				
				imagelist[i]="images/"+myForm.getUserStoryList().get(i).getEventImageName();
				
				
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
		myForm.setStoryViewFile(imagelist);
		return "gotoUserStory";
	}
}
	
	
		
	
