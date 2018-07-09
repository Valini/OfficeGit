<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<form action="LibraryController" method="post">
		<div class="form-group">
			<label for="bookName">Book Name</label> <input
				class="form-control item" type="text" id="bookName"
				name="bookName" required="required" />
		</div>
		<div class="form-group">
			<label for="authorName">Author Name</label><input class="form-control"
				type="text" id="authorName" name="authorName" required="required" />
		</div>
		<button class="btn btn-primary btn-block" type="submit">Add Book</button>
	</form>
</body>
</html>