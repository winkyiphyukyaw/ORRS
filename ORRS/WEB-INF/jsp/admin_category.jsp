<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html:html>
<head>
<title>Category List</title>

</head>
<body>
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody" >
		
	
	
	<html:form action="categoryPath">
	<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Insert New Category!</h2>
	<center>
	
	 <logic:empty property="categoryList" name="AdFormBean">
											<table align="center" width="500%">
												<tr>
													<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:text
															property="categoryName"></html:text> <font color="red">*
													</font> <html:errors property="categoryName" /></td>

												</tr>
												<tr height="10px"></tr>
												<tr>
													<td align="center"><html:submit property="btnAdd"
															value="&nbsp;Add  &nbsp;" styleId="buttonwto"></html:submit></td>
												</tr>
												<tr>
													<td align="center"><html:errors
															property="categoryError" /></td>
												</tr>

											</table>
										</logic:empty>
		
		<br>
		<logic:notEmpty property="categoryList" name="AdFormBean">
											<table align="center">
												<tr>

													<td><html:text property="categoryName" disabled="true"></html:text></td>
												</tr>
												<tr>
													<td><html:submit property="btnSave"
															styleId="buttonwto"> &nbsp;Save </html:submit></td>
													<td><html:submit property="btnCancel"
															styleId="buttonwto">&nbsp;Cancel &nbsp;</html:submit></td>
												</tr>
											</table>
										</logic:notEmpty>
		</html:form>
		
		<%-- <logic:notEmpty property="categoryList" name="AdFormBean"> --%>
	<html:form method="POST" action="pagingCategoryPath"> 
			<%-- <logic:notEmpty property="addCategoryList" name="AdFormBean"> --%>
			
			<h3 style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);" align="center">Category List..</h3>
		
		<br></br>

										<table class="body" border="1" width="40%" align="center" bordercolor="#086A87">

											<tr height="40px" align="center">
												<!-- <th width="10">No.</th>
												<th width="15">Category</th> -->
												<th align="center">No.</th>
							<th align="center" width="150px">Category</th>
							<th align="center" width="150px"> Update Link</th>
							
											</tr>
											<c:forEach var="i" begin="${AdFormBean.begin}"
												end="${AdFormBean.end}">

												<tr 40px>
													<td align="center">${i}</td>
													<td>${AdFormBean.addCategoryList[i-1].type}</td>

													<td align="center"><a
														href="updateCategoryPathFirst.do?
								updateCatId=${AdFormBean.addCategoryList[i-1].id}&updateCategoryControl=2"><span style="color:blue;">
															Update</span></a></td>
												</tr>
											</c:forEach>
										</table>

<br>
										<table align="center"  width="40%">
											<tr>
												<td width="95%"><c:if test="${AdFormBean.prevBtn}">
														<html:submit property="prev" value="&nbsp;Previous&nbsp;"
															styleId="buttonwto">
														</html:submit>
													</c:if></td>
												<td width="5%" float="right"><c:if test="${AdFormBean.nextBtn}">
														<html:submit property="next"
															value="&nbsp;&nbsp;Next&nbsp; &nbsp;" styleId="buttonwto">
														</html:submit>
													</c:if></td>
											</tr>
										</table>

</center>
									</html:form>

		
		
		</div>
		
	
	<footer>	
		<%@include file="inc/footer1.jsp" %>
   </footer>
   	
	
</body>
</html:html>



