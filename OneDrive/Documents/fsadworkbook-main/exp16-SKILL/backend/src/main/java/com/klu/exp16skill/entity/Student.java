package com.klu.exp16skill.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "students")
@Schema(description = "Student entity used in CRUD operations")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Auto-generated student id", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
	private Long id;

	@NotBlank(message = "Name is required")
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	@Schema(description = "Student full name", example = "Aarav Sharma")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Email must be valid")
	@Schema(description = "Student email address", example = "aarav.sharma@example.com")
	private String email;

	@NotBlank(message = "Course is required")
	@Size(min = 2, max = 60, message = "Course must be between 2 and 60 characters")
	@Schema(description = "Enrolled course", example = "Computer Science")
	private String course;

	public Student() {
	}

	public Student(Long id, String name, String email, String course) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
}
