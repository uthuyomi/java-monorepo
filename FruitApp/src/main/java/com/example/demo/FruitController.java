package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FruitController {
	@GetMapping("/fruitForm")
	public String ShowWindow(){
		return "fruitForm";
	}
	
	@PostMapping("/fruit")
	public String fruitResult(@RequestParam(name="fruit", required=false) String fruit, Model model) {
		if( fruit == null || fruit.trim().isEmpty() ) {
			model.addAttribute("fruit", null);
		}else {
			model.addAttribute("fruit", fruit);
		}
		return "ResultFruit";
	}
}
