<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
	<head></head>
	<body>
		<!-- header -->
			<div class="top_bg">
				<div class="container">
					<div class="header_top-sec">
						<div class="top_right">
							<ul>
								<li><a href="#">help</a></li>|
								<li><a href="contact.html">Contact</a></li>|
								<!--<li><a href="login.html">Track Order</a></li> -->
							</ul>
						</div>
						<div class="top_left">
							<ul>
								<li class="top_link">Email:<a href="info@rentvalley.com">info@rentvalley.com</a></li>|
								<security:authorize access="isAnonymous()">
									<li class="top_link"><a href="${pageContext.request.contextPath}/login.htm">Login</a></li>|
									<li class="top_link"><a href="${pageContext.request.contextPath}/customer-register.htm">Register</a></li>|
								</security:authorize>
								
								<security:authorize access="isAuthenticated()">
									<li class="top_link"><a href="${pageContext.request.contextPath}/logout">Logout</a></li>|
									<li class="top_link"><a href="${pageContext.request.contextPath}/customer-register.htm">My Account</a></li>|
								</security:authorize>				
							</ul>
							<div class="social">
								<ul>
									<li><a href="http://www.facebook.com/rentvalley"><i class="facebook"></i></a></li>
									<li><a href="http://www.twitter.com/rentvalley"><i class="twitter"></i></a></li>
									<li><a href="http://www.google.com/rentvalley"><i class="google"></i></a></li>										
								</ul>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
			</div>
			<div class="header_top">
				 <div class="container">
					 <div class="logo" >
						<a href="index.html"><img src="images/logo6.png" alt=""/></a>			 
					 </div>
					 <!-- <div class="header_right">	
						 <div class="login">
							 <a href="login.html">LOGIN</a>
						 </div>
						 <div class="cart box_1">
							<a href="cart.html">
								<h3> <span class="simpleCart_total">$0.00</span> (<span id="simpleCart_quantity" class="simpleCart_quantity">0</span> items)<img src="images/bag.png" alt=""></h3>
							</a>	
							<p><a href="javascript:;" class="simpleCart_empty">Empty cart</a></p>
							<div class="clearfix"> </div>
						 </div>				 
					 </div> -->
					 <!--  <div class="clearfix"></div>	 -->
				 </div>
			</div>
			<!--cart-->
				 
			<!------>
			<div class="mega_nav">
				 <div class="container">
					 <div class="menu_sec">
					 <!-- start header menu -->
					 <ul class="megamenu skyblue">
						 <li class="active grid"><a class="color1" href="${pageContext.request.contextPath}/home.htm">Home</a></li>
						 <li class="grid"><a class="color2" href="#">furniture</a>
							<div class="megapanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<h4>Sofas</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">All Sofas</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Fabric Sofas</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Leather Sofas</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">L-shaped Sofas</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Love Seats</a></li>									
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Wooden Sofas</a></li>
											</ul>	
										</div>							
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Tables</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Coffee Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Dinning Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Study Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Wooden Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Study Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Bar & Unit Stools</a></li>
											</ul>	
										</div>							
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Beds</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Single Bed</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Poster Bed</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Sofa Cum Bed</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Bunk Bed</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">King Size Bed</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Metal Bed</a></li>
											</ul>	
										</div>												
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Seating</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Wing Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Accent Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Arm Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Mettal Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Folding Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Bean Bags</a></li>
											</ul>	
										</div>						
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Solid Woods</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Side Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">T.v Units</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Dressing Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Wardrobes</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Shoe Racks</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Console Tables</a></li>
											</ul>	
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col2"></div>
									<div class="col1"></div>
									<div class="col1"></div>
									<div class="col1"></div>
									<div class="col1"></div>
								</div>
								</div>
							</li>
						<li><a class="color4" href="#">living</a>
							<div class="megapanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<h4>Seating</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Wing Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Accent Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Arm Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Metal Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Folding Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Bean Bags</a></li>
											</ul>	
										</div>						
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Solid Woods</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Side Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">T.v Units</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Dressing Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Wardrobes</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Shoe Racks</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Console Tables</a></li>
											</ul>	
										</div>
									</div>
								</div>
								</div>
							</li>				
							<li><a class="color5" href="#">kitchen & dinning</a>
							<div class="megapanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<h4>Tables</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Coffee Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Dinning Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Study Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Wooden Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Study Tables</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Bar & Unit Stools</a></li>
											</ul>	
										</div>							
									</div>
									
									<div class="col1">
										<div class="h_nav">
											<h4>Seating</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Wing Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Accent Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Arm Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Mettal Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Folding Chair</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Bean Bags</a></li>
											</ul>	
										</div>						
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Solid Needs</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Mixer & Juicer</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Grinder</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Induction</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Pressure Cooker</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Electric Cooker</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Water Purifiers</a></li>
											</ul>	
										</div>
									</div>
								</div>
							</div>
							</li>
							<li><a class="color6" href="#">appliances</a>
							<div class="megapanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<h4>Electronics</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Refrigerator</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Washing Machine</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">LED Tv</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Micro Oven</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Computer</a></li>									
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Printers</a></li>
											</ul>	
										</div>							
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Electricals</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Ceiling Fan</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Cooler</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">AC</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Home Theatre</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Inverters</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">DJ Speakers</a></li>
											</ul>	
										</div>							
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Others</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Coffee Makers</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Oven Grill</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Geysers</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Aquarium</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Grinders</a></li>
												<li><a href="${pageContext.request.contextPath}/furniture-products.htm">Dispensers</a></li>
											</ul>	
										</div>												
									</div>
								</div>
							</li>				
						
							<li>
								<div class="row">
									<div class="col2"></div>
									<div class="col1"></div>
									<div class="col1"></div>
									<div class="col1"></div>
									<div class="col1"></div>
								</div>
								</div>
							</li>				
						
							<li><a class="color8" href="#">vehicles</a>
							<div class="megapanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<h4>2 Wheelar</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Bi Cycle</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Scooters</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Electric Bikes</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Gear Bikes</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Sport bikes</a></li>									
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Cruiser</a></li>
											</ul>	
										</div>							
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>4 Wheelar</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Jeep</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Cars</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Sedan Cars</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">SUV Cars</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Sports Car</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Maserati</a></li>
											</ul>	
										</div>							
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Others</h4>
											<ul>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Helmet</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Gps Tracker</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">Car Stereo</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">TBD</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">TBD</a></li>
												<li><a href="${pageContext.request.contextPath}/vehicle-products.htm">TBD</a></li>
											</ul>	
										</div>												
									</div>
							</li>				
						   </ul> 
						   <div class="search">
							 <form>
								<input type="text" value="" placeholder="Search...">
								<input type="submit" value="">
								</form>
						 </div>
						 <div class="clearfix"></div>
					 </div>
				  </div>
			</div>
		</body>
	</html>