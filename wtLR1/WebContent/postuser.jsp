<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <p>Login: <%= request.getParameter("login") %></p>
        <p>Password: <%= request.getParameter("password") %></p>
</body>
</html>