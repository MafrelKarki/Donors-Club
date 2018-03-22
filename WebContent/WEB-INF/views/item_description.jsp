<%@ include file="./commons/header.jspf"%>
<script src="resources/js/post.js"></script>
<div class="container">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
		
			 <c:forEach var="itm" items="${items.getPictureList()}">
				<div class="item active">
		
					<img src="${itm.getPath()}" alt="Los Angeles" style="width: 100%;">
				</div>

			</c:forEach> 
		
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>


	<div class="panel panel-default" style="background-color: #efe5e5;">
		<br>
		<div class="panel panel-inverse"
			style="width: 95%; margin: auto; margin-bottom: 10px;">
			<table class="table">
				<tbody>
					<tr class="active">
						<td><strong>Item Name</strong></td>
						<td>${item.itemName}</td>
					</tr>
					<tr class="active">
						<td><strong>Item Description</strong></td>
						<td>${item.description}</td>
					</tr>
					<tr class="active">
						<td><strong>Post At</strong></td>
						<td>${item.createdAt}</td>
					</tr>
					<tr class="active">
						<td><strong>Posted By</strong></td>
						<td>${user.fname}${user.lname}</td>
					</tr>
					<tr class="active">
						<td><strong>Donor's Email</strong></td>
						<td>${user.email}</td>
					</tr>
					<tr class="active">
						<td><strong>Donor's Contact Number</strong></td>
						<td>${user.phoneNumber}</td>
					</tr>
					<tr class="active">
						<td><strong>Donor's Contact Number</strong></td>
						<td>${user.address}</td>
					</tr>

				</tbody>
			</table>
		</div>

		<div class="panel panel-default"
			style="width: 95%; margin: auto; margin-bottom: 10px; background-color: gainsboro;">
			<div class="row">
				<div class="col-md-6">
					<a href="#" class="btn btn-info btn-sm showInterest"
						style="width: 100%;" data-postId="${item.itemId}"> <span
						class="glyphicon glyphicon-star"></span> Show Interest
					</a>
				</div>
				<div class="col-md-6">
					<a
						href="https://www.facebook.com/sharer/sharer.php?s=100&p[url]=http://www.example.com&p[images][0]=&p[title]=Title%20Goes%20Here&p[summary]=Description%20goes%20here!"
						target="_blank" onclick="" class="btn btn-primary btn-sm"
						style="width: 100%;" class="btn btn-facebook btn-sm"> <i
						class="fa fa-facebook"></i> Share on Facebook
					</a>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="./commons/footer.jspf"%>