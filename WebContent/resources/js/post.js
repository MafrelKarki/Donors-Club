$(document).ready(function(){
	$('.showInterest').click(function(evt){
		var postId = $(this).attr("data-postId");
		evt.preventDefault();
		
		$.ajax({
			"url": "./ShowInterestServlet.do",
			"type": "post",
			"data": {
				"postId" : postId
			}, 
			
			"success": function(response){
				if(response.response == true){
					$("a[data-postId = 'postId']").addClass("btn-danger");
					window.location.reload();
				}
			},
			
			"error": function(response){
				console.log(response);
			}
		});
	});
	
});