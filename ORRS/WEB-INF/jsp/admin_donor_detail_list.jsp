<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>
<title>View Donor List</title>
<%-- <%@include file="inc/admin_sidebar.jsp"%> --%>
<!-- <link href="css/library.css" rel="stylesheet" type="text/css"> -->


</head>
<body>
	<%-- <%@include file="inc/admin_sidebar1.jsp"%> --%>
	<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>


	<div class="mainbody" width="100%" height="auto">
		

			<h2
				style="padding-left: 20px; font-size: 20px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Donor
				Detail</h2>
			<html:form action="/adminDonorDetailPath">

<center>
							<table class="body"  border="1">
								<tr>
									<td colspan="2"><img src="images/give.png"
										style="width:50px; height: 50px;"> <span
										style="color: #366b82; font-size: 18px;">Information
											about Donor</span></td>
								<tr>
									<td align="center"><font color="#086A87"><b>Name</b></font></td>
									<td>
										${AdminDonorFormBean.viewDonorListDetail[0].donor.donorName}</td>
								</tr>
								<tr>
									<td align="center"><font color="#086A87"><b>Phone
												No</b></font></td>
									<td>${AdminDonorFormBean.viewDonorListDetail[0].donor.donorPhNo}</td>
								</tr>
								<tr>
									<td align="center"><font color="#086A87"><b>NRC</b></font></td>
									<td>${AdminDonorFormBean.viewDonorListDetail[0].donor.donorNrc}</td>
								</tr>
								<tr>

									<td align="center"><font color="#086A87"><b>Address</b></font></td>
									<td>
										${AdminDonorFormBean.viewDonorListDetail[0].donor.donorAddress}</td>
								</tr>
								<tr>

									<td align="center"><font color="#086A87"><b>Email</b></font></td>
									<td>
										${AdminDonorFormBean.viewDonorListDetail[0].donor.donorEmail}</td>
								</tr>
								<tr>

									<td align="center"><font color="#086A87"><b>Comment</b></font></td>
									<td>
										${AdminDonorFormBean.viewDonorListDetail[0].donor.comment}</td>
								</tr>

							</table>
							
							</center>
							<center>
							<br>
							<br>
							<table class="body" border="1"
								>
								<tr>
									<td colspan="5"><img src="images/give.png"
										style="width: 50px; height: 50px;"> <span
										style="color: #366b82; font-size: 18px;">Time of Donation for each category</span></td>
								</tr>
								<tr>
									<th width="80" align="center">No.</th>
									<th width="140" align="center">Donate
												Date</th>
									<th width="140" align="center">Donation
												Item</th>
									<th width="140" align="center">Kind
												of donate</th>
									<th width="140" align="center">Amount</th>


								</tr>


								<c:forEach var="i" begin="${AdminDonorFormBean.begin1}"
									end="${AdminDonorFormBean.end1}">
									<tr>
										<td>${i }</td>
										<td>
											${AdminDonorFormBean.viewDonorListDetail[i-1].donateDate}</td>
										<td>
											${AdminDonorFormBean.viewDonorListDetail[i-1].category.type}</td>
										<td><c:if
												test="${AdminDonorFormBean.viewDonorListDetail[i-1].donor.kindOfDonate eq 0}">
							Only Once
							</c:if> <c:if
												test="${AdminDonorFormBean.viewDonorListDetail[i-1].donor.kindOfDonate eq 1}">
							Monthly
							</c:if> <c:if
												test="${AdminDonorFormBean.viewDonorListDetail[i-1].donor.kindOfDonate eq 2}">
							Yearly
							</c:if></td>
										<td>
											${AdminDonorFormBean.viewDonorListDetail[i-1].donor.amount}</td>


									</tr>
								</c:forEach>
							</table>
							<br>
							<table><tr><td><html:submit
											property="btnOk" value="OK"
											styleId="buttonwto"></html:submit>
							</center></td></tr></table>
							
						</html:form>
		</div>




	





	<footer>


		<%@include file="inc/footer1.jsp"%>


	</footer>
</body>
</html>