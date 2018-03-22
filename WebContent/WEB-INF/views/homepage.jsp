<%-- Mafrel's code 3/19/2018--%>
<%@ include file="./commons/header.jspf" %>
	<div class= "container">
		<c:choose>
			<c:when test="${user==null }">
				<div class= "row">
					<div class="col-md-9">
						<%@ include file="./fragments/posts.jspf" %>
					</div>
					<div class="col-md-3">
						<%@ include file="./fragments/most_interested_posts.jspf" %>
					</div>
				</div>
			</c:when> 
			<c:otherwise>
				<div class= "row">
					<div class="col-md-2">
						<%@ include file="./fragments/user_menu.jspf" %>
					</div>
					<div class="col-md-7">
						<%@ include file="./fragments/posts.jspf" %>
					</div>
					<div class="col-md-3">
						<%@ include file="./fragments/most_interested_posts.jspf" %>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
<%@ include file="./commons/footer.jspf" %>

