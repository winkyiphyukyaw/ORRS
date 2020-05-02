<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>
<title>Update Category Page</title>

</head>
<body>
<div class="mainbanner">
		<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
	</div>
<div class="mainbody" width="100%" height="auto">
		


<html:form action="/updateCategoryPath"> 
	<center>
			<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Update Profile Page</h2>
			 <logic:empty property="categoryList" name="AdminUpdateFormBean"> 
	
	
						<table>
							<tr height="60px">
								<td width="30%"></td>
								<td><html:text property="categoryName"></html:text> <font
									color="red">* </font> <html:errors property="categoryName" /></td>

							</tr>
							
							<tr height="40px">
							<td width="30%"></td>
						<td colspan="2" align="center"><html:submit
							property="btnUpdate" value="Update" styleId= "buttonwto">
						</html:submit> <html:cancel value="Cancel" styleId= "buttonwto">
						</html:cancel></td>
					</tr>
					<tr>
					<td width="30%"></td><td align="center"><html:errors property="categoryError" /></td></tr>		
						</table></logic:empty>
		<logic:notEmpty property="categoryList" name="AdminUpdateFormBean">
		<table align="center">
			<tr>

				<td><html:text property="categoryName" disabled="true"></html:text></td></tr>
				<tr><td><html:submit property="btnUpdateSave" styleId= "buttonwto">Save</html:submit></td>
				<td><html:submit property="btnSaveCancel" styleId= "buttonwto">Cancel</html:submit>
				
				</td>
				</tr>
				</table>
				</logic:notEmpty>
				</center>
		</html:form>
</div>
<footer>	
		<%@include file="inc/footer.jsp" %>
   </footer>
</body>
</html>