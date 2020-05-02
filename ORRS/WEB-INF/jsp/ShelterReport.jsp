<%@include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp" %>
<html>
<head>

<title>Home Page</title>
	<style type="text/css">
div {
	float: left;
}

html[type=submit] {
	background-color: pink;
}

#buttonwto {
	background-color: white;
	color: black;
	border: 2px solid #086A87;
	width: 100px;
}

.container {
	width: 100%;
	height: 100%;
	display: inline-block;
}

.mainbody {
	float: justify;
	min-width: 76%;
	min-height: 100%;
	background-color: #FFFFFF;
	text-align: center;
	background-color: #FFFFFF;
}

table.body {
	align: center;
	border: 2px solid #086A87;
}

table {
	align: center;
}

th,td {
	padding: 5px;
}

table.body tr:nth-child(even) {
	background-color: #C0D7E1;
}

body {
	background-color: #052645;
	width: 100%;
	height: 100%;
}

select {
	width:180px;
	height:30px;
}
</style>
<body>

	<html:form action="/viewReportPath">
		<table align="center">
			<tr>
				<td>Year</td>
				<td><html:select property="frmYearId">
						<html:option value="0">Select</html:option>
						<html:optionsCollection property="frmYearList" value="year"
							label="year" />
					</html:select>
				</td>
				<td width="15px"></td>
				<td>Chart Type</td>
				<td><html:select property="chart">
						<html:option value="0">Select </html:option>
						<html:option value="1">Bar Chart</html:option>
						<html:option value="2">Pie Chart</html:option>
						<html:option value="3">Line Chart</html:option>
						<html:option value="4">Table</html:option>
					</html:select>
				</td>
				<td width="150px">
					<html:errors property="charterror"/>
					<html:errors property ="listerror"/>
				</td>
			</tr>
			<tr height="10px"></tr>
			<tr>
				<td colspan="5" align="center"><html:submit property="btnShow"
						value="Show"></html:submit></td>
			</tr>
			</table>
			<logic:notEmpty property="frmshelterReportList" name="ShelterReportFormBean">
					<table align="center" border="1" width="500" height="200">
						<tr>
							<th>No</th>
							<th>Shelter Name</th>
							<th>Category</th>
							<th>Year</th>
							<th>Amount(Kyats)</th>
						</tr>
						<c:forEach var="i" begin="${ShelterReportFormBean.begin}"
									end="${ShelterReportFormBean.end}">
									<tr><td>${i}</td>
										<td>${ShelterReportFormBean.frmshelterReportList[i-1].shelterName}</td>
										<td>${ShelterReportFormBean.frmshelterReportList[i-1].category}</td>
										<td>${ShelterReportFormBean.frmshelterReportList[i-1].year}</td>
										<td>${ShelterReportFormBean.frmshelterReportList[i-1].amount}</td>

									</tr>
								</c:forEach>
					</table>
			</logic:notEmpty>
	</html:form>
	<logic:notEmpty name="ShelterReportFormBean" property="frmFileName">
		<center>
			<html:img src="${ShelterReportFormBean.frmFileName}" height="500"
				width="500" />
		</center>
	</logic:notEmpty>
	<%@include file="inc/footer.jsp"%>

</body>
</html>