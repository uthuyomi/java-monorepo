package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tools")
public class Todo {
	
	@Id
	@GeneratedValue(Strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "titleは必須です")
	@Column( nullable = false )
	private String title;
	
	

}
