package com.media.dao_impl;


import org.hibernate.Session;
import org.hibernate.Transaction;
import com.media.dao.Sign_upDao;
import com.media.entity.Sign_up;
import com.media.entity.User;
import com.media.HibernateUtil.HibernateUtil;

public class Sign_upDao_impl implements Sign_upDao {

    @Override
    public Sign_up createUser(Sign_up user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkUsernameExists(String username) {
        try (Session session = HibernateUtil.getSession()) {
            Long count = session.createQuery(
                    "SELECT COUNT(s) FROM user u WHERE u.Username = :Username", Long.class)
                    .setParameter("username", username)
                    .uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkEmailExists(String email) {
        try (Session session = HibernateUtil.getSession()) {
            Long count = session.createQuery(
                    "SELECT COUNT(s) FROM user u WHERE u.Email = :Email", Long.class)
                    .setParameter("email", email)
                    .uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public User registerUser(Sign_up sign_up) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUsernameAvailability(String username) {
	    return !checkUsernameExists(username);
	}

	@Override
	public boolean checkEmailAvailability(String email) {
	    return !checkEmailExists(email);
	}

}
