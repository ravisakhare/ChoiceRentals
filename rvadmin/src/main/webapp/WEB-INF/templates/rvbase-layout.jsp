<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!--
Author: vivek singh
-->
<!DOCTYPE html>
<html>
	<head>
		<title><tiles:getAsString name="title"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!-- Bootstrap Core CSS -->
		<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
		<!-- Custom CSS -->
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<link rel="stylesheet" href="css/morris.css" type="text/css"/>
		<!-- Graph CSS -->
		<link href="css/font-awesome.css" rel="stylesheet"> 
		<!-- jQuery -->
		<script src="js/jquery-2.1.4.min.js"></script>
		<!-- //jQuery -->
		<link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
		<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<!-- lined-icons -->
		<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
		<!-- //lined-icons -->
	</head> 
	<body>
	   <div class="page-container">
	        <!--header start here-->
			<tiles:insertAttribute name="header"/>
	
			<!--inner block start here-->
			<tiles:insertAttribute name="body"/>
			<!--inner block end here-->
	
			<!--copy rights start here-->
			<tiles:insertAttribute name="footer"/>
			<!--COPY rights end here-->
	
		</div>
	</body>
</html>