<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Page</title>
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