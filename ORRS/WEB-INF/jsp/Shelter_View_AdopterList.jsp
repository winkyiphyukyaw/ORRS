<%@ include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp" %>
<html>

<head>

<!-- <meta charset="utf-8" /> -->
<title>Adopter List</title>


</head>
<body>
	<div class="mainbanner"><h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1></div>
	<div class="mainbody">
		
			
	


		
			
			<html:form action="/shelterAdopterPath">
			<center>
			<h1
				style="padding-left: 20px; font-size: 20px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Adopter List</h1>
					<logic:notEmpty property="frmAdopterList"
						name="ShelterSearchAdopterFormBean">
						<center>
						<table class="body" border="1">
							<tr>
								<th>No</th>
								<th>Adopter Name</th>
								<th>Email</th>
								<th>Ph no</th>
								<th> Detail Link</th>
							</tr>
							<c:forEach var="i" begin="${ShelterSearchAdopterFormBean.begin}"
								end="${ShelterSearchAdopterFormBean.end}">
								<tr>
									<td>${i}</td>
									<td>
										${ShelterSearchAdopterFormBean.frmAdopterList[i-1].adopterName}</td>
									<td>
										${ShelterSearchAdopterFormBean.frmAdopterList[i-1].adopterEmail}</td>

									<td>
										${ShelterSearchAdopterFormBean.frmAdopterList[i-1].adopterPhNo}</td>
										
									<td align="center"><a
										href="shelterAdopterDetailPath.do?
								frmDetailAdopterId=${ShelterSearchAdopterFormBean.frmAdopterList[i-1].id}&frmControl=2">
											<font color="blue">Detail</font></a></td>
								</tr>


								<!-- <script type="text/javascript">
				//
				if(${ShelterSearchAdopterFormBean.frmAdopterList[i-1].adoptedChildNo} > 0)
					document.getElementById()(${ShelterSearchAdopterFormBean.frmAdopterList[i-1].adoptedChildNo})
				</script> -->
							</c:forEach>



						</table>

</center>


						<!-- next and previous button control here -->
						<table align="center">
							<tr>
								<td>
									<div align="center">
										<c:if test="${ShelterSearchAdopterFormBean.prevBtn}">&lt;&lt;
                                   <html:submit property="prev" styleId="buttonwto"
												value="Previous">
											</html:submit>
										</c:if>
									</div>
								</td>
								<td>
									<div align="center">
										<c:if test="${ShelterSearchAdopterFormBean.nextBtn}">
											<html:submit property="next"  styleId="buttonwto" value="Next">
											</html:submit>&gt;&gt;
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
	<%@include file="inc/footer1.jsp" %></footer>
</body>
</html>