package com.klu.exp15skill;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.klu.exp15skill.entity.Role;
import com.klu.exp15skill.entity.User;
import com.klu.exp15skill.repository.UserRepository;

@SpringBootApplication
public class Exp15SkillApplication {

	public static void main(String[] args) {
		SpringApplication.run(Exp15SkillApplication.class, args);
	}

	@Bean
	CommandLineRunner seedUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (userRepository.count() == 0) {
				userRepository.save(new User("admin", passwordEncoder.encode("admin123"), Role.ROLE_ADMIN));
				userRepository.save(new User("employee", passwordEncoder.encode("emp123"), Role.ROLE_EMPLOYEE));
			}
		};
	}
}
