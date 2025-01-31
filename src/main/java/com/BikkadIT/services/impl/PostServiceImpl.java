package com.BikkadIT.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BikkadIT.entities.Category;
import com.BikkadIT.entities.Post;
import com.BikkadIT.entities.User;
import com.BikkadIT.exceptions.ResourceNotFoundException;
import com.BikkadIT.payloads.PostDto;
import com.BikkadIT.repositories.CategoryRepo;
import com.BikkadIT.repositories.PostRepo;
import com.BikkadIT.repositories.UserRepo;
import com.BikkadIT.services.PostService;

@Service 
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired 
	private CategoryRepo categoryRepo;
	
	
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "user id",userId) );
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category id",categoryId));
		
		Post post = this.modelMapper.map(postDto,Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user); 
		post.setCategory(category);				
		Post newPost = this.postRepo.save(post);
		
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {

		Post post = this.postRepo.findById(postId).orElseThrow(()->  new ResourceNotFoundException("Post", "postId", postId));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost = this.postRepo.save(post);
		
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
 
		Post post = this.postRepo.findById(postId).orElseThrow(()->  new ResourceNotFoundException("Post", "postId", postId));
		this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> getAllPost() {
			List<Post> allPosts = this.postRepo.findAll();
			List<PostDto> postDtos = allPosts.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
			

		return postDtos;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(()->  new ResourceNotFoundException("Post", "postId", postId));
		return this.modelMapper.map(post, PostDto.class);
		 
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(( ) -> new ResourceNotFoundException("Category", "categoryId",categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat);
		
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
				
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {

		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
