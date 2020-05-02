<%@include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp"%>
<html:html>
<head>
<meta charset="UTF-8">
<title>Shelter View Event</title>
	


</head>
<body>
<div class="mainbanner"><h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1></div>
	<div class="mainbody">
		
			

			<html:form>
<center>
				<table>

					<tr>
						<c:forEach var="i" begin="${ShelterEventFormBean.begin}"
							end="${ShelterEventFormBean.end}">
							<tr>
								<td cellspacing="1000"><html:img
										src="${ShelterEventFormBean.eventViewFile[i-1]}" height="200"
										width="300" /></td>
								<td width="30"></td>
								<td>${ShelterEventFormBean.shelterEventList[i-1].event.eventText}</td>
							</tr>
							<tr>
								<td>Posted in:
									&nbsp;&nbsp;${ShelterEventFormBean.shelterEventList[i-1].event.eventDate}</td>
							</tr>
							<tr>
								<td height="70"></td>
							</tr>
						</c:forEach>
					</tr>

				</table>

				<!--  for btn -->

				<table>
					<tr>
						<td><c:if test="${ShelterEventFormBean.prevBtn}">
								<html:submit property="prev" value="Previous"
									styleId="buttonwto">
								</html:submit>
							</c:if></td>
						<td><c:if test="${ShelterEventFormBean.nextBtn}">
								<html:submit property="next" value="Next" styleId="buttonwto">
								</html:submit>
							</c:if></td>
					</tr>
				</table>









</center>
			</html:form>
		</div>
	
	<footer><%@ include file="inc/footer1.jsp"%></footer>
</body>
</html:html>