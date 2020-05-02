<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>

<head>

<title>Outcome Report</title>
</head>


<body>
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody">
		
<h1 style=" padding-left:0px; padding-right:100px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Annual Report</h1>

<html:form action="/adminViewOutcomeReportPath">
						<center>
		
						<table width="50%">

							<tr>
								<td>Year:</td>
								<td><html:select property="frmAnnualId">
										<html:option value="0">All</html:option>
										<html:optionsCollection property="frmAnnualList" value="year"
											label="year" />
									</html:select></td>
									
									<td>Category:</td>
									<td><html:select property="frmCategoryId">
										<html:option value="0">All</html:option>
										<html:optionsCollection property="frmCategoryList" value="category"
											label="category" />
									</html:select></td>

								<td colspan="2" align="center"><html:submit
										property="btnView" value="View" styleId="buttonwto"></html:submit></td>
							</tr>
							<tr>
							<td colspan="5" align="center"><html:errors property="reportlisterror" /></td>
							</tr>

						</table>
						<br>
						
						<logic:notEmpty property="frmAnnualYearList" name="AnnualReportFormBean">
							<%-- ${AnnualReportFormBean.end} --%>

							<table class="body" border="1 	">
								<%-- ${AnnualReportFormBean.frmAnnualYearList[0].month} --%>
								<tr>
									<th><center>No.</center></th>
									<th><center>Month</center></th>
									<th><center>Category</center></th>
									<th><center>Fund(MMK)</center></th>
									<th><center>Total Cost(MMK)</center></th>
									<th><center>Total Balance(MMK)</center></th>
									<!-- <th align="center">Where to Donate</th> -->
								</tr>
								<c:forEach var="i" begin="${AnnualReportFormBean.begin}"
									end="${AnnualReportFormBean.end}">
									<tr>
										<td align="center">${i} </td>
										<td>${AnnualReportFormBean.frmAnnualYearList[i-1].month}</td>
										<td>${AnnualReportFormBean.frmAnnualYearList[i-1].category}</td>
										<td>${AnnualReportFormBean.frmAnnualYearList[i-1].fund}</td>
										<td>${AnnualReportFormBean.frmAnnualYearList[i-1].cost}</td>
										<td>
											${AnnualReportFormBean.frmAnnualYearList[i-1].balance}</td>
										
									</tr>
								</c:forEach>
								
								<c:if
									test="${AnnualReportFormBean.actualPage eq AnnualReportFormBean.finalPage}">
									<tr>
									
										<td colspan="3" align="center"><b>Total</td>
										
										<td>${AnnualReportFormBean.fund_sum}</td>
										<td>${AnnualReportFormBean.cost_sum}</td>
										<td colspan="2">${AnnualReportFormBean.total_balance}</td>
									</tr>
								</c:if>
							</table>
							<table align="center">
								<tr>
									<td>
										<div align="center">
											<c:if test="${AnnualReportFormBean.prevBtn}">
											             <html:submit property="prev"
													value="Previous" styleId="buttonwto">
												</html:submit>
											</c:if>
										</div>
									</td>
									<td>
										<div align="center">
											<c:if test="${AnnualReportFormBean.nextBtn}">
												<html:submit property="next" value="Next" styleId="buttonwto">
												</html:submit>
              			</c:if>
										</div>
									</td>
								</tr>
							</table>
						</logic:notEmpty>



						<logic:notEmpty property="frmAllYearViewList"
							name="AnnualReportFormBean">
							<center>
							<table class="body" border="1">
								<%-- ${AnnualReportFormBean.frmAnnualYearList[0].month} --%>
								<tr>
								
									<th><center>No.</center></th>
									<th><center>Category</center></th>
									<th><center>Fund(Kyats)</center></th>
									<th><center>Total Cost(Kyats)</center></th>
									<th><center>Total Balance(kyats)</center></th>
									<!-- <th align="center">Where to Donate</th> -->
								
								</tr>
								<c:forEach var="i" begin="${AnnualReportFormBean.begin}"
									end="${AnnualReportFormBean.end}">

									<tr>
										<td align="center">${i}</td>
										<td>${AnnualReportFormBean.frmAllYearViewList[i-1].category}</td>
										<td>${AnnualReportFormBean.frmAllYearViewList[i-1].fund}</td>
										<td>${AnnualReportFormBean.frmAllYearViewList[i-1].cost}</td>
										<td>${AnnualReportFormBean.frmAllYearViewList[i-1].balance}</td>

									</tr>

								</c:forEach>






							</table></center>
						</logic:notEmpty>
					
				</center>
				</html:form>	
			
	
	</div>
<footer>	
		<%@include file="inc/footer1.jsp" %>
   </footer>	
</body>

</html>
