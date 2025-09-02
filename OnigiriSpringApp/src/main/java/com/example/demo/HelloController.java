package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String Hello() {
		return "Hello Spring";
	}
	
	@GetMapping("/greet")
	public String greet(@RequestParam String name) {
		return "こんにちは、"+name+"さん";
	}
}
