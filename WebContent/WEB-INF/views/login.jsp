<%@ include file="./commons/header.jspf"%>
<div class="container">
	<!--  Codes by Sherif -->
	<h2>Login</h2>
	

	<form action="./login" method="post">
	<c:if test="${msgUnvalid!=null }">
	<div class="alert alert-danger">
		${msgUnvalid}
	</div>	
	</c:if>
		<div class="row">
			<div class="form-group">
				<label class="col-md-9 control-label">Your E-mail</label>
				<div class="col-md-9 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input
							name="email" placeholder="Your E-mail"
							class="form-control" type="email" required="required">
					</div>
				</div>
			</div>
		<div class="form-group">
			<label class="col-md-9 control-label">Your Password</label>
			<div class="col-md-9 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-envelope"></i></span> <input
						name="password" placeholder="Enter your Password"
						class="form-control" type="password" required="required">
				</div>
			</div>
		</div>
		</div>
		<br/>
		<div class="form-group">
			<div class="col-md-9 control-form">
				<input type="submit" value="Login" id="btn" class="btn-primary btn btn-lg">
			</div>
		</div>
		
	</form>
</div>
<%@ include file="./commons/footer.jspf"%>

