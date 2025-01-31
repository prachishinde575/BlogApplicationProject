package com.BikkadIT.payloads;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.BikkadIT.entities.Category;
import com.BikkadIT.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer postid;
	
	private String title;
	
	private String content;
	
	private String imageName;
	
     private Date addedDate;
	 
	private CategoryDto category;
		
	private UserDto user;
	
	
	
	
}
