<!DOCTYPE HTML>
<html>
<head>
<meta name="viewport" content="width=device-width">

<title></title>
<link rel="stylesheet" href="css/jquery.mobile-1.4.5.css">

<script src="js/jquery.js"></script>
<script src="js/jquery.mobile-1.4.5.js"></script>
<script src="js/JsSeminarios2.js"></script>


</head>
<body>

<div data-role="page" id="demo-page" data-title="Cars" data-url="demo-page">


    <div data-role="header" data-theme="b">
       
	<div data-role="controlgroup" data-type="horizontal" data-mini="true">
		<a href="#"
			class="ui-shadow ui-btn ui-corner-all ui-btn-icon-left ui-icon-delete ui-btn-b"
			onClick="logout()">Logout</a> <a href="#"
			class="ui-shadow ui-btn ui-corner-all ui-btn-icon-left ui-icon-plus ui-btn-b">Config</a>
		<a href="#"
			class="ui-shadow ui-btn ui-corner-all ui-btn-icon-left ui-icon-grid ui-btn-b">More</a>
		<a href="#"
			class="ui-shadow ui-btn ui-corner-all ui-btn-icon-left ui-icon-grid ui-btn-b">More</a>
		<a href="#"
			class="ui-shadow ui-btn ui-corner-all ui-btn-icon-left ui-icon-grid ui-btn-b">More</a>
	</div>
       
    </div><!-- /header -->
    <div data-role="content">
        <ul data-role="listview">
            <li><a href="#" class="cars" id="bmw"><img src="img/bmw-thumb.jpg" alt="BMW"><h2>BMW</h2><p>5 series</p></a></li>
            <li><a href="#" class="cars" id="landrover"><img src="img/landrover-thumb.jpg" alt="Land Rover"><h2>Land Rover</h2><p>Discovery 4</p></a></li>
            <li><a href="#" class="cars" id="tesla"><img src="img/tesla-thumb.jpg" alt="Tesla"><h2>Tesla</h2><p>Model S</p></a></li>
        </ul>
    </div><!-- /content -->
</div>



</body>
</html>