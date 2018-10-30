<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/home.htm">Home</a></li>
			<li class="active">Account</li>
		</ol>
		<div class="registration">
			<div class="registration_left">
				<h2>
					new user? <span> create an rentee account </span>
				</h2>
				<!-- [if IE] 
							< link rel='stylesheet' type='text/css' href='ie.css'/>  
						 [endif] -->

				<!-- [if lt IE 7]>  
							< link rel='stylesheet' type='text/css' href='ie6.css'/>  
						 <! [endif] -->
				<script>
					(function() {

						// Create input element for testing
						var inputs = document.createElement('input');

						// Create the supports object
						var supports = {};

						supports.autofocus = 'autofocus' in inputs;
						supports.required = 'required' in inputs;
						supports.placeholder = 'placeholder' in inputs;

						// Fallback for autofocus attribute
						if (!supports.autofocus) {

						}

						// Fallback for required attribute
						if (!supports.required) {

						}

						// Fallback for placeholder attribute
						if (!supports.placeholder) {

						}

						// Change text inside send button on submit
						var send = document.getElementById('register-submit');
						if (send) {
							send.onclick = function() {
								this.innerHTML = '...Sending';
							}
						}

					})();

					jQuery(function() {
						$("#register-submit")
								.click(
										function() {
											$(".error").hide();
											var hasError = false;
											var password = $("#password").val();
											var retypePassword = $(
													"#retypePassword").val();
											if (password == '') {
												$("#password").after('<span class="error" style="color:red" required autofocus>Please enter a password.</span>');
												hasError = true;
											} else if (retypePassword == '') {
												$("#retypePassword").after('<span class="error" style="color:red">Please re-enter your password.</span>');
												hasError = true;
											} else if (password.length < 4) {
												$("#password").after('<span class="error" style="color:red" required autofocus>Password should be Min. 4 and Max. 8 characters long </span>');
												hasError = true;
											} else if (password != retypePassword) {
												$("#retypePassword").after('<span class="error" style="color:red">Passwords do not match.</span>');
												hasError = true;
											}
											if (hasError == true) {
												return false;
											}
										});
					});
				</script>

				<div class="registration_form">
					<!-- Form -->
					<form:form modelAttribute="renteeRegistrationForm"
						action="${pageContext.request.contextPath}/add-rentee.htm"
						method="post">
						<span style="color: red"> <form:errors path="*" />
						</span>
						<div>
							<label> 
								<form:input name="firstName" path="firstName"  placeholder="first name:" type="text" tabindex="1" requuired="required" autofocus="true" />
							</label>
						</div>
						<div>
							<label>
								<input name="lastName" placeholder="last name:" type="text" tabindex="2" required autofocus>
							</label>
						</div>
						<div>
							<label>
								<form:input name="emailAddress" path="emailAddress" placeholder="email address:" type="email" tabindex="3" requuired="required" />
							</label>
						</div>
						<div>
							<label>
								<input name="mobile" placeholder="Mobile:" type="text" tabindex="4" required pattern="[0-9]{10}">
							</label>
						</div>
						<!-- <div class="sky_form1">
								<ul>
									<li><label class="radio left"><input type="radio"
											name="radio" checked=""><i></i>Male</label></li>
									<li><label class="radio"><input type="radio"
											name="radio"><i></i>Female</label></li>
									<div class="clearfix"></div>
								</ul>
							</div> -->
						<div>
							<label>
								<input id="password" name="password" placeholder="password" type="password" tabindex="4" required>
							</label>
						</div>
						<div>
							<label>
								<input id="retypePassword" name="retypePassword" placeholder="retype password" type="password" tabindex="4"
								required>
							</label>
						</div>
						<div>
							<label>
								<input name="role" value="Rentee" placeholder="roleName" type="hidden" tabindex="4" required>
							</label>
						</div>
						<div>
							<input type="submit" value="create an account" id="register-submit">
						</div>
						<div class="sky-form">
							<label class="checkbox"> <input name="termsAndConditions"
								type="checkbox" name="checkbox"> <i></i>I Read &amp; Accept &nbsp; 
								<a class="terms" href="${pageContext.request.contextPath}/faq-and-terms.htm"> The Terms &amp; Conditions </a>
							</label>
						</div>
					</form:form>
					<!-- /Form -->
				</div>
			</div>
			<div class="registration_left">
				<h2>existing user</h2>
				<div class="registration_form">
					<!-- Form -->
					<form id="registration_form"
						action="${pageContext.request.contextPath}/rentee-login"
						method="post">
						<div>
							<label> <input name="j_user" placeholder="email:"
								type="email" tabindex="3" required>
							</label>
						</div>
						<div>
							<label> <input name="j_password" placeholder="password"
								type="password" tabindex="4" required>
							</label>
						</div>
						<div>

							<input type="submit" value="sign in" id="register-submit">
						</div>
						<div class="forget">
							<a href="${pageContext.request.contextPath}/forgot-password.htm">forgot
								your password</a>
						</div>
					</form>
					<!-- /Form -->
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</body>
</html>