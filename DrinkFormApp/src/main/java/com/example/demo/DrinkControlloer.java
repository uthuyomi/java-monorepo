package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DrinkControlloer {
	@GetMapping("/drinkForm")
		public String showForm() {
			//template/drinkFormを探して返す
			return "drinkForm";
		}
	
	@PostMapping("/drink")
	public String submitDrink(@RequestParam("drink") String drink, Model model) {
		if( drink == null || drink.trim().isEmpty() ) {
			model.addAttribute("drink", null);
		}else {
			model.addAttribute("drink", drink);
		}
		return "drinkResult";
	}
}
