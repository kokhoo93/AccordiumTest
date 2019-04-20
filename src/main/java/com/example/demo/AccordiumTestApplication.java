package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AccordiumTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccordiumTestApplication.class, args);
	}
	
	@RequestMapping(value = "/")
	public static String demo() {
		return "Hello World";
	}
}
