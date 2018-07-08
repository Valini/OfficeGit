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
 * Servlet implementation class EditEmployeeController
 */
public class EditEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String employeeName = request.getParameter("employeeName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setPassword(password);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setCity(city);
		employee.setPostalCode(postalCode);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.updateEmployee(employee);
		/*
		if(employeeDAO.updateEmployee(employee)) {
			request.setAttribute("messageUpdate", "New employee updated!");
			RequestDispatcher rd = request.getRequestDispatcher("employeeForms.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("errorUpdate", "There was an error updating the employee! Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("employeeForms.jsp");
			rd.forward(request, response);
		}*/
		
	}

}
