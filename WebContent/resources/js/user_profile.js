$(document).ready(function(){
	
	$('#updateUserProfile-btn').click(function(){
		
		var fname = $("input[name='first_name']").val();
		var lname = $("input[name='last_name']").val();
		var address = $("input[name='address']").val();
		var email = $("input[name='email']").val();
		var contact_no = $("input[name='contact_no']").val();
		
//		alert("here");
		$.ajax({
			"type" : "post",
			"url": "./ProfileServlet.do",
			"data" : {
				"fname": fname,
				"lname": lname,
				"address": address,
				"phoneNumber": contact_no,
				"email": email
			},
			
			"success": function(response){
				alert(fname+" "+lname+" "+address+" "+contact_no+" "+email);
			},
			
			"error": function(){
//				console.log("Error Occured");
			}
		});
	});
	
});