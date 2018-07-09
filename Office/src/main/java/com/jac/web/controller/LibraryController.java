package com.jac.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jac.web.dao.LibraryDAO;
import com.jac.web.model.Book;

/**
 * Servlet implementation class LibraryCOntroller
 */
public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Book book = new Book();
		String bookName = request.getParameter("bookName");
		String authorName = request.getParameter("authorName");
		
		book.setBookName(bookName);
		book.setAuthorName(authorName);
		
		LibraryDAO libraryDAO = new LibraryDAO();
		if(libraryDAO.addBook(book)) {
			RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
			rd.forward(request, response);
		}
		
	}

}
