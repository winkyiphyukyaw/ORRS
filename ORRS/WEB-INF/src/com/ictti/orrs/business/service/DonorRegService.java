package com.ictti.orrs.business.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;











import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.entity.Donor;
import com.ictti.orrs.business.entity.DonorCategory;
import com.ictti.orrs.business.entity.DonorShelter;
import com.ictti.orrs.business.entity.Shelter;
import com.ictti.orrs.business.entity.YearlyFoundationTable;
import com.ictti.orrs.business.entity.YearlyShelterTable;
import com.ictti.orrs.dao.CategoryDao;
import com.ictti.orrs.dao.DonorCategoryDao;
import com.ictti.orrs.dao.DonorDao;
import com.ictti.orrs.dao.DonorShelterDao;
import com.ictti.orrs.dao.ShelterDao;
import com.ictti.orrs.dao.YearlyFoundationDao;
import com.ictti.orrs.dao.YearlyShelterDao;
import com.ictti.orrs.presentation.form.DonorRegForm;
import com.ictti.orrs.util.CheckValid;

public class DonorRegService {
	DonorCategoryDao myDonorCategoryDao;
	CategoryDao myCategoryDao;
	DonorDao myDonor;
	ShelterDao myShelterDao;
	DonorShelterDao myDonorShelterDao;
	YearlyFoundationDao myYearlyFoundationDao;
	YearlyShelterDao myYearlyShelterDao;
	
	public YearlyShelterDao getMyYearlyShelterDao() {
		return myYearlyShelterDao;
	}

	public void setMyYearlyShelterDao(YearlyShelterDao myYearlyShelterDao) {
		this.myYearlyShelterDao = myYearlyShelterDao;
	}

	public YearlyFoundationDao getMyYearlyFoundationDao() {
		return myYearlyFoundationDao;
	}

	public void setMyYearlyFoundationDao(YearlyFoundationDao myYearlyFoundationDao) {
		this.myYearlyFoundationDao = myYearlyFoundationDao;
	}

	public DonorCategoryDao getMyDonorCategoryDao() {
		return myDonorCategoryDao;
	}

	public void setMyDonorCategoryDao(DonorCategoryDao myDonorCategoryDao) {
		this.myDonorCategoryDao = myDonorCategoryDao;
	}

	public CategoryDao getMyCategoryDao() {
		return myCategoryDao;
	}

	public void setMyCategoryDao(CategoryDao myCategoryDao) {
		this.myCategoryDao = myCategoryDao;
	}

	public DonorDao getMyDonor() {
		return myDonor;
	}

	public void setMyDonor(DonorDao myDonor) {
		this.myDonor = myDonor;
	}

	public ShelterDao getMyShelterDao() {
		return myShelterDao;
	}

	public void setMyShelterDao(ShelterDao myShelterDao) {
		this.myShelterDao = myShelterDao;
	}

	public DonorShelterDao getMyDonorShelterDao() {
		return myDonorShelterDao;
	}

	public void setMyDonorShelterDao(DonorShelterDao myDonorShelterDao) {
		this.myDonorShelterDao = myDonorShelterDao;
	}

	public List<Shelter> getAllShelterName(String s) {

		List<Shelter> l = myShelterDao.getAllShelter(s);
		
		return l;
	}

	String breakfast = "0";
	String lunch = "0";
	String dinner = "0";
	public void setRegDonate(DonorRegForm myForm) {
		// TODO Auto-generated method stub
		Donor inDonor = new Donor();
		DonorShelter ds = new DonorShelter();//
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date())
				.toString();
		Date d = new Date();
		
		inDonor.setId(null);
		inDonor.setDonorName(myForm.getFrmRegDonorName());
		inDonor.setDonorNrc(myForm.getFrmRegDonorNRC());
		inDonor.setDonorPhNo(myForm.getFrmRegDonorPhone());
		inDonor.setDonorEmail(myForm.getFrmRegDonorEmail());
		inDonor.setDonorAddress(myForm.getFrmRegDonorAddress());
		inDonor.setAmount(Integer.parseInt(myForm.getFrmRegAmount()));
		inDonor.setCreditCard(myForm.getFrmRegDonorCreditCard());
		inDonor.setKindOfDonate(Integer.parseInt(myForm.getRadioTest()));
		inDonor.setNoOfDonateTime(0);
		inDonor.setComment(myForm.getFrmRegDonorComment());

		Donor idDonor = new Donor();
		Category idCategory = new Category();
		Shelter idShelter = new Shelter();
		idDonor = myDonor.SaveDonor(inDonor);

		idShelter = myShelterDao.getShelterByShelterName(myForm
				.getFrmShelterName());

		idCategory = myCategoryDao.getCategoryById(Integer.parseInt(myForm
				.getFrmRegCategoryId()));
		if(myForm.getRadioTest().equals("2"))
		{
			int year_no=(Integer. parseInt( myForm.getYearlyFee1()) -Integer. parseInt( myForm.getYearlyFee()))+1;
		Calendar c = Calendar.getInstance();
		
		c.setTime(new Date());
		
		
		
			int year =Integer. parseInt( myForm.getYearlyFee());
			int count=0;
			for(int i=0;i<year_no;i++)
			{
				c.add(Calendar.YEAR, count);
				count=0;
				Date newDate = c.getTime();
				DonorShelter inDonorShelter = new DonorShelter();

				inDonorShelter.setId(null);

				inDonorShelter.setKindOfMeal("000");
				inDonorShelter.setDonateDate(newDate);
				inDonorShelter.setDonor(idDonor);
				inDonorShelter.setCategory(idCategory);
				inDonorShelter.setShelter(idShelter);
				myDonorShelterDao.SaveDonorShelter(inDonorShelter);
				count++;
			}
			
		}
		else if(myForm.getRadioTest().equals("1"))
		{
			String month=myForm.getMonthlyFee();
			String[] parts = month.split("-");
			
			String month1=myForm.getMonthlyFee1();
			String[] parts1 = month1.split("-");
			int month_no=0;
			if(Integer. parseInt( parts1[0])==Integer. parseInt( parts[0]))
			{
				month_no=(Integer. parseInt( parts1[1])-Integer. parseInt( parts[1]))+1;
				
			}
			else{
				month_no=(12-Integer. parseInt( parts[1]))+Integer. parseInt( parts1[1])+1;
				
			}
			
			//int month_no =Integer. parseInt( myForm.getMonthlyFee1())-Integer. parseInt( myForm.getMonthlyFee());
			System.out.println(month_no+"eeeeeeeeeeee");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
			//int month =Integer. parseInt( myForm.getMonthlyFee());
			int count=0;
			for(int i=0;i<month_no;i++)
			{
				c.add(Calendar.MONTH, count);
				count=0;
				Date newDate = c.getTime();
				DonorShelter inDonorShelter = new DonorShelter();

				inDonorShelter.setId(null);

				inDonorShelter.setKindOfMeal("000");
				inDonorShelter.setDonateDate(newDate);
				inDonorShelter.setDonor(idDonor);
				inDonorShelter.setCategory(idCategory);
				inDonorShelter.setShelter(idShelter);
				myDonorShelterDao.SaveDonorShelter(inDonorShelter);
				count++;
			}
			
		}
		else
			{
		DonorShelter inDonorShelter = new DonorShelter();	
		inDonorShelter.setId(null);
		inDonorShelter.setKindOfMeal("000");
		inDonorShelter.setDonateDate(d);
		inDonorShelter.setDonor(idDonor);
		inDonorShelter.setCategory(idCategory);
		inDonorShelter.setShelter(idShelter);
		myDonorShelterDao.SaveDonorShelter(inDonorShelter);
			}
	}

	public void getAllCategory(DonorRegForm myForm) {
		// TODO Auto-generated method stub

		List<Category> l = myCategoryDao.getAllCategory();
		myForm.setFrmRegCategoryList(l);
		myForm.setFrmRegCategoryId("0");
	}

	public void setRegDonateFoundation(DonorRegForm myForm) {
		// TODO Auto-generated method stub
		Donor inDonor = new Donor();
		DonorShelter inDonorShelter = new DonorShelter();
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date())
				.toString();
		Date d = new Date();

		inDonor.setId(null);
		inDonor.setDonorName(myForm.getFrmRegDonorName());
		inDonor.setDonorNrc(myForm.getFrmRegDonorNRC());
		inDonor.setDonorPhNo(myForm.getFrmRegDonorPhone());
		inDonor.setDonorEmail(myForm.getFrmRegDonorEmail());
		inDonor.setDonorAddress(myForm.getFrmRegDonorAddress());
		inDonor.setAmount(Integer.parseInt(myForm.getFrmRegAmount()));
		inDonor.setCreditCard(myForm.getFrmRegDonorCreditCard());
		inDonor.setKindOfDonate(Integer.parseInt(myForm.getRadioTest()));
		inDonor.setNoOfDonateTime(0);
		inDonor.setComment(myForm.getFrmRegDonorComment());

		Donor idDonor = new Donor();
		Category idCategory = new Category();
		
		idDonor = myDonor.SaveDonor(inDonor);

		idCategory = myCategoryDao.getCategoryById(Integer.parseInt(myForm
				.getFrmRegCategoryId()));

		
		if(myForm.getRadioTest().equals("2"))
		{
			int year_no=(Integer. parseInt( myForm.getYearlyFee1()) -Integer. parseInt( myForm.getYearlyFee()))+1;
			//Calendar c = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
			//int year_no =Integer. parseInt( myForm.getYearlyFee());
			int count=0;
			for(int i=0;i<year_no;i++)
			{
				c.add(Calendar.YEAR, count);
				count=0;
				Date newDate = c.getTime();
				DonorCategory inDonorCategory = new DonorCategory();

				inDonorCategory.setId(null);
				inDonorCategory.setDonateDate(newDate);
				inDonorCategory.setDonor(idDonor);
				inDonorCategory.setCategory(idCategory);

				myDonorCategoryDao.SaveDonorCategory(inDonorCategory);
				count++;
			}
			
		}
		else if(myForm.getRadioTest().equals("1"))
		{
			String month=myForm.getMonthlyFee();
			String[] parts = month.split("-");
			
			String month1=myForm.getMonthlyFee1();
			String[] parts1 = month1.split("-");
			int month_no=0;
			if(Integer. parseInt( parts1[0])==Integer. parseInt( parts[0]))
			{
				month_no=(Integer. parseInt( parts1[1])-Integer. parseInt( parts[1]))+1;
				
			}
			else{
				month_no=(12-Integer. parseInt( parts[1]))+Integer. parseInt( parts1[1])+1;
				
			}
			System.out.println("here");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
			//int month_no =Integer. parseInt( myForm.getMonthlyFee());
			int count=0;
			for(int i=0;i<month_no;i++)
			{
				c.add(Calendar.MONTH, count);
				count=0;
				Date newDate = c.getTime();
				DonorCategory inDonorCategory = new DonorCategory();

				inDonorCategory.setId(null);
				inDonorCategory.setDonateDate(newDate);
				inDonorCategory.setDonor(idDonor);
				inDonorCategory.setCategory(idCategory);

				myDonorCategoryDao.SaveDonorCategory(inDonorCategory);
				count++;
			}
			
		}
		else
			{
			DonorCategory inDonorCategory = new DonorCategory();	
			inDonorCategory.setId(null);
			inDonorCategory.setDonateDate(d);
			inDonorCategory.setDonor(idDonor);
			inDonorCategory.setCategory(idCategory);

			myDonorCategoryDao.SaveDonorCategory(inDonorCategory);
			}
	}

	public Shelter checkShelterbyShelter(String frmShelterName) {
		// TODO Auto-generated method stub
		Shelter s = myShelterDao.getShelterByShelterName(frmShelterName);
		return s;
	}

	// Meal Date Check
		public List<DonorShelter> checkDonateMealDate(DonorRegForm myForm)
				throws ParseException {
			// TODO Auto-generated method stub
			
			Shelter idShelter = new Shelter();

			idShelter = myShelterDao.getShelterByShelterName(myForm
					.getFrmShelterName());

			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-mm-dd");
			Date myDate1 = myformat.parse(myForm.getFrmRegDonateDate());
			
			List<DonorShelter> l = myDonorShelterDao.getAllDateForMealByShelterId(
					idShelter.getId(), myDate1);
			return l;
		}

		// to save donor who donate for food
		public void saveNewDonor(DonorRegForm myForm) throws ParseException {
			// Date d = new Date();
			DonorShelter inDonorShelter = new DonorShelter();
			Donor inDonor = new Donor();
			inDonor.setId(null);
			inDonor.setDonorName(myForm.getFrmRegDonorName());
			inDonor.setAmount(Integer.parseInt(myForm.getFrmRegAmount()));
			inDonor.setDonorPhNo(myForm.getFrmRegDonorPhone());
			inDonor.setDonorEmail(myForm.getFrmRegDonorEmail());
			inDonor.setComment(myForm.getFrmRegDonorComment());
			inDonor.setDonorNrc(myForm.getFrmRegDonorNRC());
			inDonor.setDonorAddress(myForm.getFrmRegDonorAddress());
			inDonor.setCreditCard(myForm.getFrmRegDonorCreditCard());

			Shelter idShelter = new Shelter();

			idShelter = myShelterDao.getShelterByShelterName(myForm
					.getFrmShelterName());
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-mm-dd");
			Date myDate1 = myformat.parse(myForm.getFrmRegDonateDate());

			if ((myForm.getFrmBreakfastMeal()) != null) {
				breakfast = "1";
				
			} else {
				breakfast = "0";
			}
			if ((myForm.getFrmLunchMeal()) != null) {
				lunch = "1";
				inDonorShelter.setKindOfMeal(lunch);
			} else {
				lunch = "0";
			}
			if ((myForm.getFrmDinnerMeal()) != null) {
				dinner = "1";
				inDonorShelter.setKindOfMeal(dinner);
			} else {
				dinner = "0";
			}
			breakfast = breakfast + lunch + dinner;

			// System.out.println(breakfast);

			Donor idDonor = new Donor();
			Category idCategory = new Category();

			idDonor = myDonor.SaveDonor(inDonor);

			idCategory = myCategoryDao.getCategoryById(3);

			inDonorShelter.setId(null);

			inDonorShelter.setDonateMealDate(myDate1);
			inDonorShelter.setDonor(idDonor);
			inDonorShelter.setKindOfMeal(breakfast);
			inDonorShelter.setCategory(idCategory);
			inDonorShelter.setShelter(idShelter);

			myDonorShelterDao.SaveDonorShelter(inDonorShelter);
		}
	public String checkCreditCard(String frmRegCreditCardType,
			String frmRegDonorCreditCard, String frmRegCardHolder,
			String frmRegCardExpireDate, String frmRegAmount) throws Exception {
		// TODO Auto-generated method stub
		CheckValid check = new CheckValid();
		String c = null;
		try {
			 c = check.CheckCredit(frmRegCreditCardType,
				frmRegDonorCreditCard, frmRegCardHolder,
				frmRegCardExpireDate, Integer.parseInt(frmRegAmount));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	//Report For Direct to Foundation
	public void getlessCategory(DonorRegForm myForm) {
		// TODO Auto-generated method stub
		Date d=new Date();
		List<Category> l=myForm.getFrmRegCategoryList();
		/*List<YearlyFoundationView> ly=new ArrayList();*/
		double totalamount=0;
		double lastamount=99999999;
		double mostamount=0;
		int []total=new int[l.size()];
		/*YearlyFoundationView myfv=new YearlyFoundationView();
		YearlyFoundationView lyfv=new YearlyFoundationView();*/
		String last="";
		String most="";
		for(int i=0;i<l.size();i++)
		{
			Category c=l.get(i);
			YearlyFoundationTable y=myYearlyFoundationDao.getAmountByDateAndCategory(c,d);
			if(y!=null)
			{ total[i]=Integer.parseInt(y.getYearlyFund().toString());}
			System.out.println(total[i]);
			totalamount+=total[i];
			if(lastamount>total[i])
			{
				lastamount=total[i];
			last=c.getType();
			}
			if(mostamount<total[i])
			{
				mostamount=total[i];
			most=c.getType();
				
			}
			/*ly.add(y);*/
		}
		
		/*double persent=(lastamount/totalamount) * 100;*/
		double per=(lastamount/totalamount) * 100;
		String kk=String.format("%.2f",per);
		myForm.setLastamount(kk);
		myForm.setLastcategory(last);
		
		/*System.out.println("we have only"+most+ " is "+(mostamount/totalamount)*100 + " %");
		System.out.println("we have only "+(lastamount/totalamount)*100 + " %  for "+last+ " is ");*/
		System.out.println("bb"+String.valueOf((lastamount/totalamount)*100));
		System.out.println(lastamount);
	}
	public void getlessShelterCategory(DonorRegForm myForm) {
		// TODO Auto-generated method stub
		Date d=new Date();
		List<Category> l=myForm.getFrmRegCategoryList();
		/*List<YearlyFoundationView> ly=new ArrayList();*/
		double totalamount=0;
		double lastamount=99999999;
		double mostamount=0;
		int []total=new int[l.size()];
		/*YearlyFoundationView myfv=new YearlyFoundationView();
		YearlyFoundationView lyfv=new YearlyFoundationView();*/
		String last="";
		String most="";
		for(int i=0;i<l.size();i++)
		{
			Category c=l.get(i);
			myForm.getFrmShelterName();
			YearlyShelterTable y=myYearlyShelterDao.getAmountByDateAndCategoryAndShelter(c,d,"Aye Yeik Thar");
			if(y!=null)
			{ total[i]=Integer.parseInt(y.getYearlyFund().toString());}
			System.out.println(total[i]);
			totalamount+=total[i];
			if(lastamount>total[i])
			{
				lastamount=total[i];
			last=c.getType();
			}
			if(mostamount<total[i])
			{
				mostamount=total[i];
			most=c.getType();
				
			}
			/*ly.add(y);*/
		}
		
		double per=(lastamount/totalamount) * 100;
		String kk=String.format("%.2f",per);
		/*String.valueOf((lastamount/totalamount)*100)*/
		myForm.setLastamount(kk);
		myForm.setLastcategory(last);
		System.out.println("aaa"+String.valueOf((lastamount/totalamount)*100));
		/*System.out.println("we have only"+most+ " is "+(mostamount/totalamount)*100 + " %");
		System.out.println("we have only "+(lastamount/totalamount)*100 + " %  for "+last+ " is ");*/
	}
	public String [] getAmountByShelterName(String s)
	{
		List<Category> l = myCategoryDao.getAllCategory();
		
		Date d=new Date();
		double totalamount=0;
		double lastamount=99999999;
		double mostamount=0;
		int []total=new int[l.size()];
		/*YearlyFoundationView myfv=new YearlyFoundationView();
		YearlyFoundationView lyfv=new YearlyFoundationView();*/
		String last="";
		String most="";
		String [] outamount=new String[2];
		for(int i=0;i<l.size();i++)
		{
			Category c=l.get(i);
			
			YearlyShelterTable y=myYearlyShelterDao.getAmountByDateAndCategoryAndShelter(c,d,s);
			if(y!=null)
			{ total[i]=Integer.parseInt(y.getYearlyFund().toString());}
			System.out.println(total[i]);
			totalamount+=total[i];
			if(lastamount>total[i])
			{
				lastamount=total[i];
				outamount[0]=c.getType();
			}
			if(mostamount<total[i])
			{
				mostamount=total[i];
			most=c.getType();
				
			}
			if(lastamount==0){
				outamount[1]="0.00";
			}
			else{
			double aaaa=(lastamount/totalamount)*100;
			outamount[1]=String.valueOf(String.format("%.2f", aaaa));
			
			}
			
	}
		return outamount;
}

	public String getCategoryById(String frmRegCategoryId) {
		// TODO Auto-generated method stub
		Category c = myCategoryDao.getCategoryById(Integer.parseInt(frmRegCategoryId));
		return c.getType();
		
	}
}
