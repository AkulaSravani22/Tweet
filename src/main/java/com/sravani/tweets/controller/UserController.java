package com.sravani.tweets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sravani.tweets.model.User;
import com.sravani.tweets.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	
	    private final UserService userService;

	    @Autowired
	    public UserController(UserService userService) {
	        this.userService = userService;
	    }

	    @PostMapping("/create")
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        User createdUser = userService.createUser(user);
	        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    }

	    // Other methods if needed
	

}
