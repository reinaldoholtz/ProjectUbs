<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Supermarket</title>
</head>
<body>
	<h2>Add Product</h2>	
	<form:form method="post" action="/product/save.html" modelAttribute="productForm">
	<table>
	  <tr>
		 <td>Product :</td>
		 <td><input name="item" value="${productForm.item}" size="5" /></td>
		 <c:choose>
			<c:when test="${productForm.finalize == false}">
			  <td><input type="submit" name="action" value="Add"/></td>
			</c:when>	
		 </c:choose>		 
	  </tr>
	</table>
	<h4><c:out value="${productForm.message}" /></h4> 		
	</form:form>	
	<c:choose>
	<c:when test="${productForm.add == true}">
		<form:form method="get" action="/product/finalize.html" modelAttribute="productForm">
			<input type="submit" value="Finalize" />
		</form:form>		
	</c:when>	
	</c:choose>
	
	<br/>
	<h2>Products</h2>
	<table>
			<tr>
				<th>Item</th>
				<th>Description</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${productForm.products}" var="product">
				<tr>
					<td>${product.item}</td>
					<td>${product.description}</td>
					<td>${product.unitPrice}</td>
				</tr>				
			</c:forEach>			
			<tr>
			<c:forEach items="${productForm.productsDiscount}" var="productDiscount">
				<tr>
					<td></td>
					<td>${productDiscount}</td>					
					<td></td>
				</tr>				
			</c:forEach>		
			</tr>			
			<tr>
			    <td>Total</td>
				<td>Price</td>
				<td>${productForm.totalPrice}</td>
			</tr>
	</table>
	<c:choose>
		<c:when test="${productForm.finalize == true}">
			<form:form method="get" action="/product/index.html" modelAttribute="productForm">
			<input type="submit" value="Ok" />
			</form:form>		
		</c:when>	
	</c:choose>
</body>
</html>