package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.model.User;
import com.bootcamp.bootcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired RoleService roleService;

    public void saveUser(User user){
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(roleService.getRoleUser());
        userRepository.save(user);
    }

    public User getUserByEmail(String email){
        User currentUser = userRepository.findByEmail(email);
        return currentUser;
    }

}
