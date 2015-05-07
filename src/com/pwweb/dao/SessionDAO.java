package com.pwweb.dao;

import javax.persistence.Entity;
import org.hibernate.Session;


@Entity
public class SessionDAO {
	
	public static Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
	public static void closeSession(){
		HibernateSessionFactory.closeSession();
	}
	
}