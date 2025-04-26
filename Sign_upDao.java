package com.media.dao;

import com.media.entity.Sign_up;
import com.media.entity.User;

public interface Sign_upDao {
	User registerUser(Sign_up sign_up);
	boolean checkUsernameAvailability(String username);
	boolean checkEmailAvailability(String email);
	Sign_up createUser(Sign_up user);
	boolean checkUsernameExists(String username);
	boolean checkEmailExists(String email);
}
