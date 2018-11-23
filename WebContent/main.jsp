<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>

<html lang="en">
<head>
<title>Regalapp</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	 addEventListener("load", function() {setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<meta charset utf="8">
<!--font-awsome-css-->
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
<script>
	$(document).ready(function() {
		$('.popup-top-anim').magnificPopup({
			type : 'inline',
			fixedContentPos : false,
			fixedBgPos : true,
			overflowY : 'auto',
			closeBtnInside : true,
			preloader : false,
			midClick : true,
			removalDelay : 300,
			mainClass : 'my-mfp-zoom-in'
		});
		
		
	
			console.log("Ready to bring the awesome.");
			var sugList = $("#suggestions");

			$("#search").on("input", function(e) {
				var text = $(this).val();
				if(text.length < 1) {
					sugList.html("");
				} else if(text.length > 3 )  {
					$.get("FiendsSearch", {search:text}, function(res,code) {
						var str = "";
						for(var i=0, len=res.length; i<len; i++) {
							str += "<li><a hfef='#' onClick='userSwipe(\""+res[i].email.trim()+"\",\"reservar\");'>"+res[i].email.trim()+"</a></li>";
						}
						sugList.html(str);
						console.dir(res);
					},"json");
				}
			});

	
		
	});
</script>
<!--//pop-up-box -->
</head>
<body>
	<div class="body-back">
		<div class="masthead pdng-stn1">
			<div id="menu" class="panel" role="navigation">
				<div class="wrap-content">
					<div class="profile-menu text-center">
						<a href = "./main.jsp"  ><img class="border-effect" src="img/gift-flat.png" ></a>
						<h3>MENU</h3>

						<div class="pro-menu">
							<div class="logo">
								<li><a class=" link link--yaku  active" href="#" onClick="logout()">Logout</a></li>
								<li><a class=" link link--yaku  active" href="#">Config</a></li>
								
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
							<a href="main.html">Hi , <%= session.getAttribute("userApodo") %></a>
						</h5>
					</div>
					<div class="Profile-right">
						<a href="#small-dialog" class="sign-in popup-top-anim"> <i
							class="fa fa-user"></i></a>
						<!-- modal -->
						<div id="small-dialog" class="mfp-hide">
							<div class="login-modal">
								<div class="booking-info">
									<h3>
										<a href="main.html">Config
										</a>
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
										<a href="main.html">Config
										</a>
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
							<img src="img/gift-flat.png" alt=" ">
							<h3>Welcome To</h3>
							<h4>Regalapp</h4>

						</div>
						<div class="banner_search">
							<form action="#" method="post">
								<input id="search" type="search" name="search" value="Buscar un amig@ para regalar"
									onfocus="this.value = '';"
									onblur="if (this.value == '') {this.value = 'Buscar un amig@ para regalar';}"
									required="">
									<ul id="suggestions"  class="rounded-list" data-role="listview" data-inset="true"></ul>
									
							</form>
						</div>
	&nbsp;
&nbsp;&nbsp;
					</div>
				</div>
				<div class="w3agile banner-bottom">
					<ul>
						<li><a href="flight.html" class="hvr-radial-out"><i
								class="fa fa-gift" aria-hidden="true"></i></a>
						<h6>Gustos</h6></li>
						
						<li><a href="flight.html" class="hvr-radial-out"><i class="fa fa-calendar"></i></a>
							<h6>Calendario</h6></li>
							<li><a href="swipe.jsp?act=like" class="hvr-radial-out"><i class="fa fa-hand-o-right"></i></a>
							<h6>swipe</h6></li>
					</ul>
				</div>
				<!-- //banner -->
				<!--/welcome-->
				
				<!--//welcome-->
				<!--/footer-->
				<div class="w3agile footer">
					<div class="col-md-3 w3agile_footer_grid">
					
					</div>
					<div class="col-md-2 w3agile_footer_grid">
					
					</div>
					<div class="col-md-4 w3agile_footer_grid">
					
					</div>
					<div class="col-md-3 w3agile_footer_grid">
					
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="w3agile agileinfo_copy_right">
					<div class="agileinfo_copy_right_left">
						<p>Regalap</p>
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
</body>
</html>