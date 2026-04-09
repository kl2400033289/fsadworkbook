package com.klu.exp13skill.service;

import java.util.List;

import com.klu.exp13skill.entity.Student;

public interface StudentService {
	Student addStudent(Student student);
	List<Student> getAllStudents();
	Student updateStudent(Long id, Student student);
	void deleteStudent(Long id);
}
