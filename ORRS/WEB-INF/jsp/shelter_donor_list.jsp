

<%@ include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp"%>
<html>
<head>
<title>Donor List Page</title>
	
</head>

<%-- <%@ include file="inc/left_menu.jsp"%>
		<td>
		<h3 align="center">ICTTI Frame Work Lecturesaaaa</h3> --%>
<%-- <html:form > --%>




<script type="text/javascript">
	// should be in the "onload" of the body
	function createAutoCompleter() {
		new Autocompleter.DWR("frmDonorName1", "choices1",
				populateAutocomplete, {
					afterUpdateElement : donorNameSelected,
					valueSelector : donorNameValueSelector
				});
	}
	// the callback for the auto completer
	function populateAutocomplete(autocompleter, token) {
		AjaxDonorNameSearch.getAllDonorByShelterName(token, function(
				suggestions) {
			if (suggestions != null) {
				autocompleter.setChoices(suggestions);
			}
		});
	}
	//this function extractes string from sample object for matching
	function donorNameValueSelector(DonorShelter) {

		return DonorShelter.donor.donorName;
	}
	//this function is fired when users selects sample from list
	function donorNameSelected(inputElement, selectedElement, DonorShelter) {

		dwr.util.setValue("frmDonorName1", DonorShelter.donor.donorName);

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
<!-- /*Correct  */ -->
<!-- Declare the javascript for scriptaculous -->
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/effects.js"></script>
<script type="text/javascript" src="js/controls.js"></script>
<script type="text/javascript" src="js/scriptaculous.js"></script>
<script type='text/javascript' src="js/autocompleteex.js"></script>
<!-- Declare the javascript for DWR -->
<script src='dwr/engine.js'></script>
<script src='dwr/util.js'></script>

<!-- /*Own js  */ -->

<script src='dwr/interface/AjaxDonorNameSearch.js'></script>





<body   onload="DWRUtil.useLoadingMessage(); createAutoCompleter()">
<div class="mainbanner"><h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1></div>
	<div class="mainbody">
		
			<h1
				style="padding-left: 20px; font-size: 20px; color: #366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Donor
				List</h1>







			<html:form action="/shelterDonorPath">
				<center>
					<table>
						<tr align="center">
							<td>Donor Name</td>
							<td><html:text property="frmDonorName"
									styleId="frmDonorName1" /> <%-- <html:text property ="frmDonorName" /> --%>
								<div class="choices" id="choices1"></div></td>
							<td><html:submit property="btnSearch" value="Search" styleId="buttonwto"></html:submit></td>
						</tr>
					</table>
				</center>
				<!--  -->


<br>

				<center>
					<table class="body" border="1">

						<tr height="40">
							<th width="40">No</th>
							<th width="80">Name</th>
							<th width="80">Phone No</th>
							<th width="80">NRC</th>
							<th width="80">Address</th>
							<th width="80"></th>

						</tr>
						<c:forEach var="i" begin="${ShelterDonorFormBean.begin}"
							end="${ShelterDonorFormBean.end}">
							<tr>
								<td>${i}</td>
								<td>
									${ShelterDonorFormBean.viewDonorList[i-1].donor.donorName}</td>
								<td>
									${ShelterDonorFormBean.viewDonorList[i-1].donor.donorPhNo}</td>
								<%-- <td>
							<c:if test="${ShelterDonorFormBean.viewDonorList[i-1].donor.kindOfDonate eq 0}">
							Only Once
							</c:if>
							<c:if test="${ShelterDonorFormBean.viewDonorList[i-1].donor.kindOfDonate eq 1}">
							Monthly
							</c:if>
							<c:if test="${ShelterDonorFormBean.viewDonorList[i-1].donor.kindOfDonate eq 2}">
							Yearly
							</c:if>
							</td> --%>
								<td>
									${ShelterDonorFormBean.viewDonorList[i-1].donor.donorNrc}</td>
								<td>
									${ShelterDonorFormBean.viewDonorList[i-1].donor.donorAddress}</td>


								<td><a
									href="shelterDonorListDetailPath.do?
								detailDonorId=${ShelterDonorFormBean.viewDonorList[i-1].donor.donorNrc}&donorListControl=2">
										<span style="color:blue">Detail</span></a> <!-- <a href="#"> Detail</a> --></td>
							</tr>
						</c:forEach>




					</table>
				</center>

<br>

				<!-- next and previous button control here -->
				<center>
					<table width="50%">
						<tr>
						<td width="10%" ></td>
							<td width="30%">
								
									<c:if test="${ShelterDonorFormBean.prevBtn}">
										<html:submit property="prev" value="Previous" styleId="buttonwto">
										</html:submit>
									</c:if>
								
							</td>
							<td width="30%" ></td>
							<td width="30%">
								
									<c:if test="${ShelterDonorFormBean.nextBtn}">
										<html:submit property="next" value="Next" styleId="buttonwto">
										</html:submit>
									</c:if>
								
							</td>
						</tr>
					</table>
				</center>





			</html:form>

		</div>
	
	<footer>
		<%@ include file="inc/footer1.jsp"%></footer>
</body>
</html>