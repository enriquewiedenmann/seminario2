<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.List"
    import = "view.ImagenDTO"
    %>
<!DOCTYPE html>

<html lang="en">
<head>
<title>Regalapp</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Travel Hunt App Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android  Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() {setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<meta charset utf="8">
<!--font-awsome-css-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

<link rel="stylesheet" href="css/mainPage/font-awesome.min.css">
<!--bootstrap-->
<link href="css/mainPage/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<!--custom css-->
<link href="css/mainPage/style.css" rel="stylesheet" type="text/css" />
<!--component-css-->
<script src="js/mainPage/jquery-2.1.4.min.js"></script>
<script src="js/mainPage/bootstrap.min.js"></script>
<!--script-->
<script src="js/mainPage/modernizr.custom.js"></script>
<script src="js/mainPage/bigSlide.js"></script>
<script src="js/JsSeminarios2.js"></script>
<link rel="stylesheet" type="text/css" href="css/jTinder.css">

<script>
	$(document).ready(function() {
		$('.menu-link').bigSlide();
	});
</script>
<!-- web-fonts -->
<link href='//fonts.googleapis.com/css?family=Abril+Fatface'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!-- //web-fonts -->
<!-- pop-up-box -->
<script src="js/mainPage/jquery.magnific-popup.js"
	type="text/javascript"></script>

<!--//pop-up-box -->
</head>
<body>
	<div class="body-back">
		<div class="masthead pdng-stn1">
			<div id="menu" class="panel" role="navigation">
				<div class="wrap-content">
					<div class="profile-menu text-center">
						<a href = "./main.jsp"  ><img class="border-effect" src="img/gift-flat.png" alt=" "></a>
						<h3>MENU</h3>

					<div class="pro-menu">
							<div class="logo">
								
								<li><a class=" link link--yaku  active" onClick="misCosas()"  href="#">Mis cosas</a></li>
								<li><a class=" link link--yaku  active" onClick="paraRegalar()"  href="#">Para regalar</a></li>
								<li><a class=" link link--yaku  active" href="#">Config</a></li>
								<li><a class=" link link--yaku  active" onClick="tutorial()" href="#">Tutorial</a></li>
								<li><a class=" link link--yaku  active" href="#" onClick="logout()">Logout</a></li>
							</div>


						</div>
					</div>
				</div>
			</div>
			<div class="phone-box wrap push" id="home">
				<div class="menu-notify">
					<div class="profile-left">
						<a href="#menu" class="menu-link"><i class="fa fa-list-ul"></i></a>
					</div>
					<div class="Profile-mid">
						<h5 class="pro-link">
							<a href="#">Hi , <%= session.getAttribute("userApodo") %></a>
						</h5>
					</div>
					<div class="Profile-right">
						<a href="./main.jsp" class="sign-in popup-top-anim"> <i class="fas fa-home"></i></a>
						<!-- modal -->
						<div id="small-dialog" class="mfp-hide">
							<div class="login-modal">
								<div class="booking-info">
									<h3>
										<a href="main.html">Config </a>
									</h3>

								</div>
								<div class="login-form">
									<form action="#" method="post">
										<p>User Name</p>
										<input type="text" name="Name" required="" />
										<p>User Password</p>
										<input type="password" name="Password" required="" />
										<div class="wthree-text">
											<ul>
												<li><input type="checkbox" id="brand" value="">
													<label for="brand"><span></span> Remember me ?</label></li>
												<li><a href="#">Forgot password?</a></li>
											</ul>
											<div class="clear"></div>
										</div>
										<input type="submit" value="Sign In">
									</form>
									<p>
										Don’t have an account ?<a href="#small-dialog1"
											class="sign-in popup-top-anim"> Sign Up</a>
									</p>
								</div>
							</div>
						</div>
						<!-- //modal -->
						<!-- modal-two -->
						<div id="small-dialog1" class="mfp-hide">
							<div class="login-modal">
								<div class="booking-info">

									<h3>
										<a href="main.html">Config </a>
									</h3>

								</div>
								<div class="login-form signup-form">
									<form action="#" method="post">
										<p>User Name</p>
										<input type="text" name="Name" required="" />
										<p>User Email</p>
										<input type="text" name="Email" required="" />
										<p>User Password</p>
										<input type="password" name="Password" placeholder=""
											required="" />
										<div class="wthree-text">
											<input type="checkbox" id="brand1" value=""> <label
												for="brand1"><span></span>I accept the terms of use</label>
										</div>
										<input type="submit" value="Sign Up">
									</form>
								</div>
							</div>
						</div>
						<!-- //modal-two -->

					</div>
					<div class="clearfix"></div>
				</div>
				<!-- banner -->
				
				<div class="details-grid">
					<div class="details-shade">
						<div class="details-right">
							<div id="wrap">
								<div class="row" id="tinderSlide">
								
									<%

List<ImagenDTO> regalos = (List<ImagenDTO>) session.getAttribute("regalos");

for(ImagenDTO img : regalos){
	
	out.println("<div class=\"row\"><img src=\"./img/regalos/"+img.getNombre()+" \"></div>");
	out.println("<div class=\"row\"><h4 style=\"color:#2ad2c9\">Para: "+img.getPara()+"</h4></div>");
	
}%>
							
							</div>
							</div>

						</div>

					</div>

				</div>
		
			
				<!-- //banner -->
				<!--/welcome-->

				<!--//welcome-->
				<!--/footer
				<div class="w3agile footer">
					<div class="col-md-3 w3agile_footer_grid"></div>
					<div class="col-md-2 w3agile_footer_grid"></div>
					<div class="col-md-4 w3agile_footer_grid"></div>
					<div class="col-md-3 w3agile_footer_grid"></div>
					<div class="clearfix"></div>
				</div>
				-->
				<div class="w3agile agileinfo_copy_right">
					<div class="agileinfo_copy_right_left">
						<p>Regalapp</p>
					</div>
					<div class="agileinfo_copy_right_right">
						<ul class="social">
							<li><a class="social-linkedin" href="#"> <i></i>
									<div class="tooltip">
										<span>Facebook</span>
									</div>
							</a></li>
							<li><a class="social-twitter" href="#"> <i></i>
									<div class="tooltip">
										<span>Twitter</span>
									</div>
							</a></li>
							<li><a class="social-google" href="#"> <i></i>
									<div class="tooltip">
										<span>Google+</span>
									</div>
							</a></li>
							<li><a class="social-facebook" href="#"> <i></i>
									<div class="tooltip">
										<span>Pinterest</span>
									</div>
							</a></li>
							<li><a class="social-instagram" href="#"> <i></i>
									<div class="tooltip">
										<span>Instagram</span>
									</div>
							</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<!--/footer-->

			</div>
		</div>
		

		<script src="js/mainPage/jquery.nicescroll.js"></script>
		<script src="js/mainPage/scripts.js"></script>
		<!-- jTinder status text  -->
	

		<!-- transform2d lib -->
		<script type="text/javascript" src="js/jquery.transform2d.js"></script>
		<!-- jTinder lib -->
		<script type="text/javascript" src="js/jquery.jTinder.js"></script>
		<!-- jTinder initialization script -->
		<script type="text/javascript" src="js/jTinder.js"></script>
</body>
</html>