
<%@include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp" %>
<html:html>
<head>
<meta charset="UTF-8">
<title>Shelter Upload Event</title>
	

</head>

<body>
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody">
		
			
	
	<html:form action="/uploadEventPath2" method="post"
		enctype="multipart/form-data">
		
		<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Upload Story or Activity</h2>
		<center>



		<logic:empty property="shelterEventFormControl"
			name="ShelterEventFormBean">

			

		<center>
			<table>
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
					<td><span style="color: blue;">Text Box</span></td>
				</tr>
				<tr>
					<td><html:textarea rows="15" cols="67" property="eventText"></html:textarea></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td height="50px"><html:errors property="eventText" /></td>
				</tr>
				<tr>
					<td><span style="color: blue;">Browse the Image you
							want to Use</span></td>
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
							property="btnUpload" value="&nbsp;Upload&nbsp;" styleId="buttonwto"/> <html:cancel
							value="Cancel"  styleId="buttonwto"/>
			</table>
</center>
		</logic:empty>
		<logic:notEmpty property="shelterEventFormControl"
			name="ShelterEventFormBean">
			
			<h2
				style="padding-left: 20px; font-size: 15px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Are
				you sure to Upload!</h2>
				<center>
			<table >
				<tr>
					<td><html:radio property="frmEventStoryStatus" value="0"
							disabled="true">&nbsp; Story &nbsp;</html:radio> <html:radio
							property="frmEventStoryStatus" value="1" disabled="true">&nbsp;Activity&nbsp;</html:radio></td>
				</tr>
				<tr>
					<td><html:textarea rows="15" cols="60" property="eventText"
							disabled="true"></html:textarea></td>
				</tr>

				<tr></tr>
				<tr>
					<td><span style="color:blue">The Image you Selected</span></td>
				</tr>
				<tr>
					<td>
						<%-- <c:if test="${AdminEventFormBean1.filePath1!"images/"}"> --%>
						<html:img src="${ShelterEventFormBean.filePath}" height="200"
							width="350" />
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2"><html:submit
							property="btnConfirm" value="Confirm" onclick="myFunction()" styleId="buttonwto" /> <script>
								function myFunction() {
									alert("You have uploaded successfully!");
								}
							</script> <html:submit property="btnConfirmCancel" value="Cancel" styleId="buttonwto"/></td>
				</tr>
			</table>
</center>
		</logic:notEmpty>

</center>
	</html:form>
	</div>
	<footer>
	<%@ include file="inc/footer1.jsp"%></footer>
</body>
</html:html>