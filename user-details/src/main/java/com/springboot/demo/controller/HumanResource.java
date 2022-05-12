package com.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HumanResource {
	
	@GetMapping
	public String getHome() {
		return "Welcome Human Resource Home";
	}

	@GetMapping("/hrname")
	public String getHRName() {
		return "Anirban Das";
	}
	
	@GetMapping("/hrdesigntion")
	public String getHRDesignation() {
		return "Senior HR";
	}
}
