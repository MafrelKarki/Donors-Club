//Mafrel's code 3/20/2019

$(document).ready(function(){
	
	$('#updateUserProfile-btn').click(function(){
		$('#error_message').text("");
		var fname = $("input[name='first_name']").val();
		var lname = $("input[name='last_name']").val();
		var address = $("input[name='address']").val();
		var email = $("input[name='email']").val();
		var contact_no = $("input[name='contact_no']").val();
		
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
				if(response.response!=true){
					$('#error_message').show();
					$.each(response.response, function(index, element){
						$('#error_message').append(element);
						
						$("<br>").appendTo('#error_message');
//						alert(element);
						
					})
//					$('#error_message').append(response.response[0]);
				}
					
				else{
					$('#error_message').hide();
					window.location.reload();
				}
			},
			
			"error": function(){
			}
		});
	});
	
});