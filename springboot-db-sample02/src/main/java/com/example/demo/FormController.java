package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
	
	@Autowired
	private FormRepository repository;
	
	@GetMapping("form")
	public String showForm(FormDTO dto) {
		return "form";
	}
	
	@PostMapping("result")
	public String resultForm(
			FormDTO dto,
			BindingResult bindingResult,
			Model model
			) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		FormEntity entity = new FormEntity();
		entity.setName(dto.getName());
		entity.setName(dto.getEmail());
		
		repository.save(entity);
		
		model.addAttribute("name", dto.getName());
		model.addAttribute("email", dto.getEmail());
		
		return "result";
	}
}
