<%@ include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp" %>
<html>

<head>
<!-- <meta charset="utf-8"/> -->
<title>Shelter Home Page</title>
<style type="text/css">
div {
	float:left;
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
	height: 90%;
	display: inline-block;
}

.mainbody {
	float:justify;
	min-width: 78%;
	min-height: 100%;
	background-color: #FFFFFF;
	text-align: center;
	background-color: #FFFFFF;
}

table.body {
	align: center;
	border:2px solid #086A87;
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


</style>


</head>
<body>
	<div class="mainbody">
		<div class="container">
			<h1
				style="padding-left: 20px; font-size: 20px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Adopter Detail List</h1>
	<html:form action="/shelterAdopterDetailPath">
	<center>
		<table class="body" border="1">
			<tr>
				<th>Adopter Name:</th>
				<td>${ShelterSearchAdopterFormBean.frmAdopterDetail.adopterName}
				</td>
			</tr>
			<tr>
				<th>Adopter Email:</th>
				<td>${ShelterSearchAdopterFormBean.frmAdopterDetail.adopterEmail}</td>
			</tr>
			<tr>
				<th>Adopter Ph no:</th>
				<td>${ShelterSearchAdopterFormBean.frmAdopterDetail.adopterPhNo}
				</td>
			</tr>
			<tr>
				<th>Adopter Address:</th>
				<td>
					${ShelterSearchAdopterFormBean.frmAdopterDetail.adopterAddress}</td>
			</tr>
			<tr>
				<th>Adopter NRC:</th>
				<td>
					${ShelterSearchAdopterFormBean.frmAdopterDetail.adopterNrc}</td>
			</tr>
			<tr>
				<th>Income:</th>
				<td>
					${ShelterSearchAdopterFormBean.frmAdopterDetail.adopterIncome}</td>
			</tr>
			<tr>
				<th>Occupation:</th>
				<td>
					${ShelterSearchAdopterFormBean.frmAdopterDetail.adopterOccupation}</td>
			</tr>
			<tr>
				<th>Marital Status:</th>
				<td>
					${ShelterSearchAdopterFormBean.frmAdopterDetail.adopterMaritalStatus}</td>
			</tr>
			<tr>
				<th>Gender:</th>
				<td>
					${ShelterSearchAdopterFormBean.frmAdopterDetail.adopterGender}</td>
			</tr>

			<tr>
				<th>Date of Birth:</th>
				<td>
					${ShelterSearchAdopterFormBean.frmAdopterDetail.adopterDob}</td>
			</tr>

			
			<tr>
				<th>Adopted Child No:</th>
				<td>
					${ShelterSearchAdopterFormBean.frmAdopterDetail.adoptedChildNo}</td>
			</tr>
			
		</table>
</center>
<center>
<h3 style=" padding-left:20px;font-size: 15px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">
		<font color=#086A87>Information of Orphan that Adopter wants to adopt.</font>
	</h3>
		<table class="body" border="1">
		<tr>
				<th>Orphan Age:</th>
				<td>
					${ShelterSearchAdopterFormBean.frmAdopterDetail.adopterOrphanAge}</td>
			</tr>
			<tr>
				<th>Orphan Gender:</th>
				<td>
					${ShelterSearchAdopterFormBean.frmAdopterDetail.adopterOrphanGender}</td>
			</tr>
		</table>
		</center>
		<center>
		<table align="center" bordercolor=#086A87 width="100%" >
			<tr>
			<td width="42%"></td>
				<td>
					
						<html:submit styleId="buttonwto" property="btnOk" value=" &nbsp;&nbsp; OK &nbsp;&nbsp;">
						</html:submit>
					
				</td>
				<td width="25%"></td>
				
				
			</tr>
			

		</table>
		</center>
		<logic:empty property="frmOrphanList"
			name="ShelterSearchAdopterFormBean">
		<span style="color:#366b82;font-weight:bold;">There is no orphan that match with the adopter wish.</span>
		</logic:empty>
		
		<logic:notEmpty property="frmOrphanList"
			name="ShelterSearchAdopterFormBean">
<center>
		<h1 style=" padding-left:20px;font-size: 15px;color:#366b82;text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">
		<font color=#086A87>Number of Orphan that match with Adopter
					wish to adopt.</font></h1>
	
			<table class="body" border="1">
				<tr>
					<th>No</th>
					<th>Orphan Name</th>
					<th>Age</th>
					<th>Gender</th>
					<th>Education</th>
					<th>Religion</th>
					<th>Medical Grade</th>
				</tr>
				<c:forEach var="i" begin="${ShelterSearchAdopterFormBean.begin1}"
					end="${ShelterSearchAdopterFormBean.end1}">
					<tr>
						<td>${i}</td>
						<td>
							${ShelterSearchAdopterFormBean.frmOrphanList[i-1].orphanName}</td>
						<td>
							${ShelterSearchAdopterFormBean.frmOrphanList[i-1].orphanAge}</td>

						<td>
							${ShelterSearchAdopterFormBean.frmOrphanList[i-1].orphanGender}</td>
						<td>
							${ShelterSearchAdopterFormBean.frmOrphanList[i-1].orphanEdu}</td>
						<td>
							${ShelterSearchAdopterFormBean.frmOrphanList[i-1].orphanReligion}</td>

						<td>
							${ShelterSearchAdopterFormBean.frmOrphanList[i-1].orphanMedicalGrade}</td>
					</tr>
				</c:forEach>
			</table></center>
			<center>
			<table align="center">
				<tr>
					<td>
						<div align="center">
							<c:if test="${ShelterSearchAdopterFormBean.prevBtn1}">
                                   <html:submit property="prev"
									styleId="buttonwto" value="Previous" >
								</html:submit>
							</c:if>
						</div>
					</td>
					<td>
						<div align="center">
							<c:if test="${ShelterSearchAdopterFormBean.nextBtn1}">
								<html:submit property="next" styleId="buttonwto" value="Next" >
								</html:submit>
              			</c:if>
						</div>
					</td>
			</table>
			</center>
		

		<table align="center" width="100%">
			<c:if test="${ShelterSearchAdopterFormBean.frmAdopterDetail.mailStatus eq 0}">
				<tr>
				<td width="40%"></td>
					<td><html:submit styleId="buttonwto" property="sendMail"
							value="Send Mail"></html:submit></td>
				</tr></c:if>
				<c:if test="${ShelterSearchAdopterFormBean.frmAdopterDetail.mailStatus eq 1}">
				<tr>
				<td width="40%"></td>
					<td><span style="color:green;font-weight:bold;">Already Sent Mail.</span></td>
				</tr></c:if>
			</table>
		</logic:notEmpty>
	</html:form>
	</div></div>
	<footer>
	<%@ include file="inc/footer.jsp"%></footer>
</body>
</html>
