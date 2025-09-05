package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ContactController {
	@GetMapping("/contactForm")
	public String showWindow() {
		return "/contactForm";
	}
	
	@PostMapping("contactResult")
	public String contactResult(
			@RequestParam(name="name", required=false) String name,
			@RequestParam(name="email", required=false) String email,
			@RequestParam(name="message", required=false) String message,
			Model model
			) {
		if(name == null || name.trim().isEmpty()) {
			model.addAttribute("errorMsg", "名前は必須です");
			return "/contactForm";
		}
		if(email == null || email.trim().isEmpty()) {
			model.addAttribute("errorMsg", "メールは必須です");
			return "/contactForm";
		}
		if(message == null || message.trim().isEmpty()) {
			model.addAttribute("errorMsg", "メッセージは必須です");
			return "/contactForm";
		}
		
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("message", message);
		return "/contactResult";
	}
}
