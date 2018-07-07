<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	   <%@page import="com.jac.web.model.Book"%>
     <%@page import= "java.util.ArrayList"%>
    <%@page import="com.jac.web.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<!-- Navbar -->
<%@ include file="navbar.jsp" %>
 <form class="search-form" action="bookSearch" method="get"  style="margin-top:55px;" >
    <div class="input-group">
        <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-search"></i></span></div>
        <input class="form-control" type="text" name="searchAction" id="searchAction" placeholder="Please enter name of book you are looking for.." />
        <div class="input-group-append"><button class="btn btn-light" type="Submit">Search</button></div>
    </div>
</form>
<br>
<main class="page container" style="margin-top:100px;"> 
<div class="container">
<h1>Welcome <% out.print(session.getAttribute("employeeName")); %></h1>
<br>
<div> 
<br>

<%if (request.getAttribute("result") != null) {
	out.println("<div class='alert alert-danger'>"+request.getAttribute("result")+"</div>");} %>	
	<br>
<h4>List of books available</h4> 
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Book ID</th>
    <th>Name of the book</th>
    <th>Author of the book</th> 
      </tr>
    </thead>
    <tbody>
     <% ArrayList<Book> bookList =  (ArrayList<Book>)request.getAttribute("bookList"); 
for (int i=0; i<bookList.size(); i++){
Book book = bookList.get(i); %>
<tr>
<td><%= book.getBookId() %></td>
<td><%= book.getBookName() %>
<td><%= book.getAuthorName() %>


<%}  %>
</tr>
    </tbody>
  </table>	
  </div>



</div>
</main>
</body>
</html>