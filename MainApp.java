package com.media.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.media.HibernateUtil.HibernateUtil;


public class MainApp {
	public static void main(String[] args) {

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.close();
		factory.close();
	}
}
