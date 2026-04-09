package com.klu.exp13skill;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.klu.exp13skill.entity.Student;
import com.klu.exp13skill.repository.StudentRepository;

@SpringBootApplication
public class Exp13SkillApplication {

	public static void main(String[] args) {
		SpringApplication.run(Exp13SkillApplication.class, args);
	}

	@Bean
	CommandLineRunner seedData(StudentRepository studentRepository) {
		return args -> {
			if (studentRepository.count() == 0) {
				studentRepository.save(new Student(null, "Aarav Sharma", "aarav.sharma@example.com", "Computer Science"));
				studentRepository.save(new Student(null, "Diya Nair", "diya.nair@example.com", "Information Technology"));
				studentRepository.save(new Student(null, "Karthik Iyer", "karthik.iyer@example.com", "Electronics"));
			}
		};
	}
}
