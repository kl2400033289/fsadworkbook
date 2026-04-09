package com.klu.exp13skill.exception;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(Long id) {
		super("Student not found with id: " + id);
	}
}
