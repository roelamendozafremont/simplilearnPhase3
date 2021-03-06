<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Admins</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>SportShoes - Admin Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Admin -->

			<input type="button" value="Add Admin"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!--  add our html table here -->

			<table>
				<tr>
					<th>Name</th>
					<th>Password</th>
					<th>Email</th>
				</tr>

				<!-- loop over and print our admin -->
				<c:forEach var="tempAdmin" items="${admins}">

					<!-- construct an "update" link with admin id -->
					<c:url var="updateLink" value="/admins/showFormForUpdate">
						<c:param name="adminId" value="${tempAdmin.id}" />
					</c:url>

					<!-- construct an "delete" link with admin id -->
					<c:url var="deleteLink" value="/admins/delete">
						<c:param name="adminId" value="${tempAdmin.id}" />
					</c:url>

					<tr>
						<td>${tempAdmin.name}</td>
						<td>${tempAdmin.password}</td>
						<td>${tempAdmin.email}</td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this admin?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>