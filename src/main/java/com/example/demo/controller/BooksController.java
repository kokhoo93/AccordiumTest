package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.collections.Books;
import com.example.demo.repositories.BookRepository;

@Controller
public class BooksController {
	
	@Autowired
	public BookRepository bookRepository;
	
	//Retrieve all the books that contains the partial author's name from MongoDB and return as String
	@RequestMapping(value = "/bookNameAutoComplete")
	@ResponseBody
	public List<String> listAllBooksByAuthor(@RequestParam(value="term", required = false, defaultValue="") String term) {
		List<Books> bookList = new ArrayList<Books>();
		List<String> suggestions = new ArrayList<String>();
		bookList = bookRepository.findAll();
		for(Books book : bookList) {
			if(book.getAuthor().toLowerCase().contains(term)) {
				suggestions.add(book.getName());
			}
		}
		return suggestions;
	}
	
	//landing page
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String landingPage() {
		return "start";
	}
}
