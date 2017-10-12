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
<link rel="icon" href="${images}/mylogo.jpg">
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
<style>
body{
padding-top:70px;
}
#ftr {
	text-align: center;
}
.help-block{
	color:#ff0000;
}

.footer {
	min-height: 150px;
	width: 100%;
	background-color: #666666;
	list-style: none;
	color: #fff;
	padding-top: 20px;
	margin-top: 20px;
	padding-top: 0px;
}


</style>


</head>
<body>
<%@include file="flows-navbar.jsp" %>


	<div class="content">