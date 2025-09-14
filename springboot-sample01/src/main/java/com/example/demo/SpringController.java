package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SpringController {
	// http://localhost:8080/
	@GetMapping("/form")
	public String showWindow() {
		return "form";
	}
	
	@PostMapping("/result")
	public String resultForm(
			@RequestParam(name="name", required=false) String name,
			@RequestParam(name="email", required=false) String email,
			Model model
			) {
		if( name == null || name.isEmpty() ) {
			model.addAttribute("errorMsg", "名前が入力されていません");
			return "form";
		
		}else if( email == null || email.isEmpty()){
			model.addAttribute("errorMsg", "メールアドレスが入力されていません");
			return "form";
		}else {
			model.addAttribute("name", name);
			model.addAttribute("email", email);	
			return "result";
		}
		
	}
}
