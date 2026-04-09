package com.klu.exp13skill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.exp13skill.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
