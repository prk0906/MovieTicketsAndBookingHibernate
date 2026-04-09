package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entites.Bookings;
import com.entites.Movies;

public class HibernateUtil {
	public static SessionFactory sessionFactory = null;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure();
			cfg.addAnnotatedClass(Movies.class);
			cfg.addAnnotatedClass(Bookings.class);
			sessionFactory = cfg.buildSessionFactory();
			return sessionFactory;
		}else {
			return sessionFactory;
		}
	}
}
