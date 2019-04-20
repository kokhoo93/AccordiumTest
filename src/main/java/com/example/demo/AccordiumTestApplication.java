package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.collections.Books;
import com.example.demo.repositories.BookRepository;

@RestController
@SpringBootApplication
public class AccordiumTestApplication {
	@Autowired
	public BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(AccordiumTestApplication.class, args);
	}
	
	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Books> listAllBooks() {
		List<Books> bookList = new ArrayList<Books>();
		bookList = bookRepository.findAll();
		return bookList;
	}
}
