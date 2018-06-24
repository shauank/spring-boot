package com.example.demo;

import java.text.MessageFormat;

public class MyException extends RuntimeException {

	public MyException(String message, Object... params) {
		super(MessageFormat.format(message, params));
	}

	public MyException(String message) {
		super(message);
	}

	public MyException() {
		super();
	}

}
