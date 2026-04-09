package com.klu.exp16skill.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.exp16skill.entity.Student;
import com.klu.exp16skill.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
@Validated
@Tag(name = "Student CRUD APIs", description = "Operations for managing student records")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping
	@Operation(summary = "Add a new student", description = "Creates a student record in the database")
	@ApiResponses({
			@ApiResponse(responseCode = "201", description = "Student created", content = @Content(schema = @Schema(implementation = Student.class))),
			@ApiResponse(responseCode = "400", description = "Validation failed", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\"message\":\"Validation failed\",\"errors\":{\"name\":\"Name is required\"}}"))) })
	public ResponseEntity<Student> addStudent(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Student object to create", required = true, content = @Content(schema = @Schema(implementation = Student.class), examples = @ExampleObject(value = "{\"name\":\"Rahul Verma\",\"email\":\"rahul.verma@example.com\",\"course\":\"Data Science\"}")))
			@Valid @RequestBody Student student) {
		Student savedStudent = studentService.addStudent(student);
		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}

	@GetMapping
	@Operation(summary = "Retrieve all students", description = "Fetches all student records")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Students fetched successfully", content = @Content(schema = @Schema(implementation = Student.class))) })
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Retrieve a student by ID", description = "Fetches one student by id")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Student found", content = @Content(schema = @Schema(implementation = Student.class))),
			@ApiResponse(responseCode = "404", description = "Student not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))) })
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.getStudentById(id));
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update a student", description = "Updates an existing student by id")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Student updated", content = @Content(schema = @Schema(implementation = Student.class))),
			@ApiResponse(responseCode = "400", description = "Validation failed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))),
			@ApiResponse(responseCode = "404", description = "Student not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))) })
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
		return ResponseEntity.ok(studentService.updateStudent(id, student));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a student", description = "Deletes student by id")
	@ApiResponses({
			@ApiResponse(responseCode = "204", description = "Student deleted"),
			@ApiResponse(responseCode = "404", description = "Student not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))) })
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}
}
