<%@include file="inc/banner.jsp"%>



<html>
<head>
<title>Home Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
/* * {box-sizing:border-box}
body {font-family: Verdana,sans-serif;} */
.mySlides {display:none}

/* Slideshow container */
.slideshow-container {
  height:100%;
  width:100%
  position: relative;
  margin: auto;
  
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 250px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 20px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 13px;
  width: 13px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.2s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 5.9s;
  animation-name: fade;
  animation-duration: 5.9s;
}

@-webkit-keyframes fade {
  from {opacity: .01} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .01} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}
</style>
</head>
<body>
<div class="userlogo">
		<h1 align="center"
		style="font-size: 30px; color: #366b82; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
</div>

	<div id="wrap">
		<ul class="navbar">
			<li class="active"><div class="dropdown"><a href="Welcome.do"><span
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
						aria-hidden="true"></span>Donate</a>
				<div class="dropdown-content">
					<a href="donorShelterFirstPath.do">Donate to Shelter</a> 
					<a href="donorDirectFirstPath.do">Donate to Foundation</a></div></div></li>
					
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
	<div class ="divbodyborder">
	 
<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="images/teaser11.jpg" style="width:100%;height:100%;">
  <div class="text"></div>
</div>

<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="images/bnr3.jpg" style="width:100%; height:100%">
  <div class="text"><span style="font-size:45px;color:gold">Let's</span> <span style="font-size:35px;color:gold">build the world with</span><span style="font-size:48px;color:gold"> Our Love</span></div>
</div>

<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="images/mother.jpg" style="width:100%;height:100%;">
  <div class="text"><span style="font-size:45px;color:black">Spread Love</span> <span style="font-size:35px;color:black;">Everywhere</span><span style="font-size:48px;color:black;">You Go</span></div>
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 7000); // Change image every 2 seconds
}
</script>


</div>



	

 
</body>
<footer>
<%@include file="inc/footer.jsp"%>
</footer>

</html>