package com.simplejavatest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplejavatest.model.User;
import com.simplejavatest.model.UserProgress;


@Repository
public interface UserProgressRepository extends CrudRepository<UserProgress, Integer>{
	
	@Query("select u from UserProgress u where id = : userprogressid")
	public User getUser(int userid);
	
	
	
	
	
}
