<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
		<div class="panel panel-primary">
		<div class="panel-heading">
		<h4>Product Management</h4>
		</div>
		<div class="panel-body">
		<!-- form elements -->
		<sf:form class="form-horizontal" modelAttribute="product">
		
		<div class="form-group">
		<lable class="control-lable col-md-4" for="pName">Enter Product Name:</lable>
		<div class="col-md-8">
		<sf:input type="text" path="pName" id="pName" placeholder="Product Name" class="form-controle"/>
		</div>
		</div>
		
		<div class="form-group">
		<lable class="control-lable col-md-4" for="pBrand">Enter Product Brand:</lable>
		<div class="col-md-8">
		<sf:input type="text" path="pBrand" id="pBrand" placeholder="Product Brand" class="form-controle"/>
		</div>
		</div>
		
		<div class="form-group">
		<lable class="control-lable col-md-4" for="pDesc">Enter Product Description:</lable>
		<div class="col-md-8">
		<sf:textarea type="text" path="pDesc" id="pDesc" rows="4" placeholder="Product Description" class="form-controle" />
		
		</div>
		</div>
		
			<div class="form-group">
		<lable class="control-lable col-md-4" for="pPrice">Enter Product UnitPrice:</lable>
		<div class="col-md-8">
		<sf:input type="number" path="pPrice" id="pPrice"  placeholder="unit price in &#8377;" class="form-controle"/>
		</div>
		</div>
		
		<div class="form-group">
		<lable class="control-lable col-md-4" for="pQat">Enter Product Quantity:</lable>
		<div class="col-md-8">
		<sf:input type="number" path="pQat" id="pQat" rows="4" placeholder="Product Quantity" class="form-controle"/>
		</div>
		</div>
		
			<div class="form-group">
		<lable class="control-lable col-md-4" for="pQat">Select Cetogery:</lable>
		<div class="col-md-8">
		<sf:select class="form-control" id="category_id" path="category_id"
		items="${categories}"
		itemLabel="cName"
		itemValue="cId"
		/>
	
		</div>
		</div>
		
			<div class="form-group">
		<div class="col-md-offset-4 col-md-8">
		<input type="submit" name="submit" id="submit" value="submit" placeholder="Product Brand" class="form-controle"/>
		<sf:hidden path="pId"/>
		<sf:hidden path="pCode"/>
		<sf:hidden path="supplier_id"/>
		<sf:hidden path="is_active"/>
		<sf:hidden path="Purchase"/>
			<sf:hidden path="Views"/>
		</div>
		</div>
		
		</sf:form>
		</div>
		</div>
		</div>
	</div>
</div>