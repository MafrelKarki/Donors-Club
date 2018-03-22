<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
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
							class="glyphicon glyphicon-modal-window"></i></span> <input required="required"
							name="item_name" placeholder="First Name" class="form-control"
							type="text" value="${Item.getItemName() }">
					</div>
				</div>
			</div>
		<input type="hidden"  name="myId" value="${myId }">
			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Description</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class=" glyphicon glyphicon-blackboard"></i></span>
						<textarea class="form-control" name="description" >${Item.getDescription() }</textarea>
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
							<c:if test="${i.getCategoryId()==Item.getItemCategoryList().get(0).getCategoryId() }">
								<option  selected="selected" value="${i.getCategoryId() }">${i.getCategoryName() }</option>
							</c:if>
							<c:if test="${i.getCategoryId()!=Item.getItemCategoryList().get(0).getCategoryId() }">
								<option   value="${i.getCategoryId() }">${i.getCategoryName() }</option>
							</c:if>
							</c:forEach>

						</select>
					</div>
				</div>
			</div>
			<% System.out.println("99999"); %>
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
			<c:forEach var="i" begin="0"  end="4">
			<div class="form-group">
				<label class="col-md-4 control-label">photo</label>
				<div class="col-md-4 inputGroupContainer">
	
					<input  name="photo${i+1 }" accept="image/*" type="file"
					 value='${item==null?"":item.getPictureList().size()>i?item.getPictureList().get(i).getPath():"" }'>			
				</div>
			</div>
			</c:forEach>

			<!-- Text input-->

		</fieldset>

		<input type="submit" value="Ok">
	</form>
</div>
<%@ include file="./commons/footer.jspf"%>
