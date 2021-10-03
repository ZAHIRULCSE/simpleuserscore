package com.simplejavatest.repository;

import org.springframework.data.repository.CrudRepository;

import com.simplejavatest.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	//public List<User> findTop10ByOrderByLevelDesc();
}
