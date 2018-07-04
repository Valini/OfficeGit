package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jac.web.model.Book;

public class LibraryDAO {
	
	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");
			String query = "SELECT * from libray"; //NOT SURE ABOUT THE TABLE NAME
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Book book = new Book();
				int idFromDB = rs.getInt("bookID");
				String nameFromDB = rs.getString("bookName");
				String priceFromDB = rs.getString("authorName");
				
				book.setId(idFromDB);
				book.setBookName(nameFromDB);
				book.setAuthorName(priceFromDB);

				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}
}
