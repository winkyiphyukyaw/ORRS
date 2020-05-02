<%@include file="inc/banner.jsp"%>
<%@ include file="inc/calendar.jsp"%>
<html:html>
<head>
<title>Donate Form</title>
<!-- Calling java code -->
<script type="text/javascript">
	// should be in the "onload" of the body
	function createAutoCompleter() {
		new Autocompleter.DWR("frmShelterName1", "choices1",
				populateAutocomplete, {
					afterUpdateElement : bookSelected,
					valueSelector : bookValueSelector
				});
	}
	// the callback for the auto completer
	function populateAutocomplete(autocompleter, token) {
		AjaxBooksSearch.getAllShelterName(token, function(suggestions) {
			if (suggestions != null) {
				autocompleter.setChoices(suggestions);
			}
		});
	}
	//this function extractes string from sample object for matching
	function bookValueSelector(Shelter) {

		return Shelter.shelterName;
	}
	//this function is fired when users selects sample from list
	function bookSelected(inputElement, selectedElement, Shelter) {

		dwr.util.setValue("frmShelterName1", Shelter.shelterName);
		dwr.util.setValue("frmBreakfast", Shelter.breakfastPrice);
		dwr.util.setValue("frmLunch", Shelter.lunchPrice);
		dwr.util.setValue("frmDinner", Shelter.dinnerPrice);
	}
	var total = 0;
	var breakfast = false;
	var lunch = false;
	var dinner = false;
	function calculateAmount(amount) {
		/* total += parseInt(amount.value); 
		var breakfast = document.getElementById('Breakfast').checked;
		var breakfast = document.getElementById('Lunch').checked;
		var breakfast = document.getElementById('Dinner').checked;  */

		if (document.getElementById('Breakfast').checked == true
				&& breakfast == false) {
			total += parseInt(amount.value);
			breakfast = true;
		} else if (document.getElementById('Lunch').checked == true
				&& lunch == false) {
			total += parseInt(amount.value);
			lunch = true;
		} else if (document.getElementById('Dinner').checked == true
				&& dinner == false) {
			total += parseInt(amount.value);
			dinner = true;
		}

		else if (document.getElementById('Breakfast').checked == false
				&& breakfast == true) {
			total -= parseInt(amount.value);
			breakfast = false;
		} else if (document.getElementById('Lunch').checked == false
				&& lunch == true) {
			total -= parseInt(amount.value);
			lunch = false;
		} else if (document.getElementById('Dinner').checked == false
				&& dinner == true) {
			total -= parseInt(amount.value);
			dinner = false;
		}
		document.getElementById('frmRegAmount').value = total;
	}
//-->
</script>
<!-- <link href="css/library.css" rel="stylesheet" type="text/css"> -->
<!-- Declare the autocomplement style -->
<style type="text/css">
<!--
div.choices ul { /* autocomplete candidate */
	list-style-type: none;
	background-color: #fff;
	border: 2px solid #ccc;
	margin-left: 0;
	margin-top: 0;
	padding-left: 5px;
	padding-top: 0;
}

div.choices ul li.selected { /* selected autocomplete*/
	background-color: #ffc;
	font-weight: bold;
}
-->
</style>
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
<script src='dwr/interface/AjaxBooksSearch.js'></script>

<!-- <style>
tr {
	height: 30px;
}
#buttonwto {
	background-color: white;
	color: black;
	border: 2px solid #086A87;
	width: 100px;
</style> -->
</head>
<body onload="DWRUtil.useLoadingMessage(); createAutoCompleter()">
<div class="userlogo">
		<h1 align="center"
		style="font-size: 30px; color: #366b82; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
</div>

	<div id="wrap">
		<ul class="navbar">
			<li><div class="dropdown"><a href="Welcome.do"><span
					class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</span></a></div></li>

			<li ><div class="dropdown"><a href="shelterPath.do?frmControl=1"><span
					class="glyphicon glyphicon-road" aria-hidden="true"></span> Shelter</a></div></li>
					
			<li><div class="dropdown"><a href="userStoryPath.do"><span
					class="glyphicon glyphicon-calendar" aria-hidden="true"></span> Story</a></div></li>
			
			<li><div class="dropdown"><a href="EventPath.do"><span
					class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
					Activity</a></div></li>

			<!-- <li><a href="#"><span class="glyphicon glyphicon-gift"
						aria-hidden="true"></span> Donate</a>
					<ul>
						<li><a href="donorShelterFirstPath.do">Direct to Shelter</a></li>
						<li><a href="donorDirectFirstPath.do">Direct to
								Foundation</a></li>
					</ul></li> -->
			<li ><div class="dropdown">
				<a href="#"><span class="glyphicon glyphicon-gift"
						aria-hidden="true"></span>
							Donate</a>
				<div class="dropdown-content">
					<a href="donorShelterFirstPath.do">Donate to Shelter</a> 
					<a href="donorDirectFirstPath.do">Donate to Foundation</a></div></div></li>
					
					
					
					
					<!-- <li><a href="donorShelterFirstPath.do"><span
							class="glyphicon glyphicon-gift" aria-hidden="true"></span>Donate
							to Shelter</a></li>
					<li><a href="donorDirectFirstPath.do"><span
							class="glyphicon glyphicon-gift" aria-hidden="true"></span>Donate
							to Foundation</a></li> -->

					<li class="active"><div class="dropdown"><a href="givingMealFirstPath.do"><span
							class="glyphicon glyphicon-glass" aria-hidden="true"></span>
							Giving Meal</a></div></li>
					<li><div class="dropdown"><a href="adopterFirstPath.do"><span
							class="glyphicon glyphicon-heart" aria-hidden="true"></span>
							Adopt</a></div></li>
					<li><div class="dropdown"><a href="AboutPath.do"><span
							class="glyphicon glyphicon-user" aria-hidden="true"></span> About</a></div>

					</li>
					<li><div class="dropdown"><a href="ContactPath.do"><span
							class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
							Contact</a></div></li>
					<li><div class="dropdown"><a href="annualReportPath.do"><span
							class="glyphicon glyphicon-book" aria-hidden="true"></span>
							Annual Report</a></div></li>
		</ul>

	</div>
	
			<html:form action="/givingMealRegPath">
			<center>
			<div class="divbodyborder">
<div class="maincontainer">
<h1 align="center"
		style="font-size: 20px; color: #366b82; text-shadow: 0 1px 1px rgba(0,0,0,5);">Donate To Shelter</h1>
				<logic:empty property="frmRegFormControlFood"
					name="DonorRegFormBean">
					<center>
					<table border="0" width="700px">

				
					<logic:notEmpty property="frmShelterControl"
						name="DonorRegFormBean">
						<tr height="40px">
						<td>Shelter Name</td>
						<td><html:text property="frmShelterName" disabled="true" /></td>
						</tr>
					</logic:notEmpty>
					<logic:empty property="frmShelterControl" name="DonorRegFormBean">
					<tr><td colspan="3"><img src="images/give.png" style="width:30px;height:30px;">
					<span style="color:#366b82;font-size:18px;">Please,Choose where and when to Donate</span></td></tr>
					
						<tr height="40px">
							<td>Shelter Name</td>
							<td><html:text property="frmShelterName"
									styleId="frmShelterName1" />
								<div class="choices" id="choices1"></div> <font color="red">***</font>
							</td>
							<td width="250"><font color="red"> <html:errors
										property="shelterError" /> 
							</font></td>
						</tr>
					</logic:empty>
					
					<tr height="40px">
						

								
								<td colspan="3"><html:multibox property="frmBreakfastMeal"
										value="frmBreakfast" styleId="Breakfast"
										onclick="calculateAmount(frmBreakfast)" /> Breakfast(MMK)
									&nbsp; <html:multibox property="frmLunchMeal" value="frmLunch"
										styleId="Lunch" onclick="calculateAmount(frmLunch)" /> Lunch
									(MMK) &nbsp;<html:multibox
										property="frmDinnerMeal" value="frmDinner" styleId="Dinner"
										onclick="calculateAmount(frmDinner)" /> Dinner(MMK)</td>

							</tr>
							<!-- style="width:100px;" -->
					
							<tr height="40px">
								
								<td colspan="2"><html:text property="frmBreakfastPrice"
										style="width:100px;" styleId="frmBreakfast" />&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:text
										property="frmLunchPrice" styleId="frmLunch"
										style="width:100px;" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <html:text property="frmDinnerPrice"
										styleId="frmDinner" style="width:100px;" /></td>

							<td>
							<html:errors property = "MealError.breakfast"/>
							<html:errors property = "MealError.lunch"/>
							<html:errors property = "MealError.dinner"/>
						</td>
					</tr>
					
					<tr height="40px">
						<td>Amount(MMK)</td>
						<td><html:text property="frmRegAmount" styleId="frmRegAmount" maxlength="11" readonly="true"></html:text>
							<font color="red">***</font></td>
						<td width="250"><font color="red"><html:errors
									property="frmRegAmount" /></font>
					</tr>
					
					<tr height="40px">
						<td>Donate Date</td>
						<td><html:text property="frmRegDonateDate"
								styleId="calendar1" maxlength="10" size="9" readonly="true" /> <html:image
								src="images/calendar.gif" styleId="trigger1"
								style="cursor: pointer; border: 1px solid red;"
								title="Date selector" onmouseover="this.style.background='red';"
								onmouseout="this.style.background=''"></html:image> <font
							face="Verdana" size="0.5" color="blue">&nbsp;YYYY-MM-DD</font> <script
								type="text/javascript">
								//         
								Calendar.setup({
									firstDay : 1,
									electric : false,
									singleClick : true,
									inputField : "calendar1",
									button : "trigger1",
									ifFormat : "%Y-%m-%d",
									daFormat : "%Y-%m-%d"
								});
								//
							</script><font color="red">***</font></td>
						<td><font color="red"><html:errors
									property="frmRegDonateDate" /></font>
										<html:errors property = "DateError"/>	</td>
					</tr>


					<tr></tr>
					<tr height="40px"></tr>
					<tr height="40px"><td colspan="3" align="left"><img src="images/credit.jpg" style="width:250px;height:40px;"></td></tr>
					
					<tr height="40px">
						<td>Credit Card Name</td>
						
						<td><html:text property="frmRegDonorCreditCard"></html:text>
							<font color="red">*** </font></td>
						<td><font color="red"> <html:errors
									property="frmRegDonorCreditCard" /></font></td>
					</tr>
					
					<tr height="40px">
						<td>Credit Card Type</td>
						<td><html:select property="frmRegCreditCardType">
			
					<html:option value="kbz">KBZ</html:option>
					<html:option value="aya">AYA</html:option>
					<html:option value="cb">CB</html:option>
				</html:select></td>
						<td><font color="red"><html:errors
									property="frmRegCreditCardType" /></font></td>

					</tr>
					
					<tr height="40px">
						<td>Card Holder</td>
						<td><html:text property="frmRegCardHolder" maxlength="15"></html:text> <font
							color="red">*** </font></td>
						<td><font color="red"><html:errors
									property="frmRegCardHolder" /></font></td>
					</tr>
					
					<tr height="40px">
						<td>Expired Date</td>
						<td><html:text property="frmRegCardExpireDate"
								styleId="calendar" maxlength="10" size="9" readonly="true"/> <html:image
								src="images/calendar.gif" styleId="trigger"
								style="cursor: pointer; border: 1px solid red;"
								title="Date selector" onmouseover="this.style.background='red';"
								onmouseout="this.style.background=''"></html:image> <font
							face="Verdana" size="0.5" color="blue">&nbsp;YYYY-MM-DD</font> <script
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
							</script><font color="red">***</font></td>
						<td><font color="red"><html:errors
									property="frmRegCardExpireDate" /></font></td>
					</tr>
<tr></tr>
<tr></tr>
					<tr height="40px"></tr>
					<tr height="40px"><td colspan="3" align="left"><img src="images/personalProfile.png" style="width:30px;height:30px;">
					<span style="color:#366b82;font-size:18px;">Your Personal Info</span></td></tr>


					<tr height="40px">
						<td>Name</td>
						<td><html:text property="frmRegDonorName" maxlength="30"></html:text> <font
							color="red">***</font></td>
						<td><html:errors property="frmRegDonorName" /></td>
					</tr>
					
					<tr>
						<td>NRC</td>
						<td><html:text property="frmRegDonorNRC"  maxlength="30"></html:text> <font
							color="red">***</font></td>
						<td><html:errors property="frmRegDonorNRC" /></td>
					</tr>
					<tr><td></td><td><font color="green">
								(eg.,xx/XxXxXx(N)xxxxxx)
							</font></td></tr>
					
					<tr height="40px">
						<td>Phone</td>
						<td><html:text property="frmRegDonorPhone"  maxlength="15"></html:text> <font
							color="red">***</font></td>
						<td><html:errors property="frmRegDonorPhone" /></td>
					</tr>
					<tr height="40px">
						<td></td>
						<td><font color="green"> (eg.,0x-xxxxxxxxx) </font></td>
					</tr>
					<tr height="40px">
						<td>Email</td>
						<td><html:text property="frmRegDonorEmail"  maxlength="30"></html:text> <font
							color="red">***</font></td>
						<td><html:errors property="frmRegDonorEmail" /></td>
					</tr>
					
					<tr height="40px">
						<td>Address</td>
						<td><html:text property="frmRegDonorAddress"  maxlength="50"></html:text> <font
							color="red">*** </font></td>
						<td><html:errors property="frmRegDonorAddress" /></td>
					</tr>
					
					<tr height="40px">
						<td>Comment</td>
						<td><html:textarea property="frmRegDonorComment"></html:textarea>
						</td>
					</tr>
		</table>
		</center>
		<br>
		<center>
		<table>
		<tr>
			<td><html:submit property="btnDonateFood" value="Donate" styleId= "buttonwto"></html:submit></td>
			
			<td><%-- <html:cancel value="Cancel" styleId= "buttonwto"></html:cancel> --%></td></tr></table></center>
			</logic:empty>		
		<logic:notEmpty property="frmRegFormControlFood"
			name="DonorRegFormBean">
			<center>
			<table>

				<tr><td colspan="2"><img src="images/give.png" style="width:50px;height:50px;">
					<span style="color:#366b82;font-size:18px;">Info about Your Donation</span></td></tr>

				<tr>
					<td>Shelter Name:</td>
					<td><html:text property="frmShelterName"
							styleId="frmShelterName1" disabled="true" />
						<div class="choices" id="choices1"></div></td>


				</tr>
				<tr>
					

								<td>Kind of Meal</td>
								<td colspan="2"><html:multibox property="frmBreakfastMeal"
										value="frmBreakfast" styleId="Breakfast"
										onclick="calculateAmount(frmBreakfast)" /> Breakfast &nbsp;
									&nbsp; <html:multibox property="frmLunchMeal" value="frmLunch"
										styleId="Lunch" onclick="calculateAmount(frmLunch)" /> Lunch
									&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<html:multibox
										property="frmDinnerMeal" value="frmDinner" styleId="Dinner"
										onclick="calculateAmount(frmDinner)" /> Dinner</td>

							</tr>
							<!-- style="width:100px;" -->

							<tr>
								<td></td>
								<td colspan="2"><html:text property="frmBreakfastPrice"
										style="width:100px;" styleId="frmBreakfast" /> <html:text
										property="frmLunchPrice" styleId="frmLunch"
										style="width:100px;" /> <html:text property="frmDinnerPrice"
										styleId="frmDinner" style="width:100px;" /></td>
				</tr>
<tr>
					<td>Amount:</td>
					<td><html:text property="frmRegAmount" styleId="frmRegAmount"
							disabled="true"></html:text></td>
				</tr>
				<tr><td colspan="2" align="left"><img src="images/credit.jpg" style="width:250px;height:40px;"></td></tr>
				<tr>
					<td>Credit Card</td>
					<td><html:text property="frmRegDonorCreditCard"
							disabled="true"></html:text></td>
				</tr>
				<tr>
					<td>Credit Card Type</td>
					<td><html:text property="frmRegCreditCardType" disabled="true"></html:text>
					</td>
				</tr>
				<tr>
					<td>Card Holder</td>
					<td><html:text property="frmRegCardHolder" disabled="true"></html:text>
					</td>
				</tr>
				<tr>
					<td>Expired Date</td>
					<td><html:text property="frmRegCardExpireDate" disabled="true"></html:text>
					</td>

				</tr>
				<tr><td colspan="2" align="left"><img src="images/personalProfile.png" style="width:30px;height:30px;">
					<span style="color:#366b82;font-size:18px;">Your Personal Info</span></td></tr>

				<tr>
					<td>Name:</td>
					<td><html:text property="frmRegDonorName" disabled="true"></html:text>
					</td>
				</tr>
				<tr>
					<td>NRC:</td>
					<td><html:text property="frmRegDonorNRC" disabled="true"></html:text>
					</td>
				</tr>
				<tr>
					<td>Donate Date</td>
					<td><html:text property="frmRegDonateDate" disabled="true"></html:text>
					</td>

				</tr>
				
				
				<tr>
					<td>Phone:</td>
					<td><html:text property="frmRegDonorPhone" disabled="true"></html:text></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><html:text property="frmRegDonorEmail" disabled="true"></html:text>
					</td>
				</tr>

				<tr>
					<td>Address:</td>
					<td><html:text property="frmRegDonorAddress" disabled="true"></html:text>
					</td>
				</tr>


				<tr>
					<td>Comment:</td>
					<td><html:textarea property="frmRegDonorComment"
							disabled="true"></html:textarea></td>
				</tr>
				<tr>
					<td  align="center"><html:submit property="btnSave"
							value="Confirm" styleId= "buttonwto"></html:submit> <%-- <html:submit property="btnRegisterCancel" value="Cancel"></html:submit> --%>
						<%-- <html:submit property="btnCancel" value="Cancel"></html:submit> --%>
					</td>
					<td><html:submit property="btnSaveCancel" value="Cancel" styleId= "buttonwto" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<%-- <html:errors property="accountError"/> --%>
					</td>
				</tr>
			</table></center>
		</logic:notEmpty>
		</div>
	</div>
	</center>
		</html:form>
		
	
	<footer>
	
		<%@include file="inc/footer.jsp"%></footer>
</body>
</html:html>