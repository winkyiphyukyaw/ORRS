<%-- <%@include file="inc/banner.jsp"%> --%>

<%-- <%@ taglib uri="http://displaytag.sf.net" prefix="display" %> --%>
<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<%@ include file="inc/calendar.jsp"%>
<html>
<head>


<title>Financial Outcome</title>

</head>

<body>

<div class="mainbanner">
		<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
	</div>
<div class="mainbody" >
		

		<html:form method="POST" action="/FinancialCalPath">
		<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Insert Daily Outcome!</h2>
		 <center>
		<logic:empty property="frmFinancialFormControl" name="FinancialFormBean">
		<%-- <html:form> --%>
			<table   width="100%">
				<tr height="40px">
					<td width="25%"></td>
					<td>Select Date:</td>
					
					<td ><html:text property="firstDate" styleId="calendar" maxlength="10"  readonly="true" />
								
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
</td>
<td><html:errors property="firstDate" />
<html:errors property="DateMisMatch"/>
</td>




</tr>

<tr height="40px">
<td width="25%"></td>
		<td>Category:</td>
		
						<td >
							<html:select property="frmCategoryId">
								<html:option value="0">SELECT</html:option>
								  <html:optionsCollection property="frmCategoryList" value="id"
									label="type" /> 
							</html:select> 
							<font color="red">***
								<td><html:errors property="CategoryError"/></td>
							</font>
						</td>
						
					</tr>
		
		
		<tr height="40px">
		<td width="25%"></td>
		
					<td>Amount(MMK):</td>
					
					<td>
						<html:text property="frmOutcome" maxlength="9"></html:text>
						<font color="red">***</font>
						
					</td>
					<td><html:errors property="outcomeError"/>
					<html:errors property="frmOutcome"/></td>
					
				</tr>
				
		<tr height="40px">
		<td width="25%"></td>
		<td ></td>
				<td colspan="2">
				<html:submit property="btnInsertFinancial" value="&nbsp;Add&nbsp;" styleId="buttonwto"></html:submit> 
			   	<%-- <html:submit property="btnInsertCancel" value="Clear"></html:submit> --%>
			  <%--  	<html:reset value="&nbsp;Clear&nbsp;" styleId="buttonwto"></html:reset> --%>
				 <html:cancel value="&nbsp;Cancel&nbsp;" styleId="buttonwto"/></td> 
		</tr>
			</table>
			</logic:empty>
<!-- Confirmation -->
<logic:notEmpty property="frmFinancialFormControl" name="FinancialFormBean">
	<table   width="80%">
					<tr>
					<td width="25%"></td>
					<td>Select Date:</td>
					<td><html:text property="firstDate" styleId="calendar" maxlength="10" size="10" disabled="true"/>
								
						

</td>


</tr>

	<tr>
	<td width="25%"></td>
		<td>Category:</td>
							<td><html:text property="frmCategoryName" disabled="true"></html:text></td>
	</tr>
		
		
	<tr>
	<td width="25%"></td>
					<td>Amount(MMK):</td>
					<td>
						<html:text property="frmOutcome" disabled="true"></html:text>

					</td>
	</tr>
					
					
					<tr>
					<td></td>
					<td width="25%"></td>
						<td colspan="2" ><html:submit
							property="btnSaveFinancial" value="&nbsp;&nbsp;Save&nbsp;&nbsp;" styleId="buttonwto">
						</html:submit> <html:submit property="btnsaveFinancialCancel" value="&nbsp;Cancel&nbsp;" styleId="buttonwto">
						</html:submit></td>
					</tr>
				</table>
</logic:notEmpty>	
</html:form>
		


<!-- -----------------For View--------------------------------------------------------------------------------- -->
<h2 style="padding-left: 0px;  font-size: 20px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);"><center>Financial Outcome List.</center></h2>
			<html:form method="POST" action="/FinancialpagingPath">
			<logic:notEmpty property="frmAmountList" name="FinancialFormBean">
			<table  class="body" align="center" border="1" bordercolor="#086A87" >
					<tr height="40" >
						<!-- <th >No</th>
						<th>Report-date</th>
						<th >Category</th>
						<th >Monthly-Outcome</th>
						<th >Update</th> -->
						<th align="center" width="50px">No</th>
						<th align="center" width="150px">Report-date</th>
						<th align="center" width="150px">Category</th>
						<th align="center" width="170px">Daily Outcome(MMK)</th>
						<th align="center" width="150px">Update</th>
						<!-- <td></td> -->
					</tr>
					<c:forEach var="i" begin="${FinancialFormBean.begin}" end="${FinancialFormBean.end}">
					<tr height="40">
							<td align="center">${i}</td>
							
							<td align="center">${FinancialFormBean.frmAmountList[i-1].reportDate}</td>
							<td align="center">${FinancialFormBean.frmAmountList[i-1].category.type}</td>
							<td align="center">${FinancialFormBean.frmAmountList[i-1].monthlyOutcome}0</td>
							<td align="center">
							 <a href="FinancialUpdatePath.do?frmUpdateFinancialProfileId=${FinancialFormBean.frmAmountList[i-1].id}&frmFormControl=2"><font color="blue">Update</font></a>
							</td> 
						</tr>
					</c:forEach>	
			</table>
			
			<br>
				<!-- next and previous button control here -->
				<table align="center" width="60%">
					<tr>
						<td width="45%">
						
						<c:if test="${FinancialFormBean.prevBtn}">
                            <html:submit property="prev" value="&nbsp;Previous&nbsp;" styleId="buttonwto">
							</html:submit>
						</c:if>
						
						<td width="55%"></td>
						</td>
						<td>
						
						<c:if test="${FinancialFormBean.nextBtn}">
							<html:submit property="next" value="&nbsp;&nbsp;Next&nbsp;&nbsp;" styleId="buttonwto">
							</html:submit>
              			</c:if>
              			
						</td>
					</tr>
					<html:errors property="LocError" />
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
