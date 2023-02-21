package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration conf = new Configuration();
			conf.configure("com/hibernate/resource/hibernate.cfg.xml");
			sessionFactory = conf.buildSessionFactory();
			System.out.println(sessionFactory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
