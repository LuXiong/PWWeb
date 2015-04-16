package com.pwweb.common;

import javax.persistence.Entity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

@Entity
public class DataBaseUtils {
	public static SessionFactory getSessionFactory() {
		SessionFactory factory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		return factory;
	}
}
