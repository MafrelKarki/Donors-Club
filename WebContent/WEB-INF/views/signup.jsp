<%@ include file="./commons/header.jspf"%>
<div class="container">
	<form class="well form-horizontal" action="./signup" method="post"
		id="contact_form">
		<fieldset>

			<!-- Form Name -->
			<center>
				<h2>Signup to DonorsClub</h2>
			</center>
			<hr />
			<c:if test="${signupErrorMessages.size()>0}">
				<div class="alert alert-danger">
					<b>An Error Occurred:</b>
					<hr />
					<ul>
						<c:forEach items="${signupErrorMessages}" var="item">
							<li>${item}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">First Name</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="first_name"
							placeholder="First Name" class="form-control" type="text" value="${firstName }">
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Last Name</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="last_name"
							placeholder="Last Name" class="form-control" type="text" value="${firstLast}">
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Address</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-map-marker"></i></span> <input name="address"
							placeholder="Adress" class="form-control" type="text" value="${address}">
					</div>
				</div>
			</div>



			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label">E-Mail</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-envelope"></i></span> <input name="email"
							placeholder="E-Mail Address" class="form-control" type="text" value="${email }">
					</div>
				</div>
			</div>


			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Contact No.</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-earphone"></i></span> <input
							name="contact_no" placeholder="(639)" class="form-control"
							type="text" value="${contactNo}">
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Password</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="password"
							placeholder="Password" class="form-control" type="password">
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

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4">
					<br>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<button type="submit" class="btn btn-primary">
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp SignUp <span
							class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					</button>
				</div>
			</div>

		</fieldset>
	</form>

</div>
<%@ include file="./commons/footer.jspf"%>
