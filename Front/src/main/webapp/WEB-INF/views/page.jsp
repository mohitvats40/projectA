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
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
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
 padding-top: 65px;
<!-- background:url('${images}/back.png');
 backgrund-size:cover;-->
}
#ftr {
	text-align: center;
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

ul.unstyle {
	list-style: none;
}

#reghead {
	text-align: center;
}
.landingImg{
   height:150px;
   width:150px;
}

.dataTableImg {
	width: 100px;
	height: 100px;
}

.help-block {
	color: #ff0000;
}

.adminImage {
	width: 50px;
	height: 50px;
}

.switch {
	width: 50px;
	height: 30px;
	position: relative;
	display: inline-block;
}

.switch input {
	display: none;
}

.slider {
	position: absolute;
	top: 0;
	bottom: 0;
	right: 0;
	left: 0;
	cursor: pointer;
	background-color: #ccc;
	border-radius: 30px;
	transition: .5s;
}

.slider:before {
	position: absolute;
	background-color: #fff;
	height: 20px;
	width: 20px;
	content: "";
	left: 5px;
	bottom: 5px;
	border-radius: 50%;
	transition: .5s;
}

input:checked+.slider {
	background-color: #1863E6;
}

input:checked+.slider:before {
	transform: translateX(20px);
}

.table-responsive {
	overflow-x: inherit;
}

.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
}

</style>


</head>
<body>
<div id="fakeLoader"></div>
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
	<c:if test="${SHOWCART==true}">
		<%@include file="cart.jsp"%>
	</c:if>
   	<c:if test="${FINAL==true}">
		<%@include file="final.jsp"%>
	</c:if>

	<%@include file="footer.jsp"%>

	<script src="${js}/jquery.js"></script>

	<script src="${js}/jquery.validate.js"></script>

	<script src="${js}/bootstrap.min.js"></script>

	<script src="${js}/jquery.dataTables.js"></script>

	<script src="${js}/dataTables.bootstrap.js"></script>

	<script src="${js}/bootbox.min.js"></script>
	
	
	<script src="${js}/myapp.js"></script>



</body>
</html>
