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

import com.ictti.orrs.business.entity.AdminMonthlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminMonthlyReportTable;
import com.ictti.orrs.business.entity.AdminYearlyReportAllCategoryTable;
import com.ictti.orrs.business.entity.AdminYearlyReportTable;
import com.ictti.orrs.business.entity.Category;
import com.ictti.orrs.business.service.AdminReportService;
import com.ictti.orrs.presentation.form.AdminReportForm;

public class AdminMonthlyReportAction extends BaseAction {
	AdminReportService myAdminReportService;
	
	public AdminReportService getMyAdminReportService() {
		return myAdminReportService;
	}

	public void setMyAdminReportService(AdminReportService myAdminReportService) {
		this.myAdminReportService = myAdminReportService;
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
		AdminReportForm myForm = (AdminReportForm) form;
		if(request.getParameter("btnShow")!=null){
			String category = myForm.getFrmCategoryId();
			String chart = myForm.getChart();
			String year = myForm.getFrmYearId();
			//Category c = myAdminReportService.getCategoryById(Integer.parseInt(category));
			//System.out.println(c.getType());
			ActionErrors errors = new ActionErrors();
			if(year.equals("0")  ){
				/*errors.add("charterror",new ActionMessage("errors.chartyear"));//errors.add(jsp,msg.properties);
				saveErrors(request, errors);
				myForm.setFrmFileName(null);
				myForm.setFrmAdminMonthlyReportAllList(null);
				myForm.setFrmAdminMonthlyReportList(null);
				return "gotoReport";*/
			}
			else if(chart.equals("0")){
				/*errors.add("charterror",new ActionMessage("errors.chart"));//errors.add(jsp,msg.properties);
				saveErrors(request, errors);
				myForm.setFrmFileName(null);
				myForm.setFrmAdminMonthlyReportAllList(null);
				myForm.setFrmAdminMonthlyReportList(null);
				return "gotoReport";*/
			}
			else if(category.equals("0")){
				List<AdminMonthlyReportAllCategoryTable> list = myAdminReportService.getReportByYearAndAllCategory(Integer.parseInt(year));
				if(list.isEmpty())
				{
					errors.add("reportlisterror",new ActionMessage("errors.reportlist"));//errors.add(jsp,msg.properties);
					saveErrors(request, errors);
					myForm.setFrmFileName(null);
					myForm.setFrmAdminMonthlyReportAllList(null);
					myForm.setFrmAdminMonthlyReportList(null);
					return "gotoReport";
				}
				else{
					String prjPath = getServlet().getServletContext().getRealPath("");
					if (myForm.getChart().equals("1")) {
						
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
						myForm.setFrmFileName("images/BarChartServlet.png");

						System.out.println("MyForm++++++" + filename);
						try {

							ChartUtilities.saveChartAsPNG(outputFile, objCht,
									640, 480);
						} catch (IOException ioEx) {
							ioEx.printStackTrace();
						}
						myForm.setFrmAdminMonthlyReportAllList(null);
						myForm.setFrmAdminMonthlyReportList(null);
					return "gotoReport";
					}
					if(myForm.getChart().equals("2")){
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
						myForm.setFrmFileName("images/PieChart.png");
						System.out.println("outputfile direct output"+outputFile.toString());
						try {
							ChartUtilities.saveChartAsPNG(outputFile, objCht,
									640, 480);
						} catch (IOException ioEx) {
							ioEx.printStackTrace();
						}
						myForm.setFrmAdminMonthlyReportAllList(null);
						myForm.setFrmAdminMonthlyReportList(null);
						return "gotoReport";
					}
					if(myForm.getChart().equals("3")){
						// Prepare Series
						String series = "Monthly Donate Amount";
						
						
						DefaultCategoryDataset objDcD = new DefaultCategoryDataset();
						for (int i = 0; i < list.size(); i++) {
							
							objDcD.addValue(list.get(i).getAmount(),series, list.get(i).getMonth());
						}
						// Create Line Chart
						JFreeChart objCht = ChartFactory.createLineChart(
								"Report For Donation All Category in "+year, "Year",
								"Amount [MMK]", objDcD,
								PlotOrientation.VERTICAL, true, true, false);
						// Output to browser in PNG Format 640 X 480
						File outputFile = new File(prjPath+"/images/LineChart.png");
						myForm.setFrmFileName("images/LineChart.png");
						try {
							
							ChartUtilities.saveChartAsPNG(outputFile, objCht,640, 480);
						} catch (IOException ioEx) {
							ioEx.printStackTrace();
						}
						myForm.setFrmAdminMonthlyReportAllList(null);
						myForm.setFrmAdminMonthlyReportList(null);
						return "gotoReport";
						}
					if(myForm.getChart().equals("4"))
					{
						myForm.setFrmFileName(null);
						myForm.setFrmAdminMonthlyReportAllList(list);
						myForm.setFrmAdminMonthlyReportList(null);
						System.out.println("Size is"+list.size());
						myForm.setActualPage(1);
						myForm.setBegin(0);
						myForm.setiMaxShow(6);
						if(list!=null)
							myForm.setiMaxData(list.size());
						
						//myForm.setBegin(1);
						//myForm.setEnd(list.size());
						return "gotoReport";
					}
				}
			}
			else{
				List<AdminMonthlyReportTable> list = myAdminReportService.getReportByCategoryAndYear(category,Integer.parseInt(year));
					if(list.isEmpty())
					{
						errors.add("reportlisterror",new ActionMessage("errors.reportlist"));//errors.add(jsp,msg.properties);
						saveErrors(request, errors);
						myForm.setFrmFileName(null);
						myForm.setFrmAdminMonthlyReportList(null);
						myForm.setFrmAdminMonthlyReportAllList(null);

						return "gotoReport";
					}
					else{
						String prjPath = getServlet().getServletContext().getRealPath("");
						if (myForm.getChart().equals("1")) {
							
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
									"Report For Donation " +category+" in "+year,
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
							myForm.setFrmFileName("images/BarChartServlet.png");

							System.out.println("MyForm++++++" + filename);
							try {

								ChartUtilities.saveChartAsPNG(outputFile, objCht,
										640, 480);
							} catch (IOException ioEx) {
								ioEx.printStackTrace();
							}
							myForm.setFrmAdminMonthlyReportAllList(null);
							myForm.setFrmAdminMonthlyReportList(null);
						return "gotoReport";
						}
						if(myForm.getChart().equals("2")){
							// Prepare DataSet
							DefaultPieDataset objDcd = new DefaultPieDataset();
							// Set Sales Amount per Month
							for (int i = 0; i < list.size(); i++) {
								
								objDcd.setValue(list.get(i).getMonth(), list.get(i)
										.getAmount());
							}
							// Create Pie Chart
							JFreeChart objCht = ChartFactory.createPieChart(
									"Report for Donation "+category+" in "+year, // Title
									objDcd, // Data set
									true, // Legend
									false, // Tool Tips
									false); // URL
							
							
							
							File outputFile = new File(prjPath+ "/images/PieChart.png");
							myForm.setFrmFileName("images/PieChart.png");
							System.out.println("outputfile direct output"+outputFile.toString());
							try {
								ChartUtilities.saveChartAsPNG(outputFile, objCht,
										640, 480);
							} catch (IOException ioEx) {
								ioEx.printStackTrace();
							}
							myForm.setFrmAdminMonthlyReportAllList(null);
							myForm.setFrmAdminMonthlyReportList(null);
							return "gotoReport";
						}
						if(myForm.getChart().equals("3")){
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
							myForm.setFrmFileName("images/LineChart.png");
							try {
								
								ChartUtilities.saveChartAsPNG(outputFile, objCht,640, 480);
							} catch (IOException ioEx) {
								ioEx.printStackTrace();
							}
							myForm.setFrmAdminMonthlyReportAllList(null);
							myForm.setFrmAdminMonthlyReportList(null);
							return "gotoReport";
							}
						if(myForm.getChart().equals("4"))
						{
							myForm.setFrmFileName(null);
							//myShelterReportService.getReportTable(myShelterForm);
							myForm.setFrmAdminMonthlyReportList(list);
							myForm.setFrmAdminMonthlyReportAllList(null);

							myForm.setActualPage(1);
							myForm.setBegin(0);
							myForm.setiMaxShow(6);
							if(list!=null)
								myForm.setiMaxData(list.size());
							
							return "gotoReport";
						}
					}
			}
		}
		
		if(request.getParameter("next")!=null)
			myForm.setActualPage(myForm.getActualPage()+1);
		if(request.getParameter("prev")!=null)
		myForm.setActualPage(myForm.getActualPage()-1);
		return "gotoReport";
	
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("aid") == null) {
			return "gotoLogin";
		}
		AdminReportForm myForm = (AdminReportForm) form;
		myForm.setFrmAdminMonthlyReportList(null);
		myForm.setFrmAdminMonthlyReportAllList(null);

		//myForm.setFrmFileName(null);
		myAdminReportService.getAllCategory(myForm);
		myAdminReportService.getAllYear(myForm);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int year = c.getWeekYear();
		System.out.println("year is"+year);
		List<AdminMonthlyReportAllCategoryTable> list = myAdminReportService.getReportByYearAndAllCategory(year);
		ActionErrors errors = new ActionErrors();
		if(list.isEmpty())
		{
			errors.add("reportlisterror",new ActionMessage("errors.reportlist"));//errors.add(jsp,msg.properties);
			saveErrors(request, errors);
			myForm.setFrmFileName(null);
			myForm.setFrmAdminMonthlyReportAllList(null);
			myForm.setFrmAdminMonthlyReportList(null);
			return "gotoReport";
		}
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
			myForm.setFrmFileName("images/BarChartServlet.png");

			System.out.println("MyForm++++++" + filename);
			try {

				ChartUtilities.saveChartAsPNG(outputFile, objCht,
						640, 480);
			} catch (IOException ioEx) {
				ioEx.printStackTrace();
			}
			myForm.setFrmAdminMonthlyReportAllList(null);
			myForm.setFrmAdminMonthlyReportList(null);
			myForm.setFrmYearId(String.valueOf(year));
			myForm.setFrmCategoryId("All");
			myForm.setChart("0");
		return "gotoReport";
		
	}

}
