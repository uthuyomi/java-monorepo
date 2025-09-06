package com.example.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")// ← 予約語を割ける
public class User {
	
	@Id //主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY)// 自動採番
	
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
