package com.klu.service;

import com.klu.model.Course;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

    List<Course> courseList = new ArrayList<>();

    // Add Course
    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    // Get All Courses
    public List<Course> getAllCourses() {
        return courseList;
    }

    // Get Course by ID
    public Course getCourseById(int id) {
        for(Course c : courseList) {
            if(c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    // Update Course
    public Course updateCourse(int id, Course course) {
        for(int i=0;i<courseList.size();i++) {
            if(courseList.get(i).getCourseId()==id) {
                courseList.set(i, course);
                return course;
            }
        }
        return null;
    }

    // Delete Course
    public boolean deleteCourse(int id) {
        return courseList.removeIf(c -> c.getCourseId()==id);
    }

    // Search by Title
    public List<Course> searchCourse(String title){
        List<Course> result = new ArrayList<>();
        for(Course c : courseList){
            if(c.getTitle().equalsIgnoreCase(title)){
                result.add(c);
            }
        }
        return result;
    }
}
