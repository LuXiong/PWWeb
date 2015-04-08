package com.pwweb.common;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DataBaseUtils {
	public static SessionFactory getSessionFactory() {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		return factory;
	}
}
