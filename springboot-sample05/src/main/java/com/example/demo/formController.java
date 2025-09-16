package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class formController {
	
	@GetMapping("form")
	public String showWindow(formDTO dto) {	
		return "form";
	}
	
	@PostMapping("result")
	public String resultForm(
			formDTO dto,
			BindingResult bindingResult,
			Model model
			) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		model.addAttribute("name", dto.getName());
		model.addAttribute("email", dto.getEmail());
		return "result";
	}
}
