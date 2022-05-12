package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/demo")
	public String getDemo() {
		return "Hi Anirban..";
	}
	
	@GetMapping("/index")
	public String getDemo1() {
		return "Hi Sanu..";
	}

}
