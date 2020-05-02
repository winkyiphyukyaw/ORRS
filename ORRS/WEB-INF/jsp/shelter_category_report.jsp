<%-- <%@include file="inc/banner.jsp"%> --%>
<%@ include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp" %>
<html>
<head>
<title>Report by Category</title>

	
</head>
<body>
<div class="mainbanner"><h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1></div>
<div class="mainbody" >
		
<h1 style=" padding-left:0px; padding-right:100px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Report by Category</h1>

<html:form action="/viewCategoryReportPath">
<table width="100%"><tr><td width="25%"></td><td width="50%">
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
				<td align="right">Chart Type</td>
				<td><html:select property="chart">
<%-- 						<html:option value="0">Select </html:option>
 --%>						<html:option value="1">Bar Chart</html:option>
						<html:option value="2">Pie Chart</html:option>
						<html:option value="3">Line Chart</html:option>
						<html:option value="4">Table</html:option>
					</html:select>
				</td>
				<td width="15px"></td>
				<td  align="center"><html:submit property="btnShow"
						value="&nbsp;&nbsp;Show&nbsp;&nbsp;" styleId="buttonwto"></html:submit></td>
			</tr>
			<tr height="10px">
			<td width="150px" colspan="4">
					<html:errors property ="reportlisterror"/>
				</td>
			</tr>
			
			</table>
			</center>
			<logic:notEmpty property="frmShelterCategoryReportList" name="ShelterReportFormBean">
					<center>
					<table class="body" border="1" >
					<h1 align="center" style="padding-left: 20px; font-size: 15px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Report For Donation in ${ShelterReportFormBean.frmShelterCategoryReportList[0].year}</h1>
						<tr>
							<th width="10px">No</th>
							<th>Category</th>
							<th>Amount(MMK)</th>
						</tr>
						<c:forEach var="i" begin="${ShelterReportFormBean.begin}"
									end="${ShelterReportFormBean.end}">
									<tr><td>${i}</td>
										<td>${ShelterReportFormBean.frmShelterCategoryReportList[i-1].category}</td>
										<td>${ShelterReportFormBean.frmShelterCategoryReportList[i-1].amount}</td>

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
			<html:img src="${ShelterReportFormBean.frmFileName}" height="400"
				width="400" />
		</center>
	</logic:notEmpty>
	
	</td><td width="25%"></td></tr></table>
	</div>
	
		<footer><%@ include file="inc/footer1.jsp"%></footer>
</body>
</html>