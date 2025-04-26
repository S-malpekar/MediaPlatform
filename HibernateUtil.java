package com.media.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.media.entity.*;


public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {
			return new
					Configuration().configure("Hibernate.cfg.xml")
					.addAnnotatedClass(User.class)
					.addAnnotatedClass(Posts.class)
					.addAnnotatedClass(Sign_up.class)
					.addAnnotatedClass(Login.class)
					.addAnnotatedClass(Friends.class)
					.addAnnotatedClass(SocialGrps.class)
					.addAnnotatedClass(Messages.class)
					.buildSessionFactory();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getSession() {
	    return getSessionFactory().openSession(); // Open a session from the sessionFactory
	}

}
