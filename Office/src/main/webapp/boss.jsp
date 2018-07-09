<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="com.jac.web.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Boss</title>
</head>
<body>

	<!-- Navbar -->
	<%@ include file="navbar.jsp"%>
	<br>
	
		<!--  can only be accessed by the boss -->

		<div class="container" style="margin-top:7%;">
			
			
			<h1>Welcome <%= session.getAttribute("employeeName") %> </h1>
					
			<% if (request.getAttribute("employeesList") != null) { 
		
			ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("employeesList"); 
			%>
			
			<table class="table">
			<tr>
				<th>Employee ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>City</th>
				<th>Postal Code</th>
			</tr>
			
			<% for (Employee e : list) { 
				int id = e.getEmployeeId();
				String firstName = e.getFirstName();
				String lastName = e.getLastName();
				String city = e.getCity();
				String postal = e.getPostalCode();
			%>
				
				
				
				<tr>
					<td><%= id %></td>
					<td><%= firstName %></td>
					<td><%= lastName %></td>
					<td><%= city %></td>
					<td><%= postal %></td>


					<td><form action="EmployeeController" method="get" ><input type="hidden" name="employeeId" value="<%=  e.getEmployeeId() %>"><button class="btn btn-primary" type="submit">Delete</button></form><td>
					
					
					<td><a class="btn btn-primary" href="employeeForm.jsp?employeeID=<%=e.getEmployeeId()%>">Edit</a>	

					

					
				</tr>
				
	
			<% } %>
				
			
			</table>
			
			<td><a class="btn btn-outline-primary" href="employeeForm.jsp">Add</a>	
			
			<% if (request.getAttribute("status") != null) { %>
				<p class="lead"><%= request.getAttribute("status") %></p>
			<% } 
			}
			
			%>
				<a href="employeeForm.jsp" class="btn btn-primary">Add Employee</a>		
		<%
		if (request.getAttribute("errorUpdate") != null) {
			out.println("<div class='alert alert-danger'>" + request.getAttribute("errorUpdate") + "</div>");
		} 
		else if (request.getAttribute("messageUpdate") != null) {
			out.println("<div class='alert alert-success'>" + request.getAttribute("messageUpdate") + "</div>");
		}
		%>
		


	<a href="InventoryController">Product Inventory</a>
		
		

		</div>
</body>
</html>