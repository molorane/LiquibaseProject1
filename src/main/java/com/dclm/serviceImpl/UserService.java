package com.dclm.serviceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dclm.model.Role;
import com.dclm.model.User;
import com.dclm.repository.RoleRepository;
import com.dclm.repository.UserRepository;
import com.dclm.service.IUserService;


@Service
public class UserService implements IUserService{
	
	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private RoleRepository roleRepository;
	 
	 @Autowired
	 private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		Role role = roleRepository.findByRole("SITE_USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<Role>(Arrays.asList(role)));
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
