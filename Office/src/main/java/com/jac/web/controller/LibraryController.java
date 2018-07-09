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
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String bookName = request.getParameter("bookName");
		String authorName = request.getParameter("authorName");
		
		Book book = new Book();
		LibraryDAO dao = new LibraryDAO();
		
		book.setBookName(bookName);
		book.setAuthorName(authorName);
		
		if(dao.addBook(book)) {
			request.setAttribute("messageAdd", "New Book added to the list!");
			LibraryDAO books= new LibraryDAO();
			ArrayList<Book> bookList=books.getAllBooks();
			request.setAttribute("bookList", bookList);
			RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("errorAdd", "There was an error adding the book! Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("bookForm.jsp");
			rd.forward(request, response);
		}
		
	}

}
