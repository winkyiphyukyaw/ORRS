<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head><%-- <%@include file="inc/admin_sidebar.jsp" %> --%>
<title>Update City</title>
</head>
<body>
<%-- <%@include file="inc/admin_sidebar1.jsp"%> --%>
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody">
		
<html:form action="/CityUpdate">
		
<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Update Page</h2>
<center>
			<logic:empty property="frmFormControl" name="AdminCityFormBean">
				<table align="center">
					<tr height="40px" >
						<td width="40%">Region\State:</td>
						<td><html:text property="frmRegionName" disabled="true"></html:text>
						</td>
					</tr>
					<tr height="40px">
						<td align="center">City:</td>
						<td><html:text property="frmCityName"></html:text> <font
							color="red">*</font>
						</td>
					</tr>
					<tr><td colspan="2" align="center"><html:errors property="frmCityName" /></td></tr>
					<tr height="40px" >
						<td colspan="2" align="center"><html:submit
							property="btnUpdate" value="&nbsp;Update&nbsp;" styleId="buttonwto">
						</html:submit>
						<%-- <html:cancel value="Cancel" /> --%>
						<html:cancel value="&nbsp;Cancel&nbsp;" styleId="buttonwto" />
						</td>
					</tr>
					<tr height="40px"><td colspan="2">
					<html:errors property="cityError" />
					</td></tr>
				</table>
			</logic:empty>
			<!-- Confirmation -->
			<logic:notEmpty property="frmFormControl" name="AdminCityFormBean">
				<table align="center">
					<tr height="40px">
						<td width="40%">Region\State:</td>
						<td><html:text property="frmRegionName" disabled="true">
						</html:text></td>
					</tr>
					<tr height="40px">
						<td align="center">City:</td>
						<td><html:text property="frmCityName" disabled="true">
						</html:text></td>
					</tr>
					<tr  height="40px">
						<td colspan="2" align="center"><html:submit
							property="btnSave" value="&nbsp;&nbsp;Save&nbsp;&nbsp;" styleId="buttonwto">
						</html:submit> <html:submit property="btnSaveCancel" value="&nbsp;Cancel&nbsp;" styleId="buttonwto">
						</html:submit></td>
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