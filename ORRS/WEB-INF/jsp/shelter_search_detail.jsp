<%@include file="inc/common.jsp"%>
<%@include file="inc/banner.jsp"%>
<html:html>
<head>



</head>
<body>
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
					
			<li><div class="dropdown"><a href="userStoryPath.do"><span
					class="glyphicon glyphicon-calendar" aria-hidden="true"></span> Story</a></div></li>
			
			<li><div class="dropdown"><a href="EventPath.do"><span
					class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
					Activity</a></div></li>

			<!-- <li><a href="#"><span class="glyphicon glyphicon-gift"
						aria-hidden="true"></span> Donate</a>
					<ul>
						<li><a href="donorShelterFirstPath.do">Direct to Shelter</a></li>
						<li><a href="donorDirectFirstPath.do">Direct to
								Foundation</a></li>
					</ul></li> -->
			<li><div class="dropdown">
				<a href="#"><span class="glyphicon glyphicon-gift"
						aria-hidden="true"></span>
							Donate</a>
				<div class="dropdown-content">
					<a href="donorShelterFirstPath.do">Donate to Shelter</a> 
					<a href="donorDirectFirstPath.do">Donate to Foundation</a></div></div></li>
					
					
					
					
					<!-- <li><a href="donorShelterFirstPath.do"><span
							class="glyphicon glyphicon-gift" aria-hidden="true"></span>Donate
							to Shelter</a></li>
					<li><a href="donorDirectFirstPath.do"><span
							class="glyphicon glyphicon-gift" aria-hidden="true"></span>Donate
							to Foundation</a></li> -->

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
		<html:form action="/shelterDetailPath">
		<center>
	<div class="divbodyborder">
	<div class="maincontainer">
	
	<h1 align="center"
		style="font-size: 20px; color: #366b82; text-shadow: 0 1px 1px rgba(0,0,0,5);">Search Shelter Detail</h1>
		
			<table align="center" class="table1">
			<tr height="15px"><td colspan="2"><label style="color:blue;">The Fund for  ${DonorRegFormBean.lastcategory } is being less in this shelter</label></td></tr>
				<tr height="40px">
					<td>Shelter Name:</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.shelterName}
					</td>
				</tr>
				<tr height="40px">
					<td>Shelter Principal Name</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.principalName}</td>
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
				
				<%-- <tr>
					<td>Breakfast Price:</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.breakfastPrice}</td>
				</tr>
				<tr>
					<td>Lunch Price:</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.lunchPrice}</td>
				</tr>
				<tr>
					<td>Dinner Price:</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.dinnerPrice}</td>
				</tr> --%>
				<tr height="40px">
					<td>City</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.city.name}</td>
				</tr>
				<tr height="40px">
					<td>Region State</td>
					<!-- <td></td> -->
					<td>${DonorRegFormBean.shelterDetail.city.regionState.name}</td>
				</tr>
				
			</table>
			<table align="center" width="30%">
			<tr>
				<td align="center"><html:submit property="btnBack" value="Back" styleId="buttonwto"></html:submit></td>
					<td align="center"><html:submit property="btnDonate" value="Donate" styleId="buttonwto"></html:submit>
					</td><td align="center"><html:submit property="btnGivingMeal" value="GivingMeal" styleId="buttonwto"></html:submit></td>
					
				</tr>
			</table>
			</div></div></center>
		</html:form>
<footer>
	

		<%@include file="inc/footer.jsp"%></footer>
</body>
</html:html>