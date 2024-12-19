package com.BikkadIT.services;



import java.util.List;

import com.BikkadIT.entities.User;
import com.BikkadIT.payloads.UserDto;

public  interface UserService {
	
	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUser();

	void deleteUser(Integer UserId);
	;
}
