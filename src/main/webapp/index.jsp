<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<% List<String> erros = (List)request.getAttribute("erros"); %>
	<% if(erros != null){ %>
		<%for(int i=0; i < erros.size(); i++) {%>
			<p><%= erros.get(i) %></p>
		<%} %>
	<%} %>

	<form action="login" method="post">
		User: <input type="text" name="uname">
		Password <input type="password" name="pass">
		<button type="submit">Entrar</button>
	</form>

</body>
</html>