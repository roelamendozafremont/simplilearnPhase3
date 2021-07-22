<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Admin</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-domain-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>SportyShoes - Admin Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Update Admin</h3>
	

		<form:form action="saveAdmin" modelAttribute="admin" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
				
					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	

	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/admins/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>
		