package com.klu.exp14skill.service;

import com.klu.exp14skill.dto.AuthResponse;
import com.klu.exp14skill.dto.LoginRequest;
import com.klu.exp14skill.dto.RegisterRequest;
import com.klu.exp14skill.dto.UserProfileResponse;

public interface AuthService {
	void register(RegisterRequest request);

	AuthResponse login(LoginRequest request);

	UserProfileResponse getProfile(String username);
}
