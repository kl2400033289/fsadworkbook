package com.klu.exp12skill.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.exp12skill.entity.Student;
import com.klu.exp12skill.exception.StudentNotFoundException;
import com.klu.exp12skill.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Student addStudent(Student student) {
		student.setId(null);
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(id));

		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setCourse(student.getCourse());
		return studentRepository.save(existingStudent);
	}

	@Override
	public void deleteStudent(Long id) {
		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(id));
		studentRepository.delete(existingStudent);
	}
}
