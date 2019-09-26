package com.dclm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dclm.model.Role;
import com.dclm.repository.RoleRepository;
import com.dclm.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	RoleRepository roleRepo;

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public Role getRole(int role_id) {
		// TODO Auto-generated method stub
		return roleRepo.findById(role_id).get();
	}

}
