package com.example.demo;

public class CategoryDto {
	private Long id;
	private String name;
	private String slug;
	private String description;
	
	public CategoryDto() {}
	
	public CategoryDto(Long id, String name, String slug, String description) {
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSlug() {
		return slug;
	}
	public String getDescription() {
		return description;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
