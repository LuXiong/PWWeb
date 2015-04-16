package com.pwweb.service;

import java.util.List;

import javax.persistence.Entity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pwweb.common.Constant;
import com.pwweb.common.DataBaseUtils;
import com.pwweb.model.User;

@Entity
public class PassService {

	@SuppressWarnings("unchecked")
	public String login(String name, String password) {
		Session session = DataBaseUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria c = session.createCriteria(User.class);
		c.add(Restrictions.eq("name", name));
		c.add(Restrictions.eq("password", password));
		List<User> users = c.list();
		session.close();
		if (users.size() == 1) {
			return name + "." + password;
		}

		return Constant.FAILURE;

	}
}
