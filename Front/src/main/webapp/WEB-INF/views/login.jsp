
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="${images}/img1.jpg">
<title>Electromart- ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/style.css" rel="stylesheet">


</head>
<body style="padding-top: 90px;">
	<%@include file="navbar.jsp"%>
	<div class="container">
		<%-- --%>
		<c:if test="${not empty message}">
			<div class="row">
				<div class="col-sm-4">
					<div class="alert alert-danger">${message}</div>
				</div>
			</div>
		</c:if>

		<c:if test="${not empty logout}">
			<div class="row">
				<div class="col-sm-4">
					<div class="alert alert-success">${logout}</div>
				</div>
			</div>
		</c:if>
		<div class="row">
			<div class="col-md-4">

				<legend>
					<h3>LOG IN:</h3>
				</legend>
				<form action="${contextRoot}/login" method="POST"
					class="form-horizontal" id="loginForm">
					<div class="form-group">
						<label for="username">Email:</label> <input type="email"
							class="form-control" id="username" name="username"
							class="form-control">
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" id="password" name="password"
							class="form-control">
					</div>
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label> <label
							class="pull-right"><a href="${contextRoot}/register"><h5>new
									user!!</h5></a></label>
					</div>
					<br> <input type="submit" value="Login"
						class="btn btn-primary" /> <input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
			<div class="col-sm-2">
				<P>
				<p>
			</div>

			<div class="col-md-6"></div>
		</div>
	</div>

	<br>
	<br>

	<%@include file="footer.jsp"%>

	<script src="${js}/jquery.js"></script>

	<script src="${js}/jquery.validate.js"></script>






	<script src="${js}/bootbox.min.js"></script>



	<script src="${js}/myapp.js"></script>



</body>
</html>
