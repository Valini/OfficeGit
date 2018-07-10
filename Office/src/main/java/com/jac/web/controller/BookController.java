package com.jac.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jac.web.dao.LibraryDAO;
import com.jac.web.model.Book;

/**
 * Servlet implementation class BookController
 */
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchBookName = request.getParameter("searchAction");
		// search the database for this book
		if (searchBookName == null || searchBookName.equals("")) {
			// refresh the product list
			LibraryDAO books = new LibraryDAO();
			ArrayList<Book> bookList = books.getAllBooks();
			request.setAttribute("bookList", bookList);
			RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
			rd.forward(request, response);
		} else {
			LibraryDAO books = new LibraryDAO();

			ArrayList<Book> bookList = books.getBooksbyNameLike(searchBookName);
			// if books not available display message else show list of books
			if (bookList.isEmpty()) {
				String result = "Book not available";
				request.setAttribute("result", result);
				request.setAttribute("bookList", bookList);
				RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("bookList", bookList);
				RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
				rd.forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
