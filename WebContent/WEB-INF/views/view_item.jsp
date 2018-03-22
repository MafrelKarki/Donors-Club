<%@ include file="./commons/header.jspf"%>
<div class="container">
	<!--  Codes by "Developer Sherif" -->

	<form class="well form-horizontal" action="./add_post.do" method="post"
		id="contact_form">
		<fieldset>
		<table class="table">
		<thead>
		<tr>
		<th>
	   Item Name
		</th>
		<th>
	   Category
		</th>
		<th>
		Description
		</th>
		<th>
		Date
		</th>
		<th>
		Interests
		</th>
		
		</tr>
		</thead>
		<tbody>
	<c:forEach var="item" items="${user.itemList }">
	<tr >
	<td>
	${item.getItemName() }
	</td>
	<td>
${item.getItemCategoryList()}
<%-- 	${item.getItemCategoryList().get(0).getCategory().getCategoryName() }  --%>

	</td>
		<td>
	${item.getDescription() }
	</td>
	<td>
	${item.getCreatedAt()}
	</td>
	<td>
	${item.getInterests().size()}
	</td>
	<td>

	<a href="./add_post.do?myId=${item.getItemId() }" >Update</a>
	</td>
	<td>
	<a   href="./DeleteItem.do?myId=${item.getItemId() }" onclick="" >Delete</a>

	</tr>
	</c:forEach>
	</tbody>
		</table>
		
		</fieldset>
	</form>
</div>
<%@ include file="./commons/footer.jspf"%>
