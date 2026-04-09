package com.klu.exp14skill.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.exp14skill.dto.AuthResponse;
import com.klu.exp14skill.dto.LoginRequest;
import com.klu.exp14skill.dto.RegisterRequest;
import com.klu.exp14skill.dto.UserProfileResponse;
import com.klu.exp14skill.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
		authService.register(request);
		return ResponseEntity.status(HttpStatus.CREATED).body("Registration successful.");
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(authService.login(request));
	}

	@GetMapping("/profile")
	public ResponseEntity<UserProfileResponse> getProfile(@RequestParam String username) {
		return ResponseEntity.ok(authService.getProfile(username));
	}
}
