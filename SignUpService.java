package com.media.service;

import com.media.entity.Sign_up;

public interface SignUpService {
	 Sign_up createUser(Sign_up signUp) ;
	 boolean checkUsernameExists(String username);
	 boolean checkEmailExists(String email) ;
	boolean checkUsernameAvailability(String username);
	boolean checkEmailAvailability(String email);
		

}