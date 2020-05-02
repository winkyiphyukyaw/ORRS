<%-- <%@include file="inc/banner.jsp"%> --%>
<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>
<link href="css/style3.css" rel='stylesheet' type='text/css' />
<script type="text/javascript">
	// should be in the "onload" of the body
	function createAutoCompleter() {
		new Autocompleter.DWR("frmDonorName1", "choices1",
				populateAutocomplete, {
					afterUpdateElement : donorSelected,
					valueSelector : donorValueSelector
				});
	}
	// the callback for the auto completer
	function populateAutocomplete(autocompleter, token) {
		AjaxDonorSearch.getAllDonorName(token, function(suggestions) {
			if (suggestions != null) {
				autocompleter.setChoices(suggestions);
			}
		});
	}
	//this function extractes string from sample object for matching
	function donorValueSelector(DonorCategory) {

		return DonorCategory.donor.donorName;
	}
	//this function is fired when users selects sample from list
	function donorSelected(inputElement, selectedElement, DonorCategory) {

		dwr.util.setValue("frmDonorName1", DonorCategory.donor.donorName);
		
	}
	
//-->
</script>

<!-- <link href="css/library.css" rel="stylesheet" type="text/css">
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
<script src='dwr/interface/AjaxDonorSearch.js'></script>

<title>Donor List Page</title>


</head>
<body  onload="DWRUtil.useLoadingMessage(); createAutoCompleter()">


<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1> </div>
<div class="mainbody">
		
			<html:form action="/adminDonorPath">
			<center>
			<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Donor List</h2>
			<table >
					<tr align ="center">
							<td>Donor Name :&nbsp;</td>
							<td><html:text property="frmDonorName"
									styleId="frmDonorName1" />
									<div class="choices" id="choices1"></div> 
							</td><td width="10px"></td>
							<td><html:submit property="searchDonor" value="Search" styleId="buttonwto"></html:submit></td>
						</tr>
</table>
<br>
						
						<table class="body">
	
							<tr height="40">
								<th >No.</th>
								<th >Name</th>
								<th  >Phone No</th>
								<th  >NRC</th>
								<th >Address</th>
								<th>Detail Link</th>
							</tr>
							<c:forEach var="i" begin="${AdminDonorFormBean.begin}"
								end="${AdminDonorFormBean.end}">
								<tr>
									<td align="center">${i}</td>
									<td>
										${AdminDonorFormBean.viewDonorList[i-1].donor.donorName}</td>
									<td>${AdminDonorFormBean.viewDonorList[i-1].donor.donorPhNo}</td>
									<td>${AdminDonorFormBean.viewDonorList[i-1].donor.donorNrc}</td>

									<td>
										${AdminDonorFormBean.viewDonorList[i-1].donor.donorAddress}</td>

									<td align="center"><a
										href="adminDonorDetailPath.do?
								detailDonorId=${AdminDonorFormBean.viewDonorList[i-1].donor.id}&donorListControl=2">
											<span style="color:blue;">Detail</span></a></td>
								</tr>
							</c:forEach>




						</table>

						<br>


						<!-- next and previous button control here -->
						<table align="center" width="50%">
							<tr>
								<td  width="8%">
									<div align="center">
										<c:if test="${AdminDonorFormBean.prevBtn}"><html:submit
												property="prev" styleId= "buttonwto" value="&nbsp;Previous" />

										</c:if>
									</div>
								</td>
								<td width="90%"></td>
								<td width="2%">
									<div align="center">
										<c:if test="${AdminDonorFormBean.nextBtn}">
											<html:submit property="next" styleId= "buttonwto" value="&nbsp;&nbsp; Next &nbsp;&nbsp;" />
              			</c:if>
									</div>
								</td>
							</tr>
						</table>


						<%-- </logic:notEmpty> --%>

					</center>
				</html:form>	
		</div>




	
	


	<footer>	
		<%@include file="inc/footer1.jsp" %>
   </footer>
   
</body>
</html>