<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.jac.web.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jac.web.model.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
#bookimage {
	width: 20%;
	height: 20%;
}
</style>
</head>

<body>
	<!-- Navbar -->
	<%@ include file="navbar.jsp"%>
	<main class="page container" style="margin-top:10%;">
	<div class="container">
		<h1>The books of The Office</h1>
		
		<div>

			<%
				if (request.getAttribute("result") != null) {
					out.println("<div class='alert alert-danger'>" + request.getAttribute("result") + "</div>");
				}
			 if (request.getAttribute("messageAdd") != null) {
					out.println("<div class='alert alert-success'>" + request.getAttribute("messageAdd") + "</div>");
				}
			%>
			<h4>
				<img id="bookimage"
					src="images/PNGPIX-COM-Open-Book-PNG-Transparent-Image.png" />List
				of books available
			</h4>
			
			<form class="search-form" action="bookSearch" method="get">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"><i class="fa fa-search"></i></span>
					</div>
					<input class="form-control" type="text" name="searchAction"
						id="searchAction"
						placeholder="Please enter the title of the book you are looking for.." />
						<input type="hidden" name="action" id="action" value="employeeSearch">
					<div class="input-group-append">
						<button class="btn btn-info" type="Submit">Search</button>
					</div>
				</div>
			</form>
	
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Book ID</th>
						<th>Title of the book</th>
						<th>Author of the book</th>
					</tr>
				</thead>
				<tbody>
					<%
						if(request.getAttribute("bookList")!=null){
							ArrayList<Book> bookList = (ArrayList<Book>) request.getAttribute("bookList");
							for (int i = 0; i < bookList.size(); i++) {
								Book book = bookList.get(i);
					%>
					<tr>
						<td><%=book.getBookId()%></td>
						<td><%=book.getBookName()%></td>
						<td><%=book.getAuthorName()%></td>
					</tr>
					<%}}else if (request.getAttribute("bookListFresh")!=null){
						ArrayList<Book> bookList = (ArrayList<Book>) request.getAttribute("bookListFresh");
						for (int i = 0; i < bookList.size(); i++) {
							Book book = bookList.get(i);
					 %>
					 <tr>
						<td><%=book.getBookId()%></td>
						<td><%=book.getBookName()%></td>
						<td><%=book.getAuthorName()%></td>
					</tr>
					<%}} %>
				</tbody>
			</table>
			<br />
		</div>



	</div>
	</main>

</body>
</html>