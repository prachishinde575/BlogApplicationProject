package com.BikkadIT.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.entities.Post;
import com.BikkadIT.payloads.ApiResponse;
import com.BikkadIT.payloads.PostDto;
import com.BikkadIT.services.PostService;

@RestController 
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService ;
	
	//Create 
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto>  createPost(
			@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId)
	
	{
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
		
	}
	
	//get by user
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(
			@PathVariable Integer userId){
		
		List<PostDto> posts = this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);	
	}
	
	// Get by category

	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> GetPostsByCategory(
			@PathVariable Integer categoryId){
		
		List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);	
	}
	
	
	// Get all posts
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPost(){
		
		List<PostDto> allPost = this.postService.getAllPost();
		return new 	ResponseEntity<List<PostDto>>(allPost, HttpStatus.OK);
	
	}
	
	// Get post detail by id
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity <PostDto> getPostById(@PathVariable Integer postId){
		
		PostDto postDto = this.postService.getPostById(postId);
		return new 	ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	
	}
	
	// Delete Post
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) 
	{
		this.postService.deletePost(postId);
		return new ApiResponse("Post is successfully deleted !", true );
		
	}
			
	// Update post  
	
		@PutMapping("/posts/{postId}")
		public ResponseEntity<PostDto> updatePost( @RequestBody PostDto postDto,   @PathVariable Integer postId) 
		{
			PostDto updatePost = this.postService.updatePost(postDto, postId);
			
			return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
			
			
		}
	
	
	
	
	
}
