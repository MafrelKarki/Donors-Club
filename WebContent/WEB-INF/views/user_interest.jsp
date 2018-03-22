<%@page import="com.donorsClub.models.Item"%>
<%@page import="com.donorsClub.models.User"%>
<%@page import="com.donorsClub.daos.UserDao"%>
<%@ include file="./commons/header.jspf"%>
<div class="container">
	<div class="container">
		<!--  Codes by Edward -->

		<dc:forEach var="interest" items="${user.interestList}"
			varStatus="loopp">
			<c:set var="item" value="${interest.item}"></c:set>
			<a href="./post?id=${item.getItemId()}">
				<div id="myCarousel${loopp.index }" class="carousel slide"
					data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<c:forEach var="itm" items="${item.getPictureList()}"
							varStatus="loop">
							<li data-target="#myCarousel${loopp.index }"
								data-slide-to="${loop.index }" class=""></li>
						</c:forEach>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<c:forEach var="itm" items="${item.getPictureList()}"
							varStatus="Myi">
							<c:choose>
								<c:when test="${Myi.index==0}">
									<div class="item active">
								</c:when>
								<c:otherwise>
									<div class="item ">
								</c:otherwise>
							</c:choose>
							<img src="${itm.getPath()}" alt="Los Angeles"
								style="width: 100%; height: 434px">
					</div>

					</c:forEach>
				</div> <!-- Left and right controls --> <a class="left carousel-control"
				href="#myCarousel${loopp.index }" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel${loopp.index }"
				data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
			</a>
	</div>
	</a>


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
					<c:set var="uId" value="${interest.item.userId}"></c:set>
					
					<%
					long uid = (Long)pageContext.getAttribute("uId");
					User urs = (User)new UserDao().findById(uid);
					%>
					<tr class="active">
						<td><strong>Posted By</strong></td>
						<td><%=urs.getFname() %> <%=urs.getLname()%></td>
					</tr>
					<tr class="active">
						<td><strong>Donor's Email</strong></td>
						<td><%=urs.getEmail() %></td>
					</tr>
					<tr class="active">
						<td><strong>Donor's Contact Number</strong></td>
						<td><%=urs.getPhoneNumber() %></td>
					</tr>
					<tr class="active">
						<td><strong>Donor's Contact Number</strong></td>
						<td><%=urs.getAddress() %></td>
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

	<br> <br>
	</dc:forEach>
</div>
</div>
<%@ include file="./commons/footer.jspf"%>
