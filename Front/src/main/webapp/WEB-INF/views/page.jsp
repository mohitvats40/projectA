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
<body>
	<%@include file="navbar.jsp"%>

	<c:if test="${HOME==true}">
		<%@include file="home.jsp"%>
	</c:if>
	<c:if test="${ABOUT==true}">
		<%@include file="about.jsp"%>
	</c:if>
	<c:if test="${CONTACT==true}">
		<%@include file="contactus.jsp"%>
	</c:if>
	<c:if test="${LOGIN==true}">
		<%@include file="login.jsp"%>
	</c:if>
	<c:if test="${REGESTER==true}">
		<%@include file="regester.jsp"%>
	</c:if>
	<c:if test="${ALLPRODUCTS==true or CATEGORYPRODUCTS==true}">
		<%@include file="product.jsp"%>
	</c:if>
	<c:if test="${SHOWPRODUCT==true}">
		<%@include file="show.jsp"%>
	</c:if>
	<c:if test="${ADMIN==true}">
		<%@include file="adminProduct.jsp"%>
	</c:if>


	<%@include file="footer.jsp"%>

	<script src="${js}/jquery.js"></script>

	<script src="${js}/bootstrap.min.js"></script>

	<script src="${js}/jquery.dataTables.js"></script>

	<script src="${js}/dataTables.bootstrap.js"></script>
	
	<script src="${js}/bootbox.min.js"></script>


	<script src="${js}/myapp.js"></script>



</body>
</html>
