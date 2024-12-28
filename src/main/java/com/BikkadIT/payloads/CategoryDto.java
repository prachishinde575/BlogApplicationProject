package com.BikkadIT.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	
	@NotBlank
	@Size(min= 4, message = "Minimum size of title is 4 characters")
	private String categoryTitle;
	
	@NotBlank
	@Size(min= 4, max = 100)
	private String categoryDescription;
	
}
