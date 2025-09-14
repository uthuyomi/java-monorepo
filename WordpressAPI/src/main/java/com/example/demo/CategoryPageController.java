package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Next.jsを許可
public class CategoryPageController {
	
	private final RestTemplate restTemplate = new RestTemplate();
	private final String baseUrl = "https://webyayasu.sakura.ne.jp/uthuyomizyuku/wp-json/wp/v2/categories";
	
	public ResponseEntity<CategoryDto> getCategory(@PathVariable String category){
		String url;
		
		if(category.matches("\\d+")) {
			url = baseUrl +"/"+category;
		}else {
			url = baseUrl +"?slug="+category;
		}
		
		ResponseEntity<Object> response = restTemplate.getForEntity(url,Object.class);
		Object body = response.getBody();
		
		Map<String, Object> categoryMap = null;
		
		//slug指定 →　配列が返る
		if(body instanceof List<?> list && !list.isEmpty()) {
			categoryMap = (Map<String, Object>)list.get(0);
		}
		//id指定 →オブジェクトが返る
		else if(body instanceof Map<?,?>map) {
			categoryMap = (Map<String, Object>)map;
		}
		
		if(categoryMap == null) {
			return ResponseEntity.notFound().build();
		}
		
		CategoryDto dto = new CategoryDto(
				((Number) categoryMap.get("id")).longValue(),
				(String) categoryMap.get("name"),
				(String)categoryMap.get("slug"),
				(categoryMap.get("description") == null || ((String)categoryMap.get("description")).trim().isEmpty())
				? "説明なし"
						:(String)categoryMap.get("description")
				);
		
		return ResponseEntity.ok(dto);
	}

}
