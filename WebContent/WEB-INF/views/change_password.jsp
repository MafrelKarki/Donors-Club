<%@ include file="./commons/header.jspf" %>
	<div class= "container">
		<!--  Codes by "Developer sherif" -->
		
		<form class="well form-horizontal" action="./ChangePassword.do" method="post"
		id="contact_form">
		<fieldset>
		
		<hr />
			<c:if test="${ErrorMessages.size()>0}">
				<div class="alert alert-danger">
					<b>An Error Occurred:</b>
					<hr />
					<ul>
						<c:forEach items="${ErrorMessages}" var="item">
							<li>${item}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<c:if test="${CorrerctMessages!=null }">
				<div class="alert alert-success">
				<p>${CorrerctMessages }</p>
				</div>
			</c:if>
		<div class="form-group">
				<label class="col-md-4 control-label">Old Password</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="old_password"
							placeholder="old Password" class="form-control" type="password" value="" />
					</div>
				</div>
			</div>
		
			<div class="form-group">
				<label class="col-md-4 control-label">New Password</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="new_password"
							placeholder="New Password" class="form-control" type="password">
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Confirm Password</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input
							name="confirm_password" placeholder="Confirm Password"
							class="form-control" type="password">
					</div>
				</div>
			</div>
			<input type="submit"  value="Update" > 
		</fieldset>
		</form>
		
	</div>
<%@ include file="./commons/footer.jspf" %>
