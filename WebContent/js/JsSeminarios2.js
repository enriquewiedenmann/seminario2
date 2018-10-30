/**
 * 
 */

function camposSingUp() {
	
	document.getElementById("datosSingUp").style.display = "block";
	document.getElementById("btnSingUP").style.display = "block";
	document.getElementById("btnLogIn").style.display = "none";
	document.getElementById("inputConfrimPass").style.display = "block";
}

function singUp() {

	var apodo = document.getElementById("apodo").value;
	var email = document.getElementById("email").value;
	var pass = document.getElementById("pass").value;
	var passC = document.getElementById("passC").value;
	document.getElementById("action").value = 1;

	
	if (apodo != "" & email != "" & pass != "" & (pass == passC)) {
		document.getElementById("log").submit();
	} else {
		alert("Error en Password");
	}
}

function logIn() {
	
	document.getElementById("action").value = 2;
	document.getElementById("log").submit();
}
