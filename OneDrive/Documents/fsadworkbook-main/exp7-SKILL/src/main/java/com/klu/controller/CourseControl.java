package com.klu.controller;

import com.klu.model.Course;
import com.klu.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseControl {

    @Autowired
    CourseService service;

    // Add Course
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {

        if(course.getTitle()==null || course.getTitle().isEmpty()) {
            return ResponseEntity.badRequest().body("Course title cannot be empty");
        }

        Course saved = service.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Get All Courses
    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){
        return ResponseEntity.ok(service.getAllCourses());
    }

    // Get Course by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id){

        Course c = service.getCourseById(id);

        if(c==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found");

        return ResponseEntity.ok(c);
    }

    // Update Course
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,
                                          @RequestBody Course course){

        Course updated = service.updateCourse(id,course);

        if(updated==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found");

        return ResponseEntity.ok(updated);
    }

    // Delete Course
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id){

        boolean deleted = service.deleteCourse(id);

        if(!deleted)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found");

        return ResponseEntity.ok("Course deleted successfully");
    }

    // Search Course by Title
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchCourse(@PathVariable String title){

        List<Course> result = service.searchCourse(title);

        return ResponseEntity.ok(result);
    }
}