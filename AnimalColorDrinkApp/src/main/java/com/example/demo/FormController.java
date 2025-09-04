package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

	@GetMapping("/form")
	public String showForm() {
		return "/form";
	}
	
	@PostMapping("/post")
	public String resultForm(
			@RequestParam(name="animal", required=false) String animal,
			@RequestParam(name="color", required=false) String color,
			@RequestParam(name="drink", required=false) String drink,
			Model model
			) {
		
		
	}
}
