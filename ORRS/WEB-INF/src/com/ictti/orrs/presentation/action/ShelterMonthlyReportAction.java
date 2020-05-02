package com.ictti.orrs.presentation.action;

import java.awt.Color;
import java.awt.GradientPaint;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.ictti.orrs.business.entity.AnnualReportTable;
import com.ictti.orrs.business.entity.ShelterMonthlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.ShelterMonthlyReportTable;
import com.ictti.orrs.business.entity.ShelterYearlyReportTable;
import com.ictti.orrs.business.service.AnnualReportService;
import com.ictti.orrs.business.service.ShelterReportService;
import com.ictti.orrs.presentation.form.AnnualReportForm;
import com.ictti.orrs.presentation.form.ShelterForm;
import com.ictti.orrs.presentation.form.ShelterReportForm;


public class ShelterMonthlyReportAction extends BaseAction {
	 ShelterReportService myShelterReportService;
	 
	public ShelterReportService getMyShelterReportService() {
		return myShelterReportService;
	}
	public void setMyShelterReportService(
			ShelterReportService myShelterReportService) {
		this.myShelterReportService = myShelterReportService;
	}
	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {

		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null)
			return "gotoShelterLogin";
		ShelterReportForm myShelterForm = (ShelterReportForm) form;
		ShelterForm myForm = (ShelterForm) request.getSession()
				.getAttribute("ShelterFormBean");
		myShelterForm.setLoginShelter(myForm.getLoginShelter());
		System.out.println(myForm.getShelterId());
		
		if(request.getParameter("btnShow")!=null){
			String year = myShelterForm.getFrmYearId();
			String category = myShelterForm.getFrmCategoryId();
			String chart = myShelterForm.getChart();
			System.out.println(year);
			ActionErrors errors = new ActionErrors();
			if(year.equals("0")){
				/*errors.add("charterror",new ActionMessage("errors.chart"));//errors.add(jsp,msg.properties);
				saveErrors(request, errors);
				return "gotoReport";*/
			}
			else if(category.equals("0")){
				List<ShelterMonthlyReportAllCategoryTable> list = myShelterReportService.getReportByYearAndSno(Integer.parseInt(year),myForm.getShelterId());
				if(list.isEmpty())
				{
					errors.add("reportlisterror",new ActionMessage("errors.reportlist"));//errors.add(jsp,msg.properties);
					saveErrors(request, errors);
					myShelterForm.setFrmFileName(null);
					myShelterForm.setFrmShelterMonthlyReportList(null);
					myShelterForm.setFrmShelterMonthlyReportAllList(null);
					return "gotoReport";
				}
				else{

					String prjPath = getServlet().getServletContext().getRealPath("");
					if (myShelterForm.getChart().equals("1")) {
					
						// Prepare Series(row data)
						String series = "Monthly Donate Amount";

						// Prepare DataSet
						DefaultCategoryDataset objDcd = new DefaultCategoryDataset();
						// Set Sales Amount per Month
						for (int i = 0; i < list.size(); i++) {
							objDcd.addValue(((list.get(i)).getAmount()),series, list.get(i).getMonth());

						}
						// Create Bar Chart(title,x,y,series
						JFreeChart objCht = ChartFactory.createBarChart(
								"Report For Donation All Category in "+year,
								"Month", "Amount [MMK]", objDcd,
								PlotOrientation.VERTICAL, true, true, false);
						
						  CategoryPlot plot = objCht.getCategoryPlot();//(title,horizontal,vertical, 
						  BarRenderer renderer = (BarRenderer) plot.getRenderer();
						  renderer.setDrawBarOutline(false); // Create
							 GradientPaint gradient = new GradientPaint(0.0f, 0.0f,new Color(0,128,128),0.0f, 0.0f,new Color(0,128,128)); // Set GradientPaint
						 renderer.setSeriesPaint(0, gradient);
						 

						File outputFile = new File(prjPath
								+ "/images/BarChartServlet.png");
						System.out.println(outputFile.toString());
						String filename = outputFile.toString();
						myShelterForm.setFrmFileName("images/BarChartServlet.png");

						System.out.println("MyForm++++++" + filename);
						try {

							ChartUtilities.saveChartAsPNG(outputFile, objCht,
									640, 480);
						} catch (IOException ioEx) {
							ioEx.printStackTrace();
						}
						myShelterForm.setFrmShelterMonthlyReportList(null);
						myShelterForm.setFrmShelterMonthlyReportAllList(null);
					return "gotoReport";
					}
					if(myShelterForm.getChart().equals("2")){
						// Prepare DataSet
						DefaultPieDataset objDcd = new DefaultPieDataset();
						// Set Sales Amount per Month
						for (int i = 0; i < list.size(); i++) {
							
							objDcd.setValue(list.get(i).getMonth(), list.get(i)
									.getAmount());
						}
						// Create Pie Chart
						JFreeChart objCht = ChartFactory.createPieChart(
								"Report For Donation All Category in "+year, // Title
								objDcd, // Data set
								true, // Legend
								false, // Tool Tips
								false); // URL
						
						
						
						File outputFile = new File(prjPath+ "/images/PieChart.png");
						myShelterForm.setFrmFileName("images/PieChart.png");
						System.out.println("outputfile direct output"+outputFile.toString());
						try {
							ChartUtilities.saveChartAsPNG(outputFile, objCht,
									640, 480);
						} catch (IOException ioEx) {
							ioEx.printStackTrace();
						}
						myShelterForm.setFrmShelterMonthlyReportList(null);
						myShelterForm.setFrmShelterMonthlyReportAllList(null);
						return "gotoReport";
					}
					if(myShelterForm.getChart().equals("3")){
						// Prepare Series
						String series = "Monthly Donate Amount";
						
						
						DefaultCategoryDataset objDcD = new DefaultCategoryDataset();
						for (int i = 0; i < list.size(); i++) {
							
							objDcD.addValue(list.get(i).getAmount(),series, list.get(i).getMonth());
						}
						// Create Line Chart
						JFreeChart objCht = ChartFactory.createLineChart(
								"Report For Donation All Category in "+year, "Month",
								"Amount [MMK]", objDcD,
								PlotOrientation.VERTICAL, true, true, false);
						// Output to browser in PNG Format 640 X 480
						File outputFile = new File(prjPath+"/images/LineChart.png");
						myShelterForm.setFrmFileName("images/LineChart.png");
						try {
							
							ChartUtilities.saveChartAsPNG(outputFile, objCht,640, 480);
						} catch (IOException ioEx) {
							ioEx.printStackTrace();
						}
						myShelterForm.setFrmShelterMonthlyReportList(null);
						myShelterForm.setFrmShelterMonthlyReportAllList(null);
						return "gotoReport";
						}
					if(myShelterForm.getChart().equals("4"))
					{
						myShelterForm.setFrmFileName(null);
						//myShelterReportService.getReportTable(myShelterForm);
						myShelterForm.setFrmShelterMonthlyReportList(null);
						myShelterForm.setFrmShelterMonthlyReportAllList(list);
						myShelterForm.setActualPage(1);
						myShelterForm.setBegin(0);
						myShelterForm.setiMaxShow(6);
						if(list!=null)
							myShelterForm.setiMaxData(list.size());
						return "gotoReport";
					}
				
				}
					
			}
			else{
				
				List<ShelterMonthlyReportTable> list = myShelterReportService.getReportByYearAndCategoryAndShelter(Integer.parseInt(year),category,myForm.getShelterId());
				if(list.isEmpty())
				{
					errors.add("reportlisterror",new ActionMessage("errors.reportlist"));//errors.add(jsp,msg.properties);
					saveErrors(request, errors);
					myShelterForm.setFrmFileName(null);
					myShelterForm.setFrmShelterMonthlyReportList(null);
					myShelterForm.setFrmShelterMonthlyReportAllList(null);
					return "gotoReport";
				}
				else{
					String prjPath = getServlet().getServletContext().getRealPath("");
					if (myShelterForm.getChart().equals("1")) {
					
						// Prepare Series(row data)
						String series = "Monthly Donate Amount";

						// Prepare DataSet
						DefaultCategoryDataset objDcd = new DefaultCategoryDataset();
						// Set Sales Amount per Month
						for (int i = 0; i < list.size(); i++) {
							objDcd.addValue(((list.get(i)).getAmount()),series, list.get(i).getMonth());

						}
						// Create Bar Chart(title,x,y,series
						JFreeChart objCht = ChartFactory.createBarChart(
								"Report For Donation "+category+" in "+year,
								"Month", "Amount [MMK]", objDcd,
								PlotOrientation.VERTICAL, true, true, false);
						
						  CategoryPlot plot = objCht.getCategoryPlot();//(title,horizontal,vertical, 
						  BarRenderer renderer = (BarRenderer) plot.getRenderer();
						  renderer.setDrawBarOutline(false); // Create
							 GradientPaint gradient = new GradientPaint(0.0f, 0.0f,new Color(0,128,128),0.0f, 0.0f,new Color(0,128,128)); // Set GradientPaint
						 renderer.setSeriesPaint(0, gradient);
						 

						File outputFile = new File(prjPath
								+ "/images/BarChartServlet.png");
						System.out.println(outputFile.toString());
						String filename = outputFile.toString();
						myShelterForm.setFrmFileName("images/BarChartServlet.png");

						System.out.println("MyForm++++++" + filename);
						try {

							ChartUtilities.saveChartAsPNG(outputFile, objCht,
									640, 480);
						} catch (IOException ioEx) {
							ioEx.printStackTrace();
						}
						myShelterForm.setFrmShelterMonthlyReportList(null);
						myShelterForm.setFrmShelterMonthlyReportAllList(null);
					return "gotoReport";
					}
					if(myShelterForm.getChart().equals("2")){
						// Prepare DataSet
						DefaultPieDataset objDcd = new DefaultPieDataset();
						// Set Sales Amount per Month
						for (int i = 0; i < list.size(); i++) {
							
							objDcd.setValue(list.get(i).getMonth(), list.get(i)
									.getAmount());
						}
						// Create Pie Chart
						JFreeChart objCht = ChartFactory.createPieChart(
								"Report For Donation "+category+" in " +year, // Title
								objDcd, // Data set
								true, // Legend
								false, // Tool Tips
								false); // URL
						
						
						
						File outputFile = new File(prjPath+ "/images/PieChart.png");
						myShelterForm.setFrmFileName("images/PieChart.png");
						System.out.println("outputfile direct output"+outputFile.toString());
						try {
							ChartUtilities.saveChartAsPNG(outputFile, objCht,
									640, 480);
						} catch (IOException ioEx) {
							ioEx.printStackTrace();
						}
						myShelterForm.setFrmShelterMonthlyReportList(null);
						myShelterForm.setFrmShelterMonthlyReportAllList(null);
						return "gotoReport";
					}
					if(myShelterForm.getChart().equals("3")){
						// Prepare Series
						String series = "Monthly Donate Amount";
						
						
						DefaultCategoryDataset objDcD = new DefaultCategoryDataset();
						for (int i = 0; i < list.size(); i++) {
							
							objDcD.addValue(list.get(i).getAmount(),series, list.get(i).getMonth());
						}
						// Create Line Chart
						JFreeChart objCht = ChartFactory.createLineChart(
								"Report For Donation "+category+" in "+year, "Month",
								"Amount [MMK]", objDcD,
								PlotOrientation.VERTICAL, true, true, false);
						// Output to browser in PNG Format 640 X 480
						File outputFile = new File(prjPath+"/images/LineChart.png");
						myShelterForm.setFrmFileName("images/LineChart.png");
						try {
							
							ChartUtilities.saveChartAsPNG(outputFile, objCht,640, 480);
						} catch (IOException ioEx) {
							ioEx.printStackTrace();
						}
						myShelterForm.setFrmShelterMonthlyReportList(null);
						myShelterForm.setFrmShelterMonthlyReportAllList(null);
						return "gotoReport";
						}
					if(myShelterForm.getChart().equals("4"))
					{
						myShelterForm.setFrmFileName(null);
						//myShelterReportService.getReportTable(myShelterForm);
						myShelterForm.setFrmShelterMonthlyReportList(list);
						myShelterForm.setFrmShelterMonthlyReportAllList(null);
						myShelterForm.setActualPage(1);
						myShelterForm.setBegin(0);
						myShelterForm.setiMaxShow(6);
						if(list!=null)
							myShelterForm.setiMaxData(list.size());
						return "gotoReport";
					}
				}
			}
			
		}
		if(request.getParameter("btnCancel")!=null)
		{
			return "gotoHome";
		}
		
		if(request.getParameter("next")!=null)
			myShelterForm.setActualPage(myShelterForm.getActualPage()+1);
		if(request.getParameter("prev")!=null)
			myShelterForm.setActualPage(myShelterForm.getActualPage()-1);
		return "gotoReport";
	
	}
	
	

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null)
			return "gotoShelterLogin";
		ShelterReportForm myShelterForm = (ShelterReportForm) form;
		
		ShelterForm myForm = (ShelterForm) request.getSession().getAttribute("ShelterFormBean");
		myShelterForm.setLoginShelter(myForm.getLoginShelter());
		myShelterReportService.getAllCategory(myShelterForm);
		myShelterReportService.getAllYear(myShelterForm);
		System.out.println("here");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int year = c.getWeekYear();
		System.out.println("year is"+year);
		ActionErrors errors = new ActionErrors();
		List<ShelterMonthlyReportAllCategoryTable> list = myShelterReportService.getReportByYearAndSno(year,myForm.getShelterId());
		if(list.isEmpty())
		{
			errors.add("reportlisterror",new ActionMessage("errors.reportlist"));//errors.add(jsp,msg.properties);
			saveErrors(request, errors);
			myShelterForm.setFrmFileName(null);
			myShelterForm.setFrmShelterMonthlyReportList(null);
			myShelterForm.setFrmShelterMonthlyReportAllList(null);
			return "gotoReport";
		}
		else{

			String prjPath = getServlet().getServletContext().getRealPath("");
			
				// Prepare Series(row data)
				String series = "Monthly Donate Amount";

				// Prepare DataSet
				DefaultCategoryDataset objDcd = new DefaultCategoryDataset();
				// Set Sales Amount per Month
				for (int i = 0; i < list.size(); i++) {
					objDcd.addValue(((list.get(i)).getAmount()),series, list.get(i).getMonth());

				}
				// Create Bar Chart(title,x,y,series
				JFreeChart objCht = ChartFactory.createBarChart(
						"Report For Donation All Category in "+year,
						"Month", "Amount [MMK]", objDcd,
						PlotOrientation.VERTICAL, true, true, false);
				
				  CategoryPlot plot = objCht.getCategoryPlot();//(title,horizontal,vertical, 
				  BarRenderer renderer = (BarRenderer) plot.getRenderer();
				  renderer.setDrawBarOutline(false); // Create
					 GradientPaint gradient = new GradientPaint(0.0f, 0.0f,new Color(0,128,128),0.0f, 0.0f,new Color(0,128,128)); // Set GradientPaint
				 renderer.setSeriesPaint(0, gradient);
				 

				File outputFile = new File(prjPath
						+ "/images/BarChartServlet.png");
				System.out.println(outputFile.toString());
				String filename = outputFile.toString();
				myShelterForm.setFrmFileName("images/BarChartServlet.png");

				System.out.println("MyForm++++++" + filename);
				try {

					ChartUtilities.saveChartAsPNG(outputFile, objCht,
							640, 480);
				} catch (IOException ioEx) {
					ioEx.printStackTrace();
				}
				myShelterForm.setChart("1");
				myShelterForm.setFrmCategoryId("0");
				myShelterForm.setFrmYearId(String.valueOf(year));
		myShelterForm.setFrmShelterMonthlyReportList(null);
		myShelterForm.setFrmShelterMonthlyReportAllList(null);
		return "gotoReport";
		}
	}

}