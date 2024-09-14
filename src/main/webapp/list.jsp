<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Contact</th>
			<th>Address</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="employee" items="${employeeList}">
			<tr>
				<td>${employee.name}</td>
				<td>${employee.email}</td>
				<td>${employee.contact}</td>
				<td>${employee.address}</td>
				<td>
					<form action="editServlet" method="get">
						<input type="hidden" name="action" value="edit"> <input
							type="hidden" name="id" value="${employee.id}">
						<button type="submit">Edit</button>
					</form> <a href="deleteServlet?id=${employee.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
<a href="logoutServlet">Logout</a>
</body>
</html>