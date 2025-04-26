package com.media.service_impl;


import java.util.List;
import com.media.dao.*;
import com.media.dao_impl.UserDao_impl;
import com.media.entity.User;
import com.media.service.*;

public class UserService_impl implements UserService{

	UserDao userDao = new UserDao_impl();
	
	@Override
	public User createUser(User user) {
		// Invoke DAO method to save user object
		return userDao.createUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		// Retrieve all users using DAO
		return userDao.getAllUsers();
	}

	@Override
	public User getUser(String userId) {
		// Get user by ID using DAO
		return userDao.getUser(userId);
	}

	@Override
	public User updateUser(String userId, User updatedUser) {
		// Update user details using DAO
		return userDao.updateUser(userId, updatedUser);
	}

	@Override
	public String deleteUser(String userId) {
		// Delete user using DAO
		return userDao.deleteUser(userId);
	}
}

