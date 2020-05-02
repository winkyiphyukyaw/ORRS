<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>

<head>

<!-- <meta charset="utf-8" /> -->
<title>Shelter List</title>
<script type="text/javascript">


	function sendRegiontoCity(regionId) {
		AjaxSearch.getCityByRegion(regionId,callbackCityRegion);
	}
	function callbackCityRegion(message) {		
		dwr.util.removeAllOptions("citylist");
		dwr.util.addOptions("citylist", message, "id", "name");
	}
	
	function sendRegiontoShelter(regionId) {
		AjaxSearch.getShelterByRegion(regionId, callbackShelterRegion);
	}
	function callbackShelterRegion(message1) {		
		dwr.util.removeAllOptions("shelterlist"); 
		dwr.util.addOptions("shelterlist", message1, "id", "shelterName");
	}
	
	function sendCity(cityId,regionId) {
		AjaxSearch.getShelterByCity(cityId,regionId, callbackCity);
	}
	function callbackCity(message1) {
		dwr.util.removeAllOptions("shelterlist");
		dwr.util.addOptions("shelterlist", message1, "id", "shelterName");
	}

</script>
<script type="text/javascript" src="js/prototype.js"></script>
	<script type="text/javascript" src="js/effects.js"></script>
	<script type="text/javascript" src="js/controls.js"></script>
	<script type="text/javascript" src="js/scriptaculous.js"></script>
	<script type='text/javascript' src="js/autocompleteex.js"></script>
	<!-- Declare the javascript for DWR -->
	<script src='dwr/engine.js'></script>
	<script src='dwr/util.js'></script>
	<!-- Do the javascript function for auto complement -->
	<script src='dwr/interface/AjaxSearch.js'></script>
<%-- <%@include file="inc/admin_sidebar.jsp" %> --%>




</head>
<body onload="DWRUtil.useLoadingMessage();">
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody" >
		
	
	
		
		
	<html:form action="/adminViewShelterPath">
	<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Shelter List</h2>
	 <center>
		<table align="center" width="85%">
			<tr><td width="30%" align="center">
				Region
				<html:select property="frmRegionId" styleId="regionlist" onchange="sendRegiontoCity(this[this.selectedIndex].value);sendRegiontoShelter(this[this.selectedIndex].value);">
				<%-- onchange="sendRegion(this[this.selectedIndex].value);sendCity(1);"> --%>
				
					<html:option value="0">All</html:option>
					<html:optionsCollection property="regionChoice" label="name" value="id" />
				</html:select>
				</td>
				<td width="30%" align="center">
				City
				<html:select property="frmCityId" styleId="citylist"
				onchange="sendCity(this[this.selectedIndex].value,regionlist[regionlist.selectedIndex].value)">
					<html:option value="0">All</html:option>
					<logic:notEmpty property="frmCityList" name="DonorRegFormBean">
						<html:optionsCollection property="frmCityList" label="name" value="id"/>
					</logic:notEmpty>
				</html:select>
				</td>
				<td width="50%" align="center">
				Shelter's Name
				<html:select property="frmShelterId" styleId="shelterlist"  >
					<html:option value="0" >All</html:option>
					<logic:notEmpty property="frmShelterList" name="DonorRegFormBean">
						<html:optionsCollection property="frmShelterList" label="shelterName" value="id" />
					</logic:notEmpty>
				</html:select>
				</td>
				<td>
					<html:submit property="btnSearch" value="&nbsp;&nbsp;Search&nbsp;&nbsp;" styleId= "buttonwto"></html:submit>
				</tr>
		</table>
		<hr>
		
		<p>
		<logic:notEmpty property="frmShelterList1" name="DonorRegFormBean">
			<table class="body" align="center" border="1" width="85%" bordercolor="#086A87">
					<tr>
						
						
							<th align="center" >No</th>
							<th align="center" >Shelter Name</th>
							<th align="center" >Shelter Location</th>
							
							<th> Detail Link</th>
					</tr>
					<%-- i starts 1  --%><c:forEach var="i" begin="${DonorRegFormBean.begin}" end="${DonorRegFormBean.end}">
					<tr>
							<td>${i}</td>
							<td>
							${DonorRegFormBean.frmShelterList1[i-1].shelterName}</td>
							<td>
							${DonorRegFormBean.frmShelterList1[i-1].shelterLocation}</td>
							<td align="center"><a
								href="adminViewShelterDetailPath.do?
								frmDetailShelterId=${DonorRegFormBean.frmShelterList1[i-1].id}&frmControl=2">
							<span style="color:blue">Detail</span></a></td>
						</tr>
					</c:forEach>
			</table>
			
			<br>
				<!-- next and previous button control here -->
				<table align="center" width="75%">
					<tr>
						<td width="8%">
						<div align="center">
						<c:if test="${DonorRegFormBean.prevBtn}">
                                   <html:submit property="prev"
								value="&nbsp;Previous&nbsp;" styleId= "buttonwto">
							</html:submit>
						</c:if></div>
						</td>
						<td width="90%"></td>
						<td width="2%">
						<div align="center">
						<c:if test="${DonorRegFormBean.nextBtn}">
							<html:submit property="next" value=" &nbsp;&nbsp;Next&nbsp;&nbsp;" styleId= "buttonwto">
							</html:submit>
              			</c:if>
              			</div>
						</td>
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