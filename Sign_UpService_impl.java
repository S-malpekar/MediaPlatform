package com.media.service_impl;

import com.media.dao.Sign_upDao;
import com.media.dao_impl.Sign_upDao_impl;
import com.media.entity.Sign_up;
import com.media.service.SignUpService;

public class Sign_UpService_impl implements SignUpService {
    Sign_upDao signUpDao = new Sign_upDao_impl();

    @Override
    public Sign_up createUser(Sign_up user) {
        return signUpDao.createUser(user);
    }

    @Override
    public boolean checkUsernameExists(String username) {
        return signUpDao.checkUsernameExists(username);
    }

    @Override
    public boolean checkEmailExists(String email) {
        return signUpDao.checkEmailExists(email);
    }
    
    @Override
    public boolean checkUsernameAvailability(String username) {
        return checkUsernameExists(username);
    }

    @Override
    public boolean checkEmailAvailability(String email) {
        return checkEmailExists(email);
    }

}
