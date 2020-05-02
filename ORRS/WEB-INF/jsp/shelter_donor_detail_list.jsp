<%@ include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp"%>
<html>
<head>
<title>View Donor List</title>


	
</head>
<body>
<div class="mainbanner"><h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1></div>
	<div class="mainbody">
		
			<h1
				style="padding-left: 20px; font-size: 20px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Donor Detail
				List</h1>

			
		<html:form action="/shelterDonorListDetailPath">
		<center>
			<table  class="body" border="1">
				<tr>
									<td colspan="2"><img src="images/give.png"
										style="width:50px; height: 50px;"> <span
										style="color: #366b82; font-size: 18px;">Information
											about Donor</span></td>
								<tr>
				<tr>
					<td>Name</td>
					<td>${ShelterDonorFormBean1.viewDonorListDetail[0].donor.donorName}
					</td>
				</tr>
				<tr>
					<td>Phone No:</td>
					<td>${ShelterDonorFormBean1.viewDonorListDetail[0].donor.donorPhNo}</td>
				</tr>
				<tr>
					<td>NRC</td>
					<td>${ShelterDonorFormBean1.viewDonorListDetail[0].donor.donorNrc}
					</td>
				</tr>
				<tr>
					<td>Address</td>
					<td>
					${ShelterDonorFormBean1.viewDonorListDetail[0].donor.donorAddress}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>
					${ShelterDonorFormBean1.viewDonorListDetail[0].donor.donorEmail}</td>
				</tr>
				<tr>
					<td>Comment</td>
					<td>
					${ShelterDonorFormBean1.viewDonorListDetail[0].donor.comment}</td>
				</tr>
			</table>
			</center>
			<br></br>
			
			<center>
			<table class="body" border="1">
		<tr>
									<td colspan="5"><img src="images/give.png"
										style="width: 50px; height: 50px;"> <span
										style="color: #366b82; font-size: 18px;">Donation Lists for each category</span></td>
								</tr>
						
		<tr height="40">
									<th width="80" align="center"><b>No.</b></th>
									<!-- <th width="100" align="center"><b>Name</b></th> -->
									<th width="140" align="center"><b>Donate Date</b></th>
									<th width="140" align="center"><b>Kind of donate</b></th>			
									<th width="140" align="center"><b>Donation Item</b></th>
									<th width="140" align="center"><b>Amount</b></th>			
								
								</tr>
								<c:forEach var="i" begin="${ShelterDonorFormBean1.begin}"
									end="${ShelterDonorFormBean1.end}">
									<tr>
										<td>${i}</td>
										<%-- <td>
											${ShelterDonorFormBean1.viewDonorListDetail[i-1].donor.donorName}</td> --%>
											<td>
											${ShelterDonorFormBean1.viewDonorListDetail[i-1].donateDate}</td>
										<td><c:if
												test="${ShelterDonorFormBean1.viewDonorListDetail[i-1].donor.kindOfDonate eq 0}">
							Only Once
							</c:if> <c:if
												test="${ShelterDonorFormBean1.viewDonorListDetail[i-1].donor.kindOfDonate eq 1}">
							Monthly
							</c:if> <c:if
												test="${ShelterDonorFormBean1.viewDonorListDetail[i-1].donor.kindOfDonate eq 2}">
							Yearly
							</c:if></td>
										
										<td>
											${ShelterDonorFormBean1.viewDonorListDetail[i-1].category.type}</td>
											<td>
											${ShelterDonorFormBean1.viewDonorListDetail[i-1].donor.amount}</td>
											
									
									</tr>
								</c:forEach>
								
						
			</table>
			<br>
			<html:submit property="btnOk"
						value="OK" styleId="buttonwto"></html:submit>
			</center>
		</html:form>

		</div>
	
	<footer>
		<%@ include file="inc/footer1.jsp"%></footer>
</body>
</html>