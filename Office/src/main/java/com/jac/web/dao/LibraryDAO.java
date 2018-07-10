package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jac.web.model.Book;
import com.jac.web.model.Employee;


public class LibraryDAO {
	
	
	
	public LibraryDAO() {
		
	}
	
	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> bookList = new ArrayList<Book>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");
			String query = "SELECT * from books"; 
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				int idFromDB = rs.getInt("bookID");
				String bookNameFromDB = rs.getString("bookName");
				String authorNameFromDB = rs.getString("authorName");
				
				book.setId(idFromDB);
				book.setBookName(bookNameFromDB);
				book.setAuthorName(authorNameFromDB);

				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	
	public ArrayList<Book> getBooksbyNameLike(String bookName) {
		ArrayList<Book> booksInDB= new ArrayList<Book>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");
			
			String query = "select * from books where bookName Like ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, "%" + bookName + "%");
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Book p1 = new Book();
				int bookIdFromDB=rs.getInt("bookId");
				String bookNameFromDB = rs.getString("bookName");
				String authorNameFromDB = rs.getString("authorName");
				
				p1.setId(bookIdFromDB);
				p1.setBookName(bookNameFromDB);
				p1.setAuthorName(authorNameFromDB);
				booksInDB.add(p1);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return booksInDB;
	}

	public boolean addBook(Book book) {
		boolean success = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");
			// the mysql insert statement
			String query = "INSERT INTO books (bookName, authorName) "
					+ " VALUES (?, ?)";

			// create the mysql insert prepared statement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, book.getBookName());
			preparedStmt.setString(2, book.getAuthorName());

			// execute the prepared statement
			int count = preparedStmt.executeUpdate();
			con.close();

			if (count > 0) {
				success = true;
			} else {
				success = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean deleteBook(int ID) {
		boolean success = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");
			// the mysql insert statement
			String query = "DELETE FROM books WHERE bookId= ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, ID);

			// execute the prepared statement
			int count = preparedStmt.executeUpdate();
			if (count > 0) {
				success= true;
				
			} else {
				success= false;
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean updateBook(Book book) {
		boolean success=false;
		try {
			// create a java mysql database connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");

			// create the java mysql update prepared statement
			String query = "UPDATE books set bookName=?, authorName=? "
					+ "where bookId= ?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, book.getBookName());
			preparedStmt.setString(2, book.getAuthorName());
			preparedStmt.setInt(3, book.getBookId());

			// execute the java prepared statement
			int count = preparedStmt.executeUpdate();

			con.close();
			if (count > 0) {
				success = true;
			} else {
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public Book getBookByID(int ID) {
		Book s1 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");
			String query = "SELECT * from books where bookId=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, ID);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				s1 = new Book();
				int bookIDFromDB = rs.getInt("bookId");
				String bookNameFromDB = rs.getString("bookName");
				String authorNameFromDB = rs.getString("authorName");
				
				s1.setId(bookIDFromDB);
				s1.setBookName(bookNameFromDB);
				s1.setAuthorName(authorNameFromDB);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
}