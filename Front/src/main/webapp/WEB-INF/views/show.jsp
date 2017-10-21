<div class="container">
	<div class="row">
		<br>
		<div class="col-xs-12">

			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Product</a></li>
				<li class="active">${product.pName}</li>


			</ol>


			<br>

		</div>
	</div>
	<div class="row">
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">

				<img src="${images}/${product.pCode}.jpg" class="img img-responsive" />
			</div>

		</div>
		<div class="col-xs-12 col-sm-8">
			<h3>${product.pName}</h3>
			<hr />
			<p>${product.pDesc}</p>
			<hr />
			<h4>
				Price: <strong>&#8377; ${product.pPrice} /-</strong>
			</h4>
			<hr />

			<c:choose>
				<c:when test="${product.pQat < 1}">
					<h6>
						Quantity Avilable: <span style="color: red;">out of stock</span>
					</h6>
				</c:when>
				<c:otherwise>
					<h6>Quantity Avilable: ${product.pQat}</h6>
				</c:otherwise>
			</c:choose>
			<hr />
           <security:authorize access="hasAuthority('USER')">
			<c:choose>
				<c:when test="${product.pQat < 1}">
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
							<span class="glyphicon glyphicon-shooping-cart"></span>Add to
							Cart
					</strike></a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product.pId}/product"
						class="btn btn-success"> <span
						class="glyphicon glyphicon-shooping-cart"></span>Add to Cart
					</a>
				</c:otherwise>
			</c:choose>
			</security:authorize>
			<security:authorize access="hasAuthority('ADMIN')">
			<a href="${contextRoot}/admin/${product.pId}/product"
						class="btn btn-warning"> <span
						class="glyphicon glyphicon-pencil"></span>Edit
					</a>
			</security:authorize>

			<a href="${contextRoot}/show/all/products" class="btn btn-success">
				Back </a>
		</div>
	</div>
</div>
<br>
<br>