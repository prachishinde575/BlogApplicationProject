package com.BikkadIT.services;

import java.util.List;

import com.BikkadIT.payloads.CategoryDto;


public interface CategoryService {

	
	//Create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//Update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	//delete
	public void  deleteCategory(Integer categoryId);
	
	//Get
	public CategoryDto getCategory(Integer categoryId);

	//GetAll
	List<CategoryDto> getCategories();
	
}
