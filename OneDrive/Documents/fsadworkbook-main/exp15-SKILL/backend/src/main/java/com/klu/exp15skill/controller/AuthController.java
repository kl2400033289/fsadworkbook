package com.klu.exp15skill.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.exp15skill.dto.LoginRequest;
import com.klu.exp15skill.dto.LoginResponse;
import com.klu.exp15skill.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;

	public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		UserDetails principal = (UserDetails) authentication.getPrincipal();
		String token = jwtUtil.generateToken(principal);
		String role = principal.getAuthorities().stream().findFirst().map(Object::toString).orElse("UNKNOWN");

		return ResponseEntity.ok(new LoginResponse(token, principal.getUsername(), role));
	}
}
