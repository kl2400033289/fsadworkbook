package com.example.exp12skill.service;

import java.util.List;

import com.example.exp12skill.entity.Student;

public interface StudentService {
	Student addStudent(Student student);
	List<Student> getAllStudents();
	Student updateStudent(Long id, Student student);
	void deleteStudent(Long id);
}
