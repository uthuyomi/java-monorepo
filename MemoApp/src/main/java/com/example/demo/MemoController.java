package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/memos")
public class MemoController {
	
	private final MemoRepository memoRepository;
	
	public MemoController(MemoRepository memoRepository) {
		this.memoRepository = memoRepository;
	}
	
	//一覧表示
	@GetMapping
	public String list(Model model) {
		List<Memo> memos = memoRepository.findAll();
		model.addAttribute("memos", memos);
		return "memos";
	}
	
	//新規作成フォーム
	@GetMapping("/new")
	public String newForm(Model model) {
		model.addAttribute("memo", new Memo());
		return "memo_form";
	}
	
	//保存処理
	@PostMapping("/save")
	public String save(@ModelAttribute Memo memo) {
		memoRepository.save(memo);
		return "redirect:/memos";
	}
}
