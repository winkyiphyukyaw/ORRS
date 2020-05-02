<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>

<head>

<!-- <meta charset="utf-8" /> -->
<title>Adopter View</title>



<!-- Calling java code -->
<script type="text/javascript">
	// should be in the "onload" of the body
	function createAutoCompleter() {
		new Autocompleter.DWR("frmAdopterSearchName1", "choices1", populateAutocomplete,
				{
					afterUpdateElement : adopterSelected,
					valueSelector : adopterValueSelector
				});
	}
	// the callback for the auto completer
	function populateAutocomplete(autocompleter, token) {
		AjaxAdopterSearch.findAdopterByLikeFromService(token, function(suggestions) {
			if(suggestions!=null){
				autocompleter.setChoices(suggestions);
			}
		});
	}
	//this function extractes string from sample object for matching
	function adopterValueSelector(Adopter) {
			
			return Adopter.adopterName;	
	}
	//this function is fired when users selects sample from list
	function adopterSelected(inputElement, selectedElement, Adopter) {
	
		dwr.util.setValue("frmAdopterSearchName1", Adopter.adopterName);
		
	}
//-->
</script>

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
<script src='dwr/interface/AjaxAdopterSearch.js'></script>

</head>
<body onload="DWRUtil.useLoadingMessage(); createAutoCompleter()">
<div class="mainbanner">
<h1 align="center"
		style="font-size: 30px; color: white; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1></div>
<div class="mainbody">

			<html:form action="/adopterSearch">
			<!-- <center>
			<div class="divbodyborder">
			<div class="maincontainer"> -->
			
			<center>
			
			<h2  style=" padding-left:20px;font-size: 20px;color:#366b82; text-shadow: 0 5px 3px rgba(0, 0, 0, .3);">Adopter List</h2>
			<table>
				<tr>
					<td><b>Adopter Name:</td>
					<td><html:text property="frmAdopterSearchName" styleId="frmAdopterSearchName1" />
					<div class="choices" id="choices1"></div>
					</td><td width="10px"></td>
					<td><html:submit property="btnSearch" value="Search" styleId= "buttonwto"></html:submit></td>
				</tr>
			
			</table>
			</center>
			<br>
			
			
					<logic:notEmpty property="frmAdopterList" name="AdopterViewFormBean">
				
					<center>
					 <table class="body"  border="1" width="80%">
						
						<tr>
							<th width="10px">No.</th>
							<th>Name</th>
							<th >Email</th>
							<!-- <td align="center"><font color="#086A87"><b>Phone Number</b></font></td> -->
							<th >Adopted Status</th>
							<th>Detail Link</th>
						</tr>
						<c:forEach var="i" begin="${AdopterViewFormBean.begin}" end="${AdopterViewFormBean.end}">
							<tr>
							<td align="center" >
							${i}
							</td>
							<td>
							${AdopterViewFormBean.frmAdopterList[i-1].adopterName}</td>
							<td>
							${AdopterViewFormBean.frmAdopterList[i-1].adopterEmail}</td>
														
							<td> 
							<c:if test="${AdopterViewFormBean.frmAdopterList[i-1].adoptedChildNo eq 0}">
							Not Yet Adopted
							</c:if>
							<c:if test="${AdopterViewFormBean.frmAdopterList[i-1].adoptedChildNo eq 1}">
							Adopted
							</c:if>
							</td>
							<td align="center"><a href="adopterViewDetailPath.do?
								frmDetailAdopterId=${AdopterViewFormBean.frmAdopterList[i-1].id}&frmControl=2"><font color="blue">Detail</font></a></td>
								</tr>
								
								
					
					</c:forEach>
					
					<c:if test="${AdopterViewFormBean.actualPage eq AdopterViewFormBean.finalPage}">
					
						</c:if>
					</table>
					
					</center>
					<br>
					<center>
					<table width="50%" >
					<tr>
					<td width="20%"></td>
						<td width="20%" >
					
						<c:if
							test="${AdopterViewFormBean.prevBtn}">
                                   <html:submit property="prev"
								styleId= "buttonwto" value="Previous">
							</html:submit><font color="#086A87"></font>
						</c:if>
						
						</td>
						<td width="20%" ></td>
						<td width="20%" >
						<c:if
							test="${AdopterViewFormBean.nextBtn}">
							<html:submit property="next" styleId= "buttonwto" value="&nbsp;&nbsp; Next &nbsp;&nbsp;">
							</html:submit>
							<font color="#086A87"></font>
              			</c:if>
						</td>
						<td width="20%"></td>
					</tr>
				</table>
				</center>
					</logic:notEmpty>
<!-- </div>
</div>
</center> -->
				</html:form>
					<!-- </td>
		</tr> -->
		
		</div>
		
	<footer>	
		<%@include file="inc/footer1.jsp" %>
   </footer>
</body>
</html>