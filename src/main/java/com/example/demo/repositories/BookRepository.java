package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.collections.Books;

public interface BookRepository extends MongoRepository<Books, String>{
	
	//Retrieve all the books from MongoDB
	List<Books> findAll();
}
