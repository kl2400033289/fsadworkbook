package com.klu.exp15skill.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@PostMapping("/add")
	public ResponseEntity<Map<String, String>> addEmployee(@RequestParam(defaultValue = "new-employee") String name) {
		return ResponseEntity.ok(Map.of("message", "Admin added employee: " + name));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Map<String, String>> deleteEmployee(@RequestParam(defaultValue = "employee-id-1") String id) {
		return ResponseEntity.ok(Map.of("message", "Admin deleted employee id: " + id));
	}
}
