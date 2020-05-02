package com.ictti.orrs.presentation.action;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.service.AdminEventService;
import com.ictti.orrs.presentation.form.AdminEventForm;
import com.ictti.orrs.presentation.form.AdminForm;
import com.ictti.orrs.presentation.form.ShelterEventForm;
import com.ictti.orrs.presentation.form.ShelterForm;

public class AdminEventAction extends BaseAction {
	AdminEventService myAdminEventService;

	public AdminEventService getMyAdminEventService() {
		return myAdminEventService;
	}

	public void setMyAdminEventService(AdminEventService myAdminEventService) {
		this.myAdminEventService = myAdminEventService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
	

		AdminEventForm myForm = (AdminEventForm) form;
		
		if (request.getParameter("btnUpload") != null) {
			
			if(myForm.getFrmUploadFile().getFileSize()/1024>62)
			{
				ActionErrors errors = new ActionErrors();
				errors.add("fileSizeError", new ActionMessage("errors.fileSizeAlert"));
					saveErrors(request, errors);
					return "gotoEvent";
			}
			if(myForm.getFrmUploadFile().getFileName().length()>=20)
			{
				ActionErrors errors = new ActionErrors();
				errors.add("fileNameError", new ActionMessage("errors.fileNameAlert"));
					saveErrors(request, errors);
					return "gotoEvent";
			}
			ArrayList<String> imagelist1 = new ArrayList<>();
			String filePath2 = getServlet().getServletContext()
					.getRealPath("/")+ "/images/"
							+myForm.getFrmUploadFile().getFileName();
			
			try {
				BufferedOutputStream outStream = new BufferedOutputStream(
						new FileOutputStream(filePath2));
				InputStream in = myForm.getFrmUploadFile().getInputStream();
						
				byte[] buffer = new byte[1000];
				int n = 0;
				while ((n = in.read(buffer)) != -1) {
					outStream.write(buffer, 0, n);
				}
				in.close();
				outStream.close();
				imagelist1.add(myForm.getFrmUploadFile().getFileName());
				System.out.print(myForm.getFrmUploadFile().getFileName());
				
				myForm.setFilePath2("images/"+myForm.getFrmUploadFile().getFileName());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
					
					
			
			//myForm.setEventViewFile(imagelist1);
			
			myForm.setAdminEventFormControl("data");
			return "gotoEvent";
		}
		if (isCancelled(request)) {
			
			return "gotoHome";
		}
		if (request.getParameter("btnConfirm") != null) {
			AdminForm loginForm = (AdminForm) request.getSession()
					.getAttribute("AdminFormBean");
			myForm.setLoginAdmin(loginForm.getLoginAdmin());
			//for image size and image name check
			
			
			
			myAdminEventService.saveEvent(myForm);
			myForm.setEventText(null);
			myForm.setFrmUploadFile(null);
			myForm.setFrmEventStoryStatus(null);
			myForm.setAdminEventFormControl(null);
			return "gotoEvent";
		}
		
		if(request.getParameter("btnConfirmCancel")!=null)
		{	
			myForm.setAdminEventFormControl(null);
			return "gotoEvent";
		}

		if (request.getParameter("next") != null) {
			System.out.println("next button ok");
			myForm.setActualPage(myForm.getActualPage() + 1);
			return "gotoView";
		}
		if (request.getParameter("prev") != null) {
			myForm.setActualPage(myForm.getActualPage() - 1);
			return "gotoView";
		}
		if (request.getParameter("btnView") != null) {

			System.out.println("View Button work");

			
			String myD1 = myForm.getFrmSearchDate1();
			String myD2 = myForm.getFrmSearchDate2();
			if ((myD1 == "" && myD2 == "")){
					if (myForm.getFrmEvent().equals("0")) {
				// if (myForm.getFrmEvent().equals("0")) {
				AdminForm loginForm = (AdminForm) request.getSession()
						.getAttribute("AdminFormBean");
				myForm.setLoginAdmin(loginForm.getLoginAdmin());

				
				myAdminEventService.getAllStory(myForm);
			} else if  (myForm.getFrmEvent().equals("1")) {
				AdminForm loginForm = (AdminForm) request.getSession()
						.getAttribute("AdminFormBean");
				myForm.setLoginAdmin(loginForm.getLoginAdmin());

				
				myAdminEventService.getAllEvent(myForm);

			} else if (myForm.getFrmEvent().equals("2")) {
				AdminForm loginForm = (AdminForm) request.getSession()
						.getAttribute("AdminFormBean");
				myForm.setLoginAdmin(loginForm.getLoginAdmin());

				
				myAdminEventService.getAllStoryAndEvent(myForm);

			}
			}
			//for First Date
			else if(myD1 !="" && myD2 =="")
			{
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				Date myDate1 = myformat.parse(myForm.getFrmSearchDate1());
				
				Date myDate3 = new Date();
				String myDate4 = myformat.format(myDate3);
				Date todayDate1 = myformat.parse(myDate4);
				ActionErrors errors1 = new ActionErrors();
				if(todayDate1.before(myDate1)||myDate1.equals(todayDate1)){
					errors1.add("firstDateError",new ActionMessage("errors.firstDateError"));
					saveErrors(request,errors1);
					return "gotoViewEvent";
					}
				else if

					(myForm.getFrmEvent().equals("0")) {
						myAdminEventService.getAllStoryByFirstDate(myForm, myDate1,todayDate1);
					}
					
					 else if(myForm.getFrmEvent().equals("1")){
					 myAdminEventService.getAllEventByFirstDate(myForm,myDate1,todayDate1); } 
					 else if(myForm.getFrmEvent().equals("2")){
					 myAdminEventService.getAllStoryAndEventByFirstDate(myForm,myDate1,todayDate1); }
					
				
				}
			
			//for Second Date
			
			else if(myD1 =="" && myD2 !="")
			{
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				Date myDate2 = myformat.parse(myForm.getFrmSearchDate2());
				
				Date myDate3 = new Date();
				String myDate4 = myformat.format(myDate3);
				Date todayDate1 = myformat.parse(myDate4);
				ActionErrors errors1 = new ActionErrors();
				if(myDate2.after(todayDate1)){
					errors1.add("secondDateError",new ActionMessage("errors.secondDateError"));
					saveErrors(request,errors1);
					return "gotoViewEvent";
					}
				else if (myForm.getFrmEvent().equals("0")) {
						myAdminEventService.getAllStoryToSecondDate(myForm,myDate2);
					}
					
					 else if(myForm.getFrmEvent().equals("1")){
					 myAdminEventService.getAllEventToSecondDate(myForm,myDate2); } 
					 else if(myForm.getFrmEvent().equals("2")){
					 myAdminEventService.getAllStoryAndEventToSecondDate(myForm,myDate2); }
					
				
				}
			
			
			
			else if (myD1 != "" && myD2 != "") {
				SimpleDateFormat myformat1 = new SimpleDateFormat("yyyy-MM-dd");
				Date myDate11 = myformat1.parse(myForm.getFrmSearchDate1());
				Date myDate22 = myformat1.parse(myForm.getFrmSearchDate2());
				Date myDate33 = new Date();
				String myDate44 = myformat1.format(myDate33);
				Date todayDate2 = myformat1.parse(myDate44);
				ActionErrors errors2 = new ActionErrors();
				if(myDate22.after(todayDate2)){
					errors2.add("noDateError", new ActionMessage(
							"errors.dateNo"));
					saveErrors(request, errors2);
					return "gotoViewEvent";
				}
				if(myDate11.equals(myDate22)){
					errors2.add("samedateError", new ActionMessage(
							"errors.dateSame"));
					saveErrors(request, errors2);
					return "gotoViewEvent";
				}
				if (myDate11.after(myDate22)) {
					errors2.add("dateError", new ActionMessage(
							"errors.dateBefore"));
					saveErrors(request, errors2);
					return "gotoViewEvent";
				} else if (myDate11.before(myDate22)) {
					if (myForm.getFrmEvent().equals("0")) {
						myAdminEventService.getAllStoryByDate(myForm, myDate11,
								myDate22);
					}
					
					 else if(myForm.getFrmEvent().equals("1")){
					 myAdminEventService.getAllEventByDate(myForm,myDate11,myDate22); } 
					 else if(myForm.getFrmEvent().equals("2")){
					 myAdminEventService.getAllStoryAndEventByDate(myForm,myDate11,myDate22); }
					
				}

			}

			ArrayList<String> imagelist = new ArrayList<>();

			if (myForm.getAdminEventList() != null) {

				for (int i = 0; i < myForm.getAdminEventList().size(); i++) {

					String filePath = getServlet().getServletContext()
							.getRealPath("")
							+ "/images/"
							+ myForm.getAdminEventList().get(i)
									.getEventImageName();
					try {
						BufferedOutputStream outStream = new BufferedOutputStream(
								new FileOutputStream(filePath));
						InputStream in = myForm.getAdminEventList().get(i)
								.getImage().getBinaryStream();
						byte[] buffer = new byte[1000];
						int n = 0;
						while ((n = in.read(buffer)) != -1) {
							outStream.write(buffer, 0, n);
						}
						in.close();
						outStream.close();
						// imagelist.add(myForm.getEventViewFile());
						imagelist.add("images/"
								+ myForm.getAdminEventList().get(i)
										.getEventImageName());
						System.out.println("Image path is ======"
								+ "images/"
								+ myForm.getAdminEventList().get(i)
										.getEventImageName());

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
			}	
			
			if(myForm.getAdminEventList()==null)
			{	
				ActionErrors noEventError = new ActionErrors();
				noEventError.add("noEventError", new ActionMessage(
							"errors.NoEvent"));
					saveErrors(request, noEventError);
					return "gotoViewEvent";
				
			}
			
				return "gotoView";
		} 
		

		// For Event Edit
		if (request.getParameter("btnEdit") != null) {
			
			if(myForm.getFrmUploadFile().getFileSize()/1024>62)
			{
				ActionErrors errors = new ActionErrors();
				errors.add("fileSizeError1", new ActionMessage("errors.fileSizeAlert"));
					saveErrors(request, errors);
					return "gotoEdit";
			}
			if(myForm.getFrmUploadFile().getFileName().length()>=20)
			{
				ActionErrors errors = new ActionErrors();
				errors.add("fileNameError1", new ActionMessage("errors.fileNameAlert"));
					saveErrors(request, errors);
					return "gotoEdit";
			}
			
			if(myForm.getFrmUploadFile().getFileSize()!=0){
			ArrayList<String> imagelist1 = new ArrayList<>();
			String filePath1 = getServlet().getServletContext()
					.getRealPath("/")+ "/images/"
							+myForm.getFrmUploadFile().getFileName();
			
			try {
				BufferedOutputStream outStream = new BufferedOutputStream(
						new FileOutputStream(filePath1));
				InputStream in = myForm.getFrmUploadFile().getInputStream();
						
				byte[] buffer = new byte[1000];
				int n = 0;
				while ((n = in.read(buffer)) != -1) {
					outStream.write(buffer, 0, n);
				}
				in.close();
				outStream.close();
				imagelist1.add(myForm.getFrmUploadFile().getFileName());
				System.out.print(myForm.getFrmUploadFile().getFileName());
				
				myForm.setFilePath1("images/"+myForm.getFrmUploadFile().getFileName());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			

		
					
					
			
			//myForm.setEventViewFile(imagelist1);

			myForm.setAdminEditEventControl("data");
			return "gotoEdit";
		}
		if (request.getParameter("btnEditCancel")!=null){
			myForm.setAdminEditEventControl("data");
			return "gotoView";
		}
		if (request.getParameter("btnEditConfirm") != null) {
			
			
			
			myAdminEventService.saveEditEvent(myForm);
			
			/*myForm.setEventText(null);
			myForm.setFrmEventStoryStatus(null);
			myForm.setAdminEventFormControl1(null);
			// myForm.setAdminEditEventControl(null);
			 * 
*/			
			
			String myD1 = myForm.getFrmSearchDate1();
			String myD2 = myForm.getFrmSearchDate2();
			if ((myD1 == "" || myD2 == "")
					&& (myForm.getFrmEvent().equals("0"))) {
				// if (myForm.getFrmEvent().equals("0")) {
				AdminForm loginForm = (AdminForm) request.getSession()
						.getAttribute("AdminFormBean");
				myForm.setLoginAdmin(loginForm.getLoginAdmin());

				// String[] imagelist = new String[100];
				// ArrayList<String> imagelist=new ArrayList<>();
				myAdminEventService.getAllStory(myForm);
			} else if ((myD1 == "" || myD2 == "")
					&& (myForm.getFrmEvent().equals("1"))) {
				AdminForm loginForm = (AdminForm) request.getSession()
						.getAttribute("AdminFormBean");
				myForm.setLoginAdmin(loginForm.getLoginAdmin());

				// String[] imagelist = new String[100];
				// ArrayList<String> imagelist=new ArrayList<>();
				myAdminEventService.getAllEvent(myForm);

			} else if ((myD1 == "" || myD2 == "")
					&& (myForm.getFrmEvent().equals("2"))) {
				AdminForm loginForm = (AdminForm) request.getSession()
						.getAttribute("AdminFormBean");
				myForm.setLoginAdmin(loginForm.getLoginAdmin());

				// String[] imagelist = new String[100];
				// ArrayList<String> imagelist=new ArrayList<>();
				myAdminEventService.getAllStoryAndEvent(myForm);

			}
			if (myD1 != "" && myD2 != "") {
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				Date myDate1 = myformat.parse(myForm.getFrmSearchDate1());
				Date myDate2 = myformat.parse(myForm.getFrmSearchDate2());
				
				if (myDate1.after(myDate2)) {
					System.out.println("date is ready");
					ActionErrors errors = new ActionErrors();
					errors.add("dateError", new ActionMessage(
							"errors.dateBefore"));
					saveErrors(request, errors);
				} else if (myDate1.before(myDate2)) {
				
					if (myForm.getFrmEvent().equals("0")) {
						myAdminEventService.getAllStoryByDate(myForm, myDate1,
								myDate2);
					}
					
					 else if(myForm.getFrmEvent().equals("1")){
					 myAdminEventService.getAllEventByDate(myForm,myDate1,myDate2); } 
					 else if(myForm.getFrmEvent().equals("2")){
					 myAdminEventService.getAllStoryAndEventByDate(myForm,myDate1,myDate2); }
					
				}

			}
			ArrayList<String> imagelist = new ArrayList<>();

			if (myForm.getAdminEventList() != null) {

				for (int i = 0; i < myForm.getAdminEventList().size(); i++) {

					String filePath = getServlet().getServletContext()
							.getRealPath("")
							+ "/images/"
							+ myForm.getAdminEventList().get(i)
									.getEventImageName();
					try {
						BufferedOutputStream outStream = new BufferedOutputStream(
								new FileOutputStream(filePath));
						InputStream in = myForm.getAdminEventList().get(i)
								.getImage().getBinaryStream();
						byte[] buffer = new byte[1000];
						int n = 0;
						while ((n = in.read(buffer)) != -1) {
							outStream.write(buffer, 0, n);
						}
						in.close();
						outStream.close();
						// imagelist.add(myForm.getEventViewFile());
						imagelist.add("images/"
								+ myForm.getAdminEventList().get(i)
										.getEventImageName());
						System.out.println("Image path is ======"
								+ "images/"
								+ myForm.getAdminEventList().get(i)
										.getEventImageName());

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
			}
			
			return "gotoView";
		}
		 if (request.getParameter("btnEditConfirmCancel")!= null){
			 myForm.setAdminEditEventControl(null);
			 return "gotoEdit";
		 }
		
		
			


		return "gotoView";

	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
		AdminEventForm myForm = (AdminEventForm) form;

		if (myForm.getFrmControl().equals("1")) {
			myForm.setEventText(null);
			myForm.setFrmUploadFile(null);
			myForm.setFrmEventStoryStatus(null);
			myForm.setAdminEventFormControl(null);
			//myForm.setAdminEventFormControl1(null);
			return "gotoEvent";
		}

		if (myForm.getFrmControl().equals("2")) {
			// System.out.println("sue");
			// System.out.println(myForm.getFrmEditEvent());

			myAdminEventService.getEditEventPage(myForm);
			
			myForm.setAdminEditEventControl(null);
			myForm.getFilePath1();
			return "gotoEdit";
		}
		if (myForm.getFrmControl().equals("3")) {
			// System.out.println("sue");
			// System.out.println(myForm.getFrmEditEvent());

			myAdminEventService.getEditEventPage(myForm);

			myForm.setAdminEditEventControl(null);

			return "gotoEdit";
		}
		if (myForm.getFrmControl().equals("4")) {
			// System.out.println("sue");
			// System.out.println(myForm.getFrmEditEvent());

			myAdminEventService.changePermitStatus(myForm);
			if(myForm.getFrmEvent().equals("0"))
			{
				myAdminEventService.getAllStory(myForm);
			}
			if(myForm.getFrmEvent().equals("1"))
			{
				myAdminEventService.getAllEvent(myForm);
			}
			if(myForm.getFrmEvent().equals("2"))
			{
				myAdminEventService.getAllStoryAndEvent(myForm);
			}
			myForm.setActualPage(myForm.getActualPage());
			
			
			return "gotoView";
									}
		if (myForm.getFrmControl().equals("5")) {
			// System.out.println("sue");
			// System.out.println(myForm.getFrmEditEvent());
			
			myAdminEventService.changePermitStatus(myForm);
			if(myForm.getFrmEvent().equals("0"))
			{
				myAdminEventService.getAllStory(myForm);
			}
			if(myForm.getFrmEvent().equals("1"))
			{
				myAdminEventService.getAllEvent(myForm);
			}
			if(myForm.getFrmEvent().equals("2"))
			{
				myAdminEventService.getAllStoryAndEvent(myForm);
			}
			
			return "gotoView";
		}
		if (myForm.getFrmControl().equals("6")){
			myForm.setFrmEvent(null);
			myForm.setFrmEvent("2");
			myForm.setFrmSearchDate1(null);
			myForm.setFrmSearchDate2(null);
			myForm.setAdminEventFormControl1(null);
			return "gotoViewEvent";
		}

		return "gotoEvent";

	}

}
