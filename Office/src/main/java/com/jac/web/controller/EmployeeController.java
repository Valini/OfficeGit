package com.jac.web.controller;

import java.io.IOException;
import java.util.ArrayList;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeId");
		int id= Integer.parseInt(employeeId);
		EmployeeDAO p1= new EmployeeDAO();
		String result= p1.deleteEmployee(id);
		request.setAttribute("result", result);
		response.setContentType("text/html");
		
		//refresh the product list
				EmployeeDAO employees= new EmployeeDAO();
				ArrayList<Employee> employeeList=employees.getAllEmployees();
				request.setAttribute("employeesList", employeeList);
	RequestDispatcher rd = request.getRequestDispatcher("boss.jsp");
	rd.include(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String action = request.getParameter("action");
		
		if(action.equals("add")) {
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
				RequestDispatcher rd = request.getRequestDispatcher("employeeForm.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("errorAdd", "There was an error adding the employee! Please try again.");
				RequestDispatcher rd = request.getRequestDispatcher("employeeForm.jsp");
				rd.forward(request, response);
			}
		}else if(action.equals("edit")) {
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

			
			if(employeeDAO.updateEmployee(employee)) {
				request.setAttribute("employeeID", request.getParameter("employeeId"));
				request.setAttribute("messageUpdate", "Employee #"+employee.getEmployeeId()+" updated!");
				RequestDispatcher rd = request.getRequestDispatcher("boss.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("employeeID", request.getParameter("employeeId"));
				request.setAttribute("errorUpdate", "There was an error updating the employee! Please try again.");
				RequestDispatcher rd = request.getRequestDispatcher("boss.jsp");
				rd.forward(request, response);
			}
		}
		
	}

}
