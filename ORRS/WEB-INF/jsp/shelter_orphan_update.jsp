<%@ include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp"%>
<html>
<head>
<title>Shelter Orphan Update</title>



</head>
<body onload="ShowHideDiv()">
<script>
function ShowHideDiv() {
	var chkn = document.getElementById("chkNotYet");
	var chka = document.getElementById("chkAdopt");
	
	  var dv1 = document.getElementById("txt1");
	    var dv2 = document.getElementById("txt2");
	    var dv3 = document.getElementById("txt3");
	    var dv4 = document.getElementById("txt4");
	    var dv5 = document.getElementById("txt5");
	    var dv6 = document.getElementById("txt6");
   /*  var chkYear = document.getElementById("chkYear");
    var dvMonth = document.getElementById("txtMonth");
    var dvMonth1 = document.getElementById("txtMonth1");
    
    var dvMonth2 = document.getElementById("txtMonth2");
    var dvMonth3 = document.getElementById("txtMonth3");
    var dvYear = document.getElementById("txtYear");
    var dvYear1 = document.getElementById("txtYear1");
    var dvYear2 = document.getElementById("txtYear2");
    var dvYear3 = document.getElementById("txtYear3"); */
    /* document.getElementById("chkOnce").checked==true */
    if(chkAdopt.checked==true)
    	{
    	
    	dv1.style.display= "block";
    	dv2.style.display= "block";
    	
    	dv3.style.display= "block";
    	dv4.style.display= "block";
    	dv5.style.display= "block";
    	dv6.style.display= "block";
    	/* dvMonth3.style.display= "block";
    	
    	   dvYear.style.display="none";
    	   dvYear1.style.display="none";
    	   
    	   dvYear2.style.display="none";
    	   dvYear3.style.display="none"; */
    	}
   
    else if(chkNotYet.checked==true){
    	
    	dv1.style.display= "none";
    	dv2.style.display= "none";
    	
    	dv3.style.display= "none";
    	dv4.style.display= "none";
    	dv5.style.display= "none";
    	dv6.style.display= "none";
    }
    	
        }
       
    
</script>
<div class="mainbanner"><h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1></div>
	<div class="mainbody">
		
			<h1
				style="padding-left: 20px; font-size: 20px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Update
				Orphan</h1>


			<html:form action="/shelterOrphanUpdatePath">
				<center>
					<logic:empty property="frmFormControl" name="OrphanFormBean">
						<table>

							<tr height="40">
								<td width="130">Name</td>
								<td><html:text property="frmName"  maxlength="30"></html:text> <font
									color="red">* </font></td>
									<td><html:errors property="frmName"/></td>
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
									</html:select> <font color="red">*</font></td>
									<td><html:errors property="AgeError" /></td>
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
									</html:select> <font color="red">* </font></td>
									<td><html:errors property="EducationError" /></td>
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
									</html:select> <font color="red">* </font></td>
									<td><html:errors property="ReligionError" /></td>
							</tr>
							
							<tr height="40">
								<td>Medical Grade</td>
								<td><html:select property="frmMedical">
										<html:option value="0">Select</html:option>
										<html:option value="A">A</html:option>
										<html:option value="B">B</html:option>
										<html:option value="C">C</html:option>
									</html:select> <font color="red">* </font></td>
									<td><html:errors property="MedicalError" /></td>
							</tr>
							
							<tr>
								<td>Gender</td>
								<td><html:radio property="frmGenderType" value="Male">Male</html:radio>
									<html:radio property="frmGenderType" value="Female">Female</html:radio>
								</td>
							</tr>
							<tr>
								<td></td>
								<td><html:errors property="frmGenderType" /></td>
							</tr>

							<tr>
								<td>Adopt Status</td>
								<td><html:radio property="frmAdoptType" value="Not Yet" styleId="chkNotYet" onclick="ShowHideDiv()">Not Yet</html:radio>
									<html:radio property="frmAdoptType" value="Adopt" styleId="chkAdopt" onclick="ShowHideDiv()">Adopt</html:radio>
								</td>
							</tr>
						</table>
						
						<table>
						<tr>
						
						<td width="40%" align="right">
						<p id="txt1" style="display: none">
						Adopter NRC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</p>
						</td>
						
						<td width="43%" align="left">
						<p id="txt2" style="display: none">&nbsp;
						<html:text property="frmAdopterNRC"  maxlength="30">
						</html:text><font color="red">&nbsp;*</font>
						</p>
						<font color="green">
						<p id="txt5" style="display: none">&nbsp; ( eg.,12/asn(N)195349 )</p>
						</font>
						</td>
						
						<td>
						<p id="txt3" style="display: none">
						<html:submit property="btnSearch" value="Search" styleId="buttonwto" />
						</p>
						</td>
						
						</tr>
						
						<tr>
						<td colspan="3" align="center">
						<p id="txt6" style="display: none">
						<html:errors property="AdopterNRCError" />
						<html:errors property="AdopNRCError" />
						<html:errors property="AdopNRCError1" /></p>
						</td>
						</tr>
						
						<tr>
						<td colspan="3" align="center">
					<p id="txt4" style="display: none">		
				<logic:notEmpty property="frmAdopterFormControl" name="OrphanFormBean">	
				<table border="1" border=1>											
				<tr>
  				 <td>Adopter Name:</td>
 					  <td>${OrphanFormBean.shelterAdopterList.adopterName}
					</td>
				</tr>		
				<tr>
					<td>Adopter NRC:</td>
					<td>${OrphanFormBean.shelterAdopterList.adopterNrc}
					 </td>
				</tr>
				<tr>
					<td>Adopter Phone Number:</td>
				    <td>${OrphanFormBean.shelterAdopterList.adopterPhNo}
					</td>
				</tr>
				<tr>
					<td>Adopters Address:</td>
					<td>${OrphanFormBean.shelterAdopterList.adopterAddress}
					</td>
				</tr>				    												
				</table>		
				</logic:notEmpty>
				</p>
						</td>
						</tr>
						
						</table>
						<br>
							<center>
							<table><tr></tr><td><html:submit property="btnUpdate" value="Update" styleId="buttonwto" /> 
							<%-- <html:submit property="btnCancel" value="Cancel" styleId="buttonwto" /> --%>
							<html:cancel value="Cancel" styleId= "buttonwto"/></center></td></table>
							
					</logic:empty>
				</center>
				
				
				<!-- Confirmation -->
				<center>
					<logic:notEmpty property="frmFormControl" name="OrphanFormBean">
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
								<td>Adopt Status:</td>
								<td><html:text property="frmAdoptType" disabled="true">
									</html:text></td>
							</tr>
							<tr height="80px">
								<td colspan="2" align="center">
								<html:submit property="btnSave" value="Save" styleId="buttonwto" />
								<html:submit property="btnSaveCancel" value="Cancel" styleId="buttonwto" />
								
								</td>
							</tr>
						</table>
					</logic:notEmpty>
				</center>
			</html:form>
		</div>
	
	<footer>
		<%@include file="inc/footer1.jsp"%>
	</footer>
</body>
</html>