<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.jac.web.dao.EmployeeDAO"%>
	<%@page import="com.jac.web.dao.LibraryDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Office</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<style>
#theoffice {
	width: 50%;
	height: 25%
}
</style>
</head>
<body>
	<nav
		class="navbar navbar-dark bg-dark navbar-expand-lg fixed-top clean-navbar">
		<div class="container">
			<a class="navbar-brand logo" href="<%
							if (session.getAttribute("employeeName") == null){
								out.print("index.jsp");
							}else if (session.getAttribute("employeeName").equals("boss"))  {
								EmployeeDAO dao = new EmployeeDAO();
								request.setAttribute("bookListFresh", dao.getAllEmployees());
								out.print("bossMain.jsp");
							}else{
								LibraryDAO books = new LibraryDAO();
								request.setAttribute("bookListFresh", books.getAllBooks());
								out.print("employee.jsp");
							}
						%> "><img id="theoffice"
				src="images/theoffice.png" /></a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navcol-1">
				<span class="sr-only">Toggle navigation</span><span
					class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navcol-1">
				<ul class="nav navbar-nav ml-auto">
					<% if (session.getAttribute("employeeName") != null) {%>
					<% if  (session.getAttribute("employeeName").equals("boss")){ %>
						<li class="nav-item" role="presentation">
						<a class="nav-link" href="<% EmployeeDAO dao = new EmployeeDAO();
								request.setAttribute("employeesList", dao.getAllEmployees());
								out.print("boss.jsp");%>">Employee List</a>
						</li>
						<li class="nav-item" role="presentation">
						<a class="nav-link" href="<% LibraryDAO books = new LibraryDAO();
								request.setAttribute("bookListFresh", books.getAllBooks());
								out.print("bookListBoss.jsp");%>">Book List</a>
						</li>
					<%} else{ %>
						<li class="nav-item" role="presentation">
						<a class="nav-link" href="<% LibraryDAO books = new LibraryDAO();
								request.setAttribute("bookListFresh", books.getAllBooks());
								out.print("employee.jsp");%>">Book List</a>
						</li>
					<%} %>
					<%} %>
					<li class="nav-item" role="presentation">
						<%
							if (session.getAttribute("employeeName") != null) {
						%> <div class="nav-link active">Welcome <%
 	out.print(session.getAttribute("employeeName"));
 %></div>
						<%
							} else {
						%> <a class="nav-link" href="login"></a> <%
 	}
 %>
					</li>
					<li class="nav-item" role="presentation">
						<%
							if (session.getAttribute("employeeName") != null) {
						%> <a class="nav-link" href="login">Logout</a> <%
 	} else {
 %> <a class="nav-link" href="login">Login</a> <%
 	}
 %>
					</li>
				</ul>
			</div>
		</div>
	</nav>
<script src="js/jquery.min.js"></script>
<script src="js/theme.js"></script>
</body>
</html>