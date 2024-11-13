package com.cg.FirstScbUserServices.services;

import java.util.List;

import com.cg.FirstScbUserServices.entities.User;

public interface UserService {
	public User createUser(User user);

	public List<User> getAllUsers();

	// public User getUserById(Long uid);
	public User getUser(Long userId);
}
