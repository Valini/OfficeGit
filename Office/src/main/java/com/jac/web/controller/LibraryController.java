package com.jac.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jac.web.dao.LibraryDAO;
import com.jac.web.model.Book;

public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String InsertOrEdit = "bookForm.jsp";
	private static String BookList = "employee.jsp";

	private LibraryDAO dao;
	ApplicationContext context;

	public LibraryController() {
		super();
		context = new ClassPathXmlApplicationContext("beans.xml");
		dao = (LibraryDAO) context.getBean("LibraryDAO");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		// To delete a product
		if (action.equalsIgnoreCase("delete")) {
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			dao.deleteBook(bookId);
			forward = BookList;
			request.setAttribute("books", dao.getAllBooks());
		} // To edit a product
		else if (action.equalsIgnoreCase("edit")) {
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			forward = InsertOrEdit;
			Book book = dao.getBookById(bookId);
			request.setAttribute("book", book);
		} else {
			forward = InsertOrEdit; //forward to add a book form
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// Book in database
		Book book = (Book)context.getBean("book");
		book.setBookName(request.getParameter("bookName"));
		book.setAuthorName(request.getParameter("authorName"));
		String bookId = request.getParameter("bookId");
		if (bookId == null || bookId.isEmpty()) {
			dao.addBook(book);
		} else {
			book.setId(Integer.parseInt(bookId));
			dao.updateBook(book);
		}

		RequestDispatcher view = request.getRequestDispatcher(BookList);
		request.setAttribute("books", dao.getAllBooks());
		view.forward(request, response);
	}

}
