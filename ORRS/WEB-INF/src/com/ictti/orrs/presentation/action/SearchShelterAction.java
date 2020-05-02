package com.ictti.orrs.presentation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.ictti.orrs.business.entity.City;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.business.service.DonorRegService;
import com.ictti.orrs.business.service.SearchShelterService;
import com.ictti.orrs.presentation.form.DonorRegForm;



public class SearchShelterAction extends BaseAction {
	SearchShelterService mySearchService;
	DonorRegService myDonorRegService;
	
	public DonorRegService getMyDonorRegService() {
		return myDonorRegService;
	}

	public void setMyDonorRegService(DonorRegService myDonorRegService) {
		this.myDonorRegService = myDonorRegService;
	}

	public SearchShelterService getMySearchService() {
		return mySearchService;
	}

	public void setMySearchService(SearchShelterService mySearchService) {
		this.mySearchService = mySearchService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		DonorRegForm myForm = (DonorRegForm) form;
		if(request.getParameter("next")!=null)
		{
			myForm.setActualPage(myForm.getActualPage()+1);
		}
		if(request.getParameter("prev")!=null)
		{
			myForm.setActualPage(myForm.getActualPage()-1);
		}
		if(request.getParameter("btnSearch")!=null)
		{
			System.out.println("Region is"+myForm.getFrmRegionId());
			System.out.println("City is" + myForm.getFrmCityId());
			System.out.println("Shelter is"+myForm.getFrmShelterId());
			mySearchService.getSheltersByCondition(myForm);
			//myForm.setFrmCityList(null);
			/*myForm.setFrmShelterList(mySea
			 *rchService.getShelterByCity(myForm.getFrmCityId()));*/
			List<City> cl =mySearchService.getCityByRegion(myForm.getFrmRegionId());
			cl.remove(0);
			myForm.setFrmCityList(cl);
			List<Shelter> sl;
			if(myForm.getFrmCityId().equals("0")){
				sl = mySearchService.getShelterByRegion(myForm.getFrmRegionId());
			}
			else{
				sl = mySearchService.getShelterByCity(myForm.getFrmCityId(),myForm.getFrmRegionId());

			}
			sl.remove(0);
			myForm.setFrmShelterList(sl);
		}
		if(request.getParameter("btnDonate")!=null)
		{
			System.out.println(myForm.getShelterDetail().getShelterName());
			myForm.setFrmShelterName(myForm.getShelterDetail().getShelterName());
			myForm.setFrmShelterControl("data");
			myDonorRegService.getAllCategory(myForm);
			myDonorRegService.getlessShelterCategory(myForm);
			myForm.setFrmRegFormControl(null);
			myForm.setFrmRegAmount(null);
			myForm.setFrmRegCardExpireDate(null);
			myForm.setFrmRegCardHolder(null);
			myForm.setFrmRegCreditCardType(null);
			myForm.setFrmRegDonorAddress(null);
			myForm.setFrmRegDonorComment(null);
			myForm.setFrmRegDonorCreditCard(null);
			myForm.setFrmRegDonorEmail(null);
			myForm.setFrmRegDonorName(null);
			myForm.setFrmRegDonorNRC(null);
			myForm.setFrmRegDonorPhone(null);
			myForm.setRadioTest(null);
			myForm.setFrmRadioControlMonth(null);
			myForm.setFrmRadioControlYear(null);
			myForm.setFrmRadioControlMonth(null);
			myForm.setMonthlyFee(null);
			myForm.setYearlyFee(null);
			System.out.println("Donate");
			return "gotoDonate";
		}
		if(request.getParameter("btnBack")!=null)
		{
			return "gotoShelter";
		}
		if(request.getParameter("btnGivingMeal")!=null){
			myForm.setFrmShelterName(myForm.getShelterDetail().getShelterName());
			myForm.setFrmShelterControl("data");
			myForm.setFrmBreakfastPrice(myForm.getShelterDetail().getBreakfastPrice());
			myForm.setFrmLunchPrice(myForm.getShelterDetail().getLunchPrice());
			myForm.setFrmDinnerPrice(myForm.getShelterDetail().getDinnerPrice());
			System.out.println("Giving Meal");
			return "gotoGivingMeal";
		}
		return "gotoShelter";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		DonorRegForm myForm = (DonorRegForm) form;
		if(myForm.getFrmControl().equals("2")){
			mySearchService.getShelterById(myForm);
			myDonorRegService.getAllCategory(myForm);
			myDonorRegService.getlessShelterCategory(myForm);

			return "gotoShelterDetail";
		}
		mySearchService.getShelters(myForm);//below list
		mySearchService.getAllRegion(myForm);//first load
		mySearchService.getAllShelter(myForm);//first load
		mySearchService.getAllCity(myForm);//first load
		myForm.setFrmCityId("0");
		myForm.setFrmRegionId("0");
		myForm.setFrmShelterId("0");
		return "gotoShelter";
	}

}
