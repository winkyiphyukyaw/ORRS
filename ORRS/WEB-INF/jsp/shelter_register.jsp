<%@include file="inc/common.jsp"%>
<html>
	<head><title>Shelter Registration</title>
	<!-- <link href="css/style3.css" rel='stylesheet' type='text/css' /> -->
	<script type="text/javascript">
	function sendRegion(categoryId) {
		AjaxSearchSubcategory.getBySubcity(categoryId, callbackCat);
	}
	//when subcategory is obtained from server
	function callbackCat(message) {
		dwr.util.removeAllOptions("subcitylist");
		dwr.util.addOptions("subcitylist", message, "id", "name");
	}
//-->
</script>
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
<script src='dwr/interface/AjaxSearchSubcategory.js'></script>
	
	
	
	
<!-- <link href="css/library.css" type="text/css" rel="stylesheet">
 -->
<style>
body,html {
	height: 100%;
	margin: 0;
}

.bg {
	/* The image used */
	background-image: url("images/bagan.jpg");
	/* Full height */
	height: auto;
	margin:0;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	
}

.content {
	max-width: 750px;
	margin: auto;
	padding: 10px;
}

text {
	heigh: 50px;
	
}

form {
	background-color: #efefef;
	border-radius: 25px;
	border: 1px solid black;
	opacity: 0.6;
	filter: alpha(opacity = 60); /* For IE8 and earlier */
	

}
.myTable{
	
	font-weight: bold;
    color: #000000;
    opacity:1;
    width:700px;
}
input[type=text] {
	height: 30px;
	box-sizing: border-box;
	width:200px;
}

input[type=password] {
	height: 30px;
	width:200px;
	box-sizing: border-box;
}

#button {
	background-color: #adadad;
	color: green;
	padding: 14px 20px;
	margin: 8px 0;
	border: 1px solid #f1f1f1;
	cursor: pointer;
	border-radius: 13px;
	width: 120px;
	height:50px;
	font-size:14px;
}
select {
height: 30px;
width:200px;
}

}
</style>
	</head>
	<body onload="DWRUtil.useLoadingMessage();">
	<div class="bg">
		<div class="content">
		
		
		<html:form action="/registerPath">
		<h1 align="center"
		style="font-size: 30px; color: green; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
		<h3 align="center" style=" color: green; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Shelter Registration Page</h3>
		<center>
		
			<logic:empty property="shelRegFormControl" name="RegFormBean">
				<table class="myTable">
					<tr>
						<td>Shelter Name:</td>
						<td><html:text property="shelterRegName" maxlength="50"></html:text>
						
						<font color="red">***</font></td>
								<td width="250px"><html:errors property="shelterRegName"/></td>
							
					</tr>
					<tr>
						<td>Principal Name:</td> 
						<td> <html:text property="shelterPrincipalName" maxlength="30"></html:text>
						<font color="red">***</font></td>
								<td><html:errors property="shelterPrincipalName"/></td>
							
					</tr>
					
					<tr>
						<td>Login Name:</td> 
						<td> <html:text property="shelterRegLoginName" maxlength="30"></html:text>
						<font color="red">***</font></td>
								<td><html:errors property="shelterRegLoginName"/>
								<html:errors property="accountError"/>
								</td>
							
					</tr>
					
					<tr>
						<td>Password:</td>
						<td><html:password property="shelterRegPassword" maxlength="20">
						</html:password>
						<font color="red">***</font></td>
								<td><html:errors property="shelterRegPassword"/></td>
							
					</tr>
					
					
					<tr>
						<td>Confirm Password:</td>
						<td><html:password property="shelterRegConfPassword" maxlength="20">
						</html:password> 
						<font color="red">***</font></td>
								<td><html:errors property="shelterRegConfPassword"/>
								<html:errors property="passwordError"/></td>
							
					</tr>
					<tr>
						<td>Email Address:</td>
						<td><html:text property="shelterRegEmail" maxlength="30"></html:text>
						
						<font color="red">***</font></td>
								<td><html:errors property="shelterRegEmail"/></td>
							
					</tr>
					<tr>
						<td>Phone Number:</td>
						<td><html:text property="shelterRegPhone" maxlength="15">
						</html:text>
						<font color="red">***</font></td>
								<td><html:errors property="shelterRegPhone"/></td>
							
							
						
					</tr>
					<tr ><td></td>
					<td colspan="2" align="left"><font color="green">
								(eg.,0xx-xxxxxx,0x-xxxxxxx,0x-xxxxxxxxxxx)
							</font></td></tr>
						<tr >
						<td>Address:</td>
						<td><html:textarea property="shelterRegAddress" style="width:200px;height:80px;">
						</html:textarea>
						<font color="red">***</font></td>
								<td><html:errors property="shelterRegAddress"/></td>
							
					</tr>
					
					
					
					
					
					
					<tr>
						<td>
						<label for="name">Region\State</label> 
						</td>
						<td>
						<html:select property="shelterRegRegionStateById" onchange="sendRegion(this[this.selectedIndex].value)">
							<html:option value="0">SELECT</html:option>
							<html:optionsCollection property="shelterRegRegionStateList" label="name" value="id"/>
						</html:select>
						<font color="red">***</font></td>
								<td><html:errors property="regionstateError"/></td>
						
					</tr>
					<tr>
						<td>
						<label for="nextcity">City</label> 
						</td>
						<td>
						<html:select property="shelterRegSubCityId" styleId="subcitylist">
							<html:option value="0">All</html:option>
							<logic:notEmpty property="shelterRegSubcityList" name="RegFormBean">
							<html:optionsCollection property="shelterRegSubcityList" value="id" label="name"/>
							</logic:notEmpty>
						</html:select>
						<td><html:errors property="subcityError"/></td>
						
					</tr>
					
					
					
					<tr>
						<td>Breakfast Cost(MMK):</td>
						<td><html:text property="shelterRegBfCost" maxlength="8">
						</html:text>
						<font color="red">***</font></td>
								<td><html:errors property="shelterRegBfCost"/></td>
						
					</tr>
					<tr>
						<td>Lunch Cost(MMK):</td>
						<td><html:text property="shelterRegLunCost" maxlength="8">
						</html:text>
						<font color="red">***</font></td>
								<td><html:errors property="shelterRegLunCost"/></td>
							
					</tr>
					<tr>
						<td>Dinner Cost(MMK):</td>
						<td><html:text property="shelterRegDinCost" maxlength="8">
						</html:text>
						<font color="red">***</font></td>
								<td><html:errors property="shelterRegDinCost"/></td>
							
					</tr>
					
					
					
				
					<tr>
						<td colspan="3" align="center">
						<html:submit
							property="btnRegister" value="Register" styleId="button">
						</html:submit> 
						
						<html:reset value="Clear" styleId="button"></html:reset>
						<html:cancel value="Back" styleId="button"></html:cancel>
						
						</td>
					</tr>
				</table>
			</logic:empty>
			
			
			
			<!-- *************Confirmation******************-->
			<logic:notEmpty property="shelRegFormControl" name="RegFormBean">
			
				<table class="myTable">
				
				<tr>
						<td>Shelter Name:</td>
						<td><html:text property="shelterRegName" disabled="true"></html:text> </td>
					</tr>
					<tr>
						<td>Principal Name:</td>
						<td><html:text property="shelterPrincipalName" disabled="true"></html:text> </td>
					</tr>
					<tr>
						<td>Login Name:</td> 
						<td> <html:text property="shelterRegLoginName" disabled="true"></html:text></td>
					</tr>
					
					<tr>
						<td>Password:</td>
						<td><html:text property="shelterRegPassword" disabled="true">
						</html:text> </td>
					</tr>
					<tr>
						<td>Confirm Password:</td>
						<td><html:text property="shelterRegConfPassword" disabled="true">
						</html:text> 
					</tr>
					<tr>
						<td>Email Address:</td>
						<td><html:text property="shelterRegEmail" disabled="true"></html:text> </td>
					</tr>
					<tr>
						<td>Phone Number:</td>
						<td><html:text property="shelterRegPhone" disabled="true">
						</html:text></td>
					</tr>
					
						<tr>
						<td>Address:</td>
						<td><html:text property="shelterRegAddress" disabled="true">
						</html:text></td>
					</tr>
					
					<tr>
						<td>RegionState:</td>
						<td>
							<html:text property="shelterRegRegionState" disabled="true"></html:text>
						</td>
					</tr>
					
						<tr>
						<td>City:</td>
						<td><html:text property="shelterRegCity" disabled="true">
						</html:text></td>
					</tr> 
			
					<tr>
						<td>Breakfast Cost:</td>
						<td><html:text property="shelterRegBfCost" disabled="true">
						</html:text></td>
					</tr>
					<tr>
						<td>Lunch Cost:</td>
						<td><html:text property="shelterRegLunCost" disabled="true">
						</html:text></td>
					</tr>
					<tr>
						<td>Dinner Cost:</td>
						<td><html:text property="shelterRegDinCost" disabled="true">
						</html:text></td>
					</tr>
					
					
					
					
					
					
					<tr>
						<td colspan="3" align="center" ><html:submit
							property="btnSave" value="Save" styleId="button">
						</html:submit> <html:submit property="btnSaveCancel" value="Cancel" styleId="button">
						</html:submit></td>
					</tr>
				</table>
			</logic:notEmpty>
			</center>
		</html:form>
		</div></div>
	</body>
</html>