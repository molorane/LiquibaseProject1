package com.dclm.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	public CustomUserDetails(final  User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getRoles()
			.stream()
			.map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRole()))
			.collect(Collectors.toList());
		
//      OR	
//		Set<GrantedAuthority> authorities = new HashSet<>();
//		user.getRoles().forEach(role -> {
//			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role.getRole_name());
//			authorities.add(authority);
//		});
//		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !user.accountExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.isLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isActive();
	}
	
	public User getUser() {
		return user;
	}

}
