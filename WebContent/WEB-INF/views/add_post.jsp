<%@ include file="./commons/header.jspf"%>
<div class="container">
	<!--  Codes by "Developer Sherif" -->



	<form class="well form-horizontal" action="./add_post.do" method="post"
		id="contact_form" >
		<fieldset>

			<!-- Form Name -->


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
			<!-- Text input
			add_post.do
			-->


			<div class="form-group">
				<label class="col-md-4 control-label">Item Name</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-modal-window"></i></span> <input
							name="item_name" placeholder="First Name" class="form-control"
							type="text" value="">
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Description</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class=" glyphicon glyphicon-blackboard"></i></span>
						<textarea class="form-control" name="description" >${description }</textarea>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label">Categories</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-modal-window"></i></span>
							 <select name="Myselect" class="form-control" name="Events">

							<c:forEach var="i" items="${Categories }">
								<option value="${i.getCategoryId() }">${i.getCategoryName() }</option>

							</c:forEach>

						</select>
					</div>
				</div>
			</div>
			<!-- <div class="form-group">
				<label class="col-md-4 control-label">Selected</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class=" glyphicon glyphicon-blackboard"></i></span>
						<textarea readonly="true" class="form-control" name="mySelected"></textarea>
					</div>
				</div>
			</div> -->
			<div class="form-group">
				<label class="col-md-4 control-label">photo</label>
				<div class="col-md-4 inputGroupContainer">
					<input  name="photo1" accept="image/*" type="file" value="${ photo1}">
 					
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label">photo</label>
				<div class="col-md-4 inputGroupContainer">
					<input name="photo2" accept="image/*"   type="file" value="${ photo2}">

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label">photo</label>
				<div class="col-md-4 inputGroupContainer">
					<input name="photo3"  accept="image/*"  type="file" value="${ photo3}">

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label">photo</label>
				<div class="col-md-4 inputGroupContainer">
					<input name="photo4"  accept="image/*"  type="file" value="${ photo4}">

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label">photo</label>
				<div class="col-md-4 inputGroupContainer">
					<input name="photo5"  accept="image/*"  type="file"  value="${ photo5}">

				</div>
			</div>

			<!-- Text input-->

		</fieldset>

		<input type="submit" value="Ok">
	</form>
</div>
<%@ include file="./commons/footer.jspf"%>
