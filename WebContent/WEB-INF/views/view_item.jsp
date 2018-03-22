<%@ include file="./commons/header.jspf"%>
<div class="container">
	<!--  Codes by "Developer Sherif" -->
	<h2>Your currently posted Donations</h2>
	<form class="well form-horizontal" action="./add_post.do" method="post"
		id="">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>S/N</th>
					<th>Item Name</th>
					<th>Category</th>
					<th>Description</th>
					<th>Date</th>
					<th>Interests</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${user.itemList }" varStatus='loop'>
					<tr>
						<td>${(loop.index)+1}</td>
						<td>${item.getItemName() }</td>
						<td>
							<%-- ${item.getItemCategoryList()} --%>
							${item.getItemCategoryList().get(0).getCategory().getCategoryName() }

						</td>
						<td>${item.getDescription() }</td>
						<td>${item.getCreatedAt()}</td>
						<td>${item.getInterests().size()}</td>
						<td><a href="./add_post.do?myId=${item.getItemId() }">Update</a>
						</td>
						<td><a href="./DeleteItem.do?myId=${item.getItemId() }"
							onclick="">Delete</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</form>
</div>
<%@ include file="./commons/footer.jspf"%>
