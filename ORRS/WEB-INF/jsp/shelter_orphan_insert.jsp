<%@ include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp"%>
<html>
<head>
<title>Orphan Insert</title>

<style type="text/css">
.disableClick{
    pointer-events: none;
}
</style>
</head>
<body>
<div class="mainbanner"><h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1></div>
	<div class="mainbody">
		
			
		
			
			<html:form action="/shelterOrphanInsertPath">
			
			<h1
				style="padding-left: 20px; font-size: 20px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Insert New Orphans</h1>
			
				<center>
				<logic:empty property="frmFormControlInsert" name="OrphanFormBean">
					<table>
						<tr height="40">
							<td width="130">Name</td>
							<td width="76%"><html:text property="frmName"  maxlength="30"></html:text> 
							<font color="red">* </font><html:errors property="frmName"/></td>
						</tr>
						
						<tr height="40">
							<td>Age</td>
							<td><html:select property="frmAge">
									<html:option value="0">Select</html:option>
									<html:option value="under 1 year">under 1 year</html:option>
									<html:option value="under 5 years">under 5 years</html:option>
									<html:option value="under 10 years">under 10 years</html:option>
									<html:option value="under 15 years">under 15 years</html:option>
									<html:option value="under 20 years">under 20 years</html:option>
								</html:select> <font color="red">*</font><html:errors property="AgeError" /></td>	
						</tr>

						<tr height="40">
							<td>Education</td>
							<td><html:select property="frmEducation">
									<html:option value="0">Select</html:option>
									<html:option value="None">None</html:option>
									<html:option value="Kindergarten">Kindergarten</html:option>
									<html:option value="Primary School">Primary School</html:option>
									<html:option value="Middle School">Middle School</html:option>
									<html:option value="High School">High School</html:option>
								</html:select> <font color="red">* </font><html:errors property="EducationError" /></td>
						</tr>

						<tr height="40">
							<td>Religion</td>
							<td><html:select property="frmReligion">
									<html:option value="0">Select</html:option>
									<html:option value="None">None</html:option>
									<html:option value="Buddhist">Buddhist</html:option>
									<html:option value="Christian">Christian</html:option>
									<html:option value="Hindu">Hindu</html:option>
									<html:option value="Islam">Islam</html:option>
								</html:select> <font color="red">* </font><html:errors property="ReligionError" /></td>
						</tr>

						<tr height="40">
							<td>Medical Grade</td>
							<td><html:select property="frmMedical">
									<html:option value="0">Select</html:option>
									<html:option value="A">A</html:option>
									<html:option value="B">B</html:option>
									<html:option value="C">C</html:option>
								</html:select> <font color="red">* </font><html:errors property="MedicalError" /></td>
						</tr>

						<tr>
							<td>Gender</td>
							<td><html:radio property="frmGenderType" value="Male">Male</html:radio>
								<html:radio property="frmGenderType" value="Female">Female</html:radio>
								<font color="red">*</font><html:errors property="frmGenderType" /></td>
						</tr>
						
						<tr height="50">
							<td colspan="2" align="center">
							<html:submit property="btnInsert" value="ADD" styleId= "buttonwto"/> 
							<html:cancel value="Clear" styleId= "buttonwto"/></td>
						</tr>
					</table>
				</logic:empty></center>
				<!-- Confirmation -->
				<center>
				<logic:notEmpty property="frmFormControlInsert"
					name="OrphanFormBean">
					<table>
						<tr>
							<td>Name:</td>
							<td><html:text property="frmName" disabled="true">
								</html:text></td>
						</tr>
						<tr>
							<td>Age:</td>
							<td><html:text property="frmAge" disabled="true">
								</html:text></td>
						</tr>
						<tr>
							<td>Education:</td>
							<td><html:text property="frmEducation" disabled="true">
								</html:text></td>
						</tr>
						<tr>
							<td>Religion:</td>
							<td><html:text property="frmReligion" disabled="true">
								</html:text></td>
						</tr>
						<tr>
							<td>Medical Grade:</td>
							<td><html:text property="frmMedical" disabled="true">
								</html:text></td>
						</tr>
						<tr>
							<td>Gender:</td>
							<td><html:text property="frmGenderType" disabled="true">
								</html:text></td>
						</tr>
			
						<tr>
							<td colspan="2" align="center"><html:submit
									property="btnInSave" value="Save" styleId= "buttonwto">
								</html:submit> <html:submit property="btnInSaveCancel" value="Cancel" styleId= "buttonwto">
								</html:submit></td>
						</tr>
					</table>
				</logic:notEmpty></center>
			</html:form>
			<!-- For View -->
			
			<html:form action="pagingPath">
			<center>
				<logic:notEmpty property="frmOrphanList" name="OrphanFormBean">
					<table class="body" border="1">
						<tr height="40">
							<th align="center" width="50px"><center>No</center></th>
							<th align="center" width="160px"><center>Name</center></th>
							<th align="center" width="150px"><center>Age</center></th>
							<th align="center" width="100px"><center>Gender</center></th>
							<th align="center" width="100px"> Detail Link</th>
							<th align="center" width="100px"> Update Link</th>
							
						</tr>
						<c:forEach var="i" begin="${OrphanFormBean.begin}"
							end="${OrphanFormBean.end}">
							<tr height="45" align="center">
								<td align="center">${i}</td>
								<td>${OrphanFormBean.frmOrphanList[i-1].orphanName}</td>
								<td>${OrphanFormBean.frmOrphanList[i-1].orphanAge}</td>
								<td>${OrphanFormBean.frmOrphanList[i-1].orphanGender}</td>
							
								<td><a
									href="shelterOrphanDetail.do?frmDetailOrphanId=${OrphanFormBean.frmOrphanList[i-1].id}&frmControl=4"><font
										color="#086Aee">Detail</font></a></td>
								<td align="center">
								<c:if test="${ OrphanFormBean.frmOrphanList[i-1].adoptStatus==0}">
								<a href="shelterOrphanUpdate.do?frmUpdateOrphanId=${OrphanFormBean.frmOrphanList[i-1].id}&frmControl=3"><font
										color="#086Aee">Update</font></a>
								</c:if>	
								<c:if test="${ OrphanFormBean.frmOrphanList[i-1].adoptStatus==1}">
								<a href="shelterOrphanUpdate.do?frmUpdateOrphanId=${OrphanFormBean.frmOrphanList[i-1].id}&frmControl=3" class="disableClick">
								<font color="#6495ED">Update</font></a>
								</c:if>		
								</td>
							</tr>
						</c:forEach>
					</table>
<br>
					<!-- next and previous button control here -->
					<table width="30%">
						<tr>
							<td width="40%">
								
									<c:if test="${OrphanFormBean.prevBtn}">
                            <html:submit property="prev"
											value="Previous" styleId= "buttonwto">
										</html:submit>
									</c:if>
								
							</td>
							<td width="30%"></td>
							<td width="30%">
								
									<c:if test="${OrphanFormBean.nextBtn}">
										<html:submit property="next" value="Next" styleId= "buttonwto">
										</html:submit>
              			</c:if>
								
							</td>
						</tr>
						<html:errors property="LocError" />
					</table>
				</logic:notEmpty></center>
			</html:form>
			
		</div>
	

	<footer>
		<%@include file="inc/footer1.jsp"%></footer>
</body>
</html>