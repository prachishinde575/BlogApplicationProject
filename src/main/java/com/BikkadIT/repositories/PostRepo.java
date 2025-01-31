package com.BikkadIT.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.entities.Post;
import com.BikkadIT.entities.User;
import com.BikkadIT.entities.Category;

public interface PostRepo extends JpaRepository<Post, Integer>   {
	
	//List<Post> getByUser (User user);
	
	//List<Post> getByCategory (Category category);

	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	 
	
	
	
	
	
}
