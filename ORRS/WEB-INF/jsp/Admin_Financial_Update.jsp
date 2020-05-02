
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>

<%@ include file="inc/calendar.jsp"%>
<title>Financial Outcome Update</title>
<!-- <link href="css/library.css" rel="stylesheet" type="text/css"> -->
<%-- <%@include file="inc/admin_sidebar.jsp"%> --%>

</head>
<body>
<div class="mainbanner">
		<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
	</div>
<div class="mainbody">
		
<%-- <%@include file="inc/admin_sidebar1.jsp"%> --%>



		<html:form action="/FinancialUpdate">
		<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Update Daily Outcome here...</h2>
		<center>
		<logic:empty property="frmUpdateFormControl" name="FinancialFormBean">
			<table border="0" >
				<tr height="40px">
					<td width="30%" align="right">Select Date:</td>
					<td width="40%"><html:text property="firstDate" styleId="calendar" maxlength="10" size="15" readonly="true"/>
								
						<html:image src="images/calendar.gif"
						styleId="trigger" style="cursor: pointer; border: 1px solid red;"
						title="Date selector" onmouseover="this.style.background='red';"
						onmouseout="this.style.background=''"></html:image> 
						<font face="Verdana" size="2" color="blue">&nbsp;YYYY-MM-DD</font> <script type="text/javascript">
	//         
	Calendar.setup({
		firstDay : 1,
		electric : false,
		singleClick : true,
		inputField : "calendar",
		button : "trigger",
		ifFormat : "%Y-%m-%d",
		daFormat : "%Y-%m-%d"
	});
	//
</script>
<html:errors property="firstDate" />
<html:errors property="DateMisMatch"/>
</td>
<td width="30%"></td>
</tr>

<tr height="40px">
		<td align="right">Category:</td>
						<td>
							<%-- <html:text property="frmCategoryId" disabled="true"></html:text> --%>
							<html:select property="frmCategoryId">
								<%-- <html:option value="0">SELECT</html:option> --%>
								  <html:optionsCollection property="frmCategoryList" value="id"
									label="type" /> 
							</html:select> 
							<font color="red">***
								</font></td> <td><html:errors property="CategoryError"/></td>
							
						
					</tr>
		
		
		<tr height="40px">
					<td  align="right">Amount:</td>
					<td>
						<html:text property="frmOutcome" maxlength="8" ></html:text>
						<font color="red">***</font></td>
						<td width="30%"><html:errors property="frmOutcome"/>
						<html:errors property="outcomeError"/></td>
						</tr>
						
					
		<%-- <tr>
		<td colspan="3><html:errors property="outcomeError"/></td></tr>		 --%>
				
		<tr height="40px">
				<td colspan="3" align="center">
				<html:submit property="btnUpdateFinancial" value=" &nbsp;Update&nbsp;" styleId="buttonwto"></html:submit> 
				<%-- <html:submit property="btnUpdateFinancialCancel" value="&nbsp;Cancel&nbsp;" styleId="buttonwto"></html:submit> --%>
				<html:cancel value="&nbsp;Cancel&nbsp;" styleId="buttonwto"></html:cancel>
				</td>
				<%-- <html:cancel value="Cancel"></html:cancel> --%>
		</tr>
			</table>
			</logic:empty>
			</center>
		</html:form>
		
		
		<html:errors property="dateerror" />









<!-- ******For Confirmation*********** -->


<html:form action="/FinancialUpdate"> 
<center>
		<logic:notEmpty property="frmUpdateFormControl" name="FinancialFormBean">
		<%-- <html:form> --%>
		
		
			<table >
				<tr height="40px">
					<td width="30%">Select Date:</td>
					<td><html:text property="firstDate" styleId="calendar" maxlength="10" size="15" disabled="true"/>
								
						<%-- <html:image src="images/calendar.gif"
						styleId="trigger" style="cursor: pointer; border: 1px solid red;"
						title="Date selector" onmouseover="this.style.background='red';"
						onmouseout="this.style.background=''"></html:image> 
						<font face="Verdana" size="2" color="blue">&nbsp;YYYY-MM-DD</font> <script type="text/javascript">
						 --%>
	<!-- //         
	Calendar.setup({
		firstDay : 1,
		electric : false,
		singleClick : true,
		inputField : "calendar",
		button : "trigger",
		ifFormat : "%Y-%m-%d",
		daFormat : "%Y-%m-%d"
	});
	// -->
<!-- </script> -->
</td>
</tr>

<tr height="40px">
		<td width="30%">Category:</td>
							<td><html:text property="frmCategoryName" disabled="true"></html:text></td>
							</tr>
		
		
		<tr height="40px">
					<td>Amount:</td>
					<td>
						<html:text property="frmOutcome" disabled="true"></html:text>
					
					</td>
				</tr>
				
		<tr height="40px">
				<td colspan="2" align="center">
				<html:submit property="btnUpdateSaveFinancial" value="&nbsp;&nbsp;Save&nbsp;&nbsp;" styleId="buttonwto"></html:submit> 
				<html:submit property="btnUpdateSaveCancel" value="&nbsp;Cancel&nbsp;" styleId="buttonwto"></html:submit></td>
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