<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">         
<script src="js/bootstrap.min.js"></script> 
</head>
<body>
<nav class="navbar navbar-dark bg-dark navbar-expand-lg fixed-top clean-navbar">
	<div class="container">
		<a class="navbar-brand logo" href="index.jsp">Office</a>
		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#navcol-1">
			<span class="sr-only">Toggle navigation</span><span
				class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navcol-1">
			<ul class="nav navbar-nav ml-auto">
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="index.jsp">Home</a></li>
				<li class="nav-item" role="presentation"><% 
				if(session.getAttribute("employeeName") != null) {
					%>
					<a class="nav-link" href="login">Logout</a>
					<%
				} else {
					%>
					<a class="nav-link" href="login">Login</a>
					<%
				}
				%></li>
			</ul>
		</div>
	</div>
	</nav>

</body>
</html>