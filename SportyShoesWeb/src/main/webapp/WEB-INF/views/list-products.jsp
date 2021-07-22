<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Product</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>SportShoes - Product Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<input type="button" value="Add Product"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<table>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Code</th>
					<th>Price</th>
					<th>Date Added</th>					
				</tr>

				<c:forEach var="tempProduct" items="${products}">
					<c:url var="updateLink" value="/products/showFormForUpdate">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>

					<c:url var="deleteLink" value="/products/delete">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>

					<tr>
						<td>${tempProduct.name}</td>
						<td>${tempProduct.description}</td>
						<td>${tempProduct.code}</td>
						<td>${tempProduct.price}</td>
						<td>${tempProduct.dateadded}</td>						
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>