$(document).ready(function(){
	$('.showInterest').click(function(){
		var postId = attr("data-postId");
		
		$.ajax({
			"url": "./ShowInterestServlet.do",
			"type": "post",
			"data": {
				"postId" : postId
			}, 
			
			"success": function(response){
				console.log(response);
			},
			
			"error": function(response){
				console.log(response);
			}
		});
	});
});