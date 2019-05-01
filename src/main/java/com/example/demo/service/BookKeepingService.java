package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.collections.Books;
import com.example.demo.repositories.BookRepository;

@Service("book")
public class BookKeepingService {
	@Autowired
	public BookRepository bookRepo;
	
	public List<String> searchByAuthor(String name){
		List<Books> bookList = new ArrayList<>();
		List<String> bookName = new ArrayList<>();
		
		bookList = bookRepo.findAllByAuthors(name);
		
		for(int i = 0; i < bookList.size(); i++) {
			bookName.add(bookList.get(i).getName());
		}
		
		return bookName;
	}
}
