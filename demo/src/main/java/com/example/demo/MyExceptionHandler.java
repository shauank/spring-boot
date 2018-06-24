package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RequestMapping(produces = "application/json")
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { MyException.class })
	protected ResponseEntity<Object> handleNotFound(MyException ex, WebRequest request) {
		String bodyOfResponse = ex.getMessage();

		return handleExceptionInternal(ex, new MyExceptionResponse(HttpStatus.NOT_FOUND.value(), bodyOfResponse),
				new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

}

class MyExceptionResponse {

	public MyExceptionResponse(int value, String bodyOfResponse) {
		this.reason = bodyOfResponse;
		this.status = value;
	}

	private int status;
	private Object reason;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getReason() {
		return reason;
	}

	public void setReason(Object reason) {
		this.reason = reason;
	}

}
