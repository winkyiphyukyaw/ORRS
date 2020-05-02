<%@ include file="inc/common.jsp"%>

<html:html>
<head>
<title>ORRS Admin Login</title>
<!-- <link href="css/buttonStyle.css" rel="stylesheet" type="text/css"> -->
<style>
body,html {
	height: 100%;
	margin: 0;
}

.bg {
	/* The image used */
	background-image: url("images/orrs1.PNG");
	/* Full height */
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	
}

.content {
	max-width: 500px;
	margin: auto;
	padding: 100px;
}

text {
	heigh: 50px;
}

form {
	background-color: #ffffff;
	border-radius: 25px;
	border: 1px solid black;
	opacity: 0.6;
	filter: alpha(opacity = 60); /* For IE8 and earlier */
}
.myTable{
	
	font-weight: bold;
    color: #000000;
    opacity:1;
}
input[type=text] {
	height: 30px;
	box-sizing: border-box;
}

input[type=password] {
	height: 30px;
	box-sizing: border-box;
}

#button {
	background-color: #adadad;
	color: green;
	padding: 14px 20px;
	margin: 8px 0;
	border: 1px solid #f1f1f1;
	cursor: pointer;
	border-radius: 13px;
	width: 120px;
	height:50px;
	font-size:14px;
}
}
</style>
</head>
<body>
<div class="bg">
	<div class="content">
	
	
	<html:form action="/loginPath">
	<h1 align="center"
		style="font-size: 30px; color: green; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Orphan
		Relief And Rescue System</h1>
		<h3 align="center" style=" color: green; text-shadow: 3px 3px 3px rgba(255,255,255,255);">Admin Login Page</h3>
		<center>
		<table class="myTable">
			<tr>
				<td style="font-size: 20px;font-weight: bold;
    color: #000000;opacity:1;">Login Name</td>
				<td height="40"><html:text property="adminLoginName" maxlength="30"></html:text> 
				<font color="red">***</font></td></tr>
				<tr>
				<td colspan="2" align="right"><html:errors property="adminLoginName"/></td>

			</tr>
			<tr height=30px>
				<td style="font-size: 20px;font-weight: bold;
    color: #000000;opacity:1;">Password</td>
				<td height="40"><html:password property="adminPassword"></html:password>
				 <font color="red">***</font></td></tr>
			<tr height=30px> 
				 <td colspan="2" align="right"><html:errors property="adminPassword"/>
				 </td>
				
				
			</tr>
			<tr>
			
				<td align="center" colspan="3">
				
				<html:submit property="btnLoging" value="Login" styleId="button"></html:submit>
				</td>
			</tr>
			<tr align="center">
						<td colspan="3"><html:errors property="loginerror" /></td>
					</tr>
			
			
		</table>
		</center>
	</html:form>
	</div>
	</div>
	<%-- <footer>
	<%@include file="inc/footer.jsp"%></footer> --%>
</body>
</html:html>