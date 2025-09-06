package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping
	public String list(Model model) {
		List<User> users = userRepository.findAll();//全件取得
		model.addAttribute("users", users);
		return "users"; //users.htmlを返す
	}
	
	//新規登録フォーム
	@GetMapping("/new")
	public String newForm(Model model) {
		model.addAttribute("user", new User());
		return "user_Form";
	}
	
	//登録処理
	@PostMapping("/save")
	public String save(@ModelAttribute User user) {
		userRepository.save(user);//DBに保存
		return "redirect:/users";//一覧へリダイレクト
	}

}
