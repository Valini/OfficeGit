package com.jac.web.model;

public class Library {
	
	private int id;
	private String bookName;
	private String authorName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Library [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", getId()=" + getId()
				+ ", getBookName()=" + getBookName() + ", getAuthorName()=" + getAuthorName() + "]";
	}
	
	

}
