package com.media.service;

import java.util.List;
import com.media.entity.User;

public interface UserService {
	User createUser(User user1);	
	List<User> getAllUsers();
	User getUser(String UserId);
	User updateUser(String UserId,User updatedUser);
	String deleteUser(String UserId);
}
