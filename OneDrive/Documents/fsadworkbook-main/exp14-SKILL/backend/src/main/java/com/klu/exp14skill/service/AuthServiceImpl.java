package com.klu.exp14skill.service;

import org.springframework.stereotype.Service;

import com.klu.exp14skill.dto.AuthResponse;
import com.klu.exp14skill.dto.LoginRequest;
import com.klu.exp14skill.dto.RegisterRequest;
import com.klu.exp14skill.dto.UserProfileResponse;
import com.klu.exp14skill.entity.User;
import com.klu.exp14skill.exception.AuthException;
import com.klu.exp14skill.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository;

	public AuthServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void register(RegisterRequest request) {
		if (request.getUsername() == null || request.getUsername().isBlank() ||
				request.getEmail() == null || request.getEmail().isBlank() ||
				request.getPassword() == null || request.getPassword().isBlank()) {
			throw new AuthException("All fields are required.");
		}

		if (userRepository.existsByUsername(request.getUsername())) {
			throw new AuthException("Username already exists.");
		}

		if (userRepository.existsByEmail(request.getEmail())) {
			throw new AuthException("Email already exists.");
		}

		User user = new User(request.getUsername(), request.getEmail(), request.getPassword());
		userRepository.save(user);
	}

	@Override
	public AuthResponse login(LoginRequest request) {
		if (request.getUsername() == null || request.getUsername().isBlank() ||
				request.getPassword() == null || request.getPassword().isBlank()) {
			throw new AuthException("Username and password are required.");
		}

		User user = userRepository.findByUsername(request.getUsername())
				.orElseThrow(() -> new AuthException("Invalid username or password."));

		if (!user.getPassword().equals(request.getPassword())) {
			throw new AuthException("Invalid username or password.");
		}

		return new AuthResponse(user.getId(), user.getUsername(), "Login successful.");
	}

	@Override
	public UserProfileResponse getProfile(String username) {
		if (username == null || username.isBlank()) {
			throw new AuthException("Username is required.");
		}

		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new AuthException("User not found."));

		return new UserProfileResponse(user.getId(), user.getUsername(), user.getEmail());
	}
}
