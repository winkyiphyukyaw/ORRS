<%@ include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp" %>
<html>
<head>
<title>Update Shelter Form</title>
	


</head>
<body>
	<div class="mainbanner"><h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1></div>
	<div class="mainbody">
		
			
	
	
			<html:form action="updatePath">
			<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Shelter Update Profile</h2>
			<center>

					<logic:empty property="shelRegFormControl" name="UpdateFormBean">
					<center>
						<table widtd="70%" border="0">
							<tr height="40px">
								<td widtd="30%"><b> Region and State:</b></td>
								<td widtd="40%"><html:text property="shelterRegRegionState"
										disabled="true">
									</html:text></td>
									<td widtd="30%"><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p></td>
							</tr>
							<tr  height="40px">
								<td><b>City:</b></td>
								<td><html:text property="shelterRegCity" disabled="true">
									</html:text></td>
									<td></td>
							</tr>

							<tr height="40px">
								<td><b>Shelter Name:</b></td>
								<td><html:text property="shelterRegName" maxlength="45"></html:text><font
									color="red">***</font> </td>
									<td><html:errors property="shelterRegName" /></td>
							</tr>
							<tr height="40px">
								<td><b>Principal Name:</b></td>
								<td><html:text property="shelterPrincipalName" maxlength="20"></html:text><font
									color="red">***</font> </td>
										<td><html:errors
										property="shelterPrincipalName" /></td>
							</tr>
							<tr height="40px">
								<td><b>Login Name:</b></td>
								<td><html:text property="shelterLoginName" disabled="true"></html:text>
									</td>
									<td><html:errors property="shelterLoginName" /></td>
							</tr>
							<tr height="40px">
								<td><b>Password:</b></td>
								<td><html:password  property="shelterRegPassword">
									</html:password><font color="red">***</font> </td>
										<td><html:errors
										property="shelterRegPassword" /></td>
							</tr>
							<tr height="40px">
								<td><b>Confirm Password:</b></td>
								<td><html:password property="shelterRegConfPassword">
									</html:password><font color="red">***</font></td>
										<td> <html:errors
										property="shelterRegConfPassword" /> <html:errors
										property="passwordError" /></td>
							</tr>


							<tr height="40px">
								<td><b>Breakfast Cost(MMK):</b></td>
								<td><html:text property="shelterRegBfCost" maxlength="8">
									</html:text><font color="red">***</font>
								
								</td>
								<td><html:errors property="shelterRegBfCost" />
								<html:errors property="breakfastError" /></td>
							</tr>
							<tr height="40px">
								<td><b>Lunch Cost(MMK):</b></td>
								<td><html:text property="shelterRegLunCost" maxlength="8">
									</html:text><font color="red">***</font>
								
								</td>
								<td><html:errors property="shelterRegLunCost" />
								<html:errors property="lunchError" /></td>
							</tr>
							<tr height="40px">
								<td><b>Dinner Cost(MMK):</b></td>
								<td><html:text property="shelterRegDinCost" maxlength="8">
									</html:text><font color="red">***</font>
								
								</td>
								<td><html:errors property="shelterRegDinCost" />
								<html:errors property="dinnerError" /></td>
							</tr>
							<tr height="40px">
								<td><b>Email Address:</b></td>
								<td><html:text property="shelterRegEmail"></html:text> <font
									color="red">***</font> </td>
									<td><html:errors property="shelterRegEmail" /></td>
							</tr>
							<tr height="40px">
								<td><b>Phone Number:</b></td>
								<td><html:text property="shelterRegPhone" maxlength="14">
									</html:text><font color="red">***</font> </td>
										<td><html:errors
										property="shelterRegPhone" /></td>
							</tr>
							<tr><td></td><td colspan="2"><font color="green">(eg.,0xx-xxxxxx,0x-xxxxxxx,0x-xxxxxxxxxxx)</font></td></tr>
							<tr height="80px">
								<td><b>Address:</b></td>
								<td><html:textarea  style=" border-color:#086A87; background-color: white" property="shelterRegAddress" >
									</html:textarea> <font color="red">***</font>
								<td>
								<html:errors property="shelterRegAddress" /></td></td>
							</tr>


							<tr height="40px">
								<td colspan="3" align="center"><html:submit styleId= "buttonwto"
										property="btnUpdate" value="Update">
									</html:submit> <html:cancel styleId= "buttonwto" value="Cancel"  /></td>
									
							</tr>
						</table>
						</center>
					</logic:empty>
					<!-- Confirmation -->
					<logic:notEmpty property="shelRegFormControl" name="UpdateFormBean">
					<center>
					
						<table>
							<tr height="40px">
								<td><b>Region and State:</b></td>
								<td><html:text property="shelterRegRegionState"
										disabled="true">
									</html:text></td>
									<td></td>
							</tr>


							<tr  height="40px">
								<td><b>City:</b></td>
								<td><html:text property="shelterRegCity" disabled="true">
									</html:text></td>
									<td></td>
									</tr>
							<tr height="40px">
								<td><b>Shelter Name:</b></td>
								<td><html:text property="shelterRegName" disabled="true"></html:text>
								</td>
								<td></td>
							</tr>
							<tr height="40px">
								<td><b>Principal Name:</b></td>
								<td><html:text property="shelterPrincipalName"
										disabled="true"></html:text></td>
										<td></td>
							</tr>
							<tr height="40px">
							<td><b>Login Name:</b></td>
							<td><html:text property="shelterLoginName" disabled="true"></html:text></td>
							<td></td>
							</tr>

							<tr height="40px">
								<td><b>Password:</b></td>
								<td><html:password property="shelterRegPassword"
										disabled="true">
									</html:password></td>
									<td></td>
							</tr>
							<tr height="40px">
								<td><b>Confirm Password:</b></td>
								<td><html:password property="shelterRegConfPassword"
										disabled="true">
									</html:password>
									</td>
									<td></td>
							</tr>



							
							<tr height="40px">
								<td><b>Breakfast Cost:</b></td>
								<td><html:text property="shelterRegBfCost" disabled="true">
									</html:text></td>
									<td></td>
							</tr>
							<tr height="40px">
								<td><b>Lunch Cost:</b></td>
								<td><html:text property="shelterRegLunCost" disabled="true">
									</html:text></td>
									<td></td>
							</tr>
							<tr height="40px">
								<td><b>Dinner Cost:</b></td>
								<td><html:text property="shelterRegDinCost" disabled="true">
									</html:text></td>
									<td></td>
							</tr>
							<tr height="40px">
								<td><b>Email Address:</b></td>
								<td><html:text property="shelterRegEmail" disabled="true"></html:text>
								</td>
								<td></td>
							</tr>
							<tr height="40px">
								<td><b>Phone Number:</b></td>
								<td><html:text property="shelterRegPhone" disabled="true">
									</html:text></td>
									<td></td>
							</tr>

							<tr height="80px">
								<td><b>Address:</b></td>
								<td><html:textarea  style=" border-color:#086A87; background-color: white" property="shelterRegAddress" >
									</html:textarea></td>
									<td></td>
							</tr>

							<tr height="40px">
								<td colspan="2" align="center"><html:submit
										styleId= "buttonwto" property="btnSave" value="Save" >
									</html:submit> <html:submit styleId= "buttonwto" property="btnSaveCancel" value="Cancel">
									</html:submit></td>
									<td></td>
							</tr>
						</table>
						</center>
					</logic:notEmpty>
					</center>
				</html:form></div>
				<footer>
				
	<%@include file="inc/footer1.jsp"%></footer>
</body>
</html>