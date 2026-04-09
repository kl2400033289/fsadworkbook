package com.klu.exp12skill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.exp12skill.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
