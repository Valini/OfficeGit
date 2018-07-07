<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.navbar-nav{
padding-left: 300px;
}
#login{
padding-left: 1000px;


}
#bookimage{
width:10%;
height:10%;
}

#theoffice{
width:20%;
height:20%;

}

</style>
</head>

<body>
<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="navbar-brand logo" href="#"><img id="bookimage" src="images/PNGPIX-COM-Open-Book-PNG-Transparent-Image.png"/><img id="theoffice" src="images/theoffice.png"/></a>
    </li>
    <li class="nav-item" id="login">
      <% 
				if(session.getAttribute("username") != null) {
					%>
					<a class="nav-link" href="login">Logout</a>
					<%
				} else {
					%>
					<a class="nav-link" href="login">Login</a>
					<%
				}
				%>
    </li>
    
  </ul>
</nav>
</body>
</html>