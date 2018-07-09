<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<style>
#bookimage {
	width: 50%;
}
</style>
</head>
<body>
	<!-- Navbar -->
	<%@ include file="navbar.jsp"%>
	<main class="page container" style="margin-top:100px;">
	<div class="container">
		<section class="clean-block clean-form dark">
		<div class="container">
			<div class="block-heading">
				<br> <br>
				
				<h2 class="text-info">Log In</h2>
				<%
					if (request.getAttribute("error") != null) {
						out.println("<div class='alert alert-danger'>" + request.getAttribute("error") + "</div>");
					}
				%>
			</div>

			<form action="login" method="post">
				<div class="form-group">
					<label for="employeeName">Username</label><input
						class="form-control item" type="text" id="employeeName"
						name="employeeName" required="true">
				</div>
				<div class="form-group">
					<label for="password">Password</label><input class="form-control"
						type="password" id="password" name="password" required="true">
				</div>
				<button class="btn btn-primary btn-block" type="submit">Log
					In</button>
			</form>
		</div>
		</section>
	</div>
	</main>
</body>
</html>
