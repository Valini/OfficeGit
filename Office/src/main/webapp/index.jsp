<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Welcome to the Office</h2>
<p><% if(request.getAttribute("error")!= null){
		out.println(request.getAttribute("error"));		
}%></p>
<form action="login" method="post">
		<label>Employee name:</label> 
		<input type="text" name="employeeName" /><br>
		<label>Password: </label>
		<input type="password" name="password" /><br>
		<button type="submit">Login</button>
	</form>
</body>
</html>
