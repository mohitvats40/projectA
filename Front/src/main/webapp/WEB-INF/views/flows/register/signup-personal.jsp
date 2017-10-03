<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp" %>

	<div class="container">
	<div class="row">
	<div class="col-md-6 col-md-offset-3">
	<div class="panel panel-primary">
	<div class="panel-heading">
	<h4>Register</h4>
	</div>
	<div class="panel-body">
	<sf:form method="POST" class="form-horizontal" 
	id="registerForm" modelAttribute="user">
	
	<div class="form-group">
	<label class="control-label col-md-4">First Name</label>
	<div class="col-md-8">
	<sf:input type="text" path="fname" class="form-control" placeholder="First Name"/>
	<sf:errors path="fname" cssClass="help-block" element="em" />
	</div>
	</div>
	
	<div class="form-group">
	<label class="control-label col-md-4">Last Name</label>
	<div class="col-md-8">
	<sf:input type="text" path="lname" class="form-control" placeholder="Last Name"/>
	<sf:errors path="lname" cssClass="help-block" element="em" />
	</div>
	</div>
	
	<div class="form-group">
	<label class="control-label col-md-4">Email</label>
	<div class="col-md-8">
	<sf:input type="email" path="email" class="form-control" placeholder="email"/>
	<sf:errors path="email" cssClass="help-block" element="em" />
	</div>
	</div>
	
	<div class="form-group">
	<label class="control-label col-md-4">Contact No.</label>
	<div class="col-md-8">
	<sf:input type="text" path="contectno" class="form-control" placeholder="xxxxxxxxxx"
	maxlength="10"/>
	<sf:errors path="contectno" cssClass="help-block" element="em" />
	</div>
	</div>
	
	 <div class="form-group">
	<label class="control-label col-md-4">Password</label>
	<div class="col-md-8">
	<sf:input type="password" path="password" class="form-control" 
	placeholder="Password"/>
	<sf:errors path="password" cssClass="help-block" element="em" />
	</div>
	</div>
	
	 <div class="form-group">
	<label class="control-label col-md-4">Select Role</label>
	<div class="col-md-8">
	<label class="radio-inline">
	<sf:radiobutton path="role" value="USER" checked="checked"/>User
	</label>
	<label class="radio-inline">
	<sf:radiobutton path="role" value="SUPPLIER" />Supplier
	</label>
	</div>
	</div>
	
	
	<div class="form-group">
	<div class="col-md-offset-4 col-md-8">
	<button type="submit" class="btn-btn-primery" name="_eventId_billing">
	next-Billing<span class="glyphicon glypicon-chevron-right"></span>
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