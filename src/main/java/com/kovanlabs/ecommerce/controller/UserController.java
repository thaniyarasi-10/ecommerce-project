package com.kovanlabs.ecommerce.controller;

import com.kovanlabs.ecommerce.model.UserModel;
import com.kovanlabs.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE USER API
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserModel user) {

        userService.createUser(user);

        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}