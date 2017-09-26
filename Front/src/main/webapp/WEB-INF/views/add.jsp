<p class="lead">shop name</p>
<div class="list-group">
<c:forEach items="${categories}" var="category">
<a href="${contextRoot}/show/category/${category.cId}/products" class="list-group-item" id="a_${category.cName}">${category.cName}</a>
</c:forEach>


</div>