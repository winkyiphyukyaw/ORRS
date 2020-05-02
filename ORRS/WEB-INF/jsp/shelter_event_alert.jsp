<%@include file="inc/common.jsp"%>
<%@ include file="inc/shelter_banner.jsp" %>
<html:html>
<head>
<meta charset="UTF-8">
<title>No Event Alert</title>


<!-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'> -->

<!-- <link rel="stylesheet" href="css/upload_style.css"> -->
<style> 
 html[type=submit]{
	background-color:pink;
} 
#buttonwto {
    background-color: white;
    color: black;
    border: 2px solid #086A87; 
}

</style>

<style type="text/css">

div{float:left;
}


	.banner{
	background:url(images/bnr3.jpg) no-repeat 0px 0px;
	background-size:cover;
	min-height:600px;
	padding-top:20em;
	text-align:center;
	width:100%;
	
}
.banner h2{
	color:#fff;
	font-size:7em;
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
.rslides h2{
color:#fff;
font-size: 2em;
    width: 70%;
    margin: 0 auto;
	letter-spacing:2px;
	text-transform:uppercase;
}
.rslides h3{
color:#fff;
font-size: 1.5em;
margin-top:1em;
text-transform:uppercase;
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
	height:11px;
	width: 11px;
	display: inline-block;
	border: 2px solid #fff;
	border-radius:50%;
	background:#fff;
}
.callbacks_here a:after{
	border: 2px solid #FFF;
	background:transparent;
}
.callbacks_tabs a{
	visibility:hidden;
}
.callbacks_tabs li{
	display:inline-block;
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

.mainbody{
float:left;
min-width:900px;
min-height:580px;
/* background: #eee; */
background-color:#FFFFFF;
 width: 75%;
  text-align: center;
}
table.body{
min-width:300px;
align:center;}
th, td {

    padding: 3px;
}
table.body tr:nth-child(even){background-color:
#C0D7E1;}



#outer {
  width: 100%;
  text-align: center;
}

#inner {
  display: inline-block;
}
body{background-color:#052645;}


.mainbanner{
float:left;
/* min-width:900px;
min-height:580px; */
/* background: #eee; */

 width: 75%;
  text-align: center;
}
</style>

</head>

<body>
	
<div class="content">
<p>No Event Available!</br>
You can upload event or story from <a href="gotoEventUpload.do?frmControl=2">Here</a></p>

</div>
</body>
</html:html>	