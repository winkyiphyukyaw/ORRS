package com.ictti.orrs.presentation.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.ictti.orrs.business.entity.Event;
import com.ictti.orrs.business.entity.EventImage;

public class StoryForm extends ActionForm {
	
	
	private int begin;
	private int end;
	private List<EventImage> userStoryList;
	private String[] storyViewFile;
	private EventImage eventFile;
	private String eventFileId;
	
	
	
	public String getEventFileId() {
		return eventFileId;
	}
	public void setEventFileId(String eventFileId) {
		this.eventFileId = eventFileId;
	}
	public String[] getStoryViewFile() {
		return storyViewFile;
	}
	public void setStoryViewFile(String[] storyViewFile) {
		this.storyViewFile = storyViewFile;
	}
	public EventImage getEventFile() {
		return eventFile;
	}
	
	public void setEventFile(EventImage eventFile) {
		this.eventFile = eventFile;
	}
	public int getBegin() {
		begin=(actualPage-1)*iMaxShow+1;
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		end=actualPage*iMaxShow; 
		if(end>iMaxData)
		end=iMaxData;
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public List<EventImage> getUserStoryList() {
		return userStoryList;
	}
	public void setUserStoryList(List<EventImage> userStoryList) {
		this.userStoryList = userStoryList;
	}
	
	//For Next Previous
		private boolean prevBtn;
		private boolean nextBtn;
		private int actualPage;
		private int iMaxShow;
		private int iMaxData;
		private int finalPage;


		public boolean isPrevBtn() {
			if(actualPage==1)
				prevBtn=false;
				else 
				prevBtn=true;
			return prevBtn;
		}
		public void setPrevBtn(boolean prevBtn) {
			this.prevBtn = prevBtn;
		}
		public boolean isNextBtn() {
			if(actualPage==getFinalPage())
				nextBtn=false;
			else nextBtn=true;

			return nextBtn;
		}
		public void setNextBtn(boolean nextBtn) {
			this.nextBtn = nextBtn;
		}
		public int getActualPage() {
			return actualPage;
		}
		public void setActualPage(int actualPage) {
			this.actualPage = actualPage;
		}
		public int getiMaxShow() {
			return iMaxShow;
		}
		public void setiMaxShow(int iMaxShow) {
			this.iMaxShow = iMaxShow;
		}
		public int getiMaxData() {
			return iMaxData;
		}
		public void setiMaxData(int iMaxData) {
			this.iMaxData = iMaxData;
		}
		public int getFinalPage() {
			finalPage=(int)Math.ceil((double)iMaxData/iMaxShow);
			return finalPage;
		}
		public void setFinalPage(int finalPage) {
			this.finalPage = finalPage;
		}
		
	

}
