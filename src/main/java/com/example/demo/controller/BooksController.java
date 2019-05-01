package com.example.demo.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.BookKeepingService;

@Controller
public class BooksController {
	
	@Resource(name="book")
	public BookKeepingService bks;
	
	//Retrieve all the books that contains the partial author's name from MongoDB and return as String
	@RequestMapping(value = "/bookNameAutoComplete")
	@ResponseBody
	public List<String> listAllBooksByAuthor(@RequestParam(value="term", required = false, defaultValue="") String term) {
		List<String> suggestions = bks.searchByAuthor(term);
		return suggestions;
	}
	
	//landing page
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String landingPage() {
		return "start";
	}
}
