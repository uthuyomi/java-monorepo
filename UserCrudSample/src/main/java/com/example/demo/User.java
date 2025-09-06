package com.example.demo;
import jakarta.persistence.*;

@Entity
public class User {
	
	@Id //主キー
	@GereratedValue(strategy = GenerationType.IDENTITY)// 自動採番
	
	private Long id;
	
	private String name;
	private String email;
	
	// --- getter/setter ---
	public Long getId() { return id; }
	public void setId(Long id) { this.id =id; }
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
}
