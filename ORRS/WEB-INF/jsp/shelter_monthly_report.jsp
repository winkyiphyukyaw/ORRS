<%-- <%@include file="inc/banner.jsp"%> --%>
<%@ include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp" %>
<html>
<head>
<title>Monthly Report</title>

	
</head>
<body>
<div class="mainbanner"><h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1></div>
<div class="mainbody" >
		
<%-- <%@include file="inc/admin_sidebar1.jsp" %> --%>
<h1 style=" padding-left:0px; padding-right:100px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Monthly Report</h1>

<html:form action="/viewMonthlyReportPath">
<table width="100%"><tr><td width="15%"></td><td width="80%">
		<table align="center" width="100%">
			
			<tr>
				<td>Year</td>
				<td><html:select property="frmYearId">
<%-- 						<html:option value="0">Select</html:option>
 --%>						<html:optionsCollection property="frmYearList" value="year"
							label="year" />
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
				<td>Chart Type</td>
				<td><html:select property="chart">
<%-- 						<html:option value="0">Select </html:option>
 --%>					<html:option value="1">Bar Chart</html:option>
						<html:option value="2">Pie Chart</html:option>
						<html:option value="3">Line Chart</html:option>
						<html:option value="4">Table</html:option>
					</html:select>
				</td>
				<td width="15px"></td>
				<td  align="center"><html:submit property="btnShow"
						value="Show" styleId="buttonwto"></html:submit></td>
			</tr>
			<tr height="10px"><td colspan="10" align="center" width="150px">
					<html:errors property ="reportlisterror"/>
				</td></tr>
			
			</table>
			</center>
			<logic:notEmpty property="frmShelterMonthlyReportList" name="ShelterReportFormBean">
					<center>
					<table border="1" class="body">
						<h1 align="center" style="padding-left: 20px; font-size: 15px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Report For Donation ${ShelterReportFormBean.frmShelterMonthlyReportList[0].category} in ${ShelterReportFormBean.frmShelterMonthlyReportList[0].year}</h1>
					
						<tr>
							<th width="10px">No</th>
							<th>Category</th>
							<th>Month</th>
							<th>Amount(MMK)</th>
						</tr>
						<c:forEach var="i" begin="${ShelterReportFormBean.begin}"
									end="${ShelterReportFormBean.end}">
									<tr><td>${i}</td>
										<td>${ShelterReportFormBean.frmShelterMonthlyReportList[i-1].category}</td>
										<td>${ShelterReportFormBean.frmShelterMonthlyReportList[i-1].month}</td>
										<td>${ShelterReportFormBean.frmShelterMonthlyReportList[i-1].amount}</td>

									</tr>
								</c:forEach>
					</table>
					<table>
								<tr>
									<td>
										<div align="center">
											<c:if test="${ShelterReportFormBean.prevBtn}">
                                  				<html:submit property="prev" value="Previous" styleId="buttonwto"></html:submit>
											</c:if>
										</div>
									</td>
									<td>
										<div align="center">
											<c:if test="${ShelterReportFormBean.nextBtn}">
												<html:submit property="next" value="Next" styleId="buttonwto"></html:submit>
              			</c:if>
										</div>
									</td>
								</tr>
							</table>
							</center>
			</logic:notEmpty>
			
			<logic:notEmpty property="frmShelterMonthlyReportAllList" name="ShelterReportFormBean">
					<center>
					<table border="1" class="body">
						<h1 align="center" style="padding-left: 20px; font-size: 15px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Report For Donation All Category in ${ShelterReportFormBean.frmShelterMonthlyReportAllList[0].year}</h1>
					
						<tr>
							<th width="10px">No</th>
							<th>Month</th>
							<th>Amount(MMK)</th>
						</tr>
						<c:forEach var="i" begin="${ShelterReportFormBean.begin}"
									end="${ShelterReportFormBean.end}">
									<tr><td>${i}</td>
										<td>${ShelterReportFormBean.frmShelterMonthlyReportAllList[i-1].month}</td>
										<td>${ShelterReportFormBean.frmShelterMonthlyReportAllList[i-1].amount}</td>

									</tr>
								</c:forEach>
					</table>
					<table>
								<tr>
									<td>
										<div align="center">
											<c:if test="${ShelterReportFormBean.prevBtn}">
                                  				<html:submit property="prev" value="Previous" styleId="buttonwto"></html:submit>
											</c:if>
										</div>
									</td>
									<td>
										<div align="center">
											<c:if test="${ShelterReportFormBean.nextBtn}">
												<html:submit property="next" value="Next" styleId="buttonwto"></html:submit>
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