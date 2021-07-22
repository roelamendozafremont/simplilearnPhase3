<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Category</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>SportShoes - Category Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<input type="button" value="Add Category"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<table>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Code</th>
				</tr>

				<c:forEach var="tempCategory" items="${categories}">
					<c:url var="updateLink" value="/categories/showFormForUpdate">
						<c:param name="categoryId" value="${tempCategory.id}" />
					</c:url>

					<c:url var="deleteLink" value="/categories/delete">
						<c:param name="categoryId" value="${tempCategory.id}" />
					</c:url>

					<tr>
						<td>${tempCategory.name}</td>
						<td>${tempCategory.description}</td>
						<td>${tempCategory.code}</td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this category?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>