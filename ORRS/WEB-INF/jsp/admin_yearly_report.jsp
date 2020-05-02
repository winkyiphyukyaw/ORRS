<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>

<head>
	
<title>Yearly Report</title>
</head>


<body>

<%-- <%@include file="inc/admin_sidebar1.jsp" %> --%>
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody">
		


<html:form action="/adminViewYearlyReportPath">
<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Yearly Report</h2>
<center>
		<table align="center" width="100%">
			<tr>
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
 --%>						<html:option value="1">Bar Chart</html:option>
						<html:option value="2">Pie Chart</html:option>
						<html:option value="3">Line Chart</html:option>
						<html:option value="4">Table</html:option>
					</html:select>
				</td>
				<td width="15px"></td>
				<td colspan="5" align="center"><html:submit property="btnShow"
						value="&nbsp;&nbsp;Show&nbsp;&nbsp;" styleId="buttonwto"></html:submit></td>
			</tr>
			<tr height="10px">
			<td colspan="7" width="200px" align="center">
					<html:errors property ="reportlisterror"/>
				</td>
			</tr>
			
				
			
			</table>
			<logic:notEmpty property="frmAdminYearlyReportList" name="AdminReportFormBean">
			<h1 align="center" style=" padding-left:0px; padding-right:100px;font-size: 15px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Report For Donation ${AdminReportFormBean.frmAdminYearlyReportList[0].category}</h1>
					<center>
					<table  border="1"  class="body">
						<tr>
							<th width="10px">No</th>
							<th>Year</th>
							<th>Category</th>
							<th>Amount(MMK)</th>
						</tr>
						<c:forEach var="i" begin="${AdminReportFormBean.begin}"
									end="${AdminReportFormBean.end}">
									<tr><td>${i}</td>
										<td>${AdminReportFormBean.frmAdminYearlyReportList[i-1].year}</td>
										<td>${AdminReportFormBean.frmAdminYearlyReportList[i-1].category}</td>
										<td>${AdminReportFormBean.frmAdminYearlyReportList[i-1].amount}</td>
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
			<logic:notEmpty property="frmAdminYearlyReportAllList" name="AdminReportFormBean">
			<h1 align="center" style=" padding-left:0px; padding-right:100px;font-size: 15px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Report For Donation by All Category</h1>
					<center>
					<table border="1" class="body">
						<tr>
							<th width="10px">No</th>
							<th>Year</th>
							<th>Amount(MMK)</th>
						</tr>
						<c:forEach var="i" begin="${AdminReportFormBean.begin}"
									end="${AdminReportFormBean.end}">
									<tr><td>${i}</td>
										<td>${AdminReportFormBean.frmAdminYearlyReportAllList[i-1].year}</td>
										<td>${AdminReportFormBean.frmAdminYearlyReportAllList[i-1].amount}</td>
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
			<logic:notEmpty name="AdminReportFormBean" property="frmFileName">
		<center>
			<html:img src="${AdminReportFormBean.frmFileName}" height="500"
				width="500" />
		</center>
	</logic:notEmpty>
	
	</div>
	<footer>	
		<%@include file="inc/footer1.jsp" %>
   </footer>
</body>

</html>
