package com.example.demo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class FormDTO {
	@NotBlank(message = "名前は必須です")
	private String name;
	
	@NotBlank(message = "メールは必須です")
	@Email(message = "メールの形式が正しくありません")
	private String email;
	
	public FormDTO() {}
	public FormDTO(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
