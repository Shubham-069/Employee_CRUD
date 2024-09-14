<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Employee Login</h2>
    <form action="LoginServlet" method="post">
        <label for="email">Email:</label>
        <input type="email" name="email" required><br><br>
        
       <label for="password">Password:</label>
        <input type="password" name="password" required><br><br>
        
        <input type="submit" value="Login">
        
         
        <a href="register.jsp">Sign up</a>
        
    </form>
</body>
</html>