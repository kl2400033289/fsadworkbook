package com.klu.exp16skill.exception;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(Long id) {
		super("Student not found with id: " + id);
	}
}
