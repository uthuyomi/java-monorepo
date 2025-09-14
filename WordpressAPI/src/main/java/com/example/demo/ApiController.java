package com.example.demo; 

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") //Next.jsのurlを許可
public class ApiController{
	private final RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/categories")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		String url = "https://webyayasu.sakura.ne.jp/uthuyomizyuku/wp-json/wp/v2/categories?exclude=1";
		ResponseEntity<List<Map<String, Object>>> response =
				restTemplate.exchange(url, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Map<String, Object>>>(){});
		List<Map<String, Object>> wpCategories = response.getBody();
		List<CategoryDto> categories = wpCategories.stream()
				.map(cat ->{
					String description =(cat.get("description") == null || ((String) cat.get("description")).trim().isEmpty())
							?"説明なし"
							:(String) cat.get("description");
					return new CategoryDto(
							((Number) cat.get("id")).longValue(),
							(String) cat.get("name"),
							(String) cat.get("slug"),
							description
							);
				})
				.toList();
		return ResponseEntity.ok(categories);
	}
}