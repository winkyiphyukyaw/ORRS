<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>
<title>City Add Page</title>


</head>
<body onload="DWRUtil.useLoadingMessage();">
	<div class="mainbanner">
		<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
	</div>

	<div class="mainbody" >
		
		
		<!-- For View -->
			
						<html:form action="LocationPagingPath">
						<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Region & State List</h2>
						<center>
							<logic:notEmpty property="frmRegionList" name="AdminLocationFormBean">
							<center>
								<table class="body" align="center" border="1" bordercolor="#086A87">
									<tr height="40" >
									    <th align="center" width="50px">No.</th>
										<th align="center" width="220px">Region\State</th>
										<th align="center" width="130px">Add City Link</th>
										
									</tr>
									<c:forEach var="i" begin="${AdminLocationFormBean.begin}" end="${AdminLocationFormBean.end}">
											<tr height="40">
											<td align="center">${i}</td>
											<td>${AdminLocationFormBean.frmRegionList[i-1].name}</td>
											<td align="center">
											<a
												href="LocationDetailPath.do?frmCitybyRegionId=${AdminLocationFormBean.frmRegionList[i-1].id}&frmControl=2"><span style="color:blue;">Add City</span></a>
											</td>
										</tr>
									</c:forEach>
								</table>
</center>
			<!-- next and previous button control here -->
			<br>
				<table align="center" width="30%">
					<tr>
						<td width="10%">
						
						<c:if test="${AdminLocationFormBean.prevBtn}">
                            <html:submit property="prev" value="&nbsp;Previous&nbsp;" styleId="buttonwto">
							</html:submit>
						</c:if>
						
						</td>
						<td width="80%"></td>
						<td width="10%">
						
						<c:if test="${AdminLocationFormBean.nextBtn}">
							<html:submit property="next" value="&nbsp;&nbsp;Next&nbsp;&nbsp;" styleId="buttonwto">
							</html:submit>
              			</c:if>
              			
						</td>
					</tr>
					<html:errors property="LocError" />
				</table>

							</logic:notEmpty>
							<%-- <table>
							<tr><td align="center"><html:submit property="btnHome" value="&nbsp;&nbsp;Home&nbsp;&nbsp;"  styleId="buttonwto"/></td></tr>
							</table> --%>
							</center>
						</html:form>
						
		</div>
	
	<footer>
		<%@include file="inc/footer1.jsp"%>
	</footer>
</body>

</html>