package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // ← Next.js のURLを許可
public class BaseController {
	private final RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/base")
	public ResponseEntity<Object> getCategories() {
		String url = "https://webyayasu.sakura.ne.jp/uthuyomizyuku/wp-json/wp/v2/posts?_embed";

		// WordPress API からそのまま取得
		Object response = restTemplate.getForObject(url, Object.class);

		// 加工したい場合はここで DTO に変換 or 一部抽出する
		return ResponseEntity.ok(response);
		}
}
