<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>

</head>
<body>
<div class="mainbanner">
<h1 align="center"
		style="font-size: 25px; color: #f0f0f0; text-shadow: 0 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody">
		

	
		<html:form>
		<center>
		<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Adopter Information</h2>
		    <logic:notEmpty property="adminViewOrphanControl" name="AdminViewOrphanFormBean">
		    
			<table class="body" align="center" border="3">
			
				<tr  height="35px">
					<td>Adopter Name:</td>
				    <td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterName}
					</td>
				</tr>
				<tr  height="35px">
					<td> Email:</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterEmail}</td>
				</tr>
				<tr  height="35px">
					<td> PhNo:</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterPhNo}
					</td>
				</tr>
				
				<tr  height="35px">
					<td> Address:</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterAddress}
					</td>
				</tr>
				<tr  height="35px">
					<td> NRC:</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterNrc}
					</td>
				</tr>
				
				<tr  height="35px">
					<td> Income(MMK):</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterIncome}
					</td>
				</tr>
				
				<tr  height="35px">
					<td> Occupation:</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterOccupation}
					</td>
				</tr>
				
				<tr  height="35px">
					<td> Martial Status:</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterMaritalStatus}
					</td>
				</tr>
				
				<tr  height="35px">
					<td> Gender:</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterGender}
					</td>
				</tr>
				
				<tr  height="35px">
					<td>No: Of Adopter Child:</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterNoOfChildren}
					</td>
				</tr>
				
				
				<tr  height="35px">
					<td> Date Of Birth:</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterDob}
					</td>
				</tr>
				
				<tr  height="35px">
					<td> Orphan Age:</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterOrphanAge}
					</td>
				</tr>
				
				<tr  height="35px">
					<td> Orphan Gender:</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adopterOrphanGender}
					</td>
				</tr>
				
				<tr height="35px">
					<td>No: Of Adopted Child:</td>
					<td>${AdminViewOrphanFormBean.adminViewAdopterDetail.adoptedChildNo}
					</td>
				</tr>
				
			</table>
			<table align="center">
			
				<tr height="35px">
				<td colspan="2" align="center"><html:submit property="btnOk1"
						styleId= "buttonwto" value="&nbsp;&nbsp;Back &nbsp;&nbsp;"></html:submit></td>
						</tr>
			</table>
			
			
			
				</logic:notEmpty>
				
				
				</center>
	</html:form>
	
	</div>
	<footer>	
		<%@include file="inc/footer1.jsp" %>
   </footer>
	</body>
	</html>
			
