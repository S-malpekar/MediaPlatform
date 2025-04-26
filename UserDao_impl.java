package com.media.dao_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;

import com.media.HibernateUtil.HibernateUtil;
import com.media.dao.UserDao;
import com.media.entity.User;



public class UserDao_impl implements UserDao {

	Scanner sc = new Scanner(System.in);
	@Override

	public User createUser(User user1) {

		try(Session session=HibernateUtil.getSession()) {

			session.beginTransaction();
			session.save(user1);
			session.getTransaction().commit();
			return user1;

		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override

	public List<User> getAllUsers() { // Removed unnecessary parameter
	    List<User> userList = new ArrayList<>();
	    
	    try (Session session = HibernateUtil.getSession()) {
	        // Execute HQL query to retrieve all user data
	        Query<User> query = session.createQuery("FROM User", User.class);
	        userList = query.list();
	    } 
	    catch (HibernateException e) {
	        System.out.println("HibernateException: " + e.getMessage());
	    } 
	    catch (Exception e) {
	        System.out.println("Exception: " + e.getMessage());
	    }
	    
	    return userList; // Return user list, even if empty
	}

	@Override
	public User getUser(String UserId) {

		try(Session session=HibernateUtil.getSession()) {

			User user1=session.get(User.class, UserId);
			return user1;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override
	public User updateUser(String UserId,User updatedUser) {
		try(Session session=HibernateUtil.getSession()) {
			User user1=session.get(User.class, UserId);
			session.beginTransaction();

			user1.setEmail(updatedUser.getEmail());
			user1.setPassword(updatedUser.getPassword());
			user1.setAge(updatedUser.getAge());
			user1.setLocation(updatedUser.getLocation());
			user1.setPost_count(updatedUser.getPost_count());
			session.saveOrUpdate(user1);
			session.getTransaction().commit();
			return user1;

		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return updatedUser;
	}


	@Override
	public String deleteUser(String UserId) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			User user1=session.get(User.class, UserId);
			session.beginTransaction();
			System.out.println("Are you sure  you want to delete?");
			String status=sc.next();
			if(status.equalsIgnoreCase("yes"))
			{
				session.delete(user1);//data will be deleted from DB
				session.getTransaction().commit();
				session.evict(user1);
				message="Object is deleted";

			}else
			{
				message="User wants to retain this object!!";
			}

		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return message;
	}
}
