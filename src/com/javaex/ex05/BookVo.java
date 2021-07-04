package com.javaex.ex05;

public class BookVo {
	
	private int bookId;
	private String title;
	private String pubs;
	private String pubDate;
	private int author_id;
	private String authorName;
	private String authorDesc;
	
	public BookVo () {
		
	}
	public BookVo(int bookId, String title, String pubs, String pubDate, int author_id, String authorName,
			String authorDesc) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.author_id = author_id;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPubs() {
		return pubs;
	}
	public void setPubs(String pubs) {
		this.pubs = pubs;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorDesc() {
		return authorDesc;
	}
	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}
	
	
	
	
	

}
