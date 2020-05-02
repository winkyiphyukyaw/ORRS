<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>

<head>

<title>Reports by Category</title>
</head>


<body>
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody">
		


<html:form action="/adminViewCategoryReportPath">
<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Report by Category</h2>
<center>

<br>
		<table align="center" width="60%" >
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
				<td colspan="5" align="center"><html:submit property="btnShow"
						value="&nbsp;&nbsp;Show&nbsp;&nbsp;" styleId="buttonwto"></html:submit></td>
				
			</tr>
			<tr height="10px">
			<td align="center" colspan="7" width="200px">
					<html:errors property ="reportlisterror"/>
				</td>
			</tr>
			
				
			
			</table>
			<logic:notEmpty property="frmAdminCategoryReportList" name="AdminReportFormBean">
						<h1 align="center" style=" padding-left:0px; padding-right:100px;font-size: 15px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Report For Donation in ${AdminReportFormBean.frmAdminCategoryReportList[0].year }</h1>
					<center>
					<table border="1" class="body"  >
						<tr>
							<th width="10px">No</th>
							<th>Category</th>
							<th>Amount(MMK)</th>
						</tr>
						<c:forEach var="i" begin="${AdminReportFormBean.begin}"
									end="${AdminReportFormBean.end}">
									<tr><td>${i}</td>
										<td>${AdminReportFormBean.frmAdminCategoryReportList[i-1].category}</td>
										<td>${AdminReportFormBean.frmAdminCategoryReportList[i-1].amount}</td>

									</tr>
								</c:forEach>
					</table>
					</center>
					<center>
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
	<logic:notEmpty name="AdminReportFormBean" property="frmAdminCategoryFileName">
		<center>
			<html:img src="${AdminReportFormBean.frmAdminCategoryFileName}" height="400"
				width="400" />
		</center>
	</logic:notEmpty>
	
	</div>
	
<footer>	
		<%@include file="inc/footer1.jsp" %>
   </footer>	
</body>

</html>
