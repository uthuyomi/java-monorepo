package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class TodoController {
	private final TodoRepository repo;
	
	public TodoController(TodoRepository repo) {
		this.repo = repo;
	}
	
	//一覧表示
	@GetMapping("/")
	public String list(Model model) {
		List<Todo> todos = repo.findAll();
		model.addAttribute("todos", todos);
		model.addAttribute("todo", new Todo());
		return "index";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute Todo todo) {
		repo.save(todo);
		return "redirect:/";
	}
}
