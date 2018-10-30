function logIn() {

	var pass = $("#pass").val();
	var email = $("#email").val();
	
	var info = {
			pass : $("#pass").val(),
			email : $("#email").val()
	}

	var saveData = $.ajax({
		type : 'POST',
		url : "/seminarioMVPV2/login?action=login",
		data : info,
		dataType : "text",
		success : function(resultData) {
			console.log(resultData);
		}
	});
}