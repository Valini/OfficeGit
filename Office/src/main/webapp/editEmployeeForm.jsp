<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.jac.web.model.Employee"%>
<%@page import="com.jac.web.dao.EmployeeDAO"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">         
<script src="js/bootstrap.min.js"></script> 
<title>EDit Employee form</title>
</head>
<body>
<!-- Navbar -->
<%@ include file="navbar.jsp" %>
	<main class="page container" style="margin-top:150px;">
	<div class="container">
		<section class="clean-block clean-form dark">
		<div class="container">
			<div class="block-heading">
				<h2 class="text-info">Edit Employee</h2>
				<%
				int employeeID = Integer.parseInt(request.getParameter("employeeID"));
				EmployeeDAO employeeDAO = new EmployeeDAO();
				Employee employee = new Employee();
				employee = employeeDAO.getEmployeeByID(employeeID);
				%>
			</div>
			<form action="EditEmployee" method="post">
				<div class="form-group">
					<label for="employeeName">Employee Name</label><input
						class="form-control item" type="text" id="employeeName"
						name="employeeName" required="true" value="<% out.print(employee.getEmployeeName()); %>">
				</div>
				<div class="form-group">
					<label for="password">Password</label><input class="form-control"
						type="password" id="password" name="password" required="true" value="<% out.print(employee.getPassword()); %>">
				</div>
				<div class="form-group">
					<label for="firstName">First name</label><input
						class="form-control item" type="text" id="firstName"
						name="firstName" required="true" value="<% out.print(employee.getFirstName()); %>">
				</div>
				<div class="form-group">
					<label for="lastName">Last name</label><input
						class="form-control item" type="text" id="lastName"
						name="lastName" required="true" value="<% out.print(employee.getLastName()); %>">
				</div>
				<div class="form-group">
					<label for="city">City</label><input
						class="form-control item" type="text" id="city"
						name="city" value="<% out.print(employee.getCity()); %>">
				</div>
				<div class="form-group">
					<label for="postalCode">Postal Code</label><input
						class="form-control item" type="text" id="postalCode"
						name="postalCode" value="<% out.print(employee.getPostalCode()); %>">
				</div>
				<input type="hidden" id="employeeId" name="employeeId" value="<% out.print(employee.getEmployeeId());%>">
				<button class="btn btn-primary btn-block" type="submit">Edit Employee</button>
			</form>
		</div>
		</section>
	</div>
	
	</main>
</body>
</html>