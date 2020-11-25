<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="view" method="POST">
    <input type="submit" value="View orders" />
</form>
<form action="make" method="POST">
    <input type="submit" value="Make an order" />
</form>
<form action="modify" method="POST">
    <input type="submit" value="Modify an order" />
</form>
<form action="cancel" method="POST">
    <input type="submit" value="Cancel an order" />
</form>
<form action="logout" method="POST">
    <input type="submit" value="Log out" />
</form>
</body>
</html>