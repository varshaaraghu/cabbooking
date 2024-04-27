package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createAccount(@RequestBody User user) {
		System.out.println("Inside SignUp"+user.toString());
		return userService.createUser(user);
	}
	@PostMapping(value = "/signin",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String sigin(@RequestBody User user) {
		System.out.println("Inside SignIn"+user.toString());
		return userService.signIn(user);
	}

}