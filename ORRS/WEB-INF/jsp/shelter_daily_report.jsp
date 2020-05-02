<%-- <%@include file="inc/banner.jsp"%> --%>
<%@ include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp" %>
<html>
<head>
<title>Daily Report</title>

	
</head>
<body>
<div class="mainbanner"><h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1></div>
<div class="mainbody" >
		
<h1 style=" padding-left:0px; padding-right:100px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Daily Report</h1>

<html:form action="/viewDailyReportPath">
<table width="100%"><tr><td width="10%"></td><td width="90%">
		<table align="center" width="100%">
			
			<tr>
				<td align="right">Year</td>
				<td><html:select property="frmYearId">
<%-- 						<html:option value="0">Select</html:option>
 --%>						<html:optionsCollection property="frmYearList" value="year"
							label="year" />
					</html:select>
				</td>
				<td width="15px"></td>
				<td align="right">Month</td>
				<td><html:select property="frmMonthId">
							<html:option value="January">January</html:option>
							<html:option value="February">February</html:option>
							<html:option value="March">March</html:option>
							<html:option value="April">April</html:option>
							<html:option value="May">May</html:option>
							<html:option value="June">June</html:option>
							<html:option value="July">July</html:option>
							<html:option value="August">August</html:option>
							<html:option value="September">September</html:option>
							<html:option value="October">October</html:option>
							<html:option value="November">November</html:option>
							<html:option value="December">December</html:option>
						
 							<%-- <html:optionsCollection property="frmMonthList" value="month"
								label="month" /> --%>
						</html:select>
				</td>
				<td width="15px"></td>
				<td align="right">Category</td>
				<td><html:select property="frmCategoryId">
						<html:option value="0">All</html:option>
						<html:optionsCollection property="frmCategoryList" value="type"
							label="type" />
					</html:select>
				</td>
				<td width="15px"></td>
				<td  align="right">Chart Type</td>
				<td><html:select property="chart">
<%-- 						<html:option value="0">Select </html:option>
 --%>					<html:option value="1">Bar Chart</html:option>
						<html:option value="2">Pie Chart</html:option>
						<html:option value="3">Line Chart</html:option>
						<html:option value="4">Table</html:option>
					</html:select>
				</td>
				<td  align="center"><html:submit property="btnShow"
						value="Show" styleId="buttonwto"></html:submit></td>
			</tr>
			<tr height="10px">
				<td colspan="12" align="center">
					
					<html:errors property ="reportlisterror"/>
				</td>
			</tr>
			
			</table>
			</center>
			<logic:notEmpty property="frmShelterDailyReportList" name="ShelterReportFormBean">
					<center>
					<table border="1" class="body">
					<h1 align="center" style=" padding-left:0px; padding-right:100px;font-size: 15px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Report For Donation ${ShelterReportFormBean.frmShelterDailyReportList[0].category} in ${ShelterReportFormBean.frmShelterDailyReportList[0].year} ${ShelterReportFormBean.frmShelterDailyReportList[0].month} </h1>
					
						<tr>
							<th width="10px">No</th>
							<th >Date</th>
							<th >Category</th>
							<th>Amount(MMK)</th>
						</tr>
						<c:forEach var="i" begin="${ShelterReportFormBean.begin}"
									end="${ShelterReportFormBean.end}">
									<tr><td>${i}</td>
										<td>${ShelterReportFormBean.frmShelterDailyReportList[i-1].donateDate}</td>
										<td>${ShelterReportFormBean.frmShelterDailyReportList[i-1].category}</td>
										<td>${ShelterReportFormBean.frmShelterDailyReportList[i-1].amount}</td>

									</tr>
								</c:forEach>
					</table>
					<table>
								<tr>
									<td>
										<div align="center">
											<c:if test="${ShelterReportFormBean.prevBtn}">
                                  				<html:submit property="prev" value="Previous"></html:submit>
											</c:if>
										</div>
									</td>
									<td>
										<div align="center">
											<c:if test="${ShelterReportFormBean.nextBtn}">
												<html:submit property="next" value="Next"></html:submit>
              			</c:if>
										</div>
									</td>
								</tr>
							</table>
							</center>
			</logic:notEmpty>
			<logic:notEmpty property="frmShelterDailyReportAllList" name="ShelterReportFormBean">
					<center>
					<table border="1" class="body">
					<h1 align="center" style=" padding-left:0px; padding-right:100px;font-size: 15px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Report For Donation All Category in ${ShelterReportFormBean.frmShelterDailyReportAllList[0].year} ${ShelterReportFormBean.frmShelterDailyReportAllList[0].month} </h1>
					
						<tr>
							<th width="10px">No</th>
							<th>Date</th>
							<th>Amount(MMK)</th>
						</tr>
						<c:forEach var="i" begin="${ShelterReportFormBean.begin}"
									end="${ShelterReportFormBean.end}">
									<tr><td>${i}</td>
										<td>${ShelterReportFormBean.frmShelterDailyReportAllList[i-1].donateDate}</td>
										<td>${ShelterReportFormBean.frmShelterDailyReportAllList[i-1].amount}</td>

									</tr>
								</c:forEach>
					</table>
					<table >
								<tr>
									<td>
										<div align="center">
											<c:if test="${ShelterReportFormBean.prevBtn}">
                                  				<html:submit property="prev" value="Previous"></html:submit>
											</c:if>
										</div>
									</td>
									<td>
										<div align="center">
											<c:if test="${ShelterReportFormBean.nextBtn}">
												<html:submit property="next" value="Next"></html:submit>
              			</c:if>
										</div>
									</td>
								</tr>
							</table>
							</center>
			</logic:notEmpty>
	</html:form>
	<logic:notEmpty name="ShelterReportFormBean" property="frmFileName">
		<center>
			<html:img src="${ShelterReportFormBean.frmFileName}" height="500"
				width="500" />
		</center>
	</logic:notEmpty>

	</td><td width="25%"></td></tr></table>
	</div>
	
		<footer><%@ include file="inc/footer1.jsp"%></footer>
</body>
</html>