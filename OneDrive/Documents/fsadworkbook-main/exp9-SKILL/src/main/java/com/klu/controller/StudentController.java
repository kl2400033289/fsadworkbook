package com.klu.controller;

import com.klu.model.Student;
import com.klu.exception.StudentNotFoundException;
import com.klu.exception.InvalidInputException;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {

        if(id <= 0){
            throw new InvalidInputException("Student ID must be positive");
        }

        if(id != 1){
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        return new Student(1, "Hemangini", "CSE");
    }
}