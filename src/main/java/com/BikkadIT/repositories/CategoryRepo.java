package com.BikkadIT.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>
{

	
	
}
