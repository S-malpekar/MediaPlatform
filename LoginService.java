package com.media.service;

import com.media.entity.Login;

public interface LoginService {

	 boolean login(String username, String password);

	static boolean validateLogin(Login validateLogin) {
		// TODO Auto-generated method stub
		return false;
	}
}
