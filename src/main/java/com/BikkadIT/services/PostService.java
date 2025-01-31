package com.BikkadIT.services;

import java.util.List;

import com.BikkadIT.entities.Post;
import com.BikkadIT.payloads.PostDto;

public interface PostService {

	// Create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//Update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void  deletePost(Integer postId);
	
	//get all posts
	
	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get   all posts by category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get all posts by user 
	
	List<PostDto> getPostsByUser(Integer userId);
	
	// search posts
	
	List<Post> searchPosts(String keyword);
	
	


	
	
	
	
	
	
}
