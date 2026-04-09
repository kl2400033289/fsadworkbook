package com.klu.exp14skill;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.klu.exp14skill.entity.User;
import com.klu.exp14skill.repository.UserRepository;

@SpringBootApplication
public class Exp14SkillApplication {

	public static void main(String[] args) {
		SpringApplication.run(Exp14SkillApplication.class, args);
	}

	@Bean
	CommandLineRunner seedUsers(UserRepository userRepository) {
		return args -> {
			if (userRepository.count() == 0) {
				userRepository.save(new User("demo", "demo@example.com", "pass123"));
			}
		};
	}
}
