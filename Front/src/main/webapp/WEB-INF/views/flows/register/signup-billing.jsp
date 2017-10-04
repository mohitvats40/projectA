<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp" %>

	<div class="container">
	<div class="row">
	<div class="col-md-6 col-md-offset-3">
	<div class="panel panel-primary">
	<div class="panel-heading">
	<h4>Address</h4>
	</div>
	<div class="panel-body">
	<sf:form method="POST" class="form-horizontal" 
	id="billingForm" modelAttribute="billing">
	
	<div class="form-group">
	<label class="control-label col-md-4"  for="addressLine1">Address Line One</label>
	<div class="col-md-8">
	<sf:input type="text" path="addressLine1" class="form-control" placeholder="Enter Address Line One"/>
	<sf:errors path="addressLine1" cssClass="help-block" element="em" />
	</div>
	</div>
	
	<div class="form-group">
	<label class="control-label col-md-4" for="addessLine2">Address Line two</label>
	<div class="col-md-8">
	<sf:input type="text" path="addessLine2" class="form-control" placeholder="Enter Address Line two"/>
	<sf:errors path="addessLine2" cssClass="help-block" element="em" />
	</div>
	
	</div>
	
	<div class="form-group">
	<label class="control-label col-md-4"  for="city">City</label>
	<div class="col-md-8">
	<sf:input type="text" path="city" class="form-control" 
	placeholder="Enter city"/>
	<sf:errors path="city" cssClass="help-block" element="em" />
	</div>
	</div>
	
	<div class="form-group">
	<label class="control-label col-md-4"  for="postalCode">Postal Code</label>
	<div class="col-md-8">
	<sf:input type="text" path="postalCode" class="form-control" 
	placeholder="Enter Postal code"/>
	<sf:errors path="postalCode" cssClass="help-block" element="em" />
	</div>
	</div>
	
	<div class="form-group">
	<label class="control-label col-md-4"  for="state">State</label>
	<div class="col-md-8">
	<sf:input type="text" path="state" class="form-control" 
	placeholder="Enter State Name"/>
	<sf:errors path="state" cssClass="help-block" element="em" />
	</div>
	</div>
	
	<div class="form-group">
	<label class="control-label col-md-4"  for="countery">Countery</label>
	<div class="col-md-8">
	<sf:input type="text" path="countery" class="form-control" 
	placeholder="Enter Countery Name"/>
	<sf:errors path="countery" cssClass="help-block" element="em" />
	</div>
	</div>
	
	<div class="form-group">
	<div class="col-md-offset-4 col-md-8">
	<button type="submit" class="btn btn-primery" name="_eventId_personal">
	<span class="glyphicon glypicon-chevron-left"></span> Previous-Personal
	</button>
	<button type="submit" class="btn btn-primery" name="_eventId_confirm">
	Next-Confirm <span class="glyphicon glypicon-chevron-right"></span>
	</button>
	</div>
	</div>
	
	
	</sf:form>
	</div>
	</div>
	</div>
	</div>
	</div>
	

<%@include file="../shared/flows-footer.jsp" %>