<%@include file="inc/banner.jsp"%>
<html:html>
<head>
<%@ include file="inc/calendar.jsp"%>
<title>Donate Form</title>
<!-- Calling java code -->
<script>
function myFunction() {
    alert("Your Donation is Successful.Thanks alot!!!");
}
</script>
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

	}
//-->
</script>
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
</style> -->
</head>
<body
	onload="ShowHideDiv();">
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
			<li class="active"><div class="dropdown">
				<a href="#"><span class="glyphicon glyphicon-gift"
						aria-hidden="true"></span>Donate</a>
				<div class="dropdown-content">
					<a href="donorShelterFirstPath.do">Donate to Shelter</a> 
					<a href="donorDirectFirstPath.do">Donate to Foundation</a></div></div></li>
					
					
					
					
					<!-- <li><a href="donorShelterFirstPath.do"><span
							class="glyphicon glyphicon-gift" aria-hidden="true"></span>Donate
							to Shelter</a></li>
					<li><a href="donorDirectFirstPath.do"><span
							class="glyphicon glyphicon-gift" aria-hidden="true"></span>Donate
							to Foundation</a></li> -->

					<li><div class="dropdown"><a href="givingMealFirstPath.do"><span
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
	
			<html:form action="/donorDirectRegPath">
			<center>
			<div class="divbodyborder">
<div class="maincontainer">
<h1 align="center"
		style="font-size: 20px; color: #366b82; text-shadow: 0 1px 1px rgba(0,0,0,5);">Donate To Foundation(ORRS)</h1>
				<script>
					function ShowHideDiv() {
						var chkMonth = document.getElementById("chkOnce");
						var chkMonth = document.getElementById("chkMonth");
					    var chkYear = document.getElementById("chkYear");
					    var dvMonth = document.getElementById("txtMonth");
					    var dvMonth1 = document.getElementById("txtMonth1");
					    
					    var dvMonth2 = document.getElementById("txtMonth2");
					    var dvMonth3 = document.getElementById("txtMonth3");
					    var dvYear = document.getElementById("txtYear");
					    var dvYear1 = document.getElementById("txtYear1");
					    var dvYear2 = document.getElementById("txtYear2");
					    var dvYear3 = document.getElementById("txtYear3");
					    document.getElementById("chkOnce").checked==true
					    if(chkMonth.checked==true)
					    	{
					    	
					    	dvMonth.style.display= "block";
					    	dvMonth1.style.display= "block";
					    	
					    	dvMonth2.style.display= "block";
					    	dvMonth3.style.display= "block";
					    	
					    	   dvYear.style.display="none";
					    	   dvYear1.style.display="none";
					    	   
					    	   dvYear2.style.display="none";
					    	   dvYear3.style.display="none";
					    	}
					    else if(chkYear.checked==true){
					    	
					    	dvYear.style.display= "block";
					    	dvYear1.style.display= "block";
					    	dvYear2.style.display="block";
					 	   dvYear3.style.display="block";
					    	
					    	dvMonth.style.display="none";
					    	dvMonth1.style.display="none";
					    	dvMonth2.style.display= "none";
					    	dvMonth3.style.display= "none";
					    	
					    }
					    else if(chkOnce.checked==true){
					    	dvMonth.style.display="none";
					    	dvMonth1.style.display="none";
					    	 dvYear.style.display="none";
					  	   dvYear1.style.display="none";
					  	   
					  	 dvMonth2.style.display= "none";
					 	dvMonth3.style.display= "none";
					 	  dvYear2.style.display="none";
						   dvYear3.style.display="none";
					    }

					}
				</script>

				<logic:empty property="frmRegFormControl" name="DonorRegFormBean">
				
				
				<table align="center" border="0"  width="750px">
				<tr><td width="750px" align="center"><label style="color:green;">Please Donate for ${DonorRegFormBean.lastcategory } because there is only a few ${DonorRegFormBean.lastamount } % for this part.</label></td></tr>
				<tr>
					<td align="center">
						<table align="center" border="0">
						<tr>
								<td colspan="3"><img src="images/give.png" style="width:30px;height:30px;">
					<span style="color:#366b82;font-size:18px;">Please,Choose where and when to Donate</span></td></tr>
						
						<tr>
							<td colspan="3" width="750px">
							<html:radio property="radioTest" value="0" styleId="chkOnce" onclick="ShowHideDiv()" >OnlyOnce</html:radio>
							&nbsp;&nbsp;
							<html:radio property="radioTest" value="1" styleId="chkMonth" onclick="ShowHideDiv()" >Monthly</html:radio>
							&nbsp;&nbsp;
						     <html:radio property="radioTest" value="2" styleId="chkYear" onclick="ShowHideDiv()" >Yearly</html:radio>
						    </td>
						</tr>
						
						<tr>
								<td>
													<p id="txtMonth" style="display: none">From Months</p>

													<p id="txtYear" style="display: none">From Years</p>

												</td>
												<td>


													<p id="txtMonth1" style="display: none;">
														<html:text property="monthlyFee" styleId="calendar2"
															maxlength="15" size="15" />
														
													</p>




													<p id="txtYear1" style="display: none">
														<html:text property="yearlyFee" styleId="calendar1"
															maxlength="15" size="15"  />
												
														
												</td>
											</tr>
											<tr>
												<td  height="42px"><p id="txtMonth2"
														style="display: none">To Months</p>
													<p id="txtYear2" style="display: none">To Years</p></td>
												<td><p id="txtMonth3" style="display: none;">
														<html:text property="monthlyFee1" styleId="calendar22"
															maxlength="15" size="15" />
														<html:image src="images/calendar.gif" styleId="trigger22"
															style="cursor: pointer; border: 1px solid red;"
															title="Date selector"
															onmouseover="this.style.background='red';"
															onmouseout="this.style.background=''"></html:image>
														<!-- <font
						face="Verdana" size="2" color="blue">&nbsp;YYYY-MM-DD</font>  -->
														<script type="text/javascript">
															//         
															Calendar
																	.setup({
																		firstDay : 1,
																		electric : false,
																		singleClick : true,
																		inputField : "calendar22",
																		button : "trigger22",
																		ifFormat : "%Y-%m",
																		daFormat : "%Y-%m"
																	});
															//
														</script>
														<font color="red">***</font>&nbsp&nbsp&nbsp&nbsp




													</p>
													<p id="txtYear3" style="display: none">
														<html:text property="yearlyFee1" styleId="calendar11"
															maxlength="15" size="15" />
														<html:image src="images/calendar.gif" styleId="trigger11"
															style="cursor: pointer; border: 1px solid red;"
															title="Date selector"
															onmouseover="this.style.background='red';"
															onmouseout="this.style.background=''"></html:image>
														<!-- <font
						face="Verdana" size="2" color="blue">&nbsp;YYYY-MM-DD</font> -->
														<script type="text/javascript">
															//         
															Calendar
																	.setup({
																		firstDay : 1,
																		electric : false,
																		singleClick : true,
																		inputField : "calendar11",
																		button : "trigger11",
																		ifFormat : "%Y",
																		daFormat : "%Y"
																	});
															//
														</script>
														<font color="red">***</font>
																												
													</p></td>
<td>	<html:errors property="MonthEmpty"/><html:errors property="YearEmpty"/>
<html:errors property="MonthError"/><html:errors property="YearError"/></td>
											
											</tr>
											
										
				<tr>
						<td>What To Donate  </td>
						<td> 
							<html:select property="frmRegCategoryId">
								<html:option value="0">SELECT</html:option>
								<html:optionsCollection property="frmRegCategoryList" value="id"
									label="type" /><font color="red">***</font>
							</html:select> 
						</td>
						<td width="250">
							<font color="red">
								<html:errors property="categoryError"/>
							</font>
						</td>
				</tr>
				<tr></tr>
				<tr><td colspan="3" align="left"><img src="images/credit.jpg" style="width:250px;height:40px;"></td>
				
				
				<tr height="10px"></tr>
				<tr>	
					<td>Amount</td>
					<td>
						<html:text property="frmRegAmount"></html:text>
						<font color="red">***</font>
					</td>
					<td width="250"><font color="red"><html:errors property="frmRegAmount"/></font>
				</tr>
				
<tr height="40px">					<td>Credit Card No.</td>
					<td>
						<html:text property="frmRegDonorCreditCard"></html:text>
						<font color="red">***
							</font>
					</td>
					<td><font color="red">
							<html:errors property="frmRegDonorCreditCard"/></font>
					</td>
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
					<td><html:text property="frmRegCardHolder"></html:text>
					 <font color="red">*** </font>
					 </td>
					 <td><font color="red">
							<html:errors property="frmRegCardHolder"/></font>
					</td>
				</tr>
				
				<tr height="40px">
					<td>Expired Date</td>
					<td>
						<html:text property="frmRegCardExpireDate"
									styleId="calendar" maxlength="10" size="10" /> <html:image
									src="images/calendar.gif" styleId="trigger"
									style="cursor: pointer; border: 1px solid red;"
									title="Date selector"
									onmouseover="this.style.background='red';"
									onmouseout="this.style.background=''"></html:image>
						 <font face="Verdana" size="0.5" color="blue">&nbsp;YYYY-MM-DD</font>
									<script
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
									</script>
								</td>
								 <td>
								<html:errors property="frmRegCardExpireDate"/>
								</td> 
					</tr>
					<tr></tr>
					<tr><td colspan="3" align="left"><img src="images/personalProfile.png" style="width:30px;height:30px;">
					<span style="color:#366b82;font-size:18px;">Your Personal Info</span></td></tr>
					<tr height="40px">	
						<td >Name</td>
						<td >
							<html:text property="frmRegDonorName"></html:text>
							<font color="red">***</font>
						</td>
						<td ><html:errors property="frmRegDonorName"/></td>
					</tr>
					
				<tr height="40px">	
						<td>NRC</td>
						<td>
							<html:text property="frmRegDonorNRC"></html:text>
							<font color="red">***</font>
						</td>
						<td><html:errors property="frmRegDonorNRC"/></td>
					</tr>
					<tr><td></td><td><font color="green">
								(eg.,xx/XxXxXx(N)xxxxxx)
							</font></td></tr>
					<tr height="40px">	
						<td>Phone</td>
						<td>
							<html:text property="frmRegDonorPhone"></html:text>
							<font color="red">***</font>
						</td>
						<td><html:errors property="frmRegDonorPhone"/></td>
					</tr>
					<tr height="40px"><td></td><td><font color="green">
								(eg.,0x-xxxxxxxxx)
							</font></td></tr>
					<tr height="40px">	
						<td>Email</td>
						<td>
							<html:text property="frmRegDonorEmail"></html:text>
							<font color="red">***</font>
						</td>
						<td>
						<html:errors property="frmRegDonorEmail" />
						</td>
					</tr>
					
					<tr height="40px">	
						<td>Address</td>
						<td>
							<html:text property="frmRegDonorAddress"></html:text>
							<font color="red">***	</font>
						</td>
						<td>
						<html:errors property="frmRegDonorAddress"/>
						</td>
					</tr>
					
					
					<tr height="40px">	
						<td>Comment</td>
						<td>
							<html:textarea property="frmRegDonorComment"></html:textarea>
						</td>
					</tr>
					<tr height="40px">	
						<td colspan="3" align="center">
							<html:submit property="btnDonate" value="Donate" onclick="ShowHideDiv()" styleId= "buttonwto"></html:submit>
						</td>
					</tr>
					
					
					</table>
					</td>
					</tr>
				</table>
					
				</logic:empty>
				
				<logic:notEmpty property="frmRegFormControl" name="DonorRegFormBean">
					<table align="center">

						<tr height="40px">
							
							<td colspan="2"><html:radio property="radioTest" value="0"
									styleId="chkOnce" onclick="ShowHideDiv()" disabled="true">OnlyOnce</html:radio>
								&nbsp;&nbsp;&nbsp; <html:radio property="radioTest" value="1"
									styleId="chkMonth" onclick="ShowHideDiv()" disabled="true">Monthly</html:radio>
								&nbsp;&nbsp;&nbsp; <html:radio property="radioTest" value="2"
									styleId="chkYear" onclick="ShowHideDiv()" disabled="true">Yearly</html:radio>
							</td>
						</tr>
						<logic:notEmpty property="frmRadioControlMonth" name="DonorRegFormBean">
							<tr><td>From Months</td>
							<td>
							${DonorRegFormBean.monthlyFee }
						</td>
						</tr>
						<tr><td>To Months</td>
							<td>
							${DonorRegFormBean.monthlyFee1 }
						</td>
						</tr>
						</logic:notEmpty>
						<logic:notEmpty property="frmRadioControlYear"
							name="DonorRegFormBean">
							<tr><td>From Years</td>
							<td>
							${DonorRegFormBean.yearlyFee }
						</td>
						</tr>
						<tr><td>To Years</td>
							<td>
							${DonorRegFormBean.yearlyFee1 }
						</td>
						</tr>
						</logic:notEmpty>
						<tr height="40px">
						<td>What You Want To Donate  </td>
						<td>
							
								<html:text property="frmRegCategory" disabled ="true"/>
						</td>
						<td width="250">
							
						</td>
				</tr>
				
				<tr><td colspan="3"><h3 align="left" style="font-size: 18px; color: #366b82; text-shadow: 0 5px 3px rgba(0,0,0,0);">Cradit Card Information</h3> </td>
				<tr>	
					<td>Amount</td>
					<td>
						<html:text property="frmRegAmount" disabled ="true"></html:text>
						
					</td>
					<td width="250">
				</tr>
				
				<tr height="40px">	
					<td>Credit Card</td>
					<td>
						<html:text property="frmRegDonorCreditCard" disabled ="true"></html:text>
						
					</td>
					<td>
					</td>
				</tr>
				
				<tr height="40px">						<td>Credit Card Type</td>
						<td><html:text property="frmRegCreditCardType" disabled ="true"/>
			</td>
						<td></td>

					</tr>
				
				<tr height="40px">
					<td>Card Holder</td>
					<td><html:text property="frmRegCardHolder" disabled ="true"></html:text>
					 
					 </td>
					 <td>
					</td>
				</tr>
				
				<tr height="40px">
					<td>Expired Date</td>
					<td>
						<html:text property="frmRegCardExpireDate"
									styleId="calendar" maxlength="10" size="10" disabled ="true"/> 
								</td>
								 <td>
								
								</td> 
					</tr>
					<tr></tr>
					<tr><td colspan="3"><h3 align="left" style="font-size: 18px; color: #366b82; text-shadow: 0 5px 3px rgba(0,0,0,0);">Your Information</h3></td></tr>
					<tr height="40px">	
						<td >Name</td>
						<td >
							<html:text property="frmRegDonorName" disabled ="true"></html:text>
						
						</td>
						<td ></td>
					</tr>
					
					<tr height="40px">	
						<td>NRC</td>
						<td>
							<html:text property="frmRegDonorNRC" disabled ="true"></html:text>
							
						</td>
						<td></td>
					</tr>
					
					<tr height="40px">	
						<td>Phone</td>
						<td>
							<html:text property="frmRegDonorPhone" disabled ="true"></html:text>
							
						</td>
						<td></td>
					</tr>
					
					<tr height="40px">	
						<td>Email</td>
						<td>
							<html:text property="frmRegDonorEmail" disabled ="true"></html:text>
							
						</td>
						<td>
						
						</td>
					</tr>
					
					<tr height="40px">	
						<td>Address</td>
						<td>
							<html:text property="frmRegDonorAddress" disabled ="true"></html:text>
							
						</td>
						<td>
						
						</td>
					</tr>
					
					
					<tr height="40px">	
						<td>Comment</td>
						<td>
							<html:textarea property="frmRegDonorComment" disabled ="true"></html:textarea>
						</td>
					</tr>

						
						<tr>
							<td colspan="2" align="center"><html:submit
									property="DonorConfirm" value="Confirm" styleId= "buttonwto" onclick="myFunction()" ></html:submit>
								<html:submit property="btnCancel" value="Cancel" styleId= "buttonwto"></html:submit>
							</td>
						</tr>
					</table>
				</logic:notEmpty>
				</div>
	</div>
	</center>
			</html:form>
			
	
		<footer><%@include file="inc/footer.jsp"%></footer>
</body>
</html:html>