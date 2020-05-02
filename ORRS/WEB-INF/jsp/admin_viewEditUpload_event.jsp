<%@ include file="inc/common.jsp"%>
<%@include file="inc/banner1.jsp"%>
<html>
<head>
<title>Admin Event Upload</title>

<script type="text/javascript" src="js/jquery.min.js"></script>


<script type="text/javascript">
	var clickedOnce = 0;

	function test() {

		clickedOnce = 1;
		document.getElementById('testme').submit();
		document.getElementById('anchorID').className = "disabled";

	}
</script>
<style>
.not-active {
	pointer-events: none;
	cursor: default;
}

.disabled {
	pointer-events: none;
	cursor: default;
	opacity: 0.6;
}
</style>
<style type="text/css">
div {
	float: left;
}

.banner {
	background: url(images/bnr3.jpg) no-repeat 0px 0px;
	background-size: cover;
	min-height: 600px;
	padding-top: 20em;
	text-align: center;
	width: 100%;
}

.banner h2 {
	color: #fff;
	font-size: 7em;
	font-family: 'Dosis-Bold';
}

.slider {
	position: relative;
	text-align: center;
}

.rslides {
	position: relative;
	list-style: none;
	overflow: hidden;
	width: 100%;
	padding: 0;
	margin: 0;
}

.rslides h2 {
	color: #fff;
	font-size: 2em;
	width: 70%;
	margin: 0 auto;
	letter-spacing: 2px;
	text-transform: uppercase;
}

.rslides h3 {
	color: #fff;
	font-size: 1.5em;
	margin-top: 1em;
	text-transform: uppercase;
}

.rslides li {
	-webkit-backface-visibility: hidden;
	position: absolute;
	display: none;
	width: 100%;
	left: 0;
	top: 0;
}

.rslides li:first-child {
	position: relative;
	display: block;
	float: left;
}

.callbacks_tabs a:after {
	content: "\f111";
	font-size: 0;
	font-family: FontAwesome;
	visibility: visible;
	display: block;
	height: 11px;
	width: 11px;
	display: inline-block;
	border: 2px solid #fff;
	border-radius: 50%;
	background: #fff;
}

.callbacks_here a:after {
	border: 2px solid #FFF;
	background: transparent;
}

.callbacks_tabs a {
	visibility: hidden;
}

.callbacks_tabs li {
	display: inline-block;
}

ul.callbacks_tabs.callbacks1_tabs {
	position: absolute;
	bottom: -100%;
	z-index: 999;
	left: 44%;
}

.pre-scrollable {
	max-height: 340px;
	overflow-y: scroll;
}

.container {
	padding-right: 1px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto;
	display: inline-block;
}

.mainbody {
	float: left;
	min-width: 900px;
	min-height: 580px;
	/* background: #eee; */
	background-color: #FFFFFF;
	width: 75%;
	text-align: center;
}

table.body {
	min-width: 800px;
	align: center;
}

th,td {
	padding: 5px;
}

table.body tr:nth-child(even) {
	background-color: #C0D7E1;
}

#outer {
	width: 100%;
	text-align: center;
}

#inner {
	display: inline-block;
}

body {
	background-color: #052645;
}

.mainbanner {
	float: left;
	/* min-width:900px;
min-height:580px; */
	/* background: #eee; */
	width: 75%;
	text-align: center;
}
</style>
</head>

<body>
	<div class="mainbanner">
		<h1 align="center"
			style="font-size: 25px; color: #f0f0f0; text-shadow: 0 3px 3px rgba(255, 255, 255, 255);">Orphan
			Relief And Rescue System</h1>
	</div>
	<div class="mainbody" width="100%" height="auto">
		<div class="container">

			<SCRIPT>
				$(document)
						.ready(
								function() {
									var showChar = 50;
									var ellipsestext = "...";
									var moretext = "more";
									var lesstext = "less";
									$('.more')
											.each(
													function() {
														var content = $(this)
																.html();

														if (content.length > showChar) {

															var c = content
																	.substr(0,
																			showChar);
															var h = content
																	.substr(
																			showChar - 1,
																			content.length
																					- showChar);

															var html = c
																	+ '<span class="moreelipses">'
																	+ ellipsestext
																	+ '</span>&nbsp;<span class="morecontent"><span>'
																	+ h
																	+ '</span>&nbsp;&nbsp;<a href="" class="morelink">'
																	+ moretext
																	+ '</a></span>';

															$(this).html(html);
														}

													});

									$(".morelink").click(function() {
										if ($(this).hasClass("less")) {
											$(this).removeClass("less");
											$(this).html(moretext);
										} else {
											$(this).addClass("less");
											$(this).html(lesstext);
										}
										$(this).parent().prev().toggle();
										$(this).prev().toggle();
										return false;
									});
								});
			</SCRIPT>
			<script>
function myFunction() {
    alert("You have Uploaded successfully!");
}
</script>

			<html:form action="/btnNext">
				<div class="container">
					<logic:notEmpty property="adminEventList"
						name="AdminEventFormBean1">
						<table align="center">
							<tr>
								<td><h3>
										<b><font color="darkblue">Story And Activity</font></b>
									</h3></td>
							</tr>

							<%-- <logic:notEmpty property="userEventList" name="SearchEventFormBean"> --%>



							<div class="container">
								<c:forEach var="i" begin="${AdminEventFormBean1.begin}"
									end="${AdminEventFormBean1.end}">
									<c:if test="${i%2==0 }">
										<tr>
											<td><html:img
													src="${AdminEventFormBean1.eventViewFile[i-1]}"
													height="250" width="400" /></td>
											<td><div class="comment more">${AdminEventFormBean1.adminEventList[i-1].event.eventText}
												</div></td>
										</tr>
										<tr><td>Uploaded Date: &nbsp;&nbsp;${AdminEventFormBean1.adminEventList[i-1].event.eventDate}</td></tr>
										<c:if
											test="${AdminEventFormBean1.adminEventList[i-1].event.permitStatus==0}">
											<tr>
												<td><a
													href="adminEditEvent.do?frmEditEventImgPath=${AdminEventFormBean1.eventViewFile[i-1]}&frmEditEvent=${AdminEventFormBean1.adminEventList[i-1].id}&frmControl=2">
														<span style="color: blue">Click here to Edit</span>
												</a> <a
													href="adminUploadEvent.do?frmUploadEvent=${AdminEventFormBean1.adminEventList[i-1].id}&frmControl=4"
													onclick="myFunction()">Post</a></td>


												<%-- <a href="adminUploadEvent.do?frmUploadEvent=${AdminEventFormBean1.adminEventList[i-1].id}&frmControl=4" onclick="clickAndDisable(this);">Click
													here</a></td> --%>



											</tr>
										</c:if>
										<c:if
											test="${AdminEventFormBean1.adminEventList[i-1].event.permitStatus==1}">
											<tr>
												<td><a
													href="adminEditEvent.do?frmEditEventImgPath=${AdminEventFormBean1.eventViewFile[i-1]}&frmEditEvent=${AdminEventFormBean1.adminEventList[i-1].id}&frmControl=2"><span
														style="color: blue">Click here to Edit</span></a> <span
													style="color: gray">Already Posted</span></td>
											</tr>
										</c:if>
										<tr>
											<td height="70"></td>
										</tr>

									</c:if>
									<!-- <hr style="color:gray"> -->
									<c:if test="${i%2!=0 }">
										<tr>
											<td><div class="comment more">${AdminEventFormBean1.adminEventList[i-1].event.eventText}</div></td>
											<td><html:img
													src="${AdminEventFormBean1.eventViewFile[i-1]}"
													height="250" width="400" />
											<td>
										</tr>
										<tr ><td  colspan="2" align="right">Uploaded Date: &nbsp;&nbsp;${AdminEventFormBean1.adminEventList[i-1].event.eventDate}</td></tr>
										<c:if
											test="${AdminEventFormBean1.adminEventList[i-1].event.permitStatus==0}">
											<tr>
												<td colspan="2" align="right"><a
													href="adminEditEvent.do?frmEditEventImgPath=${AdminEventFormBean1.eventViewFile[i-1]}&frmEditEvent=${AdminEventFormBean1.adminEventList[i-1].id}&frmControl=3"><span
														style="color: blue">Click here to Edit</span></a> <a
													href="adminUploadEvent.do?frmUploadEvent=${AdminEventFormBean1.adminEventList[i-1].id}&frmControl=5"
													onclick="myFunction()">Posted</a></td>

											</tr>
										</c:if>
										<c:if
											test="${AdminEventFormBean1.adminEventList[i-1].event.permitStatus==1}">
											<tr>
												<td colspan="2" align="right"><a
													href="adminEditEvent.do?frmEditEventImgPath=${AdminEventFormBean1.eventViewFile[i-1]}&frmEditEvent=${AdminEventFormBean1.adminEventList[i-1].id}&frmControl=3"><span
														style="color: blue">Click here to Edit</span></a> <span
													style="color: gray">Already Posted</span>
											</tr>
										</c:if>

										<tr>
											<td height="70"></td>
										</tr>

									</c:if>
								</c:forEach>
							</div>

						</table>

						<!--  for btn -->

						<table align="center">
							<tr>
								<td>
									<div align="center">
										<c:if test="${AdminEventFormBean1.prevBtn}">
											<html:submit property="prev" value="&nbsp;Previous&nbsp;"
												styleId="buttonwto">
											</html:submit>
										</c:if>
									</div>
								</td>
								<td>
									<div align="center">
										<c:if test="${AdminEventFormBean1.nextBtn}">
											<html:submit property="next" value="&nbsp;Next&nbsp;"
												styleId="buttonwto">
											</html:submit>
										</c:if>
									</div>
								</td>
							</tr>
						</table>
					</logic:notEmpty>
				</div>

			</html:form>
		</div>
	</div>

	<footer>
		<%@include file="inc/footer.jsp"%>
	</footer>
</body>
</html>