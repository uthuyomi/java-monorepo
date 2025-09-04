package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
	@GetMapping("/registerForm")
	public String showForm() {
		return "registerForm";
	}
	
	@PostMapping("/registerResult")
	public String submitForm(
			@RequestParam(name="name", required=false) String name,
			@RequestParam(name="email", required=false) String email,
			Model model
			) {
		if(name == null || name.trim().isEmpty()) {
			model.addAttribute("errorMessage", "名前は必須です");
			return "registerForm";
		}
		if(email == null || email.trim().isEmpty()) {
			model.addAttribute("errorMessage", "メールは必須です");
			return "registerForm";
		}
		
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "registerResult";
	}
}
