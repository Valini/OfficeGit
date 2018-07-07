package com.jac.web.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jac.web.dao.EmployeeDAO;
import com.jac.web.dao.LibraryDAO;
import com.jac.web.model.Book;
import com.jac.web.model.Employee;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//logout
		HttpSession session = request.getSession();
		session.removeAttribute("employeeName");
		session.invalidate();
		
		System.out.println("Logging out, session was removed");
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get employeeName and password from index login page
		response.setContentType("text/html");
		String employeeName = request.getParameter("employeeName");
		String password = request.getParameter("password");
		// check if employeeName and password match in database using DAO
		EmployeeDAO employee = new EmployeeDAO();
		// call method get Employee from DAO to check if this employee exists in
		// database
		Employee e1 = employee.getEmployee(employeeName);
		//if no such employee name exists in the database, return to index page
		if(e1 == null) {
			request.setAttribute("error", "Wrong username or password.");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);	
		}else {
			// check if password entered by employee matches password in database
			if (password.equals(e1.getPassword())) {
				//create session
				HttpSession session = request.getSession();
				session.setAttribute("employeeName", employeeName);
				request.setAttribute("employeeName", employeeName);
				request.setAttribute("employee", e1);
				//get list of books and send to tables- both boss and employee page
				LibraryDAO books= new LibraryDAO();
				ArrayList<Book> bookList=books.getAllBooks();
				request.setAttribute("bookList", bookList);
				
				if (employeeName.equals("boss")) {
					RequestDispatcher rd = request.getRequestDispatcher("boss.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("error", "Wrong username or password.");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
	}

}
