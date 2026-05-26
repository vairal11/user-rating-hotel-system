package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public User createUser(@RequestBody User user)
	{
		return userService.createUser(user);
		
	}
	
	@GetMapping("/getAllUser")
	public List<User>getAllUser()
	{
		return userService.getAllUser();
		
	}
	
	@CircuitBreaker(name = "RatingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	@GetMapping("/getUserById/{userId}")
	public User getUserById(@PathVariable int userId)
	{
		return userService.getUserById(userId);
		
	}
	
	public User ratingHotelFallback(Exception e)
	{
		return new User();
		
	}
	
	
	
}
