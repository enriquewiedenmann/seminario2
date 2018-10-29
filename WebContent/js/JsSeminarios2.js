/**
 * 
 */


function camposSingUp() {
	document.getElementById("datosSingUp").style.display = "block";
	document.getElementById("btnSingUP").style.display = "block";
	document.getElementById("btnLogIn").style.display = "none";
	document.getElementById("inputConfrimPass").style.display = "block";
	}

function singUp(){
	
	var apodo= document.getElementById("apodo").value;
	var email= document.getElementById("email").value;
	var pass = document.getElementById("pass").value;
	var passC = document.getElementById("passC").value;
	var accion = 1 ;
	
	
	if(apodo != "" & email!="" & pass !="" &  (pass==passC)){
		 var accion = document.createElement("INPUT");
		  accion.type="hidden";
		  accion.id = "accion";
		  accion.value = "2";
		  document.getElementById("log").appendChild(accion);
		document.getElementById("log").submit(); 
	}else{
		alert("Error en Password");
	}
}
	
	function logIn(){
	var accion = 2; 
	  var accion = document.createElement("INPUT");
	  accion.type="hidden";
	  accion.id = "accion";
	  accion.name = "accion";
	  accion.value = "2";
	  document.getElementById("log").appendChild(accion);
		document.getElementById("log").submit(); 
	}
		
