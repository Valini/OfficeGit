<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	   <%@page import="com.jac.web.model.Book"%>
     <%@page import= "java.util.ArrayList"%>
    <%@page import="com.jac.web.model.Employee"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
#bookimage{
width:20%;
height:20%;
}
</style>
</head>

<body>
<!-- Navbar -->
<%@ include file="navbar.jsp" %>
 <form class="search-form" action="bookSearch" method="get"  style="margin-top:105px;" >
    <div class="input-group">
        <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-search"></i></span></div>
        <input class="form-control" type="text" name="searchAction" id="searchAction" placeholder="Please enter the title of the book you are looking for.." />
        <div class="input-group-append"><button class="btn btn-light" type="Submit">Search</button></div>
    </div>
</form>
<br>
<main class="page container" style="margin-top:100px;"> 
<div class="container">
<h1>The books of The Office</h1>
<br>
<div> 
<br>

<%if (request.getAttribute("result") != null) {
	out.println("<div class='alert alert-danger'>"+request.getAttribute("result")+"</div>");} %>	
	<br>
<h4><img id="bookimage" src="images/PNGPIX-COM-Open-Book-PNG-Transparent-Image.png"/>List of books available</h4> 
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Book ID</th>
    <th>Title of the book</th>
    <th>Author of the book</th> 
      </tr>
    </thead>
    <tbody>
     <% ArrayList<Book> bookList =  (ArrayList<Book>)request.getAttribute("bookList"); 
for (int i=0; i<bookList.size(); i++){
Book book = bookList.get(i); %>
<tr>
<td><%= book.getBookId() %></td>
<td><%= book.getBookName() %></td>
<td><%= book.getAuthorName() %></td>
<td><a href="LibraryController?action=Edit&bookId=<c:out value="${book.bookId}" />">Edit</a></td>
<td><a href="LibraryController?action=delete&bookId=<c:out value="${book.bookId}" />">Delete</a></td>


<%}  %>
</tr>
    </tbody>
  </table>
  <br/>
  <p><a href="bookForm.jsp">Add Book</a></p>	
  </div>



</div>
</main>

</body>
</html>