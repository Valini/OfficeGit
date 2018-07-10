<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Boss Main</title>
</head>
<body>
	<!-- Navbar -->
	<%@ include file="navbar.jsp"%>
	<br>
	<div class="container">
	<div class="row text-center" style="margin-top:150px;">
		<div class="col-lg-6">
			<a href="<% EmployeeDAO dao = new EmployeeDAO();
								request.setAttribute("employeesList", dao.getAllEmployees());
								out.print("boss.jsp");%>"><img src="images/staff.jpg" class="rounded img-fluid img-thumbnail" alt="sraff image" height="50">
								</a>
				<div class="content">
					<h1>Employee List</h1>
				</div>
			</div>
		<div class="col-lg-6">
			<a href="<% LibraryDAO books = new LibraryDAO();
								request.setAttribute("bookList", books.getAllBooks());
								out.print("bookListBoss.jsp");%>"><img src="images/books.jpg" class="rounded img-fluid img-thumbnail" alt="sraff image" height="100">
								</a>
								<div class="content">
					<h1>Book List</h1>
				</div>
		</div>
		
	</div>
</div>
</body>
</html>