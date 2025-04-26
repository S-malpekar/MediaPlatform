package com.media.dao;

import java.util.List;

import com.media.entity.User;

public interface UserDao {
	User createUser(User user1);	
	List<User> getAllUsers();
	//Enrollment StudentEnrollment(Enrollment enrollment);
	User getUser(String UserId);

	User updateUser(String UserId,User updatedUser);
	String deleteUser(String UserId);
}

