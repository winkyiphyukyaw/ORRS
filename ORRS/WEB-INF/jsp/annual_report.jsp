<%@ include file="inc/common.jsp"%>
<%@ include file="inc/banner.jsp"%>
<html>
<head>
<title>Annual Report</title>

<!-- <link href="css/library.css" rel="stylesheet" type="text/css">
 -->
	<!-- <style>
	table.body {
	align: center;
	border:2px solid #086A87;
	/* min-width:400px; */	
}
table {
	align: center;
	width:100%;
}

th,td {
	padding: 5px;
}

table.body tr:nth-child(even) {
	background-color: #bab9ae;
}

#buttonwto {
	background-color: white;
	color: black;
	border: 2px solid #086A87;
	width: 100px;
}
</style>  -->
 
</head>
<body>
<div class="userlogo">
		<h1 align="center"
		style="font-size: 30px; color: #366b82; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
</div>

	<div id="wrap">
		<ul class="navbar">
			<li><div class="dropdown"><a href="Welcome.do"><span
					class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</span></a></div></li>

			<li><div class="dropdown"><a href="shelterPath.do?frmControl=1"><span
					class="glyphicon glyphicon-road" aria-hidden="true"></span> Shelter</a></div></li>
					
			<li><div class="dropdown"><a href="userStoryPath.do"><span
					class="glyphicon glyphicon-calendar" aria-hidden="true"></span> Story</a></div></li>

			<li><div class="dropdown"><a href="EventPath.do"><span
					class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
					Activity</a></div></li>


			<li><div class="dropdown">
					<a href="#"><span class="glyphicon glyphicon-gift"
						aria-hidden="true"></span>
							Donate</a>
					<div class="dropdown-content">
						<a href="donorShelterFirstPath.do">Donate to Shelter</a> <a
							href="donorDirectFirstPath.do">Donate to Foundation</a>
					</div>
				</div></li>
			<li><div class="dropdown"><a href="givingMealFirstPath.do"><span
					class="glyphicon glyphicon-glass" aria-hidden="true"></span> Giving
					Meal</a></div></li>
			<li><div class="dropdown"><a href="adopterFirstPath.do"><span
					class="glyphicon glyphicon-heart" aria-hidden="true"></span> Adopt</a></div></li>
			<li><div class="dropdown"><a href="AboutPath.do"><span
					class="glyphicon glyphicon-user" aria-hidden="true"></span> About</a></div></li>
			<li><div class="dropdown"><a href="ContactPath.do"><span
					class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					Contact</a></div></li>
			<li class="active"><div class="dropdown"><a href="annualReportPath.do"><span
					class="glyphicon glyphicon-book" aria-hidden="true"></span> Annual
					Report</a></div></li>
		</ul>

	</div>
	
<html:form action="/AnnualViewPath">
<center>
	<div class="divbodyborder">
<div class="maincontainer">
<h1 align="center"
		style="font-size: 20px; color: #366b82; text-shadow: 0 1px 1px rgba(0,0,0,5);">Annual Report</h1>	
						<table>

							<tr>
								<td>Year:</td>
								<td><html:select property="frmAnnualId">
										<html:option value="0">All</html:option>
										<html:optionsCollection property="frmAnnualList" value="year"
											label="year" />
									</html:select></td>
									
									<td>Category:</td>
									<td><html:select property="frmCategoryId">
										<html:option value="0">Select</html:option>
										<html:optionsCollection property="frmCategoryList" value="category"
											label="category" />
									</html:select></td>

								<td colspan="2" align="center"><html:submit
										property="btnView" value="View" styleId="buttonwto"></html:submit></td>
							</tr>
							<tr>
							<td colspan="3"><html:errors property="listError" /></td>
							</tr>

						</table>
						<br>
						
						<logic:notEmpty property="frmAnnualYearList" name="AnnualReportFormBean">
							<%-- ${AnnualReportFormBean.end} --%>

							<table class="body">
								<%-- ${AnnualReportFormBean.frmAnnualYearList[0].month} --%>
								<tr>
									<th>No.</th>
									<th>Category</th>
									<th>Month</th>
									<th>Fund(MMK)</th>
									<th>Total Cost(MMK)</th>
									<th>Total Balance(MMK)</th>
									<!-- <th align="center">Where to Donate</th> -->
									
								</tr>
								<c:forEach var="i" begin="${AnnualReportFormBean.begin}"
									end="${AnnualReportFormBean.end}">
									<tr>
										<td align="center">${i} </td>
										<td  align="center">
											${AnnualReportFormBean.frmAnnualYearList[i-1].category}</td>
										<td align="center">${AnnualReportFormBean.frmAnnualYearList[i-1].month}</td>
										
										<td  align="right">${AnnualReportFormBean.frmAnnualYearList[i-1].fund}</td>
										<td  align="right">${AnnualReportFormBean.frmAnnualYearList[i-1].cost}</td>
										<td  align="right">
											${AnnualReportFormBean.frmAnnualYearList[i-1].balance}</td>
										

									</tr>
								</c:forEach>
								
								<c:if
									test="${AnnualReportFormBean.actualPage eq AnnualReportFormBean.finalPage}">
									<tr>
									
										<td colspan="3" align="center"><b>Total</td>
									
										
										<td align="right">${AnnualReportFormBean.fund_sum}</td>
										<td align="right">${AnnualReportFormBean.cost_sum}</td>
										<td colspan="2" align="right">${AnnualReportFormBean.total_balance}</td>
									</tr>
								</c:if>
							</table>
							<br>
							<table width="50%">
								<tr>
								<td width="10%">
									<td width="30%">
										
											<c:if test="${AnnualReportFormBean.prevBtn}">
                                   <html:submit property="prev"
													value="Previous" styleId="buttonwto">
												</html:submit>
											</c:if>
										
									</td>
									<td width="30%"></td>
									<td width="30%">
										
											<c:if test="${AnnualReportFormBean.nextBtn}">
												<html:submit property="next" value="Next" styleId="buttonwto">
												</html:submit>
              			</c:if>
										
									</td>
								</tr>
							</table>
						</logic:notEmpty>



						<logic:notEmpty property="frmAllYearViewList"
							name="AnnualReportFormBean">
							<table class="body">
								<%-- ${AnnualReportFormBean.frmAnnualYearList[0].month} --%>
								<tr>
								
									<th>No.</th>
									<th>Category</th>
									<th>Fund(MMK)</th>
									<th>Total Cost(MMK)</th>
									<th>Total Balance(MMK)</th>
									<!-- <th align="center">Where to Donate</th> -->
									
								
								</tr>
								<c:forEach var="i" begin="${AnnualReportFormBean.begin}"
									end="${AnnualReportFormBean.end}">

									<tr>
										<td align="center">${i}</td>
										<td  align="center">
											${AnnualReportFormBean.frmAllYearViewList[i-1].category}</td>
										<td  align="right">${AnnualReportFormBean.frmAllYearViewList[i-1].fund}</td>
										<td  align="right">${AnnualReportFormBean.frmAllYearViewList[i-1].cost}</td>
										<td  align="right">
											${AnnualReportFormBean.frmAllYearViewList[i-1].balance}</td>
										

									</tr>

								</c:forEach>






							</table>
						</logic:notEmpty>
			</div>		
	</div>
	</center>
	</html:form>
	<footer>
	
		<%@include file="inc/footer.jsp"%>
		</footer>
</body>
</html>