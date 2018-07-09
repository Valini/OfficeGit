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
 * Servlet implementation class LibraryController
 */
public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		int id = Integer.parseInt(bookId);
		LibraryDAO b1 = new LibraryDAO();
		b1.deleteBook(id);

		response.setContentType("text/html");

		// refresh the product list
		LibraryDAO dao = new LibraryDAO();
		ArrayList<Book> bookList = dao.getAllBooks();
		request.setAttribute("bookList", bookList);
		RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
		rd.include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String action = request.getParameter("action");

		if (action.equals("add")) {
			String bookName = request.getParameter("bookName");
			String authorName = request.getParameter("authorName");

			Book book = new Book();
			LibraryDAO dao = new LibraryDAO();

			book.setBookName(bookName);
			book.setAuthorName(authorName);

			if (dao.addBook(book)) {
				request.setAttribute("messageAdd", "New Book added to the list!");
				LibraryDAO books = new LibraryDAO();
				ArrayList<Book> bookList = books.getAllBooks();
				request.setAttribute("bookList", bookList);
				RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("errorAdd", "There was an error adding the book! Please try again.");
				RequestDispatcher rd = request.getRequestDispatcher("bookForm.jsp");
				rd.forward(request, response);
			}
		} else if (action.equals("edit")) {
			
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			String bookName = request.getParameter("bookName");
			String authorName = request.getParameter("authorName");

			Book book = new Book();
			LibraryDAO dao = new LibraryDAO();
			
			book.setId(bookId);
			book.setBookName(bookName);
			book.setAuthorName(authorName);
			
			if (dao.updateBook(book)) {
				request.setAttribute("bookId", request.getParameter("bookId"));
				request.setAttribute("messageUpdate", "Book #" + book.getBookId() + " updated!");
				RequestDispatcher rd = request.getRequestDispatcher("boss.jsp");
				rd.forward(request, response);
			}

			else {
				request.setAttribute("bookId", request.getParameter("bookId"));
				request.setAttribute("errorUpdate", "There was an error updating the book! Please try again.");
				RequestDispatcher rd = request.getRequestDispatcher("boss.jsp");
				rd.forward(request, response);
			}
		}

	}

}
