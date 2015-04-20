package com.pwweb.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pwweb.common.Constant;
import com.pwweb.dao.BaseDAO;
import com.pwweb.model.User;

@Entity
public class PassService {

	@SuppressWarnings("unchecked")
	public String login(String name, String password) {
		BaseDAO userdao = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.eq("name", name));
		res.add(Restrictions.eq("password", password));
		List<User> users = (List<User>)userdao.findObjectByCriteria(User.class, res);
		if (users.size() == 1) {
			return name + "." + password;
		}
		return Constant.SUCCESS;

	}
}
