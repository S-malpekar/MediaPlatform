package com.media.service_impl;

import org.hibernate.Session;

import com.media.HibernateUtil.HibernateUtil;
import com.media.dao.LoginDao;
import com.media.dao_impl.LoginDao_impl;
import com.media.entity.Login;
import com.media.entity.User;
import com.media.service.LoginService;

public class LoginService_Impl implements LoginService {
    LoginDao loginDao = new LoginDao_impl();

    @Override
    public boolean login(String username, String password) {
        User user = loginDao.getUserByUsername(username); // Assuming Sign_up entity stores users

        if (user != null && user.getPassword().equals(password)) {
            return true; // Successful login
        }
        return false; // Incorrect username or password
    }
    

    public boolean validateLogin(Login validateLogin) {
        try (Session session = HibernateUtil.getSession()) {
            String username = validateLogin.getUsername();
            String password = validateLogin.getPassword();

            User user = session.createQuery(
                    "FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();

            return user != null; // If user exists, login is valid
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
