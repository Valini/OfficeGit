<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<form action="LibraryController" method="post" name="addBookForm">
		<div class="form-group">
			<label for="bookName">Book Name</label> <input
				class="form-control item" type="text" id="bookName"
				name="bookName" required="required" value="<c:out value="${book.bookName}"/>" />
		</div>
		<div class="form-group">
			<label for="authorName">Author Name</label><input class="form-control"
				type="text" id="authorName" name="authorName" required="required" value="<c:out value="${book.authorName}"/>"/>
		</div>
		<button class="btn btn-primary btn-block" type="submit">Add
			Book</button>
	</form>
</body>
</html>