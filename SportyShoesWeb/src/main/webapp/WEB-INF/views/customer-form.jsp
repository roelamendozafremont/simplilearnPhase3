<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

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
			<h2>SportyShoes - Customer Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Update Customer</h3>
	

		<form:form action="saveCustomer" modelAttribute="customer" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstname" /></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastname" /></td>
					</tr>
					<tr>
						<td><label>Email ID:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label>Address:</label></td>
						<td><form:input path="address" /></td>
					</tr>
					<tr>
						<td><label>Credit Number:</label></td>
						<td><form:input path="creditnumber" /></td>
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
			<a href="${pageContext.request.contextPath}/customers/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>
		