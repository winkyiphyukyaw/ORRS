<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>

<!-- <link href="css/library.css" rel="stylesheet" type="text/css"> -->
</head>
<body>
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody">
		
	
	
		<html:form>
		<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Orphan Detail List</h2>
		    <logic:notEmpty property="adminViewOrphanControl" name="AdminViewOrphanFormBean">
		    <center>
		    <table class="body" border="1">
			
				<tr>
  				 <td>Shelter Name:</td>
 					  <td>${AdminViewOrphanFormBean.adminViewOrphanDetail.shelter.shelterName}
					</td>
				</tr>
				
				<tr>
					<td>Orphan Name:</td>
				    <td>${AdminViewOrphanFormBean.adminViewOrphanDetail.orphanName}
					</td>
				</tr>
				<tr>
					<td>Age:</td>
					<td>${AdminViewOrphanFormBean.adminViewOrphanDetail.orphanAge}</td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td>${AdminViewOrphanFormBean.adminViewOrphanDetail.orphanGender}
					</td>
				</tr>
				<tr>
					<td>Education:</td>
					<td>
					${AdminViewOrphanFormBean.adminViewOrphanDetail.orphanEdu}</td>
				</tr>
				<tr>
					<td>Religion:</td>
					<td>
					${AdminViewOrphanFormBean.adminViewOrphanDetail.orphanReligion}</td>
				</tr>
				<tr>
					<td>Adoption_Status:</td>
					<td><c:if test="${AdminViewOrphanFormBean.adminViewOrphanDetail.adoptStatus==0}">
								Not Yet!							 	
				    </c:if>
							
					<c:if test="${AdminViewOrphanFormBean.adminViewOrphanDetail.adoptStatus==1}">
							Adopt!
				    </c:if>
				    </td>
				    </tr>			    
				    
				   
				 
			</table>
			<br>
			<table> <tr>
				     
				          <td colspan="2" align="center"><html:submit property="btnOk"
						   styleId= "buttonwto" value="&nbsp;&nbsp;Back &nbsp;&nbsp;"></html:submit>
						 <c:if test="${AdminViewOrphanFormBean.adminViewOrphanDetail.adoptStatus==1}">
						  <a href="AdminViewAdopterDetailPath.do?adminViewOrphanDetailId=${AdminViewOrphanFormBean.adminViewOrphanDetail.id}&adminViewAdopterDetailId=${AdminViewOrphanFormBean.adminViewOrphanDetail.adopter.id}&adminViewOrphanControl=3">
						      <font color="#086Aee">Adopter Detail Info</font></a>
						 </c:if>						
					     </td>
					   
				     </tr></table>
			</center>
			</logic:notEmpty>
			
			
			
				
			
				
	</html:form>
	
	</div></div>
	<footer>	
		<%@include file="inc/footer.jsp" %>
   </footer>
	</body>
	</html>
		