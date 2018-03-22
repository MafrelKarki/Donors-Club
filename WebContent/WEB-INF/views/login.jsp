<%@ include file="./commons/header.jspf"%>
<div class="container">
	<!--  Codes by Mafrel -->


	<div class="modal-dialog form-dark" role="document">
		<form action="./login" method="post">
			<c:if test="${msgUnvalid!=null }">
				<div class="alert alert-danger">${msgUnvalid}</div>
			</c:if>
			<div class="modal-content card card-image" id="loginForm">
				<div class="text-white rgba-stylish-strong py-5 px-5 z-depth-4">
					<!--Header-->
					<div class="modal-header text-center pb-4">
						<h3 class="modal-title w-100 white-text font-weight-bold"
							id="myModalLabel">
							<strong>Login</strong> <a class="green-text font-weight-bold"></a>
						</h3>
					</div>
					<!--Body-->
					<div class="modal-body">
						<!--Body-->
						<div class="md-form mb-5">
							<input name="email" type="email" id="Form-email5"
								class="form-control validate white-text"
								placeholder="Your Email" required="required">
						</div>
						<br>
						<div class="md-form pb-3">
							<input name="password" type="password" id="Form-pass5"
								class="form-control validate white-text"
								placeholder="Your Password">
						</div>

						<div class="row d-flex align-items-center mb-4">
							<br>
							<div class="text-center mb-3 col-md-12">
								<input type="Submit"
									class="btn btn-success btn-block btn-rounded z-depth-1"
									value="Login" />
							</div>

						</div>

						<div class="row"></div>

					</div>
				</div>
			</div>
	</div>





	<%-- 	<form action="./login" method="post">
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
		
	</form> --%>
</div>
<%@ include file="./commons/footer.jspf"%>

