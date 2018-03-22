<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ include file="./commons/header.jspf"%>
<div class="container" id="addPostContainer">
	<!--  Codes by "Developer Sherif" -->

<!-- sherif -->

<%-- Reformatted sherif code by Mafrel 3/21/2018--%>
	<form class="well form-horizontal" action="./add_post.do" method="post"
		enctype="multipart/form-data" id="contact_form">
		<fieldset>


			<c:if test="${signupErrorMessages!=null}">
				<div class="alert alert-danger">
					<b>An Error Occurred:</b>
					<hr />
					<ul>
						<li>${signupErrorMessages}</li>
					</ul>
				</div>

				<hr />
			</c:if>
			<c:if test="${CorrerctMessages!=null }">
				<div class="alert alert-success">
					<p>${CorrerctMessages }</p>
				</div>
			</c:if>
			<!-- Text input
			add_post.do
			-->

			<div class="form-group">
				<label class="col-md-4 control-label">Item Name</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-modal-window"></i></span> <input
							required="required" name="item_name" placeholder="Item Name"
							class="form-control" type="text" value="${Item.getItemName() }">
					</div>
				</div>
			</div>
			<input type="hidden" name="myId" value="${myId }">
			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Description</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class=" glyphicon glyphicon-blackboard"></i></span>
						<textarea class="form-control" name="description">${Item.getDescription() }</textarea>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label">Categories</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-modal-window"></i></span> <select
							name="Myselect" class="form-control" name="Events">

							<c:forEach var="i" items="${Categories }">
								<c:if
									test="${i.getCategoryId()==Item.getItemCategoryList().get(0).getCategoryId() }">
									<option selected="selected" value="${i.getCategoryId() }">${i.getCategoryName() }</option>
								</c:if>
								<c:if
									test="${i.getCategoryId()!=Item.getItemCategoryList().get(0).getCategoryId() }">
									<option value="${i.getCategoryId() }">${i.getCategoryName() }</option>
								</c:if>
							</c:forEach>

						</select>
					</div>
				</div>
			</div>
			<c:forEach var="i" begin="0" end="4">
				<div class="form-group">
					<label class="col-md-4 control-label">Item Image ${i+1}</label>
					<div class="col-md-4 inputGroupContainer">

						<input name="photo${i+1}" accept="image/*" type="file" value=''>
					</div>
				</div>
			</c:forEach>

			<!-- Text input-->

		</fieldset>

		<input type="submit" class="btn btn-info" value="Add Item" id="submitItemButton">
	</form>
</div>
<%@ include file="./commons/footer.jspf"%>
