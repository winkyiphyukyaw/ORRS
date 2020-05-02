<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>
<title>Update Profile Page</title>
	
</head>
<body>
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody" >
		

<hr>
<html:form action="/adminViewProfileUpdatePath">  
<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Update Profile Page</h2>
			<center>
			 <logic:empty property="adminViewControl" name="ViewAdminFormBean">


					<table>
						<tr height="40px">
							<td>Name:</td>
							<td><html:text property="adminLoginName" maxlength="30"
									disabled="true"></html:text> <font color="red">***</font> <html:errors
									property="adminLoginName" /></td>
							<%-- <td align="center"><html:errors property="adminError" /></td> --%>

						</tr>
						<tr height="40px">
							<td>Password:</td>
							<td><html:password property="adminPassword"></html:password>
								<font color="red">***</font> <html:errors
									property="adminPassword" /></td>
						</tr>
						<tr height="40px">
							<td>Confirm Password:</td>
							<td><html:password property="adminConfirmPassword"></html:password>
								<font color="red">***</font> <html:errors
									property="adminConfirmPassword" /> <html:errors
									property="passwordError" /></td>
						</tr>
						<tr height="40px">
							<td></td>
							<td colspan="2" align="center"><html:submit
									property="btnAdminViewUpdate"
									value="&nbsp;&nbsp;Update&nbsp;&nbsp;" styleId="buttonwto">
									<%-- 	<td align="center"><html:errors property="adminError" /></td> --%>
								</html:submit> <%-- <td align="center"><html:errors property="adminError" /> --%>
								 <html:cancel value="Cancel" styleId= "buttonwto">
						
								</html:cancel></td>
						</tr>


					</table>
				</logic:empty> 
		 <logic:notEmpty property="adminViewControl" name="ViewAdminFormBean">
		<table align="center">
			<tr height="40px">

				<tr>
				<td>Name:</td>
				<td><html:text property="adminLoginName" disabled="true"></html:text> <%-- <font
					color="red">***</font> <html:errors property="adminLoginName" /> --%>
					</td>
			</tr>
			<tr height="40px">
				<td>Password:</td>
				<td><html:password property="adminPassword" disabled="true"></html:password> <%-- <font
					color="red">***</font> <html:errors property="adminPassword" /> --%>
					</td>
			</tr>
			
				<tr height="40px">
				<td></td>
				<td colspan="2"><html:submit property="btnAdminViewUpdateSave" styleId="buttonwto">&nbsp;&nbsp;Save&nbsp;&nbsp;</html:submit>
				<html:submit property="btnAdminViewSaveCancel" styleId="buttonwto">&nbsp;Cancel&nbsp;</html:submit></td>
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
