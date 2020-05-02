<%@include file="inc/banner.jsp"%>
<html:html>
<head>
<title>Contact Us</title>
<!-- Calling java code -->
<script type="text/javascript">
	// should be in the "onload" of the body
	function createAutoCompleter() {
		new Autocompleter.DWR("frmShelterName1", "choices1", populateAutocomplete,
				{
					afterUpdateElement : bookSelected,
					valueSelector : bookValueSelector
				});
	}
	// the callback for the auto completer
	function populateAutocomplete(autocompleter, token) {
		AjaxBooksSearch.getAllShelterName(token, function(suggestions) {
			if(suggestions!=null){
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
			<li><div class="dropdown"><a href="adopterFirstPath.do"><span
					class="glyphicon glyphicon-heart" aria-hidden="true"></span> Adopt</a></div></li>
			<li><div class="dropdown"><a href="AboutPath.do"><span
					class="glyphicon glyphicon-user" aria-hidden="true"></span> About</a></div></li>
			<li class="active"><div class="dropdown"><a href="ContactPath.do"><span
					class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					Contact</a></div></li>
			<li><div class="dropdown"><a href="annualReportPath.do"><span
					class="glyphicon glyphicon-book" aria-hidden="true"></span> Annual
					Report</a></div></li>
		</ul>

	</div>
 <html:form>
 <center>
<div class="divbodyborder">
<div class="maincontainer">
<h1 align="center"
		style="font-size: 20px; color: #366b82; text-shadow: 0 1px 1px rgba(0,0,0,5);">How to Find Us</h1>	
<table border="1" width="100%" >

			
		
			<!-- <h3 class="hdng" align="center" >How to Find Us</h3> -->
			<div class="map" align="center">
					
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15273.725020992932!2d96.12798313795324!3d16.854548170238527!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x9936075ecb6cc22b!2sCICTT!5e0!3m2!1sen!2sin!4v1504602785206" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
			</div>
		
			
			
			<table align="center">
			
				<tr>
				<td style="color:#366b82;">
				Address:Orphan Relief And Rescue Service,ICTTI,Hlaing Campus,Parami Road,Yangon,Myanmar<br>
				Website:www.orrs.ictti.com <br>
				Phone: 01-222222,09-7777777<br>
				Email: orphanrelief&rescueservice@ictti.com<br>
				</td>
				</tr>
				
				
			</table>
			

		
	
</table></div></div></center>
</html:form>

<footer>
		<%@include file="inc/footer.jsp" %></footer>
</body>
</html:html>