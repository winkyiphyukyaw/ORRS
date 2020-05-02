<%@include file="inc/common.jsp"%>
<%@include file="inc/banner.jsp"%>
<html:html>
	<head>
		<title>Search Shelter</title>
<script type="text/javascript">

$(document).ready(function(){
	$('li').removeClass("active");
$("#shelter").addClass("active");

});
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

<!-- <style>
#table1.td, #table.th {    
    border: 1px solid #ddd;
    
}

#table1 {
    border-collapse: collapse;
}

th, td {

    padding: 5px;
}
tr:nth-child(even){background-color: #f2f2f2}
</style> -->

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
	<script src='dwr/interface/AjaxSearch.js'></script>
	<!-- <style>
	table.body {
	align: center;
	border:2px solid #086A87;
	/* min-width:400px; */	
}
table {
	align: center;
	width:100%;
}

th,td {
	padding: 5px;
}

table.body tr:nth-child(even) {
	background-color: #bab9ae;
}

#buttonwto {
	background-color: white;
	color: black;
	border: 2px solid #086A87;
	width: 100px;
}
   
	
	</style> -->
</head>
	<!-- <body onload="DWRUtil.useLoadingMessage();createAutoCompleter()"> -->
	<body onload="DWRUtil.useLoadingMessage();">
	
	<div class="userlogo">
		<h1 align="center"
		style="font-size: 30px; color: #366b82; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
</div>

	<div id="wrap">
		<ul class="navbar">
			<li><div class="dropdown"><a href="Welcome.do"><span
					class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</span></a></div></li>

			<li class="active"><div class="dropdown"><a href="shelterPath.do?frmControl=1"><span
					class="glyphicon glyphicon-road" aria-hidden="true"></span> Shelter</a></div></li>
			<li ><div class="dropdown"><a href="userStoryPath.do"><span
					class="glyphicon glyphicon-calendar" aria-hidden="true"></span> Story</a></div></li>
			
			
			<li><div class="dropdown"><a href="EventPath.do"><span
					class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
					Activity</a></div></li>

		
			<li><div class="dropdown">
				<a href="#"><span class="glyphicon glyphicon-gift"
						aria-hidden="true"></span>Donate</a>
				<div class="dropdown-content">
					<a href="donorShelterFirstPath.do">Donate to Shelter</a> 
					<a href="donorDirectFirstPath.do">Donate to Foundation</a></div></div></li>
					
					<li><div class="dropdown"><a href="givingMealFirstPath.do"><span
							class="glyphicon glyphicon-glass" aria-hidden="true"></span>
							Giving Meal</a></div></li>
					<li><div class="dropdown"><a href="adopterFirstPath.do"><span
							class="glyphicon glyphicon-heart" aria-hidden="true"></span>
							Adopt</a></div></li>
					<li><div class="dropdown"><a href="AboutPath.do"><span
							class="glyphicon glyphicon-user" aria-hidden="true"></span> About</a></div>

					</li>
					<li><div class="dropdown"><a href="ContactPath.do"><span
							class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
							Contact</a></div></li>
					<li><div class="dropdown"><a href="annualReportPath.do"><span
							class="glyphicon glyphicon-book" aria-hidden="true"></span>
							Annual Report</a></div></li>
		</ul>

	</div>
	<div class="clearfix"></div>
	<html:form action="/shelterPath">
	<center>
	<div class="divbodyborder">
	<div class="maincontainer">
	
	<h1 align="center"
		style="font-size: 20px; color: #366b82; text-shadow: 0 1px 1px rgba(0,0,0,5);">Search Shelter</h1>
		<table>
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
				<td width="35%" align="center">
				Shelter's Name
				<html:select property="frmShelterId" styleId="shelterlist">
					<html:option value="0">All</html:option>
					<logic:notEmpty property="frmShelterList" name="DonorRegFormBean">
						<html:optionsCollection property="frmShelterList" label="shelterName" value="id"/>
					</logic:notEmpty>
				</html:select>
				</td>
				<td>
					<html:submit property="btnSearch" value="Search" styleId="buttonwto"></html:submit>
				</tr>
		</table>
		
		<br>
		<logic:notEmpty property="frmShelterList1" name="DonorRegFormBean">
		<center>
			<table class="body" >
					<tr>
						<th align="center" >No.</th>
						<th align="center" >Shelter Name</th>
						<th align="center">Shelter Location</th>
						<th align="center" >Detail Link</th>
					</tr>
					<%-- i starts 1  --%><c:forEach var="i" begin="${DonorRegFormBean.begin}" end="${DonorRegFormBean.end}">
					<tr>
							<td align="center">${i}</td>
							<td>
							${DonorRegFormBean.frmShelterList1[i-1].shelterName}</td>
							<td>
							${DonorRegFormBean.frmShelterList1[i-1].shelterLocation}</td>
							<td align="center"><a
								href="shelterDetailPath.do?
								frmDetailShelterId=${DonorRegFormBean.frmShelterList1[i-1].id}&frmControl=2">
							<span style="color:blue; text-decoration:bold">Detail</span></a></td>
						</tr>
					</c:forEach>
			</table>
			<br>
				<!-- next and previous button control here -->
				<table width="50%">
					<tr>
					<td width="10%"></td>
						<td width="30%">
						
						<c:if test="${DonorRegFormBean.prevBtn}">
                                   <html:submit property="prev"
								value="Previous" styleId="buttonwto">
							</html:submit>
						</c:if>
						</td>
						<td width="40%"></td>
						<td width="30%">
						
						<c:if test="${DonorRegFormBean.nextBtn}">
							<html:submit property="next" value="Next" styleId="buttonwto">
							</html:submit>
              			</c:if>
              			
						</td>
					</tr>
				</table>
				</center>
				
			</logic:notEmpty>
			</div>
			</div>
		</center>
		</html:form>
		
		
		
		<footer>
	

		<%@include file="inc/footer.jsp"%></footer>
	</body>
</html:html>