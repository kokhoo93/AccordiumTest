package com.example.demo.collections;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booklist")
public class Books {
	private String author;
	private String name;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
