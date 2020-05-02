<%@include file="inc/common.jsp"%>
<html>
	<head><title>Framework Registration</title>
		<link href="css/library.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<h3 align="center">Framework Registration Page</h3>
		<hr>
		<html:form action="/registerPath">
		<%-- <html:form> --%>
			<logic:empty property="frmRegFormControl" name="RegisterFormBean">
				<table align="center">
					<tr>	
						<td>Name:</td>
						<td>
							<html:text property="frmRegName"></html:text>
							<font color="red">***
								<html:errors property="frmRegName"/>
							</font>
						</td>
					</tr>
					<tr>	
						<td>Password:</td>
						<td>
							<html:password property="frmRegPassword"></html:password>
							<font color="red">***
								<html:errors property="frmRegPassword"/>
							</font>
						</td>
					</tr>
					<tr>	
						<td>Confirm Password:</td>
						<td>
							<html:password property="frmRegConfPassword"></html:password>
							<font color="red">***
								<html:errors property="frmRegConfPassword"/>
								<html:errors property="passwordError"/>
							</font>
						</td>
					</tr>
					
					<tr>	
						<td colspan="2" align="center">
							<html:submit property="btnRegister" value="Register"></html:submit>
							<%-- <html:submit property="btnRegisterCancel" value="Cancel"></html:submit> --%>
							<html:cancel value="Cancel"></html:cancel>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<html:errors property="accountError"/>
						</td>
					</tr>
				</table>
			</logic:empty>
			<logic:notEmpty property="frmRegFormControl" name="RegisterFormBean">
				<table align="center">
					<tr>	
						<td>Name:</td>
						<td>
							<html:text property="frmRegName" disabled="true"></html:text>
						</td>
					</tr>
					
					<tr>	
						<td>Password:</td>
						<td>
							<html:password property="frmRegPassword" disabled="true"></html:password>
						</td>
					</tr>
					<tr>	
						<td>Confirm Password:</td>
						<td>
							<html:password property="frmRegConfPassword" disabled="true"></html:password>
						</td>
					</tr>
				
					<tr>	
						<td colspan="2" align="center">
							<html:submit property="btnSave" value="Save"></html:submit>
							<html:submit property="btnSaveCancel" value="Cancel"></html:submit>
						</td>
					</tr>
				</table>
			</logic:notEmpty>
		</html:form>
	</body>
</html>