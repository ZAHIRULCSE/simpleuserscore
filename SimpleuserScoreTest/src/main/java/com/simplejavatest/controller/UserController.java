package com.simplejavatest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplejavatest.model.User;
import com.simplejavatest.model.UserProgress;
import com.simplejavatest.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	public UserRepository userRepository;

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int id) {
		User user = userRepository.findById(id).get();
		return user;

	}
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		List<User> userList = new ArrayList<>();
		Iterable<User> user = userRepository.findAll();
		
		for (User u : user)
		{
			userList.add(u);
		}
		return userList;
		
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user)
	{
		UserProgress userprogress = new UserProgress();
		userprogress.setUser(user);
		
		user.setUserprogress(userprogress);
		userRepository.save(user);
		
		return getUserById(user.getId());
		
	}
	
	@DeleteMapping("/user/{id}")
	public List<User> deleteUser(@PathVariable("id") int id)
	{
		userRepository.deleteById(id);
		return getAllUsers();
		
	}
	
}
