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
import com.simplejavatest.repository.UserProgressRepository;

@RestController
public class UserProgressController {
	
	@Autowired
	public UserProgressRepository userProgressRepository;
	
	@GetMapping("/userprogress/{id}")
	public UserProgress getUserProgressById(@PathVariable("id") int id)
	{
		UserProgress userprogress = userProgressRepository.findById(id).get();
		
		return userprogress;
		
	}
	
	@GetMapping("/userprogresss")
	public List<UserProgress> getAllUserProgress()
	{
		List<UserProgress> userprogressList = new ArrayList<>();
		Iterable<UserProgress> userprogress = userProgressRepository.findAll();
		
		for(UserProgress u : userprogress)
		{
			userprogressList.add(u);
		}
		return userprogressList;
		
	}
	
	@PostMapping("/userprogress/{userid}")
	public UserProgress createUserProgress(@PathVariable("userid") int userid,
			@RequestBody UserProgress userprogress) 
	{
		User user = userProgressRepository.getUser(userid);
		userprogress.setUser(user);
		userProgressRepository.save(userprogress);
		
		return getUserProgressById(userprogress.getId());
		
	}
	
	@DeleteMapping("/useprogress/{id}")
	public List<UserProgress> deleteUserProgress(@PathVariable("id") int id)
	{
		userProgressRepository.deleteById(id);
		return getAllUserProgress();
		
	}

}
