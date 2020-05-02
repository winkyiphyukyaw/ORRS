<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>
<title>Orphan List</title>



<script type="text/javascript">
	// should be in the "onload" of the body
	function createAutoCompleter() {
		new Autocompleter.DWR("adminOrphanShelterName1", "choices1", populateAutocomplete,
				{
					afterUpdateElement : shelterNameSelected,
					valueSelector : shelterNameValueSelector
				});
	}
	// the callback for the auto completer
	function populateAutocomplete(autocompleter, token) {
		AjaxShelterNameSearch.findShelterNameByLikeFromService(token, function(suggestions) {
			if(suggestions!=null){
				autocompleter.setChoices(suggestions);
			}
		});
	}
	//this function extractes string from sample object for matching
	function shelterNameValueSelector(Shelter) {
			
			return Shelter.shelterName;	
	}
	//this function is fired when users selects sample from list
	function shelterNameSelected(inputElement, selectedElement, Shelter) {
	
		dwr.util.setValue("adminOrphanShelterName1", Shelter.shelterName);
		
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



<script src='dwr/interface/AjaxShelterNameSearch.js'></script>




<!-- <link href="css/library.css" rel="stylesheet" type="text/css"> -->
</head>
<body onload="DWRUtil.useLoadingMessage(); createAutoCompleter()">
<div class="mainbanner">
		<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
	</div>
<div class="mainbody" >
		



	
		<html:form action="/orphanSearch">
		<!--Correct  -->
		<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Orphan List</h2>
		<center>
			  <table ><tr>
					<td>Shelter Name:</td>
					<td><html:text property="adminOrphanShelterName" styleId="adminOrphanShelterName1" />
					<div class="choices" id="choices1"></div>
					</td><td width="10px"></td>
					<td><html:submit property="btnSearch" value="Search" styleId= "buttonwto"></html:submit></td></tr>
					
			
				<tr><td></td><td><html:errors property="searchShelterError"/></td></tr>
				
			</table>
			</center>
			<!--  -->
			<br>
		<center>
		<table><tr><td width="20%"></td><td width="60%">
		<html:errors property="noOrphanErr"/></td>
			<logic:notEmpty property="adminOrphanList" name="AdminViewOrphanFormBean">
			<center>
			<table class="body"  border="1">
			
			          <tr>
							<th align="center">No.</th>
							<th align="center" width="150px">Orphan Name</th>
							<th align="center" width="180px">Shelter Name</th>						
							<th align="center" width="150px">Adoption Status</th>
							<th> Detail Link</th>
						</tr>
					
					<c:forEach var="i" begin="${AdminViewOrphanFormBean.begin}" end="${AdminViewOrphanFormBean.end}">
					<tr>
							<td align="center">${i}</td>
							
							<td>${AdminViewOrphanFormBean.adminOrphanList[i-1].orphanName}</td>
							<td align="center">${AdminViewOrphanFormBean.adminOrphanList[i-1].shelter.shelterName}</td>
												
							<td align="center">
							
							<c:if test="${AdminViewOrphanFormBean.adminOrphanList[i-1].adoptStatus==0}">
								Not Yet!							 	
							</c:if>
							
							<c:if test="${AdminViewOrphanFormBean.adminOrphanList[i-1].adoptStatus==1}">
							Adopt!
							</c:if>					
							
							</td>
							<td align="center">
							    <a href="AdminViewOrphanDetailPath.do?adminViewOrphanDetailId=${AdminViewOrphanFormBean.adminOrphanList[i-1].id}&adminViewOrphanControl=2">
							    <span style="color:blue">Detail</span></a>	
							</td>						
							
					</tr>
					
					
					
					</c:forEach>
						
					
					
			</table>
			</center>
			
			
			<br>
			<center>
			<table align="center" width="50%" >
			<tr>
			<td width ="45%"><c:if test="${AdminViewOrphanFormBean.prevBtn}">
                            <html:submit property="prev" styleId= "buttonwto" value="&nbsp;Previous&nbsp;">
							</html:submit>
						</c:if></td>
						
						<!-- Correct -->
			<td width ="45%"><%-- <html:submit property="btnHome" value=" &nbsp;Home &nbsp;" styleId= "buttonwto"></html:submit> --%></td>
			            <!--  -->
			<td><c:if test="${AdminViewOrphanFormBean.nextBtn}">
							<html:submit property="next" styleId= "buttonwto" value=" &nbsp;&nbsp; Next &nbsp;&nbsp;">
							</html:submit>
              			</c:if></td>
			</tr></table>	</center>
			 
			 </logic:notEmpty>
			 
			 
			<td width="20%"></td></tr></table></center>
		</html:form>
		
</div>

<footer>	
		<%@include file="inc/footer1.jsp" %>
   </footer>

</body>
</html>
