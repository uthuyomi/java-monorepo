package com.example.demo;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {
	@GetMapping("/form")
	public String showWindow(formDTO dto) {
		return "form";
	}
	
	public String resultForm(
			@Valid formDTO dto,
			BindingResult bindingResult,
			Model model
			) {
		if(bindingResult.hasErrors()) {
			//エラーがあればフォームに返す。
			return "form";
		}
		model.addAttribute("name", dto.getName());
		model.addAttribute("email", dto.getEmail());
		return "result";
	}
}
