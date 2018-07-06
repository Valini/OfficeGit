package com.jac.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jac.web.dao.EmployeeDAO;
import com.jac.web.model.Employee;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String employeeName = request.getParameter("employeeName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		
		Employee employee = new Employee();
		employee.setEmployeeName(employeeName);
		employee.setPassword(password);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setCity(city);
		employee.setPostalCode(postalCode);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		if(employeeDAO.addEmployee(employee)) {
			request.setAttribute("messageAdd", "New employee added to the list!");
			RequestDispatcher rd = request.getRequestDispatcher("employeeForms.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("errorAdd", "There was an error adding the employee! Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("employeeForms.jsp");
			rd.forward(request, response);
		}
	}

}
