<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-inverse navbar-fixed-top"
	style="padding-left: 40px; padding-right: 60px;">

	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#navbar" aria-expanded="false"
			aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>

	</div>
	<div id="navbar" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li id="home" class="active"><a href="${contextRoot}/home"><i
					class="fa fa-home fa-2x"></i> Electromart</a></li>
			<li id="about"><a href="${contextRoot}/about"><i
					class="fa fa-info-circle fa-2x"></i> ABOUT</a></li>

			<li id="contactus"><a href="${contextRoot}/contactus"><i
					class="fa fa-phone fa-2x"></i> CONTACTus</a></li>
			<li id="product"><a href="${contextRoot}/show/all/products"><i
					class="fa fa-list fa-2x"></i>Our Products</a></li>
					<security:authorize access="hasAuthority('ADMIN')">
			<li id="adminProduct"><a href="${contextRoot}/admin/product"><i
					class="fa fa-list fa-2x"></i>Admin Products</a></li>
					</security:authorize>

		</ul>
		<ul class="nav navbar-nav pull-right">
			<security:authorize access="isAnonymous()">
				<li id="register"><a href="${contextRoot}/register"
					role="button"><i class="fa fa-pencil fa-2x" aria-hidden="true"></i>
						Sign Up</a></li>
				<li id="login"><a href="${contextRoot}/login" role="button"><i
						class="fa fa-user fa-2x" aria-hidden="true"></i> Login</a></li>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<li class="dropdown" id="userCart"><a href="javascript:void(0)"
					class="btn btn-inverse dropdown-toggle" id="dropdownMenu1"
					data-toggle="dropdown"><i class="fa fa-user fa-2x" aria-hidden="true"></i> ${usermodel.fullname} <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu">
					<security:authorize access="hasAuthority('USER')">
						<li><a href="${contextRoot}/cart/show"> <span
								class="glyphicon glyphicon-shopping-cart"></span> <span
								class="badge">${usermodel.cart.cartLine}</span>  &#8377;
								${usermodel.cart.total}
						</a></li>
						
						<li class="divider" role="separator"></li>
						</security:authorize>
						<li><a href="${contextRoot}/perform-logout">Logout</a></li>
					</ul></li>
			</security:authorize>
		</ul>

	</div>


</nav>
