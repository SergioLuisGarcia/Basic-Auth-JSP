<%@page import="com.login.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% User u = (User)request.getAttribute("usuario"); %>
	Ola <%= u.getUser() %>
	
	<form action="logout" method="post">
		<input type="submit" value="Sair">
	</form>
</body>
</html>