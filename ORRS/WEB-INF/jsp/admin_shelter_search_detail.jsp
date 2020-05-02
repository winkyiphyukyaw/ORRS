<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>

<head>

<!-- <meta charset="utf-8" /> -->
<title>Adopter View</title>
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
<body>
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody">
		
	
	
	
	<html:form action="/adminViewShelterDetailPath">
	<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Shelter Detail</h2>
	<center>
			<table align="center" border="3" bordercolor=#086A87>
			
				<tr height="40px">
					<td>Region State</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.city.regionState.name}</td>
				</tr>
				<tr height="40px">
					<td>city</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.city.name}</td>
				</tr >
				<tr height="40px">
					<td>Shelter Name:</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.shelterName}
					</td>
				</tr>
				<tr height="40px">
					<td>Shelter Location:</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.shelterLocation}</td>
				</tr>
				<tr height="40px">
					<td>Shelter Phone Number:</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.shelterPhNo}</td>
				</tr>
				<tr height="40px">
					<td>Shelter Email:</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.shelterEmail}</td>
				</tr>
				<tr height="40px">
					<td>Shelter Principal Name</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.principalName}</td>
				</tr>
				<tr height="40px">
					<td>Breakfast Cost:</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.breakfastPrice}</td>
				</tr>
				<tr height="40px">
					<td>Lunch Cost:</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.lunchPrice}</td>
				</tr>
				<tr height="40px">
					<td>Dinner Cost:</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.dinnerPrice}</td>
				</tr>
				
				
			</table>
			<table><tr>
			
				<td align="center" colspan="2"><html:submit property="btnBack" value="&nbsp;&nbsp;Back&nbsp;&nbsp;" styleId= "buttonwto"></html:submit></td>
					
				</tr></table>
				</center>
		</html:form>
			
		
		</div>
		
	<footer>	
		<%@include file="inc/footer1.jsp" %>
   </footer>
</body>
</html>