<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>

<head>

<!-- <meta charset="utf-8" /> -->
<title>Adopter View</title>
<%-- <%@include file="inc/admin_sidebar.jsp"%> --%>

</head>
<body>
	<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody">
		


	
	<html:form action="/adopterViewDetailPath">
	<center>
		<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Adopter Detail</h2>
		
		<table class="body" border="3"  width="50%" >
			<tr height="40px">
				<td >Name:</td>
				<td>${AdopterViewFormBean.frmAdopterDetail.adopterName}</td>
			</tr>
			<tr height="40px">
				<td width="50%">NRC:</td>
				<td>${AdopterViewFormBean.frmAdopterDetail.adopterNrc}</td>
			</tr>
			<tr height="40px">
				<td>Date Of Birth:</td>
				<td>${AdopterViewFormBean.frmAdopterDetail.adopterDob}</td>
			</tr>
			<tr height="40px">
				<td>Adopter Gender:</td>
				<td>${AdopterViewFormBean.frmAdopterDetail.adopterGender}</td>
			</tr>
			<tr height="40px">
				<td>Marital Status:</td>
				<td>
					${AdopterViewFormBean.frmAdopterDetail.adopterMaritalStatus}</td>
			</tr>
			<tr height="40px">
				<td>Address:</td>
				<td>${AdopterViewFormBean.frmAdopterDetail.adopterAddress}</td>
			</tr>
			<tr height="40px">
				<td>Email:</td>
				<td>${AdopterViewFormBean.frmAdopterDetail.adopterEmail}</td>
			</tr>

			<tr height="40px">
				<td>Phone Number:</td>
				<td>${AdopterViewFormBean.frmAdopterDetail.adopterPhNo}</td>
			</tr>

			<tr height="40px">
				<td>Occupation:</td>
				<td>${AdopterViewFormBean.frmAdopterDetail.adopterOccupation}</td>
			</tr>
			<tr height="40px">
				<td>Income(MMK):</td>
				<td>${AdopterViewFormBean.frmAdopterDetail.adopterIncome}</td>
			</tr>



			<tr height="40px">
				<td>Number Of Biological Child:</td>
				<td>
					${AdopterViewFormBean.frmAdopterDetail.adopterNoOfChildren}</td>
			</tr>
			
			<tr height="40px">
				<td>Number Of Adopted Child:</td>
				<td>${AdopterViewFormBean.frmAdopterDetail.adoptedChildNo}</td>
		</table>
		
		<h3 style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">
		<font color=#086A87>Information of Orphan that Adopter wants to adopt.</font>
	</h3>
		<table class="body" align="center" border="3" bordercolor=#086A87 width="50%">
		<tr>
			<td width="50%">Orphan Age:</td>
			<td>${AdopterViewFormBean.frmAdopterDetail.adopterOrphanAge}</td>
			</tr>
			<tr>
				<td>Orphan Gender:</td>
				<td>
					${AdopterViewFormBean.frmAdopterDetail.adopterOrphanGender}</td>
					</tr>
		</table>

		<table align="center" bordercolor=#086A87 width="50%" >
			<tr>
			<td width="42%"></td>
				<td>
					
						<html:submit styleId="buttonwto" property="btnOk" value=" &nbsp;&nbsp; OK &nbsp;&nbsp;">
						</html:submit>
					
				</td>
				<td width="25%"></td>
				
				
			</tr>
			

		</table>
		<hr>
<c:if test="${AdopterViewFormBean.frmOrphanTotalList==null}"><span aligin ="center" style="color:#366b82;font-size: 20px;">There is no orphan that match with the adopter wish.</span></c:if>
		<logic:notEmpty property="frmOrphanTotalList"
			name="AdopterViewFormBean">
			<h1 style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">
		<font color=#086A87>Number of Orphan that match with Adopter
					wish to adopt.</font>
	</h1>
			<!-- <h3 align="center">
				<font color=#086A87>Number of Orphan that match with Adopter
					wish to adopt.</font>
			</h3> -->
			<table align="center" border="1" width="50%" bordercolor=#086A87 class="body">
				<tr>
					<td width="50%">Shelter Name</td>
					<td>Number Of Orphan</td>
				</tr>
				<c:forEach var="i" begin="${1}"
					end="${AdopterViewFormBean.frmOrphanTotalList.size()}">
					<tr>
						<td>${AdopterViewFormBean.frmOrphanTotalList[i-1].sname}</td>
						<td>${AdopterViewFormBean.frmOrphanTotalList[i-1].count}</td>
					</tr>
				</c:forEach>
			</table>
			
			<table align="center" width="50%">
			<c:if test="${AdopterViewFormBean.frmAdopterDetail.mailStatus eq 0}">
				<tr>
				<td width="40%"></td>
					<td><html:submit styleId="buttonwto" property="sendMail"
							value="Send Mail"></html:submit></td>
				</tr></c:if>
				<c:if test="${AdopterViewFormBean.frmAdopterDetail.mailStatus eq 1}">
				<tr>
				<td width="40%"></td>
					<td><span aligin ="center" style="color:green;font-size: 20px;">Already Sent Mail.</span></td>
				</tr></c:if>
			</table>
				<%-- <font color="green">${AdopterViewFormBean.frmMailMessage}</font> --%>
		
		</logic:notEmpty>

	</center>
	</html:form>
</div>

<footer>	
		<%@include file="inc/footer.jsp" %>
   </footer>
</body>
</html>