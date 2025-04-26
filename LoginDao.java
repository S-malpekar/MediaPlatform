package com.media.dao;

import com.media.entity.Login;
import com.media.entity.User;

public interface LoginDao {
	boolean authenticateUser(String username, String password);
	Login logLoginAttempt(Login login);
	User getUserByUsername(String username);
}
