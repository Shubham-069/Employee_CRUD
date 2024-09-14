<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h2>Edit Employee</h2>
    <form action="editServlet" method="post">
        <input type="hidden" name="id" value="${employee.id}">
        
        <label for="name">Name:</label>
        <input type="text" name="name" value="${employee.name}" required><br><br>
		<%--  <p>ID: ${employee.id}</p>
<p>Name: ${employee.name}</p> --%>

		<label for="email">Email:</label>
        <input type="email" name="email" value="${employee.email}" required><br><br>
        
        <label for="contact">Contact:</label>
        <input type="text" name="contact" value="${employee.contact}" required><br><br>
        
        <label for="address">Address:</label>
        <textarea name="address" required>${employee.address}</textarea><br><br>
        
        <input type="submit" value="Update">
    </form>


</body>
</html>