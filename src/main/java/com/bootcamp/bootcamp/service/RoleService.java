package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.model.Role;
import com.bootcamp.bootcamp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;


    public Role getRoleUser(){
        Role role = roleRepository.findAllByRole("user");
        return role;
    }
}
