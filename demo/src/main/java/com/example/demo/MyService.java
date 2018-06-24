package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	public String myService(boolean result) {
		if (result) {
			throw new MyException("My Exception has called..");
		}
		return "called service";
	}

}
