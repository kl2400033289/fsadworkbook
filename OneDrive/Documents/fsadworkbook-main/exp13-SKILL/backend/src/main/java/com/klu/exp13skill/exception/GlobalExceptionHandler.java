package com.klu.exp13skill.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleStudentNotFound(StudentNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Map.of("message", exception.getMessage()));
	}
}
