<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>
<title>
Admin Event View
</title>
<%@ include file="inc/calendar.jsp"%>

</head>
<body>
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody">
		
		
<html:form action="/adminViewEvent">
<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">View  Story and Activity</h2>
<h2  style=" padding-left:20px;font-size: 17px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Choose What You Want to View</h2>
<center>

		<logic:empty property="adminEventFormControl1"
			name="AdminEventFormBean1">
			
<center>
			<table >
				
				<tr>
					<td colspan="20" height="50px"><html:radio property="frmEvent" value="0">Story</html:radio>&nbsp;&nbsp;&nbsp;&nbsp;
						<html:radio property="frmEvent" value="1">Activity</html:radio>&nbsp;&nbsp;&nbsp;&nbsp;
						<html:radio property="frmEvent" value="2">All</html:radio></td></tr><tr><td colspan="10" height="50px">
						<html:errors property="frmEvent" /></td>
				</tr>



				<tr>
					<td height="50px">From</td>
					<td height="50px"><html:text property="frmSearchDate1" styleId="calendar"
							maxlength="15" size="15"  readonly="true"/> <html:image
							src="images/calendar.gif" styleId="trigger"
							style="cursor: pointer; border: 1px solid red;"
							title="Date selector" onmouseover="this.style.background='red';"
							onmouseout="this.style.background=''"></html:image> <font
						face="Verdana" size="2" color="blue">&nbsp;YYYY-MM-DD</font> <script
							type="text/javascript">
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
					</td>
				</tr>
				<tr><td colspan="2" align="center"><html:errors property="frmSearchDate1"/></td></tr>
				<tr>
					<td height="50px">To</td>
					<td height="50px"><html:text property="frmSearchDate2" styleId="calendar1"
							maxlength="15" size="15" readonly="true"/> <html:image
							src="images/calendar.gif" styleId="trigger1"
							style="cursor: pointer; border: 1px solid red;"
							title="Date selector" onmouseover="this.style.background='red';"
							onmouseout="this.style.background=''"></html:image> <font
						face="Verdana" size="2" color="blue">&nbsp;YYYY-MM-DD</font> <script
							type="text/javascript">
							//         
							Calendar.setup({
								firstDay : 1,
								electric : false,
								singleClick : true,
								inputField : "calendar1",
								button : "trigger1",
								ifFormat : "%Y-%m-%d",
								daFormat : "%Y-%m-%d"
							});
							//
						</script> </td>
				</tr>
				<tr><td colspan="2" align="center"><html:errors property="frmSearchDate1"/></td></tr>
				<tr><td align="center" colspan="2" ><html:errors property="dateError"/></td></tr>
				<tr><td align="center" colspan="2" ><html:errors property="samedateError"/></td></tr>
				<tr><td align="center" colspan="2" ><html:errors property="noDateError"/></td></tr>
				<tr><td align="center" colspan="2" ><html:errors property="firstDateError"/></td></tr>
				<tr><td align="center" colspan="2" ><html:errors property="secondDateError"/></td></tr>
				
				<tr>
					<td align="center" colspan="2"><html:submit property="btnView"
							value="&nbsp;&nbsp;View&nbsp;&nbsp;" styleId= "buttonwto" /> <html:cancel value="&nbsp;Cancel &nbsp;" styleId= "buttonwto" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td></td>
				</tr>
				
			</table></center>
			 
		</logic:empty>
		</center>
	</html:form>
	<p align="center"><html:errors property="noEventError" /></p>
	</div>
	<footer>	
		<%@include file="inc/footer1.jsp" %>
   </footer>
</body>
</html>