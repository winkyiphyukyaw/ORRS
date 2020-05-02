
<%@ include file="inc/common.jsp"%>

<html>
<head>
<title>Admin Event Upload</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style2.css" rel='stylesheet' type='text/css' />
<link href="css/style3.css" rel='stylesheet' type='text/css' />


</head>
<body>
	<%@include file="inc/banner1.jsp"%>
	<div class="mainbanner">
		<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
	</div>
	<div class="mainbody" >
		
			
			<html:form action="/adminEventPath2" enctype="multipart/form-data">
			<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Upload  Story or Activity</h2>
			<center>
				<logic:empty property="adminEventFormControl"
								name="AdminEventFormBean">
								<!-- <h2 align="center">
						<font color="blue">Upload Event or Story</font>
					</h2>  -->




								<table align="center">
									<tr>
										<td><html:radio property="frmEventStoryStatus" value="0">Story</html:radio>
											<html:radio property="frmEventStoryStatus" value="1">Activity</html:radio>
										</td>
									</tr>
									<tr>
										<td><html:errors property="frmEventStoryStatus" /></td>
									</tr>

									<tr>
										<td height="40px">
									<tr>
										<td><span style="color: #366b82;">Text Box</span></td>
									</tr>
									<tr>
										<td><html:textarea rows="15" cols="67"
												property="eventText">Text Here</html:textarea></td>
									</tr>
									<tr></tr>
									<tr></tr>
									<tr>
										<td height="50px"><html:errors property="eventText" /></td>
									</tr>
									<tr>
										<td><span style="color: #366b82;">Browse the Image
												you want to Use</span></td>
									</tr>

									<tr>
										<td height="50px"><html:file property="frmUploadFile" /></td>
									</tr>
									<tr>
										<td><html:errors property="frmUploadFile" /></td>
									</tr>
									<tr>
										<td><html:errors property="fileSizeError" /> <html:errors
												property="fileNameError" /></td>
									</tr>
									<tr>
										<td align="center" colspan="2" height="50px"><html:submit
												property="btnUpload" value="&nbsp;Upload&nbsp;"
												styleId="buttonwto" /> <html:cancel
												value="&nbsp;Cancel &nbsp;" styleId="buttonwto" /></td>
									</tr>

								</table>

							</logic:empty> <logic:notEmpty property="adminEventFormControl"
								name="AdminEventFormBean">
								<!-- <h2 align="center">
						<font color="blue">Are you sure to Upload!</font>
					</h2>  -->
								<h2
									style="padding-left: 20px; font-size: 20px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Are
									you sure to Upload!</h2>
								<table align="center">
									<tr>
										<td><html:radio property="frmEventStoryStatus" value="0"
												disabled="true">&nbsp; Story &nbsp;</html:radio> <html:radio
												property="frmEventStoryStatus" value="1" disabled="true">&nbsp;Activity&nbsp;</html:radio></td>
									</tr>
									<tr></tr>
									<tr>
										<td><html:textarea rows="15" cols="67"
												property="eventText" disabled="true"></html:textarea></td>
									</tr>
									<tr ></tr>
									<tr rowspan="3">
										<td><span style="color:#366b82;font-size: 15px;">The Image You Selected</span></td>
									</tr>
									<tr>
										<td>
											<%-- <c:if test="${AdminEventFormBean1.filePath1!"images/"}"> --%>
											<html:img src="${AdminEventFormBean.filePath2}" height="250"
												width="400" />
										</td>
									</tr>
									<tr>
										<td align="center" colspan="2"><html:submit
												property="btnConfirm" value="Confirm" styleId="buttonwto"
												onclick="myFunction()" /> <script>
													function myFunction() {
														alert("You have uploaded successfully!");
													}
												</script> <html:submit property="btnConfirmCancel" value="Cancel"
												styleId="buttonwto" /></td>
									</tr>
								</table>

							</logic:notEmpty>
							</center>
			</html:form>

		</div>
	
	<footer>
		<%@include file="inc/footer1.jsp"%>
	</footer>
</body>
</html>