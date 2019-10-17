package com.tavisca.springapplication.controller;

import com.tavisca.springapplication.model.User;
import com.tavisca.springapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUser(){
        return this.userRepository.findAll();
    }
}
