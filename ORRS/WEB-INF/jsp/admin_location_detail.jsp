<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>
<title>Add City</title>

<!-- Calling java code -->
<script type="text/javascript">
	function sendRegion(regionId) {
		AjaxSearchSubcity.getBySubcity(regionId, callbackRegion);
	}
	//when subcategory is obtained from server
	function callbackRegion(message) {
		dwr.util.removeAllOptions("subcitylist");
		dwr.util.addOptions("subcitylist", message, "id", "name");
	}
//-->
</script>
<!-- Declare the javascript for scriptaculous -->
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/effects.js"></script>
<script type="text/javascript" src="js/controls.js"></script>
<script type="text/javascript" src="js/scriptaculous.js"></script>
<script type='text/javascript' src="js/autocompleteex.js"></script>

<!-- Declare the javascript for DWR -->
<script src='dwr/engine.js'></script>
<script src='dwr/util.js'></script>

<!-- Do the javascript function for auto complement -->
<script src='dwr/interface/AjaxSearchSubcity.js'></script>

</head>

<body  onload="DWRUtil.useLoadingMessage();">

<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> 
</div>
	<div class="mainbody">
		
	
		
		
		<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Add New City!</h2>
					<html:form method="POST" action="LocationAdmin">
					<center>
							<logic:empty property="frmFormControlLocation"
								name="AdminCityFormBean">
								<table  width="50%" cellspacing="30" align="center" border="0">
									
					<tr>
						<td align="right" width="38%"><label for="name">Region\State</label></td>
						<td><html:text property="frmRegionStateName" disabled="true"></html:text></td>
						</tr>
									<tr height="45">
										<td align="right" width="20%"><label for="name">City&nbsp;</label></td>
										<td width=35%><html:text property="frmCityName"/><font color="red">*</font></td>
										<td width="40%"><html:errors property="frmCityName" /></td>
									</tr>
									<tr>
									
										<td align="center" colspan="3">
										<html:submit property="btnAdd" value="&nbsp;Add&nbsp;" styleId="buttonwto"/> 
									 	<%-- <html:reset value="&nbsp;&nbsp;Clear&nbsp;&nbsp;" styleId="buttonwto" />  --%>
									 	<html:cancel value="&nbsp;&nbsp;Back&nbsp;&nbsp;" styleId="buttonwto"/>
									 	</td>
									</tr>
									<tr>
										<td><html:errors property="cityError" /></td>
									</tr>
									<!-- </tbody> -->
								</table>
							</logic:empty>
							
							<!-- Confirmation -->
							<logic:notEmpty property="frmFormControlLocation"
								name="AdminCityFormBean">
								<table width="30%" cellspacing="30" align="center">
									<tr>
										<td><b>Region\State</b></td>
										<td><html:text property="frmRegionStateName"
												disabled="true">
											</html:text></td>
									</tr>
									<tr>
										<td align="right"><b>City&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
										<td><html:text property="frmCityName" disabled="true">
											</html:text></td>
									</tr>
									<tr>
										<td colspan="2" align="center"><html:submit
												property="btnLocSave" value="&nbsp;&nbsp;&nbsp;Save&nbsp;&nbsp;&nbsp;" styleId="buttonwto">
											</html:submit> <html:submit property="btnLocSaveCancel" value="&nbsp;Cancel&nbsp;" styleId="buttonwto">
											</html:submit></td>
									</tr>
								</table>
							</logic:notEmpty>
							</center>
						</html:form> 
		
		
		<!-- For View City List -->
		
	
		
		

			<html:form action="/LocationDetailPath">
			<logic:notEmpty name="AdminCityFormBean" property="frmSubcityList">
			<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">City List In&nbsp; " ${AdminCityFormBean.frmRegionStateName} "</h2>

			<center>
					<table class="body" border="1" bordercolor="#086A87">
						<tr  align="center" height="38" >
								<th align="center" width="50px"><center>No</center></th>
								<th align="center" width="260px"><center>City</center></th>
								<th align="center" widht="100px">Update Link</th>
						
						</tr>
						
						<c:forEach var="i" begin="${AdminCityFormBean.beginDetail}" end="${AdminCityFormBean.endDetail}">
						<tr height="44">
							<td  align="center">${i} </td>
							<td>${AdminCityFormBean.frmSubcityList[i-1].name}</td>							
							<td align="center">
							 <a href="CityUpdatePath.do?frmUpdateCityId=${AdminCityFormBean.frmSubcityList[i-1].id}&frmControl=3"><font color="#086Aee">Update</font></a>
							</td> 
						</tr>
						</c:forEach>
					</table>
			
				<!-- next and previous button control here -->
				<br>
				<table width="30%">
					<tr>
						<td>
						<div align="center">
						<c:if test="${AdminCityFormBean.prevBtnDetail}">
                            <html:submit property="prevDetail" value="&nbsp;Previous&nbsp;" styleId="buttonwto">
							</html:submit>
						</c:if>
						</div>
						</td>
						<td width="100%"></td>
						<td>
						<div align="center">
						<c:if test="${AdminCityFormBean.nextBtnDetail}">
							<html:submit property="nextDetail" value="&nbsp;&nbsp;Next&nbsp;&nbsp;" styleId="buttonwto">
							</html:submit>
              			</c:if>
              			
              			</div>	
						</td>
					</tr>	
					<html:errors property="LocError" />
				</table>
				</center>
				</logic:notEmpty>
				</html:form>
				
						
		
		
		

	</div>
	
</body>
 <footer>
		<%@include file="inc/footer1.jsp" %>
   </footer>
</html>