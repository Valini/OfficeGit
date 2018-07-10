<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.jac.web.model.Book"%>
<%@page import="com.jac.web.dao.LibraryDAO"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<!-- Navbar -->
	<%@ include file="navbar.jsp"%>
	<main class="page container" style="margin-top:150px;">
	<%
		if (request.getParameter("bookId") == null) {
	%>
	<form action="LibraryController" method="post">
		<div class="block-heading">
			<h2 class="text-info">Add Book</h2>
			<%
				if (request.getAttribute("errorAdd") != null) {
					out.println("<div class='alert alert-danger'>" + request.getAttribute("errorAdd") + "</div>");
				} 
			%>
		</div>
		<div class="form-group">
			<label for="bookName">Book Name</label> <input
				class="form-control item" type="text" id="bookName" name="bookName"
				required="required" />
		</div>
		<div class="form-group">
			<label for="authorName">Author Name</label><input
				class="form-control" type="text" id="authorName" name="authorName"
				required="required" />
		</div>
		<input type="hidden" name="action" id="action" value="add">
		<button class="btn btn-primary btn-block" type="submit">Add Book</button>
	</form>
	<%} else { %>
	<form action="LibraryController" method="post">
		<div class="block-heading">
			<h2 class="text-info">Edit Book</h2>
			<%
					int bookId = Integer.parseInt(request.getParameter("bookId"));
						LibraryDAO libraryDAO = new LibraryDAO();
						Book book = new Book();
						book = libraryDAO.getBookByID(bookId);
				%>
			<%
				if (request.getAttribute("errorAdd") != null) {
					out.println("<div class='alert alert-danger'>" + request.getAttribute("errorAdd") + "</div>");
				} 
			%>
		</div>
		<div class="form-group">
			<label for="bookName">Book Name</label> <input
				class="form-control item" type="text" id="bookName" name="bookName"
				required="required" value="<%=book.getBookName()%>" />
		</div>
		<div class="form-group">
			<label for="authorName">Author Name</label><input
				class="form-control" type="text" id="authorName" name="authorName"
				required="required" value="<%=book.getAuthorName()%>" />
		</div>
		<input type="hidden" name="bookId" id="bookId" value="<%=book.getBookId()%>">
		<input type="hidden" name="action" id="action" value="edit">
		<button class="btn btn-primary btn-block" type="submit">Edit Book</button>
	</form>
	<%} %>
	</main>
<script src="js/jquery.min.js"></script>
<script src="js/theme.js"></script>
</html>