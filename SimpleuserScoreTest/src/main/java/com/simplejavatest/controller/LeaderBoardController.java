package com.simplejavatest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.simplejavatest.model.UserProgress;
import com.simplejavatest.repository.UserProgressRepository;

@RestController

public class LeaderBoardController {

	@Autowired
	public UserProgressRepository userProgressRepository;
	
	@GetMapping("/leadboard/{id}")
	public UserProgress getUserProgressById(@PathVariable("id") int id)
	{
		UserProgress userprogress = userProgressRepository.findById(id).get();
		
		return userprogress;
		
	}
	
	@GetMapping("/leadboards")
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
	
}

