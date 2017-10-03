<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row">

		<c:if test="${not empty message}">


			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>


		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- form elements -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/admin/product" 
						method="POST"
						enctype="multipart/form-data">

						<div class="form-group">
							<lable class="control-lable col-md-4" for="pName">Enter
							Product Name:</lable>
							<div class="col-md-8">
								<sf:input type="text" path="pName" id="pName"
									placeholder="Product Name" class="form-controle" />
								<sf:errors path="pName" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<lable class="control-lable col-md-4" for="pBrand">Enter
							Product Brand:</lable>
							<div class="col-md-8">
								<sf:input type="text" path="pBrand" id="pBrand"
									placeholder="Product Brand" class="form-controle" />
								<sf:errors path="pBrand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<lable class="control-lable col-md-4" for="pDesc">Enter
							Product Description:</lable>
							<div class="col-md-8">
								<sf:textarea type="text" path="pDesc" id="pDesc" rows="4"
									placeholder="Product Description" class="form-controle" />
								<sf:errors path="pDesc" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<lable class="control-lable col-md-4" for="pPrice">Enter
							Product UnitPrice:</lable>
							<div class="col-md-8">
								<sf:input type="number" path="pPrice" id="pPrice"
									placeholder="unit price in &#8377; " class="form-controle" />
								<sf:errors path="pPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<lable class="control-lable col-md-4" for="pQat">Enter
							Product Quantity:</lable>
							<div class="col-md-8">
								<sf:input type="number" path="pQat" id="pQat"
									placeholder="Product Quantity" class="form-controle" />
							</div>
						</div>

						<div class="form-group">
							<lable class="control-lable col-md-4" for="file">Select
							image:</lable>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file"
									class="form-controle" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<lable class="control-lable col-md-4" for="pQat">Select
							Cetogery:</lable>
							<div class="col-md-8">
								<sf:select class="form-control" id="category_id"
									path="category_id" items="${categories}" itemLabel="cName"
									
									itemValue="cId" />
									
									<c:if test="${product.pId==0}">
									<div class="text-right">
									<br/>
									<button type="button" data-toggle="modal" data-target="#categoryModal" class="btn btn-warning btn-xs">Add New Category</button>
									</div>
									</c:if>
									
									

							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="submit"
									placeholder="Product Brand" class="form-controle" />
								<sf:hidden path="pId" />
								<sf:hidden path="pCode" />
								<sf:hidden path="supplier_id" />
								<sf:hidden path="is_active" />
								<sf:hidden path="Purchase" />
								<sf:hidden path="Views" />
							</div>
						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
		<h3>Avilable Products</h3>
		</div>
		<div class="col-xs-12">
			<div style="overflow:auto">
				<table id="adminProductTable"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>&#160;</th>
							<th>NAME</th>
							<th>BRAND</th>
							<th>QUANTITY</th>
							<th>PRICE</th>
							<th>ACTIVE</th>
							<th>EDIT</th>
						</tr>
					</thead>
					
			
					<tfoot>
						<tr>
							<th>ID</th>
							<th>&#160;</th>
							<th>NAME</th>
							<th>BRAND</th>
							<th>QUANTITY</th>
							<th>PRICE</th>
							<th>ACTIVE</th>
							<th>EDIT</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>

<div class="modal fade" id="categoryModal" role="dialog" tabindex="-1">
<div class="modal-dialog" role="document">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">
<span>&times;</span>
</button>
<h4 class="modal-title">Add New Category</h4>
</div>

<div class="modal-body">

<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/admin/category"
method="POST" class="form-horizontal">

<div class="form-group">
<label for="name" class="control-label col-md-4">Category Name:</label>
<div class="col-md-8">
<sf:input type="text" path="cName" id="name" class="form-control"/>
</div>
</div>
<div class="form-group">
<label for="desc" class="control-label col-md-4">Category Description:</label>
<div class="col-md-8">
<sf:textarea type="text" cols="" rows="5" path="cDesc" id="desc" class="form-control"/>
</div>
</div>
<div class="form-group">
<div class="col-md-offset-4 col-md-8">
<input type="submit" value="Add Category" class="btn btn-primary"/>
</sf:form>

</div>
</div>
</div>
</div>
</div>
</div>
</div>