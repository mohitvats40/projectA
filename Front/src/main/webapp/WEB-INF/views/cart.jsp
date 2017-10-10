<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<style>
.table>tbody>tr>td, .table>tfoot>tr>td {
	vertical-align: middle;
}

@media screen and (max-width: 600px) {
	table#cart tbody td .form-control {
		width: 20%;
		display: inline !important;
	}
	.actions .btn {
		width: 36%;
		margin: 1.5em 0;
	}
	.actions .btn-info {
		float: left;
	}
	.actions .btn-danger {
		float: right;
	}
	table#cart thead {
		display: none;
	}
	table#cart tbody td {
		display: block;
		padding: .6rem;
		min-width: 320px;
	}
	table#cart tbody tr td:first-child {
		background: #333;
		color: #fff;
	}
	table#cart tbody td:before {
		content: attr(data-th);
		font-weight: bold;
		display: inline-block;
		width: 8rem;
	}
	table#cart tfoot td {
		display: block;
	}
	table#cart tfoot td .btn {
		display: block;
	}
	.CartImge {
		width: 100px;
		height: 100px;
	}
	.unavailable {
		color: red;
	}
}
</style>


<div class="container">
	<c:if test="${not empty message}">

		<div class="alert alert-info">
			<h3 class="text-center">${message}</h3>
		</div>
	</c:if>

	<c:choose>
		<c:when test="${not empty cartline}">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartline}" var="cartline">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img src="${images}/${cartline.product.pCode}.jpg"
											alt="${cartline.product.pName}" class="CartImge" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin">${cartline.product.pName}
											<c:if test="${cartline.is_available==false}">
												<strong class="unavailable">(Not avaiable)</strong>
											</c:if>
										</h4>
										<p>Brand - ${cartline.product.pBrand}</p>
										<p>Description - ${cartline.product.pDesc}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">&#8377; ${cartline.buying_price}</td>
							<td data-th="Quantity"><input type="number"
								id="count_${cartline.id}" min="1" max="5"
								class="form-control text-center" value="${cartline.pCount}"></td>
							<td data-th="Subtotal" class="text-center">&#8377;
								${cartline.total}</td>
							<td class="actions" data-th="">
								<button type="button" name="refreshCart" value="${cartline.id}"
									class="btn btn-info btn-sm">
									<span class="glyphicon glyphicon-refresh"></span>
								</button> <a href="${contextRoot}/cart/${cartline.id}/delete"
								class="btn btn-danger btn-sm"> <span
									class="glyphicon glyphicon-trash"></span>
							</a>
							</td>
						</tr>
					</c:forEach>

				</tbody>
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total &#8377;
								${usermodel.cart.total}</strong></td>
					</tr>
					<tr>
						<td><a href="${contextRoot}/show/all/products"
							class="btn btn-warning"><span
								class="glyphicon glyphicon-chevron-left"></span> Continue
								Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total
								&#8377; ${usermodel.cart.total}</strong></td>
						<td><a href="#" class="btn btn-success btn-block">Checkout
								<span class="glyphicon glyphicon-chevron-right"></span>
						</a></td>
					</tr>
				</tfoot>
			</table>
		</c:when>
		<c:otherwise>
			<div class="jumbotron">
				<div class="text-center">
					<h1>Your cart is empity</h1>
				</div>
			</div>
		</c:otherwise>
	</c:choose>

</div>