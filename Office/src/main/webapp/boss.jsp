<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.jac.web.model.Employee"%>
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

	<div class="container" style="margin-top: 7%;">


		<h1>List of Employees</h1>

		<%
			if (request.getAttribute("employeesList") != null) {

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

			<%
				for (Employee e : list) {
						int id = e.getEmployeeId();
						String firstName = e.getFirstName();
						String lastName = e.getLastName();
						String city = e.getCity();
						String postal = e.getPostalCode();
			%>

			<tr>
				<td><%=id%></td>
				<td><%=firstName%></td>
				<td><%=lastName%></td>
				<td><%=city%></td>
				<td><%=postal%></td>
				<td><form action="EmployeeController" method="get">
						<input type="hidden" name="employeeId"
							value="<%=e.getEmployeeId()%>">
						<button class="btn btn-secondary" type="submit">Delete</button>
					</form>
				<td>
				<td><a class="btn btn-secondary"
					href="employeeForm.jsp?employeeID=<%=e.getEmployeeId()%>">Edit</a></td>

			</tr>


			<%
				}
			%>


		</table>

		<%
			if (request.getAttribute("status") != null) {
		%>
		<p class="lead"><%=request.getAttribute("status")%></p>
		<%
			}
			}
		%>
		<a href="employeeForm.jsp" class="btn btn-secondary">Add Employee</a>
		<%
			if (request.getAttribute("errorUpdate") != null) {
				out.println("<div class='alert alert-danger'>" + request.getAttribute("errorUpdate") + "</div>");
			} else if (request.getAttribute("messageUpdate") != null) {
				out.println("<div class='alert alert-success'>" + request.getAttribute("messageUpdate") + "</div>");
			}
		%>
		<br> <br> <!-- <a class="btn btn-secondary"
			href="InventoryController">Book List</a> -->
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/theme.js"></script>
</body>
</html>