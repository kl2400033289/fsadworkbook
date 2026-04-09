package com.klu.exp15skill.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.exp15skill.dto.EmployeeProfileResponse;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping("/profile")
	public ResponseEntity<EmployeeProfileResponse> profile(Authentication authentication) {
		String role = authentication.getAuthorities().stream().findFirst().map(Object::toString).orElse("UNKNOWN");
		EmployeeProfileResponse response = new EmployeeProfileResponse(
				authentication.getName(),
				role,
				"Employee profile data fetched successfully.");
		return ResponseEntity.ok(response);
	}
}
