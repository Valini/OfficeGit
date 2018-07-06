<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Boss</title>
</head>
<body>
<!-- Navbar -->
<%@ include file="navbar.jsp" %>
<br>
<main class="page container" style="margin-top:100px;"> 
		<div class="container">
<h1>Welcome <% out.print(session.getAttribute("employeeName")); %></h1>
</div>
</main>
</body>
</html>