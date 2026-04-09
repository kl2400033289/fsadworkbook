package com.klu.exp16skill.service;

import java.util.List;

import com.klu.exp16skill.entity.Student;

public interface StudentService {
	Student addStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(Long id);

	Student updateStudent(Long id, Student student);

	void deleteStudent(Long id);
}
