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
	<%@ include file="navbar.jsp"%>
	<br>
	<main class="page container" style="margin-top:100px;">
	<div class="container">
		<h1>
			Welcome
			<%
			out.print(session.getAttribute("employeeName"));
		%>
		</h1>
		<%
			if (request.getAttribute("errorUpdate") != null) {
				out.println("<div class='alert alert-danger'>" + request.getAttribute("errorUpdate") + "</div>");
			} else if (request.getAttribute("messageUpdate") != null) {
				out.println("<div class='alert alert-success'>" + request.getAttribute("messageUpdate") + "</div>");
			}
		%>
		<a href="employeeForm.jsp">form</a><br /> <a
			class="btn btn-outline-primary" href="employeeForm.jsp?employeeID=3">Edit</a><br />


		<a href="InventoryController">Inventory</a>
	</div>
	</main>
</body>
</html>