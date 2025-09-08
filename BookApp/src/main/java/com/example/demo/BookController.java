package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
	
	private final BookRepository bookRepository;
	
	//コンストラクタ注入
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	//一覧表示
	@GetMapping
	public String list(Model model) {
		List<Book> books = bookRepository.findAll();
		model.addAttribute("books", books);
		return "books";
	}
	
	//新規登録フォーム
	@GetMapping("/new")
	public String newForm(Model model) {
		model.addAttribute("book", new Book());
		return "book_form";// → book_form.html
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/books";//保存後一覧に戻る
	}
}
