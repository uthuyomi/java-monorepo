package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController{
	
	// http://localhost:8080/
	@GetMapping("/form")
	public String showWindow() {
		return "form";
	}
	@PostMapping("/profile")
	public String sayProfile(
			@RequestParam(name="name", required=false, defaultValue="名無し") String name,
			@RequestParam(name="year", required=false, defaultValue="0") int year,
			@RequestParam(name="word", required=false, defaultValue="false") String word,
			Model model
			){
		
		model.addAttribute("name", name);
		model.addAttribute("year", year);
		model.addAttribute("word", word);
		return "result";
	}
}
