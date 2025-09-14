package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class formController {
	@GetMapping("/form")
	public String showForm() {
		return "form";
	}
	@PostMapping("/result")
	public String resultForm( FormDTO dto, Model model) {
		if( dto.getName() == null || dto.getName().isEmpty() ) {
			model.addAttribute("errorMsg", "名前が入力されていません");
			return "form";
		}
		if( dto.getEmail() == null || dto.getEmail().isEmpty() ) {
			model.addAttribute("errorMsg", "メールが入力されていません");
			return "form";
		}
		model.addAttribute("name", dto.getName());
		model.addAttribute("email", dto.getEmail());
		return "result";
	}
}
