package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	private MyService myService;

	@GetMapping
	public ResponseEntity<String> myMethod() {
		return new ResponseEntity<String>(myService.myService(true), HttpStatus.OK);
	}

}
