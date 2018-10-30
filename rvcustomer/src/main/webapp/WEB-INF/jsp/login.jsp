<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<div class="login_sec">
			<div class="container">
				<ol class="breadcrumb">
					<li><a href="home.htm">Home</a></li>
					<li class="active">Login</li>
				</ol>
				<h2>Login</h2>
				<div class="col-md-6 log">
					<p>Welcome, please enter the folling to continue.</p>
					<p>
						If you have previously Login with us !!
						<!-- <span>click here</span></p> -->
					<form action="${pageContext.request.contextPath}/rentee-security-check" method="post">
						<h5>User Name:</h5>
						<input type="text" name="j_user" value="">
						<h5>Password:</h5>
						<input type="password" name="j_password" value="">
						<input type="submit" value="Login"> <a href="${pageContext.request.contextPath}/forgot-password.htm">Forgot Password ?</a>
					</form>
				</div>
				<div class="col-md-6 login-right">
					<h3>NEW REGISTRATION</h3>
					<p>By creating an account with our site, you will be able to
						rent your unused products through our site and earn !! We are
						offering products on rent in multiple locations, view and track
						your orders in your account and more.</p>
					<a class="acount-btn" href="${pageContext.request.contextPath}/customer-register.htm">Create an Account</a>
					<a class="acount-btn" href="http://localhost:8081/rvrentee/rentee-register.htm">Want 2 become Rentee</a>
					<%-- <a class="acount-btn" href="${pageContext.request.contextPath}/rentee-register.htm">Want 2 become Rentee</a> --%>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</body>
</html>