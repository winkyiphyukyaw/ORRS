<%@ include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp"%>
<html>
<head>
<title>Orphan's Detail</title>
	


</head>
<body>
<div class="mainbanner"><h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1></div>
	<div class="mainbody">
		
	
	<html:form action="/shelterOrphanDetailPath">
	<h1 style="padding-left: 20px; font-size: 20px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Detail Orphan Page</h1>
				<center>
					<table class="body" border="1" >
						<tr height="40">
							<td>Name</td>
							<td>${OrphanFormBean.frmOrphanDetail.orphanName}
							</td>
						</tr>
						<tr height="40">
							<td>Age</td>
							<td>${OrphanFormBean.frmOrphanDetail.orphanAge}</td>
						</tr>
						<tr height="40">
							<td>Gender</td>
							<td>${OrphanFormBean.frmOrphanDetail.orphanGender}</td>
						</tr>
						<tr>
							<td>Education</td>
							<td>${OrphanFormBean.frmOrphanDetail.orphanEdu}</td>
						</tr>
						<tr height="40">
							<td>Religion</td>
							<td>${OrphanFormBean.frmOrphanDetail.orphanReligion}</td>
						</tr>
						<tr height="40">
							<td>Medical Grade</td>
							<td>${OrphanFormBean.frmOrphanDetail.orphanMedicalGrade}</td>
						</tr>
						<tr height="40">
							<td>Adopt Status</td>
							<td><c:if
									test="${OrphanFormBean.frmOrphanDetail.adoptStatus==0}">Not Yet
					</c:if> <c:if test="${OrphanFormBean.frmOrphanDetail.adoptStatus==1}">Adopt
					</c:if></td>
					</table>
					</center>
					<br>
					<center>
					<table><tr><td><html:submit property="btnOk" value="OK" styleId= "buttonwto" ></html:submit></td></tr></table>
						
					</center>
				</html:form>
	</div>
	<footer>
	<%@include file="inc/footer1.jsp"%>
	</footer>
	</body>
	</html>