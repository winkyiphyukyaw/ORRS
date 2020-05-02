<%@include file="inc/common.jsp"%>
<%@include file="inc/banner.jsp"%>
<html>
<head>
<%@ include file="inc/calendar.jsp"%>
<title>Adopter Registration</title>
<!-- <link href="css/library.css" rel="stylesheet" type="text/css"> -->
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
<!-- Declare the javascript for scriptaculous -->
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

<script>
function myFunction() {
    alert("Application have been accepted!We will send email to you.");
}
</script>
</head>
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

			<li><div class="dropdown"><a href="shelterPath.do?frmControl=1"><span
					class="glyphicon glyphicon-road" aria-hidden="true"></span> Shelter</a></div></li>
					
			<li><div class="dropdown"><a href="userStoryPath.do"><span
					class="glyphicon glyphicon-calendar" aria-hidden="true"></span> Story</a></div></li>

			<li><div class="dropdown"><a href="EventPath.do"><span
					class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
					Activity</a></div></li>


			<li><div class="dropdown">
					<a href="#"><span class="glyphicon glyphicon-gift"
						aria-hidden="true"></span>
							Donate</a>
					<div class="dropdown-content">
						<a href="donorShelterFirstPath.do">Donate to Shelter</a> <a
							href="donorDirectFirstPath.do">Donate to Foundation</a>
					</div>
				</div></li>
			<li><div class="dropdown"><a href="givingMealFirstPath.do"><span
					class="glyphicon glyphicon-glass" aria-hidden="true"></span> Giving
					Meal</a></div></li>
			<li class="active"><div class="dropdown"><a href="adopterFirstPath.do"><span
					class="glyphicon glyphicon-heart" aria-hidden="true"></span> Adopt</a></div></li>
			<li><div class="dropdown"><a href="AboutPath.do"><span
					class="glyphicon glyphicon-user" aria-hidden="true"></span> About</a></div></li>
			<li><div class="dropdown"><a href="ContactPath.do"><span
					class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					Contact</a></div></li>
			<li><div class="dropdown"><a href="annualReportPath.do"><span
					class="glyphicon glyphicon-book" aria-hidden="true"></span> Annual
					Report</a></div></li>
		</ul>

	</div>
	
	<html:form action="/adopterRegPath" enctype="multipart/form-data">
	<center>
			<div class="divbodyborder">
<div class="maincontainer">
<h1 align="center"
		style="font-size: 20px; color: #366b82; text-shadow: 0 1px 1px rgba(0,0,0,5);">Adopt(ORRS)</h1>
		<logic:empty property="frmRegFormControl" name="AdopterFormBean">
			
			<table align="center" border="0">
			<tr><td colspan="2"><img src="images/personalProfile.png" style="width:30px;height:30px;">
					<span style="color:#366b82;font-size:18px;">Please,Fill Your Personal Info</span></td></tr>
				<tr>
					<td>Name</td>
					<td><html:text property="frmAdopterName" maxlength="25"></html:text> <font color="red">***</font></td>
						<td width="250"><html:errors property="frmAdopterName" /></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>Date of Birth</td>
					<td><html:text property="frmAdopterDob" styleId="calendar"
							maxlength="15" size="9" readonly="true"/> <html:image
							src="images/calendar.gif" styleId="trigger"
							style="cursor: pointer; border: 1px solid red;"
							title="Date selector" onmouseover="this.style.background='red';"
							onmouseout="this.style.background=''"></html:image> <font
						face="Verdana" size="2" color="blue">&nbsp;YYYY-MM-DD</font> <script
							type="text/javascript">
							//         
							Calendar.setup({
								firstDay : 1,
								electric : false,
								singleClick : true,
								inputField : "calendar",
								button : "trigger",
								ifFormat : "%Y-%m-%d",
								daFormat : "%Y-%m-%d"
							});
							//
						</script><font color="red">***</font>&nbsp&nbsp&nbsp&nbsp</td>
						<!-- <td width="50px"></td> -->
						<td class="err"><html:errors property="frmAdopterDob"/>
						<html:errors property="dobError" />
						</td>
				</tr>
				<tr height="10px"></tr>
					<tr><td>NRC CardNo.</td>
					<td><html:text property="frmAdopterNrc" maxlength="30"></html:text> <font
						color="red">*** </font></td>
<!-- 						<td width="50px"></td>
 -->						<td><html:errors property="frmAdopterNrc"/>
					</td>
				</tr>
				<tr><td></td><td><font color="green">
								(eg.,xx/XxXxXx(N)xxxxxx)
							</font></td></tr>
				<tr height="10px"></tr>
				<tr>
					<td>Gender</td>
					<td><html:radio property="frmAdopterGender" value="0">Male</html:radio>
					
					<html:radio property="frmAdopterGender" value="1">Female</html:radio>
					<font color="red">***</font></td>
<!-- 					<td width="50px"></td>
 -->					<td><html:errors property="frmAdopterGender" /></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>Marital Status</td>
					<td><html:radio property="frmAdopterMaritalStatus" value="0">Single</html:radio>
				
					<html:radio property="frmAdopterMaritalStatus" value="1">Married</html:radio>
						<font color="red">***</font></td>
<!-- 						<td width="50px"></td>
 -->						<td><html:errors property="frmAdopterMaritalStatus" /></td>
				</tr>
				<tr height="10px"></tr>
				<!-- for Dob field -->
				<tr>
					<td>No. of Biological Child</td>
					<td><html:text property="frmAdopterChildNo" maxlength="10"></html:text> <font
						color="red">***</font></td>
<!-- 						<td width="50px"></td>
 -->						<td><html:errors property="frmAdopterChildNo" />
						</td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>Family's Information Form</td>

					<td><html:file property="frmFileUpload"/>
					</td>
<!-- 					<td width="50px"></td>
 -->					<td> <html:errors property="frmFileUpload" /></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>Occupation</td>
					<td><html:text property="frmAdopterOccupation" maxlength="25"></html:text>
					 <font color="red">***</font> </td>
<!-- 					 <td width="50px"></td>
 -->					 <td>
					 <html:errors property="frmAdopterOccupation" /></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>Income</td>
					<td><html:text property="frmAdopterIncome" maxlength="18" ></html:text> <font
						color="red">***</font></td> 
<!-- 						<td width="50px"></td>
 -->						<td><html:errors property="frmAdopterIncome"/>
					</td>
				</tr>
				
				
				<tr height="10px"></tr>
				<tr>
					<td>Email</td>
					<td><html:text property="frmAdopterEmail" maxlength="35"></html:text> <font
						color="red">***</font></td>
<!-- 						<td width="50px"></td>
 -->						<td> <html:errors property="frmAdopterEmail" />
					</td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>Phone.no</td>
					<td><html:text property="frmAdopterPhone" maxlength="14"></html:text> <font
						color="red">*** </font></td>
<!-- 					<td width="50px"></td>
 -->					<td><html:errors property="frmAdopterPhone" /></td>
					
				</tr>
				
				
				
				<tr height="10px"></tr>
				<tr>
					<td>Address</td>
					<td><html:textarea property="frmAdopterAddress"></html:textarea>
						<font color="red">***</font></td>
<!-- 						<td width="50px"></td>
 -->						 <td><html:errors
								property="frmAdopterAddress" />
					</td>
				</tr>
		
				
				<tr height="15px"></tr>
				<tr>
				
				
					<td colspan="2">
				
						
						<img src="images/give.png" style="width:30px;height:30px;">
						<span style="color:#366b82;font-size:18px;">
						Info about the Orphan You want to Adopt</span></td></tr>
					
				
				<tr height="10px"></tr>
				<tr><td>Region</td>
				<td>
				<html:select property="frmRegionId" styleId="regionlist" onchange="sendRegiontoCity(this[this.selectedIndex].value);sendRegiontoShelter(this[this.selectedIndex].value);">
				<%-- onchange="sendRegion(this[this.selectedIndex].value);sendCity(1);"> --%>
				
					<html:option value="0">All</html:option>
					<html:optionsCollection property="regionChoice" label="name" value="id" />
				</html:select>
				</td></tr>
				<tr height="10px"></tr>
				<tr>
				<td>City</td>
				<td>
				<html:select property="frmCityId" styleId="citylist"
				onchange="sendCity(this[this.selectedIndex].value,regionlist[regionlist.selectedIndex].value)">
					<html:option value="0">All</html:option>
					<logic:notEmpty property="frmCityList" name="AdopterFormBean">
						<html:optionsCollection property="frmCityList" label="name" value="id"/>
					</logic:notEmpty>
				</html:select>
				</td></tr>
				<tr height="10px"></tr>
				<tr><td>
				Shelter's Name</td>
				<td><html:select property="frmShelterId" styleId="shelterlist">
				
					<html:option value="0">All</html:option>
					<logic:notEmpty property="frmShelterList" name="AdopterFormBean">
						<html:optionsCollection property="frmShelterList" label="shelterName" value="id"/>
					</logic:notEmpty>
				</html:select>
				</td></tr>

				
				<tr height="10px"></tr>	
				<tr>
					<td>Orphan Gender:</td>
					<td><html:radio property="frmOrphanGender" value="0">Male</html:radio>
					
					<html:radio property="frmOrphanGender" value="1">Female</html:radio>
						<font color="red">***</font></td>
						<!-- <td width="50px"></td> --><td>
						<html:errors property="frmOrphanGender" /></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>Orphan Age:</td>
					<td><html:select property="frmOrphanAge">
					<html:option value="0">Under 1 year</html:option>
					<html:option value="1">Under 5 years</html:option>
					<html:option value="2">Under 10 years</html:option>
					<html:option value="3">Under 15 years</html:option>
					
					</html:select></td>
				</tr>
				<tr height="10px"></tr>
				<tr><td colspan="4"><span style="color:#366b82;font-size:18px;">If you have ever adopted someone or more,
				please fill the number of the Adopted Child!</span></td></tr>
				<tr height="10px"></tr>
				<tr>
					<td>Adopted Child No:</td>
					<td><html:text property="frmAdoptedChildNo"></html:text> <font
						color="red">***</font></td>
						<!-- <td width="50px"></td> -->
					<td><html:errors property="frmAdoptedChildNo"/>
					</td>
				</tr>
				<tr height="10px"></tr>

		
			<tr>
					<td colspan="4" align="center"><html:submit
							property="btnRegister" value="Register" styleId="buttonwto"></html:submit> <html:cancel
							value="Cancel" styleId="buttonwto"></html:cancel> <%-- <html:submit property="btnRegisterCancel" value="Cancel"></html:submit>  --%>
				</tr>
			</table>
		</logic:empty>


		<logic:notEmpty property="frmRegFormControl" name="AdopterFormBean">
			<table align="center">
			<tr><td colspan="2"><img src="images/personalProfile.png" style="width:30px;height:30px;">
					<span style="color:#366b82;font-size:18px;">Your Personal Info</span></td></tr>
				<tr>
					<td>Name:</td>
					<td><html:text property="frmAdopterName" disabled="true"></html:text>
					</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><html:text property="frmAdopterEmail" disabled="true"></html:text></td>
				</tr>
				<tr>
					<td>Phone.no:</td>
					<td><html:text property="frmAdopterPhone" disabled="true"></html:text>
					</td>
				</tr>

				<tr>
					<td>NRC CardNo:</td>
					<td><html:text property="frmAdopterNrc" disabled="true"></html:text></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><html:text property="frmAdopterAddress" disabled="true"></html:text>
					</td>
				</tr>
				<tr>
					<td>Occupation:</td>
					<td><html:text property="frmAdopterOccupation" disabled="true"></html:text>
					</td>
				</tr>
				<tr>
					<td>Income:</td>
					<td><html:text property="frmAdopterIncome" disabled="true"></html:text>
					</td>
				</tr>

				<tr>
					<td>Gender</td>
					<td><html:text property="frmAdopterGender" disabled="true"></html:text>
					</td>
				</tr>
				<tr>
					<td>Marital Status</td>
					<td><html:text property="frmAdopterMaritalStatus"
							disabled="true"></html:text></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><html:text property="frmAdopterDob" disabled="true"></html:text>
					</td>
				</tr>
				<tr>
					<td>No. of Children:</td>
					<td><html:text property="frmAdopterChildNo" disabled="true"></html:text>
					</td>
				</tr>
				<tr height="45px">
					<tr>
				
				
					<td colspan="2">
				
						
						<img src="images/give.png" style="width:50px;height:40px;">
						<span style="color:#366b82;font-size:18px;">
						Info about the Orphan You want to Adopt</span></td></tr>
					<tr><td>Region</td><td><html:text property="frmRegionName" disabled="true"></html:text></td></tr>
					<tr><td>City</td><td><html:text property="frmCityName" disabled="true"></html:text></td></tr>
					<tr><td>Shelter's Name</td><td><html:text property="frmShelterName" disabled="true"></html:text></td>
				</tr>
				<tr>
					<td>Orphan Gender:</td>
					<td><html:text property="frmOrphanGender" disabled="true"></html:text>
					</td>
				</tr>
				<tr>
					<td>Orphan's Age</td>
					<td><html:text property="frmOrphanAge" disabled="true">

						</html:text></td>
				</tr>
				<tr>
					<td>Adopted Child No:</td>
					<td><html:text property="frmAdoptedChildNo" disabled="true">

						</html:text></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><html:submit property="btnSave"
							value="Save" onclick="myFunction()" styleId="buttonwto"></html:submit> <html:submit property="btnSaveCancel"
							value="Cancel" styleId="buttonwto"></html:submit>
				</tr>

			</table>
		</logic:notEmpty>
</div></div>
</center>
	</html:form>
	
<footer>
		<%@include file="inc/footer.jsp"%></footer>
</body>
</html>