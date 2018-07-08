<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Boss</title>
</head>
<body>
<!-- Navbar -->
<%@ include file="navbar.jsp" %>
<br>
<main class="page container" style="margin-top:100px;"> 
		<div class="container">
<h1>Welcome <% out.print(session.getAttribute("employeeName")); %></h1>
<a href="employeeForms.jsp">form</a><br>


<a href="InventoryController">Inventory</a>
</div>
</main>
</body>
</html>