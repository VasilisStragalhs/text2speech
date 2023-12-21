package model;

import java.io.Serializable;

public class Doc implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private String date;
	private String contents;
	private String saveDate;
	public Doc() {
	};

	public Doc(String title, String author, String date, String contents, String saveDate) {
		this.title = title;
		this.author = author;
		this.date = date;
		this.contents = contents;
		this.saveDate = saveDate;
	}


	public String toString() {
		return "title:" + title + "\nAuthor: " + author + "\nDateCreated: " + date + "\nDateLastSaved: " + saveDate+ "\nContents: " + contents ;
	}
	
	public String getContents() {
		return this.contents;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getDate() {
		return this.date;
	}
	
	public String getSaveDate() {
		return this.saveDate;
	}
	
}

