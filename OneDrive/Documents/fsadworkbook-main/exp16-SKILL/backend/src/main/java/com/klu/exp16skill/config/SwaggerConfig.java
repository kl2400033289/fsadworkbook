package com.klu.exp16skill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Student CRUD API")
						.description("Swagger/OpenAPI documentation for Skill 16 Student CRUD endpoints")
						.version("v1")
						.contact(new Contact().name("FSAD Team")));
	}
}
