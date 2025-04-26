package com.media.dao_impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.media.dao.LoginDao;
import com.media.entity.Login;
import com.media.entity.User;
import com.media.HibernateUtil.HibernateUtil;

public class LoginDao_impl implements LoginDao {

    @Override
    public boolean authenticateUser(String username, String password) {
        try (Session session = HibernateUtil.getSession()) {
            Long count = session.createQuery(
                    "SELECT COUNT(l) FROM Login l WHERE l.username = :username AND l.password = :password", Long.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Login logLoginAttempt(Login login) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(login);
            transaction.commit();
            return login;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery(
                    "FROM User u WHERE u.Username = :Username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}