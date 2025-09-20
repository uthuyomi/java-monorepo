package com.example.demo;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

	@Autowired
	private FormRepository repository;
	
	//入力画面
	@GetMapping("/form")
	public String showForm(FormDTO dto) {
		return "form";
	}
	
	//登録処理
	@PostMapping("/result")
	public String resultForm(
			@Valid FormDTO dto,
			BindingResult bindingResult,
			Model model
			) {
		
		if(bindingResult.hasErrors()) {
			return "form";
		}
		
		FormEntity entity = new FormEntity();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		repository.save(entity);
		
		model.addAttribute("name", dto.getName());
		model.addAttribute("email", dto.getEmail());
		
		return "result";
	}
	
	//編集画面
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		FormEntity entity = repository.findById(id).orElseThrow();
		model.addAttribute("formDTO", new FormDTO(entity.getName(), entity.getEmail()));
		model.addAttribute("id", entity.getId());
		return "edit";
	}
	
	//更新処理
	@PostMapping("/update/{id}")
	public String update(
			@PathVariable Long id,
			@Valid FormDTO dto,
			BindingResult bindingResult
			) {
		if(bindingResult.hasErrors()) {
			return "edit";
		}
		
		FormEntity entity = repository.findById(id).orElseThrow();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		repository.save(entity);
		
		return "redirect:/list";
	}
	
	//削除処理
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/list";
	}
}
