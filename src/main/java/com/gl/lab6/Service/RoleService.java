package com.gl.lab6.Service;

import org.springframework.stereotype.Service;

import com.gl.lab6.Model.Role;
import com.gl.lab6.Repository.RoleRepository;

@Service
public class RoleService {
	
	private final RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public Role saveRole(Role role) {
		System.out.println("Role "+ role.toString());
		return this.roleRepository.save(role);
	}
}
