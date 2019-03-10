package com.bootcamp.bootcamp.service;

import com.bootcamp.bootcamp.model.User;
import com.bootcamp.bootcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }
}
