package com.cypcode.interceptor_microservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HomeController {

	
	@GetMapping
	public ResponseEntity<?> getHome(){
		return ResponseEntity.ok("API Response Success");
	}
}
