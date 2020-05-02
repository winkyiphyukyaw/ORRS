package com.ictti.orrs.presentation.action;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.business.service.ShelterEventService;
import com.ictti.orrs.presentation.form.ShelterEventForm;
import com.ictti.orrs.presentation.form.ShelterForm;

public class ShelterEventAction extends BaseAction {
	ShelterEventService myShelterService;

	public ShelterEventService getMyShelterService() {
		return myShelterService;
	}

	public void setMyShelterService(ShelterEventService myShelterService) {
		this.myShelterService = myShelterService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoShelterLogin";
		}

		ShelterEventForm myForm = (ShelterEventForm) form;
		if (request.getParameter("btnUpload") != null) {

			if (myForm.getFrmUploadFile().getFileSize() / 1024 > 62) {
				ActionErrors errors = new ActionErrors();
				errors.add("fileSizeError", new ActionMessage(
						"errors.fileSizeAlert"));
				saveErrors(request, errors);
				return "gotoUploadEvent";
			}
			if (myForm.getFrmUploadFile().getFileName().length() >= 20) {
				ActionErrors errors = new ActionErrors();
				errors.add("fileNameError", new ActionMessage(
						"errors.fileNameAlert"));
				saveErrors(request, errors);
				return "gotoUploadEvent";
			}
			ArrayList<String> imagelist1 = new ArrayList<>();
			String filePath = getServlet().getServletContext().getRealPath("/")
					+ "/images/" + myForm.getFrmUploadFile().getFileName();

			try {
				BufferedOutputStream outStream = new BufferedOutputStream(
						new FileOutputStream(filePath));
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

				myForm.setFilePath("images/"
						+ myForm.getFrmUploadFile().getFileName());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myForm.setShelterEventFormControl("data");
			return "gotoUploadEvent";
		}

		if (isCancelled(request)) {

			return "gotoShelterHome";
		}
		if (request.getParameter("btnConfirm") != null) {

			ShelterForm loginForm = (ShelterForm) request.getSession()
					.getAttribute("ShelterFormBean");
			myForm.setLoginShelter(loginForm.getLoginShelter());

			myShelterService.saveEvent(myForm);

			myForm.setEventText(null);
			myForm.setFrmUploadFile(null);
			myForm.setFrmEventStoryStatus(null);
			myForm.setShelterEventFormControl(null);
			return "gotoUploadEvent";
		}
		if (request.getParameter("btnConfirmCancel") != null) {
			myForm.setShelterEventFormControl(null);
			return "gotoUploadEvent";
		}

		return null;

		/*
		 * ShelterForm loginForm = (ShelterForm) request.getSession()
		 * .getAttribute("ShelterFormBean");
		 * myForm.setLoginShelter(loginForm.getLoginShelter());
		 * 
		 * myShelterService.saveEvent(myForm); myForm.setEventText(null); return
		 * "gotoUploadEvent"; } if (request.getParameter("btnCancel") != null) {
		 * return "gotoShelterHome"; }
		 */

	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		ShelterEventForm myForm = (ShelterEventForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoShelterLogin";
		}
		if (myForm.getFrmControl().equals("2")) {
			return "gotoUploadEvent";
		}

		// myForm.setEventText(null);
		if (myForm.getFrmControl().equals("1")) {
			myForm.setEventText(null);
			myForm.setFrmUploadFile(null);
			myForm.setFrmEventStoryStatus(null);
			myForm.setShelterEventFormControl(null);
			return "gotoUploadEvent";
		}
		return null;
	}

}
