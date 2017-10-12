<br><br>

<div class="container">

	<div class="row">



		<div class="col-md-3">
			<%@include file="add.jsp"%>

		</div>


		<div class="col-md-9">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${ALLPRODUCTS==true}">
						<script>
							window.category_id = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${CATEGORYPRODUCTS==true}">
						<script>
							window.category_id = '${category.cId}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.cName}</li>
						</ol>
					</c:if>
				</div>

			</div>

			<div class="row">
				<div class="col-xs-12">
				<div class="container-fluid">
				<div class="table-responsive">
				<table id="productListTable"
						class="table table-striped table-borderd">
						<thead>
							<tr>
								<th></th>
								<th>name</th>
								<th>brand</th>
								<th>price</th>
								<th>Qat</th>
								<th></th>

							</tr>

						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>name</th>
								<th>brand</th>
								<th>price</th>
								<th>Qat</th>
								<th></th>

							</tr>
						</tfoot>


					</table>
				
				</div>
				</div>
					
				</div>
			</div>
		</div>

	</div>

</div>


<br><br><br>