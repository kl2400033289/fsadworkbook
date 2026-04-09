package com.klu.exp16skill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.exp16skill.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
