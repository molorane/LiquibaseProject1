package com.dclm.service;

import java.util.List;
import java.util.Optional;

import com.dclm.model.User;

public interface IUserService {

	User addUser(User user);
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);	
	List<User> findAll();
	 
}
