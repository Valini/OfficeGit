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
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//get employeeName and password from index login page
				response.setContentType("text/html");
				String employeeName = request.getParameter("employeeName");
				String password = request.getParameter("password");
				//check if employeeName and password match in database using DAO
				EmployeeDAO employee = new EmployeeDAO();
				//call method get Employee from DAO to check if this employee exists in database
				Employee s1 = employee.getEmployee(employeeName);
				//check if password entered by employee matches password in database
				if(password.equals(s1.getPassword())) {
					request.setAttribute("employeeName", employeeName);
					request.setAttribute("employee", s1);
					if(employeeName.equals("boss")) {
					RequestDispatcher rd = request.getRequestDispatcher("boss.jsp");
					rd.forward(request, response);
					}
					else  {
						RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
						rd.forward(request, response);
					}
				}else {
					
					request.setAttribute("error", 
							"Wrong username or password.");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				
	}

}
