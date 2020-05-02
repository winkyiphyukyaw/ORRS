<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>
<title>Admin Event Upload</title>
<%@ include file="inc/calendar.jsp"%>

</head>
<body>
	<div class="mainbanner">
		<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
	</div>
	<div class="mainbody">
		
			<html:form action="/adminEditConfirmPath"
				enctype="multipart/form-data">
	
				<center>

				<logic:empty property="adminEditEventControl"
								name="AdminEventFormBean1">
								<h3 align="center">
									<font color="#366b82">Edit what you want!</font>
								</h3>
<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Edit what you want!</h2>
								<table align="center">
									<tr>
										<td colspan="2" align="left"><html:radio
												property="frmEventStoryStatus" value="0">Story</html:radio>
											<html:radio property="frmEventStoryStatus" value="1">Activity</html:radio></td>
									</tr>

									<tr>
										<td><html:textarea rows="15" cols="67"
												property="eventText"></html:textarea></td>
									</tr>
									<tr>
										<td><html:img
												src="${AdminEventFormBean1.frmEditEventImgPath}"
												height="250" width="400" /></td>
									</tr>
									<tr>
										<td><span style="color=#366b82">Browse the Image you want to Change</span></td>
									</tr>
									<tr>
										<td height="50px"><html:file property="frmUploadFile" /></td>
									</tr>
									<tr>
										<td><html:errors property="frmUploadFile" /></td>
									</tr>
									<tr>
										<td><html:errors property="fileSizeError1" /> <html:errors
												property="fileNameError1" /></td>
									</tr>
									<tr>
										<td align="center" colspan="2"><html:submit
												property="btnEdit" value="&nbsp;Edit&nbsp;"
												styleId="buttonwto" /> <html:submit property="btnEditCancel"
												value="&nbsp;Cancel&nbsp;" styleId="buttonwto" /></td>
									</tr>
								</table>

							</logic:empty> <logic:notEmpty property="adminEditEventControl"
								name="AdminEventFormBean1">
								<h4 align="center">
									<font color="#366b82">Are you sure to Edit!</font>
								</h4>

								<table align="center">
									<tr>
										<td colspan="2" align="center"><html:radio
												property="frmEventStoryStatus" value="0" disabled="true">Story</html:radio>
											<html:radio property="frmEventStoryStatus" value="1"
												disabled="true">Activity</html:radio></td>
									</tr>
									<tr>
										<td><html:textarea rows="15" cols="67"
												property="eventText" disabled="true"></html:textarea></td>
									</tr>

									<tr>
										<td><span style="color:#366b82">The Image you Selected</span></td>
									</tr>

									<c:set var="myVar">AdminEventFormBean1.filePath1</c:set>
									<c:if test="${myVar!=null}">
										<tr>
											<td><html:img src="${AdminEventFormBean1.filePath1}"
													height="250" width="400" /></td>
										</tr>
									</c:if>
									<c:if test="${myVar==null}">
										<tr>
											<td><html:img
													src="${AdminEventFormBean1.frmEditEventImgPath}"
													height="250" width="400" /></td>
										</tr>
									</c:if>
									<%-- </td></tr>
					<tr><td><html:file property="frmUploadFile" disabled="true"/></td>
				</tr>  --%>
									


									<tr>
										<td align="center" colspan="2"><html:submit
												property="btnEditConfirm" value="&nbsp;Confirm&nbsp;"
												styleId="buttonwto" onclick="myFunction()" /> <script>
													function myFunction() {
														alert("You have Edited and Uploaded successfully!");
													}
												</script> <html:submit property="btnEditConfirmCancel" value="&nbsp;Cancel&nbsp;"
												styleId="buttonwto" /></td>
									</tr>
								</table>
								</br>
								</br>
								<table align="center">
									<tr>
										<td><html:errors property="fileSizeError1" /> <html:errors
												property="fileNameError1" /></td>
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
