<%@ include file="inc/banner.jsp" %>
<%@ include file="inc/common.jsp"%>
<html>
<head>
<title>News and Event</title>

<script type="text/javascript" src="js/jquery.min.js"></script>

</head>
<body>

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
			
			<li class="active"><div class="dropdown"><a href="EventPath.do"><span
					class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
					Activity</a></div></li>

			<!-- <li><a href="#"><span class="glyphicon glyphicon-gift"
						aria-hidden="true"></span> Donate</a>
					<ul>
						<li><a href="donorShelterFirstPath.do">Direct to Shelter</a></li>
						<li><a href="donorDirectFirstPath.do">Direct to
								Foundation</a></li>
					</ul></li> -->
			<li><div class="dropdown">
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
	<div class="clearfix"></div>
<SCRIPT>
$(document).ready(function() {
	var showChar = 100;
	var ellipsestext = "...";
	var moretext = "read more";
	var lesstext = "less";
	$('.more').each(function() {
		var content = $(this).html();

		if(content.length > showChar) {

			var c = content.substr(0, showChar);
			var h = content.substr(showChar-1, content.length - showChar);

			var html = c + '<span class="moreelipses">'+ellipsestext+'</span>&nbsp;<span class="morecontent"><span>' + h + '</span>&nbsp;&nbsp;<a href="" class="morelink">'+moretext+'</a></span>';

			$(this).html(html);
		}

	});

	$(".morelink").click(function(){
		if($(this).hasClass("less")) {
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


 <html:form >
 <center>
 <div class="divbodyborder">
<div class="maincontainer">
 <h1 align="center"
		style="font-size: 20px; color: #366b82; text-shadow: 0 1px 1px rgba(0,0,0,5);">News And Activity what We do</h1>
 <logic:notEmpty property="userEventList" name="EventFormBean">
		<table class="bodyborder" >
			<!-- <tr>
				<td><h3 width="50" style="color:#366b82">
						<b>News And Activity what We do</b>
					</h3></td>
			</tr> -->

			<%-- <logic:notEmpty property="userEventList" name="SearchEventFormBean"> --%>
			<tr>
			<tr>
			
			
				<c:forEach var="i" begin="${EventFormBean.begin}"
					end="${EventFormBean.end}">
					<c:if test="${i%2==0 }">
					<tr>
						<td cellspacing="1000"><html:img
								src="${EventFormBean.eventViewFile[i-1]}" height="250"
								width="400" />
						
						
						<td><div class="comment more">${EventFormBean.userEventList[i-1].event.eventText}</div></td>
					</tr>
					<tr>
						<td height="70"></td>
					</tr>
					</c:if>
					<c:if test="${i%2!=0 }">
					<tr>
					    <td><div class="comment more">${EventFormBean.userEventList[i-1].event.eventText}</div></td>
						<td cellspacing="1000"><html:img
								src="${EventFormBean.eventViewFile[i-1]}" height="250"
								width="400" />
						<td>
						
						
					</tr>
					<tr>
						<td height="70"></td>
					</tr>
					</c:if>
				</c:forEach>
				
				
			</tr>
			</tr>
		</table>

		<!--  for btn -->
    
    <table width="50%">
			<tr>
				<td width="30%">
					<div align="center">
						<c:if test="${EventFormBean.prevBtn}">
                                   <html:submit property="prev"
								value="Previous" styleId="buttonwto">
							</html:submit>
						</c:if>
					</div>
				</td>
				<td width="30%"></td>
				<td width="30%">
					<div align="center">
						<c:if test="${EventFormBean.nextBtn}">
							<html:submit property="next" value="Next" styleId="buttonwto">
							</html:submit>
              			</c:if>
					</div>
				</td>
			</tr>
		</table>
		
		
				
      
    
    
    
    
      
         
     </logic:notEmpty>
    </div></div>
    </center>
     </html:form>
    
    <footer>
   
		<%@include file="inc/footer.jsp"%>
		</footer>

	
</body>
</html>