var murl = "/seminarioMVPV2/main";

function alLike(){
	window.location.replace("./swipe.jsp?act=like");
}

function tutorial(){
	window.location.replace("./tutorial.jsp");
}

function alMain(){
	window.location.replace("./main.jsp");
}

function paraRegalar(){
	
	
	
	info = {
			action : 'paraRegalar',
			
			
		}

	$.ajax({
		type : 'POST',
		url : murl,
		data : info,
		dataType : "json",
		success : function(resultData) {
			window.location.replace("./listaRegalos2.jsp");

		}
	});
}

function misCosas(){

	
	info = {
			action : 'misCosas',
			
			
		}

	$.ajax({
		type : 'POST',
		url : murl,
		data : info,
		dataType : "json",
		success : function(resultData) {
			window.location.replace("./listaRegalos3.jsp");

		}
	});

}

function logIn() {

	var pass = $("#pass").val();
	var email = $("#email").val();

	var info;


	if ($("#datosSingUp").is(":visible")) {

		info = {
			action : "signUp",
			pass : $("#pass").val(),
			email : $("#email").val(),
			apodo : $("#apodo").val()
		}

	} else {
		info = {
			action : "login",
			pass : $("#pass").val(),
			email : $("#email").val()
		}

	}

	var saveData = $.ajax({
		type : 'POST',
		url : murl,
		data : info,
		dataType : "json",
		success : function(resultData) {
			console.log(resultData);

			if (resultData.Error == true) {
				$.alertable.alert(resultData.ErrorMSG).always(function() {
				});
			} else {
				if(resultData.tutorial){
					window.location.replace("./tutorial.jsp");
				}else{
				window.location.replace("./main.jsp");
				}
			}

		}
	});
}

function logout(){
	
	info = {
			action : "logOut"
		}

	$.ajax({
		type : 'POST',
		url : murl,
		data : info,
		dataType : "json",
		success : function(resultData) {
			window.location.replace("./index.jsp");

		}
	});
}

function userSwipe(email,accion){
	
	window.location.replace("./swipe.jsp?email="+email+"&act="+accion);
	
}


function guardarLike(idImagen){
	var url = new URL(window.location.href);
	
	
	info = {
			action : url.searchParams.get("act"),
			idImagen : idImagen,
			agasajado : url.searchParams.get("email")
		}

	$.ajax({
		type : 'POST',
		url : murl,
		data : info,
		dataType : "json",
		success : function(resultData) {
			if (resultData.action == "reservar") {
			window.location.replace("./listaRegalos2.jsp");
			}

		}
	});
}


function reservarRegalo(idImagen){
	
	info = {
			action : "reservar",
			idImagen : idImagen
		}

	$.ajax({
		type : 'POST',
		url : murl,
		data : info,
		dataType : "json",
		success : function(resultData) {
		
		}
	});
}




function renderImg(Img){
	var imgLs = "<ul>";
	if(Img.Imagenes.length==0){
		imgLs += '<li id="0" >';
		imgLs += '<div  onClick="alMain()" class="img"';
		imgLs += ' style="background: url(\'./img/carita triste.png\') no-repeat scroll center center; background-size: contain;"></div>';
		imgLs += '<div>Lo sentimos, no hay regalos.</div>';
		imgLs += '</li>';
	}else{
	for (var i = 0;i < Img.Imagenes.length;i++){
		
				
				imgLs += '<li id="'+Img.Imagenes[i].idImagen+'" >';
				imgLs += '<div  class="img"';
				imgLs += ' style="background: url(\'./img/regalos/'+Img.Imagenes[i].nombre+'\') no-repeat scroll center center; background-size: contain;"></div>';
				imgLs += '<div>'+Img.Imagenes[i].label+'</div>';
				imgLs += '	<div class="like"></div>';
				imgLs += '	<div class="dislike"></div>';
				imgLs += '</li>';

	
	
	}
	}
	
	 imgLs += "</ul>";
	 
	 document.getElementById("tinderslide").innerHTML =imgLs;
	 loadTinder();

// $("#tinderslide"). replaceWith(imgLs);
}
function getImages(email){
	
	info = {
			action : "getImages",
			email : email
			
		}

	$.ajax({
		type : 'POST',
		url : murl,
		data : info,
		dataType : "json",
		success : function(img) {
			renderImg(img);

		}
	});
}

function camposSingUp() {
	$("#loginBtn").html('Sing Up'); 

	$("#datosSingUp").show("fast");

}

$( document ).on( "pageinit", "#demo-page", function() {
    $( ".cars" ).on( "click", function() {
        var target = $( this ),
            brand = target.find( "h2" ).html(),
            model = target.find( "p" ).html(),
            short = target.attr( "id" ),
            closebtn = '<a href="#" data-rel="back" data-role="button" data-theme="a" data-icon="delete" data-iconpos="notext" data-shadow="false" data-iconshadow="false" class="ui-btn-right">Close</a>',
            header = '<div data-role="header"><h2>' + brand + ' ' + model + '</h2></div>',
            img = '<img src="img/' + short + '.jpg" alt="' + brand + '" class="photo">',
            popup = '<div data-role="popup" id="popup-' + short + '" data-short="' + short +'" data-theme="none" data-overlay-theme="a" data-corners="false" data-tolerance="15">' + closebtn + header + img + '</div>';
        // Create the popup. Trigger "pagecreate" instead of "create" because
		// currently the framework doesn't bind the enhancement of toolbars to
		// the "create" event (js/widgets/page.sections.js).
        $.mobile.activePage.append( popup ).trigger( "pagecreate" );
        // Wait with opening the popup until the popup image has been loaded in
		// the DOM.
        // This ensures the popup gets the correct size and position
        $( ".photo", "#popup-" + short ).load(function() {
            var height = $( this ).height(),
                width = $( this ).width();
            // Set height and width attribute of the image
            $( this ).attr({ "height": height, "width": width });
            // Open the popup
            $( "#popup-" + short ).popup( "open" );
            // Clear the fallback
            clearTimeout( fallback );
        });
        // Fallback in case the browser doesn't fire a load event
        var fallback = setTimeout(function() {
            $( "#popup-" + short ).popup( "open" );
        }, 2000);
    });
    // Set a max-height to make large images shrink to fit the screen.
    $( document ).on( "popupbeforeposition", ".ui-popup", function() {
        // 68px: 2 * 15px for top/bottom tolerance, 38px for the header.
        var maxHeight = $( window ).height() - 68 + "px";
        $( "img.photo", this ).css( "max-height", maxHeight );
    });
    // Remove the popup after it has been closed to manage DOM size
    $( document ).on( "popupafterclose", ".ui-popup", function() {
        $( this ).remove();
    });
});

function parse_query_string(query) {
	  var vars = query.split("&");
	  var query_string = {};
	  for (var i = 0; i < vars.length; i++) {
	    var pair = vars[i].split("=");
	    var key = decodeURIComponent(pair[0]);
	    var value = decodeURIComponent(pair[1]);
	    // If first entry with this name
	    if (typeof query_string[key] === "undefined") {
	      query_string[key] = decodeURIComponent(value);
	      // If second entry with this name
	    } else if (typeof query_string[key] === "string") {
	      var arr = [query_string[key], decodeURIComponent(value)];
	      query_string[key] = arr;
	      // If third or later entry with this name
	    } else {
	      query_string[key].push(decodeURIComponent(value));
	    }
	  }
	  return query_string;
	}