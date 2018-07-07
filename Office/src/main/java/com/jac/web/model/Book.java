package com.jac.web.model;

public class Book {
	
	private int bookId;
	private String bookName;
	private String authorName;
	
	public int getBookId() {
		return bookId;
	}
	public void setId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", getBookId()="
				+ getBookId() + ", getBookName()=" + getBookName() + ", getAuthorName()=" + getAuthorName() + "]";
	}
	
	
	

}
