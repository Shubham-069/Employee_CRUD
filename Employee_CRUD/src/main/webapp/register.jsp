<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>Employee Registration</h2>
    <form action="RegisterServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" name="email" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" name="password" required>
        
        <label for="contact">Contact:</label>
        <input type="text" name="contact" required><br><br>
        
        <label for="address">Address:</label>
        <textarea name="address" required></textarea><br><br>
        
        <input type="submit" value="Register">
        
        <div>
        	<a href="login.jsp">Login</a>
        </div>
    </form>
</body>
</html>