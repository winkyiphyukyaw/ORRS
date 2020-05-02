
<%@ include file="common.jsp"%>
<html:html>
<head>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style1.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.min.js"></script>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Charity Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 



</script>
<style>
#wrap ul.navbar li a:active {
	color: #FF00CC
}

ul {
	margin: 0;
	padding: 0;
}

.logo {
	margin-top: 0;
	padding-top: 0;
	/* background-color: #366b82; */
	background-color: #efefef;
	color: #366b82;
	font-size: 30px;
	text-shadow: 0 3px 3px rgba(0, 0, 0, 5);
	font-family: Dosis-regular
}

#header {
	/* background-color: #366b82; */
	
}

#wrap {
	width: 100%; /* Spans the width of the page */
	height: 70px;
	padding: 0;
	margin: 0;
	/* Ensures there is no space between sides of the screen and the menu */
	/* z-index: 99; */
	/* Makes sure that your menu remains on top of other page elements */
	/* position: relative; */
	background-color: #366b82;
}

.navbar {
	/* 	float:center;
	padding-right: 15px;
  padding-left: 15px; */
	height: 50px;
	padding: 0;
	margin: 0;
	position: absolute;
	/* float:center; */
	padding-right: 5%;
	padding-left: 5%;
	/* Ensures that the menu doesn’t affect other elements */
	/* border-right: 1px solid #54879d; 
	border-buttom:1px solid #54879d; */
}

.navbar li {
	height: auto;
	width: 120px; /* Each menu item is 150px wide */
	float: left; /* This lines up the menu items horizontally */
	text-align: center; /* All text is placed in the center of the box */
	list-style: none;
	/* Removes the default styling (bullets) for the list */
	font: normal bold 20px/1.2em Arial, Verdana, Helvetica;
	padding: auto;
	margin: 0;
	background-color: #366b82;
}

.navbar a {
	padding: 18px 0;
	/* Adds a padding on the top and bottom so the text appears centered vertically */
	/* border-left: 1px solid #54879d; */
	/* Creates a border in a slightly lighter shade of blue than the background.  Combined with the right border, this creates a nice effect. */
	/* border-right: 1px solid #1f5065; */
	/* Creates a border in a slightly darker shade of blue than the background.  Combined with the left border, this creates a nice effect. */
	text-decoration: none; /* Removes the default hyperlink styling. */
	color: white; /* Text color is white */
	display: block;
}

.navbar li ul {
	display: none; /* Hides the drop-down menu */
	height: auto;
	margin: 0; /* Aligns drop-down box underneath the menu item */
	padding: 0; /* Aligns drop-down box underneath the menu item */
}

.navbar li:hover ul {
	background-color: #366b82;
	display: block;
	/* Displays the drop-down box when the menu item is hovered over */
	transition: all 1.9s ease;
}

.navbar a:hover {
	text-decoration: none;
	background-color: #366b82;
	color: gold;
	display: block;
	/* Displays the drop-down box when the menu item is hovered over */
	transition: all 1.9s ease;
}

.navbar li ul li {
	background-color: white;
}

.navbar li ul li a {
	/* border-left: 1px solid #1f5065; 
		border-right: 1px solid #1f5065; 
		border-top: 1px solid #74a3b7;  */
	text-decoration: none;
	display: block;
}

.navbar li ul li a:hover {
	background-color: #366b82;
	transition: all 1.9s ease;
}

.glyphicon {
	top: -8px;
	display: block;
}

.glyphicon-asterisk,.glyphicon-flag {
	color: #C7C7C7;
	font-size: 20px;
}

.glyphicon-icon {
	position: relative;
	top: 33px;
	display: block;
	font-family: 'Glyphicons Halflings';
	font-style: normal;
	font-weight: normal;
	text-align: center;
	line-height: 1;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	z-index: 999;
}

.glyphicon-menu-right:before {
	color: #333;
	content: "\e258";
}

.container {
  padding-right: 80px;
  padding-left: 80px; 
	/*  margin-top:5px; */
	width: 100%;
	height: 69%;
	background-color: #efefef;
}

.maincontainer {
	/*  padding-right: 15px;
  padding-left: 15px; */
	/*  margin-top:5px; */
	min-height: 440px;
	width: 90%;
	height: auto;
	/* background-color: #dfdfef; */
	background-color: #f2f1ef; 
	/* border: 5px double #086A87; */
	border-raius: 5px;
	 padding: 5px; 
}

.divbodyborder {
  padding: 10px;  
	background-color:#d8d7d6;
}

table.bodyborder {
	/* border: 2px solid #086A87; */
	/* background-color: #f0f000; */
	padding: 10px;
}

}
body {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
	background-color: #efefef;
	font-family: Verdana, sans-serif;
}

}

/* for donate */
.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
	height: auto;
	width: 128px; /* Each menu item is 150px wide */
	float: left; /* This lines up the menu items horizontally */
	text-align: center; /* All text is placed in the center of the box */
	list-style: none;
	/* Removes the default styling (bullets) for the list */
	font: normal bold 15px/1.2em Arial, Verdana, Helvetica;
	padding: auto;
	margin: 0;
	background-color: #366b82;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #366b82;
	/* min-width: 160px; */
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	height: auto;
	margin: 0; /* Aligns drop-down box underneath the menu item */
	padding: 0; /* Aligns drop-down box underneath the menu item */
}

.dropdown-content a {
	/* color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block; */
	text-decoration: none;
	background-color: #366b82;
	color: white;
	display: block;
}

.dropdown-content a:hover {
	background-color: #366b82 transition: all 5.5s ease;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}

select {
	width: 200px;
}

text {
	width: 200px;
}

textarea {
	width: 200px;
}

.myBox {
	height: 645px;
	overflow: scroll;
}

submit {
	color: gray;
}

#buttonwto {
	background-color: #366b82;
	color: white;
	border: 2px solid #086A87;
	width: 100px;
	/* box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19); */
	box-shadow: 0 4px 4px 0 gray;
	cursor: pointer;
	border-radius: 5px;
}

ul li.active a,ul li a:hover {
	color: gold; /* #000000; */
	transition: all .3s ease;
}

.comment {
	width: 400px;
	background-color: #f0f0f0;
	margin: 10px;
}

a.morelink {
	text-decoration: none;
	color: blue;
	outline: none;
}

.morecontent span {
	display: none;
}

input[type=text] {
	height: 30px;
	box-sizing: border-box;
	width: 200px;
}

input[type=password] {
	height: 30px;
	width: 200px;
	box-sizing: border-box;
}

select {
	height: 30px;
	width: 200px;
}
</style>
</head>
<body>



</body>
</html:html>