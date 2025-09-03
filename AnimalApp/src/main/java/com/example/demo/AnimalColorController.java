package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnimalColorController {
	@GetMapping("animalColorForm")
	public String showWindow() {
		return "animalColorForm";
	}
	
	@PostMapping("/animalColorResult")
	public String animalColorResult(
			@RequestParam(name="animal", required=false) String animal, 
			@RequestParam(name="color" ,required=false) String color,
			Model model
			) {
		if(animal == null || animal.trim().isEmpty() || color == null || color.trim().isEmpty()) {
			model.addAttribute("message", "まだ入力されていません。");
		}else {
			model.addAttribute("animal", animal);
			model.addAttribute("color", color);
		}
		return "animalColorResult";
	}
}
