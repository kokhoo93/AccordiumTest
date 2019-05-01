package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.collections.Books;

public interface BookRepository extends MongoRepository<Books, String>{
	
	//Retrieve all the books from MongoDB
	@Query(value = "{'author': {$regex : '?0', $options: 'i'}}")
	List<Books> findAllByAuthors(String authorName);
}
