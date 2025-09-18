package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class formController {
	
	@Autowired
	private formRepository repository;
	
	@GetMapping("/form")
	public String showForm(formDTO dto) {
		return "form";
	}
	
	@PostMapping("/result")
	public String resultForm(
			formDTO dto, //フォーム入力を受け取る
			BindingResult bindingResult, //バリデーション結果
			Model model
			) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		
		formEntity entity = new formEntity();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		
		repository.save(entity);
		
		model.addAttribute("name", dto.getName());
		model.addAttribute("email", dto.getEmail());
		
		return "formResult";
	}

}
