package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

	@GetMapping("/form")
	public String showForm() {
		return "/form";
	}
	
	@PostMapping("/result")
	public String resultForm(
			@RequestParam(name="animal", required=false) String animal,
			@RequestParam(name="color", required=false) String color,
			@RequestParam(name="drink", required=false) String drink,
			Model model
			) {
		if( animal == null || animal.trim().isEmpty() || color == null || color.trim().isEmpty() || drink == null || drink.trim().isEmpty() ) {
			model.addAttribute("message", "まだ入力されていません");
		} else {
			model.addAttribute("animal", animal);
			model.addAttribute("color", color);
			model.addAttribute("drink", drink);
		}
		return "/resultForm";
	}
}
