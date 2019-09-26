package com.dclm.serviceImpl;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.dclm.model.CustomUserDetails;
import com.dclm.model.Role;
import com.dclm.model.User;
import com.dclm.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByUsername(username);

		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));

		toList(optionalUser.get().getRoles());

		return optionalUser.map(users -> new CustomUserDetails(users)).get();

//        if (optionalUser == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        toList(optionalUser.get().getRoles());
//        return new CustomUserDetails(optionalUser.get());
	}

	public void toList(Set<Role> roles) {
		for (Role role : roles) {
			System.out.println("Role: " + role.getRole());
		}
	}

}
