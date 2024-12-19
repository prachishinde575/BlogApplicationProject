package com.BikkadIT.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.entities.User;

public interface  UserRepo extends JpaRepository<User, Integer> {

}
