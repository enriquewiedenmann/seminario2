function logIn() {

	var pass = $("#pass").val();
	var email = $("#email").val();

	var info;

	var murl = "/seminarioMVPV2/login";

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

			if (resultData.Error == "true") {
				$.alertable.alert(resultData.ErrorMSG).always(function() {
				});
			} else {
				window.location.replace("./main.jsp");

			}

		}
	});
}

function camposSingUp() {
	$("#loginBtn").html('Sing Up'); 

	$("#datosSingUp").show("fast");

}
