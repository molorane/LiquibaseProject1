package com.dclm.service;

import com.dclm.model.Role;

public interface IRoleService {
	Role addRole(Role role);
	Role getRole(int role_id);
}
