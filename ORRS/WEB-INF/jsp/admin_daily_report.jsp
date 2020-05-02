<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>

<head>
	
<title>Daily Report</title>
</head>


<body>
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody">
		


<html:form action="/adminViewDailyReportPath">
<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Daily Report</h2>
<center>
		<table align="center" width="80%" >
			<tr>
				<td>Year</td>
				<td><html:select property="frmYearId">
<%-- 							<html:option value="0">Select</html:option>
 --%>							<html:optionsCollection property="frmYearList" value="year"
								label="year" />
						</html:select>
				</td>
								<td width="15px"></td>
				
				<td>Month</td>
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
				<td>Category</td>
				<td><html:select property="frmCategoryId">
						<html:option value="0">All</html:option>
						<html:optionsCollection property="frmCategoryList" value="type"
							label="type" />
					</html:select>
				</td>
				<td width="15px"></td>
				<td >Chart Type</td>
				<td><html:select property="chart">
<%-- 						<html:option value="0">Select </html:option>
 --%>						<html:option value="1" >Bar Chart</html:option>
						<html:option value="2">Pie Chart</html:option>
						<html:option value="3">Line Chart</html:option>
						<html:option value="4">Table</html:option>
					</html:select>
				</td>
				
				<td><html:submit property="btnShow"
						value="&nbsp;&nbsp;Show&nbsp;&nbsp;" styleId="buttonwto"></html:submit></td>
			</tr>
			<tr height="10px">
			<td colspan="12" width="200px" align="center">
					
					<html:errors property ="reportlisterror"/>
				</td>
			</tr>
			
				
			
			</table>
			<br>
			<logic:notEmpty property="frmAdminDailyReportList" name="AdminReportFormBean">
			<h1 align="center" style=" padding-left:0px; padding-right:100px;font-size: 15px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Report For Donation ${AdminReportFormBean.frmAdminDailyReportList[0].category} in ${AdminReportFormBean.frmAdminDailyReportList[0].year} ${AdminReportFormBean.frmAdminDailyReportList[0].month}</h1>
				<center>
					<table  border="1"  class="body" >
						<tr>
							<th>No</th>
							<th>Date</th>
							<th>Category</th>
							<th>Amount(MMK)</th>
						</tr>
						<c:forEach var="i" begin="${AdminReportFormBean.begin}"
									end="${AdminReportFormBean.end}">
									<tr><td>${i}</td>
										<td>${AdminReportFormBean.frmAdminDailyReportList[i-1].donateDate}</td>
										<td>${AdminReportFormBean.frmAdminDailyReportList[i-1].category}</td>

										<td>${AdminReportFormBean.frmAdminDailyReportList[i-1].amount}</td>
									</tr>
								</c:forEach>
					</table>
					<table >
								<tr>
									<td>
										<div align="center">
											<c:if test="${AdminReportFormBean.prevBtn}">
                                  				<html:submit property="prev" value="&nbsp;Previous&nbsp;" styleId="buttonwto"></html:submit>
											</c:if>
										</div>
									</td>
									<td>
										<div align="center">
											<c:if test="${AdminReportFormBean.nextBtn}">
												<html:submit property="next" value="&nbsp;&nbsp;Next&nbsp;&nbsp;" styleId="buttonwto"></html:submit>
              			</c:if>
										</div>
									</td>
								</tr>
							</table>
							</center>
			</logic:notEmpty>
			<logic:notEmpty property="frmAdminDailyReportAllList" name="AdminReportFormBean">
			<h1 align="center" style=" padding-left:0px; padding-right:100px;font-size: 15px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Report For Donation  All Category in ${ AdminReportFormBean.frmAdminDailyReportAllList[0].year} ${AdminReportFormBean.frmAdminDailyReportAllList[0].month}</h1>
				<center>
					<table  border="1" class="body" >
						<tr>
							<th>No</th>
							<th>Date</th>
							<th>Amount(MMK)</th>
						</tr>
						<c:forEach var="i" begin="${AdminReportFormBean.begin}"
									end="${AdminReportFormBean.end}">
									<tr><td>${i}</td>
										<td>${AdminReportFormBean.frmAdminDailyReportAllList[i-1].donateDate}</td>
										<td>${AdminReportFormBean.frmAdminDailyReportAllList[i-1].amount}</td>
									</tr>
								</c:forEach>
					</table>
					<table >
								<tr>
									<td>
										<div align="center">
											<c:if test="${AdminReportFormBean.prevBtn}">
                                  				<html:submit property="prev" value="&nbsp;Previous&nbsp;" styleId="buttonwto"></html:submit>
											</c:if>
										</div>
									</td>
									<td>
										<div align="center">
											<c:if test="${AdminReportFormBean.nextBtn}">
												<html:submit property="next" value="&nbsp;&nbsp;Next&nbsp;&nbsp;" styleId="buttonwto"></html:submit>
              			</c:if>
										</div>
									</td>
								</tr>
							</table>
							</center>
							
			</logic:notEmpty>
			</center>
			</html:form>
			<logic:notEmpty name="AdminReportFormBean" property="frmAdminDailyFileName">
		<center>
			<html:img src="${AdminReportFormBean.frmAdminDailyFileName}" height="500"
				width="500" />
		</center>
	</logic:notEmpty>
	
	</div>
	
<footer>	
		<%@include file="inc/footer1.jsp" %>
   </footer>	
</body>

</html>
