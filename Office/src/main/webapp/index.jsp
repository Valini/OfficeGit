<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" href="css/bootstrap.min.css">         
<script src="js/bootstrap.min.js"></script> 
</head>
<body>
	<nav class="navbar navbar-dark bg-dark navbar-expand-lg fixed-top clean-navbar">
	<div class="container">
		<a class="navbar-brand logo" href="#">Office</a>
		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#navcol-1">
			<span class="sr-only">Toggle navigation</span><span
				class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navcol-1">
			<ul class="nav navbar-nav ml-auto">
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="index.html">Home</a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					href="login.html">Login</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<main class="page container" style="margin-top:100px;"> 
		<div class="container">
		<section class="clean-block clean-form dark">
			<div class="container">
				<div class="block-heading">
					<h2 class="text-info">Log In</h2>
						<%
							if (request.getAttribute("error") != null) {
								out.println("<div class='alert alert-danger'>"+request.getAttribute("error")+"</div>");
							}
						%>
				</div>
				<form action="login" method="post">
					<div class="form-group">
						<label for="employeeName">Username</label><input
							class="form-control item" type="text" id="employeeName"
							name="employeeName">
					</div>
					<div class="form-group">
						<label for="password">Password</label><input class="form-control"
							type="password" id="password" name="password">
					</div>
					<button class="btn btn-primary btn-block" type="submit">Log In</button>
				</form>
			</div>
		</section> 
		</div>
	</main>

</body>
</html>
